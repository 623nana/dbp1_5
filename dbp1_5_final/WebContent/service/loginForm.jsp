<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Which CLASS do you want?</title>
<script>
function login() {
	if (form.stuId.value == "") {
		alert("사용자 ID를 입력하십시오.");
		form.stuId.focus();
		return false;
	} 
	if (form.passwd.value == "") {
		alert("비밀번호를 입력하십시오.");
		form.passwd.focus();
		return false;
	}		
	form.submit();
}
</script>
</head>
<body class="bg-dark">
	<br>
	<br>
	<br>
	<br>
	<div class="container">
		<div class="card card-login mx-auto mt-5">
			<div class="card-header">Login</div>
			<div class="card-body">
				<form name="form" method="POST" action="<c:url value='/service/login' />">
					<c:if test="${loginFailed}">
						<font color="red"><c:out value="${exception.getMessage()}" /></font>
					</c:if>
					<div class="form-group">
						<label for="exampleInputEmail1">학번</label> <input type="text"
							class="form-control" name="stuId" placeholder="학번을 입력하세요.">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">비밀번호</label> <input
							type="password" class="form-control" name="passwd"
							placeholder="비밀번호를 입력하세요.">
					</div>
					<input type="submit" value="LOGIN"
						class="btn btn-primary btn-block" onClick="login()">
				</form>
				<div class="text-center">
					<a class="d-block small mt-3"
						href="<c:url value='/service/register/form' />">회원가입</a> <a
						class="d-block small" href="javascript:history.back();">창닫기</a>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="header.jsp"%>
	<%@ include file="footer.jsp"%>
</body>
</html>