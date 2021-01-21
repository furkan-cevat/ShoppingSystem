package com.deneme.dao;

import com.deneme.model.Order;

import java.util.List;

public interface OrderDAO {
    public long createOrder(Order orderId);

    public void deleteOrder(long orderId);

    public Order updateOrder(Order orderId);

    public List<Order> listAllOrder();

    void getOrder(Order order);

    public void updateOrderAfter(long userId, long cartId);

    public void changeOrderAddress(long userId, long cartId, String address);

    public void cancelledOrder(long userId);

}
