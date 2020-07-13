<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>책 정보 등록 폼</h1>
	
	<h3>신규 책 정보를 입력하세요</h3>
	
	<form action="bookregister.jsp" method="post">
		<!--
			제목, 저자, 장르, 출판사, 가격, 할인가격, 입고수량을 입력받는 폼을 만드시오.
		-->
		<div>
			<label>Title</label>
			<div><input type="text" name="booktitle" /></div>
		</div>
		<div>
			<label>Writer</label>
			<div><input type="text" name="bookwriter" /></div>
		</div>
		<div>
			<label>Genre</label>
			<div>
				<select name="bookgenre">
					<option value="fiction">Fiction</option>
					<option value="Essay">Essay</option>
					<option value="Education">Education</option>
				</select>
			</div>
		</div>
		<div>
			<label>Publisher</label>
			<div><input type="text" name="bookpublisher" /></div>
		</div>
		<div>
			<label>Price</label>
			<div><input type="number" name="bookprice" /></div>
		</div>
		<div>
			<label>DiscountPrice</label>
			<div><input type="number" name="bookdiscountprice"/></div>
		</div>
		<div>
			<label>Stock</label>
			<div><input type="number" name="bookstock"></div>
		</div>
		<div>
			<button type="submit">등록</button>
		</div>
	</form>
</body>
</html>