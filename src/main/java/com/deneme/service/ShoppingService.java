package com.deneme.service;

import com.deneme.model.ShoppingCart;



public interface ShoppingService {

    long newChart(ShoppingCart cart);

    long getCartIdByUserId(long userId);

    ShoppingCart getCartByUserId(long userId);





}