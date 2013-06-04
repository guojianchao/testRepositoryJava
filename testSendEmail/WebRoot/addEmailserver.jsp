<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addEmailserver.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	.td{
	text-align: right;
	}
</style>
  </head>
  
  <body>
  
    <form action="addEmailserver.action" style="background-color: orange	; width: 300px;">
    	<table>
    		<tr>
    			<td class="td">Email SMTP服务器:</td> <td><input type="text" name="emailserver.emailserverid"> </td> 
    		</tr>
    		
    		<tr>
    			<td class="td">Email服务器名称:</td> <td><input type="text" name="emailserver.emailservername"></td> 
    		</tr>
    		
    		<tr>
    			<td class="td">Email后缀名称:</td> <td><input type="text" name="emailserver.emailserversuffix"></td> 
    		</tr>
    		<tr><td class="td"><input type="button" value="返回" onclick="window.location='initServer.action'" > </td><td style="text-align: right;"><input type="submit" value="提交" ></td></tr>
    	</table>
    </form>
    
  </body>
</html>
