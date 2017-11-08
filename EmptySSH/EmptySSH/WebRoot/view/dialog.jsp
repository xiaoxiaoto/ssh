<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	
	<link rel="stylesheet" type="text/css" href="EasyUI/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="EasyUI/themes/icon.css">
	<script type="text/javascript" src="EasyUI/jquery.min.js"></script>
	<script type="text/javascript" src="EasyUI/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="EasyUI/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/dialog.js"></script>

  </head>
  
  <body>
<div id="box" >123</div>
<!-- <div id="box" class="easyui-dialog" style="width:500;height:500" data-options="iconCls:'icon-save',collapsible:true,resizable:true,closed:false,modal:true,toolbar:'#toolbar',buttons:'#buttons'" ></div>
<div id="toolbar" >
<a class="easyui-linkbutton" data-options="iconCls:'icon-save' ,plain:true">保存</a>
<a class="easyui-linkbutton" data-options="iconCls:'icon-edit' ,plain:true">编辑</a>
</div>
<div id="buttons">
<a class="easyui-linkbutton" data-options="plain:true" >保存</a>
<a class="easyui-linkbutton" data-options="plain:true"  >删除</a>
</div> -->
  </body>
</html>
