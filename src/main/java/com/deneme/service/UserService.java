package com.deneme.service;

import com.deneme.model.Category;
import com.deneme.model.Order;
import com.deneme.model.User;

import java.util.List;


public interface UserService {
    long addUser(User user);
    void deleteByIdUser(long userId);
    User updateUser(User user);
    List<User> listAllUser();
    User getUserById(long userId);
    boolean findLoginUser(String username, String password);
    long getLoginUserId(String username, String password);


}