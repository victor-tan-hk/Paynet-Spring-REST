package com.workshop.rest.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
  public List<Developer> getAllDevelopers() {

    logger.info("GET /api/developers invoked");
    return myDevelopers.getAll();

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

    Integer devId = null;
    try {
      devId = Integer.parseInt(devIdString);
    } catch (NumberFormatException ex) {
      throw new IncorrectJSONFormatException("Developer id specified in path must be a number");
    }
    myDevelopers.update(devId, dev);

  }

}
