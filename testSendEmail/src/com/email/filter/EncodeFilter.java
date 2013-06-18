package com.email.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodeFilter implements Filter{

	public void destroy() {
		System.out.println("销毁过滤器、、、、、、、、、");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("过滤器开始执行、、、、、、、、"+request.getCharacterEncoding());

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("过滤器开始初始化、、、、、、、");		
	}

}
