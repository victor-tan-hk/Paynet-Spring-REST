package com.workshop.rest.exception;

public class DeveloperNotFoundException extends RuntimeException {
  
  public DeveloperNotFoundException(String message) {
    super(message);
  }


}