package com.deneme.service;

import com.deneme.model.ShoppingCart;



public interface ShoppingService {

    long newChart(ShoppingCart cart);

    String addShoppingChart(ShoppingCart cartId, long productId, long orderAmount);

    long getCartIdByUserId(long userId);

    ShoppingCart getCartByUserId(long userId);





}