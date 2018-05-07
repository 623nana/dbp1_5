<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Which CLASS do you want?</title>
</head>
<body>
<%
	String[][] time = new String[6][5];
	time = (String[][])request.getAttribute("timeTable");
%>
<br><br><br><br><br><br>
	<div class="container">
 <table class="table table-bordered" width="1000">
  <thead>
      <tr align="center" bgcolor="#fed136">
      	<th></th>
        <th>월</th>
       <th>화</th>
       <th>수</th>
       <th>목</th>
       <th>금</th>
      </tr>
    </thead>
<% 
	for(int i = 0; i<6; i++){
		out.print("<tr align=\"center\">");
		for(int j = 0; j<5; j++){
			if(j==0)
				out.print("<td width=75 bgcolor=\"#fed136\"><b>" + (j+i+1) + "</b></td>");
			
			if(time[i][j]!=null){
				out.print("<td width=250>"+time[i][j]+"</td>");
				}else{
					out.print("<td width=250>&nbsp;</td>");
				}
					
			}
		out.print("</tr>");
		}
	
%>
</table>
</div>
	<%@ include file="header.jsp"%>
	<%@ include file="footer.jsp"%>
</body>
</html>