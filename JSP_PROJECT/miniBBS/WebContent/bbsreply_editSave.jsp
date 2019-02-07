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
    int num=Integer.parseInt(request.getParameter("num"));	
	String writer=request.getParameter("writer");
	String content=request.getParameter("content");
	int sabun=Integer.parseInt(request.getParameter("sabun"));
	System.out.println("guestreply_edit.jsp "+ num +" "+ writer+" "+ content +" " +sabun);
	
	msg = "update bbsreply set br_writer=?,br_content=? where br_num=? and br_sabun=?";
	pst = con.prepareStatement(msg);
    	pst.setString(1, writer);
    	pst.setString(2, content);
    	pst.setInt(3, num);
    	pst.setInt(4, sabun);
   	pst.executeUpdate();   	
 %>
 	<script type="text/javascript">
 	window.close(); 	
 	</script>
</body>
</html>