package com.deneme.service.impl;

import com.deneme.dao.ShoppingDAO;
import com.deneme.dao.UserDAO;
import com.deneme.model.Product;
import com.deneme.model.ShoppingCart;
import com.deneme.model.User;
import com.deneme.service.ShoppingService;
import com.deneme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ShoppingServiceImpl implements ShoppingService {

    @Autowired
    private ShoppingDAO shoppingDAO;


    @Override
    public long newChart(ShoppingCart cart) {
        return shoppingDAO.newChart(cart);
    }

    @Override
    public void addShoppingChart(long cartId,long productId) {
        shoppingDAO.addShoppingChart(cartId,productId);
    }

    @Override
    public long getCartByUserId(long userId) {
        return shoppingDAO.getCartByUserId(userId);
    }
}
