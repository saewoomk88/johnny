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
html {
	height: 100%;
}

body {
	position: relative;
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

.t1 {
	width: 10%;
}

.t2 {
	width: 60%;
}

.t3 {
	width: 10%;
}

.t4 {
	width: 10%;
}

.t5 {
	width: 10%;
}

a:visited {
	color: black;
}
a:link{
	color: black;
}
a:hover {
	text-decoration: none;
} 

.title {
	max-width: 95%;
	min-width: 630px; border-bottom : 3px solid #000;
	padding-bottom: 10px;
	margin-left: -15px;
	border-bottom: 3px solid #000;
}

.title>h1 {
	display: inline-block;
}

.list {
	float: right;
	border: 1px solid #ddd;
	font-size: 25px;
	padding: 0 12px;
	margin-top: 30px;
}

.list:hover {
	border: 1px solid #000;
	
}

.contents {
	margin-top: 10px;
	margin-bottom: 100px;
	max-width: 95%;
	min-width: 630px;
}

.contents-title {
	width: 70%;
	text-align: center;
	font-size: 2.5em;
	font-weight: bold;
}

.contents-reg {
	width: 15%;
	text-align: right;
	margin: auto;
}

.contents-hit {
	width: 15%;
	text-align: center;
	margin: auto;
}

.contents-con {
	border-top: 1px solid #ddd;
	border-bottom: 1px solid #ddd;
	padding: 20px 0;
	font-size: 1.2em;
	text-align: center;
	width: 100%;
}

.board{
	text-transform: uppercase;
}
.button{
	float: left;
	border: 1px solid #ddd;
	font-size: 16px;
	padding: 0 12px;
	margin-top: 10px;
	margin-right: 10px;
}
.button:hover{
	border: 1px solid #000;
}


</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {

		$(".num").click(function() {
			location.href = $(this).children('a').attr('href');
		});
		
		var msg = '${param.msg}';
		if(msg != ''){
			alert(msg);
		}
	});
</script>
</head>

<body>

	<!-- Navigation -->
	<c:import url="../nav/nav.jsp"></c:import>
	<!-- Page Content -->
	<div class="container wrap">

		<!-- Page Heading/Breadcrumbs -->
		<div class="title col-lg">
			<h1 class="mt-4 board">${board}</h1>
			<div class="list"><a href="${board }List">List</a></div>

		</div>
		<div class="row contents">

			<div class="contents-title">${dto.title}</div>
			<div class="contents-reg">${dto.reg_date}</div>
			<div class="contents-hit">${dto.hit}</div>
			<div class="contents-con">${dto.contents}</div>
			<div class="button"><a href="${board }Update?num=${dto.num}">Update</a></div>
			<div class="button"><a href="${board }Delete?num=${dto.num}">Delete</a></div>
		</div>





		<div class="row">
		<c:if test="${board eq 'notice' }">
			<table class="table table-responsive">
				<thead>
					<tr>
						<th class="t1">Num</th>
						<th class="t2">Subject</th>
						<th class="t3">Name</th>
						<th class="t4">Date</th>
						<th class="t5">Hit</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="notice">

						<tr class="tr">
							<td>${notice.num}</td>
							<td class="num"><a href="${board}Select?num=${notice.num}">${notice.title}</a></td>
							<td>${notice.writer }</td>
							<td>${notice.reg_date }</td>
							<td>${notice.hit}</td>
						</tr>

					</c:forEach>

				</tbody>
			</table>
		</c:if>


		</div>

		<!-- Pagination -->

		<div class="button">
			<a href="${board}Write"><span>Write</span></a>
		</div>
		<c:if test="${board ne 'notice' }">
		<div class="button">
			<a href="${board}Reply?num=${dto.num}"><span>Reply</span></a>
		</div>
		</c:if>
		<c:if test="${board eq 'notice' }">
		<ul class="pagination justify-content-center">
			<c:if test="${pager.curBlock>1}">
				<li class="page-item"><a class="page-link"
					href="./${board}Select?num=${dto.num}&curPage=${pager.startNum-1}"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						<span class="sr-only">Previous</span>
				</a></li>
			</c:if>
			<c:forEach begin="${pager.startNum }" end="${pager.lastNum }" var="i">
				<li class="page-item"><a class="page-link"
					href="./${board }Select?num=${dto.num}&curPage=${i}">${i }</a></li>
			</c:forEach>
			<c:if test="${pager.curBlock<pager.totalBlock }">
				<li class="page-item"><a class="page-link"
					href="${board }Select?num=${dto.num}&curPage=${pager.lastNum+1}" aria-label="Next">
						<span aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
				</a></li>
			</c:if>
		</ul>
		</c:if>
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
