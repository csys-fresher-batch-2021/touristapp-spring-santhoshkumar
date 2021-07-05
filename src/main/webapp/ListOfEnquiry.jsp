<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Enquiry</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<h3>List of enquiry</h3>
	<table class="table table-bordered" >
	<caption>List of all enquiry</caption>
	<thead>
	<tr>
	<th scope="col">S.NO</th>
	<th scope="col">Name</th>
	<th scope="col">Mobile Number</th>
	<th scope="col">Country Name</th>
	<th scope="col">Package Price</th>
	<th scope="col">Days</th>
	<th scope="col">Start Date</th>
	<th scope="col">End Date</th>
	<th scope="col">Hotel Name</th>
	<th scope="col">Status</th>
	</tr>
	</thead>
	
	<tbody id="packageEnquiry">
	
	</tbody>
	</table>
</main>

<script>
function getAllEnquiry(){
	let url="ListOfEnquiry";
	let content="";
	fetch(url).then(res=>res.json()).then(res=>{
		 let enquiryList=res;
		 console.log(enquiryList);
		let i=0;
		for(let enquiry of enquiryList){
			if(enquiry.status=="Pending"){
				content+="<tr><td>"+ ++i +"</td><td>"+enquiry.name+
				"</td><td>"+enquiry.mobileNumber+"</td><td>"+enquiry.packageName+
				"</td><td>"+enquiry.packagePrice+"</td><td>"+enquiry.numberOfDays+
				"</td><td>"+enquiry.startDate+"</td><td>"+enquiry.endDate+
				"</td><td>"+enquiry.hotelName+"</td><td>"+enquiry.status+
				"</td><td><button class='btn btn-primary'onclick=\"updateEnquiry("+enquiry.enquiryId+")\">Done</button></td></tr>";
			}
			else{
				content+="<tr><td>"+ ++i +"</td><td>"+enquiry.name+
				"</td><td>"+enquiry.mobileNumber+"</td><td>"+enquiry.packageName+
				"</td><td>"+enquiry.packagePrice+"</td><td>"+enquiry.numberOfDays+
				"</td><td>"+enquiry.startDate+"</td><td>"+enquiry.endDate+
				"</td><td>"+enquiry.hotelName+"</td><td>"+enquiry.status+"</td></tr>";
			}

		}
		document.querySelector("#packageEnquiry").innerHTML=content;

	})
	
}
function updateEnquiry(enquiryId){
	const query="?id="+enquiryId;
	let url="UpdateEnquiryStatus"+query;
	fetch(url).then(res=>res.json()).then(res=>{
		let data=res;
		console.log(data);
		alert(data.infoMessage);
		window.location.href="ListOfEnquiry.jsp";
		
	}).catch(err=>{
		
		let data=err.response.data;
		console.log(data);
		alert(data.errorMessage);
		window.location.href="ListOfFlight.jsp";
	})
	
}
getAllEnquiry();	
		/* $("#enquiryList").template("enquiry"); 
        $.tmpl("enquiry",enquiryList).appendTo("#packageEnquiry"); */
</script>
</body>
</html>