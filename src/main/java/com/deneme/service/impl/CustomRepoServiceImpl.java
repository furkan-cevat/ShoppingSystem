package com.deneme.service.impl;

import com.deneme.model.User;
import com.deneme.repository.CustomRepo;
import com.deneme.service.CustomRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomRepoServiceImpl implements CustomRepoService {

    @Autowired
    private CustomRepo customRepo;

    @Override
    public List<User> customQuery1(long productId) {
        List<User> users = new ArrayList<User>();
        List<Object[]> list = customRepo.customQuery1(productId);
        for (Object[] user : list) {
            User user1 = new User();

            String stringId = String.valueOf(user[0]);
            Long userIdLong = Long.parseLong(stringId);


            long uId = userIdLong;
            String name = (String) user[2];

            user1.setUserId(uId);
            user1.setUsername(name);

            users.add(user1);

            if(users.isEmpty()) {
                return null;
            }
        }

        return users;
    }
}
