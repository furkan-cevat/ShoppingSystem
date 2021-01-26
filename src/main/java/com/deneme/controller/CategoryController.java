package com.deneme.controller;

import com.deneme.model.Category;
import com.deneme.service.CategoryService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
=======
import org.springframework.web.bind.annotation.*;
>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f

import java.util.List;

@RequestMapping("/categoryApi")
@Controller
public class CategoryController {

    private static final Logger logger = Logger.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/newCategory", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    long newCategory(@RequestBody Category category) {
<<<<<<< HEAD
        logger.info("Category adding. id : " + category.getCategoryId());
        return categoryService.addCategory(category);
    }

    @RequestMapping(value = "/editCategory", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
=======
        long id = categoryService.addCategory(category);
        logger.info("Category adding. id : " + id);
        return id;
    }

    @RequestMapping(value = "/editCategory", method = RequestMethod.PUT, consumes = "application/json",produces = "application/json")
>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
    public @ResponseBody
    Category updateCategory(@RequestBody Category category) {
        logger.info("Category updating. id: " + category.getCategoryId());
        return categoryService.updateCategory(category);
<<<<<<< HEAD
=======

>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
    }

    @RequestMapping(value = "/removeCategory/{categoryId}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteCategory(@PathVariable(value = "categoryId") long id) {
        logger.info("User deleting. Id : " + id);
        categoryService.deleteById(id);
<<<<<<< HEAD
=======
    }

    @RequestMapping(value = "/findAllCategory", method = RequestMethod.GET)
    @ResponseBody
    public List<Category> findAllCategory() {
        logger.info("All Categories");
        return categoryService.allCategories();
>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
    }

    @RequestMapping(value = "/findAllCategory", method = RequestMethod.GET)
    @ResponseBody
    public List<Category> findAllCategory() {
        logger.info("All Categories");
        return categoryService.allCategories();
    }

}
