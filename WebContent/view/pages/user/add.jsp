<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加人员</title>
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
			<h3>添加人员</h3>
		</div>
		<div class="row-div">
			<div class="row-left"><label>人员名称</label></div>
			<div class="row-right"><input type="text" id="name" /></div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>性别</label></div>
			<div class="row-right"><label>角色名称</label></div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>所属学院</label></div>
			<div class="row-right">
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
			</div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>所属专业</label></div>
			<div class="row-right">
					<input id="department" class="easyui-combobox" data-options="url:'/department/queryAllDepartment',
						                    method:'get',
						                    valueField:'id',
						                    textField:'text',
						                    multiple:true,
						                    panelHeight:'auto'">
			</div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>联系电话</label></div>
			<div class="row-right"><input class="easyui-textbox"  ></div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>登陆账号</label></div>
			<div class="row-right"><input class="easyui-textbox" data-options="iconCls:'icon-man'" ></div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>登录密码</label></div>
			<div class="row-right"><input class="easyui-passwordbox" iconWidth="28" style="height:34px;padding:10px"></div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>确认密码</label></div>
			<div class="row-right"><input class="easyui-passwordbox" iconWidth="28" style="height:34px;padding:10px"></div>
		</div>
		<div class="bottom-div">
			<button class="button-blue" >提交</button>
		</div>
	</div>

</body>
</html>