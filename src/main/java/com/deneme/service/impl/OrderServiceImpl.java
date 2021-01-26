package com.deneme.service.impl;

<<<<<<< HEAD
import com.deneme.model.Order;
import com.deneme.model.Product;
import com.deneme.model.ShoppingCart;
import com.deneme.model.User;
import com.deneme.repository.OrderRepo;
import com.deneme.service.OrderService;
=======
import com.deneme.dao.OrderDAO;
import com.deneme.dao.ProductDAO;
import com.deneme.model.*;
import com.deneme.repository.OrderRepo;
import com.deneme.service.OrderService;
import com.deneme.service.ProductService;
import com.deneme.service.ShoppingService;
import com.deneme.service.UserService;
>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
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
<<<<<<< HEAD
    public long getOrder(Order order, User user, ShoppingCart shoppingCart) {
=======
    public long getOrder(Order order,User user,ShoppingCart shoppingCart) {
>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
        Order orderTemp = new Order();
        orderTemp.setAddress(order.getAddress());
        orderTemp.setPaymentMethod(order.getPaymentMethod());
        orderTemp.setStatus(order.getStatus());
        orderTemp.setUser(user);
        orderTemp.setShoppingCart(shoppingCart);
        orderRepo.saveAndFlush(orderTemp);
        return orderTemp.getOrderId();
    }

<<<<<<< HEAD
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
=======
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
>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
    }
    @Override
<<<<<<< HEAD
=======
    public String orderTracking(long userId) {
        return orderRepo.orderTracking(userId);
    }
    @Override
>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
    public List<Product> getProductsInOrder(long userId, long cartId) {
        List<Product> products = new ArrayList<Product>();
        List<Object[]> list = orderRepo.getProductsInOrder(userId,cartId);
        for (Object[] product : list) {
            Product product2 = new Product();
<<<<<<< HEAD

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

    @Override
    public List<User> customQuery1(long productId) {
        List<User> users = new ArrayList<User>();
        List<Object[]> list = orderRepo.customQuery1(productId);
        for (Object[] user : list) {
            User user1 = new User();

            String stringId = String.valueOf(user[0]);
            Long userIdLong = Long.parseLong(stringId);


            long uId = userIdLong;
            String name = (String) user[2];

            user1.setUserId(uId);
            user1.setUsername(name);

            users.add(user1);

            if(users.isEmpty()) {
                return null;
            }
        }

        return users;
=======

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
>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
    }

}