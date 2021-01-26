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
<<<<<<< HEAD
    Long newProduct(@RequestBody Product product, @PathVariable(value = "categoryId") long categoryId) {
        logger.info("Product adding. id : "+ product.getProductId());
        return productService.createProduct(product, categoryId);
=======
    Long newProduct(@RequestBody Product product , @PathVariable(value = "categoryId") long categoryId) {


        Long p = productService.createProduct(product,categoryId);
        logger.info("Product adding. id : " + p);
        return p;
>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
    }

    @RequestMapping(value = "/editProduct/{productId}", method = RequestMethod.PUT, consumes = "application/json")
    public @ResponseBody
<<<<<<< HEAD
    Product updateProduct(@RequestBody Product product) {
        logger.info("Product updating. : " + product.getProductId());
        return productService.updateProduct(product);
=======
    Product updateProduct(@PathVariable(value = "productId") long id, @RequestBody Product product) {

        logger.info("Product updating. : " + product.getProductId());
        return productService.updateProduct(product);

>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
    }

    @RequestMapping(value = "/removeProduct/{productId}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteProduct(@PathVariable(value = "productId") long id) {
        logger.info("Product deleting. Id : " + id);
        productService.deleteProduct(id);
    }

    @RequestMapping(value = "listAllProduct", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Product> listAllProdcut() {
        logger.info("All products.");
        return productService.listAllProduct();
    }

    @RequestMapping(value = "getProductById/{productId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Product listAllProduct(@PathVariable(value = "productId") long productId) {
        logger.info("products " + productId);
        return productService.getProductById(productId);
    }
<<<<<<< HEAD
=======




>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
}