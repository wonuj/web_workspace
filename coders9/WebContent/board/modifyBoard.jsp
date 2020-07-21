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
	int boardNo = Integer.parseInt(request.getParameter("boardno"));
%>
<div class="container">
	<h1 class="mt-5">Coders9</h1>
	<div class="row mt-3">
		<div class="col-12 mt-3">
		<h3>Modify Board</h3>
		<form action="modifyBoardRegister.jsp" method="post">
			<input type="hidden" name="boardno" value="<%=boardNo %>">
			<h5>title</h5>
				<div>
					<input type="text" style="width:100%" class=" border border-gray" name="title">
				</div>
			<h5>content</h5>
				<div>
					<textarea rows="10" style="width:100%" class="border border-gray" name="content"></textarea>
				</div>
			<div class="text-right mt-3">
				<button class="btn btn-light" type="submit">OK</button> 
				<a href="../board/boardList.jsp" class="btn btn-light text-right" >Cancel</a>
			</div>
		</form>
		</div>
	</div>
</div>
</body>
</html>