package com.workshop.configdi;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLConfigConstructorDIMainApp {
  
  public static void main(String[] args) {

    // load from two different configuration files
    ClassPathXmlApplicationContext context = 
        new ClassPathXmlApplicationContext("beansDefinition.xml");
        
    // retrieve bean from spring container
    Student firstStudent = context.getBean("highSchoolStudent", Student.class);
    
    // call methods on the bean
    firstStudent.dailyActivity();

    // close the context
    context.close();
  }

}
