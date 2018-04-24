<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人员注册</title>
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
			<h3>注册</h3>
		</div>
		<div class="row-div">
			<div class="row-left"><label>人员名称</label></div>
			<div class="row-right"><input type="text" id="name" /></div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>性别</label></div>
			<div class="row-right">
					<input type="radio" style="margin-top: 8px;" class="gender" name="gender" value="0" checked/>&nbsp;男&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" style="margin-top: 8px;" class="gender"  name="gender" value="1" />&nbsp;女
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
			<div class="row-left"><label>联系电话</label></div>
			<div class="row-right"><input class="easyui-textbox" id="mobile" ></div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>登陆账号</label></div>
			<div class="row-right"><input class="easyui-textbox" id="account" data-options="iconCls:'icon-man'" ></div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>登录密码</label></div>
			<div class="row-right"><input class="easyui-passwordbox" id="password" iconWidth="28" style="height:34px;padding:10px"></div>
		</div>
		<div class="row-div">
			<div class="row-left"><label>确认密码</label></div>
			<div class="row-right"><input class="easyui-passwordbox" id="password2" iconWidth="28" style="height:34px;padding:10px"></div>
		</div>
		<div class="bottom-div">
			<button class="button-blue" id="save">提交</button>
		</div>
	</div>
<script type="text/javascript">
		
		var saveUser = function(name){
			$.ajax({
				url:"/user/save",
				async:false,
				type:"POST",
				contentType : 'application/json',
				data:JSON.stringify({"id":$('#id').val(),"account":$('#account').val(),"password":$("#password").val(),"name":name,"gender":$('.gender:checked').val(),'mobile':$('#mobile').val(),'collegeId':$('#college').val(),'departmentId':$('#department').val()}),
				success:function(data){
					msg = eval('(' + data + ')');
					$.messager.alert('提示',msg.msg,'info',function(){
						if('0'==msg.flag){
							window.close();
						}
					});
				}
			});
		}
		var save = function(){
			var canSave = false;
			var name = $('#name').val();
			var account = $('#account').val();
			var pwd = $("#password").val();
			var pwd2 = $("#password2").val();
			if(!name||''==name||'undefined'==name){
				$.messager.alert('提示','请输入角色名称','warn');
				return ;
			}
			
			if(!account||''==account||'undefined'==account){
				$.messager.alert('提示','请输入登陆账号','warn');
				return ;
			}
			
			if(!pwd||''==pwd||'undefined'==pwd){
				$.messager.alert('提示','请输入登录密码','warn');
				return ;
			}
			if(!pwd2||''==pwd2||'undefined'==pwd2){
				$.messager.alert('提示','请确认密码','warn');
				return ;
			}
			
			if(pwd||''!=pwd||'undefined'!=pwd){
				if(pwd!=pwd2){
					$.messager.alert('提示','两次输入密码不一致,请重新输入！','warn');
					return ;
				}
			}
			
			if(account||''!=account||'undefined'!=account){
				$.ajax({
					url:"/user/checkAccountIsExists",
					async:false,
					type:"POST",
					data:{"account":account},
					success:function(data){
						msg = eval('(' + data + ')');
						if('1'==msg.flag){
							$.messager.alert('提示',msg.msg,'info');
						}else{
							saveUser(name);
						}
						
					}
				});
			}else{
				saveUser(name);
			}
		}
		
		
		$('#save').on('click',save);
</script>
</body>
</html>