package com.deneme.controller;

import com.deneme.model.User;
import com.deneme.service.CustomRepoService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/customJpaApi")
@Controller
public class CustomJPAController {
    private static final Logger logger = Logger.getLogger(CustomJPAController.class);

    @Autowired
    private CustomRepoService customRepoService;

    @RequestMapping(value = "/customRepoQuery1/{productId}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<User> customQuery1(@PathVariable("productId") long productId) {

        logger.info("productId : " + productId);

        return customRepoService.customQuery1(productId);

    }

    @RequestMapping(value = "/findByUserName/{username}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<User> findByUserName(@PathVariable("username") String username) {

        logger.info("username : " + username);

        return customRepoService.findByUsername(username);

    }


}
