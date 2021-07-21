<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>

<body>

<h1> Employee Details </h1>
<hr>
Employee name : ${param.employeeName}
<br>
<br>
<h2>${message}
</h2>
<br>
<br>
Job role : ${jobInfo.jobRole}
<br>
Salary : ${jobInfo.salary}
<br>
   <c:if test="${jobInfo.isPermanent}">
       <c:out value="This is a permanent position" />
   </c:if>
   <c:if test="${!jobInfo.isPermanent}">
       <c:out value="This is a temporary position" />
   </c:if>

</body>
</html>