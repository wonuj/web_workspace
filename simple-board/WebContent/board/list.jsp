<%@page import="com.simple.dto.BoardDto"%>
<%@page import="java.util.List"%>
<%@page import="com.simple.vo.Pagination"%>
<%@page import="com.simple.dao.BoardDao"%>
<%@page import="com.simple.util.NumberUtil"%>
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
		<% String position = "board"; %>
		<%@ include file="../common/navibar.jsp" %>
	</div>
	<div class="header">
		<h1>게시글</h1>
	</div>
	<div class="body">
		<p>게시글 목록을 확인하세요</p>
		<%
			int pageNo = NumberUtil.stringToInt(request.getParameter("page"), 1);
			
			BoardDao boardDao = new BoardDao();
			// 전체 게시글 갯수를 조회한다.
			int totalRows = boardDao.getTotalRows();
			// 페이징처리에 필요한 정보를 제공하는 Pagination객체를 생성한다.
			// new Pagination(한 페이지당 글 수, 블록당 페이지번호 수, 현재 페이지번호, 전체 게시글수)
			Pagination pagination = new Pagination(10, 5, pageNo, totalRows);
			
			// 현제 페이지번호에 해당하는 게시글을 조회한다.
			List<BoardDto> boards = boardDao.getBoards(pagination.getBeginIndex(), pagination.getEndIndex());
		%>
		<div>
			<table class="table">
				<colgroup>
					<col width="10%">
					<col width="*">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="15%">
				</colgroup>
				<thead>
					<tr>
						<th class="text-center">번호</th>
						<th>제목</th>
						<th class="text-center">작성자</th>
						<th class="text-center">조회수</th>
						<th class="text-center">댓글수</th>
						<th class="text-center">등록일</th>
					</tr>
				</thead>
				<tbody>
				<%
					if (boards.isEmpty()) {
				%>
					<tr>
						<td class="text-center" colspan="6">게시글이 없습니다.</td>
					</tr>
				<%
					} else {
						for (BoardDto dto : boards) {
							// 삭제처리된 글인 경우
							if ("Y".equals(dto.getDelYn())) {
				%>		
								<tr>
									<td class="text-center"><%=dto.getNo() %></td>
									<td colspan="5"><del>삭제된 글입니다.</del></td>
								</tr>
							
				<%				
							} else {
				%>
								<tr>
									<td class="text-center"><%=dto.getNo() %></td>
									<td><a href="hit.jsp?no=<%=dto.getNo()%>&page=<%=pagination.getPageNo()%>"><%=dto.getTitle() %></a></td>
									<td class="text-center"><a href="writers.jsp?userid=<%=dto.getWriter()%>"><%=dto.getWriterName() %></a></td>
									<td class="text-center"><%=dto.getHit() %></td>
									<td class="text-center"><%=dto.getReplyCnt() %></td>
									<td class="text-center"><%=dto.getCreateDate() %></td>
								</tr>
				
				<%
							}
						}
					}
				%>
				</tbody>
			</table>
		</div>
		<div class="text-right">
			[<a href="form.jsp">글 쓰기</a>]
		</div>
		<div class="text-center">
			<div class="pagination">
			<%
				if (pagination.getPageNo() > 1) {
			%>
				<a href="list.jsp?page=<%=pagination.getPageNo() - 1 %>">이전</a>
			<%
				}
			%>
			
			<%
				for (int num=pagination.getBeginPage(); num<=pagination.getEndPage(); num++) {
			%>
				<a class="<%=num==pageNo ? "active" : "" %>" href="list.jsp?page=<%=num%>"><%=num %></a>
			<%
				}
			%>
			
			<%
				if (pagination.getPageNo() < pagination.getTotalPages()) {
			%>
				<a href="list.jsp?page=<%=pagination.getPageNo() + 1 %>">다음</a>
			<%
				}
			%>
			</div>
		</div>
	</div>
	<div class="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
</div>
</body>
</html>