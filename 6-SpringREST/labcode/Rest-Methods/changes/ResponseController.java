package com.workshop.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ResponseController {
  
  private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
  
  @Autowired
  Employee myEmployee;
  
  @Autowired
  Resume myResume;
  
  @ResponseStatus(HttpStatus.ACCEPTED)
  @GetMapping("/status-one")
  public Resume firstStatus() {
    
    logger.info("firstStatus called");
    return myResume;
    
  }
  
  @GetMapping("/status-two")
  public ResponseEntity<Employee> secondStatus() {
    
    logger.info("secondStatus called");
    return new ResponseEntity<>(myEmployee, HttpStatus.MOVED_PERMANENTLY);
    
  }  

}

