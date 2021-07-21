package com.workshop.javaconfig;

import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDIMainApp {
  
  public static void main(String[] args) {

    // initialize IoC container with metadata from @Configuration class
    AnnotationConfigApplicationContext context = 
        new AnnotationConfigApplicationContext(MainConfig.class);
    
    // retrieve bean from IoC container 
    Student myStudent = context.getBean("highSchoolStudent", Student.class);
    System.out.println ("** Info for high school student **");
    myStudent.dailyActivity();

    System.out.println ();
    System.out.println ("** Info for college student **");

    
    // retrieve bean from IoC container and cast to correct type
    CollegeStudent collegeStudent = 
        (CollegeStudent) context.getBean("collegeStudent", Student.class);
    collegeStudent.dailyActivity();
    
    // retrieve collections from bean
    
    System.out.println ("List of favourite places : ");
    for (String place : collegeStudent.getFavouritePlaces()) {
      System.out.println(place);
    }
    System.out.println();
    
    System.out.println ("List of subjects and marks : ");
    Map<String, Integer> subjectMarks = collegeStudent.getSubjectMarks();
    for (String subject : subjectMarks.keySet())
      System.out.println(subject + " - " + subjectMarks.get(subject));
    System.out.println();

    // close the context
    context.close();
  }

}
