/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.findJob.Repositories;

import com.krisemm.findJob.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kristian
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
