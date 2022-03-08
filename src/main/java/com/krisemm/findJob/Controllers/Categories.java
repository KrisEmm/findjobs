/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.findJob.Controllers;

import com.krisemm.findJob.Models.Category;
import com.krisemm.findJob.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kristian
 */
@Controller
@RequestMapping(value="/categories")
public class Categories {
    
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping(value="/list")
    public String handleShowCategories(Model model){
        model.addAttribute("categories", categoryService.findAll());
        return "pages/categories/list";
    }
    
    @GetMapping(value="/add")
    public String handleShowFormCreateCategories(Category category){
        return "pages/categories/form";
    }
    
    @PostMapping(value="/add")
    public String handleSaveCategories(Category category){
        categoryService.save(category);
        return "redirect:/categories/list";
    }
}
