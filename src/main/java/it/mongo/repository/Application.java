/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.mongo.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author simonecipullo
 */
@Profile({Profiles.APPLICATION})
@SpringBootApplication
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer

{
       @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(this.getClass());
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
    
  
}