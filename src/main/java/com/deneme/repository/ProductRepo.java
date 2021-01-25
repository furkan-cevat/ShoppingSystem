package com.deneme.repository;

import com.deneme.model.Category;
import com.deneme.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

    @Modifying
    @Query("UPDATE Product SET shoppingCart_cartId=:id WHERE shoppingCart_cartId = :id2")
    void updateProductCartId(@Param("id2") long cartId, @Param("id") long changedValue);

    @Modifying //Update sorgularında Can not issue data manipulation statements with executeQuery() hatası için.
    @Query(value = "UPDATE Product p SET p.stock=p.stock - (SELECT pc.orderAmount FROM ProductsInCart pc WHERE pc.productId = :pId AND pc.shoppingCart_cartId = :cId) WHERE p.productId = :pId",nativeQuery = true)
    void setStockValue(@Param("pId") long productId, @Param("cId") long cartId);

    @Modifying
    @Query(value = "UPDATE Product p SET p.stock=p.stock + (SELECT pc.orderAmount FROM ProductsInCart pc WHERE pc.productId = :pId AND pc.shoppingCart_cartId = :cId) WHERE p.productId = :pId",nativeQuery = true)
    void setStockValueCancelled(@Param("pId") long productId, @Param("cId") long cartId);



}