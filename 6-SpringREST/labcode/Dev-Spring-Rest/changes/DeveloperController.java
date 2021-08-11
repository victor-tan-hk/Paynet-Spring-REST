package com.workshop.rest.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.rest.dao.DeveloperDAO;

@RestController
@RequestMapping("/api")
public class DeveloperController {
  
  @Autowired
  DeveloperDAO myDevelopers;
  
  private static final Logger logger = LoggerFactory.getLogger(DeveloperController.class);


}
