<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%><%@page
	import="com.email.model.Emailserver"%>
<%@ taglib uri="http://fckeditor.net/tags-fckeditor" prefix="FCK" %> 
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

		<title>My JSP 'sendEmail.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

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
</script>
	<body onload="checkMailServer('')">
		<form action="sendMail.action"
			style="background-color: orange;">
			<table>
				<tr>
					<td>
						请选择邮箱:
					</td>
					<td>
						<s:select name="emailInfo.serverAddress"  headerKey="-1" headerValue="请选择"
							list="list" listKey="emailserverid" listValue="emailservername" onchange="checkMailServer(this.value)"/>
					</td>
				</tr>
				<tr>
					<td>
						用户名：
					</td>
					<td>
						<input type="text" name="emailInfo.user">
						<s:select name="suffix"  headerKey="-1" headerValue="请选择" id="label"
							list="list" listKey="emailserversuffix" listValue="emailserversuffix" />
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
					<td>
						收件人：
					</td>
					<td>
						<input type="text" name="emailInfo.emailReceiver">
					</td>
				</tr>
				<tr>
					<td>
						标题：
					</td>
					<td>
						<input type="text" name="emailInfo.subject">
					</td>
				</tr>
				<tr>
					<td>
						内容：
					</td>
					<td>
					
					<FCK:editor id="emailInfo.htmlContents" width="800px;" >
						
					</FCK:editor>
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="发送"><input type="button" onclick="window.location='collectEmail.action'" value="接收">
					</td>
					<td>
						<a href="addEmailserver.jsp">添加新的Email服务器地址</a>
					</td>
				</tr>
			</table>

		</form>
	</body>
	
</html>

