package com.workshop.rest;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private MyRestService myRestService;

    @Override
    public void run(String... args) throws Exception {
      
      Developer dev = null;
      Developer[] devs = null;
      
      Developer dev1 = new Developer(0,"Flora",65,new String[] {"Erlang","C++","Java"},true);
      Developer dev2 = new Developer(0,"Albert",42,new String[] {"Python"},false);
      
      logger.info("Started MyRunner");
      
      waitKeyPress();
      
      devs = myRestService.getAllDevelopers();
      logger.info("Retrieved " + devs.length + " developers ..");
      showDevelopers(devs);

      waitKeyPress();

      logger.info(myRestService.getDeveloper(2).toString());

      waitKeyPress();
      
      logger.info("Storing 2 new developers");
      String urlForDev1 = myRestService.addDeveloper(dev1);
      String urlForDev2 = myRestService.addDeveloper(dev2);
      logger.info("Developer 1 stored at : " + urlForDev1);
      logger.info("Developer 2 stored at : " + urlForDev2);
      
      waitKeyPress();

      devs = myRestService.getAllDevelopers();
      logger.info("Retrieved " + devs.length + " developers ..");
      showDevelopers(devs);

      waitKeyPress();
      
      logger.info("Locating developers who can write Java");
      showDevelopers(myRestService.filterLanguage("Java"));

      waitKeyPress();

      logger.info("Locating developers who are single");
      showDevelopers(myRestService.filterMarried(false));

      waitKeyPress();

      logger.info("Locating developers who are 35 years or older");
      showDevelopers(myRestService.filterAge(">", 35));

      waitKeyPress();

      logger.info("Locating developers who are 50 years or younger");
      showDevelopers(myRestService.filterAge("<", 50));
      
      waitKeyPress();
      
      logger.info("Showing a total of 3 developers starting from developer #2");
      showDevelopers(myRestService.ResultPagination(3, 2));
      
      waitKeyPress();
      
      logger.info("Modifying details for developer #3");
      Developer dev3 = myRestService.getDeveloper(3);
      logger.info(dev3.toString());

      logger.info("increase age by 10 and change marital status");
      dev3.setAge(dev3.getAge() + 10);
      dev3.setMarried(!dev3.isMarried());
      
      myRestService.modifyDeveloper(dev3, 3);
      logger.info(myRestService.getDeveloper(3).toString());

      waitKeyPress();

      logger.info("Deleting developer #2 and #4");
      myRestService.deleteDeveloper(2);
      myRestService.deleteDeveloper(4);
      
      devs = myRestService.getAllDevelopers();
      logger.info("Retrieved " + devs.length + " developers ..");
      showDevelopers(devs);


      logger.info("Application complete !");
    }
    
    private void showDevelopers(Developer[] devs) {
      for (Developer dev: devs) {
        logger.info(dev.toString());
      }
    }
    
    private void waitKeyPress() {
      logger.info("Press enter to continue ....");
      Scanner scanner = new Scanner(System.in);
      scanner.nextLine();
      logger.info("\n");
      //scanner.close();
    }
}