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
        <script>
	       function exit(){
	    	   $.messager.confirm('提示','将要退出,确定要操作吗？',function(r){  
					if (r){
						  window.location.href='/logout.fbi';
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
        <input id="clientRootId" type="hidden" value="${paramValueMap['client_root_id'] }"/>
        <input id="diagramNum" type="hidden" value="${paramValueMap['diagramNum'] }"/>
        
        <div region="north" style="font-size: 15px;font-family:'Microsoft YaHei',微软雅黑,'Times New Roman'; background:fafafa;color:2d5593;height:60px;background-image: url('/images/fbi-background.png'); background-repeat: 
               repeat-x; background-position: left top">
			<table border="0" width="100%" cellspacing="0" cellpadding="0" height="100%" style="font-family:'Microsoft YaHei',微软雅黑,'Times New Roman';font-size: 15px">
				<tr>
					<td align=right width="138" ><img border="0" src="/images/fbi-banner.png"   /></td>
					<td align=left ><font color="#FFFFFF"><br/>&nbsp;&nbsp;版本 ${versionNum}</font></td>
					<td align=right width="300" ><img border="0" src="/images/top_user.png" width="20" height="20" align="absmiddle"/><span id="userName">
					<font color="#FFFFFF">${currentUser}(${account})</font>
					<c:if test="${!crossTenant eq 'true'}"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a style="cursor:pointer; " onclick="exit();"  title="退出"><img src="/images/out.gif" align="bottom" border="0" alt="退出"/></c:if>
					</a>&nbsp;&nbsp;
					<br/>
						<font  title="        售后服务：刘先生
							        手机：15321585802  Q Q：2239421825
							        邮箱：yunw@fbi-china.com
							        时间：周一 ~ 周六  9:00~18:00" color="#FFFFFF">&nbsp;&nbsp;
							<a href="/pf1d5/common/helpNoteBook.fbi?type=B" style="color:white;text-decoration:none;" target="_blank" >帮助</a>&nbsp;&nbsp; 
							<a href="javascript:void(0);" style="color:white;text-decoration:none;" >在线客服</a>
						</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
				</tr>
			</table>
        </div>
        <div region="west" title="导航菜单" split="true" style="width:200px;font-family:'Microsoft YaHei',微软雅黑,'Times New Roman';font-size: 15px">
            <div class="easyui-accordion"  fit="true" border="false" animate="false" id="main"></div>
        </div>
        <div region="center" style="font-family:'Microsoft YaHei',微软雅黑,'Times New Roman';font-size: 15px">
            <div id="main-center" class="easyui-tabs" fit="true" border="false" >
            	<c:choose>
            		<%--非企业租户 --%>
            		<c:when test="${not ('E' eq TENANT_TYPE)}">
		            	<div title="实时监控" >
		            		<iframe id="iframepage" frameborder="0" scrolling="auto" marginheight="0" marginwidth="0" width="1880" height="940"></iframe>
		            	</div>
            		</c:when>
            		<%--企业租户 --%>
            		<c:otherwise>
            			<%--角色有 实时监控权限 --%>
            			<c:if test ="${paramValueMap['sy_map_self'] eq 'true'}">
            				<div title="实时监控" >
		            			<iframe id="iframepage" frameborder="0" scrolling="auto" marginheight="0" marginwidth="0" width="1880" height="940"></iframe>
		            		</div>
            			</c:if>
            			<%--角色有 实时监控(全量)权限 --%>
            			<c:if test ="${paramValueMap['sy_map_total'] eq 'true'}">
	            			<div title="实时监控(全量)" >
			            		<iframe id="iframepage2"  frameborder="0" scrolling="auto" marginheight="0" marginwidth="0" width="1880" height="940"></iframe>
			            	</div>
            			</c:if>
            		</c:otherwise>
            	</c:choose>
            	
            	
                <div title="统计图表" style="padding:10px;">
                    <div style="height: 79%;overflow-y:auto;">
                    	<div id = "mainRep0Top">
                        <div id = "mainRep0Title" style="text-align: center;font-weight: bold;font-size: 18px;"></div>
                        <div style="width:100%;height:570px;overflow-x:auto;">
                    	<div id="mainRep0" style="width:100%;height:540px;"></div>
                    	</div></div>
                    	
                        <div id = "mainRep1Top">
                        <div id = "mainRep1Title" style="text-align: center;font-weight: bold;font-size: 18px;"></div>
                        <div style="width:100%;height:570px;overflow-x:auto;">
                    	<div id="mainRep1" style="width:100%;height:540px;"></div>
                    	</div></div>
                    	
                    	<div id = "mainRep2Top">
                    	<div id = "mainRep2Title" style="text-align: center;font-weight: bold;font-size: 18px;"></div>
                    	<div style="width:100%;height:570px;overflow-x:auto;">
                    	<div id="mainRep2" style="width:100%;height:570px;"></div>
                    	</div></div>
                    	
                    	<div id="mainRep3" style="width:100%;height:95%;display:none">
                    	    <div id = "mainRep31Title" style="text-align: center;font-weight: bold;font-size: 18px;"></div>
                    		<div id="mainRep31" style="width:100%;height:600px;" >
                    		</div>
                    		
                    		<div id = "mainRep32Title" style="text-align: center;font-weight: bold;font-size: 18px;margin-top: 90px;"></div>	
                    		<div id="mainRep32" style="width:100%;height:600px" >
                    		</div>
                    		
                    		<div id = "mainRep33Title" style="text-align: center;font-weight: bold;font-size: 18px;margin-top: 90px;"></div>	
                    		<div id="mainRep33" style="width:100%;height:600px" >
                    		</div>
                    		
                    		<div id = "mainRep34Title" style="text-align: center;font-weight: bold;font-size: 18px;margin-top: 90px;"></div>
                    		<div style="width:100%;height:450px;overflow-x:auto;">
                    			<div id="mainRep34" style="width:100%;height:400px" >
                    			</div>
                    		</div>
                    		
                    		<div id = "mainRep35Title" style="text-align: center;font-weight: bold;font-size: 18px;margin-top: 90px;"></div>
                    		<div style="width:100%;height:450px;overflow-x:auto;">	
                    			<div id="mainRep35" style="width:100%;height:400px" >
                    			</div>
                    		</div>
                    		
                    		<div id = "mainRep36Title" style="text-align: center;font-weight: bold;font-size: 18px;margin-top: 90px;"></div>
                    		<div style="width:100%;height:450px;overflow-x:auto;">		
                    			<div id="mainRep36" style="width:100%;height:400px" >
                    		 	</div>
                    		</div>	<!--  
                    		<div id="mainRep37" style="width:100%;height:400px" >
                    		  
                    		</div>	
                    		<div id="mainRep38" style="width:100%;height:400px" >
                    		  
                    		</div>	--> 
                    			
                    	</div>
                    	<div id="mainRep4" style="width:100%;height:95%;display:none">
                    	    <div id = "mainRep41Title" style="text-align: center;font-weight: bold;font-size: 18px;"></div>
                    		<div id="mainRep41" style="width:100%;height:600px;" >
                    		</div>
                    		
                    		<div id = "mainRep42Title" style="text-align: center;font-weight: bold;font-size: 18px;margin-top: 90px;"></div>
                    		<div id="mainRep42" style="width:100%;height:600px" >
                    		</div>	
                    		
                    		<div id = "mainRep43Title" style="text-align: center;font-weight: bold;font-size: 18px;margin-top: 90px;"></div>
                    		<div id="mainRep43" style="width:100%;height:600px" >
                    		</div>
                    		
                    		<div id = "mainRep44Title" style="text-align: center;font-weight: bold;font-size: 18px;margin-top: 90px;"></div>
                    		<div style="width:100%;height:450px;overflow-x:auto;">	
                    			<div id="mainRep44" style="width:100%;height:400px" >
                    			</div>
                    		</div>
                    		
                    		<div id = "mainRep45Title" style="text-align: center;font-weight: bold;font-size: 18px;margin-top: 90px;"></div>
                    		<div style="width:100%;height:450px;overflow-x:auto;">				
                    			<div id="mainRep45" style="width:100%;height:400px" >
                    			</div>
                    		</div>
                    		
                    		<div id = "mainRep46Title" style="text-align: center;font-weight: bold;font-size: 18px;margin-top: 90px;"></div>
                    		<div style="width:100%;height:450px;overflow-x:auto;">		
                    			<div id="mainRep46" style="width:100%;height:400px" >
                    			</div>
                    		</div>
                    		
                    		<div id = "mainRep47Title" style="text-align: center;font-weight: bold;font-size: 18px;margin-top: 90px;"></div>
                    		<div style="width:100%;height:450px;overflow-x:auto;">		  
                    			<div id="mainRep47" style="width:100%;height:400px" >
                    			</div>
                    		</div>
                    		
                    		<div id = "mainRep48Title" style="text-align: center;font-weight: bold;font-size: 18px;margin-top: 90px;"></div>
                    		<div style="width:100%;height:450px;overflow-x:auto;">	
                    			<div id="mainRep48" style="width:100%;height:400px" >
                    			</div>
                    		</div>	
                    	</div>
                    	<div id="mainRep5" style="width:100%;height:95%;display:none">
                    	
                    	    <div id = "mainRep51Title" style="text-align: center;font-weight: bold;font-size: 18px;"></div>
                    		<div id="mainRep51" style="width:100%;height:600px;" >
                    		</div>
                    		
                    		<div id = "mainRep52Title" style="text-align: center;font-weight: bold;font-size: 18px;margin-top: 90px;"></div>
                    		<div id="mainRep52" style="width:100%;height:600px" >
                    		</div>
                    		
                    		<div id = "mainRep53Title" style="text-align: center;font-weight: bold;font-size: 18px;margin-top: 90px;"></div>	
                    		<div id="mainRep53" style="width:100%;height:600px" >
                    		</div>	
                    		
                    		<div id = "mainRep54Title" style="text-align: center;font-weight: bold;font-size: 18px;margin-top: 90px;"></div>
                    		<div id="mainRep54" style="width:100%;height:600px" >
                    		</div>	
                    		
                    		<div id = "mainRep55Title" style="text-align: center;font-weight: bold;font-size: 18px;margin-top: 90px;"></div>
                    		<div id="mainRep55" style="width:100%;height:600px" >
                    		</div>
                    		
                    		<div id = "mainRep56Title" style="text-align: center;font-weight: bold;font-size: 18px;margin-top: 90px;"></div>	
                    		<div id="mainRep56" style="width:100%;height:600px" >
                    		</div>	  
                    			
                    	</div>
                    	
                    	<div id="mainRep6" style="width:100%;height:95%;display:none">
                    	    <div id = "mainRep61Title" style="text-align: center;font-weight: bold;font-size: 18px;"></div>
                    		<div id="mainRep61" style="width:100%;height:500px;" >
                    		</div>
                    		
                    		<div id = "mainRep62Title" style="text-align: center;font-weight: bold;font-size: 18px;margin-top: 90px;"></div>
                    		<div id="mainRep62" style="width:100%;height:500px" >
                    		</div>
                    		
                    		<div id = "mainRep63Title" style="text-align: center;font-weight: bold;font-size: 18px;margin-top: 90px;"></div>	
                    		<div id="mainRep63" style="width:100%;height:500px" >
                    		</div>	
                    		
                    		<div id = "mainRep64Title" style="text-align: center;font-weight: bold;font-size: 18px;margin-top: 90px;"></div>
                    		<div id="mainRep64" style="width:100%;height:500px" >
                    		</div>	
                    		
                    		<div id = "mainRep65Title" style="text-align: center;font-weight: bold;font-size: 18px;margin-top: 90px;"></div>
                    		<div id="mainRep65" style="width:100%;height:500px" >
                    		</div>
                    		
                    		<div id = "mainRep66Title" style="text-align: center;font-weight: bold;font-size: 18px;margin-top: 90px;"></div>	
                    		<div id="mainRep66" style="width:100%;height:500px" >
                    		</div>	  
                    			
                    	</div>
					</div>
					<hr/>
					<div class="focustool" id="picDiv" style="display: none;">
				        <ul class="ftoollist clearfix" ><!--通过控制该ul的left值来实现列表的左右移动，增量为931px-->
				        	<c:if test="${paramValueMap['sy_gzgz'] eq 'true'}">
				            <li class="on"><a onclick="changMainRep(0);" id="changMainRep0" style="" ><img src="/images/ywysxgz.png"/><p class="imgname">业务员工作跟踪</p><p class="imgshortcat">${currentDate }</p></a></li>
				            </c:if>
				        	<c:if test="${paramValueMap['sy_sxgz'] eq 'true'}">
				            <li class="off"><a onclick="changMainRep(1);" id="changMainRep1" style="" ><img src="/images/ywysxgz.png"/><p class="imgname">业务员上线跟踪</p><p class="imgshortcat">${currentDate }</p></a></li>
				            </c:if>
				            <c:if test="${paramValueMap['sy_xsfx'] eq 'true'}">
				            <li><a onclick="changMainRep(2);" ><img src="/images/XSFX.png" /><p class="imgname">销售分析汇总</p><p class="imgshortcat">${currentBeforeMonth }</p></a></li>
				            </c:if>
				            <c:if test="${paramValueMap['sy_rgx'] eq 'true'}">
				            <li><a onclick="changMainRep(3);"><img src="/images/RGX.png"/><p class="imgname">日功效</p><p class="imgshortcat">${currentBeforeDate} </p></a></li>
				            </c:if>
				            <c:if test="${paramValueMap['sy_ygx'] eq 'true'}">
				            <li><a onclick="changMainRep(4);"><img src="/images/YGX.png"/><p class="imgname">月功效</p><p class="imgshortcat">${currentBeforeMonth }</p></a></li> 
				        	</c:if>
				        	<c:if test="${paramValueMap['sy_qyxlzb'] eq 'true'}">
				            <li><a onclick="changMainRep(5);"><img src="/images/qyxlzb.png"/><p class="imgname">区域销量占比</p><p class="imgshortcat">${currentBeforeMonth }</p></a></li> 
				        	</c:if>
				        	<c:if test="${paramValueMap['sy_cpxlzb'] eq 'true'}">
				            <li><a onclick="changMainRep(6);"><img src="/images/cpxlzb.png"/><p class="imgname">产品销量占比</p><p class="imgshortcat">${currentBeforeMonth }</p></a></li> 
				        	</c:if>
				        </ul>
					</div>
               </div>
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
