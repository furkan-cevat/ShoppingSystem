package com.deneme.dao;

import com.deneme.model.Order;
import com.deneme.model.User;

import java.util.List;

public interface UserDAO {
    public long createUser(User user);

    public void deleteUser(long userId);

    public User updateUser(User user);

    public List<User> listAllUser();

    public User getUserById(long id);

    boolean findLoginUser(String username, String password);

    List<User> getLoginUserId(String username, String password);

    List<Order> getLoginOrders(long userId);
}
