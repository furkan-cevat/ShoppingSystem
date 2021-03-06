package com.deneme.service.impl;

import com.deneme.model.ShoppingCart;
import com.deneme.repository.ShoppingRepo;
import com.deneme.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShoppingServiceImpl implements ShoppingService {

    @Autowired
    private ShoppingRepo shoppingRepo;

    @Override
    public long newChart(ShoppingCart cart) {
        shoppingRepo.save(cart);
        return cart.getCartId();
    }

    @Override
    public ShoppingCart getCartByUserId(long userId) {
        return shoppingRepo.findById(userId).orElse(null);
    }

    @Override
    public long getCartIdByUserId(long userId) {
        return shoppingRepo.getCartIdByUserId(userId);
    }
}