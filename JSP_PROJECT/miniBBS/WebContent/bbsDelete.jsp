<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="bbs_ssi.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int data = Integer.parseInt(request.getParameter("idx"));
	msg = "delete from bbs where b_sabun="+data;
	st = con.createStatement();
	st.executeUpdate(msg);
	response.sendRedirect("bbsList1.jsp");
	%>
</body>
</html>