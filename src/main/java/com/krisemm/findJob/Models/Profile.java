/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.findJob.Models;


/**
 *
 * @author kristian
 */
public class Profile {
    private Integer idUser;
    private Integer idRole;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    @Override
    public String toString() {
        return "Profile{" + "idUser=" + idUser + ", idRole=" + idRole + '}';
    }
    
    
}
