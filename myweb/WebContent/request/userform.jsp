<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>유저 폼</h1>
	
	<h3>유저 정보를 등록하세요.</h3>
	<form>
		<div>
			<label>아이디</label>
			<div><input type="text" name="userid" /></div>
		</div>
		<div>
			<label>비밀번호</label>
			<div><input type="password" name="userpassword" /></div>
		</div>
		<div>
			<label>이름</label>
			<div><input type="text" name="username" /></div>
		</div>
		<div>
			<label>이메일</label>
			<div><input type="text" name="useremail" /></div>
		</div>
		<div>
			<button type="submit">등록</button>
		</div>
	</form>
</body>
</html>