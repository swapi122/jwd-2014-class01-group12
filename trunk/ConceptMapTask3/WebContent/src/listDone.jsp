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
	<h3>List of answer for task: ABC....</h3>
	<hr>
	
	<table id="listTask" class="display" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>Title</th>
				<th>Create date</th>
				<th>Submitted ?</th>
				<th>Submitted date</th>
				<th>Mark</th>
				<th>Feedback</th>
				
			</tr>
		</thead>
		<tbody>
			<tr class="tr-task">
				<td><a href="conceptmapDetail.jsp">Answer 1</a></td>
				<td>2014/04/25</td>
				<td>Yes</td>
				<td>2014/04/30</td>
				<td>70</td>
				<td><a href="feedback.jsp">View</a></td>
				
			</tr>
			<tr class="tr-task">
				<td><a href="conceptmapDetail.jsp">Answer 2</a></td>
				<td>2014/07/25</td>
				<td>Yes</td>
				<td>2014/07/29</td>
				<td>80</td>
				<td><a href="feedback.jsp">View</a></td>
				
			</tr>
			<tr class="tr-task">
				<td><a href="conceptmapDetail.jsp">Answer 3</a></td>
				<td>2014/01/12</td>
				<td>No</td>
				<td>--</td>
				<td>--</td>
				<td>--</td>
				
			</tr>
			<tr class="tr-task">
				<td><a href="conceptmapDetail.jsp">Answer 4</a></td>
				<td>2014/07/25</td>
				<td>No</td>
				<td>--</td>
				<td>--</td>
				<td>--</td>
				
			</tr>
			<tr class="tr-task">
				<td><a href="conceptmapDetail.jsp">Answer 5</a></td>
				<td>2014/07/25</td>
				<td>Yes</td>
				<td>2014/07/25</td>
				<td>40</td>
				<td><a href="feedback.jsp">View</a></td>
				
			</tr>
			<tr class="tr-task">
				<td><a href="conceptmapDetail.jsp">Answer 6</a></td>
				<td>2014/07/25</td>
				<td>Yes</td>
				<td>2014/07/29</td>
				<td>70</td>
				<td><a href="feedback.jsp">View</a></td>
				
			</tr>
			<tr class="tr-task">
				<td><a href="conceptmapDetail.jsp">Answer 7</a></td>
				<td>2014/07/25</td>
				<td>No</td>
				<td>--</td>
				<td>--</td>
				<td>--</td>
				
			</tr>
		</tbody>
	</table>
<a class="btn btn-primary" href="newConceptmap.jsp">Create</a>
<a class="btn btn-danger" href="listTask.jsp">Back to List task</a>
	<%@ include file="footer.jsp"%>
<script type="text/javascript">
$(document).ready(function() {
    $('#listTask').dataTable();
} );

$(document).on("click", "tr.tr-task", function(e) {
	//alert(this.getElementsByTagName("td")[2].childNodes[0].nodeValue.trim());
	var v = this;
	
	if(v.getElementsByTagName("td")[2].childNodes[0].nodeValue.trim() == "No"){
		bootbox
        .confirm(
            "Do you want to submit this answer?",
            function(result) {
                if (result == true) {
                	v.getElementsByTagName("td")[2].childNodes[0].nodeValue = "Yes";
                	v.getElementsByTagName("td")[3].childNodes[0].nodeValue = "2014/09/12";
                	v.getElementsByTagName("td")[4].childNodes[0].nodeValue = "80";
                	v.getElementsByTagName("td")[5].innerHTML = "<a href=\"feedback.jsp\">View</a>";
                	
                } else {

                }
            });
	}
});
</script>
</body>
</html>