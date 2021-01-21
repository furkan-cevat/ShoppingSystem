package com.deneme.controller;


import com.deneme.model.Product;
import com.deneme.service.ProductService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/productApi")
@Controller
public class ProductController {

    private static final Logger logger = Logger.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/newProduct", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    long newProduct(@RequestBody Product product) {

        long id = productService.createProduct(product);
        logger.info("Product adding. id : " + id);
        return id;
    }

    @RequestMapping(value = "/editProduct/{productId}", method = RequestMethod.PUT, consumes = "application/json")
    public @ResponseBody
    Product updateProduct(@PathVariable(value = "productId") long id, @RequestBody Product product) {
        Product productTemp = new Product();

        productTemp.setProductId(product.getProductId());
        productTemp.setName(product.getName());
        productTemp.setStock(product.getStock());
        productTemp.setCategory(product.getCategory());

        logger.info("Product updating. : " + productTemp);
        return productService.updateProduct(productTemp);

    }
    @RequestMapping(value = "/removeProduct/{productId}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteProduct(@PathVariable(value = "productId") long id) {
        logger.info("Product deleting. Id : " + id);
        productService.deleteProduct(id);
    }

    @RequestMapping(value =  "listAllProduct", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Product> listAllProdcut() {

        logger.info("All products.");
        List<Product> productList = productService.listAllProduct();
        return productList;
    }




}
