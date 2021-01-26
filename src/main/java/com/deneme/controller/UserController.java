package com.deneme.controller;

import com.deneme.config.Tokens;
import com.deneme.model.Order;
import com.deneme.model.User;
import com.deneme.service.OrderService;
import com.deneme.service.UserService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequestMapping("/userApi")
@Controller
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private Tokens tokens;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "newUser", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    long newUser(@RequestBody User user) {
        logger.info("User adding.");
        return userService.addUser(user);
    }

    @RequestMapping(value = "editUser/{userId}", method = RequestMethod.PUT, consumes = "application/json")
    public @ResponseBody
    User updateUser(@RequestBody User user) {
        User userTemp = new User();
        userTemp.setUserId(user.getUserId());
        userTemp.setUsername(user.getUsername());
        userTemp.setPassword(user.getPassword());
        logger.info("User updating. : " + userTemp);
        return userService.updateUser(userTemp);
    }

    @RequestMapping(value = "removeUser/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUser(@PathVariable(value = "userId") long id) {
        logger.info("User deleting. Id : " + id);
        userService.deleteByIdUser(id);
    }

    @RequestMapping(value ="/listAllUser", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<User> listAllUser() {
        logger.info("All users.");
        return userService.listAllUser();
    }

    @RequestMapping(value = "/getLoginUserOrders", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Order> getLoginOrders(@CookieValue(value = "token") Long token) {
        long userId = (long) tokens.getTokensMap().get(token);
        return orderService.getLoginOrders(userId);
    }

}




