<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="bbs_ssi.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Rsabun = Integer.parseInt( request.getParameter("b_sabun") );
	Rwriter = request.getParameter("writer");
	Rcontent = request.getParameter("content");
	
	msg = "insert into bbsreply values(bbsreply_seq.nextval,?,?,sysdate,?)";
	pst = con.prepareStatement(msg);
		pst.setString(1, Rwriter);
		pst.setString(2, Rcontent);
		pst.setInt(3, Rsabun);
	pst.executeUpdate();
	
	response.sendRedirect("bbsDetail.jsp?idx="+Rsabun);
%>

</body>
</html>