package com.workshop.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyRestService {

  private static final Logger logger = LoggerFactory.getLogger(MyRestService.class);

  @Autowired
  private RestTemplate myRestTemplate;

  @Value("${myrest.url}")
  private String restUrl;
  
  public void workWithPosts() {
    String finalUrl = restUrl + "/posts";
    logger.info("GET to " + finalUrl);
    
    Post[] postsArray = myRestTemplate.getForObject(finalUrl, Post[].class);
    
    logger.info("Showing first 5 posts");

    for (int i =0; i < 5; i++) {
      logger.info(postsArray[i].toString());
    }

    logger.info("\n\n");

    finalUrl = restUrl + "/posts/1";
    logger.info("GET to " + finalUrl);
    
    Post singlePost = myRestTemplate.getForObject(finalUrl, Post.class);
    logger.info("Showing single post retrieved");
    logger.info(singlePost.toString());
    
  }
  
  public void workWithComments() {
    
    String finalUrl = restUrl + "/comments";
    logger.info("GET to " + finalUrl);
    
    Comment[] commentsArray = myRestTemplate.getForObject(finalUrl, Comment[].class);
    
    logger.info("Showing first 5 comments");

    for (int i =0; i < 5; i++) {
      logger.info(commentsArray[i].toString());
    }

    logger.info("\n\n");

    finalUrl = restUrl + "/comments/1";
    logger.info("GET to " + finalUrl);
    
    Comment singleComment = myRestTemplate.getForObject(finalUrl, Comment.class);
    logger.info("Showing single comment retrieved");
    logger.info(singleComment.toString());
    
    
  }
  



  
}