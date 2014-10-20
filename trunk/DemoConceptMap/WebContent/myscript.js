Raphael.fn.connection = function (obj1, obj2, line, bg) {

	if (obj1.line && obj1.from && obj1.to) {
		line = obj1;
		obj1 = line.from;
		obj2 = line.to;
	}
	var bb1 = obj1.getBBox(),
	bb2 = obj2.getBBox(),
	p = [{x: bb1.x + bb1.width / 2, y: bb1.y - 1},
	     {x: bb1.x + bb1.width / 2, y: bb1.y + bb1.height + 1},
	     {x: bb1.x - 1, y: bb1.y + bb1.height / 2},
	     {x: bb1.x + bb1.width + 1, y: bb1.y + bb1.height / 2},
	     {x: bb2.x + bb2.width / 2, y: bb2.y - 1},
	     {x: bb2.x + bb2.width / 2, y: bb2.y + bb2.height + 1},
	     {x: bb2.x - 1, y: bb2.y + bb2.height / 2},
	     {x: bb2.x + bb2.width + 1, y: bb2.y + bb2.height / 2}],
	     d = {}, dis = [];
	for (var i = 0; i < 4; i++) {
		for (var j = 4; j < 8; j++) {
			var dx = Math.abs(p[i].x - p[j].x),
			dy = Math.abs(p[i].y - p[j].y);
			if ((i == j - 4) || (((i != 3 && j != 6) || p[i].x < p[j].x) && ((i != 2 && j != 7) || p[i].x > p[j].x) && ((i != 0 && j != 5) || p[i].y > p[j].y) && ((i != 1 && j != 4) || p[i].y < p[j].y))) {
				dis.push(dx + dy);
				d[dis[dis.length - 1]] = [i, j];
			}
		}
	}
	if (dis.length == 0) {
		var res = [0, 4];
	} else {
		res = d[Math.min.apply(Math, dis)];
	}
	var x1 = p[res[0]].x,
	y1 = p[res[0]].y,
	x4 = p[res[1]].x,
	y4 = p[res[1]].y;
	dx = Math.max(Math.abs(x1 - x4) / 2, 10);
	dy = Math.max(Math.abs(y1 - y4) / 2, 10);

	var x2 = [x1, x1, x1 - dx, x1 + dx][res[0]].toFixed(3),
	y2 = [y1 - dy, y1 + dy, y1, y1][res[0]].toFixed(3),
	x3 = [0, 0, 0, 0, x4, x4, x4 - dx, x4 + dx][res[1]].toFixed(3),
	y3 = [0, 0, 0, 0, y1 + dy, y1 - dy, y4, y4][res[1]].toFixed(3);
	var path = ["M", x1.toFixed(3), y1.toFixed(3), "C", x2, y2, x3, y3, x4.toFixed(3), y4.toFixed(3)].join(",");
	// paper.text(x3, y3,"asdf").attr({fill:"red"});
	if (line && line.line) {
		line.bg && line.bg.attr({path: path});
		line.line.attr({path: path});
	} else {
		var color = typeof line == "string" ? line : "#000";
		return {
			bg: bg && bg.split && this.path(path).attr({stroke: bg.split("|")[0], fill: "none", "stroke-width": bg.split("|")[1] || 3}),
			line: this.path(path).attr({stroke: color, fill: "none"}),
			from: obj1,
			to: obj2,

		};
		this.rect(x1.toFixed(3), y1.toFixed(3),20,20);
	}

};

Raphael.st.draggable = function() {
	var me = this,
	lx = 0,
	ly = 0,
	ox = 0,
	oy = 0,
	moveFnc = function(dx, dy) {
		lx = dx + ox;
		ly = dy + oy;
		me.transform('t' + lx + ',' + ly);
		for (var i = relations.length; i--;) {
			paper.connection(relations[i]);
		}
		paper.safari();
	},
	startFnc = function() {
		this.ox = this.type == "rect" ? this.attr("x") : this.attr("cx");
		this.oy = this.type == "rect" ? this.attr("y") : this.attr("cy");
		this.animate({"fill-opacity": .2}, 500);
	},
	endFnc = function() {
		ox = lx;
		oy = ly;
		this.animate({"fill-opacity": 1.0}, 500);
	};

	this.drag(moveFnc, startFnc, endFnc);

};


function dragger() {
	this.ox = this.type == "rect" ? this.attr("x") : this.attr("cx");
	this.oy = this.type == "rect" ? this.attr("y") : this.attr("cy");
	this.animate({"fill-opacity": .2}, 500);
};
function move(dx, dy) {
	var att = this.type == "rect" ? {x: this.ox + dx, y: this.oy + dy} : {cx: this.ox + dx, cy: this.oy + dy};
	this.attr(att);
	for (var i = relations.length; i--;) {
		paper.connection(relations[i]);
	}
	paper.safari();
};
function up() {
	this.animate({"fill-opacity": 1.0}, 500);
};

function drawCircle(){
	i++;
	var c=paper.circle(x,100,50,50).attr({fill:"orange"});
	var initText="New "+i;
	var txt=paper.text(c.attr("cx"),c.attr("cy"),initText);
	// c.data("text",initText);
	// c.id=i;

	txt.attr({"fill":"white"});
	var mySet=paper.set();
	mySet.push(c);
	mySet.push(txt);
	x=x+50;
	
	// console.log(initText);

	mySet.data("content","New");
	mySet.id=i;
	
	conceptNames[i]=initText;
	
	mySet.click(function(){
		
		if(currentObj!=null){
			currentObj[0].attr({fill:"orange"});
		}
		
		currentObj=mySet;
		$("#textContent").val(currentObj[1].attr("text"));
		$("#textID").val(currentObj.id);
		if(cmd!=1){
			mySet[0].attr({fill:"green"});
		}
		
		console.log("cmd: "+cmd);
		if(cmd==1){
			console.log("cmd: "+cmd);
			row.push(currentObj.id);
			console.log("Row length: "+row.length);
			if(row.length==2){
				console.log("Vao trong ");
				mapTable.push(row);
				row=[];
				cmd=0;
			}

		}

	});

	// mySet.drag(move, dragger, up);
	// mySet.click(clickEventDrawRelation(mySet));
	mySet.mouseup(mousedownEventDrawRelation);
	mySet.mouseout(mouseoutEventDrawRelation);
	shapes.push(mySet);
	mySet.draggable();
};
function drawRelation(){
	cmd=1;
	$("#note").text("Click select 2 concept to draw relationship.");
	// relations.push(paper.connection(shapes[0], shapes[1], "red"));
	// var x1=shapes[0].attr("cx"),x2=shapes[1].attr("cx");
	// var y1=shapes[0].attr("cy"),y2=shapes[1].attr("cy");
	// paper.text((x1+x2)/2,(y1+y2)/2,"asdd");
	// l.click(clickevent);
	// l.drag(move, dragger, up);
	// l.draggable()
	// alert(relations[0].attr("x"));
};






function mousedownEventDrawRelation(){
	if(cmd==1){
		this.attr({fill:"red"});
		tmp.push(this);
		// console.log(currentObj.id);
		// row.push(currentObj.id);
		/*
		if(tmp.length==0){
			relation.concept1.name=currentObj[1].attr("text");
		}
		else{

			relation.concept2.name=currentObj[1].attr("text");
		}
		*/

		if(tmp.length==2){
			// tmp[0].attr({fill:"orange"});
			// tmp[1].attr({fill:"orange"});
			relations.push(paper.connection(tmp[0], tmp[1], "red"));
			// console.log(tmp[0]);
			// console.log(tmp[1]);
			/*
			 * var x1=tmp[0].attr("cx"),x2=tmp[1].attr("cx"); var
			 * y1=tmp[0].attr("cy"),y2=tmp[1].attr("cy"); var
			 * lbl=paper.text((x1+x2)/2,(y1+y2)/2,"asdd");
			 * relations.push(paper.connection(lbl,tmp[0],"red"));
			 * relations.push(paper.connection(lbl,tmp[1],"red"));
			 */
			cmObj.Relations.push(relation);


		}
	}
};

function mouseoutEventDrawRelation(){
	if(cmd==0){
		if(tmp.length==2){
			tmp[0].attr({fill:"orange"});
			tmp[1].attr({fill:"orange"});
			tmp=[];
			$("#note").text("");
		}
	}
	var str=$("input#textContent").val();
	console.log(str);
	//currentObj.attr({"text":str});

};

$("input#textContent").blur(function(){
	// alert("This input field has lost its focus.");
	var str=$("input#textContent").val();
	console.log(str);
	currentObj.attr({"text":str});
	var id=$("#textID").val();
	conceptNames[id]=str;
});


function viewJson(){
	var v = cmObj.Relations[0].concept1.name;
	alert(v);
};

function displayJson(){
	cmObj={"Name":""+$("#conceptMapName").val(),"Relations":[]};
	//var relation={"concept1":{"ID":"","name":""},"concept2":{"ID":"","name":""},"title":"chứa"};
	
	for(var i=0;i<mapTable.length;i++){
		var concept1ID=mapTable[i][0];
		var concept2ID=mapTable[i][1];
		
		console.log(concept1ID+" - "+concept2ID);
		
		var c1=paper.getById(concept1ID), c2=paper.getById(concept2ID);
		
		console.log(conceptNames[concept1ID] + " - " + conceptNames[concept2ID]);

		//relation.concept1.name=conceptNames[concept1ID];
		//relation.concept1.ID=concept1ID;
		
		//relation.concept2.name=conceptNames[concept2ID];
		//relation.concept2.ID=concept2ID;
		
		console.log("Pre push: Relation "+i + ": "+JSON.stringify(relation));
		
		
		cmObj.Relations.push({"concept1":{"ID":concept1ID,"name":""+conceptNames[concept1ID]},"concept2":{"ID":concept2ID,"name":""+conceptNames[concept2ID]},"title":"chua"});
		console.log("Post push: Relation "+i + ": "+JSON.stringify(cmObj.Relations[i]));
		
		
	}	
	console.log(cmObj);
	var str = JSON.stringify(cmObj);
	$("#txtJson").val(str);
	console.log("Final: "+str);
};

function displayMapTable(){
	var str="";
	for(var x=0;x<mapTable.length;x++){
		str+= mapTable[x][0] +"-"+ mapTable[x][1] +"\n";
	}
	$("#txtJson").val(str);
};

function Submit() {
	  
	  cmObj={"Name":""+$("#conceptMapName").val(),"Relations":[]};
		//var relation={"concept1":{"ID":"","name":""},"concept2":{"ID":"","name":""},"title":"chua"};
		
		for(var i=0;i<mapTable.length;i++){
			var concept1ID=mapTable[i][0];
			var concept2ID=mapTable[i][1];
			
			console.log(concept1ID+" - "+concept2ID);
			
			var c1=paper.getById(concept1ID), c2=paper.getById(concept2ID);
			
			console.log(conceptNames[concept1ID] + " - " + conceptNames[concept2ID]);

			//relation.concept1.name=conceptNames[concept1ID];
			//relation.concept1.ID=concept1ID;
			
			//relation.concept2.name=conceptNames[concept2ID];
			//relation.concept2.ID=concept2ID;
			
			console.log("Pre push: Relation "+i + ": "+JSON.stringify(relation));
			
			
			cmObj.Relations.push({"concept1":{"ID":concept1ID,"name":""+conceptNames[concept1ID]},"concept2":{"ID":concept2ID,"name":""+conceptNames[concept2ID]},"title":"chua"});
			console.log("Post push: Relation "+i + ": "+JSON.stringify(cmObj.Relations[i]));
			
			
		}	
		console.log(cmObj);
		var str = JSON.stringify(cmObj);
		$("#txtJson").val(str);
		console.log("Final: "+str);
		
	  //var jsondata=$("#txtJson").val();
	  var jsondata=str;
	  $.ajax({
        url:"ConceptMapController?cm="+jsondata,
        type: "POST",
        success:function(data) {
           alert(data);
        },
        error:function(data){
      	  
      }
   });
};