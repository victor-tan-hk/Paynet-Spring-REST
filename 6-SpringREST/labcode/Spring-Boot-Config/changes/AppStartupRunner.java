package com.workshop.boot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class AppStartupRunner implements ApplicationRunner {
	
    @Value("${team.name}")
    private String myTeam;
	
    private static final Logger logger = LoggerFactory.getLogger(AppStartupRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
    	logger.info("Startup logic in ApplicationRunner implementation");
        logger.info("Your application started with option names : {}", args.getOptionNames());
        
        for (String name : args.getOptionNames()){
            logger.info("Option - " + name + " = " + args.getOptionValues(name));
        }
        
        logger.info("The team I am rooting is for : " + myTeam);
    }
}
