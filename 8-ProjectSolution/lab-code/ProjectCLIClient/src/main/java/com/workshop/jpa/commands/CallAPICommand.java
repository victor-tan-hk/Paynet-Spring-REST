package com.workshop.jpa.commands;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Component;

import picocli.CommandLine.Command;
import picocli.CommandLine.HelpCommand;

@Component
@Command(
    name="callapi",
    mixinStandardHelpOptions = true,
    version = "v1.0",
    description = "Makes REST API calls to the countries REST service",
    subcommands = {
        GetCommand.class,
        PostCommand.class,
        DeleteCommand.class,
        PatchCommand.class,
        PutCommand.class,
        HelpCommand.class
    }
  )
public class CallAPICommand implements Callable<Integer> {
  

    @Override
    public Integer call() throws Exception {
      
      System.out.println("\nFor more info, type: help");
      return 0;

    }
}