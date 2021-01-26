package com.deneme.service;

import com.deneme.model.Product;

;import java.util.List;

public interface ProductService {

    Long createProduct(Product product, long categoryId);
    void deleteProduct(long productId);
    Product updateProduct(Product product);
    List<Product> listAllProduct();
    Product getProductById(long productId);

    void updateProductCartId(long cartId);

    long getProductStock(long productId);

    void setStockValue(long productId,long cartId);

    void setStockValueCancelled(Long productId, long cartId);






}