<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加角色</title>
<link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/bootstrap/easyui.css" />
<link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/icon.css" />
<link type="text/css" rel="stylesheet" href="/css/common.css" />
<script type="text/javascript" src="/js/jquery-3.2.1.min.js" ></script>
<script type="text/javascript" src="/jquery-easyui/jquery.easyui.min.js" ></script>
<script type="text/javascript" src="/jquery-easyui/locale/easyui-lang-zh_CN.js" ></script>
</head>
<body class="easyui-layout">
	<div class="main-add">
		<div class="row-div">
			<div class="row-left"><label>角色名称</label></div>
			<div class="row-right"><input type="text" id="name" /></div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>角色描述</label></div>
			<div class="row-right"><textarea cols="3" rows="20" id="memo"></textarea></div>
		</div>
		<div class="row-div">
			<button id= "save" style="width: 50%;border-radius: 20px;height: 30px;">提交</button>
		</div>
	</div>
<script type="text/javascript">
		
		
		var save = function(){
			$.ajax({
				url:"/role/save",
				async:false,
				type:"POST",
				dataType:"json",
				data:{"name":$('#name').val(),"memo":$('#memo').val()},
				success:function(data){
					
				}
			});
		}
		$('#save').on('click',save);
</script>
</body>
</html>