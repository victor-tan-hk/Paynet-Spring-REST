package com.workshop.jpa;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class H2StartupRunner implements CommandLineRunner {


  @Override
  public void run(String... args) throws Exception {
    log.info("Startup logic in CommandLineRunner implementation");
    

  }
  

    
}