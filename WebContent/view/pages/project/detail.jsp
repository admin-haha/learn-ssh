<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>题目详情</title>
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
			<h3>题目详情</h3>
		</div>
		<div class="row-div">
			<div class="row-left"><label>教师</label></div>
			<div class="row-right">
				<input type="text"  value="${user.name }" readonly="readonly" />
			</div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>题目名称</label></div>
			<div class="row-right">
				<input type="text" id="name" value="${project.title }" readonly="readonly" />
				<input type="hidden" id="id" value="${project.id }" />
			</div>
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
			<div class="row-left"><label>详细描述</label></div>
			<div class="row-right"><textarea readonly="readonly" cols="30" rows="3" id="detail" draggable="false">${project.detail }</textarea></div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>学生个数</label></div>
			<div class="row-right">
            <input class="text" id="studentCount" value="${project.studentCount }" readonly="readonly">
			</div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>备注</label></div>
			<div class="row-right"><textarea readonly="readonly" cols="30" rows="3" id="memo" draggable="false">${project.memo }</textarea></div>
		</div>
		<div class="bottom-div">
			<button class="button-blue" id= "close" >关闭</button>
		</div>
	</div>
<script type="text/javascript">
		$('#close').on('click',function(){
			window.close();
		});
</script>
</body>
</html>