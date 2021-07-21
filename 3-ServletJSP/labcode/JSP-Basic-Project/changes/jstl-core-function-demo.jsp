<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>
<html>
<body>

	<c:import var="myHeader" url="header.html" />
	${myHeader}

	<h2>if-else condition</h2>
	<c:set var="age" value="26" />
	<c:if test="${age >= 18}">
		<c:out value="You are eligible for voting!" />
	</c:if>
	<c:if test="${age < 18}">
		<c:out value="You are not eligible for voting!" />
	</c:if>

	<br>
	<br>
	<h2>Iteration structure</h2>

	<c:forEach var="counter" begin="1" end="10">
		<c:out value="${counter}" />
	</c:forEach>

	<br>
	<br>
	<h2>Case structure</h2>

	<c:set var="number1" value="222" />
	<c:set var="number2" value="12" />
	<c:set var="number3" value="10" />
	<c:choose>
		<c:when test="${number1 < number2}">
			<c:out value="number1 is less than number2" />
		</c:when>
		<c:when test="${number1 <= number3}">
			<c:out value="number1 is less than or equal to number3" />
		</c:when>
		<c:otherwise>
			<c:out value="number1 is largest number!" />
		</c:otherwise>
	</c:choose>

	<br>
	<br>
	<h2>Some string functions</h2>

	<c:set var="oldPassword" value="HelloPass" />
	<c:set var="newPassword" value="HelloPassNew" />
	<c:if test="${fn:contains(newPassword, oldPassword)}">
		<c:out
			value="New password should not contain old password as substring" />
	</c:if>

	<br>
	<br> Spiderman occurs at index position ${fn:indexOf("My name is Spiderman", "Spiderman")}

	<br>
	<br>
	<c:set var="largeStr" value="Thor Hulk Superman" />
	<c:set var="smallStr" value="Thor" />
	<c:if test="${fn:startsWith(largeStr, smallStr)}">
		<c:out value="Large string does start with small string" />
	</c:if>

</body>
</html>