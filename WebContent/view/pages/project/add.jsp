<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加题目</title>
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
			<h3>添加题目</h3>
		</div>
		<div class="row-div">
			<div class="row-left"><label>题目名称</label></div>
			<div class="row-right"><input type="text" id="name" /></div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>所属学院</label></div>
			<div class="row-right">
					<input id="college" class="easyui-combobox" data-options="
				                    url:'/college/queryAllCollege',
				                    method:'get',
				                    valueField:'id',
				                    textField:'text',
				                    multiple:false,
				                    panelHeight:'auto',
				                    onChange:function(newValue,oldValue){
				                    	$('#department').combobox('reload','/department/queryAllDepartment?collegeIds='+newValue);
				                    },
				                    onUnselect:function(){
				                    	$('#department').combobox('clear');
				                    }
				                    ">
			</div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>所属专业</label></div>
			<div class="row-right">
					<input id="department" class="easyui-combobox" data-options="url:'/department/queryAllDepartment',
						                    method:'get',
						                    valueField:'id',
						                    textField:'text',
						                    multiple:false,
						                    panelHeight:'auto'">
			</div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>详细描述</label></div>
			<div class="row-right"><textarea cols="30" rows="3" id="detail" draggable="false"></textarea></div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>学生个数</label></div>
			<div class="row-right">
            <input class="easyui-numberspinner" id="studentCount" value="1" data-options="min:1,max:10" style="width:100%;">
			</div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>备注</label></div>
			<div class="row-right"><textarea cols="30" rows="3" id="memo" draggable="false"></textarea></div>
		</div>
		<div class="bottom-div">
			<button class="button-blue" id="save">提交</button>
		</div>
	</div>
<script type="text/javascript">
		
var save = function(){
	var name = $('#name').val();
	var department = $('#department').val();
	var college = $('#college').val();
	if(!name||''==name||'undefined'==name){
		$.messager.alert('提示','请输入题目名称','warn');
		return ;
	}
	if(!department||''==department||'undefined'==department){
		$.messager.alert('提示','请选择学院','warn');
		return ;
	}
	if(!college||''==college||'undefined'==college){
		$.messager.alert('提示','请选择专业','warn');
		return ;
	}
	$.ajax({
		url:"/project/save",
		async:false,
		type:"POST",
		contentType : 'application/json',
		data:JSON.stringify({"title":name,"detail":$('#detail').val(),"memo":$('#memo').val(),'studentCount':$('#studentCount').val(),'collegeId':$('#college').val(),'departmentId':$('#department').val()}),
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
$('#save').on('click',save);
</script>
</body>
</html>