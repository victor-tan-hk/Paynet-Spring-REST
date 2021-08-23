package com.workshop.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
  private static final String PAGE_PARAM = "param";
  
  
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
    
    List<DeveloperDTO> listToReturn = new ArrayList<DeveloperDTO>();
    if (allParams.size() == 0)
      return getAllDevelopers();
    else {
      
      for (Map.Entry<String, String> entry : allParams.entrySet()) {
        log.info(entry.getKey() + " : " + entry.getValue());
        if (entry.getKey().equals(LANGUAGE_PARAM)) {
          langValue = entry.getValue();
        } else if (entry.getKey().equals(MARRIED_PARAM)) {
          marriedValue = entry.getValue();
          if (!(marriedValue.toLowerCase().equals("true") || marriedValue.toLowerCase().equals("false")))
            throw new IncorrectURLFormatException( MARRIED_PARAM + " must be either true or false ");
        }
      
      }
      
      if (langValue != null && marriedValue != null) {
        
        log.info("Retrieving all developers who can code in : " +langValue + " with marital status : " + marriedValue);
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
