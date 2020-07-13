<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>To Do</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<%@ include file="nav.jsp" %>
	<!-- Content -->
	<div class="row mb-3">
		<div class="col-12">
			<div class="card">
				<div class="card-header">전체 일정</div>
				<div class="card-body">
					<div class="row">
						<c:forEach var="recent" items="${recent }" >
							<div class="col-4 mb-2">
								<div class="card">
									<div class="card-header d-flex justify-content-between">
										<div>${recent.title }</div> 
										<div><span class="badge ${recent.statusClass }">처리예정</span></div>
									</div>
									<div class="card-body">
										<div class="row mb-3">
											<div class="col-9">
												<small>${recent.content }</small>
											</div>
											<div class="col-3">
												<button type="button" class="btn btn-outline-secondary btn-sm" onclick="openTodoDetailModal()">상세</button>
											</div>
										</div>
										<div class="d-flex justify-content-between">
											<span class="text-secondary font-weight-bold">${recent.userName }</span>											
											<strong>${recent.day }</strong>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="row">
						<div class="col-12 text-center"><button class="btn btn-outline-dark btn"> 더보기 </button></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 상세정보 모달창 -->
	<div class="modal" id="modal-todo-detail">
		<div class="modal-dialog modal-lg">
 			<div class="modal-content">
   				<div class="modal-header">
     				<h4 class="modal-title">상세 정보</h4>
     				<button type="button" class="close" data-dismiss="modal">&times;</button>
   				</div>
   				<div class="modal-body">
     				<div class="row">
     					<div class="col-12">
     						<table class="table table-bordered table-sm">
     							<colgroup>
     								<col width="15%">
     								<col width="35%">
     								<col width="15%">
     								<col width="35%">
     							</colgroup>
     							<tbody>
     								<tr>
     									<th>제목</th>
     									<td colspan="3" id="modal-todo-title">${detail.title }</td>
     									<th></th>
     									<td></td>
     								</tr>
     								<tr>
     									<th>작성자</th>
     									<td id="modal-todo-username">${detail.userName }</td>
     									<th>등록일</th>
     									<td id="modal-todo-day">${detail.createdDate }</td>
     								</tr>
     								<tr>
     									<th>상태</th>
     									<td id="modal-todo-status">${detail.status }</td>
     									<th>예정일</th>
     									<td id="modal-todo-completed-day">${detail.completeDay }</td>
     								</tr>
     								<tr>
     									<th style="vertical-align: middle;">내용</th>
     									<td colspan="3"><small id="modal-todo-content">${detail.content }</small></td>
     								</tr>
     							</tbody>
     						</table>
     					</div>
     				</div>
   				</div>
   				<div class="modal-footer">
     				<button type="button" class="btn btn-success btn-sm" onclick="updateTodoStatus('처리완료')">처리완료</button>
     				<button type="button" class="btn btn-info btn-sm" onclick="updateTodoStatus('처리중')">처리중</button>
     				<button type="button" class="btn btn-secondary btn-sm" onclick="updateTodoStatus('보류')">보류</button>
     				<button type="button" class="btn btn-danger btn-sm" onclick="updateTodoStatus('취소')">취소</button>
     				<button type="button" class="btn btn-outline-dark btn-sm" data-dismiss="modal">닫기</button>
   				</div>
 			</div>
		</div>
	</div>
	
	<%@ include file="footer.jsp" %>
</div>
<script type="text/javascript">
	function openTodoDetailModal() {
		$("#modal-todo-detail").modal('show');
	}
	
	function updateTodoStatus(status) {
		var todoNo = document.getElementById("modal-todo-no").textContent;
		alert(todoNo + ", " + status);
	}
	
	function todoDetail() {
		
	}
</script>
</body>
</html>
