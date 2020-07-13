<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.sample.vo.Contact"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- sample5.jsp > sample5_jsp.java > sample5_jsp.class -->
	<h1>스크립틀릿 사용하기</h1>
	
	<%
		Contact c1 = new Contact("홍길동", "010-1234-5546", "hong@gmail.com", "현대자동차");
		Contact c2 = new Contact("김유신", "010-4434-5546", "ggg@gmail.com", "기아자동차");
		Contact c3 = new Contact("강감찬", "010-3334-5546", "sadng@gmail.com", "대우자동차");
		Contact c4 = new Contact("유관순", "010-5534-5546", "h213g@gmail.com", "BMW");
		Contact c5 = new Contact("안중근", "010-6634-5546", "hxzcgg@gmail.com", "포르쉐");
		Contact c6 = new Contact("이순신", "010-6878-4546", "cccgg@gmail.com", "람보르기니");
		
		List<Contact> contacts = new ArrayList<>();
		contacts.add(c1);
		contacts.add(c2);
		contacts.add(c3);
		contacts.add(c4);
		contacts.add(c5);
		contacts.add(c6);
	%>
	
	<table border="1" style="width: 100%">
		<thead>
			<tr>
				<th>이름</th>
				<th>연락처</th>
				<th>이메일</th>
				<th>소속회사</th>
			</tr>
		</thead>
		<tbody>
			<!-- 연락처 반복 -->
			<%
				for (Contact contact : contacts) {
			%>
			<tr>
				<td><%=contact.getName() %></td>
				<td><%=contact.getTel() %></td>
				<td><%=contact.getEmail() %></td>
				<td><%=contact.getCompany() %></td>
			</tr>
			<!-- // 연락처 반복 -->
			<%
				}
			%>
		</tbody>
	</table>
	
</body>
</html>