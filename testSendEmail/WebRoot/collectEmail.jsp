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

		<title>My JSP 'collectEmail.jsp' starting page</title>

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
				<td>
					邮件主题
				</td>
				<td>
					发件人
				</td>
				<td>
					状态
				</td>
				<td>
					操作
				</td>
			</tr>

			<c:forEach items="${session.list}" var="s">
				<tr>
					<td>${s.subject}</td>
					<td>${s.form}</td>
					<td>
						${s.hasRead}
					</td>
					<td><a href="readEmail.action?messageId=${s.messageId}">查看</a></td>
				</tr>
			</c:forEach>

			<tr><td colspan="4"><a href="emailIndex.jsp">返回首页</a></td></td>
		</table>
	</body>
</html>
