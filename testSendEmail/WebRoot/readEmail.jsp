<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'readEmail.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<table style="background-color: orange">
			<tr>
				<td> 邮件主题: ${session.collectEmail.subject}</td>
			</tr>
			<tr>
				<td> 发件人: ${session.collectEmail.form}</td>
			</tr>
			<tr>
				<td> 发送时间: ${session.collectEmail.sentdate}</td>
			</tr>
			<tr> 
				<td> 邮件内容 :<br>${session.collectEmail.bodycontent}</td>
			</tr>
			<tr>
				<td> 操作 : <td><a href="emailIndex.jsp">返回首页</a></td></td>
			</tr>
	</body>
</html>
