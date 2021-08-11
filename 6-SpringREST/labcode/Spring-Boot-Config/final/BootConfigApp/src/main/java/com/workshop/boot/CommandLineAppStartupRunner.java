package com.workshop.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
	
    private static final Logger logger =
      LoggerFactory.getLogger(CommandLineAppStartupRunner.class);

    @Override
    public void run(String...args) throws Exception {
    	logger.info("Startup logic in CommandLineRunner implementation");
    	
    	for (String str: args) {
        	logger.info("Argument : " + str);
    	}
    }
}