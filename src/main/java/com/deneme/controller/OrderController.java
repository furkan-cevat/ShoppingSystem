package com.deneme.controller;

import com.deneme.config.Tokens;
import com.deneme.model.Order;
import com.deneme.model.Product;
import com.deneme.model.ShoppingCart;
import com.deneme.model.User;
import com.deneme.service.*;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/orderApi")
@Controller
public class OrderController {

    private static final Logger logger = Logger.getLogger(OrderController.class);

    @Autowired
    private Tokens tokens;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ShoppingService shoppingService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductInCartService productInCartService;

    @Autowired
    private UserService userService;
<<<<<<< HEAD
=======



    @RequestMapping(value = "/createOrder", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    void createOrder(@CookieValue(value = "token") Long token, @RequestBody Order order) {

        long userId = (long) tokens.getTokensMap().get(token);

        long cartId = shoppingService.getCartIdByUserId(userId);

        //orderService.getOrder(order);

        //orderService.updateOrderAfter(userId,cartId);

        logger.info("Order getting. userId : " + userId);
    }
>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f

    @RequestMapping(value = "/getOrder", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    List<Product> getOrder(@CookieValue(value = "token") Long token, @RequestBody Order order) {
<<<<<<< HEAD
        long userId = (long) tokens.getTokensMap().get(token);
        long cartId = shoppingService.getCartIdByUserId(userId);
        order.setStatus("Sipariş Alındı.");
        User user = userService.getUserById(userId);
        ShoppingCart shoppingCart = shoppingService.getCartByUserId(cartId);
        orderService.getOrder(order,user,shoppingCart);
        List<Product> listProduct = orderService.getProductsInOrder(userId,cartId);
        for (Product product : listProduct) {
            productService.setStockValue(product.getProductId(),cartId);
        }
        logger.info("Order getting. userId : " + userId);
=======

        long userId = (long) tokens.getTokensMap().get(token);

        long cartId = shoppingService.getCartIdByUserId(userId);

        order.setStatus("Sipariş Alındı.");

        User user = userService.getUserById(userId);

        ShoppingCart shoppingCart = shoppingService.getCartByUserId(cartId);


        long orderId = orderService.getOrder(order,user,shoppingCart);

        List<Product> listProduct = orderService.getProductsInOrder(userId,cartId);

        for (Product product : listProduct) {
            productService.setStockValue(product.getProductId(),cartId);
        }



        logger.info("Order getting. userId : " + userId);

>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
        return listProduct;
    }





    @RequestMapping(value = "/changeOrderAddress/{address}", method = RequestMethod.GET)
    public @ResponseBody
    void changeOrderAddress(@CookieValue(value = "token") Long token ,@PathVariable(value = "address") String address) {
        long userId = (long) tokens.getTokensMap().get(token);
<<<<<<< HEAD
        long cartId = shoppingService.getCartIdByUserId(userId);
=======

        long cartId = shoppingService.getCartIdByUserId(userId);


>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
        orderService.changeOrderAddress(userId,cartId,address);
        logger.info("Address changing. userId : " + userId +  " address : " + address);
    }

    @RequestMapping(value = "/cancelledOrder", method = RequestMethod.GET)
    public @ResponseBody
    void cancelledOrder(@CookieValue(value = "token") Long token) {
        long userId = (long) tokens.getTokensMap().get(token);
<<<<<<< HEAD
        long cartId = shoppingService.getCartIdByUserId(userId);
        List<Product> listProduct = orderService.getProductsInOrder(userId,cartId);
        for (Product product : listProduct) {
            productService.setStockValueCancelled(product.getProductId(),cartId);
        }
        orderService.cancelledOrder(userId);
        productInCartService.clearProductInCart(cartId);
=======

        long cartId = shoppingService.getCartIdByUserId(userId);

        List<Product> listProduct = orderService.getProductsInOrder(userId,cartId);

        for (Product product : listProduct) {
            productService.setStockValueCancelled(product.getProductId(),cartId);
        }


        orderService.cancelledOrder(userId);

        productInCartService.clearProductInCart(cartId);

>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
        logger.info("Order cancelling. userId : " + userId);
    }

    @RequestMapping(value = "/orderTracking", method = RequestMethod.GET)
    public @ResponseBody
    String orderTracking(@CookieValue(value = "token") Long token) {
        long userId = (long) tokens.getTokensMap().get(token);
        logger.info("Order tracking. userId : " + userId);
        return orderService.orderTracking(userId);
    }

<<<<<<< HEAD
    @RequestMapping(value = "/allCustomersOrderedSpecificProduct/{productId}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<User> customQuery1(@PathVariable("productId") long productId) {
        logger.info("productId : " + productId);
        return orderService.customQuery1(productId);
    }
=======








>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
}