<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Which CLASS do you want?</title>
<script type="text/javascript">
	function selectEvent(selectObj) {
		if (selectObj == 1)
			location.href = "searchPage.jsp?sel=1";
		else if (selectObj == 2)
			location.href = "searchPage.jsp?sel=2";
		else if (selectObj == 3)
			location.href = "searchPage.jsp?sel=3";
		else if (selectObj == 4)
			location.href = "searchPage.jsp?sel=4";
		else
			location.href = "searchDay.jsp";
	}
	function search() {
		
		var chk = false;
		var chkLen = 0;
		for(var i = 0; i<6; i++){
			if(document.form.time[i].checked==true){
				chk = true;
				chkLen++;
			}
		}
		
		if(chkLen >= 3){
			alert('3개이상은 선택할 수 없습니다!');
			return false;
		}
		if(chk==true){
			form.submit();
		}else{
			alert('시간을 선택하세요!');
		}
	}
</script>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<form name="form" class="form-search" method="post"
		action="<c:url value='/service/list' />">
		<div class="container">
			<div class="row">
				<div class="col-xs-6">
					<p>
						<select class="form-control" name="searchType"
							onChange="javascript:selectEvent(this.value);">
							<option value="1">과목명</option>
							<option value="2">교수명</option>
							<option value="3">학수번호</option>
							<option value="4">이수영역</option>
							<option value="5">요일</option>
							<option value="6" selected>교시</option>
						</select>
					</p>
				</div>
				&nbsp;
				<div class="col-xs-4">
					<p>
						<input type="checkbox" name="time" value="1"> 1 &nbsp;
						<input type="checkbox" name="time" value="2"> 2 &nbsp;
						<input type="checkbox" name="time" value="3"> 3 &nbsp;
						<input type="checkbox" name="time" value="4"> 4 &nbsp;
						<input type="checkbox" name="time" value="5"> 5 &nbsp;
						<input type="checkbox" name="time" value="6"> 6 &nbsp;
					</p>
				</div>
				<div class="col-xs-2">
					<p>
						<input type="button" class="btn btn-warning" onClick="search()" value="SEARCH!" />
					</p>
				</div>
			</div>
		</div>
	</form>
	<%@ include file="header.jsp"%>
	<%@ include file="footer.jsp"%>
</body>
</html>