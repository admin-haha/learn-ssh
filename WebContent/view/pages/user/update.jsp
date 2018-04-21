<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改人员信息</title>
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
			<h3>修改人员信息</h3>
		</div>
		<div class="row-div">
			<div class="row-left"><label>人员名称</label></div>
			<div class="row-right">
				<input type="text" id="name" value="${user.name }"/>
				<input type="hidden" id="id"  value="${user.id }"/>
				<input type="hidden" id="account"  value="${user.account }"/>
				<input type="hidden" id="password"  value="${user.password }"/>
			</div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>性别</label></div>
			<div class="row-right">
					<input type="radio" style="margin-top: 8px;" class="gender" <c:if test="${user.gender eq '0' }">checked</c:if> name="gender" value="0"/>&nbsp;男&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" style="margin-top: 8px;" class="gender" <c:if test="${user.gender eq '1' }">checked</c:if> name="gender" value="1" />&nbsp;女
			</div>
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
				                    panelHeight:'auto',onLoadSuccess:function(){
				                    	$('#college').combobox('setValue','${usercollegeId }');
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
					<input id="department" class="easyui-combobox" data-options="url:'/department/queryAllDepartment',
						                    method:'get',
						                    valueField:'id',
						                    textField:'text',
						                    multiple:false,
						                    panelHeight:'auto',
						                    onLoadSuccess:function(){
						                    	$('#department').combobox('setValue','${user.departmentId }');
						                    }">
			</div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>联系电话</label></div>
			<div class="row-right"><input class="easyui-textbox" id="mobile" value="${user.mobile }" ></div>
		</div>
		<div class="bottom-div">
			<button class="button-blue" id="save">提交</button>
		</div>
	</div>
<script type="text/javascript">
		
		
		var save = function(){
			var name = $('#name').val();
			if(!name||''==name||'undefined'==name){
				$.messager.alert('提示','请输入人员名称','warn');
				return ;
			}
			$.ajax({
				url:"/user/update",
				async:false,
				type:"PUT",
				contentType : 'application/json',
				data:JSON.stringify({"id":$('#id').val(),"account":$('#account').val(),"password":$("#password").val(),"name":name,"gender":$('.gender:checked').val(),'mobile':$('#mobile').val(),'collegeId':$('#college').val(),'departmentId':$('#department').val()}),
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