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

<title>Modern Business - Start Bootstrap Template</title>

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

.t1{width: 10%;}
.t2{width: 60%;}
.t3{width: 10%;}
.t4{width: 10%;}
.t5{width: 10%;}

a:link{
	color: black;
}
a:visited{
	color: black;
}

.board{
	text-transform: uppercase;
}

.frm{
	width: 100%;
	
}

.contents{
	min-width: 540px;
}

.btn{
	float: right;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
var oEditors = [];
$(function(){
    nhn.husky.EZCreator.createInIFrame({
        oAppRef: oEditors,
        //textarea 의 ID
        elPlaceHolder: "contents",
        //SmartEditor2Skin.html 파일이 존재하는 경로
        sSkinURI: "${pageContext.request.contextPath}/resources/SE2/SmartEditor2Skin.html",  
        htParams : {
            // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
            bUseToolbar : true,             
            // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
            bUseVerticalResizer : true,     
            // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
            bUseModeChanger : true,         
            fOnBeforeUnload : function(){
                 
            }
        }
        
    });
   
    $("#save").click(function(){
        oEditors.getById["contents"].exec("UPDATE_CONTENTS_FIELD", ["수정"]);
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
		<h1 class="mt-4 mb-3 board">${board} Write</h1>

		<div class="row tablee">

			<form class="frm" id="frm" action="${board }Write" method="post">
				<div class="form-group">
					<input type="text"
						class="form-control" id="title" name="title" placeholder="제목을 입력하세요.">
				</div>
				<div class="form-group">
					<textarea class="form-control" rows="10" id="contents" name="contents"></textarea>
				</div>
				<div class="form-group">
					<input type="button" id="save" value="Write" class="btn btn-default">
				</div>
					
				<div>
					<input type="text" name="writer" value="IU" readonly="readonly">
				</div>
				
			</form>


		</div>

		
		
		
	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2018</p>
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
