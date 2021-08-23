package com.workshop.jpa;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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
    
    Iterable<Developer> devs;
    
    log.info("Single developers older than 50");
    devs = basicRepo.getAllTheOldLonelyDevs();
    showDevelopers(devs);

    log.info("The youngest developer is " + basicRepo.whoIsYoungestDev() + " years old !");
    waitKeyPress(); 

    log.info("Developers younger than 30 who can code in PHP");
    devs = basicRepo.whoAreTheCoolDevs(30, "php");
    showDevelopers(devs);
    
    log.info("The number of developers who can code in Java : " + basicRepo.getNumOfLanguagePros("java"));
    waitKeyPress(); 

    int pageNo = 3;
    int pageSize = 5; 
    log.info("Attempting to retrieve a page at page no : " + pageNo + " with a page size of : " + pageSize + " from the devs sorted by age");

    Pageable paging = PageRequest.of(pageNo, pageSize);
    devs = basicRepo.findAllDevsSortedOnAgeWithPagination(paging);
    showDevelopers(devs);
    
    log.info("Developers who are not married");
    devs=basicRepo.findAllSingleDevelopers();
    showDevelopers(devs);
    
    log.info("Developers who are older than 40 and can code in Python");
    devs = basicRepo.whoAreTheBoringDevs(40,"python");
    showDevelopers(devs);
    
    log.info("Attempting to retrieve a page at page no : " + pageNo + " with a page size of : " + pageSize + " from the devs sorted by name");
    devs = basicRepo.findAllDevsSortedOnNameWithPagination(paging);
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