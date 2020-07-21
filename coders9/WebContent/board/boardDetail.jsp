<%@page import="com.simple.vo.Board"%>
<%@page import="com.simple.dao.BoardDao"%>
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

	BoardDao boardDao = new BoardDao();
	Board board = boardDao.getBoardByNo(boardNo);
%>
<div class="container">
	<h1 class="mt-5">Coders9</h1>
	<div class="row mt-3">
		<div class="col-12 mt-3">
		<h3>Board Detail</h3>
	      <div class="row">
	        <div class="col-8">
	          <h5>Profile</h5>
	          <div class="card mt-3">
	            <div class="row no-gutters">
	              <div class="col-2">
	                <img src="images/1.png" alt="" class="card-img" />
	              </div>
	              <div class="col-10">
	                <div class="card-body">
	                  <p class="card-text">안녕하세요. 저는 'hong'이라고 합니다.</p>
	                </div>
	              </div>
	            </div>
	          </div>
	        </div>
	      </div>
	    </div>
	</div>
	<div>
		<div>
			<div>
				<h6 class="mt-3">board no.<%=boardNo %></h6>
			</div>			
			<div>
				<h5 class="mt-3">title</h5>
				<%=board.getBoardTitle() %>
			</div>			
			<div>
				<h5 class="mt-3">content</h5>
				<%=board.getContent() %>
			</div>
			<div class="text-right mt-3">
				<a href="../board/modifyBoard.jsp?boardno=<%=boardNo %>" class="btn btn-light text-right">Modify</a>
				<a href="../board/deleteBoard.jsp?boardno=<%=boardNo %>" class="btn btn-light text-right">Delete</a>
				<a href="../board/boardList.jsp" class="btn btn-light text-right" >List</a>
			</div>
		</div>
	</div>
</div>
</body>
</html>