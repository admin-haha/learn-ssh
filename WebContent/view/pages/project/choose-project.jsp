<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>题目列表</title>
<link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/bootstrap/easyui.css" />
<link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/icon.css" />
<script type="text/javascript" src="/js/jquery-3.2.1.min.js" ></script>
<script type="text/javascript" src="/js/utils.js" ></script>
<script type="text/javascript" src="/jquery-easyui/jquery.easyui.min.js" ></script>
<script type="text/javascript" src="/jquery-easyui/locale/easyui-lang-zh_CN.js" ></script>
</head>
<body class="easyui-layout">
<input id="userId" class="hidden" value="${userId }" />
<div style='display:none'><span style="visibility: hidden;white-space: nowrap; font-size: 24px; " id='forStrLen'></span></div>
<div region="north"  split="true" id="northdiv" style="height:100px;padding:10px;">
	<table width="98%">
				<tr>
					<td width="30%">
						<label>题目名称：</label>
	                       	<input id="name" class="easyui-textbox" >
					</td>
					<td width="30%">
						<label>所属学院：</label>
						<input id="college" class="easyui-combobox" data-options="
				                    url:'/college/queryAllCollege',
				                    method:'get',
				                    valueField:'id',
				                    textField:'text',
				                    multiple:true,
				                    panelHeight:'auto',
				                    onChange:function(newValue,oldValue){
				                    	$('#department').combobox('reload','/department/queryAllDepartment?collegeIds='+newValue);
				                    },
				                    onUnselect:function(){
				                    	$('#department').combobox('clear');
				                    }
				                    ">
					</td> 
					<td width="40%">
					<label>所属科系：</label>
					<input id="department" class="easyui-combobox" data-options="url:'/department/queryAllDepartment',
						                    method:'get',
						                    valueField:'id',
						                    textField:'text',
						                    multiple:true,
						                    panelHeight:'auto'">
					</td>
				</tr>
				<tr>
					<td width="30%">
						<button class="easyui-linkbutton" style="width: 130px;" type="button" id="query" data-options="iconCls:'icon-ok'">&nbsp;&nbsp;查询&nbsp;&nbsp;</button>
					</td>
					<td width="30%">
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
		url: '/project/query',
		queryParams:{name:$('#name').val(),college:$('#college').val(),department:$('#department').val()},
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
	        {field:'text', title:'题目名称', width: '15%',halign: 'center',align:'center'},
	        {field:'teacher', title:'指导教师', width: '10%',halign: 'center',align:'center'},
	        {field:'detail', title:'详细描述', width: '20%',halign: 'center',align:'center'},
	        {field:'memo', title:'备注', width: '10%',halign: 'center',align:'center'},
	        {field:'createTime', title:'创建时间', width: '15%',halign: 'center',align:'center'},
	        {field:'updateTime', title:'更新时间', width: '15%',halign: 'center',align:'center'},
	        {field:'studentCount', title:'需要人数', width: '5%',halign: 'center',align:'center'},
	        {field:'chooseCount', title:'已选人数', width: '5%',halign: 'center',align:'center',formatter:function(val,rec){
        				return rec.chooseCount+'人选择';
        }},
	        {field:'status', title:'选题状态', width: '5%',halign: 'center',align:'center',formatter:function(val,rec){
	        		if('0' == rec.canChoose){
	        			return '<font color="red">进行中</font>';
	        		}else{
	        			return '<font color="green">已完成</font>';
	        		}
	        	
	        }},
	        {field:'opt', title:'操作', width: '6%',halign: 'center',align:'center',formatter(val,rec){
	        		var id = rec.id;
	        		if('0' == rec.canChoose){
	        			return '<a href="javascript:choose(\''+id+'\',\''+rec.text+'\');">选择</a>';
	        		}else{
	        			return '-';
	        		}
				}
	        }]],
	    onLoadSuccess:function (data) {
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


var choose = function(id,name){
	var userId = $('#userId').val();
	var projectId = id;
	$.messager.confirm('确认','你是否我确认选择该题目《'+name+'》？',function(r){
		if(r){
			$.ajax({
				url:"/project/choose",
				async:false,
				type:"POST",
				contentType : 'application/json',
				data:JSON.stringify({"userId":userId,'projectId':projectId}),
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

</script>
</body>
</html>