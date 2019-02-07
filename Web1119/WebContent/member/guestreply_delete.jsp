<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="./ssi.jsp" %>
<!-- ./ -> 현재폴더내 -->
<!-- 선언시에는 절대 세미콜론을 찍으면 안됨 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[guestreply_delete.jsp]</title></head>
<body>
  <%
  	//guestreply_delete.jsp
  	//guestreply_delete.jsp?idx=<%=Rsabun>//&num=<%Rnum>
   int Dsabun = Integer.parseInt(request.getParameter("idx"));
   int Dnum = Integer.parseInt(request.getParameter("num"));
   msg="delete from guestreply where num="+Dnum;
   ST = CN.createStatement();
   ST.executeUpdate(msg);
   response.sendRedirect("guestDetail.jsp?idx="+Dsabun);
	
  %>
  	
</body>
</html>