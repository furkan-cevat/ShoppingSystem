package com.deneme.controller;

import com.deneme.config.Tokens;
import com.deneme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@Controller
public class SecurityController {

    @Autowired
    private UserService userService;

    @Autowired
    private Tokens tokens;

    @RequestMapping(value = "/login/{username}/{password}", method = RequestMethod.GET)
    @ResponseBody
    public void login(HttpServletResponse response, @PathVariable(value = "username") String username,
                      @PathVariable(value = "password") String password) {
        if (userService.findLoginUser(username, password)) {
            long loginKullaniciId = userService.getLoginUserId(username, password);
            Cookie cookie = new Cookie("token", String.valueOf(loginKullaniciId));
            cookie.setPath("/");
            response.addCookie(cookie);
            tokens.getTokensMap().put(loginKullaniciId, loginKullaniciId);
            System.out.println("Login oldunuz." + loginKullaniciId + " id'li kullanici");
        } else
            System.out.println("Login işlemi başarısız.");
    }

}
