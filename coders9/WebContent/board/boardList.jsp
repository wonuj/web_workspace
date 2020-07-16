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
</style>
</head>
<body>

<%
	
%>

<div class="container p-3 my-4 border">
	<div>
		<h1 class="mt-2">Coders9</h1>
	</div>
	<div class="row mt-2 ">
		<div class="col-12 mt-3">
			<h3>Board List</h3>
			<table class="table table-hover">
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
					<tr class="text-center">
						<td>1</td>
						<td class="text-left">안녕하세요.</td>
						<td>장원준</td>
						<td>2020.07.16</td>
					</tr>
					<tr class="text-center">
						<td>2</td>
						<td class="text-left">안녕하세요.</td>
						<td>장원준</td>
						<td>2020.07.16</td>
					</tr>
					<tr class="text-center">
						<td>3</td>
						<td class="text-left">안녕하세요.</td>
						<td>장원준</td>
						<td>2020.07.16</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="text-right">
		<a href="../board/insertBoard.jsp" class="btn btn-light text-right" >글 등록</a>
	</div>
</div>
</body>
</html>