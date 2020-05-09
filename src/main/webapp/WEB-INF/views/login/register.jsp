<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register User</title>
</head>
<body>
<form action="register" method="post">
<pre>
<h2>User Registration</h2>
FirstName:  <input type="text" name="firstName"/>
LastName:  <input type="text" name="lastName"/>
Email:  <input type="text" name="email"/>
Password:  <input type="password" name="password"/>
ConfirmedPassword:  <input type="password" name="confirm"/>
<input type="submit" value="Register"/>
</pre>
</form>
</body>
</html>