<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Edit Team</title>
</head>
<body>
  <div class="m-5">
    <h1>Edit Team</h1>
    <a href="/home">dashboard</a>
    <form:form action="/teams/${team.id}/edit" method="post" modelAttribute="team" class="m-5 ">
    <input type="hidden" name="_method" value="put">
    <table class="table table-bordered w-50">
        <tr>
            <td><form:label path="teamName" class="col-form-label">Team Name:</form:label></td>
            <td>
                <form:errors path="teamName" class="text-danger" />
                <form:input type="text" path="teamName" class="form-control" />
            </td>
        </tr>
        <tr>
            <td><form:label path="skillLevel" class="col-form-label">Skill Level:</form:label></td>
            <td>
                <form:errors path="skillLevel" class="text-danger" />
                <form:input type="number" path="skillLevel" class="form-control" />
            </td>
        </tr>
        <tr>
            <td><form:label path="gameDay" class="col-form-label">Game Day:</form:label></td>
            <td>
                <form:errors path="gameDay" class="text-danger" />
                <form:input type="text" path="gameDay" class="form-control" />
            </td>
        </tr>
         <tr>
	       <td colspan=2>
	        <input  type="submit" value="Submit" class="col-sm-10 btn btn-light" style="box-shadow: 4px 4px black"/>
	        </td>
	        </tr>
    </table>

     <c:if test="${user.id == team.user.id}">
           <a href="/teams/delete/${team.id}">Delete</a>
     </c:if>
</form:form>

  </div>
</body>
</html>
