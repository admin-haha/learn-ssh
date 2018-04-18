<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限列表</title>
<link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/bootstrap/easyui.css" />
<link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/icon.css" />
<link type="text/css" rel="stylesheet" href="/css/common.css" />
<script type="text/javascript" src="/js/jquery-3.2.1.min.js" ></script>
<script type="text/javascript" src="/jquery-easyui/jquery.easyui.min.js" ></script>
<script type="text/javascript" src="/jquery-easyui/locale/easyui-lang-zh_CN.js" ></script>
</head>
<body class="easyui-layout">
    <table id="detail" class="easyui-treegrid" >
    </table>
<script type="text/javascript">
		
$(function(){
	var roleId = '${role.id}';
		$('#detail').treegrid({
			height: $(window).height()  - 200,
			url: '/function/queryAllFunctionWithRole?roleId='+roleId ,
			method:'GET',
			checkbox:false,
			lines:true,
			cascadeCheck:false,
			idField:'id',
		    treeField:'name',
		    columns:[[
		        {field:'name', title:'权限名称', width: '20%'},
		        {field:'funcUrl', title:'权限详情', width: '20%'},
		        {field:'funcKey', title:'权限唯一标示', width: '20%'},
		        {field:'funcOrder', title:'顺序', width: '8%',align:'center'},
		        {field:'createTime', title:'创建时间', width: '15%',align:'center'},
		        {field:'updateTime', title:'更新时间', width: '15%',align:'center'}
		    ]]
		});
});
		
</script>
</body>
</html>