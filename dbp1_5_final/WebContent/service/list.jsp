<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Which CLASS do you want?</title>
</head>
<body>

<%@ include file="searchPage.jsp"%>
	<br>
	<div class="container">
		<c:if test="${InsertFailed}">
			<script type="text/javascript">
				alert('${exception.getMessage()}')
				history.back(-1);
			</script>
		</c:if>
		<c:if test="${InsertOk}">
			<script type="text/javascript">
				alert('위시리스트에 담았습니다!')
				history.back(-1);
			</script>
		</c:if>
		<c:if test="${searchNull}">
			<script type="text/javascript">
				alert('검색결과가 없습니다!')
				history.back(-1);
			</script>
		</c:if>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>학수번호</th>
					<th>분반</th>
					<th>이수영역</th>
					<th>과목명</th>
					<th>담당교수</th>
					<th>요일</th>
					<th>교시</th>
					<th></th>
				</tr>
			</thead>
			<c:forEach var="course" items="${searchList}">
				<tbody>
					<tr>
						<td>${course.course_id}</td>
						<td>${course.division}</td>
						<td>${course.field}</td>
						<td><a href="<c:url value='/service/course/view'>
		  	<c:param name="course_id" value='${course.course_id}'/>
		  	<c:param name="class_id" value='${course.class_id}'/>
		  	<c:param name="title" value='${course.title}'/>
		  	</c:url>">${course.title}</a></td>
						<td>${course.prof_name}</td>
						<td><c:choose>
								<c:when test="${ course.day1 eq course.day2 }">
									<c:choose>
										<c:when test="${course.day1 eq '1' }">월</c:when>
										<c:when test="${course.day1 eq '2' }">화</c:when>
										<c:when test="${course.day1 eq '3' }">수</c:when>
										<c:when test="${course.day1 eq '4' }">목</c:when>
										<c:otherwise>금</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<c:if test="${course.day1 eq '1' }"><c:set var="day1" value="월" /></c:if>
									<c:if test="${course.day1 eq '2' }"><c:set var="day1" value="화" /></c:if>
									<c:if test="${course.day1 eq '3' }"><c:set var="day1" value="수" /></c:if>
									<c:if test="${course.day1 eq '4' }"><c:set var="day1" value="목" /></c:if>
									<c:if test="${course.day1 eq '5' }"><c:set var="day1" value="금" /></c:if>
									<c:if test="${course.day2 eq '1' }"><c:set var="day2" value="월" /></c:if>
									<c:if test="${course.day2 eq '2' }"><c:set var="day2" value="화" /></c:if>
									<c:if test="${course.day2 eq '3' }"><c:set var="day2" value="수" /></c:if>
									<c:if test="${course.day2 eq '4' }"><c:set var="day2" value="목" /></c:if>
									<c:if test="${course.day2 eq '5' }"><c:set var="day2" value="금" /></c:if>
		      						${day1} / ${day2}
		      					</c:otherwise>
							</c:choose></td>
						<td>${course.time1} / ${course.time2}</td>
						<td><a class="btn btn-warning" href="<c:url value='/service/wish/insert'>
		  	<c:param name="course_id" value='${course.course_id}'/>
		  	<c:param name="class_id" value='${course.class_id}'/>
		  	<c:param name="day1" value='${course.day1}'/>
           	<c:param name="day2" value='${course.day2}'/>
           	<c:param name="time1" value='${course.time1}'/>
           	<c:param name="time2" value='${course.time2}'/>
           	<c:param name="stuDept" value='${student.deptID}'/>
		  	<c:param name="stu_id" value='${student.stuID}'/>
		  	</c:url>">담기</a></td></tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<%@ include file="header.jsp"%>
	<%@ include file="footer.jsp"%>
</body>
</html>