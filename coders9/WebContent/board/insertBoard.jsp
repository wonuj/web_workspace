<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style type="text/css">
	
</style>
</head>
<body>
<%
	
%>
<div class="container p-3 my-4 border">
	<h1 class="mt-2">Coders9</h1>
	<div class="row mt-2">
		<div class="col-12 mt-3">
		<h3>Insert Board</h3>
		<form action="insertBoardRegister.jsp" method="post">
			<input type="hidden" name="userid" value="<%= %>">
			제목
			<div>
			<input type="text" style="width:100%" class=" border border-gray" name="title">
			</div>
			내용
			<div>
			<textarea rows="10" style="width:100%" class="border border-gray" name="content"></textarea>
			</div>
			<div class="text-right">
				<button class="btn btn-light" type="submit">등록</button> 
				<a href="../board/boardList.jsp" class="btn btn-light text-right" >작성 취소</a>
			</div>
		</form>
		</div>
	</div>
</div>
</body>
</html>