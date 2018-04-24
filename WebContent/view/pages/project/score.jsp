<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评分</title>
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
			<h3>评分</h3>
		</div>
		<div class="row-div">
			<div class="row-left"><label>题目名称</label></div>
			<div class="row-right">
				<input type="text" value="${project.title }" readonly="readonly"/>
				<input type="hidden" id="projectId" value="${project.title }" />
			</div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>学生姓名</label></div>
			<div class="row-right">
				<input type="text" value="${user.name }" readonly="readonly"/>
				<input type="hidden" id="userId" value="${user.id }"/>
			</div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>评分（1~10）</label></div>
			<div class="row-right">
            <input class="easyui-numberspinner" id="score" value="1" data-options="min:1,max:10" style="width:100%;">
			</div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>评语</label></div>
			<div class="row-right"><div class="row-right"><textarea cols="30" rows="3" id="memo" draggable="false"></textarea></div></div>
		</div>
		<div class="bottom-div">
			<button class="button-blue" id="save">提交</button>
		</div>
	</div>
<script type="text/javascript">
		
var save = function(){
	
	$.messager.confirm('提示','是否保存评分？',function(r){
		if(r){
			$.ajax({
				url:"/project/score",
				async:false,
				type:"POST",
				contentType : 'application/json',
				data:JSON.stringify({"userId":$('#userId').val(),"projectId":$('#projectId').val(),"score":$('#score').val(),'memo':$('#memo').val()}),
				success:function(data){
					msg = eval('(' + data + ')');
					$.messager.alert('提示',msg.msg,'info',function(){
						if('0'==msg.flag){
							window.close();
							window.opener.loadData();
						}
					});
				}
			});
		}
	});
	
}
$('#save').on('click',save);
</script>
</body>
</html>