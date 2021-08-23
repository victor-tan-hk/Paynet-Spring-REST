package com.workshop.jpa;

import org.springframework.data.repository.CrudRepository;

public interface BasicRepository extends CrudRepository<Developer, Integer> {
  

}