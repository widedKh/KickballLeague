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
	<title>Kickball League Dashboard</title>
</head>
<body>

	<div class="m-5  w-75">
	
      <h1>Welcome, <c:out value="${user.name}"/></h1>
      <a href="/logout">logout</a>
  
    <table class="table table-striped table-bordered mt-3">
        <tr>
            <th>Team Name</th>
            <th>Skill Level (1-5)</th>
            <th>Game Day</th>
        </tr>
        <c:forEach var="team" items="${teams}">
            <tr>
                <td><a href="teams/${team.id}"><c:out value="${team.teamName}"/></a></td>
                <td><c:out value="${team.skillLevel}"/></td>
                <td><c:out value="${team.gameDay}"/></td>
            </tr>
        </c:forEach>
    </table>
   <a href="teams/new">
     <button class="col-sm-10 btn btn-light" style="box-shadow: 4px 4px black">Create New Team</button>
  </a>
</div>


</body>
</html>