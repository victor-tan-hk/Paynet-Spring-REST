package com.workshop.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.workshop.rest.dao.DeveloperDAO;
import com.workshop.rest.exception.DeveloperNotFoundException;
import com.workshop.rest.exception.IncorrectJSONFormatException;
import com.workshop.rest.model.Developer;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

@Component
public class DeveloperService implements DeveloperDAO {
  
  private static final Logger logger = LoggerFactory.getLogger(DeveloperService.class);

  private static final String LANGUAGE_PARAM = "language";
  private static final String MARRIED_PARAM = "married";
  private static final String AGE_PARAM = "age";
  private static final String LIMIT_PARAM = "limit";
  private static final String START_PARAM = "start";
  
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
    
    boolean found = false;
    Developer devToReturn = null;
    for (Developer tempDev : developers) {
      if (tempDev.getId() == id) {
        devToReturn = tempDev;
        found=true;
        break;
      }
    }
    
    if (!found) 
      throw new DeveloperNotFoundException("No developer with ID " + id + " exists !");
    else
      return devToReturn;
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
    
    boolean found = false;
    for (Developer tempDev : developers) {
      if (tempDev.getId() == id) {
        developers.remove(tempDev);
        found=true;
        break;
      }
    }
    
    if (!found) 
      throw new DeveloperNotFoundException("No developer with ID " + id + " exists !");    
    
  }
  
  @Override
  public List<Developer> getWithParams(Map<String, String> allParams) {
    
    List<Developer> listToFilter = developers;
    boolean foundValidKey = false;
    
    if (allParams.size() == 0)
      return listToFilter;
    else {
      
      for (Map.Entry<String, String> entry : allParams.entrySet()) {

        if (entry.getKey().equals(LANGUAGE_PARAM)) {
          foundValidKey = true;
          listToFilter = filterOnLanguage(entry.getValue(),listToFilter);
        } 
        else if (entry.getKey().equals(MARRIED_PARAM)) {
          
          String tempValue = entry.getValue().toLowerCase();
          if (!(tempValue.equals("false") || tempValue.equals("true")))
            throw new IncorrectJSONFormatException("married parameter must be either true or false");
          
          foundValidKey = true;
          listToFilter = filterOnMarried(Boolean.parseBoolean(tempValue),listToFilter);
        } 
        else if (entry.getKey().contains(">") || entry.getKey().contains("<")) {
          
          String tempValue = entry.getKey().toLowerCase();
          if (!(tempValue.contains(AGE_PARAM)))
            throw new IncorrectJSONFormatException("Condition expression only applicable for age parameter");

          foundValidKey = true;
          listToFilter = filterOnAge(entry.getKey(), listToFilter);
        }
      }
      
      // if at least one filtering operation was performed, return the result
      // otherwise return an empty list
      if (foundValidKey)
        return listToFilter;
      else
        return new ArrayList<Developer>();

    }
    
  }
  
  
  private List<Developer> filterOnLanguage(String languageToFind, List<Developer> listToFilter) {
    
    logger.info("Filtering on language : " + languageToFind);
    
    List<Developer> tempList = new ArrayList<Developer>();
    for (Developer tempDev : listToFilter) {
      for (String language : tempDev.getLanguages()) {
        if (language.toLowerCase().equals(languageToFind.toLowerCase())) {
          tempList.add(tempDev);
          break;
        }
      }
    }
    
    return tempList;
    
  }
  
  private List<Developer> filterOnMarried(boolean marriageStatus, List<Developer> listToFilter) {
    
    logger.info("Filtering on marriage : " + marriageStatus);
    
    List<Developer> tempList = new ArrayList<Developer>();
    for (Developer tempDev : listToFilter) {
      if (tempDev.isMarried() == marriageStatus) {
        tempList.add(tempDev);
      }
    }
    
    return tempList;
    
  }  

  private List<Developer> filterOnAge(String expression, List<Developer> listToFilter) {
    
    logger.info("Filtering on conditional expression : " + expression);
    
    ScriptEngineManager factory = new ScriptEngineManager();
    ScriptEngine engine = factory.getEngineByName("JavaScript");
    List<Developer> tempList = new ArrayList<Developer>();
    
    for (Developer tempDev : listToFilter) {
      
      try {
        engine.eval("age = " + tempDev.getAge());
        if ((Boolean) engine.eval(expression))
          tempList.add(tempDev);
      } catch (ScriptException e) {
        e.printStackTrace();
        throw new IncorrectJSONFormatException("Problem evaluating expression : " + expression);
      }
    }

    return tempList;
  }
  
  
}
