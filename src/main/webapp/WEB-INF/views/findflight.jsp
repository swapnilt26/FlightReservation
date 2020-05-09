<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Flight</title>
</head>
<body>
<h2>Enter Travel Details</h2>
<form action="findflight" method="post">
<pre>
DepartureCity:  <input type="text" name="departurecity"/>
ArrivalCity:  <input type="text" name="arrivalcity"/>
Date Of Travel : <input type="date" name="traveldate"/>
<input type="submit" value="Search"/>
</pre>
</form>
</body>
</html>