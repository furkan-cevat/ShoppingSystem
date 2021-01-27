package com.deneme.service.impl;

import com.deneme.model.Order;
import com.deneme.model.Product;
import com.deneme.model.ShoppingCart;
import com.deneme.model.User;
import com.deneme.repository.OrderRepo;
import com.deneme.service.OrderService;
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
    public long getOrder(Order order, User user, ShoppingCart shoppingCart) {
        Order orderTemp = new Order();
        orderTemp.setAddress(order.getAddress());
        orderTemp.setPaymentMethod(order.getPaymentMethod());
        orderTemp.setStatus(order.getStatus());
        orderTemp.setUser(user);
        orderTemp.setShoppingCart(shoppingCart);
        orderRepo.saveAndFlush(orderTemp);
        return orderTemp.getOrderId();
    }

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
        List<Product> products = new ArrayList<>();
        List<Object[]> list = orderRepo.getProductsInOrder(userId,cartId);
        for (Object[] product : list) {
            Product product2 = new Product();

            String stringId = String.valueOf(product[0]);
            long longId = Long.parseLong(stringId);

            String stringStock = String.valueOf(product[2]);
            int longStock = Integer.parseInt(stringStock);

            String name = (String) product[1];

            product2.setProductId(longId);
            product2.setName(name);
            product2.setStock(longStock);

            products.add(product2);
        }

        return products;
    }

    @Override
    public List<Order> getLoginOrders(long userId) {
        return orderRepo.getLoginOrders(userId);
    }

    @Override
    public List<User> customQuery1(long productId) {
        List<User> users = new ArrayList<>();
        List<Object[]> list = orderRepo.customQuery1(productId);
        for (Object[] user : list) {
            User user1 = new User();

            String stringId = String.valueOf(user[0]);


            long uId = Long.parseLong(stringId);
            String name = (String) user[2];

            user1.setUserId(uId);
            user1.setUsername(name);

            users.add(user1);

            if(users.isEmpty()) {
                return null;
            }
        }

        return users;
    }

}