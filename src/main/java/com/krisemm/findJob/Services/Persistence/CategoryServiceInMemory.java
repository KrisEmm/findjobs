/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.findJob.Services.Persistence;

import com.krisemm.findJob.Models.Category;
import com.krisemm.findJob.Services.CategoryService;
import com.krisemm.findJob.Services.FakeCategoriesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author kristian
 */
@Service
@Qualifier("InMemory")
public class CategoryServiceInMemory implements CategoryService {
    
    private List<Category> categories;
    
    @Autowired
    public CategoryServiceInMemory(FakeCategoriesService fakeCategories) {
        this.categories = fakeCategories.generate();
    }
    
    @Override
    public List<Category> findAll() {
        return categories;
    }

    @Override
    public Category findById(Integer id) {
        for(Category category: categories){
            if(category.getId().equals(id)){
                System.out.println("here: "+category);
                return category;
            }
        }
        return null;
    }

    @Override
    public void save(Category category) {
        category.setId(++FakeCategoriesService.incremetID);
        categories.add(category);
        System.out.println("Category Saved Sucess!");
        System.out.println(category);
    }
    
}
