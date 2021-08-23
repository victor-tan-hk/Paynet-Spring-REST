package com.workshop.jpa;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface BasicRepository extends PagingAndSortingRepository<Developer, Integer> {
  
  
  // Demonstration of various forms of native SQL queries
  
  @Query(value = "SELECT * FROM developers WHERE age > 50 AND married IS FALSE", 
      nativeQuery = true)
  List<Developer> getAllTheOldLonelyDevs();
  
  @Query(value = "SELECT MIN(age) FROM developers", 
      nativeQuery = true)
  int whoIsYoungestDev();
  
  @Query(value = "SELECT * FROM developers WHERE age <= :devage AND INSTR(languages,:devlang) > 0", nativeQuery = true)
  List<Developer> whoAreTheCoolDevs(@Param("devage") Integer devage, @Param("devlang") String devlang);

  @Query(value = "SELECT COUNT(*) FROM developers WHERE  INSTR(languages,:devlang) > 0", nativeQuery = true)
  int getNumOfLanguagePros(@Param("devlang") String devlang);
  
  @Query(
      value = "SELECT * FROM developers ORDER BY age", 
      countQuery = "SELECT COUNT(*) FROM developers", 
      nativeQuery = true)
  List<Developer> findAllDevsSortedOnAgeWithPagination(Pageable pageable);
  
  
  // Demonstration of various forms of JPQL queries

  @Query("SELECT d FROM Developer d WHERE d.married = false")
  List<Developer> findAllSingleDevelopers();
  
  
  @Query(value = "SELECT d FROM Developer d WHERE d.age > :devage AND LOCATE(:devlang, d.languages) > 0")
  List<Developer> whoAreTheBoringDevs(@Param("devage") Integer devage, @Param("devlang") String devlang);
  
  
  @Query(value = "SELECT d FROM Developer d ORDER BY d.name")
  List<Developer> findAllDevsSortedOnNameWithPagination(Pageable pageable);
  
}