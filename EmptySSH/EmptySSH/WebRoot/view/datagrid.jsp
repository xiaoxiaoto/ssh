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
	href="./aoto/common/thirdparty/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="./aoto/common/thirdparty/easyui/themes/icon.css">
<script type="text/javascript" src="./aoto/common/thirdparty/easyui/jquery.min.js"></script>
<script type="text/javascript" src="./aoto/common/thirdparty/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="./aoto/common/thirdparty/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/datagrid.js" charset="UTF-8"></script>

</head>

<body>


<table id="da"></table>
<!-- <table id="data"  style="width:400;height:500" class="easyui-datagrid" data-options="url:'data4datagrid',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'id',width:100">id</th>
				<th data-options="field:'text',width:100">text</th>
				<th data-options="field:'state',width:100">state</th>
				<th data-options="field:'tid',width:100">tid</th>
			</tr>
		</thead>
	</table> -->
	
</body>
</html>
