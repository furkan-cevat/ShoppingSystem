package com.deneme.service.impl;

import com.deneme.dao.OrderDAO;
import com.deneme.dao.ProductDAO;
import com.deneme.model.*;
import com.deneme.repository.OrderRepo;
import com.deneme.service.OrderService;
import com.deneme.service.ProductService;
import com.deneme.service.ShoppingService;
import com.deneme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Override
    public long getOrder(Order order,User user,ShoppingCart shoppingCart) {
        Order orderTemp = new Order();
        orderTemp.setAddress(order.getAddress());
        orderTemp.setPaymentMethod(order.getPaymentMethod());
        orderTemp.setStatus(order.getStatus());
        orderTemp.setUser(user);
        orderTemp.setShoppingCart(shoppingCart);
        orderRepo.saveAndFlush(orderTemp);
        return orderTemp.getOrderId();
    }

   // @Override
   // public void updateOrderAfter(long userId, long cartId) {
        //orderRepo.updateOrderAfter(userId,cartId);
   // }

    @Override
    public void changeOrderAddress(long userId, long cartId, String address) {
        orderRepo.changeOrderAddress(address,userId,cartId);
    }

    @Override
    public void cancelledOrder(long userId) {
        orderRepo.cancelledOrder(userId);
    }

    @Override
    public String orderTracking(long userId) {
        return orderRepo.orderTracking(userId);
    }
    @Override
    public List<Product> getProductsInOrder(long userId, long cartId) {
        List<Product> products = new ArrayList<Product>();
        List<Object[]> list = orderRepo.getProductsInOrder(userId,cartId);
        for (Object[] product : list) {
            Product product2 = new Product();

            String stringId = String.valueOf(product[0]);
            Long longId = Long.parseLong(stringId);

            String stringStock = String.valueOf(product[2]);
            Integer longStock = Integer.parseInt(stringStock);

            long productId = longId;
            String name = (String) product[1];
            int stock = longStock;

            product2.setProductId(productId);
            product2.setName(name);
            product2.setStock(stock);

            products.add(product2);
        }

        return products;
    }

    @Override
    public List<Order> getLoginOrders(long userId) {
        return orderRepo.getLoginOrders(userId);
    }

}