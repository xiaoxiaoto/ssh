<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
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

<title>My JSP 'hchart.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript"
	src="./aoto/common/thirdparty/jquery/jquery-2.2.1.min.js"></script>
<script type="text/javascript"
	src="./aoto/common/thirdparty/highcharts/highcharts.js"></script>
<script type="text/javascript"
	src="./aoto/common/thirdparty/highcharts/highcharts-more.js"></script>
<script type="text/javascript"
	src="./aoto/common/thirdparty/highcharts/highcharts-3d.js"></script>
	<script type="text/javascript"
	src="js/hchart.js"></script>
</head>

<body>
	<div id="container"
		style="min-width: 400px; height: 400px; margin: 0 auto"></div>
	<div id="container1"
		style="min-width: 400px; height: 400px; margin: 0 auto"></div>
		<div id="container2"
		style="min-width: 400px; height: 400px; margin: 0 auto"></div>
</body>
</html>
