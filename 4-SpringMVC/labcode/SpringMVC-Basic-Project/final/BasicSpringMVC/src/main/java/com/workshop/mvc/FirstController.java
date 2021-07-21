package com.workshop.mvc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class FirstController {

  private static final Logger LOGGER = 
      LogManager.getLogger(FirstController.class.getName());

  @RequestMapping("/")
  public String showLandingPage() {
    
    LOGGER.info("Inside showLandingPage in FirstController");

    return "main-menu";
  }

  @RequestMapping("/first")
  public String showFirstPage() {
    
    LOGGER.info("Inside showFirstPage in FirstController");

    return "awesome";
  }

  @RequestMapping("/firstform")
  public String showFirstForm() {
    
    LOGGER.info("Inside showFirstForm in FirstController");

    return "first-form";
  }

}
