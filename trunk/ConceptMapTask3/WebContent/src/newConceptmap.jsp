<%@page import="vn.edu.hcmute.dao.ConceptMapDAO"%>
<%@page import="vn.edu.hcmute.entity.ConceptMap"%>
<%@page import="java.util.List"%>
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
<link rel="stylesheet" type="text/css" href="../css/joint.css">
<link rel="stylesheet" type="text/css" href="../css/DrawConceptMap.css">
</head>
<body>
	<%@ include file="header.jsp"%>
			<div id="paper-container" ></div>
			<div id="inspector-container"></div>
			<div id="toolbar-container">
		 		<button class="btn-drive-load" onclick="toolbar.loadGraph()" data-tooltip="Load">
		        	<img src="../images/load.png"/><span>Load</span>
		         </button>
		         <button class="btn-drive-save" onclick="toolbar.saveGraph()" data-tooltip="Save">
		         	<img src="../images/load.png"/><span>Save</span>
		         </button>
		         <button class="btn-print" onclick="paper.print()" data-tooltip="Print">
		         	<img src="../images/print.png"/>
		         </button>
		         <button class="btn-json" onclick="toolbar.toJSON()" data-tooltip="Open As JSON">
		         	<img src="../images/json.png"/>
		         </button>
		         <button class="btn-zoom-in" onclick="paperScroller.zoom(0.2, { max: 4 })" data-tooltip="Zoom In">
		         	<img src="../images/zoomin.png"/>
		         </button>
		         <button class="btn-zoom-out" onclick="paperScroller.zoom(-0.2, { min: 0.2 })" data-tooltip="Zoom Out">
		         	<img src="../images/zoomout.png"/>
		         </button>
		         <button class="btn-clear" onclick="graph.clear()" data-tooltip="Clear">
		         	<img src="../images/clear.png"></img>
		         </button>
		         <button class="btn-undo" onclick="commandManager.undo()" data-tooltip="Undo">
		         	<img src="../images/undo.png"></img>
		         </button>
		         <button class="btn-redo" onclick="commandManager.redo()" data-tooltip="Redo">
		         	<img src="../images/rendo.png"></img>
		         </button>
		         <input id="fileName" type="text">
    		</div>
    		<div id="stencil-container"></div>
		   
	<%@ include file="footer.jsp"%>
	<script src="../js/keyboard.js"></script>
	<script src="../js/joint.js"></script>
	<script src="../js/DrawConceptMap.js"></script>
</body>
</html>