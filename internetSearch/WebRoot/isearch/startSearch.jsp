<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="isearch.env.Environment"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>启动搜索</title>
  </head>
  
  <body style="text-align:center">
  	<div style="height:50px"></div>
    <%	try{
    		Environment.getInstance().startSearch(); 
    		out.println("<h1>启动成功</h1>");
	    }catch(Exception e){
	    	out.println("<h1>启动失败</h1>");
	    }
    %>
  </body>
</html>
