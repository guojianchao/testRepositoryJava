<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '_content.jsp' starting page</title>
    
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
    <p style="font-size:14px">这里是AJAX加载内容.</p>
	<ul>
		<li>easyui是一套基于JQuery的用户界面插件集合.</li>
		<li>easyui为构建现代流行的交互式体验JavaScript应用程序提供了基本功能.</li>
		<li>使用easyui你不需要写很多javascript代码，你通常只需要写一些html标签来定义用户界面.</li>
		<li>完美支持HTML5.</li>
		<li>easyui能够有效地节省你的开发时间.</li>
		<li>easyui很简单但是很强大.</li>
	</ul>
	
	<input type="text" id="google_q" ><input type="button" value="百度搜索" onclick="google_go()">
  </body>
  <script type="text/javascript">
  	function google_go(){
  		var question=document.getElementById("google_q").value;
  		location.href="http://www.baidu.com/s?wd="+question+"&rsv_spt=1&issp=1&rsv_bp=0&ie=utf-8&tn=baiduhome_pg&rsv_sug3=2&rsv_sug=0&rsv_sug4=628&rsv_sug1=1&inputT=1525"
        return false;                                              
  	}	
  
  </script>
</html>
