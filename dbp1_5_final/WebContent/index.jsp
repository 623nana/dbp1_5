<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<body>
<c:if test="${registerOk}">
<script type="text/javascript">
				alert('회원가입을 축하합니다! 로그인을 해주세요!');
			</script>
</c:if>
	<!-- Header -->
	<header class="masthead">
		<div class="container">
			<div class="intro-text">
				<div class="intro-lead-in">당신에게 맞춤형 교양을 추천해드립니다!</div>
				<div class="intro-heading text-uppercase">Which CLASS do you want?</div>
				<c:choose>
					<c:when test="${sessionScope.student == null}">
						<a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger"
							href="<c:url value='/service/login/form' />">로그인</a>
						<a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger"
							href="<c:url value='/service/register/form' />">회원가입</a>
					</c:when>
					<c:otherwise>
						<a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger"
							href="<c:url value='/service/suggest' >
             					<c:param name='field1' value='${student.field1}'/>
             					<c:param name='field2' value='${student.field2}'/>
             					</c:url>">추천 강의</a>
						<a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger"
							href="<c:url value='/service/search' />">검색</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</header>

	<!-- Services -->
	<section id="ABOUT">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading text-uppercase">ABOUT</h2>
					<h3 class="section-subheading text-muted">당신에게 맞춤형 교양을 추천해드립니다!</h3>
				</div>
			</div>
			<div class="row text-center">
				<div class="col-md-4">
					<span class="fa-stack fa-4x"> <i
						class="fa fa-circle fa-stack-2x text-primary"></i> <i
						class="fa fa-search fa-stack-1x fa-inverse"></i>
					</span>
					<h4 class="service-heading">과목 검색</h4>
					<p class="text-muted">다양한 기준으로 과목을 검색해볼 수 있습니다!</p>
				</div>
				<div class="col-md-4">
					<span class="fa-stack fa-4x"> <i
						class="fa fa-circle fa-stack-2x text-primary"></i> <i
						class="fa fa-shopping-cart fa-stack-1x fa-inverse"></i>
					</span>
					<h4 class="service-heading">위시리스트</h4>
					<p class="text-muted">마음에 드는 강의를 위시리스트에 담아 시간표를 만들어보세요!</p>
				</div>
				<div class="col-md-4">
					<span class="fa-stack fa-4x"> <i
						class="fa fa-circle fa-stack-2x text-primary"></i> <i
						class="fa fa-laptop fa-stack-1x fa-inverse"></i>
					</span>
					<h4 class="service-heading">수강 후기</h4>
					<p class="text-muted">해당 과목을 수강한 학생들의 다양한 후기를 보거나, 직접 수강 후기를 등록할 수 있습니다!</p>
				</div>
			</div>
		</div>
	</section>

	<!-- Team -->
	<section class="bg-light" id="team">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading text-uppercase">Our Amazing Team</h2>
					<h3 class="section-subheading text-muted">KIMNAPARK</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<div class="team-member">
						<img class="mx-auto rounded-circle"
							src="<c:url value='/img/team/1.jpg'/>" alt="">
						<h4>나현정</h4>
						<p class="text-muted">20141051</p>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="team-member">
						<img class="mx-auto rounded-circle"
							src="<c:url value='/img/team/2.jpg'/>" alt="">
						<h4>김태성</h4>
						<p class="text-muted">20150984</p>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="team-member">
						<img class="mx-auto rounded-circle"
							src="<c:url value='/img/team/3.jpg'/>" alt="">
						<h4>박소연</h4>
						<p class="text-muted">20150991</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<span class="copyright">Copyright &copy; DATABASE PROGRAMING
						2017</span>
				</div>
			</div>
		</div>
	</footer>

	<%@ include file="./service/headerIdx.jsp"%>
	<%@ include file="./service/footer.jsp"%>
</body>

</html>