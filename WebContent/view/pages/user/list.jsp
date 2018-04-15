<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人员列表</title>
<link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/bootstrap/easyui.css" />
<link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/icon.css" />
<script type="text/javascript" src="/js/jquery-3.2.1.min.js" ></script>
<script type="text/javascript" src="/jquery-easyui/jquery.easyui.min.js" ></script>
<script type="text/javascript" src="/jquery-easyui/locale/easyui-lang-zh_CN.js" ></script>
</head>
<body class="easyui-layout">
<div style='display:none'><span style="visibility: hidden;white-space: nowrap; font-size: 24px; " id='forStrLen'></span></div>
<div region="north"  split="true" id="northdiv" style="height:160px;padding:10px;">
	<fieldset>
			<table>
				<tr>
					<td width="40%">
						<label>学院选择：</label>
	                       	<input id="college" class="easyui-combobox" data-options="
				                    url:'/college/queryAllCollege',
				                    method:'get',
				                    valueField:'id',
				                    textField:'text',
				                    multiple:true,
				                    panelHeight:'auto'
				                    ">
					</td>
					<td width="40%">
						<label>科系选择：</label>
						<select id="department" >
	                       		<option value=""></option>
	                       		<c:forEach items="${colleges }" var="college">
	                       			<option value="${college.id }">${college.name }</option>
	                       		</c:forEach>
	                       	</select>
					</td> 
				</tr>
				<tr>
					<td width="40%">
	                   <label>产品选择：</label>
	                   <input type="hidden" name="productIds" id="productIds" />
	                   <input type="text"  name="productNames"  id="productNames" disabled="disabled" size="40" />
	                   <input type="button" value="选择" onclick="selectMultiProduct();">
	                </td>
	                <td width="40%" style="display: none;" id="badProdType">
	                	不良品类型
	                	<input style="margin-left: 2px;margin-top: 8px" name="stockCheckbox2" class="badtype" type="checkbox" value="2">过期
	                	<input name="stockCheckbox1" class="badtype" type="checkbox" value="1">破损
	                	<input name="stockCheckbox3" class="badtype" type="checkbox" value="3">不良品
	                </td>
	                 <td width="40%" style="display: none;" id="renYuanCang">
	                 	<span style="margin-left: 0px" id="cangku">人员选择</span>&nbsp;&nbsp;
	                	<input type="hidden" name="storeId" id="storeId" />
	                    <input id="storeName" name="storeName" type="text" disabled="disabled" size="30" />
	                	<input type="button" value="选择" onclick="multiSelectJXSStrore();">
	                </td>
				</tr>
				<tr>
					<td width="40%">
		                <button class="easyui-linkbutton" style="margin-left: 130px;" type="button" id="query" data-options="iconCls:'icon-ok'">&nbsp;&nbsp;查询&nbsp;&nbsp;</button>
					</td>
					<td width="40%"></td>
				</tr>
			</table>
	</fieldset>
</div>
<div region="center" style="overflow:hidden;">
  <div id="tabSearchResult"  class="easyui-tabs" fit="true" border="false">
     <div title="查询结果"  id="divSearchResultDetails">
       <table id="detail" fit="true"></table>
     </div>
 </div>
</div>

<script type="text/javascript">
var loadData = function(){
	$('#detail').datagrid({
		height: $(window).height()  - 30,
		url: '/user/query' ,
		method:'GET',
		pageNumber: 1,
        pageSize:20,
		fit: true,//自动大小
		nowrap:false, //换行
        rownumbers:false,//行号
        striped: true,
        singleSelect:true,//单行选取
        pagination:true,//显示分页
	    columns:[[
	        {field:'index', title:'', width: '5%', align: 'center', halign: 'center'},
	        {field:'name', title:'人员名称', width: '12%',halign: 'center'},
	        {field:'role', title:'角色', width: '12%',halign: 'center'},
	        {field:'gender', title:'性别', width: '12%',halign: 'center'},
	        {field:'account', title:'人员账号', width: '12%',halign: 'center'},
	        {field:'mobile', title:'联系电话', width: '12%',halign: 'center'},
	        {field:'department', title:'所属科系', width: '12%',halign: 'center'},
	        {field:'college', title:'所属学院', width: '12%',halign: 'center'},
	        {field:'createTime', title:'创建时间', width: '12%',halign: 'center'},
	        {field:'updateTime', title:'更新时间', width: '12%',halign: 'center'}
	    ]],
	  
	    onLoadSuccess: function (data) {
	    	$("#noResultMsg").remove();
        	var rowArray = $('#detail').datagrid('getRows');               
              if(rowArray.length==0){
               var msg = $("<div id ='noResultMsg' style='display:none;text-align:center;padding:10px;border:1px solid #AAAAA;background-color:yellow;  margin-top:20px;'>您当前的选择，无返回信息，请重新调整条件!</div>"); 
                  msg.insertAfter($('#detail')); 
                  msg.show(200); 
              }  
       }
	});
}

$('#query').on('click',loadData);
</script>
</body>
</html>