<%@page import="com.simple.dto.ReplyDto"%>
<%@page import="java.util.List"%>
<%@page import="com.simple.dao.ReplyDao"%>
<%@page import="com.simple.util.StringUtil"%>
<%@page import="com.simple.dao.BoardDao"%>
<%@page import="com.simple.dto.BoardDto"%>
<%@page import="com.simple.util.NumberUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple Board</title>
<link rel="stylesheet" type="text/css" href="../resources/css/style.css">
<style>
	.bold-bordered {
		border-bottom: 1px double black;
	}
</style>
</head>
<body>
<div class="wrapper">
	<div class="navi">
		<% String position = "board"; %>
		<%@ include file="../common/navibar.jsp" %>
	</div>
	<div class="header">
		<h1>게시글 상세정보</h1>
	</div>
	<div class="body">
		<%
			int boardNo = NumberUtil.stringToInt(request.getParameter("no"));
			int pageNo = NumberUtil.stringToInt(request.getParameter("page"), 1);
			
			// 글번호가 0보다 작으면 list.jsp를 재요청하게 한다.
			if (boardNo <= 0) {
				response.sendRedirect("list.jsp");
				return;
			}
			
			BoardDao boardDao = new BoardDao();
			// 게시글 번호에 해당하는 게시글을 조회한다.
			BoardDto boardDto = boardDao.getBoard(boardNo);
			// 게시글이 존재하지 않으면 list.jsp를 재요청하게 한다.
			if (boardDto == null) {
				response.sendRedirect("list.jsp");
				return;
			}
			
		%>
		<p>게시글의 내용을 확인하고, 댓글도 달아보세요.</p>
		<div>
			<table class="table bordered">
				<colgroup>
					<col width="10%">
					<col width="40%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>제목</th>
						<td colspan="3"><%=boardDto.getTitle() %></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><a href="writers.jsp?userid=<%=boardDto.getWriter()%>"><%=boardDto.getWriterName() %></a></td>
						<th>등록일</th>
						<td><%=boardDto.getCreateDate() %></td>
					</tr>
					<tr>
						<th>조회수</th>
						<td><%=boardDto.getHit() %></td>
						<th>댓글갯수</th>
						<td><%=boardDto.getReplyCnt() %></td>
					</tr>
					<tr>
						<th style="vertical-align: top;">내용</th>
						<td colspan="3" style="vertical-align:top; height:150px; min-height: 150px;"><%=StringUtil.strWithBr(boardDto.getContent()) %></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="text-right">
		<%
			if ("Y".equals(loginedYn) && loginedUserId.equals(boardDto.getWriter())) {
		%>
			[<a href="modifyform.jsp?no=<%=boardNo%>&page=<%=pageNo%>">수정하기</a>]
			[<a href="delete.jsp?no=<%=boardNo%>&page=<%=pageNo%>">삭제하기</a>]
		<%
			}
		%>
		
			[<a href="list.jsp?page=<%=pageNo%>">목록가기</a>]
		</div>
		
		<div>
		<%
			ReplyDao replyDao = new ReplyDao();
			// 게시글번호에 해당하는 리플을 조회한다.
			List<ReplyDto> replys = replyDao.getReplys(boardNo);
		%>
			<p>댓글을 확인하세요.</p>
			<table class="table">
				<colgroup>
					<col width="10%">
					<col width="40%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
				<%
					if (replys.isEmpty()) {
				%>
					<tr>
						<td class="text-center" colspan="4">댓글이 없습니다.</td>
					</tr>
				<%
					} else {
						for (ReplyDto replyDto : replys) {
				%>
					<tr>
						<th>작성자</th>
						<td><%=replyDto.getWriterName() %></td>
						<th>등록일</th>
						<td><%=replyDto.getCreateDate() %></td>
					</tr>
					<tr class="bold-bordered">
						<th>내용</th>
						<td colspan="3"><%=StringUtil.strWithBr(replyDto.getContent()) %></td>
					</tr>
				<%
						}
					}
				%>
				</tbody>
			</table>
			<br/>
			<div class="well">
				<form method="post" action="../reply/register.jsp">
					<input type="hidden" name="boardno" value="<%=boardDto.getNo()%>"/>
					<div class="form-group">
						<textarea rows="3" name="content"></textarea>
					</div>
					<div class="text-right">
						<button type="submit">등록</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
</div>
</body>
</html>