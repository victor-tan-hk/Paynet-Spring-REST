package com.workshop.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private MyRestService myRestService;

    @Override
    public void run(String... args) throws Exception {
      
      logger.info("Started MyRunner");
      
      Resume returnedResume = myRestService.getSingleResume();
      logger.info(returnedResume.toString());
      
      Resume newResume = new Resume("IIT", 3.99f, new String[] {"Hindi","Tamil"}, "Cool CEO", 15);
      myRestService.postSingleResume(newResume);   

      Resume anotherResume = new Resume("Oxford", 3.25f, new String[] {"English","French"}, "Studious tester", 6);

      myRestService.putSingleResume(anotherResume);
      myRestService.deleteSingleResume();

    }
}