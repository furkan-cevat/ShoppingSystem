package com.deneme.repository;

import com.deneme.model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {

    //@Query(value = "UPDATE orders SET user_userId =:id , shoppingCart_cartId = :id2 WHERE shoppingCart_cartId IS NULL AND user_userId IS NULL",nativeQuery = true)
    //void updateOrderAfter(@Param("id") long userId , @Param("id2") long cartId);

    @Modifying
    @Query(value = "UPDATE orders SET address =:adr WHERE shoppingCart_cartId = :cId AND user_userId = :uId",nativeQuery = true)
    void changeOrderAddress(@Param("adr") String address , @Param("uId") long userId , @Param("cId") long cartId);

    @Modifying
    @Query(value = "DELETE FROM orders WHERE user_userId = :uId",nativeQuery = true)
    void cancelledOrder(@Param("uId") long userId);

    @Query(value = "SELECT o.status FROM User u inner join orders o ON u.userId = o.user_userId where o.user_userId = :uId",nativeQuery = true)
    String orderTracking(@Param("uId") long userId);

    @Query(value = "SELECT p.* FROM orders o INNER JOIN ProductsInCart pc ON o.shoppingCart_cartId = pc.shoppingCart_cartId INNER JOIN Product p ON pc.productId = p.productId WHERE o.user_userId = :uId AND o.shoppingCart_cartId = :scId",nativeQuery = true)
    List<Object[]> getProductsInOrder(@Param("uId") long userId , @Param("scId") long cartId);

    @Query(value = "SELECT o.* FROM User u inner join orders o ON u.userId = o.user_userId where o.user_userId = :uId",nativeQuery = true)
    List<Order> getLoginOrders(@Param("uId") long userId);
}