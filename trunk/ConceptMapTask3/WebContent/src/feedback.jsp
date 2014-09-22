<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of task</title>
<!-- Bootstrap core CSS -->
<link href="../css/bootstrap.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="../css/sticky-footer-navbar.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="../css/jquery.dataTables.css" rel="stylesheet">
<!-- Placed at the end of the document so the pages load faster -->
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.js"></script>
<script type="text/javascript" src="../js/jquery.dataTables.js"></script>
<!-- bootbox code -->
<script src="../js/bootbox.min.js"></script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<h3>Feedback for your answer:</h3>
	<p><span style="font-weight: bold;">Task name:</span> Software</p>
	<p><span style="font-weight: bold;">Answer:</span> Answer 5</p>
	<p><span style="font-weight: bold;">Mark:</span> 70/100</p>
	<p><span style="font-weight: bold;">View following reference document to complete your answer :</span></p>
	<ul>
		<li><a>Concept ABC</a></li>
		<li><a>Concept ADS</a></li>
		<li><a>Concept XYZ</a></li>
	</ul>
	<a class="btn btn-primary" href="listDone.jsp">Back to list answer</a>
	<%@ include file="footer.jsp"%>
</body>
</html>