package com.workshop.rest;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyRestService {

  private static final Logger logger = LoggerFactory.getLogger(MyRestService.class);

  @Autowired
  private RestTemplate myRestTemplate;

  @Value("${myrest.url}")
  private String restUrl;

  
  public void getAndRetrieveHeaders() {
    
    String finalUrl = restUrl + "/header-sixth";
    logger.info("GET to " + finalUrl);
    
    ResponseEntity<Resume> response = myRestTemplate.getForEntity(finalUrl, Resume.class);

    HttpStatus code = response.getStatusCode();
    logger.info("Status code is : " + code);
    
    HttpHeaders headers = response.getHeaders();
    List<String>  headerValues = headers.get("hero"); 
    logger.info("Values for header : hero ");
    for (String temp: headerValues) {
      logger.info(temp);
    }
  }
  
  
  public void getAndRetrieveHeadersAndBody() {
    
    String finalUrl = restUrl + "/resume";
    logger.info("GET to " + finalUrl);
    
    ResponseEntity<Resume> response = myRestTemplate.getForEntity(finalUrl, Resume.class);
    
    Resume res = response.getBody();
    logger.info("Body is : " + res.toString());
    
    logger.info("Listing all headers : ");

    HttpHeaders headers = response.getHeaders();
    for (Map.Entry<String, List<String>> entry : headers.entrySet())
      logger.info("Header = " + entry.getKey() + ", Value = " + entry.getValue()); 
    
  }
  
  

}