package com.deneme.dao;

import com.deneme.model.Product;

import java.util.List;

public interface ProductDAO {
     long createProduct(Product product);

     void deleteProduct(long productId);

     Product updateProduct(Product product);

     List<Product> listAllProduct();

    void updateProductCartId(long cartId);


}
