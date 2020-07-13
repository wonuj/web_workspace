<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	
		String title = request.getParameter("title");
		String content = request.getParameter("contents");
		
		// 아래 코드는 생략
		// Board board = new Board();
		// board.setTitle(title);
		// board.setContents(contents);
		//
		// BoardDao boardDao = new BoardDao();
		// boardDao.insertBoard(board);
		
		// 재요청할 URL을 클라이언트에 응답으로 보내기
		response.sendRedirect("list.jsp");
	%>
</body>
</html>