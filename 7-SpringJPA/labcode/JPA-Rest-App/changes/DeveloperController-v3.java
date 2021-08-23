package com.workshop.jpa.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.workshop.jpa.service.DeveloperService;
import com.workshop.jpa.dto.DeveloperDTO;


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

}
