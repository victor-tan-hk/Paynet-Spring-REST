package com.workshop.rest;

import lombok.Data;
import lombok.NonNull;

@Data
public class Developer {
  
  @NonNull
  private Integer id;
  @NonNull
  private String name;
  @NonNull
  private Integer age;
  @NonNull
  private String[] languages;
  @NonNull
  private boolean married;
  
}
