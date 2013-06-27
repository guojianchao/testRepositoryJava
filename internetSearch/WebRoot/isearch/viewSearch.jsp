<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="isearch.env.Environment"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>查看状态</title>
  </head>
  
  <body  style="text-align:center;">
  	<div style="height:50px"></div>
    <table>
    	<%int[] arr = Environment.getInstance().getStatistics(); %>
    	<tr><td><h1>当前线程数: <%=arr[0] %>    <%=arr[0]==0?"停止状态":"运行状态" %></h1></td><td></td><td></td></tr>
    	<tr><td><h1>已搜索的URL数量: <%=arr[1] %></h1></td><td></td><td style="color:red"></td></tr>
    	<tr><td><h1>未搜索的URL数量: <%=arr[2] %></h1></td><td></td><td style="color:red"></td></tr>
    	<tr><td><h1>已搜索的索引数量: <%=arr[3] %></h1></td><td></td><td></td></tr>
    	<tr>
    		<td colspan=3 style="color:red;font-size:9pt">
    			已搜索的URL数量-包括被载入内存缓存的URL<br>
    			未搜索的URL数量-不包括搜索到缓存在内存中的URL<br>
    			以上数据在搜索处于停止状态时显示的为准备数据<br>
    		</td>
    	</tr>
    </table>
  </body>
</html>
