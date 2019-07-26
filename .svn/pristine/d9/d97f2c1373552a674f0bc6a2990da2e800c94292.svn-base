function ClassEdgeFn() {}

ClassEdgeFn.cleartoken = function() {
	console.log("clear");	
	if (localStorage.getItem("token") != null) {
		localStorage.removeItem("token");
		localStorage.removeItem("sessionTimeout");
		localStorage.removeItem("lastHit");	
	}
	console.log(" stored localStorage  ",localStorage);
	
}
/*
ClassEdgeFn.loadtoken = function(data) {
	console.log("tttt",data);
	localStorage.token = data.token;	
	if(data.sessionTimeout != null) {
		localStorage.sessionTimeout = data.sessionTimeout;
	}	
	var now = new Date();
	localStorage.lastHit = now.getTime();	
	console.log(" stored localStorage  ",localStorage);
	
}
*/
ClassEdgeFn.extendSession = function () {
	var now = new Date();	
	var prev = Date.parse(localStorage.lastHit);
	console.log("extend session --"+now.getTime() + "----- "+prev);
	//check if the last hit was more than five minutes
	var timeDiff = Math.abs(now.getTime() - prev);
	console.log(localStorage.sessionTimeout + "extend timediff " +timeDiff);
	if(timeDiff < parseInt(localStorage.sessionTimeout,10)){
		var data = {
        	    "grant_type": "refresh_token",
        	    "access_token":localStorage.token,
        	    "refresh_token":localStorage.rtoken
        	  }  
		ClassEdgeFn.callAjax("/tce-auth-api/0/api/1/sso/token",data,
    			{ 	headerFn : ClassEdgeFn.noHeader,
        			targetFn : function (result) { 
	            				console.log( "Renewed Access token = "+ result.access_token);
	                            console.log( "Renewed refresh token = "+ result.refresh_token);			                        
	                            localStorage.setItem("token",result.access_token);
    						}
        		}); 
		console.log("token extended");
	}
}

ClassEdgeFn.loaderHtml = function(targetDiv) {
	jQuery(targetDiv).html("<table border='0' cellpadding='0' cellspacing='0' width='310px' height='50px'>"+
					"<tr><td align='center' valign='middle'>"+
					"<img src='/ce-static/common/css/images/spinner.gif'/>"+
					"</td></tr>"+
					"</table>");	
}

ClassEdgeFn.renderHtml = function (content,targetDiv,extraProps) {
	var ajaxProps = {};
	//combine props
	jQuery.extend(ajaxProps, extraProps);
	
	console.log("div html props",ajaxProps);
	
	var tmpltFileUrl = extraProps.template;
	if(localStorage.apiVersion || localStorage.apiVersion != null){
		tmpltFileUrl = tmpltFileUrl.replace('{version}',localStorage.apiVersion);
	}
	
	$.get(tmpltFileUrl, null, function (template) {
		var tmpl = $.templates(template);
		var htmlString = tmpl.render(content);						
		jQuery(targetDiv).html(htmlString);
	});
	
}

ClassEdgeFn.defaultHeader = function () {
	var authHeader = {};
	if (localStorage.token || localStorage.token != null) {
		authHeader = {'Authorization': 'Bearer ' + localStorage.token};	
	}
	
	return authHeader;
}

ClassEdgeFn.clientHeader = function () {
	return { 'Authorization': 'Basic '+localStorage.clientCreds, 
        	'Content-Type':'application/x-www-form-urlencoded'};
}

ClassEdgeFn.noHeader = function () {
	return { 'Content-Type':'application/x-www-form-urlencoded' };
}

ClassEdgeFn.defaultTargetHandler = function (result) {
	console.log("returned",result); 
	return;
}

ClassEdgeFn.defaultErrorHandler = function (jqXHR, textStatus, errorThrown) {
	console.log(jqXHR.status+"--"+textStatus);
	
	if (jqXHR.status == 400 || jqXHR.status == 500) {
		console.log("Validation Error ",jqXHR.responseText);
		var errObj = JSON.parse(jqXHR.responseText);
		
		var errmsg = "Validation Error \n";
		
		for(var key in errObj){
			errmsg = errmsg + key + ":" + errObj[key];
		}
		alert(errmsg);	
		return;
	}
	
	
	if (jqXHR.status == 401) {
		alert("Session timedOut");
		location.href = "/";
		return;
	} 					
	
	if (jqXHR.status == 403) {
		alert("you donot have the required permissions");						
		return;
	} 
	
	if (jqXHR.status == 404) {
		alert("url not found");						
		return;
	} 
	
	return;
}

ClassEdgeFn.callAjax = function (url,data,extraProps) {
	
	//reset counter
	localStorage.lastHit = new Date();	
	
	var ajaxProps = {targetFn : ClassEdgeFn.defaultTargetHandler, errorFn : ClassEdgeFn.defaultErrorHandler,
					headerFn : ClassEdgeFn.defaultHeader,httpMethod : 'POST'};
	//combine props
	jQuery.extend(ajaxProps, extraProps);
		
	//construct url format 
	var serverurl = url;
	if(localStorage.apiVersion || localStorage.apiVersion != null){
		serverurl = serverurl.replace('{version}',localStorage.apiVersion);
	}
	console.log('url>>'+serverurl+' props>>>',ajaxProps);
	/*JSON.stringify(data)*/
	jQuery.ajax({
		type : ajaxProps.httpMethod,
		url : serverurl,
		contentType: 'application/json',
        dataType: 'json',
		data: data,
		headers: ajaxProps.headerFn(),
		success : function(result) {ajaxProps.targetFn(result);},
		error : function(jqXHR, textStatus, errorThrown) {
			ajaxProps.errorFn(jqXHR, textStatus, errorThrown);
		}
	});

}

ClassEdgeFn.pouplateDialog = function(settings) {
	$.modal("<div id='basic-modal-download'><div id='downloaddialog' title=''></div></div>");
	$('#downloaddialog').dialog({
			autoOpen: false,
			width: settings.width,
			height: settings.height,
			title:settings.title,
			modal: true,
			resizable: false,
			overlayClose: true,
			close: function (e) {
				$.modal.close();
				$('#downloaddialog').dialog( "close" );
			}
		});

	$('#downloaddialog').dialog('open');
	$('#simplemodal-overlay').hide();
}

ClassEdgeFn.showDialog = function(dlgURL,data,settings) {
	ClassEdgeFn.pouplateDialog(settings);	
	
	var extraprops = {targetFn : function(htmlData) {
								ClassEdgeFn.renderHtml(htmlData,'#downloaddialog',settings);										
							},
					errorFn : function(htmlData) {
								ClassEdgeFn.renderHtml(htmlData,'#downloaddialog',settings);										
							}
					};
	//combine props
	jQuery.extend( extraprops,settings.apiProps);
	console.log("dlg apiprops >> ",extraprops);
	
	ClassEdgeFn.callAjax(dlgURL,data,extraprops);	
}

ClassEdgeFn.closeDialog = function() {
	$('#downloaddialog').dialog( "close" );
}

ClassEdgeFn.fillDD = function(id,result,settings) {

	var defSettings = {optionSelected:"",isMultiple:false,placeholder:{id:-1,text:"Select One"}};
	jQuery.extend( defSettings,settings);
	
	//populate the list
	$(id).empty();
	$(id).append(new Option(defSettings.placeholder.text, defSettings.placeholder.id,  false, false));
	$.each(result, function (index, row) {	
			var isSelected = defSettings.optionSelected == "" ? false :  
								defSettings.isMultiple ? selectedOption.indexOf(row.id) != -1 ? true : false : 
										defSettings.optionSelected == row.id ? true : false;
			$(id).append(new Option(row.text, row.id,  isSelected, isSelected));
	    }	
    );
	
	
	$(id).select2({		
		 allowClear: true,	
		 multiple : defSettings.isMultiple
	 });
}


////////////////function to show dialog////////////////////////////

function PopupCenter(pageURL,width,height) {
    var params = 'width='+width+', height='+height;
    params += ', directories=no';
	 params += ', location=no';
	 params += ', menubar=no';
	 params += ', resizable=yes';
	 params += ', scrollbars=yes';
	 params += ', status=no';
	 params += ', toolbar=no';
	window.open (pageURL," ",params);
}

/////////////////functions for HTML loading ////////////////////

function script(url) {
    var s = document.createElement('script');
    s.type = 'text/javascript';
    s.async = true;
    s.src = url;
    var x = document.getElementsByTagName('head')[0];
    x.appendChild(s);
}

/////////////////functions for string/////////////////////////
function startsWith(str, word) {
    return str.lastIndexOf(word, 0) === 0;
}

function endsWith(str, word) {
    return str.indexOf(word, str.length - word.length) !== -1;
}

/////////////////functions for context menu/////////////////////////
function HideContent(d) {
	if(d.length < 1) { return; }
	document.getElementById(d).style.display = "none";
}

function ShowContent(d) {
	if(d.length < 1) { return; }
	document.getElementById(d).style.display = "block";
}

///////////// button js functions ///////////////
function buttonOver(obj, textcolor) {
	obj.style.color = textcolor;
}

function buttonOut(obj, textcolor) {
	obj.style.color = textcolor;
}



///////////////////// version history js functions ////////////////////////////
function getQueryVariable(variable) {
	var query = window.location.search.substring(1);
	var vars = query.split("&");
	for (var i=0;i<vars.length;i++) {
		var pair = vars[i].split("=");
		if (pair[0] == variable) {
			return pair[1];
		}
	}
	alert('Query Variable ' + variable + ' not found');
}



function VersionHandler(url) {
	this.baseUrl = url;
	this.namespace = "versionMgmtHandle";
	this.submitFnHandle = null;
	if(typeof(submitComments) == "function"){this.submitFnHandle =submitComments;};
	this.validateFn = null;
	if(typeof(validateForm) == "function"){this.validateFn =validateForm;};

	this.setCallbackFn=function(submitFn,validateFn) {
		this.submitFnHandle = submitFn;
		this.validateFn = validateFn;
	};

	this.setNamespace = function(namespace){
		this.namespace = namespace;
	};

	this.addVersionComment =function (formName,submitUrl) {
		var flag = this.validateFn(formName);
		if (flag == true) {
			var data = {
					submitUrl : submitUrl,
					formName : formName,
					namespace : this.namespace
			};
			Liferay.ClassedgePopup.displayPopup(this.baseUrl,data, "Add Comments");
		}
	};

	this.viewVersionHistory = function (assetId,moduleId){
		var data = {
				assetId : assetId,
				moduleId : moduleId
		};
		downloadDialog(this.baseUrl,data,{width:610,height:400,title:"Version History"});
	};

	this.submitVersionComments = function(formName,submitUrl){
		var formElement = document.getElementById(formName);
		var comments = document.getElementById("versionComments").value;
		if(comments==""){
			alert("Please add your comments");
			return;
		}
		var inputElement = document.createElement("input");
	   inputElement.setAttributeNode(createHtmlAttribute("type", "hidden"));
	   inputElement.setAttributeNode(createHtmlAttribute("name", "comments"));
	   inputElement.setAttributeNode(createHtmlAttribute("value", comments));
	   formElement.appendChild(inputElement);
	   return this.submitFnHandle(formName,submitUrl);
	};

	this.showDetails = function(versionId){
		callAjax("#versionContent",this.baseUrl+"&Operation=viewVersionDetails&verionId="+versionId,null);
	};

	this.showVersions = function(){
		callAjax("#versionContent",this.baseUrl+"&Operation=viewVersionHistoryTable",null);
	};
}


function createHtmlAttribute(name, value) {
   var attribute = document.createAttribute(name);
   attribute.nodeValue = value;
   return attribute;
}


///////////////////// dynamic file upload js functions //////////////////////////
function uploadFile(divName) {

	if(document.getElementById("hidden_form").action == ''){
		alert('URL has not been set');
		return;
	}
	
	var theFile = document.getElementById("lpFile");
	var fileParent = theFile.parentNode;
	// create a div with a hidden iframe and form

	//This function should be called when the iframe has compleated loading
	document.getElementById("hidden_frame").onload = uploadDone;
	// That will happen when the file is completely uploaded and the server has returned the data we need.


	var hiddenForm = document.getElementById("hidden_form");
	fileParent.removeChild(theFile);
	// attach the file to the hidden form
	hiddenForm.appendChild(theFile);
	
	var theDiv = document.getElementById(divName);
	theDiv.innerHTML = loaderHtml;

	hiddenForm.submit();
	hiddenForm.removeChild(theFile);
	// put th file back where it came from
	//fileParent.appendChild(theFile);
	// can't remove div yet, frame may not have loaded
	//document.body.removeChild(theDiv);
	//document.getElementById("lpFile").value="";
}

function uploadDone() { //Function will be called when iframe is loaded
	var ret = frames['hidden_frame'].document.getElementsByTagName("body")[0].innerHTML;
	var theDiv = document.getElementById("uploadedDiv");
	theDiv.innerHTML = ret;
}



function download(downloadURL,data) {
	var settings = {
		width : 400,
		height : 100,
		title : "Download File",
		template:'/ce-static/common/html/download.html'
	};
	downloadDialog(downloadURL,data,settings);
}










function submitCEForm(formName,submitUrl,hiddenFields){
	document.getElementById(formName).action = submitUrl;
	document.getElementById(formName).submit();
	
	if(hiddenFields != null){
		jQuery.each(hiddenFields, function(index, item) {
			document.getElementById(item.key).value = item.value;
		});
	}
}


/* requires the following object {src : <path to js>, data : <object>, selector : #<id of html object>}*/
function renderExternalTmpl(item) {
    $.when($.get(item.name))
     .done(function(tmplData) {
         $.templates({ tmpl: tmplData });
         $(item.selector).html($.render.tmpl(item.data));
     });    
}

function showRollOverMenu(id,title,menuOptions){

	var header = '<div onmouseout="HideContent(\''+id+'uniquename\');" onmouseover="ShowContent(\''+id+'uniquename\'); return true;"> '+
				'<span style="FONT-FAMILY: Arial; font-size: 12px; font-weight: Regular; color: #000000;">'+title+'</span>'+
				'<div id="'+id+'uniquename" class="ce-popupmenu"><ul>';
	var menuItems = '';
	for(var i=0;i<menuOptions.length;i++){
		menuItems = menuItems + '<li><a href="'+menuOptions[i][1]+'" style="text-decoration: none;"><b>'+menuOptions[i][0]+'</b> </a></li>';
	}
	var footer = '</ul></div></div>';
	return header + menuItems + footer;

}



///////////////////// table and filter functions ///////////////////////////////////////////////
function setupFilter(filterOptions,searchFn){
	var filterDD = jQuery("#filterType");
	var count = 1;
	jQuery.each(filterOptions, 
				function(index, item) {
						filterDD.get(0).options[count] = new Option(item.value,item.key);
						count++;
				});
	jQuery("#filterText").addClear({"top" : "20px"});
	jQuery('#filterText').on('keydown', 
								function(e) {
									if (e.which == 13 || event.keyCode == 13) {
										e.preventDefault();
										searchFn();
									}
							});
	jQuery('#filterBtn').on("click",function(){
								searchFn();	
							});
}

function initializeFilter(selectedType,selectedValue) {
	if (selectedType != null){
		var selected = false;
		var selectedTypeValue = '';
		for(var i = 0;i < document.getElementById("filterType").length;i++){
	        if(document.getElementById("filterType").options[i].value.indexOf(selectedType) != -1){
	            document.getElementById("filterType").selectedIndex  = i;
	            selectedTypeValue = document.getElementById("filterType").options[i].value;
	            selected = true;
	            break;
	        }
	    }
		if(selected == false) {
			document.getElementById("filterType").selectedIndex  = 0;
		} else {
			$.when(changeFilter(selectedTypeValue)).done(function(){
				if(selectedTypeValue.indexOf('tt') == 0){
	            	document.getElementById('filterText').value=selectedValue;
	            } else if(selectedTypeValue.indexOf('dd') == 0){
	            	for(var i = 0;i < document.getElementById("filterDD").length;i++){
	            		 if(document.getElementById("filterDD").options[i].value == selectedValue){
	         	            document.getElementById("filterDD").selectedIndex  = i;
	         	            break;
	            		 }
	            	}
	            }
			});
		}
	}
}

function changeFilter(selValue) {
	var ddDiv =document.getElementById("ddDiv");
	var ttDiv =document.getElementById("ttDiv");
	var valParts = selValue.split('~');
	if(valParts[0]=='dd'){
		var data={filterTypeValue : valParts[2]	};
		var filterId=document.getElementById('filterDD');
		filterId.options.length=0;
		new LoadDataIntoDropDown(window[valParts[1]](),data,{addselect:true,validateFilter:true,async:false}).populate(filterId);
		ddDiv.style.display ='inline-block';
		ttDiv.style.display ='none';
	} else if(valParts[0]=='tt'){
		document.getElementById('filterText').value="";
		ddDiv.style.display ='none';
		ttDiv.style.display ='inline-block';
	} else if(valParts[0]=='all'){
		ddDiv.style.display ='none';
		ttDiv.style.display ='none';
	}

	return;
}

function validateFilter() {
	var valParts = document.getElementById("filterType").value.split('~');
	var filterId = '';
	if(valParts[0]=='dd'){
		filterId = document.getElementById('filterDD').value;
		if (filterId == 'empty'|| filterId=='select') {
			alert("Please select  filter value");
			return false;
		}
	} else if(valParts[0]=='tt'){
		filterId = document.getElementById('filterText').value;
		if (filterId == '') {
			alert("Filtered value can't be blank");
			return false;
		}

	} else {
		filterId = valParts[2];
	}

	document.getElementById('filterTypeId').value = valParts[2];
	document.getElementById('filterValueId').value = filterId;
	
	return true;
}


function retrieve(elementName){
	if(document.getElementById(elementName) != null) {
		return document.getElementById(elementName).value;
	}
	return "";
}

function retrieveForRadio(elementName){
	if(document.getElementsByName(elementName) != null) {
		var radioValue = $("input[name="+elementName+"]:checked").val();
		if(typeof radioValue !== "undefined" ) {
			return radioValue;
		}
	}
	//this is a workaround for firstime loading of the page as it seems the radio is not set
	if(document.getElementById("table"+elementName) != null) {
		return document.getElementById("table"+elementName).value;
	}
	//if no footer is there
	return "";
}

function getOperationFromURL(url,variable) {
	var query = url.split("/");
	return query[query.length - 1];
	/*
	if(url.indexOf('/-/') > -1) {
		var query = url.split("/-/")[1];
		var vars = query.split("/");
		if(vars.length >= 3){
			if(vars[2].indexOf('?') > -1) {
				return vars[2].split("?")[0];
			} else {
				return vars[2];
			}
		}
	} else if(url.indexOf('?') > -1) {
		var query = url.split("?")[1];
		var vars = query.split("&");
		for (var i=0;i<vars.length;i++) {
			var pair = vars[i].split("=");
			if (pair[0].indexOf(variable) > -1) {
				return pair[1];
			}
		}
	}
*/
	alert('Query Variable ' + variable + ' not found');
}

ClassEdgeFn.loadTableData = function (url,columnDefs,extraProps){
	var tableProps = {tableId : "dTable", paginate : true, noOfRows : 15, serverside : true,  paginationType : "full_numbers",
						showHeader : true, sortCol : 0, sortOrder : 'desc', rowClick : false, rowClickFn : null,
						headerFn : ClassEdgeFn.defaultHeader};
	try {
		if (Object.prototype.toString.call(extraProps) === '[object Object]') {
			jQuery.extend(tableProps, extraProps);
		} else {
			tableProps.paginate = extraProps;
		}
	} catch (e) {
		//this may happen in lower version
		tableProps.paginate = extraProps;
	}
	var tableId = tableProps.tableId;
	var paginate = tableProps.paginate;
	var serverside = tableProps.serverside;
	var noOfRows = tableProps.noOfRows;
	var paginationType = tableProps.paginationType;
	var rowClick = tableProps.rowClick;
	var operation = getOperationFromURL(url,"Operation");
	console.log(tableId+"~~"+paginate +"~~"+noOfRows +"--"+serverside +"--"+tableProps.showHeader +"--"+paginationType +"--"+operation+"--"+rowClick);

	//construct url format 
	var serverurl = url;
	if(localStorage.apiVersion || localStorage.apiVersion != null){
		serverurl = serverurl.replace('{version}',localStorage.apiVersion);
	}
	console.log('url>>'+serverurl+' props>>>',tableProps);
	
    return $('#'+tableId).dataTable({
							"bSortable" : true,
							"aaSorting" : [ [ tableProps.sortCol, tableProps.sortOrder ]],
							"bPaginate" : paginate,
							"bLengthChange" : false,
					        "bFilter" : false,
					        "bInfo" : true,
					        "bAutoWidth" : true,
					        "bStateSave" : true,
					        "processing" : serverside,
					        "serverSide" : serverside,
					        "iDisplayLength" : noOfRows,
					        "sPaginationType" : paginationType,
					        "ajax" : {
									    		type : 'GET',
									    		url : serverurl,
									    		contentType: 'application/json',
									            dataType: 'json',									 
									    		headers: tableProps.headerFn()
									    	},
					        "oLanguage" : {
								sProcessing: "<img src='/ce-static/common/css/images/loading.gif'>"
					        },
					        
					        "fnDrawCallback": function() {
						        	if(tableProps.showHeader == false){
						            	$("#"+tableId+" thead").remove();
						        	}
						        	if(tableProps.rowClick == true){
						        		$("#"+tableId+" tbody tr").css('cursor', 'pointer');
						        		$("#"+tableId+" tbody tr").click(function() {
						        			tableProps.rowClickFn(this);
						        		});
						        	}
					        },
					        "fnStateSave": function (oSettings, oData) {
					        	localStorage.setItem( 'DataTables_'+operation, JSON.stringify(oData) );
					        },
					        "fnStateLoad": function (oSettings) {
					        	return JSON.parse( localStorage.getItem('DataTables_'+operation) );
					        },
					        "aoColumnDefs" : columnDefs
	 			});
    
    /*
     * "fnServerParams": function ( aoData ) {

							       	 var sortIndex = -1;
							       	 var sortColumn = "";
							       	 for(var i = 0; i < aoData.length; i++){
								        	 if(aoData[i].name == "iSortCol_0"){
								        		 sortIndex = aoData[i].value;
								        	 }
							       	 }

							       	 if(sortIndex != -1){
							       		 for(var i = 0; i < aoData.length; i++){
									        	 if(aoData[i].name == "mDataProp_"+sortIndex){
									        		 sortColumn = aoData[i].value;
									        	 }
								        	 }

							       		 aoData.push( { "name": "sortColumn", "value": sortColumn });
							       	 }
								     aoData.push(
									        { "name": "filterName", "value":  retrieve('filterTypeId') },
									        { "name": "filterValue", "value": retrieve('filterValueId') },
									        { "name": "filterExtraParam", "value": retrieve("filterExtraParam") },
									        { "name": "status", "value": retrieveForRadio('status') }
									  );

					        },
     */
    
}



//////////////////////////// File upload //////////////////////////////////////////////

function commonAttachFile(divId,linkId){
	var mainDiv=document.getElementById(divId);
	var testFile =document.getElementById(divId+"File");
	if(testFile==null){
		var newdiv = document.createElement('div');
		newdiv.setAttribute("id",divId+'child');
		newdiv.innerHTML = "<input type=\"file\" name=\""+divId+"File"+"\" id=\""+divId+"File"+"\" size=\"20\"/> <input type=\"button\" value=\"X\" onclick=\" commonDeleteKeyword(\'"
				+ divId + "\',\'" + divId+'child'+ "\',\'" +linkId+ "\')\">";
		mainDiv.appendChild(newdiv);
		var linkDiv=document.getElementById(linkId);
		linkDiv.style.display='none';
	}
}

function commonDeleteKeyword(id,divno,linkid){
	var d = document.getElementById(id);
	var olddiv = document.getElementById(divno);
	d.removeChild(olddiv);
	var linkDiv=document.getElementById(linkid);
	linkDiv.style.display='block';
}

