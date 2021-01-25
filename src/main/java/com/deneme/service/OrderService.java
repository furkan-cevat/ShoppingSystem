package com.deneme.service;

import com.deneme.model.*;

import java.util.List;


public interface OrderService {
    long getOrder(Order order, User user, ShoppingCart cart);
    void changeOrderAddress(long userId,long cartId,String address);
    void cancelledOrder(long userId);
    String orderTracking(long userId);
    List<Product> getProductsInOrder(long userId, long cartId);
    List<Order> getLoginOrders(long userId);
}