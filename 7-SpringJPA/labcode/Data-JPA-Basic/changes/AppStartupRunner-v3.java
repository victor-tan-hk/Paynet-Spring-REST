package com.workshop.jpa;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Sort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AppStartupRunner implements CommandLineRunner {

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
    Page<Developer> pagedResult;
    Iterable<Developer> devs;
    
    int pageNo = 1;
    int pageSize = 10; 
    log.info("Attempting to retrieve a page at page no : " + pageNo + " with a page size of : " + pageSize);

    paging = PageRequest.of(pageNo, pageSize);
    pagedResult = basicRepo.findAll(paging);
    
    if (pagedResult.hasContent()) {
      devs = pagedResult.getContent();
      showDevelopers(devs);
    } else 
      log.info("There is no content for that particular page");
    
    
    log.info("Sorting the entire table by the name column");
    devs = basicRepo.findAll(Sort.by("name"));
    showDevelopers(devs);

    pageNo = 1;
    pageSize = 5; 
    log.info("Sorting the entire table first on name column");
    log.info("Then retrieving a page at page no : " + pageNo + " with a page size of : " + pageSize + " from the sorted results");
    
    paging = PageRequest.of(pageNo, pageSize, Sort.by("name"));
    
    pagedResult = basicRepo.findAll(paging);
    if (pagedResult.hasContent()) {
      devs = pagedResult.getContent();
      showDevelopers(devs);
    } else 
      log.info("There is no content for that particular page");
    
    
    log.info("Sorting the page content by the age column in ascending order");
    log.info("Then retrieving a page at page no : " + pageNo + " with a page size of : " + pageSize + " from the sorted results");
    
    paging = PageRequest.of(pageNo, pageSize, Sort.by("age").ascending());
    
    pagedResult = basicRepo.findAll(paging);
    
    if (pagedResult.hasContent()) {
      devs = pagedResult.getContent();
      showDevelopers(devs);
    } else 
      log.info("There is no content for that particular page");

    
    log.info("Sorting the entire table with primary sort on name and secondary sort on age in ascending order");
    
    Sort nameSort = Sort.by("name");
    Sort ageSort = Sort.by("age");
    Sort groupBySort = nameSort.and(ageSort);
    
    devs = basicRepo.findAll(groupBySort);
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