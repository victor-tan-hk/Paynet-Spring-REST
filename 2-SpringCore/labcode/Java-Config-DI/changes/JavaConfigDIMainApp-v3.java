package com.workshop.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDIMainApp {
  
  public static void main(String[] args) {

    // initialize IoC container with metadata from @Configuration class
    AnnotationConfigApplicationContext context = 
        new AnnotationConfigApplicationContext(MainConfig.class);
        
    // retrieve beans from IoC container
    Student myStudent = context.getBean("collegeStudent", Student.class);
    Exercise specificExercise = context.getBean("swimmingExercise", Exercise.class);
    Exercise  anyExercise = context.getBean(Exercise.class);
    
    // call methods on the beans
    specificExercise.doExercise();
    anyExercise.doExercise();
    myStudent.dailyActivity();

    // close the context
    context.close();
  }

}
