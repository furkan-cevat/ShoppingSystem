package com.deneme.service.impl;

import com.deneme.dao.OrderDAO;
import com.deneme.dao.ProductDAO;
import com.deneme.model.Order;
import com.deneme.model.Product;
import com.deneme.service.OrderService;
import com.deneme.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;


    @Override
    public long createOrder(Order order) {
        return orderDAO.createOrder(order);
    }

    @Override
    public void deleteOrder(long orderId) {
        orderDAO.deleteOrder(orderId);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderDAO.updateOrder(order);
    }

    @Override
    public List<Order> listAllOrder() {
        return orderDAO.listAllOrder();
    }

    @Override
    public void getOrder(Order order) {
        orderDAO.getOrder(order);
    }

    @Override
    public void updateOrderAfter(long userId, long cartId) {
        orderDAO.updateOrderAfter(userId,cartId);
    }
}