package com.workshop.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.jpa.controller.DeveloperController;
import com.workshop.jpa.repository.DeveloperRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DeveloperService {
  
  @Autowired
  private DeveloperRepository devRepo;

}
