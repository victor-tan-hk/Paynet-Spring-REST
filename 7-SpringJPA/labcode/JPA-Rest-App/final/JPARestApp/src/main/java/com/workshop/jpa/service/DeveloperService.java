package com.workshop.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.workshop.jpa.dto.DeveloperDTO;
import com.workshop.jpa.exception.IncorrectJSONFormatException;
import com.workshop.jpa.exception.IncorrectURLFormatException;
import com.workshop.jpa.model.Developer;
import com.workshop.jpa.repository.DeveloperRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DeveloperService {
  
  @Autowired
  private DeveloperRepository devRepo;
  
  private static final String LANGUAGE_PARAM = "language";
  private static final String MARRIED_PARAM = "married";
  private static final String AGE_PARAM = "age";
  private static final String LIMIT_PARAM = "limit";
  private static final String PAGE_PARAM = "page";
  
  
  public List<DeveloperDTO> getAllDevelopers() {
    
    Iterable<Developer> devList = devRepo.findAll();
    log.info("Retrieved developers from database");
   
    return convertDeveloperListToDeveloperDTOList(devList);
  }
  
  public int saveDeveloper(DeveloperDTO devDTO) {
    
    if (isDeveloperValid(devDTO)) {
      Developer newDev = new Developer(devDTO);
      devRepo.save(newDev);
    }
    else 
      throw new IncorrectJSONFormatException("JSON is valid, but incorrect format for developer");

    List<Developer> devs = devRepo.getNewlyAddedRecord();
    int newDevId = devs.get(0).getId();
    return newDevId;
    
  }
  
  public void updateDeveloper(int devId, DeveloperDTO devDTO) {
    
    if (isDeveloperValid(devDTO)) {
      Developer newDev = new Developer(devDTO);
      if (!devRepo.existsById(devId))
        throw new IncorrectURLFormatException("Developer with id : " + devId + " does not exist");
      
      log.info("Updating developer id : "+ devId);
      log.info("With new contents : " + newDev.toString());

      devRepo.updateExistingRecord(devId, newDev.getName(), newDev.getAge(), 
          newDev.getLanguages(), newDev.getMarried());
    }
    else 
      throw new IncorrectJSONFormatException("JSON is valid, but incorrect format for developer");
  
  }
  
  
  public void deleteDeveloper(int devId) {
    
      if (!devRepo.existsById(devId))
        throw new IncorrectURLFormatException("Developer with id : " + devId + " does not exist");
      
      log.info("Deleting developer id : "+ devId);

      devRepo.deleteById(devId);
    
  }
  
  public DeveloperDTO getSingleDeveloper(int devId) {
    
    if (!devRepo.existsById(devId))
      throw new IncorrectURLFormatException("Developer with id : " + devId + " does not exist");

    Optional<Developer> dev = devRepo.findById(devId);
    return new DeveloperDTO(dev.get());
    
  }
  
  
  public List<DeveloperDTO> getWithParams(Map<String, String> allParams) {
    
    String langValue = null;
    String marriedValue = null;
    int greaterThanAge = -1;
    int lessThanAge = -1;
    int pageVal = -1;
    int limitVal = -1;
    
    Pageable paging;
    
    List<DeveloperDTO> listToReturn = new ArrayList<DeveloperDTO>();
    if (allParams.size() == 0)
      return getAllDevelopers();
    else {
      
      for (Map.Entry<String, String> entry : allParams.entrySet()) {
        
        String tempKey = entry.getKey();
        String tempValue = entry.getValue();
        log.info(tempKey + " : " + tempValue);
        
        if (tempKey.equals(LANGUAGE_PARAM)) {
          
          langValue = tempValue;
        
        } else if (tempKey.equals(MARRIED_PARAM)) {
        
          marriedValue = tempValue;
          if (!(marriedValue.toLowerCase().equals("true") || marriedValue.toLowerCase().equals("false")))
            throw new IncorrectURLFormatException( MARRIED_PARAM + " must be either true or false ");
        } else if (tempKey.contains(AGE_PARAM) && (!(tempKey.equals(PAGE_PARAM)))) {
          
          String errMessage = "age parameter is either specified as age>X or age<Y, where X and Y are positive numbers";
          String[] strArray;
          
          if (tempKey.contains(">")) {
            
            strArray = tempKey.split(">");
            try {
              greaterThanAge = Integer.parseInt(strArray[1]);
            } catch (NumberFormatException ex) {
              throw new IncorrectURLFormatException(errMessage);
            }
          
          } else if (tempKey.contains("<")) {
            
            strArray = tempKey.split("<");
            try {
              lessThanAge = Integer.parseInt(strArray[1]);
            } catch (NumberFormatException ex) {
              throw new IncorrectURLFormatException(errMessage);
            }
          }
          
          if (lessThanAge <= 0 && greaterThanAge <= 0)
            throw new IncorrectURLFormatException(errMessage);
          
        } else if (tempKey.equals(LIMIT_PARAM)) {
          
          try {
            limitVal = Integer.parseInt(tempValue);
          } catch (NumberFormatException ex) {
            throw new IncorrectURLFormatException("limit parameter must be a number");
          }
          if (limitVal < 0)
            throw new IncorrectURLFormatException("limit parameter must be a positive number");          
          
        } else if (tempKey.equals(PAGE_PARAM)) {
          
          try {
            pageVal = Integer.parseInt(tempValue);
          } catch (NumberFormatException ex) {
            throw new IncorrectURLFormatException("page parameter must be a number");
          }
          if (pageVal < 0)
            throw new IncorrectURLFormatException("page parameter must be a positive number");
          
        }
      
      }
      
      if (limitVal >= 0 && pageVal >= 0) {
        
        log.info("Retrieving developers from page : " + pageVal + " with a limit of : " + limitVal);
        
        paging = PageRequest.of(pageVal, limitVal);
        List<Developer> devs = devRepo.findAll(paging).getContent();
        listToReturn = convertDeveloperListToDeveloperDTOList(devs);
        
      } else if (!(limitVal < 0 && pageVal < 0)) {
        
        throw new IncorrectURLFormatException("both limit and page parameters must be supplied together");
        
      }
      
      
      if (lessThanAge > 0) {
        
        log.info("Retrieving developers who are younger than " + lessThanAge);
        listToReturn = convertDeveloperListToDeveloperDTOList(devRepo.findByAgeLessThan(lessThanAge));
        
      } else if (greaterThanAge > 0) {
        
        log.info("Retrieving developers who are older than " + greaterThanAge);
        listToReturn = convertDeveloperListToDeveloperDTOList(devRepo.findByAgeGreaterThan(greaterThanAge));
        
      } else if (langValue != null && marriedValue != null) {
        
        log.info("Retrieving developers who can code in : " +langValue + " with marital status : " + marriedValue);
        listToReturn = convertDeveloperListToDeveloperDTOList(devRepo.findByMarriedAndLanguagesContaining(Boolean.parseBoolean(marriedValue), langValue));
        
      } else if (langValue != null) {
        
        log.info("Retrieving all developers who can code in : " +langValue);
        listToReturn = convertDeveloperListToDeveloperDTOList(devRepo.findByLanguagesContaining(langValue));
      
      } else if (marriedValue != null) {

        log.info("Retrieving all developers with marital status : " +marriedValue);
        listToReturn = convertDeveloperListToDeveloperDTOList(devRepo.findByMarried(Boolean.parseBoolean(marriedValue)));

      } 

      return listToReturn;

    }
    
  }
  
  private boolean isDeveloperValid(DeveloperDTO devDTO) {
    
    return (devDTO.getName() != null &&
        devDTO.getAge() != null &&
        devDTO.getLanguages() != null &&
        devDTO.getMarried() != null);
    
  }
  
  private List<DeveloperDTO> convertDeveloperListToDeveloperDTOList(Iterable<Developer> devList) {
    
    List<DeveloperDTO> myDevs = new ArrayList<DeveloperDTO>();
    for (Developer dev : devList) {
      myDevs.add(new DeveloperDTO(dev));
    }
   
    return myDevs;
    
  }


}
