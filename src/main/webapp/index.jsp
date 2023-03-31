<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="test.UserBean"
	import="java.util.*"%>
	
	<%
UserBean admin = (UserBean) request.getSession().getAttribute("admin");
if (admin != null) {
	response.sendRedirect("index.jsp");
}

%>

<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
<%@include file="include_Jsp_file/head.jsp"%>
</head>
<body>

	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">User Login</div>
			<div class="card-body ">

				<form action="user-login" method="post">

					<div class="form-group">
						<label>Email address</label> <input type="email"
							class="form-control" name="login-email"
							placeholder="Enter your Email" required>
					</div>

					<div class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" name="login-pass" placeholder="***********"
							required>
					</div>

					<div class="text-center">
					<br>
						<button type="submit" class="btn btn-primary">Login</button>
						<a href="signUp.jsp" class="btn btn-primary">New User</a>
						<a href="forgot.jsp" class="btn btn-primary">Forgot Password</a>
						<a href="adminLogin.jsp" class="btn btn-primary">Admin Login</a>
					</div>
				</form>

			</div>
		</div>
	</div>
</body>
</html>