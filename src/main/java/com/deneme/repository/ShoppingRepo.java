package com.deneme.repository;

import com.deneme.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingRepo extends JpaRepository<ShoppingCart, Long> {

    @Query(value = "SELECT sc.cartId FROM ShoppingCart sc WHERE user_userId = :id")
    long getCartIdByUserId(@Param("id") long userId);

}