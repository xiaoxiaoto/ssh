<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
	href="EasyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="EasyUI/themes/icon.css">
<script type="text/javascript" src="EasyUI/jquery.min.js"></script>
<script type="text/javascript" src="EasyUI/jquery.easyui.min.js"></script>
<script type="text/javascript" src="EasyUI/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/layout.js" charset="UTF-8"></script>
</head>

<body id="box" class="easyui-layout">
	<div style="height:100"
		data-options="region:'north',title:'标题区域',border:true,split:true,iconCls:'icon-save',collapsible:true,href:'print'"></div>
	<div style="width:100"
		data-options="region:'west',title:'导航栏',border:true,split:true,iconCls:'icon-save',collapsible:true,href:'data4datagrid'""></div>
	<div style="width:80%"
		data-options="region:'center',title:'主窗体',border:true,split:true,iconCls:'icon-print',collapsible:true">
		<div class="easyui-layout" data-options="fit:true">
			<div
				data-options="region:'west',border:true,split:true,href:'print',title:'内部导航栏',iconCls:'icon-save',collpasble:true"
				style="width:180px"></div>
			<div
				data-options="region:'center',title:'内部主窗体',iconCls:'icon-print',collpasble:true">
				<div class="easyui-layout" data-options="fit:true">
					<div data-options="region:'west'"
						style="width:180px"></div>
					<div data-options="region:'center'"></div>
				</div>
			</div>
		</div>
	</div>

	<div style="height:100"
		data-options="region:'south',tools:'#tools',title:'工具栏',border:true,split:true,iconCls:'icon-save',collapsible:true,href:'print'""></div>
		<div id="tools">
		<a class="icon-ok" onclick="add()"></a>
		<a class="icon-edit" onclick="add()"></a>
		</div>
</body>
</html>
