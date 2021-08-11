package com.workshop.rest.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.converter.HttpMessageNotReadableException;

import com.workshop.rest.exception.CustomErrorMessage;
import com.workshop.rest.exception.DeveloperNotFoundException;
import com.workshop.rest.exception.IncorrectJSONFormatException;

@ControllerAdvice
public class DeveloperControllerExceptionHandler {

  private static final Logger logger = LoggerFactory.getLogger(DeveloperControllerExceptionHandler.class);
  
  private static final String urlToConsult = "https://www.paynet.my/en/support/api/docs";


  
  // Handles incorrect JSON format
  @ExceptionHandler(IncorrectJSONFormatException.class) 
  public ResponseEntity<CustomErrorMessage> handleCustomException(IncorrectJSONFormatException ijfe) {
    
    logger.info("Exception handling logic to handle incorrect JSON format");

    HttpStatus statusToReturn = HttpStatus.BAD_REQUEST;
    String messageToReturn = ijfe.getMessage();

    // Additional specialized info to return
    int localErrorId = 666;
    
    CustomErrorMessage newMessage = new CustomErrorMessage(new Date(), statusToReturn.value(), statusToReturn.toString(), messageToReturn, localErrorId, urlToConsult);
    
    return new ResponseEntity<CustomErrorMessage>(newMessage, statusToReturn);
  }
  
  // Handles developer not found
  @ExceptionHandler(DeveloperNotFoundException.class) 
  public ResponseEntity<CustomErrorMessage> handleCustomException(DeveloperNotFoundException ijfe) {
    
    logger.info("Exception handling logic to handle developer not found");

    HttpStatus statusToReturn = HttpStatus.NOT_FOUND;
    String messageToReturn = ijfe.getMessage();

    // Additional specialized info to return
    int localErrorId = 333;
    
    CustomErrorMessage newMessage = new CustomErrorMessage(new Date(), statusToReturn.value(), statusToReturn.toString(), messageToReturn, localErrorId, urlToConsult);
    
    return new ResponseEntity<CustomErrorMessage>(newMessage, statusToReturn);
  }
  
    
  // Handles Spring framework exceptions
  @ExceptionHandler(HttpMessageNotReadableException.class) 
  public ResponseEntity<CustomErrorMessage> handleSpringFrameworkException (HttpMessageNotReadableException mnrex) {
    
    logger.info("Exception handling logic to handle Spring framework exceptions");

    HttpStatus statusToReturn = HttpStatus.BAD_REQUEST;
    String messageToReturn = "Your JSON was malformed. Please check it again";

    // Additional specialized info to return
    int localErrorId = 111;
    
    CustomErrorMessage newMessage = new CustomErrorMessage(new Date(), statusToReturn.value(), statusToReturn.toString(), messageToReturn, localErrorId, urlToConsult);
    
    return new ResponseEntity<CustomErrorMessage>(newMessage, statusToReturn);    
    
    
  }
  
  
  
}
