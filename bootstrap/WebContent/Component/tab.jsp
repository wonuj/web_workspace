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
			<h3>기본 탭</h3>
			<ul class="nav nav-tabs">
				<li class="nav-item"><a class="nav-link active" data-toggle="tab" href="#detail-box">상세정보</a></li>
				<li class="nav-item"><a class="nav-link"        data-toggle="tab" href="#review-box">사용후기</a></li>
				<li class="nav-item"><a class="nav-link"        data-toggle="tab" href="#qna-box">질문/답변</a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane container active" id="detail-box">
					<h4>상세정보 내용</h4>
					<p>"국민들이 수치감을 느끼잖아요. 예를 들면 부정부패를 하거나 아니면 무능하거나 이런 것들에 대해서는 국민들은 당장 자신의 일은 아니니까, 뭐, 인내할 수 있어요. 나중에 책임을 물을 수도 있지만. 하지만, 지금 벌어지는 일들을 보면 국민들 모두에게 수치심을 주잖아요. 자괴감. 아이고, 내가 저런 사람들한테 지배를 당했단 말이지? 이런 심리 상태인데 이게 지금 어떤 수를 쓰더라도 누그러지지 않습니다. 자존심이 상했잖아요."</p>
				</div>
				<div class="tabe pane container fade" id="review-box"></div>
				<div class="tabe pane container fade" id="qna-box"></div>
			</div>
		</div>
		<div class="col-6">
			<h3>기본 탭</h3>
			<ul class="nav nav-tabs nav-justified">
				<li class="nav-item"><a class="nav-link active">상세정보</a></li>
				<li class="nav-item"><a class="nav-link">사용후기</a></li>
				<li class="nav-item"><a class="nav-link">질문/답변</a></li>
			</ul>
		</div>
	</div>
</div>
</body>
</html>