package com.deneme.service.impl;

import com.deneme.dao.ProductDAO;
import com.deneme.dao.ShoppingDAO;
import com.deneme.model.Product;
import com.deneme.model.ShoppingCart;
import com.deneme.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShoppingServiceImpl implements ShoppingService {

    @Autowired
    private ShoppingDAO shoppingDAO;

    @Autowired
    private ProductDAO productDAO;


    @Override
    public long newChart(ShoppingCart cart) {
        return shoppingDAO.newChart(cart);
    }

    @Override
    public String addShoppingChart(ShoppingCart cart, long productId, long orderAmount) {
        Product p = productDAO.getProductById(productId);

        if(p.getStock()<orderAmount) {
            return "Stoktaki ürün sayısı yetersiz. ürün sayısı : " + p.getStock();
        }

        return shoppingDAO.addShoppingChart(cart,productId,orderAmount);
    }

    @Override
    public ShoppingCart getCartByUserId(long userId) {
        return shoppingDAO.getCartByUserId(userId);
    }

    @Override
    public long getCartIdByUserId(long userId) {
        return shoppingDAO.getCartIdByUserId(userId);
    }
}