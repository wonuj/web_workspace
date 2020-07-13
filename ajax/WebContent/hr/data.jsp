<%@page import="com.google.gson.Gson"%>
<%@page import="com.sample.hr.vo.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.simple.util.NumberUtil"%>
<%@page import="com.sample.hr.dao.EmployeeDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	int departmentId = NumberUtil.stringToInt(request.getParameter("deptid"));

	EmployeeDao employeeDao = new EmployeeDao();
	List<Employee> employees = employeeDao.getEmployeesByDept(departmentId);
	
	Gson gson = new Gson();
	String jsonContent = gson.toJson(employees);
	
	out.write(jsonContent);
%>