package com.simple.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoggerFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// ��ó�� �۾� (doFilter �������� �ڵ� ��ġ�� ���� ��ó��/��ó���� ������.)
		System.out.println("�α����� ��ó���۾� ...");
		
		HttpServletRequest httpReq = (HttpServletRequest) request;
		String requestURI = httpReq.getRequestURI();
		String ipAddr = httpReq.getRemoteAddr();
		
		long startTime = System.currentTimeMillis();
		
		System.out.println("["+ipAddr+"] Ŭ���̾�Ʈ�� ��û�� ����");
		System.out.println("["+requestURI+"] ��û�� ���� ó���� ������");
		
		chain.doFilter(request, response); // �� ���� ���Ϳ� �ִ� doFilter�� �����ϴ� ��
										   // ���̻� �����ִ� ���� ������ �������� ����/JSP�� ����
		
		// ��ó�� �۾�
		System.out.println("�α����� ��ó���۾� ...");
		
		long endTime = System.currentTimeMillis();
		
		long workingTime = endTime - startTime;
		
		System.out.println("�ҿ�ð� : " + workingTime + " �и���");
		System.out.println("["+requestURI+"] ��û�� ���� ó���� ������\n");
		
		
	}
}
