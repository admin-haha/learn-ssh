<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色列表</title>
<link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/bootstrap/easyui.css" />
<link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/icon.css" />
<script type="text/javascript" src="/js/jquery-3.2.1.min.js" ></script>
<script type="text/javascript" src="/jquery-easyui/jquery.easyui.min.js" ></script>
<script type="text/javascript" src="/jquery-easyui/locale/easyui-lang-zh_CN.js" ></script>
</head>
<body class="easyui-layout">
<div style='display:none'><span style="visibility: hidden;white-space: nowrap; font-size: 24px; " id='forStrLen'></span></div>
<div region="north"  split="true" id="northdiv" style="height:140px;padding:10px;">

	<button id="query">查询</button>
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
		url: '/college/query' ,
		method:'GET',
		pageNumber: 1,
        pageSize:20,
		fit: true,//自动大小
		nowrap:false, //换行
        rownumbers:false,//行号
        striped: true,
        singleSelect:true,//单行选取
        pagination:true,//显示分页
       /*  toolbar: [{
            text:'导出',
            iconCls:'icon-save',
            handler:function(){
            	$.messager.confirm('确认', '确认导出？', function(r){
    				if (r){
    					window.location.href = '/terminalMgr/web/wms/store/realTimeExport.fbi?' + params;
    				}
    			});
            }
        }], */
	    columns:[[
	        {field:'index', title:' ', width: '5%', align: 'center', halign: 'center',style:'color:red'},
	        {field:'prodname', title:'产品名称', width: '12%',halign: 'center',sortable:'true',
	        	styler: function(value,row,index){
					if (index==0){
						return 'text-align:center;';
					}
				}
	        }
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