<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色列表</title>
<link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/bootstrap/easyui.css" />
<link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/icon.css" />
<script type="text/javascript" src="/js/jquery-3.2.1.min.js" ></script>
<script type="text/javascript" src="/js/utils.js" ></script>
<script type="text/javascript" src="/jquery-easyui/jquery.easyui.min.js" ></script>
<script type="text/javascript" src="/jquery-easyui/locale/easyui-lang-zh_CN.js" ></script>
</head>
<body class="easyui-layout">
<div style='display:none'><span style="visibility: hidden;white-space: nowrap; font-size: 24px; " id='forStrLen'></span></div>
<div region="north"  split="true" id="northdiv" style="height:70px;padding:10px;">
	<table width="98%">
				<tr>
					<td width="30%">
						<label>角色名称：</label>
	                       	<input id="name" class="easyui-textbox" >
					</td>
					<td width="30%">
						<button class="easyui-linkbutton" style="width: 130px;" type="button" id="query" data-options="iconCls:'icon-ok'">&nbsp;&nbsp;查询&nbsp;&nbsp;</button>
					</td> 
					<td width="40%">
					</td>
				</tr>
			
				
			</table>
</div>
<div region="center" style="overflow:hidden;">
  <div id="tabSearchResult"  class="easyui-tabs" fit="true" border="false">
     <div title="查询结果"  id="divSearchResultDetails">
       <table id="detail" fit="true"></table>
     </div>
 </div>
</div>
<script type="text/javascript">
var loadData = function(){
	$('#detail').datagrid({
		height: $(window).height()  - 30,
		url: '/role/query' ,
		queryParams:{name:$('#name').val()},
		method:'POST',
		pageNumber: 1,
        pageSize:20,
		fit: true,//自动大小
		nowrap:true, //换行
        rownumbers:true,//行号
        striped: true,
        singleSelect:true,//单行选取
        pagination:true,//显示分页
	    columns:[[
	        {field:'text', title:'角色名称', width: '15%',halign: 'center',align:'center'},
	        {field:'memo', title:'角色描述', width: '25%',halign: 'center',align:'center'},
	        {field:'createTime', title:'创建时间', width: '15%',halign: 'center',align:'center'},
	        {field:'updateTime', title:'更新时间', width: '15%',halign: 'center',align:'center'},
	        {field:'assignCount', title:'分配人数', width: '5%',halign: 'center',align:'center'}
	    ]],
	  
	    onLoadSuccess: function (data) {
	    	$("#noResultMsg").remove();
        	var rowArray = $('#detail').datagrid('getRows');               
              if(rowArray.length==0){
               var msg = $("<div id ='noResultMsg' style='display:none;text-align:center;padding:10px;border:1px solid #AAAAA;background-color:yellow;  margin-top:20px;'>您当前的选择，无返回信息，请重新调整条件!</div>"); 
                  msg.insertAfter($('#detail')); 
                  msg.show(200); 
              }  
       }
	});
}

$('#query').on('click',loadData);

</script>
</body>
</html>