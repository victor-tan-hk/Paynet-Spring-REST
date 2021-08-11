package com.workshop.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {
	
    @Value("${schoolName}")
    private String school;
	
	int numOfCalls = 1;

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @RequestMapping("/showlogs")
    public String index() {
    	
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
        
        String message = "Called " + numOfCalls++ + " times : The school is : " + school;

        return message;
    }
}