package com.workshop.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.workshop.jpa.service.CountryService;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Component
public class AppStartupRunner implements CommandLineRunner {
  
  @Value("${initialize.publicAPI:false}")
  private String initializeValue;
  
  @Autowired
  CountryService countryService;
      
  @Override
  public void run(String... args) throws Exception {

    log.info("REST API service started up");
    
    if (initializeValue.toLowerCase().equals("true")) {
      countryService.initializeFromPublicAPI();
    } else {
      log.info("Assuming table initialization has been completed");
    }

  }
}