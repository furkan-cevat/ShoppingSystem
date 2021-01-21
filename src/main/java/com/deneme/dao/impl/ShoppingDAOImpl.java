package com.deneme.dao.impl;

import com.deneme.dao.ShoppingDAO;
import com.deneme.dao.UserDAO;
import com.deneme.model.ShoppingCart;
import com.deneme.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShoppingDAOImpl implements ShoppingDAO {
    Transaction transaction = null;

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public long newChart(ShoppingCart cart) {
        Session session = this.sessionFactory.openSession(); // Hepsi bu şekilde olmalı.
        session.beginTransaction();
        long cart1 = (long) session.save(cart);
        session.getTransaction().commit();
        return cart1;
    }
}
