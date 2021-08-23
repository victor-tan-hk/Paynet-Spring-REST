package com.workshop.jpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.workshop.jpa.model.Developer;


public interface DeveloperRepository extends PagingAndSortingRepository<Developer, Integer> {
  
  
  
}