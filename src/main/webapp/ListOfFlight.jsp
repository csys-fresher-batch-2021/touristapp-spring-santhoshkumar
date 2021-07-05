<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Delete Flights</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>List of flights</h3>
		<table class="table table-bordered">
			<caption>List of flight details</caption>

			<thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Country name</th>
					<th scope="col">Flight Name</th>
					<th scope="col">Source</th>
					<th scope="col">Destination</th>
					<th scope="col">Journey date</th>
					<th scope="col">Departure time</th>
					<th scope="col">Arrival time</th>
					<th scope="col">Status</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody id="flightList">


			</tbody>
		</table>
	</main>
	<script>
function getAllFlight(){
	
	let url="ListOfFlight";
	fetch(url).then(res=>res.json()).then(res=>{
		let flightDetail=res;
		console.log(flightDetail);
		let content="";
		let  i=0;
		for(let flight of flightDetail){
			let date = new Date(flight.journeyDate)
			let formattedDate = date.getDate() + "-" + (date.getMonth() + 1) + "-" + date.getFullYear()
			content+="<tr><td>"+ ++i + "</td><td>"+flight.countryName+
			"</td><td>"+flight.flightName+"</td><td>"+flight.source+
			"</td><td>"+flight.destination+"</td><td>"+formattedDate+
			"</td><td>"+flight.departure+"</td><td>"+flight.arrival+
			"</td><td>"+flight.status+
			"</td><td><button class='btn btn-danger'onclick=\"removeFlight("+flight.flightId+")\">Delete</button></td></tr>";
		}
		document.querySelector("#flightList").innerHTML=content;
		
	})
	
	
}
function removeFlight(flightId){
	event.preventDefault();
	console.log(flightId);
	const queryParams="?id="+flightId;
	let url="RemoveFlightAction"+queryParams;
	console.log(url);
	let content="";
	fetch(url).then(res=>res.json()).then(res=>{
		let data=res;
		console.log(data);
		content+=data.infoMessage;
		alert(content);
		window.location.href="ListOfFlight.jsp";
		
	}).catch(err=>{
		
		let data=err.response.data;
		console.log(data);
		content+=data.errorMessage;
		alert(content);
		window.location.href="ListOfFlight.jsp";
	})
}
getAllFlight();
</script>
</body>
</html>