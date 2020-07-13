<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple Board</title>
<link rel="stylesheet" type="text/css" href="../resources/css/style.css">
</head>
<body>
<div class="wrapper">
	<div class="navi">
		<% String position = "user"; %>
		<%@ include file="../common/navibar.jsp" %>
	</div>
	<div class="header">
		<h1>회원가입 완료</h1>
	</div>
	<div class="body">
		<p>회원가입이 완료되었습니다.</p>
	</div>
	<div class="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
</div>
</body>
</html>