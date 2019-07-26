/* http://www.jsviews.com/#tags */
$.views.tags('bluebutton', 
	'<a id="{{:~tag.tagCtx.props.id}}" class="cancelButton"><span> &nbsp;&nbsp;{{:~tag.tagCtx.props.name}}&nbsp;&nbsp;</span></a>');

$.views.tags('portlettitle', [
	'<script language="javascript">',
	'jQuery("#p_p_id_{{:~tag.tagCtx.props.portletname}}_ span.portlet-title-text").html("{{:~tag.tagCtx.props.name}}");',
	'jQuery("#p_p_id_{{:~tag.tagCtx.props.portletname}}_ header.resouses_darkbluetop > span.portlet-title-text").html("{{:~tag.tagCtx.props.name}}");',
	'</script>',
	'<div id="statusMsgDiv"></div>'
	].join(""));

$.views.tags('successMsg', 
	'<table><tr><td height="10px"></td></tr><tr><td class="portlet-msg-alert"><font color="#FE6700" size="2">{{:}}</font></td></tr><tr><td height="10px"></td></tr></table>');

$.views.tags('errorMsg', 
	'<table><tr><td height="10px"></td></tr><tr><td> <div class="portlet-msg-error">{{:}}</div></td></tr><tr><td height="10px"></td></tr></table>');

$.templates("msgTemplate", "{{if status  == 'true'}} {{successMsg statusText /}} {{else}} {{errorMsg statusText /}} {{/if}}");

$.views.tags('tablefilter', [
	'<style>',
	'.datasel { padding: 0px 15px 0px 0px; width:auto;float:left;}',
	'.dataip { width: 320px; padding: 0px 15px 0px 0px;float:left;}',
	'.dataip input[type="text"] {float:left;padding: 5px;font-size: 14px;height: auto;}',
	'</style>',
	'<table style="width:auto;float:left;">',
	'	<tr><td style="vertical-align: top;">',
	'	<select size="1" name="filterType" id="filterType" style="padding: 5px;height: 30px;width:auto"	onchange="javascript:changeFilter(this.value);">',
	'		<option value="all~all~all">Show All</option>',			
	'	</select>',
	'	</td>',
	'	<td width="15px"></td>',
	'	<td>',
	'	<div>',
	'		<div id="ddDiv" class="datasel" style="display:none" >',
	'			<select name="filterDD"	id="filterDD" style="float:left;padding: 5px;">',
	'				   <option value="">Select a value</option>',
	'			</select>',
	'		</div>',
	'		<div id="ttDiv" class="dataip"  style="display:none" >',
	'			<input type="text" name="filterText" id="filterText" size="45" >',
	'		</div>',
	'		<div style="display: inline-block;float:left;padding-top: 5px;">',
	'			{{bluebutton id="filterBtn" name="Filter" /}}',
	'		</div>',
	'	</div>',
	'	</td></tr>',
	'</table>',
	'<input type="hidden" id="filterValueId" name="filterValueId" value ="" />',
	'<input type="hidden" id="filterTypeId" name="filterTypeId" value ="" />',
	'<input type="hidden" id="filterExtraParam" name="filterExtraParam" value ="" />'	
	].join(" "));