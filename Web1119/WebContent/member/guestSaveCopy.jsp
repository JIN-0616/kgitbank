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
  	//guestSave.jsp
	request.setCharacterEncoding("UTF-8");
	Gsabun = Integer.parseInt(request.getParameter("sabun"));
	Gname = request.getParameter("name");
	Gtitle=request.getParameter("title");
	Gpay= Integer.parseInt(request.getParameter("pay"));
	out.println("넘어온 사번 : "+ Gsabun +"<br>");
	out.println("넘어온 이름 : "+ Gname +"<br>");
	out.println("넘어온 제목 : "+ Gtitle +"<br>");
	out.println("넘어온 급여 : "+ Gpay +"<p>");
	
	msg="insert into guest values("+Gsabun+",'"+Gname+"','"+Gtitle+"',sysdate, "+Gpay+")";
	out.println(msg); 
	
	ST=CN.createStatement();
	ST.executeUpdate(msg);		
	System.out.println(Gsabun+"사번으로 guest테이블 저장성공했습니다");
	//response.sendRedirect("guestList.jsp"); //현재화면보이지않고 바로 이동 <-> a태그
	
  %>
  	<p>
	<a href="index.jsp">[index]</a>
	<a href="guest.jsp">[신규등록]</a>
	<a href="guestList.jsp">[전체출력]</a>
	<a href="ssi.jsp">[ssi]</a>
</body>
</html>