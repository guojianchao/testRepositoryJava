<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'collectLogin.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function checkMailServer(obj){
		if(obj=="smtp.126.com"){
			document.getElementById("label").value="@126.com";
		}
		else if(obj=="smtp.163.com"){
			document.getElementById("label").value="@163.com";
		}else if(obj=="smtp.qq.com"){
			document.getElementById("label").value="@qq.com";
		}else{
			document.getElementById("label").value="@";
		}
	}
	function onclikCollect(){
		$("#form").attr("action","collectEmail.action");
	}
</script>
	</head>

	<body>
		<form action="collectEmail.action" id="form"
			style="background-color: orange;">
			<table>
				<tr>
					<td>
						请选择邮箱:
					</td>
					<td>
						<s:select name="emailInfo.serverAddress" headerKey="-1"
							headerValue="请选择" list="list" listKey="emailserverid"
							listValue="emailservername"
							onchange="checkMailServer(this.value)" />
					</td>
				</tr>
				<tr>
					<td>
						用户名：
					</td>
					<td>
						<input type="text" name="emailInfo.user">
						<s:select name="suffix" headerKey="-1" headerValue="请选择"
							id="label" list="list" listKey="emailserversuffix"
							listValue="emailserversuffix" />
					</td>
				</tr>
				<tr>
					<td>
						密码：
					</td>
					<td>
						<input type="password" name="emailInfo.pwd">
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="收取"> </td><td><a href="emailIndex.jsp">返回首页</a></td>
				</tr>
			</table>
		</form>
	</body>
</html>
