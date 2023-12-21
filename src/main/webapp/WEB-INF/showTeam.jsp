<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>Team Details</title>
</head>
<body>
 <div class="m-5 w-50">
   
        <h1><c:out value="${team.teamName}"/></h1>
        <a href="/home" class="mt-5">dashboard</a>


       <p class="mt-3">Team Name: <c:out value="${team.teamName}"/></p>
       <p>Skill Level: <c:out value="${team.skillLevel}"/></p>
       <p>Game Day: <c:out value="${team.gameDay}"/></p>
 

        <c:if test="${user.id == team.user.id}">
            <a href="/teams/${team.id}/edit">Edit</a>
            <a href="/teams/delete/${team.id}">Delete</a>
        </c:if>
    
</div>

</body>
</html>

