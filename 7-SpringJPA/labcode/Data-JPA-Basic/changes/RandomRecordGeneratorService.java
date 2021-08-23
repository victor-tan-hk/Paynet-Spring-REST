package com.workshop.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RandomRecordGeneratorService {
  
  @Value("${options.languages}")
  private String[]  languageList;
  
  @Value("${options.names}")
  private String[]  nameList;
  
  public void showValuesFromFile() {
    
    log.info("Languages list");
    for (String lang: languageList) {
      log.info(lang);
    }

    log.info("Names list");
    for (String lang: nameList) {
      log.info(lang);
    }

  }
  
  public List<Developer> getRandomDevelopers(int num) {
    
    String name;
    int numLanguages;
    String languages;
    int age;
    int valMarriage;
    Boolean married;
    
    List<Developer> developers = new ArrayList<Developer>();
    
    for (int devCount = 0; devCount < num; devCount++) {
      
      name = nameList[getRandomNumber(0,nameList.length)];
      
      numLanguages = getRandomNumber(1,5);
      languages = "";
      
      List<String> tempList = new ArrayList<String>();
      for (String lang : languageList) {
        tempList.add(new String(lang));
      }
      
      for (int i = 0; i < numLanguages; i++) {
        int randLanguage = getRandomNumber(0,tempList.size());
        if (i == numLanguages - 1)
          languages += tempList.get(randLanguage);
        else 
          languages += tempList.get(randLanguage) + ",";
        tempList.remove(randLanguage);
      }
      
      age = getRandomNumber(20, 61);
      
      married = false;
      valMarriage = getRandomNumber(0,2);
      if (valMarriage == 0)
        married = true;

      Developer randomDev = new Developer(0,name,age,languages,married);
      developers.add(randomDev);
    }
    
    return developers;
    
  }
  
  private int getRandomNumber(int min, int max) {
    Random random = new Random();
    return random.nextInt(max - min) + min;  
  }

}
