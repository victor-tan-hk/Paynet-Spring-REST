package com.workshop.jpa.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.converter.HttpMessageNotReadableException;

import com.workshop.jpa.dto.CustomErrorMessage;
import com.workshop.jpa.exception.IncorrectJSONFormatException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class DeveloperControllerExceptionHandler {

  
  private static final String urlToConsult = "https://www.awesomecompany.com/support/api/docs";

  
  // Handles incorrect JSON format
  @ExceptionHandler(IncorrectJSONFormatException.class) 
  public ResponseEntity<CustomErrorMessage> handleCustomException(IncorrectJSONFormatException ijfe) {
    
    log.info("Exception handling logic to handle incorrect JSON format");

    HttpStatus statusToReturn = HttpStatus.BAD_REQUEST;
    String messageToReturn = ijfe.getMessage();

    // Additional specialized info to return
    int localErrorId = 666;
    
    CustomErrorMessage newMessage = new CustomErrorMessage(new Date(), statusToReturn.value(), statusToReturn.toString(), messageToReturn, localErrorId, urlToConsult);
    
    return new ResponseEntity<CustomErrorMessage>(newMessage, statusToReturn);
  }
    
  
  // Handles Spring framework exceptions
  @ExceptionHandler(HttpMessageNotReadableException.class) 
  public ResponseEntity<CustomErrorMessage> handleSpringFrameworkException (HttpMessageNotReadableException mnrex) {
    
    log.info("Exception handling logic to handle Spring framework exceptions");

    HttpStatus statusToReturn = HttpStatus.BAD_REQUEST;
    String messageToReturn = "Your JSON was malformed. Please check it again";

    // Additional specialized info to return
    int localErrorId = 111;
    
    CustomErrorMessage newMessage = new CustomErrorMessage(new Date(), statusToReturn.value(), statusToReturn.toString(), messageToReturn, localErrorId, urlToConsult);
    
    return new ResponseEntity<CustomErrorMessage>(newMessage, statusToReturn);    
    
  }
  
  
}
