(function($){
	
	var pencilconfig = {debug:false,color:"black",linewidth:1,trackcustomdraw:true,drawarr:[],eraserarr:[]};
	var eraserwidth = 15;
	var pencilwidth = 3;
	$.fn.canvaspainterpencil = function(options,method,parameter) {
		
		if(options == "option") {
			if(method.toLowerCase() == "color") {
				pencilconfig.color = parameter;
			}
			if(method.toLowerCase() == "tool") {
				pencilconfig.tool = parameter;
			}
			if(method.toLowerCase() == "retrace") {
				pencilconfig.drawarr.length = 0;
				pencilconfig.eraserarr.length = 0;
			}
			if(method.toLowerCase() == "cleartool") {
				pencilconfig.tool = null;
			}
			if(method.toLowerCase() == "getuserdrawing") {
				console.log("returning array: " + pencilconfig.drawarr);
				//Arijit: 28 Sept send the eraser retrace data
				return pencilconfig.drawarr.concat(pencilconfig.eraserarr);
				//| pencilconfig.eraserarr ;
			}
			if(method.toLowerCase() == "redraw") {
				resketch(parameter);
			}
			return;
		}
		console.log("creating pencil config instance");
		pencilconfig = $.extend(pencilconfig,options);
		initpencil(pencilconfig);
	}
	
	function initpencil(pencilconfig) {

		pencilconfig.annotationcanvas.addEventListener("mousemove", function (e) { findxy('move', e, pencilconfig);});
		pencilconfig.annotationcanvas.addEventListener("touchmove", function (e) { findxy('move', e, pencilconfig);});
		pencilconfig.annotationcanvas.addEventListener("mousedown", function (e) { findxy('down', e, pencilconfig);});
		pencilconfig.annotationcanvas.addEventListener("touchstart", function (e) {  findxy('down', e, pencilconfig);});
		pencilconfig.annotationcanvas.addEventListener("mouseup", function (e) { findxy('up', e, pencilconfig);});
		pencilconfig.annotationcanvas.addEventListener("touchend", function (e) { findxy('up', e, pencilconfig);});
		if(pencilconfig.showcolorchooser) {
			showcolorchooser(pencilconfig);
		}
	}
	function showcolorchooser(pencilconfig) {
		$(pencilconfig.toolscontainer).append("<div class=\"cursor\" tool='cursor'></div><div class=\"pencil\" tool='pencil'></div><div class='pencilcolors'><div id=\"green\"></div><div id=\"blue\"></div><div id=\"red\"></div><div id=\"yellow\"></div><div id=\"orange\"></div><div id=\"black\"></div></div>");
		$(pencilconfig.toolscontainer).find(".pencilcolors").hide();
		$(pencilconfig.toolscontainer).find(".pencilcolors div[id]").each(function(){
			$(this).css("background-color",$(this).attr("id"));
		});
		$(pencilconfig.toolscontainer).find("[tool]").click(function(){
			$(pencilconfig.toolscontainer).find("[tool].active").removeClass("active");
			$(this).addClass("active");
			pencilconfig.tool = $(this).attr("tool");
		})
		$(pencilconfig.toolscontainer).find(".pencil").click(function(){
			$(pencilconfig.toolscontainer).find(".pencilcolors").toggle();
		})
		$(pencilconfig.toolscontainer).find(".pencilcolors div[id]").click(function(){
			$(pencilconfig.toolscontainer).find(".pencilcolors div[id].active").removeClass("active");
			$(this).addClass("active");
			pencilconfig.color = $(this).attr("id");
		})
	}
	var mousedownstate = false;
	var prevX = 0,prevY = 0,currX = 0,currY = 0;
	function findxy(res,e,pencilconfig) {
		
		//---- Arijit 17 April - eSenses multitouch fix (touch events added)///
		// Todo: a. reference to [0] to be removed....		
		console.log("pencilconfig.tool",pencilconfig.tool);
		var rect = pencilconfig.annotationcanvas.getBoundingClientRect();
		if (res == 'move' && mousedownstate == true && pencilconfig.tool == "pencil") {
			//console.log("e.clientX: " + e.clientX + ", e.clientY: " + e.clientY + ", leftoffset: " + pencilconfig.canvas.offsetLeft + ", topoffset: " + pencilconfig.canvas.offsetTop + ", scroll: " + $(pencilconfig.containerelement).scrollTop() + ", client rect left: " + rect.left + ", client rect top: " + rect.top);
			pencilconfig.context.beginPath();
            prevX = currX;
            prevY = currY;
            //currX = e.clientX- pencilconfig.canvas.offsetLeft;
            //currY = e.clientY - pencilconfig.canvas.offsetTop + $(pencilconfig.containerelement).scrollTop();
            //currX = e.pageX;
            //currY = e.pageY;
			
			if (e.clientX){
				 currX = e.clientX - rect.left;
				currY = e.clientY - rect.top + $(pencilconfig.containerelement).scrollTop();
			}else{				
				currX = e.changedTouches[0].clientX - rect.left;
				currY = e.changedTouches[0].clientY - rect.top + $(pencilconfig.containerelement).scrollTop();				
			}
            draw(pencilconfig);
		} else if (res == 'move' && mousedownstate == true && pencilconfig.tool == "erase") {
			pencilconfig.context.beginPath();
			prevX = currX;
			prevY = currY;
			if (e.clientX){
				currX = e.clientX - rect.left;
				currY = e.clientY - rect.top + $(pencilconfig.containerelement).scrollTop();
			}else{				
				currX = e.changedTouches[0].clientX - rect.left;
				currY = e.changedTouches[0].clientY - rect.top + $(pencilconfig.containerelement).scrollTop();				
			}
			eraser(pencilconfig);
		}
		if(res == "up") {
			mousedownstate = false;
			return;
		}
		if(res == "down") {
            prevX = currX;
            prevY = currY;
			//currX = e.clientX;
			//currY = e.clientY;
            //currX = e.clientX - pencilconfig.canvas.offsetLeft;
            //currY = e.clientY - pencilconfig.canvas.offsetTop /*+ $(pencilconfig.containerelement).scrollTop()*/;
			if (e.clientX){
				currX = e.clientX - rect.left;
				currY = e.clientY - rect.top;
			}else{
				currX =  e.changedTouches[0].clientX - rect.left;
				currY =  e.changedTouches[0].clientY - rect.top;
				
			}
			//console.log("down >>>>"+ currX+ ">>>>>>>>>>>>"+ currY);
			mousedownstate = true;			
		}
		
	}
	function draw(pencilconfig) {
		
		console.log("draw >>>>>>>>>>>>>>>>",pencilconfig);
		//var ctx = pencilconfig.context;
		var ctx = pencilconfig.annotationcanvas.getContext("2d");
		ctx.globalCompositeOperation="source-over";
		ctx.beginPath();
		ctx.moveTo(prevX, prevY);
		ctx.lineTo(currX, currY);
		console.log("draw from[" + prevX + "," + prevY + "] to [" + currX + "," + currY + "]");
		ctx.strokeStyle = pencilconfig.color;
		ctx.lineWidth = pencilwidth;
		ctx.stroke();
		if(pencilconfig.trackcustomdraw) {
			pencilconfig.drawarr.push({color:ctx.strokeStyle,linewidth:ctx.lineWidth,from:{x:prevX,y:prevY},to:{x:currX,y:currY}});
			console.log("added to drawarr: " + pencilconfig.drawarr.length);
		}


		// 24 Sept: Arijit .... Eraser
		// https://stackoverflow.com/questions/25907163/html5-canvas-eraser-tool-without-overdraw-white-color

	}
	function eraser(pencilconfig){
		console.log("eraser final >>>>>>>>>>>>>>>>", pencilconfig.color);
		var ctx = pencilconfig.annotationcanvas.getContext("2d");
		ctx.globalCompositeOperation="destination-out";
		/*ctx.arc(prevX,prevY,8,0,Math.PI*2,false);
		ctx.fillStyle = 'rgba(0,0,0,1)';
		ctx.strokeStyle = 'rgba(0,0,0,1)';
		ctx.lineWidth = 10;
		ctx.fill();*/
		
		/*if(pencilconfig.trackcustomdraw) {
			pencilconfig.eraserarr.push({color:ctx.strokeStyle,linewidth:ctx.lineWidth,from:{x:prevX,y:prevY},to:{x:currX,y:currY}});
			console.log("added to eraserarr: " + pencilconfig.eraserarr.length);
		}*/
		ctx.beginPath();
		ctx.moveTo(prevX, prevY);
		ctx.lineTo(currX, currY);
		//console.log("draw from[" + prevX + "," + prevY + "] to [" + currX + "," + currY + "]");
		ctx.strokeStyle = pencilconfig.color;
		ctx.lineWidth = eraserwidth;
		ctx.stroke();
		//ctx.globalCompositeOperation="source-over";
		//pencilconfig.annotationcanvas.style.background = "url('"+pencilconfig.background.url+"')";
		/*var img = new Image();
		img.onload = function() {
			var hRatio = pencilconfig.canvas.width  / img.width    ;
			var vRatio =  pencilconfig.canvas.height / img.height  ;
			pencilconfig.ratio = Math.min ( hRatio, vRatio );
			var centerShift_x = ( pencilconfig.canvas.width - img.width*pencilconfig.ratio ) / 2;
		   	var centerShift_y = ( pencilconfig.canvas.height - img.height*pencilconfig.ratio ) / 2;  
		   	//pencilconfig.context.drawImage(img, 0,0, img.width, img.height,centerShift_x,centerShift_y,img.width*pencilconfig.ratio, img.height*pencilconfig.ratio); 
			pencilconfig.canvas.style.background = "url('"+pencilconfig.background.url+"')";
			pencilconfig.canvas.style.background-size = "img.width, img.height,centerShift_x,centerShift_y,img.width*pencilconfig.ratio, img.height*pencilconfig.ratio";
		}
		img.src = pencilconfig.background.url;
*/
		//$().setCanvasBackground(penci	lconfig);
		if(pencilconfig.trackcustomdraw) {
			pencilconfig.eraserarr.push({color:ctx.strokeStyle,linewidth:ctx.lineWidth,from:{x:prevX,y:prevY},to:{x:currX,y:currY}});
			console.log("added to eraserarr: " + pencilconfig.eraserarr.length);
		}
		ctx.globalCompositeOperation="source-over";
	}

	function resketch(drawarr) {
		console.log("recreating .... >>>>>>>>>>>>>>>>",drawarr);
		drawarr = drawarr.splice(0);
		pencilconfig.drawarr.length = 0;
		$.each(drawarr,function(index,points){
			prevX = points.from.x;
			prevY = points.from.y;
			currX = points.to.x;
			currY = points.to.y;
			pencilconfig.color = points.color;
			pencilconfig.linewidth = points.linewidth;
			if (pencilconfig.linewidth == eraserwidth){
				eraser(pencilconfig);
			}else{
				draw(pencilconfig);
			}
		})

		/*eraserarr = eraserarr.splice(0);
		pencilconfig.drawarr.length = 0;
		$.each(drawarr,function(index,points){
			prevX = points.from.x;
			prevY = points.from.y;
			currX = points.to.x;
			currY = points.to.y;
			pencilconfig.color = points.color;
			pencilconfig.linewidth = points.linewidth;
			draw(pencilconfig);
		})*/
	}
}(jQuery))