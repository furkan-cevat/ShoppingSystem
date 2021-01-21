package com.deneme.service;

;

import com.deneme.model.User;

import java.util.List;


public interface UserService {

    public long createUser(User user);

    public void deleteUser(long userId);

    public User updateUser(User user);

    public boolean findLoginUser(String username,String password);

    public List<User> listAllUser();






}