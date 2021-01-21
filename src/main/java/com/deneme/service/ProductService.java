package com.deneme.service;

import com.deneme.model.Category;
import com.deneme.model.Product;
import com.deneme.model.User;

;import java.util.List;


public interface ProductService {

    public long createProduct(Product product);

    public void deleteProduct(long productId);

    public Product updateProduct(Product product);

    public List<Product> listAllProduct();

    public void addShoppingChart(Product product);






}