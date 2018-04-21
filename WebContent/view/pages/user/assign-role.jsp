<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改科系</title>
<link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/bootstrap/easyui.css" />
<link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/icon.css" />
<link type="text/css" rel="stylesheet" href="/css/common.css" />
<script type="text/javascript" src="/js/jquery-3.2.1.min.js" ></script>
<script type="text/javascript" src="/jquery-easyui/jquery.easyui.min.js" ></script>
<script type="text/javascript" src="/jquery-easyui/locale/easyui-lang-zh_CN.js" ></script>
</head>
<body class="easyui-layout">
	<div class="main-add">
		<div class="row-div bg-red">
			<h3>分配角色</h3>
		</div>
		<div class="row-div">
			<div class="row-left"><label>人员</label></div>
			<div class="row-right">
				<input type="text" id="name" value = "${user.name }" readonly="readonly"/>
				<input type="hidden" id="id" value = "${user.id }" />
			</div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>选择角色</label></div>
			<div class="row-right">
			<input id="role" class="easyui-combobox" data-options="
				                    url:'/role/queryAllRoles',
				                    method:'get',
				                    valueField:'id',
				                    textField:'text',
				                    multiple:false,
				                    panelHeight:'auto',
				                    onLoadSuccess:function(){
				                    	$('#role').combobox('setValue','${roleId }');
				                    }
				                    ">
			</div>
		</div>
		<div class="bottom-div">
			<button class="button-blue" id= "save" >提交</button>
		</div>
	</div>
<script type="text/javascript">
		
		
		var save = function(){
			$.ajax({
				url:"/user/assignRole",
				async:false,
				type:"POST",
				contentType : 'application/json',
				data:JSON.stringify({"userId":$('#id').val(),"roleId":$('#role').val()}),
				success:function(msg){
					msg = eval('(' + msg + ')');
					$.messager.alert('提示',msg.msg,'info',function(){
						if('0'==msg.flag){
							window.close();
							window.opener.loadData();
						}
					});
				}
			});
		}
		$('#save').on('click',save);
</script>
</body>
</html>