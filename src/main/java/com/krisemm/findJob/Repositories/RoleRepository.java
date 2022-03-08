/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.findJob.Repositories;

import com.krisemm.findJob.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kristian
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
