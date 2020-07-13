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
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-6">
			<h1>To Do List <span class="badge badge-secondary">10개</span></h1>
			<h2>To Do List <span class="badge badge-secondary">10개</span></h2>
			<h3>To Do List <span class="badge badge-secondary">10개</span></h3>
			<h4>To Do List <span class="badge badge-secondary">10개</span></h4>
			<h5>To Do List <span class="badge badge-secondary">10개</span></h5>
			<h6>To Do List <span class="badge badge-secondary">10개</span></h6>
		</div>
		<div class="col-6">
			<h3>버튼에 표시되는 뱃지</h3>
			<button class="btn btn-warning">
				알림 <span class="badge badge-light">4</span>
			</button>
		</div>
	</div>
	<div class="row">
		<div class="col-4">
			<h3>문맥적 의미를 가지는 뱃지</h3>
			<span class="badge  badge-priamry">p</span>
			<span class="badge  badge-secondary">scd</span>
			<span class="badge  badge-success">sc</span>
			<span class="badge  badge-danger">d</span>
			<span class="badge  badge-warning">wrn</span>
			<span class="badge  badge-info">i</span>
			<span class="badge  badge-light">l</span>
			<span class="badge  badge-dark">d</span>
		</div>
		<div class="col-4">
			<h3>모서리가 라운딩 처리된 뱃지</h3>
			<h3>문맥적 의미를 가지는 뱃지</h3>
			<span class="badge badge-pill badge-priamry">p</span>
			<span class="badge badge-pill badge-secondary">scd</span>
			<span class="badge badge-pill badge-success">sc</span>
			<span class="badge badge-pill badge-danger">d</span>
			<span class="badge badge-pill badge-warning">wrn</span>
			<span class="badge badge-pill badge-info">i</span>
			<span class="badge badge-pill badge-light">l</span>
			<span class="badge badge-pill badge-dark">d</span>
		</div>
		<div class="col-4">
			<h3>링크를 뱃지로 표현하기</h3>
			<a href="#" class="badge badge-primary">중요한 링크</a>
			<a href="#" class="badge badge-secondary">덜 중요한 </a>
			<a href="#" class="badge badge-success">좋은 일이 생기는 </a>
			<a href="#" class="badge badge-danger">안 좋은 일이 생기는</a>
			<a href="#" class="badge badge-warning">경고를 해주고 싶은</a>
			<a href="#" class="badge badge-info">변경된 정보를 보여주는</a>
			<a href="#" class="badge badge-light">하얀</a>
			<a href="#" class="badge badge-dark">까만</a>
		</div>
	</div>
</div>
</body>
</html>