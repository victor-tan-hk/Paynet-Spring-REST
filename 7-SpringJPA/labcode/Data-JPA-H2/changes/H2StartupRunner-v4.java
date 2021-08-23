package com.workshop.jpa;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class H2StartupRunner implements CommandLineRunner {

  @Autowired
  private BasicRepository basicRepo;

  @Autowired
  private RandomRecordGeneratorService generatorService;

  @Override
  public void run(String... args) throws Exception {
    log.info("Startup logic in CommandLineRunner implementation");

    log.info("The database table Developers has " + basicRepo.count() + " rows");
    waitKeyPress();
    
    Pageable paging; 
    Iterable<Developer> devs;
    
    String nameToFind = "Michael";
    
    log.info("There are a total of : " + basicRepo.countByName(nameToFind) + " developers with name : " + nameToFind);
    log.info("Retrieving developers with name : " + nameToFind);
    devs = basicRepo.findByName(nameToFind);
    showDevelopers(devs);
    
    log.info("The first 3 devs with the name of : " + nameToFind);
    devs = basicRepo.findFirst3ByName(nameToFind);
    showDevelopers(devs);
    
    int ageToFind = 54;
    log.info("Retrieving developers with age : " + ageToFind);
    devs = basicRepo.findByAge(ageToFind);
    showDevelopers(devs);
    
    ageToFind = 46;
    nameToFind = "Peter";
    log.info("Retrieving developers with name : " + nameToFind + " and age : " + ageToFind);
    devs = basicRepo.findByNameAndAge(nameToFind, ageToFind);
    showDevelopers(devs);

    
    String langToFind = "Python";
    log.info("Retrieving developers who can code in : " + langToFind);
    devs = basicRepo.findByLanguagesContaining(langToFind);
    showDevelopers(devs);
    
    
    ageToFind = 49;
    log.info("Retrieving developers who are same or older than : " + ageToFind);
    devs = basicRepo.findByAgeGreaterThanEqual(ageToFind);
    showDevelopers(devs);
    
    
    ageToFind = 33;
    log.info("Retrieving developers who are younger than : " + ageToFind);
    devs = basicRepo.findByAgeLessThan(ageToFind);
    showDevelopers(devs);
    
    int topAge = 40;
    log.info("Retrieving developers between the age of " + ageToFind + "  and " + topAge);
    devs = basicRepo.findByAgeBetween(ageToFind, topAge);
    showDevelopers(devs);

    
    log.info("Retrieving developers who are younger than : " + ageToFind + " and can code in  : " + langToFind);
    devs = basicRepo.findByAgeLessThanAndLanguagesContaining(ageToFind, langToFind);
    showDevelopers(devs);
    
    
    nameToFind = "Michael";
    log.info("Retrieving developers who are named : " + nameToFind + " sorted on age in ascending order");
    devs = basicRepo.findByNameOrderByAgeAsc(nameToFind);
    showDevelopers(devs);
    
    
    log.info("Retrieving developers who can code in : " + langToFind);
    log.info("Primary sort on name ascending, secondary sort on age descending");
    devs = basicRepo.findByLanguagesContainingOrderByNameAscAgeDesc(langToFind);
    showDevelopers(devs);

    
    int pageNo = 1;
    int pageSize = 5; 
    paging = PageRequest.of(pageNo, pageSize);
    log.info("Retrieving developers who are married");
    log.info("Getting page : " + pageNo + " for a page size of : " + pageSize);
    devs = basicRepo.findAllByMarried(true, paging);
    showDevelopers(devs);

  }

  private void waitKeyPress() {
    log.info("Press enter to continue ....");
    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();
    log.info("\n");
    // scanner.close();
  }
  
  private void showDevelopers(Iterable<Developer> devs) {
    for (Developer dev : devs) {
      log.info(dev.toString());
    }
    waitKeyPress(); 
  }

}