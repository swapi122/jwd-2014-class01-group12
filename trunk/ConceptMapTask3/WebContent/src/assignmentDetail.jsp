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
	<h2>Assignment Details</h2>
	<hr>
	<div class="tabbable"">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#panel-Detail-1" data-toggle="tab">Details</a></li>
			<li><a href="#panel-Detail-2" data-toggle="tab">Assign for
					Student</a></li>
			<li><a href="#panel-Detail-3" data-toggle="tab">Answer key</a></li>
			<li><a href="#panel-Detail-4" data-toggle="tab">Answers</a></li>
		</ul>
		<div class="tab-content">
			<!-- 
			---------------------------------------
			Content of Tab-1: Details form 
			-->

			<div class="tab-pane active" id="panel-Detail-1">
				<form action="" method="post" class="form-horizontal">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
							<p></p>
							<div class="form-group">
								<label class="col-lg-4 control-label" for="assName">Assignment
									Name*</label>
								<div class="col-lg-6">
									<input name="assName" class="form-control"
										value="System Architect" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-4 control-label">Created date</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" value="21/09/2014" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-4 control-label">Started date</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" value="23/09/2014" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-4 control-label">Deadline</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" value="30/09/2014" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-4 control-label">Max Mark</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" value="100" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-4 control-label">Pass Mark</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" value="90" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-4 control-label">Published</label>
								<div class="col-lg-6">
									<input type="checkbox" class="checkbox" checked="checked" />
								</div>
							</div>
						</div>
						<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
							<p></p>

							<div class="form-group">
								<label class="col-lg-4 control-label">Requirement</label>
								<div class="col-lg-4">
									<textarea class="form-control"
										style="width: 360px; height: 140px;">
										This is Requirement for assignment!
										</textarea>
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-4 control-label">Description</label>
								<div class="col-lg-4">
									<textarea class="form-control"
										style="width: 360px; height: 140px;">
										This is Description for assignment!
										</textarea>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-2 col-md-offset-5">
							<input type="submit" class="btn btn-success btn-default"
								value="Save" /> <a class="btn btn-danger btn-default"
								href="listAssignment.jsp">Back</a>
						</div>
					</div>
				</form>
			</div>

			<!-- 
				-------------------------------------------------
				Content of Tab-2: List Assigned
				-->
			<div class="tab-pane" id="panel-Detail-2">
				<br>
				<div class="col-md-12" style="padding-left: 400px;">
				<form action="" method="post" class="form-horizontal">
					<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
						<div class="form-group">
							<label class="col-lg-4 control-label">Student ID:</label>
							<div class="col-lg-4">
								<input id="inputContactName" type="text" class="form-control" />
							</div>
							<a class="btn btn-primary" id="lookupcontact">Add</a>
						</div>
					</div>
				</form>
				</div>
				<hr>
				<div class="col-md-12">
					<div class="row clearfix">
						<div class="col-md-6 column">
							<h3>List of student are assigned:</h3>
						</div>

					</div>
				</div>
				<div>
					<table id="listStudent" class="table table-striped table-bordered"
						cellspacing="0" width="100%">
						<thead>
							<tr>
								<th>No.</th>
								<th>Student ID</th>
								<th>Student Name:</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>123</td>
								<td>Nguyen Van A</td>
							</tr>
							<tr>
								<td>2</td>
								<td>243</td>
								<td>Nguyen Van B</td>
							</tr>
							<tr>
								<td>3</td>
								<td>341</td>
								<td>Ly Thi C</td>
							</tr>
							<tr>
								<td>4</td>
								<td>764</td>
								<td>Tran Van D</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

			<!-- 
				-------------------------------------------------
				Content of Tab-3:  Key answer
				-->

			<div class="tab-pane" id="panel-Detail-3" style="padding-top: 30px;">
				<a href="conceptmapDetail.jsp">Click here to view key answer detail.</a>
			</div>

			<!-- 
				-------------------------------------------------
				Content of Tab-3:  List of Answers
				-->
			<div class="tab-pane" id="panel-Detail-4">
				<div class="col-md-12 column">
					<div class="row clearfix">
						<div class="col-md-6 column">
							<h3>List of Answers:</h3>
						</div>
					</div>
				</div>

				<div>
					<table id="listAnswers" class="table table-striped table-bordered"
						cellspacing="0" width="100%">
						<thead>
							<tr>
								<th>No.</th>
								<th>Student ID</th>
								<th>Student Name</th>
								<th>Submited date</th>
								<th>Mark</th>
								<th>Detail</th>
							</tr>
						</thead>
						<tbody id="tbody">
							<tr>
								<td>1</td>
								<td>123</td>
								<td>Nguyen Van A</td>
								<td>20/09/2014</td>
								<td>90/100</td>
								<td><a href="conceptmapDetail.jsp">View</a></td>
							</tr>
							<tr>
								<td>2</td>
								<td>243</td>
								<td>Nguyen Van B</td>
								<td>20/09/2014</td>
								<td>90/100</td>
								<td><a href="conceptmapDetail.jsp">View</a></td>
							</tr>
							<tr>
								<td>3</td>
								<td>341</td>
								<td>Ly Thi C</td>
								<td>20/09/2014</td>
								<td>30/100</td>
								<td><a href="conceptmapDetail.jsp">View</a></td>
							</tr>
							<tr>
								<td>4</td>
								<td>764</td>
								<td>Tran Van DD</td>
								<td>20/09/2014</td>
								<td>90/100</td>
								<td><a href="conceptmapDetail.jsp">View</a></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

		</div>
	</div>
	<%@ include file="footer.jsp"%>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#listAnswers').dataTable();
			$('#listStudent').dataTable();
		});
	</script>
</body>
</html>