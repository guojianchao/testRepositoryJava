<%@ page language="java"  pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>搜索管理</title>
  </head>
  
  <body>
    <table style="width:100%;height:100%">
    	<tr>
    		<td style="width:150px;">
    			<table style="height:100%">
    				<tr style="height:40px"><td></td></tr>
    				<tr><td>相关操作</td></tr>
    				<tr><td><a href="javascript:void(document.getElementById('info').src='startSearch.jsp?'+Math.random())">启动搜索</a></td></tr>
    				<tr><td><a href="javascript:void(document.getElementById('info').src='stopSearch.jsp?'+Math.random())">停止搜索</a></td></tr>
    				<tr><td><a href="javascript:void(document.getElementById('info').src='viewSearch.jsp?'+Math.random())">查看搜索状态</a></td></tr>
    				<tr><td><a href="javascript:void(document.getElementById('info').src='search.jsp?'+Math.random())">搜索</a></td></tr>
    				<tr style="height:100%"><td></td></tr>
    			</table>
    		</td>
    		<td>
    			<iframe id="info" name="info" frameBorder=0 style="width:100%;height:100%"></iframe>
    		</td>
    	</tr>
    </table>
  </body>
</html>
