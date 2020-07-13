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
		
		// 전처리 작업 (doFilter 기준으로 코드 위치에 따라서 전처리/후처리로 나뉜다.)
		System.out.println("로그필터 전처리작업 ...");
		
		HttpServletRequest httpReq = (HttpServletRequest) request;
		String requestURI = httpReq.getRequestURI();
		String ipAddr = httpReq.getRemoteAddr();
		
		long startTime = System.currentTimeMillis();
		
		System.out.println("["+ipAddr+"] 클라이언트의 요청을 받음");
		System.out.println("["+requestURI+"] 요청에 대한 처리를 시작함");
		
		chain.doFilter(request, response); // 내 다음 필터에 있는 doFilter를 실행하는 것
										   // 더이상 남아있는 것이 없으면 그제서야 서블릿/JSP를 실행
		
		// 후처리 작업
		System.out.println("로그필터 후처리작업 ...");
		
		long endTime = System.currentTimeMillis();
		
		long workingTime = endTime - startTime;
		
		System.out.println("소요시간 : " + workingTime + " 밀리초");
		System.out.println("["+requestURI+"] 요청에 대한 처리를 종료함\n");
		
		
	}
}
