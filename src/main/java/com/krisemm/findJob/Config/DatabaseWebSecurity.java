/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.findJob.Config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author kristian
 */
@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter{
    @Autowired
    private DataSource dataSource;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT username, password, status FROM User WHERE username=?")
                .authoritiesByUsernameQuery("SELECT u.username, r.role FROM Profile up " +
                                            "INNER JOIN User u on u.id = up.idUser " +
                                            "INNER JOIN Role r on r.id = up.idRole " +
                                            "WHERE u.username=?"); 
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(
                        "/bootstrap/**",
                        "/images/**",
                        "/tinymce/**"
                )
                .permitAll()
                .antMatchers(
                        "/",
                        "/search",
                        "/vacancies/view/**",
                        "/signup"
                )
                .permitAll()
                .antMatchers("/vacancies/**").hasAnyAuthority("SUPERVISOR","ADMINISTRADOR")
                .antMatchers("/categories/**").hasAnyAuthority("SUPERVISOR","ADMINISTRADOR")
                .antMatchers("/users/**").hasAnyAuthority("ADMINISTRADOR")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("/login")
                .permitAll();
                
                
    }
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
}
