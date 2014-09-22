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
	<h3>List of Assignment:</h3>
	<a class="btn btn-primary" href="createAssignment.jsp" style="float: right; margin: 20px;">Create</a>
	<hr>
	
	<table id="listAssignment" class="display" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>No.</th>
				<th>Name</th>
				<th>Created date</th>
				<th>Started date</th>
				<th>Dead line</th>
				<th>Published ?</th>
				<th>Max Mark</th>
				<th>Pass Mark</th>
				<th>Detail</th>
			</tr>
		</thead>
		<tbody>
			<tr class="tr-task">
				<td>1</td>
				<td>System Architect</td>
				<td>2014/04/25</td>
				<td>2014/04/27</td>
				<td>2014/04/30</td>
				<td>Yes</td>
				<td>100</td>
				<td>50</td>
				<td><a href="assignmentDetail.jsp">View</a></td>
			</tr>
			<tr class="tr-task">
				<td>2</td>
				<td>System Architect</td>
				<td>2014/07/14</td>
				<td>2014/07/20</td>
				<td>2014/07/30</td>
				<td>No</td>
				<td>100</td>
				<td>80</td>
				<td><a href="assignmentDetail.jsp">View</a></td>
			</tr>
			<tr class="tr-task">
				<td>3</td>
				<td>Cedric Kelly</td>
				<td>2014/04/25</td>
				<td>2014/04/27</td>
				<td>2014/04/30</td>
				<td>No</td>
				<td>100</td>
				<td>50</td>
				<td><a href="assignmentDetail.jsp">View</a></td>
			</tr>
			<tr class="tr-task">
				<td>4</td>
				<td>System Architect</td>
				<td>2014/04/25</td>
				<td>2014/04/27</td>
				<td>2014/04/30</td>
				<td>Yes</td>
				<td>100</td>
				<td>90</td>
				<td><a href="assignmentDetail.jsp">View</a></td>
			</tr>
			<tr class="tr-task">
				<td>5</td>
				<td>System Architect</td>
				<td>2014/04/25</td>
				<td>2014/04/27</td>
				<td>2014/04/30</td>
				<td>No</td>
				<td>100</td>
				<td>60</td>
				<td><a href="assignmentDetail.jsp">View</a></td>
			</tr>
			<tr class="tr-task">
				<td>6</td>
				<td>System Architect</td>
				<td>2014/04/25</td>
				<td>2014/04/27</td>
				<td>2014/04/30</td>
				<td>Yes</td>
				<td>100</td>
				<td>100</td>
				<td><a href="assignmentDetail.jsp">View</a></td>
			</tr>
			<tr class="tr-task">
				<td>7</td>
				<td>System Architect</td>
				<td>2014/04/25</td>
				<td>2014/04/27</td>
				<td>2014/04/30</td>
				<td>Yes</td>
				<td>100</td>
				<td>50</td>
				<td><a href="assignmentDetail.jsp">View</a></td>
			</tr>
		</tbody>
	</table>
	
	<%@ include file="footer.jsp"%>
<script type="text/javascript">
$(document).ready(function() {
    $('#listAssignment').dataTable();
} );

$(document).on("click", "tr.tr-task", function(e) {
	//alert(this.getElementsByTagName("td")[2].childNodes[0].nodeValue.trim());
	var v = this;
	
	if(v.getElementsByTagName("td")[5].childNodes[0].nodeValue.trim() == "No"){
		bootbox
        .confirm(
            "Do you want to publish this assignment?",
            function(result) {
                if (result == true) {
                	v.getElementsByTagName("td")[5].childNodes[0].nodeValue = "Yes";
                	
                } else {

                }
            });
	}
});
</script>
</body>
</html>