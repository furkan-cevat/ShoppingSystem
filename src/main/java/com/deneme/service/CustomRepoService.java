package com.deneme.service;

import com.deneme.model.Order;
import com.deneme.model.User;

import java.util.List;




public interface CustomRepoService {

    List<User> customQuery1(long productId);
}