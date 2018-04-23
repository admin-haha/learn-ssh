<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分配权限</title>
<link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/bootstrap/easyui.css" />
<link type="text/css" rel="stylesheet" href="/jquery-easyui/themes/icon.css" />
<link type="text/css" rel="stylesheet" href="/css/common.css" />
<script type="text/javascript" src="/js/jquery-3.2.1.min.js" ></script>
<script type="text/javascript" src="/jquery-easyui/jquery.easyui.min.js" ></script>
<script type="text/javascript" src="/jquery-easyui/locale/easyui-lang-zh_CN.js" ></script>
</head>
<body class="easyui-layout">
	<h2>当前角色:<font style="color:red;">${role.name }</font></h2>
    <p>对角色分配权限</p>
    <div style="margin:20px 0;"></div>
    <table title="分配权限" id="detail" class="easyui-treegrid" >
    </table>
    <p></p>
    <div style="text-align: center;"><button class="button-blue" id="save" style="width:30%;">提交</button></div>
<script type="text/javascript">
		
$(function(){
	var roleId = '${role.id}';
		$('#detail').treegrid({
			height: $(window).height()  - 200,
			url: '/function/queryAllFunctionWithRole?roleId='+roleId ,
			method:'GET',
			checkbox:true,
			lines:true,
			cascadeCheck:false,
			idField:'id',
		    treeField:'name',
		    columns:[[
		        {field:'name', title:'权限名称', width: '20%'},
		        {field:'funcUrl', title:'权限详情', width: '20%'},
		        {field:'funcKey', title:'权限唯一标示', width: '20%'},
		        {field:'funcOrder', title:'顺序', width: '8%',align:'center'},
		        {field:'createTime', title:'创建时间', width: '15%',align:'center'},
		        {field:'updateTime', title:'更新时间', width: '15%',align:'center'}
		    ]]
		});
});
		
		var saveAssign = function(params){
			console.log(params);
			$.ajax({
				url:"/function/assignFunction",
				async:false,
				type:"POST",
				contentType:'application/json',
				data:JSON.stringify(params),
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
		
		var save = function(){
			
			var nodes = $('#detail').treegrid('getCheckedNodes');
			if(!nodes||nodes.length==0){
				$.messager.confirm('确认？','你对该角色未选择任何权限，是否继续保存？',function(r){
					if(r){
						var arr = new Array();
						var record = {"roleId":'${role.id}',"funcId":''};
						arr.push(record);
						saveAssign(arr);
					}
				});
			}else{
				$.messager.confirm('确认？','是否继续保存？',function(r){
					if(r){
						var arr = new Array();
						for(var i = 0;i<nodes.length;i++){
							var record = {"roleId":'${role.id}',"funcId":nodes[i].id};
							arr.push(record);
						}
						saveAssign(arr);
					}
				});
				
			}
		}
		$('#save').on('click',save);
</script>
</body>
</html>