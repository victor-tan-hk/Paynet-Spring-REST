package com.workshop.jpa.service;


import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.client.HttpClientErrorException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.workshop.jpa.dto.CountryDTO;
import com.workshop.jpa.dto.PatchFormatDTO;
import com.workshop.jpa.dto.TotalDTO;
import com.workshop.jpa.misc.ServerConstants;


@Service
public class MyRestService {

  @Autowired
  private RestTemplate myRestTemplate;

  @Value("${myrest.url}")
  private String restUrl;
  
  private int limit = 0;
  private int page = -1;
  
  public void setLimitAndPage(String limitStr, String pageStr) {
    
    if (limitStr == null || pageStr == null) {
      System.out.println ("The limit and page options must be specified together"); 
      System.exit(1);
    }
    
    page = (int) checkNumericOptions(ServerConstants.PAGE_PARAM, pageStr);
    limit = (int) checkNumericOptions(ServerConstants.LIMIT_PARAM, limitStr);
    
    
  }
  
 
  public List<CountryDTO> getDeveloperList(String key, String value) {

    List<CountryDTO> listToDisplay = new ArrayList<CountryDTO>();
    String finalUrl = "";

    if (key.equals(ServerConstants.NAME_PARAM)) {
      
      if (value.contains(ServerConstants.INCLUDE_ALL_PARAM))
        finalUrl = restUrl;
      else {
        
        finalUrl = restUrl + "/" + value;
        System.out.println("GET to " + finalUrl);
        
        CountryDTO country = new CountryDTO();
        try {
          country = myRestTemplate.getForObject(finalUrl, CountryDTO.class);
        } catch (HttpClientErrorException hcee) {
          System.out.println ("Error message returned from server side");
          System.out.println(hcee.getResponseBodyAsString());
          System.exit(-1);
        }

        listToDisplay.add(country);
        return listToDisplay;
        
      }


    } else if (key.equals(ServerConstants.CAPITAL_PARAM)) {
      
      finalUrl = restUrl + "/" + ServerConstants.CAPITAL_PARAM + "/" + value;
      System.out.println("GET to " + finalUrl);

      CountryDTO country = new CountryDTO();
      try {
        country = myRestTemplate.getForObject(finalUrl, CountryDTO.class);
      } catch (HttpClientErrorException hcee) {
        System.out.println ("Error message returned from server side");
        System.out.println(hcee.getResponseBodyAsString());
        System.exit(-1);
      }

      listToDisplay.add(country);
      return listToDisplay;
      
    } else if (key.equals(ServerConstants.REGION_PARAM)) {
      
      finalUrl = restUrl + "?" + ServerConstants.REGION_PARAM + "=" + value;
            
    } else if (key.equals(ServerConstants.SUBREGION_PARAM)) {
      
      finalUrl = restUrl + "?" + ServerConstants.SUBREGION_PARAM + "=" + value;
      
    } else if (key.equals(ServerConstants.CURRENCY_PARAM)) {
      
      finalUrl = restUrl + "?" + ServerConstants.CURRENCY_PARAM + "=" + value;
      
    } else if (key.equals(ServerConstants.LANGUAGE_PARAM)) {
      
      finalUrl = restUrl + "?" + ServerConstants.LANGUAGE_PARAM + "=" + value;
      
    } else if (key.equals(ServerConstants.LANGUAGE_NUMBER_PARAM)) {
      
      finalUrl = restUrl + "?" + ServerConstants.LANGUAGE_NUMBER_PARAM + "=" + value;
      
    } else if (key.equals(ServerConstants.POPULATION_MORE_PARAM)) {
      
      checkNumericOptions(ServerConstants.POPULATION_MORE_PARAM, value);
      finalUrl = restUrl + "?" + ServerConstants.POPULATION_PARAM + ">" + value;
      
    } else if (key.equals(ServerConstants.POPULATION_LESS_PARAM)) {
      
      checkNumericOptions(ServerConstants.POPULATION_LESS_PARAM, value);
      finalUrl = restUrl + "?" + ServerConstants.POPULATION_PARAM + "<" + value;
      
    } else if (key.equals(ServerConstants.SORTING_PARAM)) {
      
      if (!(value.equals(ServerConstants.POPULATION_ASCENDING) || value.equals(ServerConstants.POPULATION_DESCENDING))) {
        System.out.println ("Option " + ServerConstants.SORTING_PARAM + " must be either " + ServerConstants.POPULATION_ASCENDING + " or " + ServerConstants.POPULATION_DESCENDING);
        System.exit(1);
      }
      
      finalUrl = restUrl + "?" + ServerConstants.SORTING_PARAM + "=" + value;
      
    } 
      
    
    if (limit > 0) {
      
      if (finalUrl.contains("=")) 
        finalUrl += "&" + ServerConstants.LIMIT_PARAM + "=" + limit + "&" + ServerConstants.PAGE_PARAM + "=" + page;
      else
        finalUrl += "?" + ServerConstants.LIMIT_PARAM + "=" + limit + "&" + ServerConstants.PAGE_PARAM  + "=" + page;
        
    }
    
    limit = 0;
    page = -1;
    
    System.out.println("GET to " + finalUrl);
    
    HttpEntity<String> requestEntity = new HttpEntity<String>("empty body");
    
    ResponseEntity<List<CountryDTO>> countryResponse = null;
    try {
      countryResponse = myRestTemplate.exchange(finalUrl, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<CountryDTO>>() {});

    } catch (HttpClientErrorException hcee) {
      System.out.println ("Error message returned from server side");
      System.out.println(hcee.getResponseBodyAsString());
      System.exit(-1);
    }

    listToDisplay = countryResponse.getBody();
    return listToDisplay;
    
  }
  
  
  public TotalDTO getTotalCount(String key, String value) {
    
    String finalUrl = restUrl + "/count?" + key + "=" + value;
    System.out.println("GET to " + finalUrl);
    
    TotalDTO result = new TotalDTO();
     try {
       result = myRestTemplate.getForObject(finalUrl, TotalDTO.class, new HashMap<String,String>());
     } catch (HttpClientErrorException hcee) {
       System.out.println ("Error message returned from server side");
       System.out.println(hcee.getResponseBodyAsString());
       System.exit(-1);
     }
    
    return result;
  }

  
  
  public void postCountry(String fileName) {
    
    CountryDTO country = readCountryJSONFromFile(fileName);
    
    System.out.println("POST to " + restUrl);
    System.out.println("With contents : " + country.toString());

    try {
      myRestTemplate.postForLocation(restUrl, country, new HashMap<String,String>());
    } catch (HttpClientErrorException hcee) {
      System.out.println ("Error message returned from server side");
      System.out.println(hcee.getResponseBodyAsString());
      System.exit(-1);
    }
  
  }
  
  
  public void putCountry(String fileName) {
    
    CountryDTO country = readCountryJSONFromFile(fileName);
    
    String finalURL = restUrl + "/" + country.getName();
    
    System.out.println("PUT to " + finalURL);
    System.out.println("With contents : " + country.toString());    
    
    try {
      myRestTemplate.put(finalURL, country, new HashMap<String,String>());
    } catch (HttpClientErrorException hcee) {
      System.out.println ("Error message returned from server side");
      System.out.println(hcee.getResponseBodyAsString());
      System.exit(-1);
    }
    
  }
  
  
  
  public void patchCountry(String countryName, String fileName) {
    
    System.out.println("Reading JSON contents from file : " + fileName);

    ObjectMapper objectMapper = new ObjectMapper();
    PatchFormatDTO[] patchContents = new PatchFormatDTO[0];
    try {
      patchContents = objectMapper.readValue(new File(fileName), PatchFormatDTO[].class);
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Error in parsing JSON from file");
      System.exit(-1);
    }
    
    String finalURL = restUrl + "/" + countryName;
    
    HttpHeaders headers = new HttpHeaders();
    headers .set("Content-Type", "application/json-patch+json");  
    HttpEntity<PatchFormatDTO[]> requestEntity = new HttpEntity<>(patchContents,headers);
    
    System.out.println("PATCH to " + finalURL);
    System.out.println("Contents of PATCH");
    for (PatchFormatDTO pfdto: patchContents) {
      System.out.println(pfdto);
    }
    ResponseEntity<CountryDTO> response = null;
    
    try {
      response = myRestTemplate.exchange(finalURL, HttpMethod.PATCH, requestEntity, CountryDTO.class);
    } catch (HttpClientErrorException hcee) {
      System.out.println ("Error message returned from server side");
      System.out.println(hcee.getResponseBodyAsString());
      System.exit(-1);
    }
    
    CountryDTO country = response.getBody();
    System.out.println ("Modified content received in return : ");
    System.out.println(country);
    
  }  
  
  
  
  public void deleteCountry(String name) {

    String finalUrl = restUrl + "/" + name;
    System.out.println("DELETE to " + finalUrl);
    
    try {
      myRestTemplate.delete(finalUrl, new HashMap<String, String>());
    } catch (HttpClientErrorException hcee) {
      System.out.println ("Error message returned from server side");
      System.out.println(hcee.getResponseBodyAsString());
      System.exit(-1);
    }
  }

  
  
  
  private long checkNumericOptions(String optionName, String value) {
    
    long tempValue = -1;
    try {
      tempValue = Long.parseLong(value);
    } catch (NumberFormatException ex) {
      System.out.println ("Option " + optionName + " must be numeric");
      System.exit(1);
    }
    
    if (tempValue < 0) {
      System.out.println ("Option " + optionName + "  must be 0 or higher"); 
      System.exit(1);
    }
    
    return tempValue;
    
  }
  
  /*
   * Use to ensure that a DTO object has all its fields initialized properly
   * before use
   */
  private boolean isCountryValid(CountryDTO country) {
    
    return (country.getName() != null &&
        country.getCapital() != null &&
        country.getRegion() != null &&
        country.getSubregion() != null &&
        country.getPopulation() >= 0 &&
        country.getCurrencies() != null &&
        country.getLanguages() != null);
    
  }
  
  
  
  /*
   * Read the JSON content from a file, serialize it into a CountryDTO object,
   * check its validity, then return it.
   */  
  private CountryDTO readCountryJSONFromFile(String fileName) {
    
    System.out.println("Reading JSON contents from file : " + fileName);

    ObjectMapper objectMapper = new ObjectMapper();
    CountryDTO country = new CountryDTO();
    try {
      country = objectMapper.readValue(new File(fileName), CountryDTO.class);
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Error in parsing JSON from file");
      System.exit(-1);
    }
    
    if (!isCountryValid(country)) {
      System.out.println("JSON in file does not conform to expected format for a country");
      System.exit(-1);
    }
    
    return country;
  }

  
  
}