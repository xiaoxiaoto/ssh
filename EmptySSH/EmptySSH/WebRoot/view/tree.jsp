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
<script type="text/javascript" src="js/tree.js" charset="UTF-8"></script>

</head>

<body>
	<!-- 静态菜单栏class加载方式 -->
	<!-- <ul id="box" class="easyui-tree">
		<li><span>我的文件夹</span>
			<ul>
				<li><span>文件</span>
					<ul>
					   <li><span><a>文档</a></span></li>
						<li><span><a>图片</a></span></li>
					</ul>
				</li>
				<li><span>软件</span></li>
				<li><span>娱乐</span></li>
			</ul></li>
		<li><span>计算机</span></li>
		<li><span>桌面</span></li>
	</ul> -->
	<ul id="box"></ul>
</body>
</html>
