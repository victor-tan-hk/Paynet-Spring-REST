package com.workshop.jpa.commands;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.workshop.jpa.service.MyRestService;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Component
@Command(name = "patch", 
mixinStandardHelpOptions = true,
version = "v1.0",
description = "Execute Patch REST API call to the countries REST service")
public class PatchCommand implements Callable<Integer> {
  
  @Autowired
  private MyRestService restService;

  @Value("${myrest.url}")
  private String restUrl;
  
  @Parameters(index = "0", description = "The country to do a PATCH on")
  private String countryName;
  
  @Parameters(index = "1", description = "The file with JSON content to send")
  private String fileName;

  @Override
  public Integer call() throws Exception {
    
    System.out.println("\n");

    
    if (fileName != null && countryName != null) {
      restService.patchCountry(countryName, fileName);
    }
     
    return 0;

  }



}
