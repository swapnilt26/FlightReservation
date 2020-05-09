<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
span.note {
  font-size: 120%;
  color: red;
}
</style>
<meta charset="UTF-8">
<title>User Login</title>
</head>
<body>
<form action="login" method="post">
<pre>
<h2>User Login</h2>
Email:  <input type="text" name="email"/>
Password:  <input type="password" name="password"/>
<input type="submit" value="Login"/>
<span class="note">${msg}</span>
</pre>
</form>
</body>
</html>