package com.deneme.service.impl;

import com.deneme.model.Category;
import com.deneme.repository.CategoryRepo;
import com.deneme.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public long addCategory(Category category) {
        Category category1 = new Category();
        category1.setCategoryId(category.getCategoryId());
        category1.setName(category.getName());
        categoryRepo.save(category1);
        return category1.getCategoryId();
    }

    @Override
    public void deleteById(long categoryId) {
        Category category1 = findByIdCategory(categoryId);
        categoryRepo.deleteById(category1.getCategoryId());
    }

    @Override
    public Category updateCategory(Category category) {
        Category category1 = findByIdCategory(category.getCategoryId());
        category1.setName(category.getName());
        categoryRepo.save(category1);
        return category1;
    }

    @Override
    public Category findByIdCategory(long categoryId) {
        return categoryRepo.findById(categoryId).orElse(null);
    }

    @Override
    public List<Category> allCategories() {
        return categoryRepo.findAll();
    }
}
