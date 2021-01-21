package com.deneme.dao;

import com.deneme.model.Category;
import com.deneme.model.User;

public interface CategoryDAO {
    public long createCategory(Category category);

    public void deleteCategory(long categoryId);

    public Category updateCategory(Category category);


}
