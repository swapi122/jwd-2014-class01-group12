var inspector;

/* GRAPH */

var graph = new joint.dia.Graph;

var commandManager = new joint.dia.CommandManager({ graph: this.graph });

/* PAPER + SCROLLER */
var link = new joint.dia.Link({
	labels: [
	         { position: .5, attrs: { text: { text: 'label' } } }
	     ],
    attrs: {
    	'.connection': { stroke: 'blue' },
        '.marker-target': { fill: 'yellow', d: 'M 10 0 L 0 5 L 10 10 z' }
    }
});
var paper = new joint.dia.Paper({
    width: 2000,
    height: 2000,
    model: graph,
    gridSize: 10,
    model: graph,
    perpendicularLinks: true,
    perpendicularLinks: true,
    defaultLink: link
}).on({

    'blank:pointerdown': function(evt,x,y) {

    	paperScroller.startPanning(evt, x, y);
    },
    'blank:pointerdblclick': function(evt,x,y) {
    	var c = new joint.shapes.basic.Circle({ 
            position: { x: x, y: y }, size: { width: 110, height: 65 },
            attrs: { circle: { fill: '#9B59B6' }, text: { text: 'new concept', fill: 'black' } }
        });
    	graph.addCell(c);
    	 
    },
   

    'cell:pointerup': function(cellView) {

    	createInspector(cellView);
        if (cellView.model instanceof joint.dia.Link) return;
        var halo = new joint.ui.Halo({ graph: graph, paper: paper, cellView: cellView });
        halo.render();
    }

});

var paperScroller = new joint.ui.PaperScroller({
    autoResizePaper: true,
    padding: 50,
    paper: paper
});

paperScroller.$el.appendTo('#paper-container');

paperScroller.center();

/* SELECTION */



/* STENCIL */
/*var relation =new joint.dia.Link({
	source: {x:5,y:50},
	target: {x:100,y:50},
	labels: { position: .5, attrs: { text: { text: 'label' } } },
	attrs: {
    	'.connection': { stroke: 'blue' },
        '.marker-target': { fill: 'yellow', d: 'M 10 0 L 0 5 L 10 10 z' }
    }
});*/
var stencil = new joint.ui.Stencil({ 
	graph: graph, 
	paper: paper,
	groups:{
		shape:{label: 'Shape',index: 1},
		//relation:{label: 'Relation', index: 2}
	}
});

stencil.render().$el.appendTo('#stencil-container');
var circle=new joint.shapes.basic.Circle({
	 	size: { width: 110, height: 65 },
	    attrs: { circle: { fill: '#9B59B6' }, text: { text: 'new concept', fill: 'black' } }
	});
stencil.load([circle],'shape');
//stencil.load([relation],'relation');
//stencil.getPaper().fitToContent(0, 0, 10);
/* CELL ADDED: after the view of the model was added into the paper */


/* KEYBOARD */



// Disable context menu inside the paper.

// This prevents from context menu being shown when selecting individual elements with Ctrl in OS X.
paper.el.oncontextmenu = function(evt) { evt.preventDefault(); };


$('#toolbar-container [data-tooltip]').each(function() {

    new joint.ui.Tooltip({
        target: $(this),
        content: $(this).data('tooltip'),
        top: '#toolbar-container',
        direction: 'top'
    });
});







var toolbar = {

    toJSON: function() {

        var windowFeatures = 'menubar=no,location=no,resizable=yes,scrollbars=yes,status=no';
            var windowName = _.uniqueId('json_output');
            var jsonWindow = window.open('', windowName, windowFeatures);

        jsonWindow.document.write(JSON.stringify(graph.toJSON()));
    },

    loadGraph: function() {
    	var cmid = $('#fileName').val();
    	$.ajax({
    		url:"ConceptMapController?action=load&cmid="+cmid,
    		type:"POST",
    		success:function(data) {
    			graph.fromJSON(JSON.parse(data));
    			//console.log(data);
             },
             error:function(data){
            	 alert("loi");
           }
    	});
    },

    saveGraph: function() {
    	//alert(JSON.stringify(graph.toJSON()));
    	$.ajax({
            url:"ConceptMapController?action=save",
            type: "POST",
            dataType: 'JSON',
            data: { json:JSON.stringify(graph.toJSON()) },
            success: function(data, textStatus, jqXHR){
                //alert(data.status);
            	bootbox.alert(data.status);
            },
            error: function(jqXHR, textStatus, errorThrown){
                alert("FAIL "+errorThrown);
            }
       });
    }
};
//create Inspector
function createInspector(cellView) {
    
    // No need to re-render inspector if the cellView didn't change.
    if (!inspector || inspector.options.cellView !== cellView) {
    
        if (inspector) {
            // Clean up the old inspector if there was one.
            inspector.remove();
        }
        if (cellView.model instanceof joint.dia.Link) {
        	//alert("click link");
        	inspector = new joint.ui.Inspector({
        		 inputs: {
        			 labels: {
        				 0:{
        					 attrs:{
        						 text:{
        							 text: {
        								 type: 'text',group: 'text', index: 1, label: 'Text',defaultValue:'Label'
        							 }
        						 }
        					 }
        				 }
        			 }
        		 },
        		 groups: {
        			 text: { label: 'Text', index: 1 }
        		 },
        		 cellView: cellView
        	});
        }
        else {
        	inspector = new joint.ui.Inspector({
                inputs: {
                    attrs: {
                        text: { 
                            text: { type: 'textarea', group: 'text', index: 1, label: 'Text' },
                            'font-size': { type: 'number', group: 'text', index: 2,label: 'Font-Size' },
                            fill: {type:'color', group:'text',index: 3, label: 'Font-Color',defaultValue:'white'}
                        },
                        circle:{
                        	fill: {type:'color', group:'presentation',index: 1, label: 'Fill-Color'}
                        }
                    }
                },
                groups: {
                    text: { label: 'Text', index: 1 },
                	presentation: {label:'Presentation',index:2}
                },
                cellView: cellView
            });
        }
        
        $('#inspector-container').html(inspector.render().el);
    }
}
// an example graph

