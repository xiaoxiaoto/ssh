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
<script type="text/javascript" src="js/panel.js" charset="UTF-8"></script>

</head>

<body>
<div id="box" >123</div>
	<!--  <div id="box" class="easyui-panel" style="width:600;height:500;"
		data-options="title:'panel',iconCls:'icon-save',left:100,top:100,fit:false,border:true,noheader:false,content:'123456',tools:'#tools'">123</div>
		<div id="tools" >
		<a class="icon-edit" onclick="add()"></a>
		<a class="icon-save" onclick="add()"></a>
		</div> -->
</body>
</html>
