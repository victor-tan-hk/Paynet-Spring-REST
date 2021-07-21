<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>

<!-- Declaring variables -->
<%! String name="Spiderman"; %> 
<%! int age = 33; %>

<!-- Declaring methods -->
<%! 
int addNum(int num1, int num2){ 
  return num1 + num2; 
} 
%>

<h2> Employee details </h2>
<hr>

<!-- Expression tags -->
<%= "Name : " +  name %><br>
<%= "Age : "+ age %><br> 
<%= "Sum of 4 and 5 is : " + addNum(4,5) %>
<hr>

<!-- Scriptlet that uses declared variables and methods -->

<table>

  <%
  StringBuffer sb = new StringBuffer();
  
  sb.append("<tr>");
  sb.append("<td>" +  name + "</td>");
  for (int i = 1; i <= 3; i++) {
    sb.append("<td>" + addNum(age, i) + "</td>");
  }
  sb.append("</tr>");
  
  sb.append("<tr>");
  sb.append("<td>" +  name + " Rebooted </td>");
  for (int i = 4; i <= 6; i++) {
    sb.append("<td>" + addNum(age, i) + "</td>");
  }
  sb.append("</tr>");
  
  out.println(sb);
  
  %>

</table>
</body>
</html>