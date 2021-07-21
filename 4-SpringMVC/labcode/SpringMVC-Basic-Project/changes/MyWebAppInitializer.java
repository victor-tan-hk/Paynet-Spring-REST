package com.workshop.mvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebAppInitializer implements WebApplicationInitializer {
  @Override
  public void onStartup(ServletContext container) throws ServletException {
    AnnotationConfigWebApplicationContext context
    = new AnnotationConfigWebApplicationContext();

    // Set the package structure where we can find all Java-based configuration files  
    context.setConfigLocation("com.workshop.mvc");

    container.addListener(new ContextLoaderListener(context));

    ServletRegistration.Dynamic dispatcher = container
        .addServlet("dispatcher", new DispatcherServlet(context));

    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/");
  }
}

