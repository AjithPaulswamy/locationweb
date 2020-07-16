<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Location</title>
</head>
<body>

<h2>Locations :</h2>
<table bgcolor="#0080ff">
<!-- Table Heading -->
<tr>
<th>ID</th>
<th>Code</th>
<th>Name</th>
<th>Type</th>
</tr>
<!-- Table Row -->
<c:forEach items="${locations}" var="location">
<tr>
<td>${location.id}</td>
<td>${location.code}</td>
<td>${location.name}</td>
<td>${location.type}</td>
</tr>
</c:forEach>

</table>

</body>
</html>