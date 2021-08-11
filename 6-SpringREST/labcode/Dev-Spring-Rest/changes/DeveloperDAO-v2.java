package com.workshop.rest.dao;

import java.util.List;
import java.util.Map;

import com.workshop.rest.model.Developer;

public interface DeveloperDAO {
  
  Developer get(int id);
  
  int save(Developer dev);
  
  void update(int id, Developer dev);
  
  void delete(int id);
  
  List<Developer> getWithParams(Map<String, String> allParams);


}
