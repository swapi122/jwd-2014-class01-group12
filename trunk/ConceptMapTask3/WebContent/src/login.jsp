<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<!-- Bootstrap core CSS -->
<link href="../css/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../css/signin.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../css/cover.css" rel="stylesheet">
<!-- Placed at the end of the document so the pages load faster -->
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.js"></script>
</head>
<body>
	<div class="site-wrapper">
		<div class="site-wrapper-inner">

			<div class="cover-container">

				<div class="masthead clearfix">
					<div class="inner">
						<h3 class="masthead-brand" style="color: #FF1F00; font-weight: bold;">CONCEPT MAP PROJECT</h3>
						<ul class="nav masthead-nav">
							<li class="active"><a href="#">Home</a></li>
							<li><a href="#">Features</a></li>
							<li><a href="#">Contact</a></li>
						</ul>
					</div>
				</div>

				<div class="inner cover">
					<form class="form-signin" role="form">
						<h3 class="form-signin-heading">Please login</h3>

						<input type="email" class="form-control"
							placeholder="Email address" required autofocus> <input
							type="password" class="form-control" placeholder="Password"
							required> <label>Login as: </label> 
							<input type="radio" name="login-as" value="teacher"> Teacher 
							<input type="radio" name="login-as" value="student" checked="checked"> Student 
							<label class="checkbox">
							<input type="checkbox" value="remember-me">Remember me
						</label>
						<a class="btn btn-lg btn-primary btn-block"  onclick="proccessLogin();">Login</a>
					</form>
				</div>

				<div class="mastfoot">
					<div class="inner">
						<p>
							Copyright (c) Group 12 - CONCEPT MAP PROJECT
						</p>
					</div>
				</div>

			</div>

		</div>

	</div>
<script type="text/javascript">
function proccessLogin(){
	var v = $('input[name="login-as"]:checked').val();
	//alert(v);
	if(v.trim() == "student"){
		window.location.href="listTask.jsp";
	}
	else{
		window.location.href="listAssignment.jsp";
	}
}
</script>
</body>
</html>