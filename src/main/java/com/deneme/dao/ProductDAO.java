package com.deneme.dao;

import com.deneme.model.Product;
import com.deneme.model.User;

import java.util.List;

public interface ProductDAO {
    public long createProduct(Product product);

    public void deleteProduct(long productId);

    public Product updateProduct(Product product);

    public List<Product> listAllProduct();


}
