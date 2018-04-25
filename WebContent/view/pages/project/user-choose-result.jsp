<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选题结果</title>
<link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/bootstrap/easyui.css" />
<link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/icon.css" />
<link type="text/css" rel="stylesheet" href="/css/common.css" />
<script type="text/javascript" src="/js/jquery-3.2.1.min.js" ></script>
<script type="text/javascript" src="/jquery-easyui/jquery.easyui.min.js" ></script>
<script type="text/javascript" src="/jquery-easyui/locale/easyui-lang-zh_CN.js" ></script>
</head>
<body class="easyui-layout">
	<div class="main-add" style="height: 550px;">
		<div class="row-div bg-red">
			<h3>选题结果</h3>
		</div>
		<div class="row-div">
			<div class="row-left"><label>题目名称</label></div>
			<div class="row-right"><input type="text" value="${project.title }" readonly="readonly" /></div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>题目描述</label></div>
			<div class="row-right"><input type="text" value="${project.detail }" readonly="readonly" /></div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>题目备注</label></div>
			<div class="row-right"><input type="text" value="${project.memo }" readonly="readonly" /></div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>所属学院</label></div>
			<div class="row-right">
					<input readonly="readonly" id="college" class="easyui-combobox" data-options="
				                    url:'/college/queryAllCollege',
				                    method:'get',
				                    valueField:'id',
				                    textField:'text',
				                    multiple:false,
				                    panelHeight:'auto',
				                    onLoadSuccess:function(){
				                    	$('#college').combobox('setValue','${project.collegeId }');
				                    },
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
					<input readonly="readonly" id="department" class="easyui-combobox" data-options="url:'/department/queryAllDepartment',
						                    method:'get',
						                    valueField:'id',
						                    textField:'text',
						                    multiple:false,
						                    panelHeight:'auto',
						                    onLoadSuccess:function(){
						                    	$('#department').combobox('setValue','${project.departmentId }');
						                    }">
			</div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>指导教师</label></div>
			<div class="row-right">
					<input type="text" value="${teacher.name }" readonly="readonly"/>
			</div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>评分</label></div>
			<div class="row-right">
					<input type="text" value="${userProject.score }" readonly="readonly"/>
			</div>
		</div>
		<div class="row-div" style="height:80px;">
			<div class="row-left" style="height:70px;"><label>评语</label></div>
			<div class="row-right" style="height:70px;">
					<textarea cols="30" rows="5" readonly="readonly" draggable="false">${userProject.memo }</textarea>
			</div>
		</div>
		<div class="bottom-div">
			<button class="button-blue" id="refresh">刷新</button>
		</div>
	</div>
	<script type="text/javascript">
		(function(){
			$('#refresh').on('click',function(){
				window.location.reload();
			});
		})()
	</script>
</body>
</html>