package com.deneme.service.impl;

import com.deneme.model.User;
import com.deneme.repository.UserRepo;
import com.deneme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public long addUser(User user) {
        User user1 = new User();
        user1.setUserId(user.getUserId());
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        userRepo.save(user1);
        return user1.getUserId();
    }

    @Override
    public void deleteByIdUser(long userId) {
        userRepo.deleteById(userId);

    }

    @Override
    public User updateUser(User user) {
        User user1 = getUserById(user.getUserId());
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        userRepo.save(user1);
        return user1;
    }

    @Override
    public List<User> listAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(long userId) {
        return userRepo.getUserById(userId).get(0);
    }
    @Override
    public boolean findLoginUser(String username, String password) {
        boolean b = false;
        long id = userRepo.findLoginUser(username,password);
        if(id!=0){
            b=true;
        }
        return b;
    }
    @Override
    public long getLoginUserId(String username, String password) {
        return userRepo.getLoginUserId(username,password);
    }






}
