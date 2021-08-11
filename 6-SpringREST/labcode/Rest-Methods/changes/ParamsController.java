package com.workshop.rest;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ParamsController {

  private static final Logger logger = LoggerFactory.getLogger(ParamsController.class);

  @GetMapping("/first")
  public void firstMapping(@RequestParam String hero) {

    logger.info("FirstMapping: Hero : " + hero);

  }

  // different names for key and parameter with multiple request params
  @GetMapping("/second")
  public void secondMapping(@RequestParam(name = "person") String hero, @RequestParam Integer age) {

    logger.info("SecondMapping: Hero : " + hero + " is " + age + " years old");

  }

  // optional parameter
  @GetMapping("/third")
  public void thirdMapping(@RequestParam(required = false) String hero) {

    if (hero != null)
      logger.info("ThirdMapping: Hero : " + hero);
    else
      logger.info("ThirdMapping: No hero here !");
  }

  // default value
  @GetMapping("/fourth")
  public void fourthMapping(@RequestParam(defaultValue = "ironman") String hero) {

    logger.info("FourthMapping: Hero : " + hero);
  }

  // Obtain all key value pairs as a Map
  @GetMapping("/fifth")
  public void fifthMapping(@RequestParam Map<String, String> allParams) {
    logger.info("FifthMapping");
    for (Map.Entry<String, String> entry : allParams.entrySet())
      logger.info("Key = " + entry.getKey() + ", Value = " + entry.getValue());

  }

  // Multi-value parameters
  @GetMapping("/sixth")
  public void sixthMapping(@RequestParam List<String> heroes) {

    logger.info("SixthMapping");
    String myHeroes = "";
    for (String hero : heroes) {
      myHeroes += hero + " , ";
    }
    logger.info("Heroes are : " + myHeroes);

  }

  @GetMapping("/seventh/{name}")
  public void seventhMapping(@PathVariable String name) {

    logger.info("SeventhMapping : Name is : " + name);

  }

  // multiple path variables in a single request
  @GetMapping("/eighth/{name}/{age}")
  public void eighthMapping(@PathVariable String name, @PathVariable Integer age) {

    logger.info("EighthMapping : Name : " + name + " is " + age + " years old ");

  }
  
  // multiple path variables extracted through a Map
  @GetMapping("/ninth/{name}/{job}/{gender}")
  public void ninthMapping(@PathVariable Map<String, String> pathVarsMap) {
    
    logger.info("NinthMapping");
    for (Map.Entry<String, String> entry : pathVarsMap.entrySet())
      logger.info("Key = " + entry.getKey() + ", Value = " + entry.getValue());
    
  }
  
  // optional path variable
  @GetMapping(path = {"/tenth", "/tenth/{name}"})
  public void tenthMapping(@PathVariable(required=false) String name) {
    
    if (name != null)
      logger.info("TenthMapping : Name is : " + name);
    else
      logger.info("TenthMapping : No name given !");

  }  

}