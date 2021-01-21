package com.deneme.dao.impl;

import com.deneme.dao.ShoppingDAO;
import com.deneme.dao.UserDAO;
import com.deneme.model.Product;
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
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        long cart1 = (long) session.save(cart);
        session.getTransaction().commit();
        return cart1;
    }

    public void addShoppingChart(long cartId,long productId){
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            String hql = "UPDATE Product SET shoppingCart_cartId=:id WHERE productId = :id2" +
                         "   ";
            Query q = session.createQuery(hql).setParameter("id", cartId).setParameter("id2",productId);
            q.executeUpdate();

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }

    }

    public long getCartByUserId(long userId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        long id = (long) session.createQuery(
                "SELECT sc.cartId FROM ShoppingCart sc where user_userId = :id ").setParameter("id",userId).getSingleResult();
        session.getTransaction().commit();
        return id;

    }

}
