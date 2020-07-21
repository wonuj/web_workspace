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
@import url("http://fonts.googleapis.com/earlyaccess/nanumgothic.css");
	body {
	    width:100%;
	    height:100%;
	    margin: 0;
	}
    .card {
        margin: 0 auto; /* Added */
        float: none; /* Added */
        margin-bottom: 10px; /* Added */
	}
	.form-signin .form-control {
  		position: relative;
  		height: auto;
  		-webkit-box-sizing: border-box;
     	-moz-box-sizing: border-box;
        	 box-sizing: border-box;
  		padding: 10px;
  		font-size: 16px;
	}
</style>
</head>
<body>
	<div class="container">
		<h1 class="mt-5">Coders9</h1>		
		<div class="card align-middle mt-5" style="width:20rem; border-radius:20px;">
			<div class="card-title" style="margin-top:30px;">
				<h3 class="card-title text-center">Login</h3>
				
			</div>
			<div class="card-body">
				<form action="loginRegister.jsp" method="post">
					<h5 class="form-signin-heading">Welcome!</h5>
					<label class="sr-only">ID</label>
					<input type="text" name="userid" class="form-control" placeholder="ID" required autofocus><br>
					<label class="sr-only">Password</label>
					<input type="password" name="password" class="form-control" placeholder="Password" required><br>
					<button class="btn btn-lg btn-secondary btn-block" type="submit">Sign In</button>
					<a href="../user/signUp.jsp" class="btn btn-lg btn-secondary btn-block">Sign Up</a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>