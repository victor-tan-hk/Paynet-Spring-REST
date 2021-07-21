package com.workshop.setterdi;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLConfigSetterDIMainApp {
  
  public static void main(String[] args) {

    // load from XML configuration file to initialize IoC container
    ClassPathXmlApplicationContext context = 
        new ClassPathXmlApplicationContext("beansDefinition.xml");
        
    // retrieve bean from IoC container
    Student firstStudent = context.getBean("highSchoolStudent", Student.class);
    
    // call methods on the bean
    firstStudent.dailyActivity();

    // close the context
    context.close();
  }

}
