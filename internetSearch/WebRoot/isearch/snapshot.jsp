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
		<title>网页快照-<%=map.get("content") %></title>
		<link rel="stylesheet" type="text/css" href="style.css" />
	</head>
	<script>
		function lightKeyword(){
	    	var keywords = '<%=keyword%>'.replace(/^ */,"").replace(/ *$/,"").replace(/ +/g," ").split(" ");
    		for(var i=0;i<keywords.length;i++){
	    		var rng = document.body.createTextRange();
	    		while(rng.findText(keywords[i])){
	    			rng.pasteHTML('<span class="keywordstyle">' + rng.text + '</span>');
	    			
	    		}
	    	}
	    	//document.body.innerHTML=ohtml;
	    }
	</script>
	
		
	<body onload="lightKeyword()" >
		<div style="border:0px solid #000000;background:white;width:100%;text-align:center">
			<div style="border:2px solid #000000;background:#DEDFDE;width:1000px" class="cachestyle">
				这是对 <a href="<%=map.get("url") %>"><%=map.get("url") %></a> 的页面缓存,缓存时间:<%=map.get("times") %><br>此网页可能已经被更改,点击 <a href="<%=map.get("url") %>">这里</a> 里查看最新内容
			</div>
		</div>
		<%=content %>
  	</body>
  	
  	
</html>
