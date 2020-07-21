<%@page import="com.simple.vo.User"%>
<%@page import="com.simple.dao.UserDao"%>
<%@page import="com.simple.vo.Board"%>
<%@page import="java.util.List"%>
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
	.table {
		border: 1px gray;
	}
 	a:link { color: black; text-decoration: none;}
 	a:visited { color: black; text-decoration: none;}
 	a:hover { color: blue; text-decoration: underline;}
</style>
</head>
<body>
<%
	BoardDao boardDao = new BoardDao();
	List<Board> boards = boardDao.getAllBoards();
%>

<div class="container">
	<h1 class="mt-5">Coders9</h1>
	<div class="row mt-3 ">
		<div class="col-12 mt-3">
			<h3>Board List</h3>
			<table class="table">
				<colgroup>
                  <col width="10%">
                  <col width="60%">
                  <col width="15%">
                  <col width="15%">
               </colgroup>
				<thead>
					<tr class="table-light">
						<th class="text-center">No</th>
						<th class="text-center">Title</th>
						<th class="text-center">Writer</th>
						<th class="text-center">Date</th>
					</tr>
				</thead>
				<tbody>
				<%
					if (boards.isEmpty()) {
				%>
					<tr class="text-center">
						<td>게시글이 존재하지 않습니다.</td>
					</tr>
				
				<%
					} else { 
						for (Board board : boards) {
				%>
					<tr class="text-center">
						<td><%=board.getBoardNo() %></td>
						<td class="text-left"><a href="../board/boardDetail.jsp?boardno=<%=board.getBoardNo() %>"><%=board.getBoardTitle() %></a></td>
						<td>hong</td>
						<td><%=board.getBoardRegisteredDate() %></td>
					</tr>
				<%
						}
					}
				%>
				</tbody>
			</table>
		</div>
	</div>
	<div class="text-right">
		<a href="../board/insertBoard.jsp" class="btn btn-light text-right" >Write</a>
	</div>
</div>


</body>
</html>