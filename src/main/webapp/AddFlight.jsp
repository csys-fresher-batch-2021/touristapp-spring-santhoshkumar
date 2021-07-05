<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add flight</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<h3>Add Flight</h3>
	<p id="message"></p>
	<form onsubmit="addFlight()">
	<label for="countryName"><strong>Country Name</strong></label><br>
		<select name="countryName" id="countryName">
		  <option value="" disabled>Select a country</option>
		  <option value="Dubai">Dubai</option>
		  <option value="Maldives">Maldives</option>
		  <option value="Germany">Germany</option>
		  <option value="Singapore">Singapore</option>
		  <option value="Malaysia">Malaysia</option>
		  <option value="Manali">Manali</option>
		</select>
		<br>
		<label for="flightName"><strong>Flight</strong></label><br>
		<select name="flightName" id="flightName">
		  <option value="" disabled>Select a flight</option>
		  <option value="Spice Jet">Spice Jet</option>
		  <option value="Indigo">Indigo</option>
		  <option value="Go Air">Go Air</option>
		  <option value="Air Asia">Air Asia</option>
		  <option value="Etihad Airways">Etihad Airways</option>
		  <option value="Alliance Air">Alliance Air</option>
		</select>
		<br>
		<label for="source"><strong>From</strong></label><br>
		<select name="source" id="source">
		  <option value="" disabled>Source</option>
		  <option value="Coimbatore (CJB)">Coimbatore (CJB)</option>
		  <option value="Chennai (MAA)">Chennai (MAA)</option>
		  <option value="Delhi (DEL)">Delhi (DEL)</option>
		  <option value="Dubai (DXB)">Dubai (DXB)</option>
		  <option value="Kuala Lumpur (KUL)">Kuala Lumpur (KUL)</option>
		  <option value="Male (MLE)">Male (MLE)</option>
		  <option value="Puerto Carreno (PCR)">Puerto Carreno (PCR)</option>
		  <option value="Singapore (XSP)">Singapore (XSP)</option>
		</select>
		<br>
		
		<label for="destination"><strong>To</strong></label><br>
		<select name="destination" id="destination">
		  <option value="" disabled>destination</option>
		  <option value="Coimbatore (CJB)">Coimbatore (CJB)</option>
		  <option value="Chennai (MAA)">Chennai (MAA)</option>
		  <option value="Delhi (DEL)">Delhi (DEL)</option>
		  <option value="Dubai (DXB)">Dubai (DXB)</option>
		  <option value="Kuala Lumpur (KUL)">Kuala Lumpur (KUL)</option>
		  <option value="Male (MLE)">Male (MLE)</option>
		  <option value="Puerto Carreno (PCR)">Puerto Carreno (PCR)</option>
		  <option value="Singapore (XSP)">Singapore (XSP)</option>
		</select>
		<br>
		<label for="startDate"><strong>Journey start date</strong></label><br>
		<input type="date" id="startDate"name="startDate" placeholder="Journey start date" required><br>
		<label for="depatureTime"><strong>Departure time</strong></label><br>
		<input type="time" id="departureTime" name="depatureTime" placeholder="Depature time" required><br>
		<label for="arrivalTime"><strong>Arrival time</strong></label><br>
		<input type="time" id="arrivalTime" name="arrivalTime" placeholder="Arrival time" required><br>
		<label for="status"><strong>Status</strong></label><br>
		<input type="radio" value="Depart" id="status" name="status" checked >Depart   
		<input type="radio" value="Return" id="status1" name="status"> Return<br>   
		<br>
		<button type="submit" class="btn btn-primary">Submit</button>
		<button  type="reset" class="btn btn-danger">Reset</button>
	
	</form>
</main>
<script>
function addFlight(){
	event.preventDefault();
	let countryName=document.querySelector("#countryName").value;
	let flightName=document.querySelector("#flightName").value;
	let source=document.querySelector("#source").value;
	let destination=document.querySelector("#destination").value;
	let startDate=document.querySelector("#startDate").value;
	let departureTime=document.querySelector("#departureTime").value;
	let arrivalTime=document.querySelector("#arrivalTime").value;
	let journeyStatus;
	if (document.getElementById('status').checked) {
		  journeyStatus = document.getElementById('status').value;
	}else if (document.getElementById('status1').checked) {
		  journeyStatus = document.getElementById('status1').value;
	}
	console.log(journeyStatus);
	let flightDetail={
			"countryName":countryName,
			"flightName":flightName,
			"source":source,
			"destination":destination,
			"journeyDate":startDate,
			"departure":departureTime,
			"arrival":arrivalTime,
			"status":journeyStatus
	}
	console.log(flightDetail);
	let url="AddFlightAction";
	content="";
	axios.post(url,flightDetail).then(res=>{
		let data=res.data;
		console.log(data);
		alert(data.infoMessage);
		window.location.href="AddFlight.jsp";
		
	}).catch(err=>{
		let data=err.response.data;
		console.log(data);
		alert(data.errorMessage);
		window.location.href="AddFlight.jsp";
		
	})
}
</script>
</body>
</html>