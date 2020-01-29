<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Employee Registration</title>
</head>
<body>
	<div align = "center">
		<h3>Add New Employee or Edit Employee</h3>
		<form action="saveEmployee" method="post" modelAttribute="employee">
			<label>ID:  </label><input name="id"/><br>
			<label>First Name:  </label><input name="fname"/><br>
			<label>Last Name:  </label><input name="lname"/><br>
			<label>Role:  </label><input name="role"/><br>
			<input type="submit" value="Save">
		</form>
	</div>
</body>
</html>