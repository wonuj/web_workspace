<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>체크박스가 포함된 요청파라미터값 조회하기</h1>
	<%
		request.setCharacterEncoding("utf-8");
	
		String name = request.getParameter("name");
		String job = request.getParameter("job");
		String[] skills = request.getParameterValues("skill"); // 값을 입력하는데 복수개 입력하는 경우에는 values
	%>
	
	<h3>경력사항</h3>
	<dl>
		<dt>이름</dt>
		<dd><%=name %></dd>
	</dl>
	<dl>
		<dt>지원분야</dt>
		<dd><%=job %></dd>
	</dl>
	<dl>
		<dt>보유기술</dt>
	<%
		if(skills != null) {
			for(String skill : skills) {
	%>
		<dd><%=skill %></dd>
	<%
			}
		}
	%>
	</dl>
</body>
</html>