package com.protrack.api.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protrack.api.entity.Category;
import com.protrack.api.repository.ICategoryRepository;

import lombok.Data;

@Service
@Data
public class CategoryService {
    
    @Autowired
    private ICategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public Optional<Category> getById(Long id){
        return categoryRepository.findById(id);
    }

    public Optional<Category> getByName(String name){
        return categoryRepository.findByNameIgnoreCase(name);
    }

    public Category create(Category category){
        return categoryRepository.save(category);
    }

    public Category update(Long id,Category categoryData){
        Optional<Category> existingCategory = categoryRepository.findById(id);

        if(existingCategory.isEmpty()){
            throw new RuntimeException("Category not found");
        }

        Category category = existingCategory.get();
        category.setName(categoryData.getName());
        categoryRepository.save(category);
        return category;
    
    }

    public void delete(Long id){
        categoryRepository.deleteById(id);
    }
}
