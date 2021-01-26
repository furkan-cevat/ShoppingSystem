package com.deneme.controller;

import com.deneme.config.Tokens;
<<<<<<< HEAD
import com.deneme.model.ShoppingCart;
=======
import com.deneme.dao.UserDAO;
import com.deneme.model.ProductsInCart;
import com.deneme.model.ShoppingCart;
import com.deneme.repository.UserRepo;
>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
import com.deneme.service.ProductInCartService;
import com.deneme.service.ShoppingService;
import com.deneme.service.UserService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/shoppingApi")
@Controller
public class ShoppingCartController {
    @Autowired
    private Tokens tokens;

    @Autowired
    private ShoppingService shoppingService;

    @Autowired
    private ProductInCartService productInCartService;

    @Autowired
    private UserService userService;

    private static final Logger logger = Logger.getLogger(ShoppingCartController.class);

    @RequestMapping(value = "/newChart", method = RequestMethod.GET)
    public @ResponseBody
    long newCart(@CookieValue(value = "token") Long token) {
        ShoppingCart sc = new ShoppingCart();
        long userId = (long) tokens.getTokensMap().get(token);
        sc.setUser(userService.getUserById(userId));
<<<<<<< HEAD
        logger.info("Shopping Cart adding.");
        return shoppingService.newChart(sc);
    }

    @RequestMapping(value = "/addShoppingCart/{productId}/{orderAmount}", method = RequestMethod.GET)
    public @ResponseBody
    long addShoppingCart(@CookieValue(value = "token") Long token, @PathVariable(value = "productId") long productId, @PathVariable(value = "orderAmount") long orderAmount) {
        long userId = (long) tokens.getTokensMap().get(token);
        long cartId = shoppingService.getCartIdByUserId(userId);
        ShoppingCart sc = shoppingService.getCartByUserId(cartId);
        String resultMessage = productInCartService.addShoppingChart(sc, productId, orderAmount);
        logger.info("Shopping Cart adding productId: " + productId + "result : " + resultMessage);
        return productId;
    }
=======
        long id = shoppingService.newChart(sc);
        logger.info("Shopping Cart adding. id : " + id);
        return id;
    }

    @RequestMapping(value = "/addShoppingCart/{productId}/{orderAmount}", method = RequestMethod.GET)
    public @ResponseBody long addShoppingCart(@CookieValue(value = "token") Long token,@PathVariable(value = "productId") long productId,@PathVariable(value = "orderAmount") long orderAmount) {
        ShoppingCart sc = new ShoppingCart();

        long userId = (long) tokens.getTokensMap().get(token);

        long cartId = shoppingService.getCartIdByUserId(userId);

        sc = shoppingService.getCartByUserId(cartId);


        String resultMessage = productInCartService.addShoppingChart(sc,productId,orderAmount);

        logger.info("Shopping Cart adding productId: " + productId + "result : " + resultMessage);
        return productId;
    }








>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
}