package com.workshop.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.workshop.jpa.model.Developer;

public interface DeveloperRepository extends PagingAndSortingRepository<Developer, Integer> {
  
  // Returns the last row in the table
  @Query(value = "SELECT * FROM developers ORDER BY id DESC LIMIT 1", 
      nativeQuery = true)
  List<Developer> getNewlyAddedRecord();
  
  // Update existing row in the table by its id
  @Modifying
  @Transactional
  @Query(value = "UPDATE developers SET name = :devName, age = :devAge, languages = :devLanguages, married = :devMarried WHERE id = :devId", 
      nativeQuery = true)
  
  void updateExistingRecord(@Param("devId") int devId, @Param("devName") String devName, @Param("devAge") Integer devAge, 
      @Param("devLanguages") String devLanguages, @Param("devMarried") Boolean devMarried);
  
  // Find all developers that can code in a specified language
  List<Developer> findByLanguagesContaining(String langToFind);
  
  // Find all developers who are married
  List<Developer> findByMarried(boolean married);
  
  
}