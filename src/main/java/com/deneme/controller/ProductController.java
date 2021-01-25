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

    @RequestMapping(value = "/createProduct/{categoryId}", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    Long newProduct(@RequestBody Product product , @PathVariable(value = "categoryId") long categoryId) {


        Long p = productService.createProduct(product,categoryId);
        logger.info("Product adding. id : " + p);
        return p;
    }

    @RequestMapping(value = "/editProduct/{productId}", method = RequestMethod.PUT, consumes = "application/json")
    public @ResponseBody
    Product updateProduct(@PathVariable(value = "productId") long id, @RequestBody Product product) {

        logger.info("Product updating. : " + product.getProductId());
        return productService.updateProduct(product);

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

    @RequestMapping(value =  "getProductById/{productId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Product listAllProduct(@PathVariable(value = "productId") long productId) {

        logger.info("products " + productId);
        Product product = productService.getProductById(productId);
        return product;
    }




}