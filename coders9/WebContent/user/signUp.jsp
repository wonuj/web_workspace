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
	<div class="card align-middle mt-5" style="width:40rem; border-radius:20px;">
		<div class="card-title" style="margin-top:30px;"> 		
			<h3 class="card-title text-center">Sign Up</h3>
		</div>
		<div class="card-body">
			<form action="signUpRegister.jsp" method="post">
			  	<div class="form-group">
				    <label>ID</label>
				    <input type="text" class="form-control" placeholder="Enter ID" name="userid" id="userid" required>
			  	</div>
			  	<div class="form-group">
				    <label>Password</label>
				    <input type="password" class="form-control" placeholder="Enter Password" name="password" required>
				    <p id="message1"></p><p id="message3"></p>
			  	</div>	  	
			  	<div class="form-group">
				    <label>Confirm Password</label>
				    <input type="password" class="form-control" placeholder="Enter Password" name="pwdCheck" required>
			  	</div>	  	
			  	<div class="form-group">
				    <label>Name</label>
				    <input type="text" class="form-control" placeholder="Enter Name" name="name" required>
			  	</div>
			  	<div class="text-right">
		  			<button type="submit" class="btn btn-light">OK</button>
		  		</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>