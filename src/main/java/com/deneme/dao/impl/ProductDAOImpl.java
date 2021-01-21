package com.deneme.dao.impl;

import com.deneme.dao.CategoryDAO;
import com.deneme.dao.ProductDAO;
import com.deneme.model.Category;
import com.deneme.model.Product;
import com.deneme.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    Transaction transaction = null;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long createProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        return (long) session.save(product);
    }

    @Override
    public void deleteProduct(long productId) {
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            String hql = "delete Product where productId = :id";
            Query q = session.createQuery(hql).setParameter("id", productId);
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

    @Override
    public Product updateProduct(Product product) {
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(product);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return product;
    }

    public List<Product> listAllProduct() {
        List<Product> list = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            String hql = "FROM Product";
            list = session.createQuery(hql).list();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return list;

    }

    @Override
    public void updateProductCartId(long cartId) {
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            String hql = "UPDATE Product SET shoppingCart_cartId=:id WHERE shoppingCart_cartId = :id2";
            Query q = session.createQuery(hql).setParameter("id", 0).setParameter("id2",cartId);
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


}
