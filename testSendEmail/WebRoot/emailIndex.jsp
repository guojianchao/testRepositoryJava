<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'emailIndex.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="text-align: center;">
		<span style="color:red"><h3>请选择</h3></span>
		<span style="color:red"><h4><a href="initServer.action?flag=1">收取邮件</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="initServer.action?flag=2">发送邮件</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="addEmailserver.jsp">添加新的Email服务器地址</a>
		</h4></span>
	</body>
</html>
