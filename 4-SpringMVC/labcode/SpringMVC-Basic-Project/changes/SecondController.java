package com.workshop.mvc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/stuff")
public class SecondController {

  private static final Logger LOGGER = 
      LogManager.getLogger(SecondController.class.getName());

  @RequestMapping("/interesting")
  public String showInterestingPage() {
    
    LOGGER.info("Inside showInterestingPage in SecondController");

    return "awesome";
  }

  @RequestMapping("/fancy/pants")
  public String showFancyPage() {
    
    LOGGER.info("Inside showFancyPage in SecondController");

    return "fancy";
  }
  
  
  @RequestMapping(value={"/cool","/reallycool"})
  public String multiplePathMaps() {
    
    LOGGER.info("Inside multiplePathMaps in SecondController");

    return "cool";
  }
  

}
