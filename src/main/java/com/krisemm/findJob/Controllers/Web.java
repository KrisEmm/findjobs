/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.findJob.Controllers;

import com.krisemm.findJob.Models.Vacancy;
import com.krisemm.findJob.Services.CategoryService;
import com.krisemm.findJob.Services.VacancyService;
import java.util.List;
import java.util.function.Consumer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author kristian
 */
@Controller
public class Web {
   @Autowired 
   private VacancyService vacancyService;
   @Autowired
   private CategoryService categoryService;
   private final String outstanding = "Destacado";
   private final String status = "Approved";
   
    @GetMapping("/")
    public String handleShowRoot(){
        return "pages/index";
    }
    
    @GetMapping("/search")
    public String handleQueryVacancy(@ModelAttribute("query") Vacancy vacancy, Model model){
        System.out.println(vacancy);
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher(
                "description", 
                ExampleMatcher.GenericPropertyMatchers.contains()
        );
        Example<Vacancy> example = Example.of(vacancy,matcher);
        if(!(vacancy.getDescription() == null & vacancy.getCategory().getId()== null)) {
            model.addAttribute("vacancies", vacancyService.findAllByExample(example));
        } 
        return "pages/index";
    }
    
    @GetMapping("/login")
    public String handleLogin(){
        return"pages/login";
    }
    
    @GetMapping("logout")
    public String handleLogout(HttpServletRequest request){
        SecurityContextLogoutHandler logoutHendler = new SecurityContextLogoutHandler();
        logoutHendler.logout(request, null, null);
        return "redirect:/login";
    }
    @GetMapping("/signup")
    public String handleSignin(Authentication auth, HttpSession session){
        System.out.println(auth.getCredentials().toString());
//        Consumer<GrantedAuthority> action = x->System.out.println(x);
//        List<GrantedAuthority> roles = (List<GrantedAuthority>) auth.getAuthorities();
//        String username = auth.getName();
//        if(session.getAttribute("user") == null){
//            User user = 
//            user.setPassword(null);
//            session.setAttribute("user", user);
//        }
//        roles.forEach(action);
//        System.out.println(username);
        return "redirect:/";
    }
    
    @ModelAttribute
    public void setModelAttributes(Model model){
        Vacancy vacancy = new Vacancy();
        vacancy.setImage(null);
        Integer value = outstanding == "Destacado" ? 1 : 0;               
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("vacancies", vacancyService.findAllByOutstandingAndStatus(value, status));
        model.addAttribute("query", vacancy);
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
    
       
    
}
