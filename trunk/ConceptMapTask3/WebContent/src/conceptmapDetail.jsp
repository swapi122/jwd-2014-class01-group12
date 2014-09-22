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
<style type="text/css">
#drawspace{
	width: 1000px;
	border: 1px solid black;
	margin: 0 auto;
}
.button-toolbar{
	width: 60px;
	height: 60px;
}
#toolbar{
	float: left;
	padding: 2px;
	height: 70px; 
	width: 1000px;
	border: 1px solid black;
	background: #FFFFFF;
}
#workspace{
	height:500px;
	background: #F0F0F0;
}
img{
	margin-left: 5px;
}
</style>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="drawspace">
		<div id="toolbar">
			<a><img class="button-toolbar" src="../images/add.gif"></a>
			<a><img class="button-toolbar" src="../images/save.png"></a>
			<a><img class="button-toolbar" src="../images/shape.png"></a>
			
			<a><img class="button-toolbar" src="../images/attach.png"></a>
			<a><img class="button-toolbar" src="../images/relationship.jpg"></a>
			<a><img class="button-toolbar" src="../images/submit.png"></a>
			<a><img class="button-toolbar" src="../images/delete.png"></a>
			<a><img class="button-toolbar" src="../images/share.png"></a>
			<a><img style="width: 300px; height: 60px;" src="../images/color-table.png"></a>
			<a href="assignmentDetail.jsp"><img class="button-toolbar" src="../images/back.png"></a>
		</div>
		<div id="workspace">
			<img alt="concept map here" src="../images/Concept_Map_Administrator.png">
		</div>
	</div>
	<%@ include file="footer.jsp"%>

</body>
</html>