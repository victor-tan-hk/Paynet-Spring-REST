package com.workshop.rest;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.converter.HttpMessageNotReadableException;

@ControllerAdvice
public class SampleControllerExceptionHandler {

  private static final Logger logger = LoggerFactory.getLogger(SampleControllerExceptionHandler.class);

  // Handles common Java-related exceptions
  @ExceptionHandler(ArithmeticException.class) 
  public void handleMathError() {
    
    logger.info("exception handling logic to handle arithmetic exception");
    
  }
  
  // Handles user-defined custom exceptions
  @ExceptionHandler(AnotherCustomException.class) 
  public ResponseEntity<CustomErrorMessage> handleCustomException(AnotherCustomException acex) {
    
    logger.info("exception handling logic to handle custom exception");

    HttpStatus statusToReturn = HttpStatus.NOT_FOUND;
    String messageToReturn = acex.getMessage();

    // Additional specialized info to return
    int localErrorId = 666;
    String urlToConsult = "https://developer.twitter.com/en/support/twitter-api/error-troubleshooting";
    
    CustomErrorMessage newMessage = new CustomErrorMessage(new Date(), statusToReturn.value(), statusToReturn.toString(), messageToReturn, localErrorId, urlToConsult);
    
    return new ResponseEntity<CustomErrorMessage>(newMessage, statusToReturn);
  }
    
  // Handles Spring framework exceptions
  @ExceptionHandler(HttpMessageNotReadableException.class) 
  public ResponseEntity<CustomErrorMessage> handleSpringFrameworkException (HttpMessageNotReadableException mnrex) {
    
    logger.info("exception handling logic to handle Spring framework exceptions");

    HttpStatus statusToReturn = HttpStatus.BAD_REQUEST;
    String messageToReturn = "Your JSON was malformed. Please check it again";

    // Additional specialized info to return
    int localErrorId = 111;
    String urlToConsult = "https://developer.twitter.com/en/support/twitter-api/error-troubleshooting";
    
    CustomErrorMessage newMessage = new CustomErrorMessage(new Date(), statusToReturn.value(), statusToReturn.toString(), messageToReturn, localErrorId, urlToConsult);
    
    return new ResponseEntity<CustomErrorMessage>(newMessage, statusToReturn);    
    
    
  }
  
  
  
}
