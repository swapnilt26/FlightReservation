<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flights</title>
</head>
<body>
<h2>All Flights:</h2>

<table>
  <tr>
    <th>Airlines</th>
    <th>Departure City</th>
    <th>Arrival City</th>
    <th>Departure Time</th>
  </tr>
 <c:forEach items="${find}" var="flight">
  <tr>
   <td>${flight.operatingAirlines}</td>
   <td>${flight.departureCity}</td>
   <td>${flight.arrivalCity}</td>
   <td>${flight.estimatedDepartureTime}</td>
   <td><a href="showCompleteReservation?Flightid=${flight.id}">select</a></td>
  </tr>
 </c:forEach> 
</table>
</body>
</html>