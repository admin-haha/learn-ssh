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
			<h3>修改学院</h3>
		</div>
		<div class="row-div">
			<div class="row-left"><label>学院名称</label></div>
			<div class="row-right">
				<input type="hidden" id="id" value="${college.id }"/>
				<input type="text" id="name" value="${college.name }"/>
			</div>
		</div>
		<div class="bottom-div">
			<button class="button-blue" id= "save" >提交</button>
		</div>
	</div>
<script type="text/javascript">
		
		
		var save = function(){
			var name = $('#name').val();
			if(!name||''==name||'undefined'==name){
				$.messager.alert('提示','请输入学院名称','warn');
				return ;
			}
			$.ajax({
				url:"/college/update",
				async:false,
				type:'PUT',
				contentType : 'application/json',
				data:JSON.stringify({"name":name,"id":$('#id').val()}),
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