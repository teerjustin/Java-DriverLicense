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
		
		<h1>All Persons</h1>
		<table>
		    <thead>
		        <tr>
		            <th>First Name</th>
		            <th>Last Name</th>
		            <th>License #</th>
		            <th>State </th>
		            <th>Expiration Date</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${persons}" var="person">
		        <tr>
		            <td> <c:out value="${person.firstName}"></c:out> </td>
		            <td> <c:out value="${person.lastName}"></c:out></td>
		            <td> <c:out value="${person.license.number}"></c:out></td>
		            <td> <c:out value="${person.license.state}"></c:out></td>
		            <td> <c:out value="${person.license.expirationDate}"></c:out></td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
		<a href = "<c:url value = "/persons/new"/>">Create a new person</a>
</body>
</html>