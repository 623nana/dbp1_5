<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Which CLASS do you want?</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value='/vendor/bootstrap/css/bootstrap.min.css' />"
	rel="stylesheet">

<!-- Custom fonts for this template -->
<link
	href="<c:url value='/vendor/font-awesome/css/font-awesome.min.css' />"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Kaushan+Script'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link href="<c:url value='/css/agency.min.css' />" rel="stylesheet">

</head>

<body id="page-top">

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger"
				href="<c:url value='/'/> ">Select Class!</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fa fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav text-uppercase ml-auto">
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="<c:url value='/' />">MAIN</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="<c:url value='/service/search' />">SEARCH</a></li>
					<c:choose>
						<c:when test="${sessionScope.student == null }">
							<li class="nav-item"><a class="nav-link js-scroll-trigger"
								href="<c:url value='/service/login/form' />">LOGIN</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link js-scroll-trigger"
								href="<c:url value='/service/wish/list' >
								<c:param name='stuId' value='${student.stuID}'/>
								</c:url>">WISH</a></li>
							<li class="nav-item"><a class="nav-link js-scroll-trigger"
								href="<c:url value='/service/mypage' >
								<c:param name='stuId' value='${student.stuID}'/>
								</c:url>">MYPAGE</a></li>
							<li class="nav-item"><a class="nav-link js-scroll-trigger"
								href="<c:url value='/service/logout' />">LOGOUT</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>