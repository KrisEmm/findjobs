/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.findJob.Services.Persistence;

import com.krisemm.findJob.Models.Vacancy;
import com.krisemm.findJob.Repositories.VacancyRepository;
import com.krisemm.findJob.Services.VacancyService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author kristian
 */
@Service
@Qualifier("InMySQL")
@Primary
public class VacancyServicesInMySQL implements VacancyService {
    
    @Autowired
    private VacancyRepository repository;
    
    @Override
    public List<Vacancy> findAll() {
        return repository.findAll();
    }

    @Override
    public Vacancy findById(Integer id) {
        Optional<Vacancy> result = repository.findById(id);
        if(result.isEmpty()) return null;
        return result.get();
    }

    @Override
    public void save(Vacancy vacancy) {
        repository.save(vacancy);
    }

    @Override
    public List<Vacancy> findAllByOutstandingAndStatus(Integer outstanding, String status) {
        List<Vacancy> vacancies = repository.findByOutstandingAndStatusOrderBySalaryDesc(outstanding,status);
        return vacancies;
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Vacancy> findAllByExample(Example<Vacancy> example) {
        return repository.findAll(example);
    }

    @Override
    public Page<Vacancy> findAll(Pageable page) {
        return repository.findAll(page);
    }
    
}
