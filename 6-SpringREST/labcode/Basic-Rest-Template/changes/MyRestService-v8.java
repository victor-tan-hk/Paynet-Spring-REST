package com.workshop.rest;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MyRestService {

  private static final Logger logger = LoggerFactory.getLogger(MyRestService.class);

  @Autowired
  private RestTemplate myRestTemplate;

  @Value("${myrest.url}")
  private String restUrl;
  
  
  // GET /api/developers
  public Developer[] getAllDevelopers() {
    
    String finalUrl = restUrl;
    logger.info("GET to " + finalUrl);
    return myRestTemplate.getForObject(finalUrl, Developer[].class);
    
  }
  
  // GET /api/developers/{id}
  public Developer getDeveloper(int id) {

    String finalUrl = restUrl +"/" + id;
    logger.info("GET to " + finalUrl);
    return myRestTemplate.getForObject(finalUrl, Developer.class);
  
  }

  // GET /api/developers?language=XXX
  public Developer[] filterLanguage(String language) {
    
    UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(restUrl)
        .queryParam("language", language);
        
    String finalUrl = uriBuilder.toUriString();
    logger.info("GET to " + finalUrl);
    
    return myRestTemplate.getForObject(finalUrl, Developer[].class);

  }
  
  
  // GET  /api/developers?married=XXX
  public Developer[] filterMarried(boolean isMarried) {
    
    UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(restUrl)
        .queryParam("married", isMarried);
    
    String finalUrl = uriBuilder.toUriString();
    logger.info("GET to " + finalUrl);
    
    return myRestTemplate.getForObject(finalUrl, Developer[].class);

  }
  
  // GET /api/developers?age>XX|age<XX
  public Developer[] filterAge(String symbol, int age) {
    
    String finalUrl = restUrl + "?age" + symbol + "" + age;
    logger.info("GET to " + finalUrl);

    return myRestTemplate.getForObject(finalUrl, Developer[].class);

  }
  
  
  // GET /api/developers?limit=X&start=Y   
  public Developer[] ResultPagination(int limit, int start) {
    
    UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(restUrl)
        .queryParam("limit", limit)
        .queryParam("start", start);
    
    String finalUrl = uriBuilder.toUriString();
    logger.info("GET to " + finalUrl);
    
    return myRestTemplate.getForObject(finalUrl, Developer[].class);

  }
  
  // POST  /api/developers
  public String addDeveloper(Developer dev) {
    
    String finalUrl = restUrl;
    logger.info("POST to " + finalUrl);
    
    URI destination = null;
    try {
      destination = new URI(finalUrl);
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    
    URI result = myRestTemplate.postForLocation(destination, dev);
    
    return result.toString();
  }
  
  // PUT /api/developers/{id}
  public void modifyDeveloper(Developer dev, int id) {
    
    String finalUrl = restUrl + "/" + id;
    logger.info("PUT to " + finalUrl); 
    
    URI destination = null;
    try {
      destination = new URI(finalUrl);
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }

    myRestTemplate.put(destination, dev);

  }
  
  // DELETE  /api/developers/{id}
  public void deleteDeveloper(int id) {
    
    String finalUrl = restUrl + "/" + id;
    logger.info("DELETE to " + finalUrl);
    
    URI destination = null;
    try {
      destination = new URI(finalUrl);
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }

    myRestTemplate.delete(destination);
    
  }
   
  
}