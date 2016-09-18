package com.iie.cas.controller;

import static com.iie.cas.cons.CommonConstant.ROLE;
import static com.iie.cas.cons.CommonConstant.ADMIN_CONTEXT;
import static com.iie.cas.cons.CommonConstant.STUDENT_CONTEXT;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iie.cas.entity.Admin;
import com.iie.cas.entity.Student;

/**
 * @author liujunjiao 2016/9/14
 */
public class LoginFilter implements Filter {
	private String[] excludedUrls;

	@Override
	public void init(FilterConfig config) throws ServletException {
		String excludes = config.getInitParameter("excludedUrls");
		if (excludes != null) {
			this.excludedUrls = excludes.split(",");
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String requestUri = httpRequest.getRequestURI();

		System.out.println("获得地址是：" + requestUri);

		for (String url : excludedUrls) {
			System.out.println("url : " + url);
			if (requestUri.contains(url.trim())) {
				chain.doFilter(request, response);
				return;
			}
		}

		if (getSessionRole(httpRequest) == null && getSessionStudent(httpRequest) == null && getSessionAdmin(httpRequest) == null) {
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");

		} else {
			chain.doFilter(request, response);
			return;
		}
	}

	@Override
	public void destroy() {

	}

	protected Student getSessionStudent(HttpServletRequest request) {
		return (Student) request.getSession().getAttribute(STUDENT_CONTEXT);
	}
	
	protected Admin getSessionAdmin(HttpServletRequest request) {
		return (Admin) request.getSession().getAttribute(ADMIN_CONTEXT);
	}
	
	protected Integer getSessionRole(HttpServletRequest request) {
		return (Integer) request.getSession().getAttribute(ROLE);
	}


}