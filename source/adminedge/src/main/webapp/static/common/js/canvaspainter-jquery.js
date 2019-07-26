(function($){
	var defaultsettings = {canvasid:"mycanvas",canvasannotationid:"annocanvas",width:1280,height:700,scaleindex:0,zoomscale:[],zoomoutscale:[0.25,0.5]};
	var config = null;
	$.fn.canvaspainter = function(options,method,parameters) {
		if(options == "option") {
			if(method.toLowerCase() == "setbackground") {
				if(!config.background) {
					config.background = new Object();
				}
				config.background.url = parameters;
				setCanvasBackground(config);
				//$().canvaspainterpencil("option","cleartool");
			}
			if(method.toLowerCase() == "getDataUrl") {
				return config.canvas.toDataURL();
			}
			if(method.toLowerCase() == "clear") {
				config.context.clearRect(0,0,config.canvas.width,config.canvas.height);
			}
			if(method.toLowerCase() == "color") {
				$().canvaspainterpencil("option","color",parameters);
			}
			if(method.toLowerCase() == "tool") {
				$().canvaspainterpencil("option","tool",parameters);
			}
			if(method.toLowerCase() == "cleartool") {
				$().canvaspainterpencil("option","cleartool");
			}
			if(method.toLowerCase() == "zoomout") {
				zoomOut();
			}
			if(method.toLowerCase() == "zoomin") {
				zoomIn();
			}
			if(method.toLowerCase() == "getuserdrawing") {
				console.log("getting user drawing from pencil plugin");
				return $().canvaspainterpencil("option","getUserDrawing");
			}
			if(method.toLowerCase() == "drawuserdrawing") {
				config.onbackgroundchange = function() {
					$().canvaspainterpencil("option","redraw",parameters);
					config.context.setTransform(1,0,0,1,0,0);
				}
			}
			if(method.toLowerCase() == "resetscale") {
				config.context.setTransform(1,0,0,1,0,0);
			}
			if(method.toLowerCase() == "retrace") {
				$().canvaspainterpencil("option","retrace");
			}
			return;
		}
		console.log("creating canvas painter");
		config = $.extend(defaultsettings,options);
		delete config.onbackgroundchange;
		config.containerelement = $(this);
		init(config);
	}
	/*function zoomOut() {
		config.scaleindex--;
		if(config.scaleindex > 0) {
			var dataurl = config.canvas.toDataURL();
			config.context.clearRect(0,0,config.canvas.width,config.canvas.height);
			console.log("canvas width: " + config.canvas.width + ", init width: " + config.canvas.initwidth);
			//$(config.containerelement).find("canvas").attr("width",config.canvas.width + config.canvas.initwidth / 2);
			//$(config.containerelement).find("canvas").attr("height",config.canvas.width + config.canvas.initheight / 2);
			$(config.containerelement).find("canvas").attr("width",config.zoomscale[config.scaleindex].width);
			$(config.containerelement).find("canvas").attr("height",config.zoomscale[config.scaleindex].height);
			
			setCanvasBackground(config);
			return;
		}
		if(-config.scaleindex < config.zoomoutscale.length ) {
			var dataurl = config.canvas.toDataURL();
			config.context.clearRect(0,0,config.canvas.width,config.canvas.height);
			//config.context.setTransform(1, 0, 0, 1, 0, 0);
			config.context.scale(config.zoomoutscale[-config.scaleindex],config.zoomoutscale[-config.scaleindex]);
			//config.context.scale(1,1);
			var orgbackgroundchange = null;
			if(config.onbackgroundchange) {
				orgbackgroundchange = config.onbackgroundchange;
			}
			config.onbackgroundchange = function() {
				//$(config.containerelement).find("canvas").attr("width",config.canvas.width - config.canvas.initwidth / 2);
				//$(config.containerelement).find("canvas").attr("height",config.canvas.width - config.canvas.initheight / 2);
				console.log("resetting scale...");
				config.context.setTransform(1, 0, 0, 1, 0, 0);
				if(orgbackgroundchange) {
					orgbackgroundchange();
				}
			}
			setCanvasBackground(config);
		}
	}
	function zoomIn() {
		config.scaleindex++;
		if(config.scaleindex >= config.zoomscale.length) {
			return;
		}
		var dataurl = config.canvas.toDataURL();
		config.context.clearRect(0,0,config.canvas.width,config.canvas.height);
		console.log("canvas width: " + config.canvas.width + ", init width: " + config.canvas.initwidth);
		//$(config.containerelement).find("canvas").attr("width",config.canvas.width + config.canvas.initwidth / 2);
		//$(config.containerelement).find("canvas").attr("height",config.canvas.width + config.canvas.initheight / 2);
		console.log("scale index: " + config.scaleindex);
		$(config.containerelement).find("canvas").attr("width",config.zoomscale[config.scaleindex].width);
		$(config.containerelement).find("canvas").attr("height",config.zoomscale[config.scaleindex].height);
		
		setCanvasBackground(config);
	}*/
	function zoomOut() {
		if(config.scaleindex <= -1) {
			return;
		}
		config.scaleindex--;
		managezoom();
	}
	function zoomIn() {
		if(config.scaleindex >= 1) {
			return;
		}
		config.scaleindex++;
		managezoom();
	}
	function managezoom() {
		if(config.scaleindex > 0) {
			var dataurl = config.canvas.toDataURL();
			config.context.clearRect(0,0,config.canvas.width,config.canvas.height);
			console.log("canvas width: " + config.canvas.width + ", init width: " + config.canvas.initwidth);
			//$(config.containerelement).find("canvas").attr("width",config.canvas.width + config.canvas.initwidth / 2);
			//$(config.containerelement).find("canvas").attr("height",config.canvas.width + config.canvas.initheight / 2);
			console.log("scale index: " + config.scaleindex);
			$(config.containerelement).find("canvas").attr("width",config.canvas.width + config.canvas.initwidth/2);
			$(config.containerelement).find("canvas").attr("height",config.canvas.width + config.canvas.initheight/2);
			
			setCanvasBackground(config);
			return;
		}
		if(config.scaleindex == 0) {
			config.context.clearRect(0,0,config.canvas.width,config.canvas.height);
			console.log("canvas width: " + config.canvas.width + ", init width: " + config.canvas.initwidth);
			//$(config.containerelement).find("canvas").attr("width",config.canvas.width + config.canvas.initwidth / 2);
			//$(config.containerelement).find("canvas").attr("height",config.canvas.width + config.canvas.initheight / 2);
			console.log("scale index: " + config.scaleindex);
			$(config.containerelement).find("canvas").attr("width",config.canvas.initwidth);
			$(config.containerelement).find("canvas").attr("height",config.canvas.initheight);
			setCanvasBackground(config);
			return
		}
		if(config.scaleindex < 0) {
			var dataurl = config.canvas.toDataURL();
			config.context.clearRect(0,0,config.canvas.width,config.canvas.height);
			//config.context.setTransform(1, 0, 0, 1, 0, 0);
			config.context.scale(0.75,0.75);
			//config.context.scale(1,1);
			var orgbackgroundchange = null;
			if(config.onbackgroundchange) {
				orgbackgroundchange = config.onbackgroundchange;
			}
			config.onbackgroundchange = function() {
				//$(config.containerelement).find("canvas").attr("width",config.canvas.width - config.canvas.initwidth / 2);
				//$(config.containerelement).find("canvas").attr("height",config.canvas.width - config.canvas.initheight / 2);
				console.log("resetting scale...");
				config.context.setTransform(1, 0, 0, 1, 0, 0);
				if(orgbackgroundchange) {
					orgbackgroundchange();
				}
			}
			setCanvasBackground(config);
		}
		
	}
	function init(config) {
		//Arijit: 24 Sept: introduced annotation canvas
		var ui = "<canvas id='" + config.canvasannotationid + "' width='" + config.width + "' height='" + config.height + "' style='position: fixed;top: inherit;'>Your browser doesn't support html5! Please download a fitable browser.</canvas>";
		//var ui = "<canvas id=\"" + config.canvasannotationid + "\" width=\"" + config.width + "\" height=\"" + config.height + "\">Your browser doesn't support html5! Please download a fitable browser.</canvas>";
		ui = ui + "<img id='imgbg' src='"+config.background.url+"' ></img>";
		//ui = ui + "<canvas  width=\"" + config.width + "\" height='600px'>Your browser doesn't support html5! Please download a fitable browser.</canvas>";
		
		$(config.containerelement).html(ui);
		$(config.containerelement).css({"text-align":"left"})
		config.canvas = document.getElementById(config.canvasannotationid);
		config.context = config.canvas.getContext("2d");
		config.onbackgroundchange = function() {
			if(!config.canvas.initwidth) {
		   		config.canvas.initwidth = config.canvas.width;
		   	}
		   	if(!config.canvas.initheight) {
		   		config.canvas.initheight = config.canvas.height;
		   	}
		   	if(config.zoomscale.length == 0) {
		   		config.zoomscale.push({width:config.canvas.initwidth,height:config.canvas.initheight});
		   		config.zoomscale.push({width:config.canvas.initwidth + config.canvas.initwidth/2,height:config.canvas.height + config.canvas.initwidth/2});
		   		config.zoomscale.push({width:config.canvas.initwidth + config.canvas.initwidth,height:config.canvas.height + config.canvas.initwidth});
			}
			   
		}
		if(config.background.url) {
			setCanvasBackground(config);
		}
		
		//Arijit: 24 Sept: introduced annotation canvas		
		config.annotationcanvas = document.getElementById(config.canvasannotationid);
		config.annotationcontext = config.annotationcanvas.getContext("2d");
		config.onbackgroundchange = function() {
			if(!config.annotationcanvas.initwidth) {
		   		config.annotationcanvas.initwidth = config.annotationcanvas.width;
		   	}
		   	if(!config.annotationcanvas.initheight) {
		   		config.annotationcanvas.initheight = config.annotationcanvas.height;
		   	}
		   	if(config.zoomscale.length == 0) {
		   		config.zoomscale.push({width:config.annotationcanvas.initwidth,height:config.annotationcanvas.initheight});
		   		config.zoomscale.push({width:config.annotationcanvas.initwidth + config.annotationcanvas.initwidth/2,height:config.annotationcanvas.height + config.annotationcanvas.initwidth/2});
		   		config.zoomscale.push({width:config.annotationcanvas.initwidth + config.annotationcanvas.initwidth,height:config.annotationcanvas.height + config.annotationcanvas.initwidth});
		   	}
		}
				
		console.log("is pencil enabled: " + config.enablepencil);
		if(config.enablepencil) {
			console.log("enabling pencil...")
			$().canvaspainterpencil(config);
		}
	}
	function setCanvasBackground(config) {
		var img = new Image();
		img.onload = function() {
			var hRatio = config.canvas.width  / img.width    ;
			var vRatio =  config.canvas.height / img.height  ;
			config.ratio = Math.min ( hRatio, vRatio );
			console.log("ratio: " + config.ratio);
			var centerShift_x = ( config.canvas.width - img.width*config.ratio ) / 2;
		   	var centerShift_y = ( config.canvas.height - img.height*config.ratio ) / 2;  
		   	//config.context.clearRect(0,0,config.canvas.width, config.canvas.height);
		   	//config.context.drawImage(img, 0,0, img.width, img.height,centerShift_x,centerShift_y,img.width*config.ratio, img.height*config.ratio); 
			//config.context.drawImage(this,0,0);
			document.getElementById("imgbg").src = config.background.url;
			document.getElementById("imgbg").width = img.width*config.ratio;
			document.getElementById("imgbg").height = img.height*config.ratio;
			$().canvaspainterpencil("option","retrace");
		   
			if(config.onbackgroundchange) {
				config.onbackgroundchange();
			}
		}
		img.src = config.background.url;
	}
}(jQuery))