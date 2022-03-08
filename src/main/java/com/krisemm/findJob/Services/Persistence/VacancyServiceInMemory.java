/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.findJob.Services.Persistence;

import com.krisemm.findJob.Models.Vacancy;
import com.krisemm.findJob.Services.FakeVacanciesService;
import com.krisemm.findJob.Services.VacancyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author kristian
 */
@Service
@Qualifier("InMemory")
public class VacancyServiceInMemory implements VacancyService {
    
    private List<Vacancy> vacancies;
    
    @Autowired
    public VacancyServiceInMemory(FakeVacanciesService fakeVacancies) {
        this.vacancies = fakeVacancies.generate();
    }
    
    @Override
    public List<Vacancy> findAll() {
        return vacancies;
    }

    @Override
    public Vacancy findById(Integer id) {
         for(Vacancy vacancy : vacancies){
            if(vacancy.getId().equals(id)) return vacancy;
        }
        return null;
    }
    
    @Override
    public void save(Vacancy vacancy) {
        vacancies.add(vacancy);
        System.out.println("Vacancy Saved Sucess!");
        System.out.println(vacancy);
    }

    @Override
    public List<Vacancy> findAllByOutstandingAndStatus(Integer outstanding, String status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vacancy> findAllByExample(Example<Vacancy> example) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<Vacancy> findAll(Pageable page) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
