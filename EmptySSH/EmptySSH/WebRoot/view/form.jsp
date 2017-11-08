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
<script type="text/javascript" src="js/form.js"></script>

</head>

<body>
	<div id="box">
		<form id="form" method="post">
			<div>
				<label>姓名：</label> <input id="name" name="name" type="text" />
			</div>
			<div>
				<label>邮箱：</label> <input id="email" name="email" type="text" />
			</div>
			<div>
				<label>密码：</label> <input id="password" name="password" type="text" />
			</div>
		</form>
	</div>
</body>
</html>
