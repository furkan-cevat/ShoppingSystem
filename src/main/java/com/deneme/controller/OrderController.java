package com.deneme.controller;

import com.deneme.config.Tokens;
import com.deneme.model.Order;
import com.deneme.service.OrderService;
import com.deneme.service.ProductService;
import com.deneme.service.ShoppingService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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


    @RequestMapping(value = "/getOrder", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    void newOrder(@CookieValue(value = "token") Long token, @RequestBody Order order) {

        long userId = (long) tokens.getTokensMap().get(token);

        long cartId = shoppingService.getCartByUserId(userId);

        order.setStatus("Sipariş Alındı.");

        orderService.getOrder(order);

        orderService.updateOrderAfter(userId,cartId);

        logger.info("Order getting. userId : " + userId);
    }

    @RequestMapping(value = "/changeOrderAddress/{address}", method = RequestMethod.GET)
    public @ResponseBody
    void changeOrderAddress(@CookieValue(value = "token") Long token ,@PathVariable(value = "address") String address) {

        long userId = (long) tokens.getTokensMap().get(token);

        long cartId = shoppingService.getCartByUserId(userId);


        orderService.changeOrderAddress(userId,cartId,address);



        logger.info("Address changing. userId : " + userId +  " address : " + address);
    }

    @RequestMapping(value = "/cancelledOrder", method = RequestMethod.GET)
    public @ResponseBody
    void cancelledOrder(@CookieValue(value = "token") Long token) {

        long userId = (long) tokens.getTokensMap().get(token);

        long cartId = shoppingService.getCartByUserId(userId);


        orderService.cancelledOrder(userId);

        productService.updateProductCartId(cartId);

        logger.info("Order cancelling. userId : " + userId);
    }

    @RequestMapping(value = "/orderTracking", method = RequestMethod.GET)
    public @ResponseBody
    String orderTracking(@CookieValue(value = "token") Long token) {

        long userId = (long) tokens.getTokensMap().get(token);


        String x = orderService.orderTracking(userId);

        logger.info("Order tracking. userId : " + userId + " order status : " + x);

        return x;


    }









}
