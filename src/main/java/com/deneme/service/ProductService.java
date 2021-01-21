package com.deneme.service;

import com.deneme.model.Category;
import com.deneme.model.Product;
import com.deneme.model.User;

;import java.util.List;


public interface ProductService {

     long createProduct(Product product);

     void deleteProduct(long productId);

     Product updateProduct(Product product);

     List<Product> listAllProduct();

     void addShoppingChart(Product product);

    void updateProductCartId(long cartId);

     Product getProductById(long productId);






}