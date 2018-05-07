<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="model.*"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Which CLASS do you want?</title>
<style>
.checked {
	color: orange;
}
</style>
<script>
	function upload() {
		if (form.opinion.value == "") {
			alert("내용을 입력하십시오.");
			form.opinion.focus();
			return false;
		} 
		if (form.rating.value == "") {
			alert("별점을 선택하십시오.");
			return false;
		} 
		if (form.evaluation.value == "") {
			alert("평가를 선택하십시오.");
			return false;
		} 
		form.submit();
	}
</script>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="container">
		<font size="50"><b>${param.title}</b></font>
		<table class="table table-bordered">
			<thead align="center">
				<tr align="center" bgcolor="#fed136">
					<th>학수번호</th>
					<th>분반</th>
					<th>이수영역</th>
					<th>담당교수</th>
					<th>요일</th>
					<th>교시</th>
				</tr>
			</thead>
			<c:forEach var="course" items="${searchList}">
				<tbody>
					<tr align="center">
						<td>${course.class_id}</td>
						<td>${course.division}</td>
						<td>${course.field}</td>
						<td>${course.prof_name}</td>
						<td><c:choose>
								<c:when test="${course.day1 eq course.day2 }">
									<c:choose>
										<c:when test="${course.day1 eq '1' }">월</c:when>
										<c:when test="${course.day1 eq '2' }">화</c:when>
										<c:when test="${course.day1 eq '3' }">수</c:when>
										<c:when test="${course.day1 eq '4' }">목</c:when>
										<c:otherwise>금</c:otherwise>
									</c:choose>
									</c:when>
								<c:otherwise>
									<c:if test="${course.day1 eq '1' }"><c:set var="day1" value="월"/></c:if>
									<c:if test="${course.day1 eq '2' }"><c:set var="day1" value="화"/></c:if>
									<c:if test="${course.day1 eq '3' }"><c:set var="day1" value="수"/></c:if>
									<c:if test="${course.day1 eq '4' }"><c:set var="day1" value="목"/></c:if>
									<c:if test="${course.day1 eq '5' }"><c:set var="day1" value="금"/></c:if>
									<c:if test="${course.day2 eq '1' }"><c:set var="day2" value="월"/></c:if>
									<c:if test="${course.day2 eq '2' }"><c:set var="day2" value="화"/></c:if>
									<c:if test="${course.day2 eq '3' }"><c:set var="day2" value="수"/></c:if>
									<c:if test="${course.day2 eq '4' }"><c:set var="day2" value="목"/></c:if>
									<c:if test="${course.day2 eq '5' }"><c:set var="day2" value="금"/></c:if>
		      						${day1} / ${day2}
		      					</c:otherwise>
							</c:choose></td>
						<td>${course.time1} / ${course.time2}</td>
					</tr>
					</tbody>
					<P align="right">
			<a class="btn btn-warning" href="<c:url value='/service/wish/insert'>
		  	<c:param name="course_id" value='${course.course_id}'/>
		  	<c:param name="class_id" value='${course.class_id}'/>
		  	<c:param name="day1" value='${course.day1}'/>
           	<c:param name="day2" value='${course.day2}'/>
           	<c:param name="time1" value='${course.time1}'/>
           	<c:param name="time2" value='${course.time2}'/>
           	<c:param name="stuDept" value='${student.deptID}'/>
		  	<c:param name="stu_id" value='${student.stuID}'/>
		  	</c:url>">담기</a>
		</P>
			</c:forEach>
					</table>
	</div>

	<div class="container">
		<table class="table table-bordered">
			<c:if test="${reviewFailed}">
				<script>
					alert('${exception.getMessage()}');
				</script>
			</c:if>
			<tr>
				<td><c:choose>
						<c:when test="${fn:length(reviewList) == 0}">
							아직 등록된 후기가 없습니다.
							</c:when>
						<c:otherwise>
							<font size="5"> 평균 별점 : <button type="button" class="btn btn-warning"> <%=request.getAttribute("avg")%></button><br>
								<%
									if ((int) request.getAttribute("good") == 0)
												out.print(" ");
											else
												out.print("<button type=\"button\" class=\"btn btn-warning\">" + request.getAttribute("good")+ "</button>명이 좋아한 강의 ");

											if ((int) request.getAttribute("soso") == 0)
												out.print(" ");
											else
												out.print("<button type=\"button\" class=\"btn btn-warning\">" + request.getAttribute("soso")+ "</button>" + "명이 그냥 그렇다고한 강의 ");
											if ((int) request.getAttribute("bad") == 0)
												out.print(" ");
											else
												out.print("<button type=\"button\" class=\"btn btn-warning\">" + request.getAttribute("bad")+ "</button>" + "명이 별로라고한 강의 ");
								%></font>
						</c:otherwise>
					</c:choose></td>
			</tr>
		</table>
	</div>
	<div class="container">
		<table class="table table-bordered">
			<c:choose>
				<c:when test="${fn:length(reviewList) == 0}"/>
				<c:otherwise>
					<thead>
						<tr bgcolor="#fed136">
							<th>수강생 후기</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="review" items="${reviewList}">
							<tr bgcolor="#f1f1f1">
								<td>anonymous&nbsp;
								<c:if test="${review.evaluation == '1' }">
								<font size="1"><mark>좋아요😁👍</mark></font>
								</c:if>
								<c:if test="${review.evaluation == '2' }">
								<font size="1"><mark>그냥 그래요😅 </mark></font>
								</c:if>
								<c:if test="${review.evaluation == '3' }">ant
								<font size="1"><mark>별로에요👎😐  </mark></font>
								</c:if>
								<c:if test="${student.stuID == review.stuID }">
								<a class="btn btn-warning" href="<c:url value='/service/review/delete' >
									<c:param name="course_id" value='${param.course_id}'/>
									<c:param name="class_id" value='${param.class_id}'/>
									<c:param name="title" value='${param.title}'/>
									<c:param name='stu_id' value='${student.stuID}'/>
 								</c:url>">삭제</a>
								</c:if></td>
							</tr>
							<tr>
								<td>${review.opinion}</td>
							</tr>

						</c:forEach>
				</c:otherwise>
			</c:choose>
			</tbody>
		</table>
	</div>
	<div class="container">
		<form name="form" method="post"
			action="<c:url value='/service/review/upload' />">
			<input type="hidden" name="course_id" value="${param.course_id}" />
			<input type="hidden" name="class_id" value="${param.class_id}" />
			<input type="hidden" name="title" value="${param.title}" />
			<input type="hidden" name="stu_id" value="${student.stuID}" />
			<table class="table table-bordered">
				<thead>
					<tr bgcolor="#fed136">
						<th>후기 작성</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td align="center">
							<input name="rating" type="radio" value="5" />
							<span class="fa fa-star checked"></span>
							<span class="fa fa-star checked"></span>
							<span class="fa fa-star checked"></span>
							<span class="fa fa-star checked"></span>
							<span class="fa fa-star checked"></span>&nbsp;&nbsp;

							<input name="rating" type="radio" value="4" />
							<span class="fa fa-star checked"></span>
							<span class="fa fa-star checked"></span>
							<span class="fa fa-star checked"></span>
							<span class="fa fa-star checked"></span>
							<span class="fa fa-star"></span>&nbsp;&nbsp;

							<input name="rating" type="radio" value="3" />
							<span class="fa fa-star checked"></span>
							<span class="fa fa-star checked"></span>
							<span class="fa fa-star checked"></span>
							<span class="fa fa-star"></span>
							<span class="fa fa-star"></span>&nbsp;&nbsp;
							
							<input name="rating" type="radio" value="2" />
							<span class="fa fa-star checked"></span>
							<span class="fa fa-star checked"></span>
							<span class="fa fa-star"></span>
							<span class="fa fa-star"></span>
							<span class="fa fa-star"></span>&nbsp;&nbsp;
							
							<input name="rating" type="radio" value="1" />
							<span class="fa fa-star checked"></span>
							<span class="fa fa-star"></span>
							<span class="fa fa-star"></span>
							<span class="fa fa-star"></span>
							<span class="fa fa-star"></span>&nbsp;&nbsp;
					
					<tr align="center">
						<td><input name="evaluation" type="radio" value="1" />좋아요😁👍&nbsp;
							<input name="evaluation" type="radio" value="2" />그냥 그래요😅&nbsp;
							<input name="evaluation" type="radio" value="3" />별로에요👎😐&nbsp;</td>
					</tr>
					<tr align="center">
						<br>
						<br>
						<td><textarea class="form-control" rows="5" name="opinion"></textarea></td>
					</tr>
					<tr align="right">
						<td><input type="button" value="등록" class="btn btn-warning"
							onClick="upload()"> <input type="button" value="뒤로가기"
							class="btn btn-warning" onClick="history.back(-2);"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<%@ include file="header.jsp"%>
	<%@ include file="footer.jsp"%>
</body>
</html>