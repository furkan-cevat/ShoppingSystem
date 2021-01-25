package com.deneme.repository;

import com.deneme.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomRepo extends JpaRepository<User,Long>{

        @Query(value = "SELECT u.* FROM User u "
            + "INNER JOIN orders o ON o.user_userId = u.userId "
            + "INNER JOIN ProductsInCart pc ON o.shoppingCart_cartId = pc.shoppingCart_cartId "
            + "WHERE pc.productId = :pId",nativeQuery = true)
    List<Object[]> customQuery1(@Param("pId") long productId);




}
