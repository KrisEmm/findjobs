/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.findJob.Services;

import com.krisemm.findJob.Models.Category;
import java.util.List;

/**
 *
 * @author kristian
 */
public interface CategoryService {
    List<Category> findAll();
    Category findById(Integer id);
    void save(Category category);
}
