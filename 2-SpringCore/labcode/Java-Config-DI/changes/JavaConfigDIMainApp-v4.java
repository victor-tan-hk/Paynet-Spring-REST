package com.workshop.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDIMainApp {
  
  public static void main(String[] args) {

    // initialize IoC container with metadata from @Configuration class
    AnnotationConfigApplicationContext context = 
        new AnnotationConfigApplicationContext(MainConfig.class);
        
    // retrieve bean from IoC container
    Student myStudent = context.getBean("highSchoolStudent", Student.class);
    
    // call method on the beans
    myStudent.dailyActivity();

    // close the context
    context.close();
  }

}
