/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.findJob.Repositories;

import com.krisemm.findJob.Models.Vacancy;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kristian
 */
@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Integer> {

    List<Vacancy> findByStatus(String status);
    List<Vacancy> findByStatusIn(String[] status);
    List<Vacancy> findByOutstandingAndStatusOrderBySalaryDesc(int outstanding, String status);
    List<Vacancy> findBySalaryBetweenOrderBySalary(double max, double min);
    
}
