<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="./ssi.jsp" %>
<!-- ./ -> 현재폴더내 -->
<!-- 선언시에는 절대 세미콜론을 찍으면 안됨 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[gestSave.jsp]</title></head>
<body>
  <%
  	// guestDeleteSave.jsp 단독실행하면 에러발생
  	int data = Integer.parseInt(request.getParameter("idx"));
  	msg = "delete from guest where sabun="+data;
  	System.out.println(msg);
  	ST = CN.createStatement();
  	ST.executeUpdate(msg);
  	System.out.println(data+ " 번호 삭제성공");
  	response.sendRedirect("guestList.jsp");  	
	
  %>  	
</body>
</html>