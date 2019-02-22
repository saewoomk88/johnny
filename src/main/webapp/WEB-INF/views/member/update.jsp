<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Johnny 2019</title>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link
	href="${pageContext.request.contextPath}/resources/css/modern-business.css"
	rel="stylesheet">
<style type="text/css">

html{
	height: 100%;
}

body {
	position:relative;
	height: 100%;
}

.wrap {
	min-height: 100%;
	position: relative;
	
}

footer {
	width: 100%;
	position: static;
	bottom: 0;
}


a:link{
	color: black;
}
a:visited{
	color: black;
}

.board{
	text-transform: uppercase;
	text-align: center;
}

.frm{
	width: 50%;
	margin: 0 auto;
}

.contents{
	min-width: 540px;
}

.btn{
	float: right;
}

.tablee{
	border: 1px solid black;
}
.you{
	margin: 10px 0;
}
.you>div{
	display: inline-block;
	margin-left: 80px;
    width: 20%;
}

.button {
	float: left;
	border: 1px solid #ddd;
	font-size: 16px;
	padding: 0 12px;
	margin-top: 10px;
	margin-right: 10px;
}

.button:hover {
	border: 1px solid #000;
	cursor:pointer
}
 

</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
var oEditors = [];
$(function(){
   
   
    $("#save").click(function(){
      $("#frm").submit();
    });  
   
});
		
		
</script>
</head>

<body>

	<!-- Navigation -->
	<c:import url="../nav/nav.jsp"></c:import>
	<!-- Page Content -->
	<div class="container wrap">

		<!-- Page Heading/Breadcrumbs -->
		<h1 class="mt-4 mb-3 board">마이페이지</h1>

		<form action="./update" id="frm" method="post">
		<div class="tablee">
			<div class="you">
			<div>아이디</div><div><input type="text" readonly="readonly" name="id" value="${member.id}"></div>
			</div>
			<div class="you">
			<div>이름</div><div><input type="text" readonly="readonly" name="name" value="${member.name}"></div>
			</div>
			<div class="you">
			<div>주소</div><div><input type="text" name="address" value="${member.address}"></div>
			</div>
			<div class="you">
			<div>핸드폰</div><div><input type="number" name="phone" value="${member.phone}"></div>
			</div>
			<div class="you">
			<div>이메일</div><div><input type="email" name="email" value="${member.email}"></div>
			</div>
			<div class="you">
			<div>등급</div><div><input type="text" readonly="readonly" name="lv" value="${member.lv}"></div>
			</div>
		</div>
		
		<div class="button" id="save">
			
			<span>수정완료</span>
		
		</div>
		</form>
		
		
		
	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; 
				Johnny 2019</p>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
