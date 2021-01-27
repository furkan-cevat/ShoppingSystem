package com.deneme.controller;

import com.deneme.model.Category;
import com.deneme.service.CategoryService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
        logger.info("Category adding. id : " + category.getCategoryId());
        return categoryService.addCategory(category);
    }

    @RequestMapping(value = "/editCategory", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    Category updateCategory(@RequestBody Category category) {
        logger.info("Category updating. id: " + category.getCategoryId());
        return categoryService.updateCategory(category);
    }

    @RequestMapping(value = "/removeCategory/{categoryId}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteCategory(@PathVariable(value = "categoryId") long id) {
        logger.info("User deleting. Id : " + id);
        categoryService.deleteById(id);
    }

    @RequestMapping(value = "/findAllCategory", method = RequestMethod.GET)
    @ResponseBody
    public List<Category> findAllCategory() {
        logger.info("All Categories");
        return categoryService.allCategories();
    }

}
