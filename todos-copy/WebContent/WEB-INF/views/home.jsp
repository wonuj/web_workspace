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
					<c:forEach var="todo" items="${todos }">
						<div class="col-4 mb-2">
							<div class="card">
								<div class="card-header d-flex justify-content-between">
									<div>${todo.title }</div> 
										<div><span id="card-todo-status-${todo.no }"class="badge ${todo.statusClass }">${todo.status }</span></div>
								</div>
								<div class="card-body">
									<div class="row mb-3">
										<div class="col-9">
											<small>${todo.content }</small>
										</div>
										<div class="col-3">
											<button type="button" class="btn btn-outline-secondary btn-sm" onclick="openTodoDetailModal(${todo.no})">상세</button>
										</div>
									</div>
									<div class="d-flex justify-content-between">
										<span class="text-secondary font-weight-bold">${todo.userName }</span>											
										<strong><fmt:formatDate value="${todo.day }"/></strong>
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
     									<th>번호</th>
     									<td id="modal-todo-no"></td>
     									<th>제목</th>
     									<td colspan="3" id="modal-todo-title"></td>
     								</tr>
     								<tr>
     									<th>작성자</th>
     									<td id="modal-todo-username"></td>
     									<th>등록일</th>
     									<td id="modal-todo-day"> </td>
     								</tr>
     								<tr>
     									<th>상태</th>
     									<td id="modal-todo-status"></td>
     									<th>예정일</th>
     									<td id="modal-todo-completed-day"></td>
     								</tr>
     								<tr>
     									<th style="vertical-align: middle;">내용</th>
     									<td colspan="3" id="modal-todo-content"><small> </small></td>
     								</tr>
     							</tbody>
     						</table>
     					</div>
     				</div>
   				</div>
   				<div class="modal-footer">
     				<span id="modal-badge-1" style="display: none;">
	     				<button type="button" class="btn btn-success btn-sm" onclick="updateTodoStatus('처리완료')">처리완료</button>
	     				<button type="button" class="btn btn-info btn-sm" onclick="updateTodoStatus('처리중')">처리중</button>
	     				<button type="button" class="btn btn-secondary btn-sm" onclick="updateTodoStatus('보류')">보류</button>
	     				<button type="button" class="btn btn-danger btn-sm" onclick="updateTodoStatus('취소')">취소</button>
     				</span>
     				<span>
	     				<button type="button" class="btn btn-outline-dark btn-sm" data-dismiss="modal">닫기</button>     				
     				</span>
   				</div>
 			</div>
		</div>
	</div>
	
	<%@ include file="footer.jsp" %>
</div>
<script type="text/javascript">
	function openTodoDetailModal(no) {
		document.getElementById("modal-badge-1").style.display = "none";					
		var data = "?todono=" + no;
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200){
				var text = xhr.responseText; // text --> '{"result":true}' or '{"result":false}'
				var resData = JSON.parse(text); // resData --> {result: true} or {result : false}로 변환됨
				$("#modal-todo-title").text(resData.title);
				$("#modal-todo-username").text(resData.userName);
				$("#modal-todo-day").text(resData.day);
				$("#modal-todo-status").text(resData.status);
				$("#modal-todo-completed-day").text(resData.completedDate);
				$("#modal-todo-no").text(resData.no);
				$("#modal-todo-content").text(resData.content);
				$("#modal-todo-detail").modal('show');
				if(resData.canModify){
					document.getElementById("modal-badge-1").style.display = "";
				} else{
					document.getElementById("modal-badge-1").style.display = "none";					
				}
			}
		};
		xhr.open("get", "/todo/detail.hta" + data);
		xhr.send(data);
		
	}
	
	function updateTodoStatus(status) {
		var no = document.getElementById("modal-todo-no").textContent;
		var data = "?todono="+no+"&status="+status;
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200){
				var text = xhr.responseText; // text --> '{"result":true}' or '{"result":false}'
				var resData = JSON.parse(text); // resData --> {result: true} or {result : false}로 변환됨
				$("#modal-todo-status").text(resData.status);
				$("#modal-todo-completed-day").text(resData.completedDay);
				$("#card-todo-status-" + resData.no).attr("class", "badge " + resData.statusClass);
				$("#card-todo-status-" + resData.no).text(resData.status);
			}
		};
		xhr.open("get", "/todo/updatestatus.hta" + data);
		xhr.send();
	}
</script>
</body>
</html>
