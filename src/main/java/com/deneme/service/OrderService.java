package com.deneme.service;

import com.deneme.model.Category;
import com.deneme.model.Order;

;import java.util.List;


public interface OrderService {

    public long createOrder(Order order);

    public void deleteOrder(long orderId);

    public Order updateOrder(Order order);

    public List<Order> listAllOrder();

    void getOrder(Order order);

    void updateOrderAfter(long userId,long cartId);

    void changeOrderAddress(long userId,long cartId,String address);

    void cancelledOrder(long userId);






}