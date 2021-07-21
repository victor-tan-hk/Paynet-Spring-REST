package com.workshop.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FirstServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;


  public FirstServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println ("inside doGet of FirstServlet");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      // Write some content
      out.println("<html>");
      out.println("<body>");
      out.println("<h1>FirstServlet served at : " + request.getContextPath() + "</h1>");
      out.println("<hr>");
      out.println("<h2>Time on the server is: " + new java.util.Date() + "</h2>");
      out.println("</body>");
      out.println("</html>");
    } finally {
      out.close();
    }	
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
