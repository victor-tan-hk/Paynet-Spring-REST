package com.workshop.mvc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/processFirstForm")
public class ThirdController {

  private static final Logger LOGGER = 
      LogManager.getLogger(ThirdController.class.getName());

  @RequestMapping(method = RequestMethod.GET)
  public String showGetPage() {
    
    LOGGER.info("Inside showGetPage in ThirdController");

    return "cool";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String showPostPage() {
    
    LOGGER.info("Inside showPostPage in ThirdController");

    return "fancy";
  }

}
