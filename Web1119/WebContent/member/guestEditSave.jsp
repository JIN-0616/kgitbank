<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="./ssi.jsp" %>
<!-- ./ -> 현재폴더내 -->
<!-- 선언시에는 절대 세미콜론을 찍으면 안됨 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[gestEditSave.jsp]</title></head>
<body>
   <%
  	//guestSave.jsp
	//request.setCharacterEncoding("UTF-8");
		Gsabun = Integer.parseInt(request.getParameter("sabun"));
		Gname = request.getParameter("name");
		Gtitle = request.getParameter("title");
		Gpay= Integer.parseInt(request.getParameter("pay"));
	System.out.println("guestEditSave.jsp문서<br>");
	System.out.println("수정넘어온 사번 : "+ Gsabun +"<br>");
	System.out.println("수정넘어온 이름 : "+ Gname +"<br>");
	System.out.println("수정넘어온 제목 : "+ Gtitle +"<br>");
	System.out.println("수정넘어온 급여 : "+ Gpay +"<p>");
	
	msg="update guest set name=?,title=?,nalja=sysdate,pay=? where sabun=?";
	
	PST=CN.prepareStatement(msg); //데이터가 빠진 쿼리문명령어 미리서해석컴파일
		//데이터매칭연결 ? - 전역변수 연결
		PST.setString(1, Gname);
		PST.setString(2, Gtitle);
		PST.setInt(3, Gpay);
		PST.setInt(4, Gsabun);
	PST.executeUpdate(); // 매개인자 없음!!! 주의!!!
	
	
	System.out.println(Gsabun+"사번으로 guest테이블 PST명령어저장성공했습니다");
	response.sendRedirect("guestList.jsp"); //현재화면보이지않고 바로 이동 <-> a태그
	
  %>
  	<p>
	<a href="index.jsp">[index]</a>
	<a href="guest.jsp">[신규등록]</a>
	<a href="guestList.jsp">[전체출력]</a>
	<a href="ssi.jsp">[ssi]</a>
</body>
</html>