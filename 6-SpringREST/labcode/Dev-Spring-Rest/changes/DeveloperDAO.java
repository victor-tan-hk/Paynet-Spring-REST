package com.workshop.rest.dao;

import java.util.List;
import com.workshop.rest.model.Developer;

public interface DeveloperDAO {
  
  Developer get(int id);
  
  List<Developer> getAll();
  
  int save(Developer dev);
  
  void update(int id, Developer dev);
  
  void delete(int id);

}
