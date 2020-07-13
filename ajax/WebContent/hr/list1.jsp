<%@page import="com.sample.hr.vo.Employee"%>
<%@page import="com.simple.util.NumberUtil"%>
<%@page import="com.sample.hr.vo.Department"%>
<%@page import="java.util.List"%>
<%@page import="com.sample.hr.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../resources/css/style.css">
</head>
<body>
<div class="wrapper">
	<div class="navi">
		<div id="navibar">
			<ul>
				<li><a href="/ajax/home.jsp">직원조회</a></li>
				<li class="active"><a href="/ajax/hr/list1.jsp">직원조회</a></li>
				<li><a href="/ajax/hr/list2.jsp">직원조회(Ajax)</a></li>
			</ul>
		</div>
	</div>
	<div class="header">
		<h1>직원조회 시스템</h1>
	</div>
	<div class="body">
		<p>부서별 직원조회 기능을 제공합니다.</p>
		
		<%
			int departmentId = NumberUtil.stringToInt(request.getParameter("deptid"));
		
			EmployeeDao dao = new EmployeeDao();
			List<Department> departments = dao.getAllDepartments();
		%>
		
		<div>
			<form method="get" action="list1.jsp">
				<label>부서명</label>
				<select name="deptid" style="height: 30px;">
					<option value="" selected disabled> -- 부서명 선택 -- </option>
		<%
			for (Department dept : departments) {
		%>				
					<option value="<%=dept.getId() %>" <%=departmentId == dept.getId() ? "selected" : "" %>><%=dept.getName() %></option>
		<%
			}
		%>
				</select>
				<button type="submit">조회</button>
			</form>
		</div>
		
		<div>
		<%
			List<Employee> employees = dao.getEmployeesByDept(departmentId);
		%>
			<table class="table">
				<colgroup>
					<col width="16%">
					<col width="16%">
					<col width="16%">
					<col width="16%">
					<col width="16%">
					<col width="16%">
				</colgroup>
			
				<thead>
					<tr>
						<th>사원아이디</th>
						<th>이름</th>
						<th>전화번호</th>
						<th>직종</th>
						<th>급여</th>
						<th>입사일</th>
					</tr>
				</thead>
				<tbody>
		<%
			if (employees.isEmpty()) {
		%>
				<tr>
					<td class="text-center" colspan="6">조회된 결과가 없습니다.</td>
				</tr>
		<%
			} else {
				for (Employee emp : employees) {
		%>
					<tr>
						<td><%=emp.getId() %></td>
						<td><%=emp.getFirstName() %></td>
						<td><%=emp.getPhoneNumber() %></td>
						<td><%=emp.getJobId() %></td>
						<td><%=NumberUtil.numberWithComma((int)emp.getSalary()) %></td>
						<td><%=emp.getHireDate() %></td>
					</tr>
		<%
			
				}
			}
		%>
				</tbody>
			</table>
		</div>
	</div>
	<div class="footer">
		<p>좋은짱 주식회사</p>
	</div>
</div>
</body>
</html>