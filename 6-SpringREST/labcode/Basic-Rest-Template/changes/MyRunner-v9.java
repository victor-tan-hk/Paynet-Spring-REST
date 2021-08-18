package com.workshop.rest;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MyRunner implements CommandLineRunner {

    @Autowired
    private MyRestService myRestService;

    @Override
    public void run(String... args) throws Exception {
      
      Developer[] devs = null;
      
      Developer dev1 = new Developer(0,"Flora",65,new String[] {"Erlang","C++","Java"},true);
      Developer dev2 = new Developer(0,"Albert",42,new String[] {"Python"},false);
      
      log.info("Started MyRunner");
      
      waitKeyPress();
      
      devs = myRestService.getAllDevelopers();
      log.info("Retrieved " + devs.length + " developers ..");
      showDevelopers(devs);

      waitKeyPress();

      log.info(myRestService.getDeveloper(2).toString());

      waitKeyPress();
      
      log.info("Storing 2 new developers");
      String urlForDev1 = myRestService.addDeveloper(dev1);
      String urlForDev2 = myRestService.addDeveloper(dev2);
      log.info("Developer 1 stored at : " + urlForDev1);
      log.info("Developer 2 stored at : " + urlForDev2);
      
      waitKeyPress();

      devs = myRestService.getAllDevelopers();
      log.info("Retrieved " + devs.length + " developers ..");
      showDevelopers(devs);

      waitKeyPress();
      
      log.info("Locating developers who can write Java");
      showDevelopers(myRestService.filterLanguage("Java"));

      waitKeyPress();

      log.info("Locating developers who are single");
      showDevelopers(myRestService.filterMarried(false));

      waitKeyPress();

      log.info("Locating developers who are 35 years or older");
      showDevelopers(myRestService.filterAge(">", 35));

      waitKeyPress();

      log.info("Locating developers who are 50 years or younger");
      showDevelopers(myRestService.filterAge("<", 50));
      
      waitKeyPress();
      
      log.info("Showing a total of 3 developers starting from developer #2");
      showDevelopers(myRestService.ResultPagination(3, 2));
      
      waitKeyPress();
      
      log.info("Modifying details for developer #3");
      Developer dev3 = myRestService.getDeveloper(3);
      log.info(dev3.toString());

      log.info("increase age by 10 and change marital status");
      dev3.setAge(dev3.getAge() + 10);
      dev3.setMarried(!dev3.isMarried());
      
      myRestService.modifyDeveloper(dev3, 3);
      log.info(myRestService.getDeveloper(3).toString());

      waitKeyPress();

      log.info("Deleting developer #2 and #4");
      myRestService.deleteDeveloper(2);
      myRestService.deleteDeveloper(4);
      
      devs = myRestService.getAllDevelopers();
      log.info("Retrieved " + devs.length + " developers ..");
      showDevelopers(devs);


      log.info("Application complete !");
    }
    
    private void showDevelopers(Developer[] devs) {
      for (Developer dev: devs) {
        log.info(dev.toString());
      }
    }
    
    private void waitKeyPress() {
      log.info("Press enter to continue ....");
      Scanner scanner = new Scanner(System.in);
      scanner.nextLine();
      log.info("\n");
      //scanner.close();
    }
}