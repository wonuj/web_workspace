package com.simple.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.simple.vo.User;

public class LoginCheckFilter implements Filter {
	
	private String loginCheckUrl;
	private String loginUncheckUrl;	
	
	// web.xml ������ ���� ���� ����
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String loginCheckUrl = filterConfig.getInitParameter("checkURL");
		String loginUncheckUrl = filterConfig.getInitParameter("uncheckURL");
		System.out.println("�α��� üũ URL :" + loginCheckUrl);
		System.out.println("�α��� ��üũ URL :" + loginUncheckUrl);
		
	}
	
	@Override
	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpReq = (HttpServletRequest) request;
		String requestUrl = httpReq.getRequestURI();
		
		// ��ûurl�� �α���üũ url�� ��ġ�ϴ� ���
		if(requestUrl.equals(loginCheckUrl)) {
			// �α��� ���θ� Ȯ���Ѵ�.
			HttpSession session = httpReq.getSession();
			User user = (User) session.getAttribute("loginUser");
			// �α��εǾ� ���� ������ ������������ ������.
			if(user == null) {
				httpReq.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
				return;
			}
		} 
		
		// ��ûurl�� �α���üũ url�� ��ġ���� �ʴ� ���
		// �α��ο��θ� üũ�� �ʿ䰡 �����Ƿ� ������ ���ͳ� ������ �����Ѵ�.
		chain.doFilter(request, response);
		
		
	}
}
