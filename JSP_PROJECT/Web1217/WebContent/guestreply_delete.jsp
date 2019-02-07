<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ include file="./ssi.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [guestreply_delete.jsp]</title></head>
<body>
 <%
  //guestreply_delete.jsp 댓글삭제
  int Dsabun=Integer.parseInt(request.getParameter("idx"));
  int Dnum=Integer.parseInt(request.getParameter("num"));
  msg="delete from guestreply where num=" + Dnum;
  ST=CN.createStatement();
  ST.executeUpdate(msg); 
  response.sendRedirect("guestDetail.jsp?idx="+Dsabun);
 %>
  
</body>
</html>


















