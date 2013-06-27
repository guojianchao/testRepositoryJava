<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="isearch.env.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<%
		String keyword = new String (request.getParameter("keyword").getBytes("iso-8859-1"),"utf-8");
		String pkey = request.getParameter("pkey");
		Map<String,String> map = Toolkit.getDataProvider().getInfo(pkey);
		String content = map.get("content");
		//content =content.replaceAll("<[^<>]+>","");
	
	%>
	<head>
		<title>搜索-<%=map.get("title") %></title>
		<link rel="stylesheet" type="text/css" href="style.css" />
	</head>
	<script>
		function lightKeyword(){
	    	var keywords = '<%=keyword%>'.split(" ");
    		//var ohtml = document.body.innerHTML;
    		//var oset = document.all;
    		var rng = document.body.createTextRange();
    		for(var i=0;i<keywords.length;i++){
	    		//eval('ohtml = ohtml.replace(/'+keywords[i]+'/g,\'<span class="keywordstyle">'+keywords[i]+'</span>\')');
	    		while(rng.findText(keywords[i])){
	    			rng.pasteHTML('<span class="keywordstyle">' + rng.text + '</span>');
	    			
	    		}
	    	}
	    	//document.body.innerHTML=ohtml;
	    }
	</script>
	<body onload="lightKeyword()" >
		<%=content %>
  	</body>
  	
  	
</html>
