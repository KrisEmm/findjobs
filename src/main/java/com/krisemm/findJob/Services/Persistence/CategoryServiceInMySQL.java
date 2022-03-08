/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.findJob.Services.Persistence;

import com.krisemm.findJob.Models.Category;
import com.krisemm.findJob.Repositories.CategoryRepository;
import com.krisemm.findJob.Services.CategoryService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 *
 * @author kristian
 */
@Service
@Qualifier("InMySQL")
@Primary
public class CategoryServiceInMySQL implements CategoryService {

    @Autowired
    private CategoryRepository repository;
    
    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        Optional<Category> result = repository.findById(id);
        if(result.isEmpty()) return null;
        return result.get();
    }

    @Override
    public void save(Category category) {
        repository.save(category);
    }
    
}
