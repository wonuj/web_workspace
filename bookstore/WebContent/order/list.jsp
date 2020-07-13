<%@page import="com.bookstore.dto.OrderDto"%>
<%@page import="java.util.List"%>
<%@page import="com.bookstore.dao.OrderDao"%>
<%@page import="com.bookstore.util.NumberUtil"%>
<%@page import="com.bookstore.vo.User"%>
<%@page import="com.bookstore.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bookstore</title>
<link rel="stylesheet" type="text/css" href="../css/bookstore.css">
</head>
<body>
<div class="wrapper">
	<div class="navi">
		<%
			String position = "order";
		%>
		<%@ include file="../common/navibar.jsp" %>
	</div>
	<div class="header">
		<h1>주문내역 조회</h1>
	</div>
	<div class="body">
		<%
			String userId = request.getParameter("userid");
		
			UserDao userDao = new UserDao();
			User user = userDao.getUserById(userId);
		%>
		<div>
			<h3>[<%=user.getName() %>]님의 주문내역입니다.</h3>
			<p><strong>누적포인트: </strong> <%=NumberUtil.numberWithComma(user.getPoint()) %> 점</p>
		</div>
		<div>
			<p>주문내역을 확인하세요</p>
			<table class="table">
				<thead>
					<tr>
						<th>주문번호</th>
						<th>제목</th>
						<th class="text-right">가격</th>
						<th class="text-right">수량</th>
						<th class="text-right">결재금액</th>
						<th class="text-center">주문날짜</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				<%
					OrderDao orderDao = new OrderDao();
					List<OrderDto> orders = orderDao.getOrdersByUserId(userId);
					
					if (orders.isEmpty()) {
				%>
						<tr>
							<td class="text-center" colspan="7">
								주문내역이 존재하지 않습니다.
							</td>
						</tr>				
				<%
					} else {
						for (OrderDto order : orders) {
				%>
						<tr>
							<td><%=order.getNo() %></td>
							<td><a href="../book/detail.jsp?bookno=<%=order.getBookNo()%>"><%=order.getBookTitle() %></a></td>
							<td class="text-right"><%=NumberUtil.numberWithComma(order.getPrice()) %> 원</td>
							<td class="text-right"><%=order.getAmount() %></td>
							<td class="text-right"><%=NumberUtil.numberWithComma(order.getPrice()*order.getAmount()) %> 원</td>
							<td class="text-center"><%=order.getRegisteredDate() %></td>
							<td>
							<%
								if ("Y".equals(order.getReviewYN())) {
							%>
								[작성완료]
							<%
								} else {
							%>
								<a href="../review/form.jsp?userid=<%=userId %>&bookno=<%=order.getBookNo()%>">[리뷰작성]</a>
							<%
								}
							%>
							</td>
						</tr>
				<%
						}
					}
					
				%>
				</tbody>
			</table>
			<hr />
			<div class="text-right">
				<a href="../user/list.jsp">사용자 목록</a>
			</div>
		</div>
	</div>
	<%@ include file="../common/footer.jsp" %>	
</div>
</body>
</html>