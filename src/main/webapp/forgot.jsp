<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
	<title>Forgot Password</title>
</head>
<body>
	<h1>Forgot Password</h1>
	<form action="Forgot" method="post">
		<label for="email">Email:</label>
		<input type="email" id="email" name="femail" required><br><br>
		<input type="submit" value="Submit">
		<a href="index.jsp">Login Page</a>
	</form>
</body>
</html>
