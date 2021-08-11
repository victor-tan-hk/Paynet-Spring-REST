package com.workshop.rest;

import java.net.URI;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/api")
public class HeaderController {
  
  private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
  
  @Autowired
  Employee myEmployee;
  
  @Autowired
  Resume myResume;
  
  // Retrieving specific headers using @RequestHeader
  @GetMapping("/header-first")
  public void firstHeader(@RequestHeader("User-Agent") String agent, @RequestHeader("Host") String host) {
    
    logger.info("firstHeader called");
    logger.info("User-Agent : " + agent);
    logger.info("Host : " + host);

  }
  
  // Retrieving collection of headers using HttpHeaders
  @GetMapping("/header-second")
  public void secondHeader(@RequestHeader HttpHeaders allHeaders) {
    
    logger.info("secondHeader called");
    logger.info("Connection : " + allHeaders.getConnection());
    logger.info("Host : " + allHeaders.getHost());

  }    
  
  // Retrieving collection of headers using Map
  @GetMapping("/header-third")
  public void thirdHeader(@RequestHeader Map<String,String> allHeaders) {
    
    logger.info("thirdHeader called");
    for (Map.Entry<String, String> entry : allHeaders.entrySet())
      logger.info("Header = " + entry.getKey() + ", Value = " + entry.getValue());    

  }
  
  // Optional header
  @GetMapping("/header-fourth")
  public void fourthHeader(@RequestHeader(value = "hero", required = false) String myHero) {
    
    logger.info("fourthHeader called");
    if (myHero != null)
      logger.info("hero : " + myHero);
    else
      logger.info("No hero in header");

  }  
  
  // Default header value
  @GetMapping("/header-fifth")
  public void fifthHeader(@RequestHeader(value = "job", defaultValue = "developer") String myJob) {
    
    logger.info("fifthHeader called");
    logger.info("Job : " + myJob);

  }    
 
  
  @GetMapping("/header-sixth")
  public void sixthHeader(HttpServletResponse response) {
    
    logger.info("sixthHeader called");
    response.addHeader("hero", "spiderman");

  }    
  
  @GetMapping("/header-seventh")
  public ResponseEntity<Resume> seventhHeader() {
    
    logger.info("seventhHeader called");
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.set("job", "developer");
    return ResponseEntity.ok().headers(responseHeaders).body(myResume);

  }
  
  @PostMapping("/header-eighth")
  public ResponseEntity<Object> eigthHeader() {
    
    logger.info("eigthHeader called");
    
    // Assume that the new resource is given the unique id 888
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(888).toUri();
    
    return ResponseEntity.created(location).build();

  }
  
  
  @GetMapping("/filter-header/first")
  public void firstFilterHeader() {
    
    logger.info("firstFilterHeader called");

  }    
 
  @GetMapping("/filter-header/second")
  public void secondFilterHeader() {
    
    logger.info("secondFilterHeader called");

  }    
  
}

