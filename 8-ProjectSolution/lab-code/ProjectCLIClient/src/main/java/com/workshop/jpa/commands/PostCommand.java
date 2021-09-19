package com.workshop.jpa.commands;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import com.workshop.jpa.service.MyRestService;


@Component
@Command(name = "post", 
mixinStandardHelpOptions = true,
version = "v1.0",
description = "Execute Post REST API call to the countries REST service")
public class PostCommand implements Callable<Integer> {
  
  @Autowired
  private MyRestService restService;

  @Value("${myrest.url}")
  private String restUrl;
  
  @Parameters(index = "0", description = "The file with JSON content to send")
  private String fileName;
  
  
  @Override
  public Integer call() throws Exception {
    
    System.out.println("\n");

    
    if (fileName != null) {
      restService.postCountry(fileName);
    }
     
    return 0;

  }
}