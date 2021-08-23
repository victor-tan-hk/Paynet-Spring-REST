package com.workshop.jpa.dto;

import com.workshop.jpa.model.Developer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class DeveloperDTO {
  
  private Integer id;
  private String name;
  private Integer age;
  private String[] languages;
  private Boolean married;
  
  public DeveloperDTO(Developer dev) {
    this.id = dev.getId();
    this.name = dev.getName();
    this.age = dev.getAge();
    this.languages = dev.getLanguages().split(",");
    this.married = dev.getMarried();
  }

}
