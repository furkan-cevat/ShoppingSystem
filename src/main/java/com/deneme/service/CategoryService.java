package com.deneme.service;

import com.deneme.model.Category;
import com.deneme.model.User;

import java.util.List;

;


public interface CategoryService {

    public long createCategory(Category category);

    public void deleteCategory(long categoryId);

    public Category updateCategory(Category category);






}