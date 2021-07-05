<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>New License</h1>
	
	<form:form action="/persons/license/create" method="post" modelAttribute="license">
		

		<p>
			<form:label path="person">Person: </form:label>
			<select id="person" name="person">
				<c:forEach items="${persons}" var="person">
				    <option value="${person.id}">${person.firstName} ${person.lastName}</option>
				</c:forEach>
			</select>
		</p>
		
	    <p>
	        <form:label path="state">State: </form:label>
	        <form:errors path="state"/>
	        <form:input path="state"/>
	    </p>
	    <p>
	        <form:label path="expirationDate">Expiration Date: </form:label>
	        <form:errors path="expirationDate"/>
	        <form:input type="date" path="expirationDate"/>
	    </p>

	    <input type="submit" value="Submit"/>
	</form:form>    
</body>
</html>