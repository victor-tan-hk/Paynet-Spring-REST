package com.workshop.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.jpa.dto.DeveloperDTO;
import com.workshop.jpa.exception.IncorrectJSONFormatException;
import com.workshop.jpa.model.Developer;
import com.workshop.jpa.repository.DeveloperRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DeveloperService {
  
  @Autowired
  private DeveloperRepository devRepo;
  
  public List<DeveloperDTO> getAllDevelopers() {
    
    List<DeveloperDTO> myDevs = new ArrayList<DeveloperDTO>();
    Iterable<Developer> devList = devRepo.findAll();
    log.info("Retrieved developers from database");
    for (Developer dev : devList) {
      myDevs.add(new DeveloperDTO(dev));
    }
   
    return myDevs;
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
  
  private boolean isDeveloperValid(DeveloperDTO devDTO) {
    
    return (devDTO.getName() != null &&
        devDTO.getAge() != null &&
        devDTO.getLanguages() != null &&
        devDTO.getMarried() != null);
    
  }


}
