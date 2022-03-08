/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.findJob.Services;

import com.krisemm.findJob.Models.Category;
import com.krisemm.findJob.Models.Vacancy;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author kristian
 */
@Service
public class FakeVacanciesService {
    
    public List<Vacancy> generate(){    
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Category category = new Category();
        category.setId(0);
        category.setName("Default");
        category.setDescription("Default");
        
        Vacancy vacancy1 = new Vacancy();
        vacancy1.setName("Ingeniero de Software");
        vacancy1.setDescription("Se solicita Ingeniero Backend en Java");
        vacancy1.setPublished(LocalDate.parse(LocalDate.now().format(formatter),formatter));
        vacancy1.setSalary(10000.0);
        vacancy1.setOutstanding(1);
        vacancy1.setCategory(category);
        
        Vacancy vacancy2 = new Vacancy();
        vacancy2.setName("Ingeniero de Software");
        vacancy2.setDescription("Se solicita Ingeniero Backend en NodeJs");
        vacancy2.setPublished(LocalDate.parse(LocalDate.now().format(formatter),formatter));
        vacancy2.setSalary(10000.0);
        vacancy2.setOutstanding(0);
        vacancy2.setCategory(category);

        
        Vacancy vacancy3 = new Vacancy();
        vacancy3.setName("Ingeniero de Software");
        vacancy3.setDescription("Se solicita Ingeniero Backend en php");
        vacancy3.setPublished(LocalDate.parse(LocalDate.now().format(formatter),formatter));
        vacancy3.setSalary(10000.0);
        vacancy3.setOutstanding(1);
        vacancy3.setCategory(category);

        
        Vacancy vacancy4 = new Vacancy();
        vacancy4.setName("Mesero");
        vacancy4.setDescription("Pour me Something tall and strong");
        vacancy4.setPublished(LocalDate.parse(LocalDate.now().format(formatter),formatter));
        vacancy4.setSalary(10000.0);
        vacancy4.setOutstanding(0);
        vacancy4.setCategory(category);

        Vacancy vacancy5 = new Vacancy();
        vacancy5.setName("Ingeniero de Software");
        vacancy5.setDescription("Se solicita Ingeniero Frontend en Angular");
        vacancy5.setPublished(LocalDate.parse(LocalDate.now().format(formatter),formatter));
        vacancy5.setSalary(10000.0);
        vacancy5.setOutstanding(1);
        vacancy5.setCategory(category);


        List<Vacancy> list = new ArrayList<>();

        list.add(vacancy1);
        list.add(vacancy2);
        list.add(vacancy3);
        list.add(vacancy4);
        list.add(vacancy5);
        
        return list;
     }

}
