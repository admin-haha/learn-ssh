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
<script type="text/javascript" src="/js/jquery.form.js" ></script>
</head>
<body class="easyui-layout">
	<div class="main-add">
		<div class="row-div bg-red">
			<h3>人员导入</h3>
		</div>
		<div class="row-div">
			<button class="easyui-linkbutton" style="width: 130px;" type="button" id="download" data-options="iconCls:'icon-save'">&nbsp;&nbsp;下载导入模板&nbsp;&nbsp;</button>
		</div>
		<div class="row-div">
				<form id="uploadFileForm" name="uploadFileForm" method="post" enctype="multipart/form-data">
						<input id="uploadFile" type="file"  name="uploadFile" />
				</form>
		</div>
		<div class="bottom-div">
			<button class="button-blue" id="save">提交</button>
		</div>
	</div>
<script type="text/javascript">
		
		
		var download = function(){
			window.location.href = '/user/downloadUserTemplate';
		}
		
		$('#download').on('click',download);
		
		var save = function(){
			$('#uploadFileForm').ajaxSubmit({
				url: '/user/import',
				cache: false,
				type: 'post',
				success: function(data){
					msg = eval('(' + data + ')');
					$.messager.alert('提示',msg.msg,'info',function(){
						if('0'==msg.flag){
							window.close();
							window.opener.loadData();
						}else{
							$('#uploadFileForm')[0].reset();
							return false;
						}
						
					});
				}
			});
		}
		$('#save').on('click',save);
</script>
</body>
</html>