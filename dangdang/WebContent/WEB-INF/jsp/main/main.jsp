<%@page contentType="text/html;charset=utf-8" import="com.tarena.entity.*"%><%@page import="java.util.List"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${pageContext.request.contextPath}/css/book.css"
			rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/second.css"
			rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/secBook_Show.css"
			rel="stylesheet" type="text/css" />

	<script type="text/javascript" src="../../../js/jquery-1.4.min.js"></script>
	<script type="text/javascript" src="../../../js/jquery-1.8.min.js"></script></head>
	<body>
		&nbsp;
		<!-- 头部开始 -->
		<%@include file="/common/head.jsp"%>
		<!-- 头部结束 -->
		<div style="width: 962px; margin: auto;">
			<a href="#" target="_blank"><img
					src="${pageContext.request.contextPath}/images/default/book_banner_081203.jpg"
					border="0" /> </a>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<s:action name="categoryAction" namespace="/main"
					executeResult="true"></s:action>
			</div>
			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--推荐图书开始-->
				<div class=second_c_border1 id="recommend">
					<s:action name="recommendAction" namespace="/main"
						executeResult="true"></s:action>
				</div>

				<!--推荐图书结束-->

				<!--热销图书开始-->
				<div class="book_c_border2" id="hot">
					<s:action name="hotAction" namespace="/main" executeResult="true"></s:action>
				</div>
				<!--热销图书结束-->

				<!--最新上架图书开始-->
				<div class="book_c_border2" id="new">
					<s:action name="newAction" namespace="/main" executeResult="true"></s:action>
				</div>

				<!--最新上架图书结束-->

				<div class="clear">
				</div>
			</div>
			<!--中栏结束-->



			<!--右栏开始-->
			<div class="book_right">
				<div class="book_r_border2" id="_XinShuReMai">
					<div class="book_r_b2_1x" id="new_bang">
						<h2 class="t_xsrm">
							新书热卖榜
						</h2>
						<div id="NewProduct_1_o_t" onmouseover="">
							<s:action name="newHotAction" namespace="/main"
								executeResult="true"></s:action>
							<h3 class="second">
								<span class="dot_r"> </span><a href="#" target="_blank">更多&gt;&gt;</a>
							</h3>
						</div>
					</div>
				</div>
<%

	Book book=(Book)session.getAttribute("viewed");
	List<Book> list=(List<Book>)session.getAttribute("pageShow");

%>
				<div class="book_r_border2" id="_zuijinliulan">
					<div class="book_r_b2_1x" id="new_bang">
						<h2 class="t_xsrm">
							最近浏览
						</h2>
						<div id="NewProduct_1_o_t" onmouseover="">
						<%if(list.size()!=0){ %>
							<table class=tabl_del id=del_table style="text-align: center;">
								<tr>
									<%for(int i=0;i<list.size();i++){ %>
									
										<td><a href="http://localhost:80/dangdang/main/book_view?id=<%=list.get(i).getId() %>"><IMG id=img_show_prd
											src="../productImages/<%=list.get(i).getProduct_pic() %>" width="75px"><%=list.get(i).getProduct_name() %></td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
										
									<%} %>
								</tr>
							</table>
							<h3 class="second">
							<%if(list.size()>1){ %>
								<span class="dot_r"> </span><a href="mainAction.action?id=<%=list.get(1).getId() %>" >更多&gt;&gt;</a>
							
							</h3>
							<%} }%>
						</div>
					</div>
				</div>
				<!--右栏结束-->
				<div class="clear"></div>
			</div>

			<!--页尾开始 -->
			<%@include file="/common/foot.jsp"%>
			<!--页尾结束 -->
	</body>
</html>
