package com.workshop.rest;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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

  
  
  public void includeHTTPHeadersInRequest(Resume res) {
    
    String finalUrl = restUrl + "/header-third";
    logger.info("GET to " + finalUrl);
    
    HttpHeaders headers = new HttpHeaders();
    headers.set("hero", "spiderman");  
    headers.set("age", "33");  

    HttpEntity<Resume> requestEntity = new HttpEntity<>(res,headers);
    ResponseEntity<Resume> response = myRestTemplate.exchange(finalUrl, HttpMethod.GET, requestEntity, Resume.class);

    // Code to extract headers, status and body from ResponseEntity
    // similar to previous example

    
  }

}