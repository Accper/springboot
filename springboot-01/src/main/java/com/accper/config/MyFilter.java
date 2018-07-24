package com.accper.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * 自定义过滤器作用： 1，录调用日志 2，排除有XSS威胁的字符 3，执行权限认证
 * 
 * 实现的两个步骤： 1，实现Filter接口，实现Filter方法 2，添加@Configuration注解，将自定义Filter加入到过滤链
 * 
 * @author accper
 *
 */
@WebFilter(urlPatterns = "/*", filterName = "myfilter")
public class MyFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		System.out.println("this is my filter, url is:"
				+ httpServletRequest.getRequestURL());
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}