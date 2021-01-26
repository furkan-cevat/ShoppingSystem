package com.deneme.service;

<<<<<<< HEAD
=======
import com.deneme.model.Category;
import com.deneme.model.Order;
>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
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

<<<<<<< HEAD
    long addUser(User user);
    void deleteByIdUser(long userId);
    User updateUser(User user);
    List<User> listAllUser();
    User getUserById(long userId);
    boolean findLoginUser(String username, String password);
    long getLoginUserId(String username, String password);
=======
>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f

}