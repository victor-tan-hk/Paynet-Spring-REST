package com.workshop.jpa;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BasicRepository extends PagingAndSortingRepository<Developer, Integer> {
  
  // Basic keywords
  
  // Count the number of devs with a specified name
  int countByName(String name);

  // Find all devs with a specified name
  List<Developer> findByName(String name);
  
  // Find the first 3 devs with a specified name
  List<Developer> findFirst3ByName(String nameToFind);
  
  // Find all devs with a specified age
  List<Developer> findByAge(int age);
  
  // Combining basic keywords with logic keywords

  // Find all devs with a specified name and age
  List<Developer> findByNameAndAge(String name, int age);

  // Find all devs that can code in a specified language
  List<Developer> findByLanguagesContaining(String langToFind);
  
  // Find all devs that are younger than a specified age
  List<Developer> findByAgeLessThan(Integer age);

  // Find all devs that are the same or older than a specified age
  List<Developer> findByAgeGreaterThanEqual(Integer age);
  
  // Find all devs that are within an age range
  List<Developer> findByAgeBetween(Integer startAge, Integer endAge);

  // Find all devs that are younger than a specified age
  // and can code in a specified language
  List<Developer> findByAgeLessThanAndLanguagesContaining(Integer age, String langToFind);
  
  // Performing sorting
  
  // Find all devs that with a specified name
  // Sort them on their age in ascending order
  List<Developer> findByNameOrderByAgeAsc(String name);
  
  
  // Find all devs that can code in a specified language
  // Sort them on their name in ascending order
  // For identical names, sort on the age in descending order
  List<Developer> findByLanguagesContainingOrderByNameAscAgeDesc(String langToFind);
  
  // Apply pagination / sorting to standard findByMarried query method
  List<Developer> findAllByMarried(boolean married, Pageable pageable);        
  
}