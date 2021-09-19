package com.workshop.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.workshop.jpa.commands.CallAPICommand;

import picocli.CommandLine;
import picocli.CommandLine.IFactory;

@SpringBootApplication
public class ProjectRestClientApplication implements CommandLineRunner {
  
  private IFactory factory;        
  private CallAPICommand callAPICommand; 
  private int exitCode;
  
  ProjectRestClientApplication(IFactory factory, CallAPICommand callAPICommand) {
    this.factory = factory;
    this.callAPICommand = callAPICommand;
  }

	public static void main(String[] args) {
    System.exit(SpringApplication.exit(SpringApplication.run(ProjectRestClientApplication.class, args)));

	}
	

  @Override
  public void run(String... args) {
    
    exitCode = new CommandLine(callAPICommand, factory).execute(args);
    System.exit(exitCode);
  
  }

  public int getExitCode() {
      return exitCode;
  }
}
