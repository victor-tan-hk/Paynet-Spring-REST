package com.workshop.javaconfig;

import org.springframework.stereotype.Component;

@Component
public class SwimmingExercise implements Exercise {
  
  @Override
  public void doExercise() {
    System.out.println ("Swimming is great !");
  }

}

