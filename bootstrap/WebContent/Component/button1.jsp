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
		<div class="col-12">
			<h1>부트스트랩 버튼</h1>
			
			<h3>버튼샘플</h3>
			<div>
				<button type="button" class="btn btn-primary">Primary</button>
				<button type="button" class="btn btn-secondary">Secondary</button>
				<button type="button" class="btn btn-success">Success</button>
				<button type="button" class="btn btn-danger">Danger</button>
				<button type="button" class="btn btn-warning">Warning</button>
				<button type="button" class="btn btn-info">Info</button>
				<button type="button" class="btn btn-light">Light</button>
				<button type="button" class="btn btn-dark">Dark</button>
				<button type="button" class="btn btn-link">Link</button>
			</div>
			
			<h3>
				<a href="#" class="btn btn-primary">a tag 링크로도 버튼 가능</a>
				<input type="submit" class="btn btn-primary" value="제출">
				<input type="reset" class="btn btn-primary" value="리셋">
			</h3>
			<hr>
			<h3>테두리를 가진 버튼</h3>
			<div>
				<button type="button" class="btn btn-outline-primary">Primary</button>
				<button type="button" class="btn btn-outline-secondary">Secondary</button>
				<button type="button" class="btn btn-outline-success">Success</button>
				<button type="button" class="btn btn-outline-danger">Danger</button>
				<button type="button" class="btn btn-outline-warning">Warning</button>
				<button type="button" class="btn btn-outline-info">Info</button>
				<button type="button" class="btn btn-outline-light">Light</button>
				<button type="button" class="btn btn-outline-dark">Dark</button>
				<button type="button" class="btn btn-outline-link">Link</button>
			</div>
			<hr/>
			
			<h3>다양한 크기의 버튼</h3>
			<div>
				<button class="btn btn-primary btn-sm">SMALL BUTTON</button>
				<button class="btn btn-primary">NOMAL BUTTON</button>
				<button class="btn btn-primary btn-lg">LARGE BUTTON</button>
			</div>
			<hr>
			
			<h3>활성화 비활성화된 버튼</h3>
			<div>
				<a class="btn btn-primary" href="#">링크</a>
				<a class="btn btn-primary active" href="#">링크</a>
				<button class="btn btn-primary">버튼</button>
				
				<a clss="btn btn-primary disabled" href="#">링크</a>
				<button class="btn btn-primary" disabled>버튼</button>
			</div>
			<hr/>
			
			<h3>로딩 중 버튼</h3>
			<div>
				<button class="btn btn-primary">
					<span class="spinner-border spinner-border-sm"></span>
				</button>
				<button class="btn btn-secondary">
					<span class="spinner-border spinner-border-lg"></span>
					로딩...
				</button>
			</div>
			<hr/>
			
			<h3>풀사이즈 버튼</h3>
			<div>
				<button class="btn btn-danger btn-block">풀사이즈 버튼</button>
			</div>
		</div>
	</div>
</div>
</body>
</html>