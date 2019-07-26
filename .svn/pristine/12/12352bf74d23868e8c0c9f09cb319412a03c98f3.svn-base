(function($){
	$.fn.d3Pie = function(options) {
		if(options.debug) console.log("function to create pie chart using d3js");
		var defaultoptions = {debug:false};
		$.extend(defaultoptions,options);
		var container = $(this);
		if(options.debug) console.log("container: " + $(container).attr("id") + ", found: " + $(container).length + ", svg in container: " + $(container).find("svg").length)
		var svgid = $(container).attr("id") + "-svg";
		if($(container).find("svg").length == 0) {
			$(container).append("<svg id='" + svgid + "' width='" + defaultoptions.width + "' height='" + defaultoptions.height + "'></svg>");
		}
		var dataset = defaultoptions.data;
		var totalvalue = 0;
		$.each(dataset,function(index,dataitem){
			totalvalue += dataitem[defaultoptions.valueproperty];
		});
		$.each(dataset,function(index,dataitem){
			dataitem.percentage = dataitem[defaultoptions.valueproperty] * 100 / totalvalue;
		});
		if(defaultoptions.debug) console.log("updated dataset: " + JSON.stringify(dataset));
		var outerradius = defaultoptions.width/2, innerradius = 0;
		var arc = d3.svg.arc()
						.innerRadius(innerradius)
						.outerRadius(outerradius);
		var svg = d3.select("#" + svgid);
		var pie = d3.layout.pie()
					.value(function(d){ return d.percentage});
		//var color = d3.scaleOrdinal(d3.schemeCategory10);
		
		if(options.debug) console.log("svg: " + svg);
		var arcs = svg.selectAll("g.fan")
									.data(pie(dataset))
									.enter()
									.append("g")
									.attr("class", "fan")
									.attr("transform", "translate(" + outerradius + "," + outerradius + ")");
		if(options.debug) console.log("arcs: " + arcs.length);
		//Draw arc paths
		arcs.append("path")
					    .attr("fill", function(d, i) {
					    	return dataset[i].color;
					    })
					    .attr("d", arc);
		
		//Labels
		arcs.append("text")
					    .attr("transform", function(d) {
					    	return "translate(" + arc.centroid(d) + ")";
					    })
					    .attr("text-anchor", "middle")
					    .text(function(d) {
					    	if(options.debug) console.log("d text: " + JSON.stringify(d));
					    	if(d.data.hidetext) {
					    		return "";
					    	}
					    	return d.value;
					    });
		
	}
	$.fn.d3Area = function(options) {
		if(options.debug) console.log("function to create area chart using d3js");
		var defaultoptions = {debug:false,margin:{top:10,right:40,bottom:10,left:40}};
		$.extend(defaultoptions,options);
		var container = $(this);
		var svgid = $(container).attr("id") + "-svg";
		if($(container).find("svg").length == 0) {
			$(container).append("<svg id='" + svgid + "' width='" + defaultoptions.width + "' height='" + defaultoptions.height + "'></svg>");
		}
		var svg = d3.select("#" + svgid);
		var g = svg.append("g");
		if(defaultoptions.debug) console.log("xAxisData: " + JSON.stringify(defaultoptions.xAxisData));
		var x = d3.scale.ordinal()
					.domain(defaultoptions.xAxisData)
					.rangePoints([0,(defaultoptions.width-defaultoptions.margin.left - defaultoptions.margin.right)]);
		var xAxis = d3.svg.axis()
					.scale(x)
					.tickSize(1)
					.orient("bottom");
		svg.append("g")
	      .attr("class", "x axis")
	      .attr("transform", "translate(" + defaultoptions.margin.left + "," + (defaultoptions.height-30) + ")")
	      .call(xAxis)
	      .selectAll("text")
	      .attr("y","10px");
		
		var y = d3.scale.linear()
				.domain([0,d3.max(defaultoptions.data,function(d){
					var valuearr = [];
					$.each(defaultoptions.series,function(index,seriesitem){
						valuearr.push(d[seriesitem.valuekey]);
					});
					return d3.max(valuearr);
				})])
				.rangeRound([defaultoptions.height-30,0]);
		var yAxis = d3.svg.axis()
					.scale(y)
					.tickSize(1)
					.orient("left");
		svg.append("g")
	      .attr("class", "y axis")
	      .attr("transform","translate(" + defaultoptions.margin.left + ",0)")
	      .call(yAxis)
	    .append("text")
	      .attr("transform", "rotate(-90)")
	      .attr("x",-defaultoptions.height/2)
	      .attr("y", -defaultoptions.margin.left)
	      .attr("dy", ".71em")
	      .style("text-anchor", "middle")
	      .text("Score");
		$.each(defaultoptions.series,function(index,seriesitem){
			var area = d3.svg.area()
								.interpolate("monotone")
								.x(function(d){
									if(defaultoptions.debug) console.log("d: " + JSON.stringify(d) + ", x: " + x(d.weekNo))
									return x(d[defaultoptions.valuekey]) + defaultoptions.margin.left;
								})
								.y1(function(d){
									if(defaultoptions.debug) console.log("d: " + JSON.stringify(d) + ", y: " + y(d[seriesitem.valuekey]))
									return y(d[seriesitem.valuekey]);
								});
			area.y0(y(0));
			
			svg.append("path")
				.datum(defaultoptions.data)
				.attr("class","area")
				.attr("fill", seriesitem.color)
				.attr("opacity",(seriesitem.opacity? seriesitem.opacity : 1))
				.attr("d",area);
		});
	}
	$.fn.stackedBarGraph = function(options) {
		if(options.debug) console.log("function to create bar chart using d3js");
		var defaultoptions = {debug:false,margin:{top:10,right:40,bottom:10,left:40},barpadding:20};
		$.extend(defaultoptions,options);
		var container = $(this);
		var svgid = $(container).attr("id") + "-svg";
		if($(container).find("svg").length == 0) {
			$(container).append("<svg id='" + svgid + "' width='" + defaultoptions.width + "' height='" + defaultoptions.height + "'></svg>");
		}
		var svg = d3.select("#" + svgid);
		var g = svg.append("g");
		if(defaultoptions.debug) console.log("xAxisData: " + JSON.stringify(defaultoptions.xAxisData));
		var x = d3.scale.ordinal()
					.domain(defaultoptions.xAxisData)
					.rangeBands([0,(defaultoptions.width-defaultoptions.margin.left - defaultoptions.margin.right)]);
		var xAxis = d3.svg.axis()
					.scale(x)
					.tickSize(1)
					.orient("bottom");
		svg.append("g")
	      .attr("class", "x axis")
	      .attr("transform", "translate(" + defaultoptions.margin.left + "," + (defaultoptions.height-30) + ")")
	      .call(xAxis)
	      .selectAll("text")
	      .attr("y","10px");
		
		var y = d3.scale.linear()
				.domain([0,d3.max(defaultoptions.data,function(d){
					var valuearr = [];
					$.each(defaultoptions.series,function(index,seriesitem){
						valuearr.push(d[seriesitem.valuekey]);
					});
					if(defaultoptions.debug) console.log("value arr: " + JSON.stringify(valuearr) + ", max: " + d3.max(valuearr));
					return d3.max(valuearr);
				})])
				.rangeRound([defaultoptions.height-30,0]);
		var yAxis = d3.svg.axis()
					.scale(y)
					.tickSize(1)
					.orient("left");
		svg.append("g")
	      .attr("class", "y axis")
	      .attr("transform","translate(" + defaultoptions.margin.left + ",0)")
	      .call(yAxis)
	    .append("text")
	      .attr("transform", "rotate(-90)")
	      .attr("x",-defaultoptions.height/2)
	      .attr("y", -defaultoptions.margin.left)
	      .attr("dy", ".71em")
	      .style("text-anchor", "middle")
	      .text("Score");
		
		var barcontainer = g.append("g")
								.selectAll("g")
								.data(defaultoptions.data)
								.enter().append("g")
								.selectAll("rect")
								.data(defaultoptions.data);
		var heightarr = []
		$.each(defaultoptions.series,function(index,seriesitem){
			totaly = 0;
			barcontainer.enter().append("rect")
						.attr("x",function(d){
							if(defaultoptions.debug) console.log("for x, seriesitem: " + JSON.stringify(seriesitem) + " d: " + JSON.stringify(d) + ", x: " + x(d.gradeTitle));
							return x(d[defaultoptions.xaxisprop]) + defaultoptions.margin.left + defaultoptions.barpadding/2;
						})
						.attr("y",function(d){
							if(defaultoptions.debug) console.log("for y, seriesitem: " + JSON.stringify(seriesitem) + " d: " + JSON.stringify(d) + ", y: " + (y(d[seriesitem.valuekey]) - totaly) + ", abs y: " + y(d[seriesitem.valuekey]) + ", heightarr: " + JSON.stringify(heightarr));
							var yval = y(d[seriesitem.valuekey]);
							return yval;
						})
						.attr("height",function(d){
							if(defaultoptions.debug) console.log("for height, seriesitem: " + JSON.stringify(seriesitem) + " d: " + JSON.stringify(d) + ", height: " + (defaultoptions.height - 30 - y(d[seriesitem.valuekey])) + ", abs y: " + y(d[seriesitem.valuekey]));
							if(!heightarr[index]) {
								heightarr[index] = 0;
							}
							var height = defaultoptions.height - 30 - y(d[seriesitem.valuekey]);
							var prevseriesheight = 0;
							for(var i = 0; i < index; i++) {
								prevseriesheight += defaultoptions.height - 30 - y(d[defaultoptions.series[i].valuekey]);
							}
							return height - prevseriesheight;
						})
						.attr("width",x.rangeBand()-defaultoptions.barpadding)
						.attr("fill",seriesitem.color);

		});
			
		
	}
	$.fn.d3TreeMap = function(options) {
		if(options.debug) console.log("function to create tree map using d3js");
		if(options.debug) console.log("data: " + JSON.stringify(options.data));
		var defaultoptions = {debug:false,margin:{top:10,right:40,bottom:10,left:40},barpadding:50,title:"Treemap"};
		$.extend(defaultoptions,options);
		var container = $(this);
		if(defaultoptions.debug) console.log("container: " + $(container).length);
		var svgid = $(container).attr("id") + "-svg";
		if($(container).find("svg").length == 0) {
			$(container).append("<svg id='" + svgid + "' width='" + defaultoptions.width + "' height='" + defaultoptions.height + "'></svg>");
		}
		var svg = d3.select("#" + svgid);
		var g = svg.append("g");
		var treemap = d3.layout.treemap()
							    .round(true)
							    .size([defaultoptions.width, defaultoptions.height])
							    .sticky(true)
							    .value(function(d) { return d[defaultoptions.valuekey]; });
		  var nodes = treemap.nodes(defaultoptions.data)
						      //.filter(function(d) {return !d.children; });
		  var cell = svg.selectAll("g")
				      .data(nodes)
				    .enter().append("svg:g")
				      .attr("class", "cell")
				      .attr("transform", function(d) { return "translate(" + d.x + "," + d.y + ")"; });
		
		  cell.append("svg:rect")
		      .attr("width", function(d) { return d.dx - 1; })
		      .attr("height", function(d) { return d.dy - 1; })
		      .style("fill", function(d) {return options.mincolor; });
		
		  cell.append("svg:text")
		      .attr("x", function(d) { return d.dx / 2; })
		      .attr("y", function(d) { return d.dy / 3; })
		      .attr("dy", ".35em")
		      .attr("text-anchor", "middle")
		      .text(defaultoptions.retrievelabel)
		      .style("opacity", function(d) { /*d.w = this.getComputedTextLength(); return d.dx > d.w ? 1 : 0;*/ return 1; });
		  cell.append("svg:text")
		      .attr("x", function(d) { return d.dx / 2; })
		      .attr("y", function(d) { return d.dy/3 + 14; })
		      .attr("dy", ".35em")
		      .attr("text-anchor", "middle")
		      .text(defaultoptions.retrievecount)
		      .style("opacity", function(d) { /*d.w = this.getComputedTextLength(); return d.dx > d.w ? 1 : 0;*/ return 1; });
		

		  cell.append("title")
		      .text(defaultoptions.retrievelabel);
		  
		  /*$("#" + options.chartid + "d3 g.cell").each(function(){
				var cell = $(this);
				var cellrectwidth = $(cell).find("rect").width();
				if(config.debug) console.log("cell rect width: " + cellrectwidth);
				$(cell).find("text").each(function(){
					if($(this).width() > cellrectwidth) {
						var text = $(this).text();
						if(config.debug) console.log("text: " + text);
					}
				});
			});*/
		  cell.each(function(d,i){
			  console.log("cell found...");
		  });

	}

	
}(jQuery))