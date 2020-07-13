package com.simple.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.dbcp2.BasicDataSource;

import com.simple.util.ConnectionUtil;

public class DBCPInitializerListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		// <context-param>�� �������� ��� �ִ� ServletContext ��ü ȹ��
		ServletContext sc = sce.getServletContext();
		// <context-param> �� ��ȸ�ϱ�
		String url = sc.getInitParameter("db.url");
		String driverClassName = sc.getInitParameter("db.driverClassName");
		String userName = sc.getInitParameter("db.username");
		String password = sc.getInitParameter("db.password");
		
		// DataBase Connection Pool �����ϱ�
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl(url);
		ds.setDriverClassName(driverClassName);
		ds.setUsername(userName);
		ds.setPassword(password);
		
		// ������ Ŀ�ؼ�Ǯ ��ü�� ConnectionUtil�� dataSource ������ �����Ѵ�.
		ConnectionUtil.setDataSource(ds);
	}
}
