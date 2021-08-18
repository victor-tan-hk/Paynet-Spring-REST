package com.workshop.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyRestService {

  private static final Logger logger = LoggerFactory.getLogger(MyRestService.class);

  @Autowired
  private RestTemplate myRestTemplate;

  @Value("${myrest.url}")
  private String restUrl;

  public Resume getSingleResume() {
    String finalUrl = restUrl + "/resume";
    logger.info("GET to " + finalUrl);
    Resume myResume = myRestTemplate.getForObject(finalUrl, Resume.class);
    return myResume;
  }
  
  public void postSingleResume(Resume res) {
    String finalUrl = restUrl + "/resume";
    logger.info("POST to " + finalUrl);
    myRestTemplate.postForObject(finalUrl, res, Resume.class);
    
  }
  
  public void putSingleResume(Resume res) {
    String finalUrl = restUrl + "/resume";
    logger.info("PUT to " + finalUrl);
    myRestTemplate.put(finalUrl, res);
  }
  
  public void deleteSingleResume() {
    String finalUrl = restUrl + "/resume";
    logger.info("DELETE to " + finalUrl);
    myRestTemplate.delete(finalUrl);
  }

}