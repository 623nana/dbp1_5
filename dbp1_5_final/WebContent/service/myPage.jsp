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
function userUpdate() {
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

function userList(targetUri) {
	form.action = targetUri;
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
		action="<c:url value='/service/mypage' />">
		<div class="container">
			<c:if test="${registerFailed}">
				<font color="red"><c:out value="${exception.getMessage()}" /></font>
			</c:if>
			<div class="form-group" id="divStuId">
				<label for="inputId" class="col-lg-2 control-label">학번</label>
				<div class="col-lg-5">
					<input type="text" class="form-control" name="stuId"
						value="${student.stuID}" readonly maxlength="8">
				</div>
			</div>
			<div class="form-group" id="divPassword">
				<label for="inputPassword" class="col-lg-2 control-label">패스워드</label>
				<div class="col-lg-5">
					<input type="password" class="form-control" name="passwd"
						value="${student.password}" maxlength="20">
				</div>
			</div>
			<div class="form-group" id="divPasswordCheck">
				<label for="inputPasswordCheck" class="col-lg-2 control-label">패스워드
					확인</label>
				<div class="col-lg-5">
					<input type="password" class="form-control" name="passwd2"
						value="${student.password}" maxlength="20">
				</div>
			</div>
			<div class="form-group" id="divName">
				<label for="inputName" class="col-lg-2 control-label">이름</label>
				<div class="col-lg-5">
					<input type="text" class="form-control onlyHangul" name="name"
						value="${student.stuName}" maxlength="5">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPhoneNumber" class="col-lg-2 control-label">학과</label>
				<div class="col-lg-5">
					<select class="form-control" id="dept" name="deptID">
						<option ${student.deptID=='경영학과'?'selected':''}>경영학과</option>
						<option ${student.deptID=='경제학과'?'selected':''}>경제학과</option>
						<option ${student.deptID=='국사학과'?'selected':''}>국사학과</option>
						<option ${student.deptID=='국어국문학과'?'selected':''}>국어국문학과</option>
						<option ${student.deptID=='국제경영학과'?'selected':''}>국제경영학과</option>
						<option ${student.deptID=='독일어과'?'selected':''}>독일어과</option>
						<option ${student.deptID=='문예창작학과'?'selected':''}>문예창작학과</option>
						<option ${student.deptID=='문헌정보학과'?'selected':''}>문헌정보학과</option>
						<option ${student.deptID=='사회복지학과'?'selected':''}>사회복지학과</option>
						<option ${student.deptID=='아동학과'?'selected':''}>아동학과</option>
						<option ${student.deptID=='영어과'?'selected':''}>영어과</option>
						<option ${student.deptID=='응용화학과'?'selected':''}>응용화학과</option>
						<option ${student.deptID=='일본어과'?'selected':''}>일본어과</option>
						<option ${student.deptID=='정보통계학과'?'selected':''}>정보통계학과</option>
						<option ${student.deptID=='중어중국학과'?'selected':''}>중어중국학과</option>
						<option ${student.deptID=='컴퓨터학과'?'selected':''}>컴퓨터학과</option>
						<option ${student.deptID=='큐레이터학과'?'selected':''}>큐레이터학과</option>
						<option ${student.deptID=='프랑스어과'?'selected':''}>프랑스어과</option>
					</select>
				</div>
			</div>
			<div class="form-group" id="divEmail">
				<label for="inputEmail" class="col-lg-2 control-label">이메일</label>
				<div class="col-lg-5">
					<input type="email" class="form-control" name="email"
						value="${student.email}" maxlength="40">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPhoneNumber" class="col-lg-2 control-label">흥미분야</label>
				<div class="col-lg-5">
					<select class="form-control" id="field1" name="field1">
						<option ${student.field1=='글로벌여성과자기계발영역'?'selected':''}>글로벌여성과자기계발영역</option>
						<option ${student.field1=='사회과학영역'?'selected':''}>사회과학영역</option>
						<option ${student.field1=='인문학영역'?'selected':''}>인문학영역</option>
						<option ${student.field1=='자연과학영역'?'selected':''}>자연과학영역</option>
						<option ${student.field1=='창감영역'?'selected':''}>창감영역</option>
					</select>
					<select class="form-control" id="field2" name="field2">
						<option ${student.field2=='글로벌여성과자기계발영역'?'selected':''}>글로벌여성과자기계발영역</option>
						<option ${student.field2=='사회과학영역'?'selected':''}>사회과학영역</option>
						<option ${student.field2=='인문학영역'?'selected':''}>인문학영역</option>
						<option ${student.field2=='자연과학영역'?'selected':''}>자연과학영역</option>
						<option ${student.field2=='창감영역'?'selected':''}>창감영역</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="button" value="수정완료" class="btn btn-warning"
						onClick="userUpdate()"> &nbsp;
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