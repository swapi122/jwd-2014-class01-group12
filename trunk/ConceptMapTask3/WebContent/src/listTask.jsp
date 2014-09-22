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
	<h3>List of Student's task:</h3><hr>
	
	<table id="listTask" class="display" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>Title</th>
				<th>OfTeacher</th>
				<th>Started Date</th>
				<th>Due to</th>
				<th>Max Mark</th>
				<th>Pass Mark</th>
				<th>Status?</th>
			</tr>
		</thead>
		<tbody>
			<tr class="tr-task">
				<td>Tiger Nixon</td>
				<td>System Architect</td>
				<td>2011/04/25</td>
				<td>2011/04/30</td>
				<td>100</td>
				<td>60</td>
				<td><span style="color: red;">New</span></td>
			</tr>
			<tr class="tr-task">
				<td>Garrett Winters</td>
				<td>Accountant</td>
				<td>2011/07/25</td>
				<td>2011/07/29</td>
				<td>100</td>
				<td>70</td>
				<td><span style="color: red;">New</span></td>
			</tr>
			<tr class="tr-task">
				<td>Ashton Cox</td>
				<td>Junior Technical Author</td>
				<td>2009/01/12</td>
				<td>2009/01/20</td>
				<td>100</td>
				<td>50</td>
				<td><span style="color: red;">New</span></td>
			</tr>
			<tr class="tr-task">
				<td>Cedric Kelly</td>
				<td>Senior Javascript Developer</td>
				<td>2011/07/25</td>
				<td>2011/07/29</td>
				<td>100</td>
				<td>70</td>
				<td>Done</td>
			</tr>
			<tr class="tr-task">
				<td>Airi Satou</td>
				<td>Accountant</td>
				<td>2011/07/25</td>
				<td>2011/07/29</td>
				<td>100</td>
				<td>70</td>
				<td>Done</td>
			</tr>
			<tr class="tr-task">
				<td>Brielle Williamson</td>
				<td>Integration Specialist</td>
				<td>2011/07/25</td>
				<td>2011/07/29</td>
				<td>100</td>
				<td>70</td>
				<td>Done</td>
			</tr>
			<tr class="tr-task">
				<td>Herrod Chandler</td>
				<td>Sales Assistant</td>
				<td>2011/07/25</td>
				<td>2011/07/29</td>
				<td>100</td>
				<td>70</td>
				<td>Done</td>
			</tr>
		</tbody>
	</table>
	<%@ include file="footer.jsp"%>
<script type="text/javascript">
$(document).ready(function() {
    $('#listTask').dataTable();
} );

$(document).on("click", "tr.tr-task", function(e) {
	bootbox.dialog({
		  message: "What do you want?",
		  title: "Action",
		  buttons: {
		    success: {
		      label: "View list",
		      className: "btn-success",
		      callback: function() {
		        location.href="listDone.jsp";
		      }
		    },
		   
		    main: {
		      label: "Do task",
		      className: "btn-primary",
		      callback: function() {
		    	  location.href="newConceptmap.jsp";
		      }
		    }
		  }
		});
});
</script>
</body>
</html>