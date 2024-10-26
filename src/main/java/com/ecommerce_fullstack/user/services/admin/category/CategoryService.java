package com.ecommerce_fullstack.user.services.admin.category;

import com.ecommerce_fullstack.user.dto.CategoryDto;
import com.ecommerce_fullstack.user.entity.Category;

import java.util.List;

public interface CategoryService {

    Category createCategory(CategoryDto categoryDto);
    List<Category> getAllCategories();

}
