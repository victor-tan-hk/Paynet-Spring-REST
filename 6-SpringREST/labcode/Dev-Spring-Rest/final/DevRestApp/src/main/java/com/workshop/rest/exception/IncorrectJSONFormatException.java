package com.workshop.rest.exception;

public class IncorrectJSONFormatException extends RuntimeException {
  
  public IncorrectJSONFormatException(String message) {
    super(message);
  }


}