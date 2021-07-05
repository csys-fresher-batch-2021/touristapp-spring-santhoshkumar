<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>UserLogin</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<p id="message"></p>
	<h3>Login</h3>
	<form onsubmit="userLogin()" method="post">
	
		<label for="mobileNumber"><strong>Mobile Number</strong></label><br>
		<input type="tel" name="mobileNumber" id="mobileNumber" placeholder="Enter your mobile number" autofocus required><br>
		<label for="password" ><strong>Password</strong></label><br>
		<input type="password" name="password" id="password" placeholder="Enter your password" required><br>
		<br>
		<a href="ForgotPassword.jsp">Forgot Password</a>
		<br>
		<button type="submit" class="btn btn-primary">Submit</button>
		<button  type="reset" class="btn btn-danger">Reset</button>
	</form>
</main>
<script>

function userLogin()
{
	event.preventDefault();
	let mobileNumber=document.querySelector("#mobileNumber").value;
	let password=document.querySelector("#password").value;
	localStorage.setItem("role","USER");
	let user={
			"mobileNumber":mobileNumber,
			"password":password
	}
	let url="UserLoginAction";
	content="";
	console.log(user);
	axios.post(url,user).then(res=>{
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