package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Category;
import com.project.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired private CategoryRepository categoryRepo;

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public Category addCategory(Category category) {
        return categoryRepo.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepo.deleteById(id);
    }
}
