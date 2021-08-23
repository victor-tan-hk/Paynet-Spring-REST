package com.workshop.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.workshop.jpa.model.Developer;

public interface DeveloperRepository extends PagingAndSortingRepository<Developer, Integer> {
  
  // Returns the last row in the table
  @Query(value = "SELECT * FROM developers ORDER BY id DESC LIMIT 1", 
      nativeQuery = true)
  List<Developer> getNewlyAddedRecord();
  
}