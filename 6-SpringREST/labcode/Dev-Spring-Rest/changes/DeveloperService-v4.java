package com.workshop.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.workshop.rest.dao.DeveloperDAO;
import com.workshop.rest.exception.DeveloperNotFoundException;
import com.workshop.rest.exception.IncorrectJSONFormatException;
import com.workshop.rest.model.Developer;

@Component
public class DeveloperService implements DeveloperDAO {
  
  private List<Developer> developers = new ArrayList<>();
  private int idCounter;
  
  public DeveloperService() {
    
    Developer dev1 = new Developer(1,"Peter",25, new String[] {"Java","Python"},false);
    Developer dev2 = new Developer(2,"Jane",38, new String[] {"C++","JavaScript"},true);
    Developer dev3 = new Developer(3,"Douglas",45, new String[] {"Java","JavaScript"},true);
    Developer dev4 = new Developer(4,"Sophia",30, new String[] {"Python","JavaScript","Java"},false);
    Developer dev5 = new Developer(5,"Isabella",58, new String[] {"C++","Java","Erlang"},true);
    
    developers.add(dev1);
    developers.add(dev2);
    developers.add(dev3);
    developers.add(dev4);
    developers.add(dev5);
    
    idCounter = developers.size();
    
  }

  @Override
  public Developer get(int id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Developer> getAll() {
    return developers;
  }

  @Override
  public int save(Developer dev) {
    
    if (dev.getName() == null || dev.getAge() == null || dev.getLanguages() == null)
      throw new IncorrectJSONFormatException("JSON is valid, but incorrect format for developer");
    
    idCounter++;
    dev.setId(idCounter);
    developers.add(dev);
    return idCounter;
  }

  @Override
  public void update(int id, Developer dev) {
    
    if (dev.getName() == null || dev.getAge() == null || dev.getLanguages() == null)
      throw new IncorrectJSONFormatException("All developer fields must be specified for update operation");
    
    boolean found = false;
    for (Developer tempDev : developers) {
      if (tempDev.getId() == id) {
        tempDev.setAge(dev.getAge());
        tempDev.setName(dev.getName());
        tempDev.setLanguages(dev.getLanguages());
        tempDev.setMarried(dev.isMarried());
        found=true;
        break;
      }
    }
    
    if (!found) 
      throw new DeveloperNotFoundException("No developer with ID " + id + " exists !");
  }

  @Override
  public void delete(int id) {
    // TODO Auto-generated method stub
    
  }

}
