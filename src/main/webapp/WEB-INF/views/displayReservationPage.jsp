<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservation Completion</title>
</head>
<body>
<h2>Flights Details:</h2>
Airline: ${reserve.operatingAirlines}<br/>
DepartureCity: ${reserve.departureCity}<br/>
ArrivalCity: ${reserve.arrivalCity}<br/>

<form action="completereservation" method="post">
<pre>
<h2>Passenger Details:</h2>
FirstName:  <input type="text" name="passengerfirstName"/>
LastName:  <input type="text" name="passengerlastName"/>
Email:  <input type="text" name="passengerEmail"/>
Mobile:  <input type="tel" name="passengerMobile"/>

<h2>Card Details:</h2>
Name On Card:  <input type="text" name="nameOnCard"/>
Card Number:  <input type="text" name="cardNumber"/>
Expiry Date:  <input type="text" name="cardExpiry"/>
Three Digit Sec Code:  <input type="text" name="secCode"/>

<input type="hidden" name="flightId" value="${reserve.id}"/>
<input type="submit" value="Confirm"/>
</pre>
</form>
</body>
</html>