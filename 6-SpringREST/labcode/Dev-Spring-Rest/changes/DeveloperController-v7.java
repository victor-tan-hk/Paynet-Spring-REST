package com.workshop.rest.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.workshop.rest.dao.DeveloperDAO;
import com.workshop.rest.exception.IncorrectJSONFormatException;
import com.workshop.rest.model.Developer;

@RestController
@RequestMapping("/api")
public class DeveloperController {

  @Autowired
  DeveloperDAO myDevelopers;

  private static final Logger logger = LoggerFactory.getLogger(DeveloperController.class);

  @GetMapping("/developers")
  public List<Developer> getDevelopers(@RequestParam Map<String, String> allParams) {

    logger.info("GET /api/developers invoked");
    
    return myDevelopers.getWithParams(allParams);

  }

  @PostMapping("/developers")
  public ResponseEntity<Object> addSingleDeveloper(@RequestBody Developer dev) {

    logger.info("POST /api/developers invoked");

    int devId = myDevelopers.save(dev);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(devId).toUri();
    return ResponseEntity.created(location).build();

  }

  @PutMapping("/developers/{devIdString}")
  public void updateDeveloper(@PathVariable String devIdString, @RequestBody Developer dev) {

    logger.info("PUT /api/developers invoked");
    
    Integer devId = null;
    try {
      devId = Integer.parseInt(devIdString);
    } catch (NumberFormatException ex) {
      throw new IncorrectJSONFormatException("Developer id specified in path must be a number");
    }
    myDevelopers.update(devId, dev);

  }
  
  @DeleteMapping("/developers/{devIdString}")
  public void deleteDeveloper(@PathVariable String devIdString) {

    logger.info("DELETE /api/developers invoked");

    Integer devId = null;
    try {
      devId = Integer.parseInt(devIdString);
    } catch (NumberFormatException ex) {
      throw new IncorrectJSONFormatException("Developer id specified in path must be a number");
    }
    myDevelopers.delete(devId);

  }  
  
  @GetMapping("/developers/{devIdString}")
  public Developer getSingleDeveloper(@PathVariable String devIdString) {

    logger.info("GET /api/developers/" + devIdString + " invoked");

    Integer devId = null;
    try {
      devId = Integer.parseInt(devIdString);
    } catch (NumberFormatException ex) {
      throw new IncorrectJSONFormatException("Developer id specified in path must be a number");
    }
    return (myDevelopers.get(devId));

  }    

}
