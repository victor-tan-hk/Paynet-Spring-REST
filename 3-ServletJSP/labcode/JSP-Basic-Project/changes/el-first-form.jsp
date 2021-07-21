<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<body>
<h1> Using Expression Language </h1>

<h2> Hello : ${ param.name } </h2>
<hr>
<h2> Your favourite language : ${ param.language } </h2>
<hr>
<h2> ${requestScope.displayMessage} </h2>

</body>
</html>
