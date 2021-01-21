package com.deneme.controller;

import com.deneme.dao.UserDAO;
import com.deneme.model.User;
import com.deneme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class SecurityController {

    @Autowired
    private UserDAO userDAO;

    static Object loginKullaniciID;

    @RequestMapping(value = "/login/{username}/{password}", method = RequestMethod.GET)
    @ResponseBody
    public void login(@PathVariable(value = "username") String username ,
                                @PathVariable(value = "password") String password) {
        boolean b = userDAO.findLoginUser(username,password);
        if(b==true){
            List<User> loginKullaniciId = userDAO.getLoginUserId(username,password);
            System.out.println("Login oldunuz." + loginKullaniciId.get(0) + " id'li kullanici");
            loginKullaniciID = loginKullaniciId.get(0);
        }
        else
            System.out.println("Login işlemi başarısız.");



    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public void logout() {
        loginKullaniciID=null;
    }

}
