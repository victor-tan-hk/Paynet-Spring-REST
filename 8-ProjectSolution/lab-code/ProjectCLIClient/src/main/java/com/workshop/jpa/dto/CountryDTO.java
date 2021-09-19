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

public class CountryDTO {
  
  private Integer id;
  private String name;
  private String capital;
  private String region;
  private String subregion;
  private Long population;
  private String[] currencies;
  private String[] languages;
  
  


}
