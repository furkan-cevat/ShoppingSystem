package com.deneme.controller;

import com.deneme.dao.UserDAO;
import com.deneme.model.ShoppingCart;
import com.deneme.model.User;
import com.deneme.service.ShoppingService;
import com.deneme.service.UserService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/shoppingApi")
@Controller
public class ShoppingCartController {

    @Autowired
    private ShoppingService shoppingService;

    @Autowired
    private UserDAO userDAO;

    private static final Logger logger = Logger.getLogger(ShoppingCartController.class);

    @RequestMapping(value = "/newChart", method = RequestMethod.GET)
    public @ResponseBody
    long newUser() {

        ShoppingCart sc = new ShoppingCart();
        sc.setUser(userDAO.getUserById((Long) SecurityController.loginKullaniciID));
        long id = shoppingService.newChart(sc);
        logger.info("Shopping Cart adding. id : " + id);
        return id;
    }

}
