<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Details</title>
</head>
<body>
		<h2>Flight Details</h2>
			Flight Number:${flight.flightNumber}<br/>
			Operating Airlines:${flight.operatingAirlines}<br/>
			Departure City:${flight.departureCity}<br/>
			Arrival City:${flight.arrivalCity}<br/>
			Date Of Departure:${flight.dateOfDeparture}<br/>
		
		<h2>Passenger Details</h2>
		<form action = "confirmReservation" method = "post">
		<pre>
			FirstName<input type = "text" name = "firstName"/>
			MiddleName<input type = "text" name = "middleName"/>
			LastName<input type = "text" name = "lastName"/>
			Email<input type = "text" name = "email"/>
			Phone<input type = "number" name = "phone"/>
			<input type = "hidden" name = "flightId" value = "${flight.id}"/>
			
			<h2>Enter The Payment Details</h2>
			Amount<input type ="text" name = "amount"/>
			Name On The Card<input type = "text" name = "nameOfTheCard"/>
			Card Number<input type = "text" name = "cardNumber"/>
			Expiry Date<input type = "text" name = "expiryDate"/>
			Cvv<input type = "number" name = "cvv"/>
			<input type = "submit" value = "complete reservation"/>
		</pre>
		
		</form>
</body>
</html>