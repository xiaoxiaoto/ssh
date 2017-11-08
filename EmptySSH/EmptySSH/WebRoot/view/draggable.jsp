<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
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
<script type="text/javascript" src="js/draggable.js" charset="UTF-8"></script>

</head>

<body id="box">
	<div id="fox">
		<input id="search" />
		<div id="menu">
			<div name="all">All News</div>
			<div name="sports">Sports News</div>
		</div>
		<div id="progress"></div>
		<div id="mm" class="easyui-menu" style="width:120px;">
			<div>New</div>
			<div>
				<span>Open</span>
				<div style="width:150px;">
					<div>
						<b>Word</b>
					</div>
					<div>Excel</div>
					<div>PowerPoint</div>
				</div>
			</div>
			<div iconCls="icon-save" href="panel">Save</div>
			<div class="menu-sep"></div>
			<div onclick="obj.add()">Exit</div>
		</div>
		<div id="tabs">
			<a id="button1">Save</a> <a id="button2">Save</a> <a
				class="easyui-linkbutton" data-options="iconCls:'icon-add'">Add</a>
			<a class="easyui-linkbutton" data-options="iconCls:'icon-remove'">Remove</a>
			<a class="easyui-linkbutton" data-options="iconCls:'icon-save'">Save</a>
			<a class="easyui-linkbutton"
				data-options="iconCls:'icon-cut',disabled:true">Cut</a> <a
				class="easyui-linkbutton" data-options="iconCls:'icon-print'">Print</a>
			<a class="easyui-linkbutton" data-options="iconCls:'icon-help'">Help</a>
			<a class="easyui-linkbutton" data-options="iconCls:'icon-undo'">Undo</a>
			<a class="easyui-linkbutton" data-options="iconCls:'icon-redo'">Redo</a>
			<a class="easyui-linkbutton" data-options="iconCls:'icon-back'">Back</a>
		</div>
	</div>
</body>
</html>
