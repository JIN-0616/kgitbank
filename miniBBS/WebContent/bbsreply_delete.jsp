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
 	int bbsNum =Integer.parseInt( request.getParameter("idx") );
 	int replyNum =Integer.parseInt( request.getParameter("num") );
 	
 	msg = "delete from bbsreply where br_num="+replyNum;
 	st = con.createStatement();
 	st.executeUpdate(msg);
 	
 	response.sendRedirect("bbsDetail.jsp?idx="+bbsNum);
 %>
 
 
</body>
</html>