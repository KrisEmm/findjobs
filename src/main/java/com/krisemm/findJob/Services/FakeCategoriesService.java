/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.findJob.Services;

import com.krisemm.findJob.Models.Category;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author kristian
 */
@Service
public class FakeCategoriesService {
    
    public static Integer incremetID = 0;
            
    public List<Category> generate(){
        
        List<Category> categories = new ArrayList<>();
        Category category1 = new Category();
        category1.setId(++incremetID);
        category1.setName("Informatica");
        category1.setDescription("Ingeniera en Ciencias de la Computacion, Sistemas Informaticos o IT");
        
        Category category2 = new Category();
        category2.setId(++incremetID);
        category2.setName("Contruccion");
        category2.setDescription("Ingeniera en Artitectura o Civil");
        
        categories.add(category1);
        categories.add(category2);
        
        return categories;
    }
}
