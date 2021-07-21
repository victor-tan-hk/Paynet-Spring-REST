package com.workshop.annotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CyclingExercise implements Exercise {
  
  @Override
  public void doExercise() {
    System.out.println ("Cycling is cool !");
  }


}
