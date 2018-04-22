<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
	<head>
		<title></title>
		<meta charset="utf-8">
		<link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/bootstrap/easyui.css" />
<link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/icon.css" />
<link type="text/css" rel="stylesheet" href="/css/common.css" />
<script type="text/javascript" src="/js/jquery-3.2.1.min.js" ></script>
<script type="text/javascript" src="/jquery-easyui/jquery.easyui.min.js" ></script>
<script type="text/javascript" src="/jquery-easyui/locale/easyui-lang-zh_CN.js" ></script>
		<style>
			header{
				width:100%;
				height:80px;
				border-bottom:1px solid #E0E0E0;
				padding-right:30px;
			}
			#header div.img{
				float:left;
			}
			header div{
			}
			#text ul li{
				list-style:none;
				color:#999;
				float:left;
			}
			body a{
				color:#0062C5;
				text-decoration:none;
			}
			body,input{
				color:#999;
			}
			#header div a.help{
				color:#000;
				display:inline-block;
				height:25px;
				border:1px solid transparent;
				padding-left:19px;
				background:url(D:/images/help.png) no-repeat;
			}
			#header div b{
				background:url(D:/images/index_sprite.png) no-repeat -222px 0;
				width:14px;
				height:14px;
				float:right;
			}
			#login-div{
				width:100%;
				height:300px;
				margin-top:30px;
				border:1px solid transparent;
			}
			#login-div img{
				width:50%;
				height:300px;
				border:1px solid transparent;
				float:left;
				margin: 0 auto;
			}
			#login-div ul{
				width:40%;
				list-style:none;
			}
			#login-div a.zh{
			}
			#login-div input{
				height:25px;
				margin-top:10px;
				border:1px solid #ccc;
			}
			#txtname{
				padding-left:24px;
				background:url(C:/user.png) no-repeat;
			}
			#txtpwd{
				padding-left:24px;
				background:url(C:/pwd.png) no-repeat;
			}
			#login-div li{
				width:250px;
			}
			#login-div a.pwd{
			}
			#login-div li button{
				border:1px solid #e4393c;
				width:250px;
				background:#e4393c;
				color:#fff;
				border-radius:3px;
				height:25px;
				margin:5px 5px;
			}
			#login-div li span{
				color:#666;
			}
			#login-div li a.wz{
				color:#999;
			}
			#login-div li a.wz img{
				width:30px;
				height:25px;
				margin:2px;
			}
			footer p{
				color:#000;
				text-align:center;
				font-size:5px;
			}
		</style>
	</head>
	<body>
		<header id="header">
			<div id="text"  style="text-align: center;">
				<h3>中原工学院信息商务学院-在线选题系统</h3>
			</div>
		</header>
		<div id="login-div">
				<ul>
					<li>
						<b>用户登录</b>
					</li>
					<li>
						<label>账号：</label><input class="easyui-textbox" id="account" data-options="iconCls:'icon-man'" >
					</li>
					<li>
						<label>密码：</label><input class="easyui-passwordbox" id="password" iconWidth="28" style="height:34px;padding:10px">
					</li>
					<li>
						<button id="login">登录</button>
					</li>
				</ul>
		</div>
		<footer>
					<p>沪|cp备13044278 | 合字B1.B2-20130004 | 营业执照</p>
					<p>Copyright&copy;中原工学院信息商务学院 2007-2018，All Right Reserved</p>
		</footer>
	</body>
	<script type="text/javascript">
		var login = function (){
			var account = $('#account').val();
			var password = $('#password').val();
			
			if(!account||''==account||'undefined'==account){
				$.messager.alert('提示','请输入账号','warn');
				return ;
			}
			if(!password||''==password||'undefined'==password){
				$.messager.alert('提示','请输入密码','warn');
				return ;
			}
			
			$.ajax({
				url:"/login",
				async:false,
				type:"POST",
				contentType : 'application/json',
				data:JSON.stringify({"account":account,"password":password}),
				success:function(data){
					/* msg = eval('(' + data + ')');
					$.messager.alert('提示',msg.msg,'info',function(){
						if('0'==msg.flag){
							window.close();
							window.opener.loadData();
						} 
					});*/
				}
			});
		}
		
		$('#login').on('click',login);
	</script>
</html>