package com.workshop.jpa.dto;

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

}
