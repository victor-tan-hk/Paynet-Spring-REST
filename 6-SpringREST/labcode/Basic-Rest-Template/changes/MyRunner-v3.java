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
      
      myRestService.getAndRetrieveHeaders();
      myRestService.getAndRetrieveHeadersAndBody();

    }
}