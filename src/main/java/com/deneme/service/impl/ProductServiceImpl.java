package com.deneme.service.impl;

import com.deneme.dao.CategoryDAO;
import com.deneme.dao.ProductDAO;
import com.deneme.model.Category;
import com.deneme.model.Product;
import com.deneme.model.User;
import com.deneme.service.CategoryService;
import com.deneme.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;


    @Override
    public long createProduct(Product product) {
        return productDAO.createProduct(product);
    }

    @Override
    public void deleteProduct(long productId) {
        productDAO.deleteProduct(productId);
    }

    @Override
    public Product updateProduct(Product product) {
        return productDAO.updateProduct(product);
    }

    @Override
    public List<Product> listAllProduct() {
        return productDAO.listAllProduct();
    }

    @Override
    public void addShoppingChart(Product product) {
        productDAO.updateProduct(product);
    }
}