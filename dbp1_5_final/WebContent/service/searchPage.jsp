<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Which CLASS do you want?</title>
<script type="text/javascript">
function searchClass() {
	if (form.search.value == "") {
		alert("검색어를 입력하십시오.");
		form.search.focus();
		return false;
		}
	form.submit();
}
function selectEvent(selectObj) {
		if (selectObj == 5)
			location.href = "searchDay.jsp";
		if (selectObj == 6)
			location.href = "searchTime.jsp";
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
	<form name="form" class="form-search" method="post" action="<c:url value='/service/list' />">
		<div class="container">
			<div class="row">
				<div class="col-xs-6">
					<p>
						<select class="form-control" name="searchType"
							onChange="javascript:selectEvent(this.value);">
							<option value="1" ${param.sel=='1'?'selected':''} >과목명</option>
							<option value="2" ${param.sel=='2'?'selected':''} >교수명</option>
							<option value="3" ${param.sel=='3'?'selected':''}>학수번호</option>
							<option value="4" ${param.sel=='4'?'selected':''}>이수영역</option>
							<option value="5">요일</option>
							<option value="6">교시</option>
						</select>
					</p>
				</div>
				<div class="col-xs-4">
					&nbsp;&nbsp;<input type="text" name="search" class="input-large search-query" size="30"/>
				</div>
				<div class="col-xs-2">
					&nbsp;&nbsp;<input type="submit" value="SEARCH!" class="btn btn-warning"
						onClick="return searchClass()" /> 
				</div>
			</div>
		</div>
	</form>
	<%@ include file="header.jsp"%>
	<%@ include file="footer.jsp"%>
</body>
</html>