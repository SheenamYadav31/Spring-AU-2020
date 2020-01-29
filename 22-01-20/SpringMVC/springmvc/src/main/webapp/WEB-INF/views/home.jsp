<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sheenam Yadav</title>
</head>
<body>
	<div align="center">
			<h1>Employee List</h1>
			<h3><a href="/springmvc/employeeForm">Add New Employee</a></h3>
			<table border="1">
				<thead>ID</thead>
				<thead>First Name</thead>
				<thead>Last Name</thead>
				<thead>Role</thead>
				<c:forEach items = "${emplist}" var="employee">
					<tr>      
					        <td><c:out value = "${employee.id}"/></td>
					        <td><c:out value = "${employee.fname }"/></td>
					        <td><c:out value = "${employee.lname }"/></td> 
					        <td></td>
					        <td>
					        <a href="/springmvc/editForm">Edit Employee</a>
					        
	                        &nbsp;&nbsp;&nbsp;&nbsp;
	                        <a href="/springmvc/deleteEmployee">Delete Employee</a>
	                        </td>
					        
					</tr>      
  </c:forEach>
	         </table> 
		</div>
</body>
</html>
<!-- -->