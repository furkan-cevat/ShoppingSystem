package com.deneme.service.impl;

import com.deneme.model.Product;
import com.deneme.model.ProductsInCart;
import com.deneme.model.ShoppingCart;
import com.deneme.repository.ProductInCartRepo;
import com.deneme.service.ProductInCartService;
import com.deneme.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductInCartServiceImpl implements ProductInCartService {

    @Autowired
    private ProductInCartRepo productInCartRepo;

    @Autowired
    private ProductService productService;

    @Override
    public void clearProductInCart(long shoppingCartId) {
        productInCartRepo.clearProductInCart(shoppingCartId);
    }

    @Override
    public String addShoppingChart(ShoppingCart cart, long productId, long orderAmount) {
        String message = null;
        Product p = productService.getProductById(productId);

        if(p.getStock()<orderAmount) {
            return "Stoktaki ürün sayısı yetersiz. ürün sayısı : " + p.getStock();
        }

        ProductsInCart pc = new ProductsInCart();
        pc.setShoppingCart(cart);
        pc.setOrderAmount(orderAmount);
        pc.setProductId(productId);
        try{
            productInCartRepo.save(pc);
            message = "Ürün başarılı şekilde eklendi";
        }
        catch (Exception e){
            message = "Ürün eklenemedi";
        }

        return message;
    }
}
