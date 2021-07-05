<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="in.santhosh.model.TourPackageDetail"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>List of packages</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid"></main>
	<h3>List of packages</h3>
	<p id="message"></p>
	<div class="row" id="packages"></div>
	<script>

		function getAllPackages()
		{
			let url="ListofPackagesAction"
			fetch(url).then(res=>res.json()).then(res=>{
			let packagesList=res;
			console.log("Pac:", packagesList);
			let content = "";
			let role = '<%=session.getAttribute("ROLE")%>';
			let role1 = '<%=session.getAttribute("LOGINUSER")%>';
			for(let packages of packagesList)
			{
				if(role1=="USER"){
					content += "<div class='col-4'><div class='card'><div class='card-body' ><p class='card-text'><strong>Country Name : </strong>"+packages.packageName+
					"</p><p class='card-text'><strong>Package Price : Rs.</strong>"+packages.packagePrice+
					"</p><p class='card-text'><strong>Number of days : </strong>"+packages.numberOfDays+
					"</p><p class='card-text'><strong>Start date : </strong>"+packages.startDate+
					"</p><p class='card-text'><strong>End date : </strong>"+packages.endDate+
					"</p><p class='card-text'><strong>Hotel name : </strong>"+packages.hotelName+
					"</p><button class = 'btn btn-primary' onclick=\"bookPackage("+packages.packageId +
							")\">Book</button</td></tr></div></div><br><br></div></div>";
					
				}else if(role=="ADMIN"){
				content += "<div class='col-4'><div class='card'><div class='card-body' ><p class='card-text'><strong>Country Name : </strong>"+packages.packageName+
				"</p><p class='card-text'><strong>Package Price : Rs.</strong>"+packages.packagePrice+
				"</p><p class='card-text'><strong>Number of days : </strong>"+packages.numberOfDays+
				"</p><p class='card-text'><strong>Start date : </strong>"+packages.startDate+
				"</p><p class='card-text'><strong>End date : </strong>"+packages.endDate+
				"</p><p class='card-text'><strong>Hotel name : </strong>"+packages.hotelName+
				"</p><button class = 'btn btn-danger' onclick=\"removePackage("+packages.packageId +
						")\">Remove</button</td></tr></div></div><br><br></div></div>";
				}
				else{
					content += "<div class='col-4'><div class='card'><div class='card-body' ><p class='card-text'><strong>Country Name : </strong>"+packages.packageName+
					"</p><p class='card-text'><strong>Package Price : Rs.</strong>"+packages.packagePrice+
					"</p><p class='card-text'><strong>Number of days : </strong>"+packages.numberOfDays+
					"</p><p class='card-text'><strong>Start date : </strong>"+packages.startDate+
					"</p><p class='card-text'><strong>End date : </strong>"+packages.endDate+
					"</p><p class='card-text'><strong>Hotel name : </strong>"+packages.hotelName+
					"</p><button class = 'btn btn-primary' onclick=\"bookPackage("+packages.packageId +
							")\">Book</button</td></tr></div></div><br><br></div></div>";
					}
				
			}
			 document.querySelector("#packages").innerHTML = content; 
			
			})
			
		}
		function removePackage(packageId)
		{
			event.preventDefault();
			const queryParams="?id="+packageId;
			let url="RemovePackageAction"+queryParams;
			content="";
			fetch(url).then(res=>res.json()).then(res=>{
				let data=res;
				console.log(data);
				content+=data.infoMessage;
				alert(content);
				window.location.href="ListOfPackages.jsp";
			
			}).catch(err=>{
				let data=err.response;
				console.log(data);
				content+=data.errorMessage;
				document.querySelector("#messsage").innerHTMl=content;
				
			});
			
		}
		getAllPackages();

	</script>
</body>
</html>