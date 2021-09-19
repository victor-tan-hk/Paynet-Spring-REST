package com.workshop.jpa.commands;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.workshop.jpa.service.MyRestService;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Component
@Command(name = "delete", 
mixinStandardHelpOptions = true,
version = "v1.0",
description = "Execute Delete REST API call to the countries REST service")
public class DeleteCommand implements Callable<Integer> {
  
  @Autowired
  private MyRestService restService;

  @Value("${myrest.url}")
  private String restUrl;
  
  @Parameters(index = "0", description = "The name of the country to delete")
  private String name;

  @Override
  public Integer call() throws Exception {
    
    System.out.println("\n");

    
    if (name != null)
      restService.deleteCountry(name);
    return 0;
  }

}
