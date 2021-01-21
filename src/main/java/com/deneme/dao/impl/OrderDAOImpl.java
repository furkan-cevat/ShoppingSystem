package com.deneme.dao.impl;

import com.deneme.dao.OrderDAO;
import com.deneme.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    Transaction transaction = null;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long createOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        return (long) session.save(order);
    }

    @Override
    public void deleteOrder(long orderId) {
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            String hql = "delete Order where orderId = :id";
            Query q = session.createQuery(hql).setParameter("id", orderId);
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
    public Order updateOrder(Order order) {
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(order);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return order;
    }

    public List<Order> listAllOrder() {
        List<Order> list = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            String hql = "FROM Order";
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
    public void getOrder(Order order) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Order orderTemp = new Order();
        orderTemp.setAddress(order.getAddress());
        orderTemp.setPaymentMethod(order.getPaymentMethod());
        orderTemp.setStatus("1");

        session.save(orderTemp);
        session.getTransaction().commit();


//        List<Order> list = null;
//        Session session = sessionFactory.openSession();
//        try {
//            transaction = session.beginTransaction();
//            String sql = "INSERT INTO orders " +
//                    "(address', " +
//                    "'paymentMethod' ," +
//                    "'status', " +
//                    "'shoppingCart_cartId'," +
//                    "'user_userId') " +
//                    "VALUES " +
//                    "(:param1,:param2,:param3,:param4,:param5);";
//            session.createSQLQuery(sql).setParameter("param1",order.getAddress()).setParameter("param2",order.getPaymentMethod()).setParameter("param3","0").setParameter("param4",cartId).setParameter("param5",userId).executeUpdate();
//            transaction.commit();
//
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        } finally {
//            session.close();
//        }

    }

    @Override
    public void updateOrderAfter(long userId, long cartId) {
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            String hql = "UPDATE orders SET user_userId =:id , shoppingCart_cartId = :id2 WHERE shoppingCart_cartId IS NULL AND user_userId IS NULL";
            Query q = session.createSQLQuery(hql).setParameter("id", userId).setParameter("id2",cartId);
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
    public void changeOrderAddress(long userId, long cartId, String address) {
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            String hql = "UPDATE orders SET address =:adr WHERE shoppingCart_cartId = :cId AND user_userId = :uId";
            Query q = session.createSQLQuery(hql).setParameter("adr",address).setParameter("cId", cartId).setParameter("uId",userId);
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
    public void cancelledOrder(long userId) {
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            String hql = "DELETE FROM orders WHERE user_userId = :uId";
            Query q = session.createSQLQuery(hql).setParameter("uId",userId);
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
