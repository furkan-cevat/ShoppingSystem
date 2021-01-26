package com.deneme.service;

import com.deneme.model.Category;

import java.util.List;

public interface CategoryService {

    long addCategory(Category category);
    void deleteById(long categoryId);
    Category updateCategory(Category category);
    Category findByIdCategory(long categoryId);
    List<Category> allCategories();
<<<<<<< HEAD
=======





>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f

}