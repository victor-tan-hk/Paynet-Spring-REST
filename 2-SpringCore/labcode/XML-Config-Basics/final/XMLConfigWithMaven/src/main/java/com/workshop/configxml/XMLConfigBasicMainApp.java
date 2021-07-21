package com.workshop.configxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLConfigBasicMainApp {
  
  public static void main(String[] args) {

    // load the spring configuration file
    ClassPathXmlApplicationContext context = 
        new ClassPathXmlApplicationContext("beansDefinition.xml");
        
    // retrieve bean from spring container
    Exercise myExercise = context.getBean("favouriteExercise", Exercise.class);
    
    // call methods on the bean
    myExercise.doExercise();
    
    // close the context
    context.close();
  }

  

}
