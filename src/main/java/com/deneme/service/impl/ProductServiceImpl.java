package com.deneme.service.impl;

import com.deneme.model.Category;
import com.deneme.model.Product;
<<<<<<< HEAD
=======
import com.deneme.model.User;
>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
import com.deneme.repository.ProductRepo;
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
    private ProductRepo productRepo;

    @Autowired
    private CategoryService categoryService;


    @Override
    public Long createProduct(Product product, long categoryId) {
        Category category = categoryService.findByIdCategory(categoryId);
        Product product1 = new Product();
        product1.setName(product.getName());
        product1.setStock(product.getStock());
        product1.setCategory(category);
        productRepo.save(product1);
        return product1.getProductId();

    }

    @Override
    public void deleteProduct(long productId) {
<<<<<<< HEAD
        //Product product1 = getProductById(productId);
=======
        Product product1 = getProductById(productId);
>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
        productRepo.deleteById(productId);
    }

    @Override
    public Product updateProduct(Product product) {
        Product product1 = getProductById(product.getProductId());
        Category category1 = categoryService.findByIdCategory(product1.getCategory().getCategoryId());
        product1.setName(product.getName());
        product1.setStock(product.getStock());
        product1.setCategory(category1);
<<<<<<< HEAD
=======

>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
        productRepo.save(product1);
        return product1;

    }

    @Override
    public List<Product> listAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(long productId) {
        return productRepo.findById(productId).orElse(null);
    }

    @Override
    public void updateProductCartId(long cartId) {
        productRepo.updateProductCartId(cartId,0);
    }


    @Override
    public long getProductStock(long productId) {
        return productRepo.findById(productId).orElse(null).getStock();
<<<<<<< HEAD
    }

    @Override
    public void setStockValue(long productId,long cartId) {
        productRepo.setStockValue(productId,cartId);
=======

    }


    @Override
    public void setStockValue(long productId,long cartId) {
        productRepo.setStockValue(productId,cartId);

>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
    }

    @Override
    public void setStockValueCancelled(Long productId, long cartId) {
        productRepo.setStockValueCancelled(productId,cartId);

    }

<<<<<<< HEAD
=======

>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
}