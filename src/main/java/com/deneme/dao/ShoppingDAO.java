package com.deneme.dao;

import com.deneme.model.Product;
import com.deneme.model.ShoppingCart;
import com.deneme.model.User;

import java.util.List;

public interface ShoppingDAO {
    public long newChart(ShoppingCart cart);

    public void addShoppingChart(long cartId,long productId);

    public long getCartByUserId(long userId);

}
