package com.workshop.rest;

import java.util.HashMap;
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
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MyRestService {

  private static final Logger logger = LoggerFactory.getLogger(MyRestService.class);

  @Autowired
  private RestTemplate myRestTemplate;

  @Value("${myrest.url}")
  private String restUrl;
  
  public void sendQueryParameters() {
    String finalUrl = restUrl + "/second";
    logger.info("GET to " + finalUrl);
    
    UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(finalUrl)
        .queryParam("person", "spiderman")
        .queryParam("age", "37");

    myRestTemplate.getForObject(uriBuilder.toUriString(), Resume.class);
  }

  public void sendPathParameters() {
    String finalUrl = restUrl + "/eighth/{name}/{age}";
    logger.info("GET to " + finalUrl); 
    
    Map<String, String> params = new HashMap<String, String>();
    params.put("age", "35");
    params.put("name", "thanos");

    myRestTemplate.getForObject(finalUrl, Resume.class, params);
    
  }
  
}