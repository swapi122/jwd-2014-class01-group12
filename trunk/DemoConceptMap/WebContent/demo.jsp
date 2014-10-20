<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="raphael-min.js"></script>
<script src="jquery-1.11.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CONCEPT MAP APPLICATION-GROUP 12</title>
<link rel='stylesheet' href='style.css' type='text/css' />
<script type="text/javascript">
  
  </script>
</head>
<body>
	<div id="header">CONCEPT MAP APPLICATION-GROUP 12</div>
	<div>
		<button onclick='drawCircle();'>DrawCircle</button>
		<button onclick='drawRelation();'>DrawRelation</button>
		<button onclick='displayJson();'>View Json</button>
		<button onclick='displayMapTable();'>View Map Table</button>
		<button onclick='Submit();'>Submit</button>
		Concept map name: <input id="conceptMapName" type="text" /> 
		Concept text: <input id="textContent" type="text" /> 
		Concept ID: <input id="textID" type="text" style="width: 70px;"/>
	</div>

	<div>
		<textarea id="txtJson" col="50" rows="5">Json string here...</textarea>
	</div>
	<p id="note"></p>
	<div id="notepad" style="background: rgb(222, 223, 205); height: 100%;"></div>
	<script>
 
 
    window.onload = function() {
		paper=Raphael(document.getElementById('notepad'), "100%", "100%");
		x=100;
		i=0;
		relations=[];
		shapes =[];
		cmd=0;
		tmp=[];
		currentObj=null;
		cmObj={"Name":"CM1", "Relations":[]};
		relation={"concept1":{"ID":"","name":""},"concept2":{"ID":"","name":""},"title":"chua"};
		concept={"name":"","ID":""};
		mapTable=[];
		conceptNames=[];
		row=[];
		j=0;
		
    };
  </script>
	<script src="myscript.js"></script>

</body>
</html>