package com.deneme.repository;

import com.deneme.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<< HEAD
public interface ShoppingRepo extends JpaRepository<ShoppingCart, Long> {

    @Query(value = "SELECT sc.cartId FROM ShoppingCart sc where user_userId = :id")
    long getCartIdByUserId(@Param("id") long userId);
=======
public interface ShoppingRepo extends JpaRepository<ShoppingCart,Long> {


    @Query(value = "SELECT sc.cartId FROM ShoppingCart sc where user_userId = :id")
    long getCartIdByUserId(@Param("id") long userId );


>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f

}