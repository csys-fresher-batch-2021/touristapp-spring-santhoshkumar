<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<p id="message"></p>
	<form onsubmit="addUser()" method="post">
	<label for="name"><strong>Name</strong></label><br>
	<input type="text" name="name" id="name" placeholder="Enter your name" required autofocus><br>
	
	<label for="age"><strong>Age</strong></label><br>
	<input type="number" name="age" id="age" placeholder="Enter your age" required min="18"><br>
	
	<label for="gender"><strong>Gender</strong></label><br>
	<input type="radio" value="Male" name="gender" id="gender" checked > Male   
	<input type="radio" value="Female" name="gender" id="gender"> Female<br>   
	
	<label for="mobileNumber"><strong>Mobile Number</strong></label><br>
	<input type="tel" name="mobileNumber" id="mobileNumber" placeholder="Enter your mobile number" required><br>
	
	<label for="password"><strong>Set Password</strong></label><br>
	<input type="password" name="password" id="password" placeholder="Enter your password" required><br>
	<p class="text-muted"><em>* First letter should be capital and length should be greater than 8</em></p>
	
	<label for="retypepassword"><strong>Re-type password</strong></label><br>
	<input type="password" name="retypepassword" id="retypePassword" placeholder="Retype your password" required><br>
	<br>
	<button type="submit" class="btn btn-primary">Submit</button>
	<button  type="reset" class="btn btn-danger">Reset</button>
	</form>

</main>
<script>
function addUser(){
	event.preventDefault();
	let name=document.querySelector("#name").value;
	let age=document.querySelector("#age").value;
	let gender=document.querySelector("#gender").value;
	let mobileNumber=document.querySelector("#mobileNumber").value;
	let password=document.querySelector("#password").value;
	let retypePassword=document.querySelector("#retypePassword").value;
	let user={
			"name":name,
			"age":age,
			"gender":gender,
			"mobileNumber":mobileNumber,
			"password":password,
			"reTypePassword":retypePassword
	
		
	}
	console.log(user);
	let url="RegistrationAction";
	content="";
	axios.post(url,user).then(res=>{
		let data=res.data;
		content+=data.infoMessage;
		document.querySelector("#message").innerHTML=content;
		
		
	}).catch(err=>{
		let data = err.response.data;
		content+=data.errorMessage;
		document.querySelector("#message").innerHTML=content;

	});
		
}
</script>
</body>
</html>