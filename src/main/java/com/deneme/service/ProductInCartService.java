package com.deneme.service;


import com.deneme.model.ShoppingCart;

public interface ProductInCartService {

    void clearProductInCart(long shoppingCartId);

    String addShoppingChart(ShoppingCart cartId, long productId, long orderAmount);

}