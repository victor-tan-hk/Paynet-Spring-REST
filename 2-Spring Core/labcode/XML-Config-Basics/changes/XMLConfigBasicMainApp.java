package com.workshop.configxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLConfigBasicMainApp {
  
  public static void main(String[] args) {

    // load from XML configuration file to initialize IoC container
    ClassPathXmlApplicationContext context = 
        new ClassPathXmlApplicationContext("beansDefinition.xml");
        
    // retrieve bean from IoC container
    Exercise myExercise = context.getBean("favouriteExercise", Exercise.class);
    
    // call methods on the bean
    myExercise.doExercise();
    
    // close the context
    context.close();
  }

  

}
