<%@page contentType="text/html;charset=utf-8"%>
<link rel="stylesheet" type="text/css" href="css/loginn.css">
<link href="${pageContext.request.contextPath}/css/book_head090107.css"
	rel="stylesheet" type="text/css" />
<div class="head_container">
	<div class="head_welcome">
		<div class="head_welcome_right">
			<span class="head_welcome_text"> </span>
			<span class="head_welcome_text"> <span class="little_n">
					| <a href="#" name="mydangdang" class="head_black12a">我的当当</a> | <a
					href="../common/introduce.jsp" name="helpcenter"
					class="head_black12a">帮助</a> | </span> </span>
			<div class="cart gray4012">
				<a href="${pageContext.request.contextPath}/cart/cart">购物车</a>
			</div>
		</div>
		<span class="head_toutext" id="logininfo"> <b><span
				style="color: blue; font-size: 15px">${s_user.nickname }</span>
				您好，欢迎光临当当网 </b> <%if(session.getAttribute("s_user")!=null){ %> [&nbsp;<a
			href="<%=request.getContextPath() %>/user/logout" class="b">登出</a>&nbsp;]
			<%} else{%> [&nbsp;<a class="btn btn-primary btn-large theme-login"
			href="javascript:;">登录</a>|<a
			href="${pageContext.request.contextPath}/user/toRegistAction"
			class="b">注册</a>&nbsp;] <%} %> </span>
	</div>
	<div class="head_head_list">
		<div class="head_head_list_left">
			<span class="head_logo"><a
				href="${pageContext.request.contextPath}/main/mainAction"
				name="backtobook"><img
						src="${pageContext.request.contextPath}/images/booksaleimg/book_logo.gif" />
			</a> </span>
		</div>
		<div class="head_head_list_right">

			<div class="head_head_list_right_b">
			</div>
		</div>
	</div>
	<div class="head_search_div">

	</div>
	<div class="head_search_bg"></div>


</div>


<script type="text/javascript" src="js/jquery-1.8.min.js">
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/user.login_form.js"></script>
<script>
jQuery(document).ready(function($) {
	$('.theme-login').click(function() {
		$('.theme-popover-mask').fadeIn(100);
		$('.theme-popover').slideDown(200);
	})
	$('.theme-poptit .close').click(function() {
		$('.theme-popover-mask').fadeOut(100);
		$('.theme-popover').slideUp(200);
	})

})
</script>


	<body>
		<div >
			<div class="theme-buy" style="display: none">
			</div>
			<div class="theme-popover">
				<div class="theme-poptit">
					<a href="javascript:;" title="关闭" class="close">×</a>
					<h3>
						登录 是一种态度
					</h3>
				</div>
				<div class="theme-popbod dform">
					<form class="theme-signin"  method="post" action="login" id="ctl00">
						<ol>
							<li>
								<h4>
									你必须先登录！
								</h4>
							</li>
							<li>
								<strong>用户名：</strong>
								<input class="ipt" name="user.email" id="txtUsername" />
							</li>
							<li>
								<strong>密码：</strong>
								<input class="ipt" type="password" name="user.password" id="txtPassword" />
							</li>
							<li>
								<input class="btn btn-primary" type="submit" value=" 登 录 " />
							</li>
						</ol>
					</form>
				</div>
			</div>
			<div class="theme-popover-mask"></div>
		</div>
	</body>
