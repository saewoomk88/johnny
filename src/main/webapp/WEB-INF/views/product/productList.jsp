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
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

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

.t1 {	width: 10%;}

.t2 {	width: 60%;}

.t3 {	width: 10%;}

.t4 {	width: 10%;}

.t5 {	width: 10%;}

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

.search{
	float: right;
	padding: 0 12px;
	margin-top: 30px;
	
}
.search-input{
	width: 200px;
	display: inline-block;
}
a:link {
	color: black;
}

a:visited {
	color: black;
}

a:hover {
	text-decoration: none;
} 



.board {
	text-transform: uppercase;
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
}

#kind{
	display: inline-block;
	width: 85px;
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
			<h1 class="mt-4 board"><a href="${board}List">${board}</a></h1>

			<form class="search">
				<div>
					<select id="kind" name="kind" class="form-control">
						<option value="title">제목</option>
						<option value="contents">내용</option>
					</select> 
					<input type="text" class="form-control search-input" placeholder="Search"
						name="search">
				</div>
			</form>
		</div>


		 <div class="row">
    <div class="col-lg-4 col-sm-6 mb-4">
      <div class="card h-100">
        <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
        <div class="card-body">
          <h4 class="card-title">
            <a href="#">Project One</a>
          </h4>
          <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur eum quasi sapiente nesciunt? Voluptatibus sit, repellat sequi itaque deserunt, dolores in, nesciunt, illum tempora ex quae? Nihil, dolorem!</p>
        </div>
      </div>
    </div>
    <div class="col-lg-4 col-sm-6 mb-4">
      <div class="card h-100">
        <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
        <div class="card-body">
          <h4 class="card-title">
            <a href="#">Project Two</a>
          </h4>
          <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>
        </div>
      </div>
    </div>
    <div class="col-lg-4 col-sm-6 mb-4">
      <div class="card h-100">
        <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
        <div class="card-body">
          <h4 class="card-title">
            <a href="#">Project Three</a>
          </h4>
          <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quos quisquam, error quod sed cumque, odio distinctio velit nostrum temporibus necessitatibus et facere atque iure perspiciatis mollitia recusandae vero vel quam!</p>
        </div>
      </div>
    </div>
    <div class="col-lg-4 col-sm-6 mb-4">
      <div class="card h-100">
        <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
        <div class="card-body">
          <h4 class="card-title">
            <a href="#">Project Four</a>
          </h4>
          <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>
        </div>
      </div>
    </div>
    <div class="col-lg-4 col-sm-6 mb-4">
      <div class="card h-100">
        <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
        <div class="card-body">
          <h4 class="card-title">
            <a href="#">Project Five</a>
          </h4>
          <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>
        </div>
      </div>
    </div>
    <div class="col-lg-4 col-sm-6 mb-4">
      <div class="card h-100">
        <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
        <div class="card-body">
          <h4 class="card-title">
            <a href="#">Project Six</a>
          </h4>
          <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque earum nostrum suscipit ducimus nihil provident, perferendis rem illo, voluptate atque, sit eius in voluptates, nemo repellat fugiat excepturi! Nemo, esse.</p>
        </div>
      </div>
    </div>
  </div>
  <!-- /.row -->

		<!-- Pagination -->

		<div class="button">
			<a href="${board}Write"><span>Write</span></a>
		</div>
		<ul class="pagination justify-content-center">
			<c:if test="${pager.curBlock>1}">
				<li class="page-item"><a class="page-link"
					href="./${board}List?curPage=${pager.startNum-1}&search=${pager.search}&kind=${pager.kind}"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						<span class="sr-only">Previous</span>
				</a></li>
			</c:if>
			<c:forEach begin="${pager.startNum }" end="${pager.lastNum }" var="i">
				<li class="page-item"><a class="page-link"
					href="./${board }List?curPage=${i}&search=${pager.search}&kind=${pager.kind}">${i }</a></li>
			</c:forEach>
			<c:if test="${pager.curBlock<pager.totalBlock }">
				<li class="page-item"><a class="page-link"
					href="${board }List?curPage=${pager.lastNum+1}&search=${pager.search}&kind=${pager.kind}" aria-label="Next">
						<span aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
				</a></li>
			</c:if>
		</ul>

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
