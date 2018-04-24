<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>中原工学院信息商务学院在线选题系统</title>
		<link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/bootstrap/easyui.css" />
		<link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/icon.css" />
		<script type="text/javascript" src="/js/jquery-3.2.1.min.js" ></script>
		<script type="text/javascript" src="/js/utils.js" ></script>
		<script type="text/javascript" src="/jquery-easyui/jquery.easyui.min.js" ></script>
		<script type="text/javascript" src="/jquery-easyui/locale/easyui-lang-zh_CN.js" ></script>
        <script>
            if (self != top) {
                top.location = "/login.jsp";
            }
    
            <%
    
            java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("HH");
    
            java.util.Date currentTime = new java.util.Date();//得到当前系统时间
    
            String str_date1 = formatter.format(currentTime); //将日期时间格式化
    
            %>
    
            var h_num=0<%=str_date1%>;
        </script>
        <script type="text/javascript">
			
        </script>
        <link href="/css/login.css" rel="stylesheet" type="text/css" />
        <style type="text/css">
			.STYLE1 {
				font-size: 18px;
				font-weight: bold;
				font-family: "微软雅黑";
			}
			p {
				font-size: 13px;
			}
			.STYLE2 {
				font-family: "微软雅黑";
				font-size: 16px;
				font-weight: bold;
			}
			#pin-div{
				position: fixed;
				right: 50px;
				top: 400px;
				height: 200px;
				width: 230px;
				background-color: #ffc;
				box-shadow: 5px 5px 7px rgba(33,33,33,.7);
				transform: rotate(-6deg);
    			font-size: 18px;
    			text-decoration: none;
    			padding: 5px 10px;
    			font-family: 'Microsoft yahei', 'Neuton', serif;
    			box-sizing: border-box;
    			overflow-y: auto;;
			}
</style>
    </head>
    <body style="overflow: hidden;">
    <div id="pin-div">
    	<h5 style="margin-bottom: 0px;margin-top: 3px;">通知:</h5>
   		<ol>
   			<c:forEach items="${notices }" var="item">
   				<li>${item }</li>
   			</c:forEach>
   		</ol>
    </div>
        <table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td width="1000" valign="top" colspan="2">
                    <img src="img/login-top1.jpg" width="1000" height="450" />
                </td>
            </tr>
            <tr>
                <td width="1000" valign="top">
                <img src="img/login_down_left_011.jpg" width="587" height="133" />
                </td>
                <td width="500" valign="top">
                    <div class="bgr">
                        <font color="yellow"></font>
                        <form action="/login" method="post" name="form1" id="form1" onsubmit="return login();">
                            <table width="366" height="197" border="0" cellpadding="0" cellspacing="0">
								  <tr>
								    <td height="6" colspan="6"></td>
								   </tr>
								  <tr>
								    <td height="30"><span class="STYLE2">帐</span></td>
								    <td>&nbsp;</td>
								    <td><span class="STYLE2">号</span></td>
								    <td></td>
								    <td colspan="1"><input class="easyui-textbox"  size="20" type="text" id="account" name="account" maxlength="20" style="width:150px" data-options="iconCls:'icon-man'"/></td>
								    <td></td>
								  </tr>
								  <tr>
								    <td height="30"><span class="STYLE2">密</span></td>
								    <td>&nbsp;</td>
								    <td><span class="STYLE2">码</span></td>
								    <td></td>
								    <td colspan="1"><input class="easyui-passwordbox"  size="22" id="password" type="password" name="password" maxlength="20" style="width:150px" /></td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr>
								    <td height="30" colspan="4">&nbsp;</td>
								    <td><button type="submit" data-options="iconCls:'icon-ok'" style="font-weight: bold;width: 60px;" class="easyui-linkbutton">登陆</button>&nbsp;&nbsp;<button class="easyui-linkbutton" data-options="iconCls:'icon-add'" type="button" id="register" style="font-weight: bold;width: 60px;">注册</button></td>
								    <td></td>
								  </tr>
							</table>
							</form>
						</div>
					</td>
				</tr>
			</table>
        <p>&nbsp;</p>
    </body>
    <script type="text/javascript">
    $(function(){
   	 if(!!window.ActiveXObject || "ActiveXObject" in window){ //判断否是ie浏览器
   	   $("#password").attr("size","21.5");
   	  }else{
   	   $("#password").attr("size","20");
   	   
   	   var error = '${error}';
   	   if(error!=''){
   		$.messager.alert('提示',error,'warn');
   	   }
   	  }
   	});
	(function(){
		
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
		}
		
		$('#register').on('click',function(){
			myOpen('/user/register',500,600);
		});
		
	})()
		
	</script>
</html>
