package com.workshop.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api")
public class SampleController {
  
  private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
  
  @Autowired
  Resume myResume;  
  
  // Demonstrate a server-side error
  @GetMapping("/demo-error")
  public void demoError() {
    
    // This causes a run-time Arithmetic Exception
    int y = 6 / 0;
    logger.info("Value of y : " + y);


  }
  
  // Demo using a custom Exception implementation
  @GetMapping("/firstdemo/{resumeId}")
  public Resume firstdemo(@PathVariable Integer resumeId) {
    
    // simulate the logic of searching for a resume based on its id
    // from a collection of 100 resumes
    if (resumeId < 1 || resumeId > 100) {
      throw new ResourceNotFoundException();
    }
    
    return myResume;
  }
  
  // Demo using a ResponseStatusException 
  @GetMapping("/seconddemo/{resumeId}")
  public Resume seconddemo(@PathVariable Integer resumeId) {
    
    // simulate the logic of searching for a resume based on its id
    // from a collection of 100 resumes
    if (resumeId < 1 || resumeId > 100) {
      String message = "Resume with id of " + resumeId + " is not found";
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, message, new RuntimeException());
      
    }
    
    return myResume;
  }  

  // Demo using a custom Exception implementation
  // that is caught by @ExceptionHandler 
  @GetMapping("/thirddemo/{resumeId}")
  public Resume thirddemo(@PathVariable Integer resumeId) {
    
    // simulate the logic of searching for a resume based on its id
    // from a collection of 100 resumes
    if (resumeId < 1 || resumeId > 100) {
      throw new AnotherCustomException("Bad ID specified : " + resumeId);
    }
    
    return myResume;
  } 
  
  @PostMapping("/fourthdemo") 
  public void fourthdemo(@RequestBody Resume res) {
    logger.info("PostMapping for resume");
    logger.info(res.toString());
  }

}
