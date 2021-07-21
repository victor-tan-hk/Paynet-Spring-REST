package com.workshop.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDIMainApp {
  
  public static void main(String[] args) {

    // initialize IoC container with metadata from @Configuration class
    AnnotationConfigApplicationContext context = 
        new AnnotationConfigApplicationContext(MainConfig.class);
        
    // retrieve beans from IoC container
    Exercise  myExercise = context.getBean("swimmingExercise", Exercise.class);
    Student myStudent = context.getBean("collegeStudent", Student.class);

    // call methods on the bean
    myExercise.doExercise();
    myStudent.dailyActivity();

    // close the context
    context.close();
  }

}
