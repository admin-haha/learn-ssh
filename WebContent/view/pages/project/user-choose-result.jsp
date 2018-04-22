<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分配权限</title>
<link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/bootstrap/easyui.css" />
<link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/icon.css" />
<link type="text/css" rel="stylesheet" href="/css/common.css" />
<script type="text/javascript" src="/js/jquery-3.2.1.min.js" ></script>
<script type="text/javascript" src="/jquery-easyui/jquery.easyui.min.js" ></script>
<script type="text/javascript" src="/jquery-easyui/locale/easyui-lang-zh_CN.js" ></script>
</head>
<body class="easyui-layout">
	<h2>当前题目:<font style="color:red;">${project.title }</font></h2>
    <p>选择该题目的人员</p>
    <div style="text-align: center;"><button class="button-blue" id="close" style="width:30%;">关闭</button></div>
    <div style="margin:20px 0;"></div>
    <table title="分配权限" id="detail"  >
    </table>
    <p></p>
<script type="text/javascript">
		
$(function(){
	var projectId = '${project.id}';
		$('#detail').datagrid({
			height: $(window).height()  - 300,
			url: '/user/queryAllUsersWithProject?projectId='+projectId ,
			pageNumber: 1,
	        pageSize:20,
			fit: true,//自动大小
			nowrap:true, //换行
	        rownumbers:true,//行号
	        striped: true,
	        singleSelect:true,//单行选取
	        pagination:true,//显示分页
		    columns:[[
		    	{field:'name', title:'人员名称', width: '10%',halign: 'center',align:'center'},
		        {field:'gender', title:'性别', width: '5%',halign: 'center',align:'center'},
		        {field:'department', title:'所属科系', width: '15%',halign: 'center',align:'center'},
		        {field:'college', title:'所属学院', width: '15%',halign: 'center',align:'center'},
		        {field:'account', title:'登陆账号', width: '15%',halign: 'center',align:'center'},
		        {field:'mobile', title:'联系电话', width: '15%',halign: 'center',align:'center'},
		        {field:'createTime', title:'创建时间', width: '15%',halign: 'center',align:'center'},
		        {field:'updateTime', title:'更新时间', width: '15%',halign: 'center',align:'center'}
		    ]]
		});
		$('#close').on('click',function(){
			window.close();
		});
});


</script>
</body>
</html>