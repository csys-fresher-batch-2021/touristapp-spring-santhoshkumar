<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<p id="message"></p>
	
	<h3>Login</h3>
	<form onsubmit="adminLogin()" method="post">
		<label for="mobileNumber"><strong>Mobile Number</strong></label><br>
		<input type="tel"  id="mobileNumber" name="mobileNumber" placeholder="Enter your mobile number" autofocus required><br>
		<label for="password" ><strong>Password</strong></label><br>
		<input type="password" id ="password" name="password" placeholder="Enter your password" required><br>
	
		<br>
		<button type="submit" class="btn btn-primary">Submit</button>
		<button  type="reset" class="btn btn-danger">Reset</button>
	</form>
</main>
<script>
function adminLogin()
{
	event.preventDefault();
	let mobileNumber=document.querySelector("#mobileNumber").value;
	let password=document.querySelector("#password").value;
	localStorage.setItem("role","ADMIN");
	let admin={
			"mobileNumber":mobileNumber,
			"password":password
	}
	let url="AdminLoginAction";
	content="";
	console.log(admin);
	axios.post(url,admin).then(res=>{
		let data=res.data;
		console.log(data);
		alert(data.infoMessage);
		window.location.href="index.jsp";
		
	}).catch(err=>{
		let data=err.response.data;
		content+=data.errorMessage;
		document.querySelector("#message").innerHTML=content;
	});
	}
</script>
</body>
</html>