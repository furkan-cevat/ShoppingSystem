package com.deneme.controller;

import com.deneme.config.Tokens;
import com.deneme.model.Order;
import com.deneme.service.OrderService;
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

    @RequestMapping(value = "/getOrder", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    void newCategory(@CookieValue(value = "token") Long token, @RequestBody Order order) {

        long userId = (long) tokens.getTokensMap().get(token);

        long cartId = shoppingService.getCartByUserId(userId);


        orderService.getOrder(order);

        orderService.updateOrderAfter(userId,cartId);

        logger.info("Order getting. userId : " + userId);
    }



}
