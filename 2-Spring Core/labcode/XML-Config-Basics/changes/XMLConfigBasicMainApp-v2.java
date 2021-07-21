package com.workshop.configxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLConfigBasicMainApp {
  
  public static void main(String[] args) {

    // load from two different configuration files to initialize IoC container
    ClassPathXmlApplicationContext context = 
        new ClassPathXmlApplicationContext("beansDefinition.xml", "backupDefinition.xml");
        
    // retrieve beans from IoC container
    Exercise firstExercise = context.getBean("favouriteExercise", Exercise.class);
    Exercise secondExercise = context.getBean("backupExercise", Exercise.class);
    
    // call methods on beans
    firstExercise.doExercise();
    secondExercise.doExercise();
    
    // close the context
    context.close();
  }

  

}
