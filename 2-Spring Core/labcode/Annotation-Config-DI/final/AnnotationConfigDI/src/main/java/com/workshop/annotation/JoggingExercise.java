package com.workshop.annotation;

import org.springframework.stereotype.Component;

@Component
public class JoggingExercise implements Exercise {
  
  @Override
  public void doExercise() {
    System.out.println ("Jogging is fun !");
  }

}



