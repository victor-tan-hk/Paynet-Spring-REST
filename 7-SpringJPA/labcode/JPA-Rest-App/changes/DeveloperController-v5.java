package com.workshop.jpa.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.workshop.jpa.service.DeveloperService;
import com.workshop.jpa.dto.DeveloperDTO;
import com.workshop.jpa.exception.IncorrectURLFormatException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class DeveloperController {
  
  @Autowired
  DeveloperService devService;
  
  @GetMapping("/developers")
  public List<DeveloperDTO> getAllDevelopers() {
    
    log.info("GET /api/developers invoked");
    return devService.getAllDevelopers();
    
  }
  
  @PostMapping("/developers")
  public ResponseEntity<Object> addSingleDeveloper(@RequestBody DeveloperDTO devDTO) {
    
    log.info("POST /api/developers invoked");
    
    int devId = devService.saveDeveloper(devDTO);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(devId)
        .toUri();   
    return ResponseEntity.created(location).build();
    
  }
  
  @PutMapping("/developers/{devIdString}")
  public void updateDeveloper(@PathVariable String devIdString, @RequestBody DeveloperDTO devDTO) {

    log.info("PUT /api/developers invoked");
    
    int devId = 0;
    try {
      devId = Integer.parseInt(devIdString);
    } catch (NumberFormatException ex) {
      throw new IncorrectURLFormatException("Developer id specified in path must be a number");
    }
    devService.updateDeveloper(devId, devDTO);

  }
  
  @DeleteMapping("/developers/{devIdString}")
  public void deleteDeveloper(@PathVariable String devIdString) {

    log.info("DELETE /api/developers invoked");
    
    int devId = 0;
    try {
      devId = Integer.parseInt(devIdString);
    } catch (NumberFormatException ex) {
      throw new IncorrectURLFormatException("Developer id specified in path must be a number");
    }
    devService.deleteDeveloper(devId);

  }
  
  

}
