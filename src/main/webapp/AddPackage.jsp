<!DOCTYPE>
<html lang="en">
<head>
<title>Tourist Management App</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<p id="message"></p>
		<h3>Add packages</h3>
		<form onsubmit="addPackage()">
		<label for="countryName"><strong>Country Name</strong></label><br>
		<select name="countryName" id ="countryName">
		  <option value="" disabled >Select a country</option>
		  <option value="Dubai">Dubai</option>
		  <option value="Maldives">Maldives</option>
		  <option value="Germany">Germany</option>
		  <option value="Singapore">Singapore</option>
		  <option value="Malaysia">Malaysia</option>
		</select>
		<br>
		<label for="packagePrice"><strong>Package price</strong></label><br>
		<input type="number"  id="packagePrice" name="packagePrice" placeholder="Enter the package price" min=10000 required>
		<br>
		<label for="days"><strong>Days</strong></label><br>
		<input type="number" id="days" name="days" placeholder="Enter the number of days" min=3 max=15 required>
		<br>
		<label for="startDate"><strong>Journey start date</strong></label><br>
		<input type="date" id="startDate" name="startDate" placeholder="Journey start date" required>
		<br>
		<label for="endDate"><strong>Journey end date</strong></label><br>
		<input type="date" id="endDate" name="endDate" placeholder="Journey end date" required>
		<br>
		<label for="hotelName"><strong>Hotel Name</strong></label><br>
		<select name="hotelName" id="hotelName">
		  <option value="" disabled>Select hotel name</option>
		  <option value="ibis Styles Dubai Jumeira">Ibis Styles Dubai Jumeira-Dubai</option>
		  <option value="Crowne Plaza Dubai Festival City">Crowne Plaza Dubai-Dubai</option>
		  <option value="Angaga Island Resort Spa">Angaga Island Resort-Maldives</option>
		  <option value="Paradise Island Resort Maldives">Paradise Island Resort-Maldives</option>
		  <option value="Park Inn by Radisson">Park Inn by Radisson-Germany</option>
		  <option value="Leonardo Royal Hotel Frankfurt">Leonardo Royal Hotel Frankfurt-Germany</option>
		  <option value="Hilton Singapore">Hilton Singapore-Singapore</option>
		  <option value=" Marina Bay Sands Singapore">Marina Bay Sands-Singapore</option>
		  <option value=" Four Seasons Hotel Kuala Lumpur">Four Seasons Hote-Malaysia</option>
		  <option value=" Banyan Tree Kuala Lumpur">Banyan Tree-Malaysia</option>
		</select>
		<br>
		<br>
		<button type="submit" class="btn btn-primary">Submit</button>
		<button  type="reset" class="btn btn-danger">Reset</button>
		</form>
	</main>
	<script>
	function addPackage(){
		event.preventDefault();
		let countryName=document.querySelector("#countryName").value;
		let packagePrice=document.querySelector("#packagePrice").value;
		let days=document.querySelector("#days").value;
		let startDate=document.querySelector("#startDate").value;
		let endDate=document.querySelector("#endDate").value;
		let hotelName=document.querySelector("#hotelName").value;
		let packages={
				"packageName":countryName,
				"packagePrice":packagePrice,
				"numberOfDays":days,
				"startDate":startDate,
				"endDate":endDate,
				"hotelName":hotelName
		}
		console.log(packages);
		let url="AddPackagesAction";
		content="";
		axios.post(url,packages).then(res=>{
			let data=res.data;
			console.log(data);
			alert(data.infoMessage);
			window.location.href="AddPackage.jsp";
		}).catch(err=>{
			let data=err.response.data;
			content+=data.errorMessage;
			document.querySelector("#message").innerHTML=content;
			
		});
	}
	</script>
</body>
</html>
