package com.workshop.rest;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class EmployeeController {
  
  private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
  
  @Autowired
  Employee myEmployee;
  
  @Autowired
  Resume myResume;
  
  @GetMapping("/employee")
  public Employee getSingleEmployee() {
    
    logger.info("GetMapping for employee");
    return myEmployee;
    
  }
  
  @GetMapping(path = "/resume", produces = "application/json")
  public Resume getSingleResume() {
    
    logger.info("GetMapping for resume");
    return myResume;
    
  }
  
  @GetMapping(path = "/both",produces = { MediaType.APPLICATION_XML_VALUE })
  public Resume returnOnlyXM() {
    
    logger.info("GetMapping method that returns XML");
    return myResume;
    
  }
  
  @GetMapping(path = "/both",produces = { MediaType.APPLICATION_JSON_VALUE })
  public Resume returnOnlyJSON() {
    
    logger.info("GetMapping method that returns JSON");
    return myResume;
    
  }  
  

  @PostMapping(path = "/resume", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
  public void mapSingleEmployee(@RequestBody Resume res)
  {
    
    logger.info("PostMapping for resume");
    logger.info(res.toString());
  }  
  
  @PostMapping("/employee")
  public void mapSingleEmployee(@RequestBody Employee emp)
  {
    
    logger.info("PostMapping for employee");
    logger.info(emp.toString());
  }
  
  @PostMapping(path="/vals", consumes = "application/x-www-form-urlencoded")
  public void process(@RequestParam Map<String,String> paramValues) {
    
    logger.info("PostMapping for values");
    for (Map.Entry<String, String> entry : paramValues.entrySet())
      logger.info("Key = " + entry.getKey() + ", Value = " + entry.getValue());

  }    
  
  
  @PutMapping("/resume")
  public void putSingleResume(@RequestBody Resume res)
  {
    logger.info("PutMapping for resume");
    logger.info(res.toString());
  }
  
  @DeleteMapping("/resume")
  public void deleteSingleResume()
  {
    logger.info("DeleteMapping for resume");
  }

}

