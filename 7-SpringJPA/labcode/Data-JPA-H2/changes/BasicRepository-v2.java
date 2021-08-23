package com.workshop.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface BasicRepository extends PagingAndSortingRepository<Developer, Integer> {
  

}