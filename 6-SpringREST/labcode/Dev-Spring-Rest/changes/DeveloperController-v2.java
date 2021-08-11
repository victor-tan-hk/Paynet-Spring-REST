package com.workshop.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.rest.dao.DeveloperDAO;
import com.workshop.rest.model.Developer;

@RestController
@RequestMapping("/api")
public class DeveloperController {
  
  @Autowired
  DeveloperDAO myDevelopers;
  
  private static final Logger logger = LoggerFactory.getLogger(DeveloperController.class);
  
  @GetMapping("/developers")
  public List<Developer> getAllDevelopers() {
    
    logger.info("/developers invoked");
    return myDevelopers.getAll();
    
  }


}
