package com.deneme.service;

import com.deneme.model.Product;
import com.deneme.model.ShoppingCart;
import com.deneme.model.User;

import java.util.List;

;


public interface ShoppingService {

    public long newChart(ShoppingCart cart);

    public void addShoppingChart(long cartId,long productId);

    public long getCartByUserId(long userId);






}