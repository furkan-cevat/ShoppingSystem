package com.deneme.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

<<<<<<< HEAD
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
=======
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f

@Entity
public class ProductsInCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productsInCartId;


    @ManyToOne
    @JsonIgnore
    private ShoppingCart shoppingCart;


<<<<<<< HEAD
=======


>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
    private long productId;

    private long orderAmount;


    public long getProductsInCartId() {
        return productsInCartId;
    }

    public void setProductsInCartId(long productsInCartId) {
        this.productsInCartId = productsInCartId;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(long orderAmount) {
        this.orderAmount = orderAmount;
    }
}
