<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="isearch.env.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>搜索</title>
  	<link rel="stylesheet" type="text/css" href="style.css" />
  </head>
  
  <%
    	request.setCharacterEncoding("UTF-8");
    	//response.setCharacterEncoding("UTF-8");
    	int pageNo = 1;
    	int pageSize = 10;
    	int resultCount = 1;
    	int pageCount=1;
    	String keyword = request.getParameter("keyword")==null?"":request.getParameter("keyword");
    	pageNo = request.getParameter("pageNo")==null?1:Integer.parseInt(request.getParameter("pageNo"));
    	List<Map<String,String>> list = new ArrayList<Map<String,String>>();
    	if(!keyword.trim().equals("")){
			list = Environment.getInstance().getSearchResult(keyword,pageNo,pageSize);
    		Map<String,String> map = list.get(0);
    		resultCount = Integer.parseInt(map.get("count"));
    	}
    	pageCount=(int)Math.ceil((double)resultCount/pageSize);
    	
    %>
  <script>
  	function lightKeyword(){
    	var keywords = '<%=keyword%>'.replace(/^ */,"").replace(/ *$/,"").replace(/ +/g," ").split(" ");
    	var otitles = document.getElementsByName("title");
    	var ocontents = document.getElementsByName("content");
    	for(var k=0;k<otitles.length;k++){
    		var ohtml = otitles[k].innerHTML;    	
    		
    		for(var i=0;i<keywords.length;i++){
	    		eval('ohtml = ohtml.replace(/'+keywords[i]+'/g,\'<span class="listkeywordstyle">'+keywords[i]+'</span>\')');
	    	}
	    	otitles[k].innerHTML = ohtml;
    	}
    	for(var j=0;j<ocontents.length;j++){
    		var ohtml = ocontents[j].innerHTML;
    		for(var i=0;i<keywords.length;i++){
	    		eval('ohtml = ohtml.replace(/'+keywords[i]+'/g,\'<span class="listkeywordstyle">'+keywords[i]+'</span>\')');
	    	}
	    	ocontents[j].innerHTML = ohtml;
    	}
    	document.body.innerHTML=document.body.innerHTML;
    }
    function search(keyword,pageNo){
    	document.getElementsByName('keyword')[0].value=keyword;
    	document.getElementsByName('pageNo')[0].value=pageNo;
    	document.getElementById('searchForm').submit();
    }
    function view(id){
    	window.open('snapshot.jsp?pkey='+id+'&keyword='+document.getElementById('keyword').value,"","");//<%=java.net.URLEncoder.encode("大话","gbk")%>
    }
    
    </script>
  <body style="text-align:center" onload="lightKeyword()">
    <table style="height:100%;width:90%">
    	<tr>
    		<td style="text-align:center;">
    			<form action="search.jsp" method="post" id="searchForm" style="margin:0px;padding:0px">
			    	<table>
			    		<tr>
			    			<input type="hidden" name="pageNo" value="1">
			    			<td><input type="text" name="keyword" id="keyword" size="100" value="<%=keyword %>"></td>
			    			<td><input type="submit" value="搜索" onclick="searchUrl()"></td>
			    		</tr>
			    	</table>
			    </form>
    		</td>
    	</tr>
    	<tr>
    		<td style="text-align:center">
    			<%for(int i = pageNo-10;i<pageNo+10&&i<=pageCount;i++){ 
			    	if(i>0&&!keyword.trim().equals("")){
			    %>
<%--			    	<a href="javascript:search('<%=keyword%>','<%=i %>');"><%=i %> </a>&nbsp;	--%>
			    <%	}
			    } %>
    		</td>
    	</tr>
    	<tr>
    		<td style="height:100%;vertical-align:top" id="list">
    			<%if(!keyword.trim().equals("")){
    				out.println("<table style='width:100%'><tr><td class='resultcount'>共 "+resultCount+" 条结果&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><tr>");
		    		for(int i=1;i<list.size();i++){
		    			Map<String,String> map = list.get(i);
		    			String title = map.get("title");
		    			String content = map.get("result").replaceAll("<[^<>]+>","");
		    			content =content.substring(0,content.length()>500?500:content.length());
		    			out.println("<tr><td class='resulttitle'><br>");
		    			out.println("<a href='"+map.get("url")+"' target='_blank' name='title'>"+title+"</a>&nbsp;&nbsp;&nbsp;&nbsp;");
		    			out.println("<a href='snapshot.jsp?pkey="+map.get("pkey")+"&keyword="+keyword+"' target='_blank'>网页快照</a>");
		    			out.println("</td></tr>");
		    			out.println("<tr><td class='resultcontent'><a name='content' style='width:80%'>"+content+"</a></td></tr>");
		    			out.println("<tr><td class='resulthref'><a style='width:80%'>"+map.get("url")+"</a></td></tr>");
		    		}
		    		out.println("</table>");
		    	}else{%>
		    		<span style="text-align:center;width:100%"><h1>搜索页面</h1></span>
		    	<%} %>
    		</td>
    	</tr>
    	<tr>
    		<td style="text-align:center">
    			<%for(int i = pageNo-10;i<pageNo+10&&i<=pageCount;i++){ 
			    	if(i>0&&!keyword.trim().equals("")){
			    %>
			    	<a href="javascript:search('<%=keyword%>','<%=i %>');"><%=i %> </a>&nbsp;	
			    <%	}
			    } %>
    		</td>
    	</tr>
    </table>
  </body>
</html>
