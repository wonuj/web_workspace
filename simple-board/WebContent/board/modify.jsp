<%@page import="com.simple.vo.Board"%>
<%@page import="com.simple.dao.BoardDao"%>
<%@page import="com.simple.dto.BoardDto"%>
<%@page import="com.simple.util.NumberUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/logincheck.jsp" %>
<%
	// 요청파라미터값 조회
	int boardNo = NumberUtil.stringToInt(request.getParameter("no"));
	int pageNo = NumberUtil.stringToInt(request.getParameter("page"), 1);
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	BoardDao boardDao = new BoardDao();
	// 게시글번호에 대한 게시글 정보를 조회한다.
	BoardDto boardDto = boardDao.getBoard(boardNo);
	
	// Board객체를 생성하고, 현재 게시글값과 수정폼에 입력한 값으로 Board객체에 저장한다.
	Board board = new Board();
	board.setNo(boardNo);
	board.setTitle(title);
	board.setWriter(boardDto.getWriter());
	board.setContent(content);
	board.setHit(boardDto.getHit());
	board.setReplyCnt(boardDto.getReplyCnt());
	board.setDelYn(boardDto.getDelYn());
	// 게시글정보를 데이터베이스에 반영시킨다.
	boardDao.updateBoard(board);
	// 게시글 상세정보화면을 재요청하게 한다.
	response.sendRedirect("detail.jsp?no=" + boardNo + "&page=" + pageNo);
	
%>