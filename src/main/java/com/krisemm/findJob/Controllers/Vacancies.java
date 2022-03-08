/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.findJob.Controllers;

import com.krisemm.findJob.Models.Category;
import com.krisemm.findJob.Models.Vacancy;
import com.krisemm.findJob.Services.CategoryService;
import com.krisemm.findJob.Services.ManagerUploadedFilesService;
import com.krisemm.findJob.Services.VacancyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author kristian
 */
@Controller
@RequestMapping(value = "/vacancies")
public class Vacancies {

    @Autowired
    private VacancyService vacancyService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/index")
    public String handleShowListVacancies(Model model) {
        List<Vacancy> vacancies = vacancyService.findAll();
        model.addAttribute("vacancies", vacancies);
        return "pages/vacancies/list";
    }
        
    @GetMapping("/list")
    public String handleGetPages(Model model, Pageable page){
        Page<Vacancy> pages = vacancyService.findAll(page);
        model.addAttribute("vacancies", pages);
        return "pages/vacancies/list";
    }
    
    @GetMapping(value = "/view/{id}")
    public String handleShowDetailsVacancy(@PathVariable("id") Integer idVacancy, Model model) {
        Vacancy vacancy = vacancyService.findById(idVacancy);
        model.addAttribute("id", idVacancy);
        model.addAttribute("vacancy", vacancy);
        return "pages/vacancies/detail";
    }

    @GetMapping(value = "/edit/{id}")
    public String handleShowEditVacancy(@PathVariable("id") Integer idVacancy, Model model) {
        List<Category> categories = categoryService.findAll();
        Vacancy vacancy = vacancyService.findById(idVacancy);
        model.addAttribute("vacancy", vacancy);
        model.addAttribute("categories", categories);
        return "pages/vacancies/form";
    }

    @GetMapping(value = "/add")
    public String handleShowFormNewVacancy(Vacancy vacancy, Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "pages/vacancies/form";
    }

    @PostMapping(value = "/add")
    public String handleSaveVacancy(
            Vacancy vacancy,
            BindingResult result,
            RedirectAttributes attributes,
            Model model,
            @RequestParam(value = "file") MultipartFile file,
            @Autowired ManagerUploadedFilesService managerUploadedFiles
    ) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);

        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            return "pages/vacancies/form";
        }

        if (!file.isEmpty()) {
            vacancy.setImage(managerUploadedFiles.store(file));
        }
        vacancyService.save(vacancy);
        attributes.addFlashAttribute("message", "Una nueva Vacante ha sido agregada correctamente");
        return "redirect:/vacancies/list";
    }

    @GetMapping(value = "/delete/{id}")
    public String handleDeleteVacancy(@PathVariable("id") Integer idVacancy, RedirectAttributes atrribute) {

        String message = "La Vacante" + " " + vacancyService.findById(idVacancy).getName() + " " + "ha sido eliminada correctamente";
        vacancyService.delete(idVacancy);
        atrribute.addFlashAttribute("message", message);

        return "redirect:/vacancies/list";
    }
}
