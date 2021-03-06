<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科系查询</title>
<link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/bootstrap/easyui.css" />
<link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/icon.css" />
<script type="text/javascript" src="/js/jquery-3.2.1.min.js" ></script>
<script type="text/javascript" src="/js/utils.js" ></script>
<script type="text/javascript" src="/jquery-easyui/jquery.easyui.min.js" ></script>
<script type="text/javascript" src="/jquery-easyui/locale/easyui-lang-zh_CN.js" ></script>
</head>
<body class="easyui-layout">
<div style='display:none'><span style="visibility: hidden;white-space: nowrap; font-size: 24px; " id='forStrLen'></span></div>
<div region="north"  split="true" id="northdiv" style="height:80px;padding:10px;">
		<table width="98%">
				<tr>
					<td width="30%">
						<label>学院名称：</label>
	                       	<input id="name" class="easyui-textbox" >
					</td>
					<td width="30%">
						<label>学院选择：</label>
	                       	<input id="college" class="easyui-combobox" data-options="
				                    url:'/college/queryAllCollege',
				                    method:'get',
				                    valueField:'id',
				                    textField:'text',
				                    multiple:true,
				                    panelHeight:'auto'
				                    ">
					</td> 
					<td width="40%">
					</td>
				</tr>
				<tr>
						<td >
							<button class="easyui-linkbutton" style="width: 130px;" type="button" id="query" data-options="iconCls:'icon-ok'">&nbsp;&nbsp;查询&nbsp;&nbsp;</button>
							<button class="easyui-linkbutton" style="width: 130px;" type="button" id="add" data-options="iconCls:'icon-add'">&nbsp;&nbsp;添加&nbsp;&nbsp;</button>
						</td> 
						<td >
						</td>
						<td >
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
		url: '/department/query' ,
		queryParams:{name:$('#name').val(),collegeIds:$('#college').val()},
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
	        {field:'text', title:'科系名称', width: '24%',halign: 'center',align:'center',rowspan:2},
	        {field:'college', title:'所属学院', width: '20%',halign: 'center',align:'center',rowspan:2},
	        {field:'createTime', title:'创建时间', width: '10%',halign: 'center',align:'center',rowspan:2},
	        {field:'updateTime', title:'更新时间', width: '10%',halign: 'center',align:'center',rowspan:2},
	        {field:'opt', title:'操作', width: '20%',colspan:2,halign: 'center',align:'center',rowspan:1}
	       
	    ],[ 
		    	{field:'update', title:'修改', width: '13%',halign: 'center',align:'center',rowspan:1,formatter:function(val,rec){
			    		var id = rec.id;
			    		return '<a href="javascript:update(\''+id+'\');">修改</a>';
		    }},
		    {field:'delete', title:'删除', width: '13%',halign: 'center',align:'center',rowspan:1,formatter:function(val,rec){
					var id = rec.id;
					return '<a href="javascript:deleteRecord(\''+id+'\');">删除</a>';
			}}
		 ]],
	  
	    onLoadSuccess: function (data) {
	    	$("#noResultMsg").remove();
        	var rowArray = $('#detail').datagrid('getRows');               
              if(rowArray.length==0){
               var msg = $("<div id ='noResultMsg' style='display:none;text-align:center;padding:10px;border:1px solid #AAAAA;background-color:yellow;  margin-top:40px;'>您当前的选择，无返回信息，请重新调整条件!</div>"); 
                  msg.insertAfter($('#detail')); 
                  msg.show(200); 
              }  
       }
	});
}

var update = function(id){
	myOpen('/department/update?id='+id,500,500);
}

var deleteRecord = function(id){
	$.messager.confirm('警告','你正在进行删除操作，是否继续？',function(r){
		if(r){
			$.ajax({
				url:"/department/delete",
				async:false,
				type:"DELETE",
				contentType : 'application/json',
				data:JSON.stringify({"id":id}),
				success:function(data){
					msg = eval('(' + data + ')');
					$.messager.alert('提示',msg.msg,'info',function(){
						if('0'==msg.flag){
							loadData();
						}
					});
				}
			});
		}
	});
}

$('#query').on('click',loadData);

$('#add').on('click',function(){
	myOpen('/department/add',500,500);
});
</script>
</body>
</html>