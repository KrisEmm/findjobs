/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.findJob.Services;

import com.krisemm.findJob.Models.Vacancy;
import java.util.List;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author kristian
 */
public interface VacancyService {
    List<Vacancy> findAll();
    Page<Vacancy> findAll(Pageable page);
    List<Vacancy> findAllByExample(Example<Vacancy> example);
    List<Vacancy> findAllByOutstandingAndStatus(Integer outstanding, String status);
    Vacancy findById(Integer id);
    void save(Vacancy vacancy);
    void delete(Integer id);
}
