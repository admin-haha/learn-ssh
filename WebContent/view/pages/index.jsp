<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>在线选题系统</title>
        <link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/bootstrap/easyui.css" />
		<link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/icon.css" />
		<link type="text/css" rel="stylesheet" href="/css/common.css" />
		<link rel="stylesheet" href="/css/indexcross.css" />
		<script type="text/javascript" src="/js/jquery-3.2.1.min.js" ></script>
		<script type="text/javascript" src="/jquery-easyui/jquery.easyui.min.js" ></script>
		<script type="text/javascript" src="/jquery-easyui/locale/easyui-lang-zh_CN.js" ></script>
		<script type="text/javascript" src="/js/function_tree.js"></script>
		<script type="text/javascript" src="/js/jquery.js"></script>
        <script>
	       function exit(){
	    	   $.messager.confirm('提示','将要退出,确定要操作吗？',function(r){  
					if (r){
						  window.location.href='/logout';
					}});
	      }
       </script>
       <script type="text/javascript">
	    jQuery.noConflict();
	   	jQuery(document).ready(function($){
	   		$(".ftoollist li").mouseover(function(){
	   			$(this).siblings().removeClass("on");
	   			$(this).addClass("on");
	   		});
	   	});
	   </script>
        
        <style>
            a:link {
                color: #583403;
                text-decoration: none;
                font-family:'Microsoft YaHei',微软雅黑,'Times New Roman';
                font-size:15px;
            }
            
            a {
                color: #583403;
                text-decoration: none;
                font-family:'Microsoft YaHei',微软雅黑,'Times New Roman';
                font-size:15px;
            }
            font {
            	font-family:'Microsoft YaHei',微软雅黑,'Times New Roman';
            }
        </style>
        
    </head>
    <body class="easyui-layout">
        
        <div region="north" style="font-size: 15px;font-family:'Microsoft YaHei',微软雅黑,'Times New Roman'; background:fafafa;color:2d5593;height:60px;background-image: url('/img/fbi-background.png'); background-repeat: 
               repeat-x; background-position: left top">
			<table border="0" width="100%" cellspacing="0" cellpadding="0" height="100%" style="font-family:'Microsoft YaHei',微软雅黑,'Times New Roman';font-size: 15px">
				<tr>
					<td align=right width="138" >在线选题系统</td>
					<td align=left ><font color="#FFFFFF"><br/>&nbsp;&nbsp;版本V1.0</font></td>
					<td align=right width="300" ><img border="0" src="/img/top_user.png" width="20" height="20" align="absmiddle"/><span id="userName">
					<font color="#FFFFFF">${currentUser}(${account})</font>
					</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a style="cursor:pointer; " onclick="exit();"  title="退出"><img src="/img/out.gif" align="bottom" border="0" alt="退出"/>
					</a>&nbsp;&nbsp;
					</td>
				</tr>
			</table>
        </div>
        <div region="west" title="导航菜单" split="true" style="width:200px;font-family:'Microsoft YaHei',微软雅黑,'Times New Roman';font-size: 15px">
            <div class="easyui-accordion"  fit="true" border="false" animate="false" id="main"></div>
        </div>
        <div region="center" style="font-family:'Microsoft YaHei',微软雅黑,'Times New Roman';font-size: 15px">
            <div id="main-center" class="easyui-tabs" fit="true" border="false" >
            	
           </div>
       </div>
        <div id="mm" class="easyui-menu" style="width:180px;font-family:'Microsoft YaHei',微软雅黑,'Times New Roman';font-size: 15px">
            <div id="mm-tabclose">关闭</div>
            <div id="mm-tabcloseall">全部关闭</div>
            <div id="mm-tabcloseother">除此之外全部关闭</div>
            <div class="menu-sep"></div>
            <div id="mm-tabcloseright">当前页右侧全部关闭</div>
            <div id="mm-tabcloseleft">当前页左侧全部关闭</div>
            <div class="menu-sep"></div>
            <div id="mm-exit">退出</div>
        </div>
    </body>
    <script type="text/javascript">
    </script>
</html>
