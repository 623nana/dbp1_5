<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Which CLASS do you want?</title>
</head>
<script>
function userCreate() {
	if (form.stuId.value == "") {
		alert("사용자 아이디를 입력하십시오.");
		form.stuId.focus();
		return false;
	} 
	if (form.passwd.value == "") {
		alert("비밀번호를 입력하십시오.");
		form.passwd.focus();
		return false;
	}
	if (form.passwd.value != form.passwd2.value) {
		alert("비밀번호가 일치하지 않습니다.");
		form.passwd2.focus();
		return false;
	}
	if (form.name.value == "") {
		alert("이름을 입력하십시오.");
		form.name.focus();
		return false;
	}
	form.submit();
}
</script>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<form name="form" method="post"
		action="<c:url value='/service/register' />">
		<div class="container">
			<c:if test="${registerFailed}">
				<font color="red"><c:out value="${exception.getMessage()}" /></font>
			</c:if>
			<div class="form-group" id="divStuId">
				<label for="inputId" class="col-lg-2 control-label">학번</label>
				<div class="col-lg-5">
					<input type="text" class="form-control" name="stuId"
						placeholder="학번을 입력하세요." maxlength="8">
				</div>
			</div>
			<div class="form-group" id="divPassword">
				<label for="inputPassword" class="col-lg-2 control-label">패스워드</label>
				<div class="col-lg-5">
					<input type="password" class="form-control" name="passwd"
						placeholder="패스워드" maxlength="20">
				</div>
			</div>
			<div class="form-group" id="divPasswordCheck">
				<label for="inputPasswordCheck" class="col-lg-2 control-label">패스워드
					확인</label>
				<div class="col-lg-5">
					<input type="password" class="form-control" name="passwd2"
						placeholder="패스워드 확인" maxlength="20">
				</div>
			</div>
			<div class="form-group" id="divName">
				<label for="inputName" class="col-lg-2 control-label">이름</label>
				<div class="col-lg-5">
					<input type="text" class="form-control onlyHangul" name="name"
						placeholder="이름을 입력하세요." maxlength="5">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPhoneNumber" class="col-lg-2 control-label">학과</label>
				<div class="col-lg-5">
					<select class="form-control" id="dept" name="deptID">
						<option>경영학과</option>
						<option>경제학과</option>
						<option>국사학과</option>
						<option>국어국문학과</option>
						<option>국제경영학과</option>
						<option>독일어과</option>
						<option>문예창작학과</option>
						<option>문헌정보학과</option>
						<option>사회복지학과</option>
						<option>아동학과</option>
						<option>영어과</option>
						<option>응용화학과</option>
						<option>일본어과</option>
						<option>정보통계학과</option>
						<option>중어중국학과</option>
						<option>컴퓨터학과</option>
						<option>큐레이터학과</option>
						<option>프랑스어과</option>
					</select>
				</div>
			</div>
			<div class="form-group" id="divEmail">
				<label for="inputEmail" class="col-lg-2 control-label">이메일</label>
				<div class="col-lg-5">
					<input type="email" class="form-control" name="email"
						placeholder="이메일" maxlength="40">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPhoneNumber" class="col-lg-2 control-label">흥미분야</label>
				<div class="col-lg-5">
					<select class="form-control" id="field1" name="field1">
						<option>글로벌여성과자기계발영역</option>
						<option>사회과학영역</option>
						<option>인문학영역</option>
						<option>자연과학영역</option>
						<option>창감영역</option>
					</select>
					<select class="form-control" id="field2" name="field2">
						<option>글로벌여성과자기계발영역</option>
						<option>사회과학영역</option>
						<option>인문학영역</option>
						<option>자연과학영역</option>
						<option>창감영역</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="button" value="회원가입" class="btn btn-warning"
						onClick="userCreate()"> &nbsp;
						<input type="button" value="뒤로가기" class="btn btn-warning"
						onClick="window.history.go(-1); return false;">
				</div>
			</div>
		</div>
	</form>
	<%@ include file="header.jsp"%>
	<%@ include file="footer.jsp"%>
</body>
</html>