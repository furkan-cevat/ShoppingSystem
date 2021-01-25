package com.deneme.repository;

import com.deneme.model.ProductsInCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInCartRepo extends JpaRepository<ProductsInCart,Long> {

     @Modifying
     @Query(value = "DELETE FROM ProductsInCart pc WHERE pc.shoppingCart_cartId = :scId",nativeQuery = true)
     void clearProductInCart(@Param("scId") long shoppingCartId);


}
