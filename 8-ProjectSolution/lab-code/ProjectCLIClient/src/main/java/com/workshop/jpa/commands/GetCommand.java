package com.workshop.jpa.commands;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.workshop.jpa.dto.CountryDTO;
import com.workshop.jpa.misc.ServerConstants;
import com.workshop.jpa.misc.UtilityMethods;
import com.workshop.jpa.service.MyRestService;

import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;


@Component
@Command(name = "get",
mixinStandardHelpOptions = true, 
description = "Execute Get REST API call to the countries REST service")
public class GetCommand implements Callable<Integer> {
  
  @Autowired
  private MyRestService restService;
  
  @Option(names = {"--"+ServerConstants.NAME_PARAM},description="Country names: france, spain, use * to retrieve all countries ....")
  private String name;

  @Option(names = {"--"+ServerConstants.CAPITAL_PARAM},description="Country capitals: london, paris, bangkok,....")
  private String capital;

  @Option(names = {"--"+ServerConstants.REGION_PARAM},description="Country regions: asia, europe, africa, americas, ....")
  private String region;

  @Option(names = {"--"+ServerConstants.SUBREGION_PARAM},description="Country subregions: northern europe, eastern europe, western europe, ...")
  private String subregion;

  @Option(names = {"--"+ServerConstants.CURRENCY_PARAM},description="Country currencies: usd, gbp, eur,...")
  private String currency;
  
  @Option(names = {"--"+ServerConstants.LANGUAGE_PARAM},description="Country languages: en, fr, de, es,.....")
  private String language;
  
  @Option(names = {"--"+ServerConstants.LANGUAGE_NUMBER_PARAM},description="No. total languages spoken: 1, 2, 3, 4, ...")
  private String langnum;

  @Option(names = {"--"+ServerConstants.COUNT_REGION_PARAM},description="Country regions: asia, europe, africa, americas, ....")
  private String countregion;
  
  @Option(names = {"--"+ServerConstants.COUNT_LANGUAGE_PARAM},description="Country languages: en, fr, de, es,.....")
  private String countlanguage;

  @Option(names = {"--"+ServerConstants.POPULATION_MORE_PARAM},description="Countries with population more than <popmore>")
  private String popmore;

  @Option(names = {"--"+ServerConstants.POPULATION_LESS_PARAM},description="Countries with population less than <popless>")
  private String popless;

  @Option(names = {"--"+ServerConstants.SORTING_PARAM},description="Sort on ascending (sort=pop-asc) or descending (sort=pop-desc) order of population")
  private String sort;

  @Option(names = {"--"+ServerConstants.LIMIT_PARAM},description="Limit on number of rows to be shown")
  private String limit;
  
  @Option(names = {"--"+ServerConstants.PAGE_PARAM},description="Page number to be retrieved")
  private String page;
  
  
  @Override
  public Integer call() throws Exception {
    
    System.out.println("\n");
    
    if (limit != null || page != null) {
      restService.setLimitAndPage(limit, page);
    }
    
    if (name != null) {
      UtilityMethods.showCountries(restService.getDeveloperList(ServerConstants.NAME_PARAM,name));
    } else if (capital != null) {
      UtilityMethods.showCountries(restService.getDeveloperList(ServerConstants.CAPITAL_PARAM,capital));
    } else if (region != null) {
      UtilityMethods.showCountries(restService.getDeveloperList(ServerConstants.REGION_PARAM,region));
    } else if (subregion != null) {
      UtilityMethods.showCountries(restService.getDeveloperList(ServerConstants.SUBREGION_PARAM,subregion));
    } else if (currency != null) {
      UtilityMethods.showCountries(restService.getDeveloperList(ServerConstants.CURRENCY_PARAM,currency));
    } else if (language != null) {
      UtilityMethods.showCountries(restService.getDeveloperList(ServerConstants.LANGUAGE_PARAM,language));
    } else if (langnum != null) {
      UtilityMethods.showCountries(restService.getDeveloperList(ServerConstants.LANGUAGE_NUMBER_PARAM,langnum));
    } else if (countregion != null) {
      UtilityMethods.showTotal(restService.getTotalCount(ServerConstants.REGION_PARAM,countregion));
    } else if (countlanguage != null) {
      UtilityMethods.showTotal(restService.getTotalCount(ServerConstants.LANGUAGE_PARAM,countlanguage));
    } else if (popmore != null) {
      UtilityMethods.showCountries(restService.getDeveloperList(ServerConstants.POPULATION_MORE_PARAM,popmore));
    } else if (popless != null) {
      UtilityMethods.showCountries(restService.getDeveloperList(ServerConstants.POPULATION_LESS_PARAM,popless));
    } else if (sort != null) {
      UtilityMethods.showCountries(restService.getDeveloperList(ServerConstants.SORTING_PARAM,sort));
    } else {
      
      System.out.println ("Type --help for more information on options and parameters");
      
    }
    
    return 0;

  }
}