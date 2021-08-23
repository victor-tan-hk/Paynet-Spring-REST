package com.workshop.jpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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

    int idToFind = 10;
    if (basicRepo.existsById(idToFind))
      log.info("There is a row with the id : " + idToFind);
    else
      log.info("There is no row with the id : " + idToFind);

    log.info("Searching for the row with id : " + idToFind);
    Optional<Developer> findDev = basicRepo.findById(idToFind);
    if (findDev.isPresent())
      log.info(basicRepo.findById(idToFind).toString());
    else
      log.info("No row located at id " + idToFind);
    waitKeyPress();

    
    log.info("Retrieving the entire list of developers");
    Iterable<Developer> devs = basicRepo.findAll();
    for (Developer dev : devs) {
      log.info(dev.toString());
    }
    waitKeyPress();
    
    log.info("Deleting the last 3 records");
    basicRepo.deleteById((int) basicRepo.count()); // need to cast long to an int
    basicRepo.deleteById((int) basicRepo.count()); // need to cast long to an int
    basicRepo.deleteById((int) basicRepo.count()); // need to cast long to an int
    waitKeyPress();    

    log.info("Retrieving the entire list of developers");
    devs = basicRepo.findAll();
    showDevelopers(devs);

    
    int numRandDevs = 10;
    log.info("Adding in " + numRandDevs + " random developers");
    List<Developer> newDevs = generatorService.getRandomDevelopers(numRandDevs);
    for (Developer dev : newDevs) {
      basicRepo.save(dev);
    }
    log.info("There are now " + basicRepo.count() + " records in the repository");
    waitKeyPress();

    log.info("Retrieving the entire list of developers");
    devs = basicRepo.findAll();
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