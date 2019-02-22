<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">JOHNNY</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/notice/noticeList">NOTICE</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/product/productList">SHOP</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/product/productList">EVENT</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                CS CENTER
              </a>
              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">
                <a class="dropdown-item" href="${pageContext.request.contextPath}/qna/qnaList">QNA</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/">DELIVERY</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/">ORDER/PAY</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/">RETURN</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/">ETC</a>
              </div>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Member
              </a>.
              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
              <c:choose>
              	<c:when test="${empty member }">
                <a class="dropdown-item" href="${pageContext.request.contextPath}/member/login">Login</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/member/insert">Join</a>
              	</c:when>
              	<c:otherwise>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/member/myPage">MyPage</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/member/logOut">Logout</a>
              	</c:otherwise>
              </c:choose>
              </div>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Other Pages
              </a>
              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
                <a class="dropdown-item" href="full-width.html">Full Width Page</a>
                <a class="dropdown-item" href="sidebar.html">Sidebar Page</a>
                <a class="dropdown-item" href="faq.html">FAQ</a>
                <a class="dropdown-item" href="404.html">404</a>
                <a class="dropdown-item" href="pricing.html">Pricing Table</a>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </nav>