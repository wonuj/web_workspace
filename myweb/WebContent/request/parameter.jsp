<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>요청 파라미터 보내기</h1>
	
	<h3>POST 방식으로 요청 파라미터 보내기</h3>
	<form method="post" action="parameterview.jsp">
		<div>
			<label>장르</label>
			<div><input type="text" name="genre" /></div>
		</div>
		<div>
			<label>검색어</label>
			<div><input type="text" name="keyword" /></div>
		</div>
		<div>
			<button type="submit">제출하기</button>
		</div>
	</form>
	<h3>GET 방식으로 요청 파라미터 보내기</h3>
	<ul>
		<li><a href="parameterview.jsp?genre=IT&keyword=java">자바</a></li>
		<li><a href="parameterview.jsp?genre=IT&keyword=spring">스프링프레임워크</a></li>
		<li><a href="parameterview.jsp?genre=IT&keyword=datascience">데이터 사이언스</a></li>
		<li><a href="parameterview.jsp?genre=IT&keyword=deeplearning">딥러닝</a></li>
	</ul>
</body>
</html>