package com.workshop.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
    log.info("/developers invoked");
    return devService.getAllDevelopers();
    
  }

}
