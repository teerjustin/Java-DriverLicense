<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:out value="${person.firstName} ${person.lastName}">${person.firstName} ${person.lastName}</c:out>
	<c:out value="${person.license.number}">${person.license.number}</c:out>
	<c:out value="${person.license.state}">${person.license.state}</c:out>
	<c:out value="${person.license.expirationDate}">${person.license.expirationDate}</c:out>

</body>
</html>