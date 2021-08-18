package com.workshop.rest;

import java.util.Arrays;

public class Developer {
  
  private Integer id;
  private String name;
  private Integer age;
  private String[] languages;
  private boolean married;
  
  public Developer() {
    
  }

  public Developer(Integer id, String name, Integer age, String[] languages, boolean married) {
    super();
    this.id = id;
    this.name = name;
    this.age = age;
    this.languages = languages;
    this.married = married;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String[] getLanguages() {
    return languages;
  }

  public void setLanguages(String[] languages) {
    this.languages = languages;
  }

  public boolean isMarried() {
    return married;
  }

  public void setMarried(boolean married) {
    this.married = married;
  }

  @Override
  public String toString() {
    return "Developer [id=" + id + ", name=" + name + ", age=" + age + ", languages=" + Arrays.toString(languages)
        + ", married=" + married + "]";
  }
  
}
