package com.workshop.jpa.misc;

import java.util.Scanner;

import com.workshop.jpa.dto.CountryDTO;
import com.workshop.jpa.dto.TotalDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UtilityMethods {
  
  

  public static void waitKeyPress() {
    System.out.println("\nPress enter to continue ....");
    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();
    log.info("\n");
    // scanner.close();
  }
  
  public static void showCountries(Iterable<CountryDTO> countries) {
    System.out.println("\n  +++++ List of countries to display +++++\n");
    int countLine = 1;
    for (CountryDTO country: countries) {
      System.out.println(country.toString());
      if (countLine++ > 5) {
        waitKeyPress(); 
        countLine = 1;
      }
    }
    waitKeyPress(); 
  }
  
  
  
  public static void showTotal(TotalDTO total) {
    System.out.println("\n  +++++ Total count +++++\n");
    System.out.println(total);
  }
  
  

}
