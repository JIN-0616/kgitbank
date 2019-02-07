<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ include file="./ssi.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [loginList.jsp]</title></head>
<body>
 <%
  //lgoinList.jsp 단독실행하면 에러발생
  //select쿼리문 preparedStatement
  String a=request.getParameter("userid");
  String b=request.getParameter("pwd");
  msg="select count(*) as cnt from login where userid=? and pwd=?";
  PST=CN.prepareStatement(msg);
  	PST.setString(1, a);
  	PST.setString(2, b);
  RS=PST.executeQuery();
  if(RS.next()==true){ Gtotal=RS.getInt("cnt");}
  if(Gtotal>0){
	//세션설정.setAttribute( 가, 진짜id=a)
	//세션설정시간변경   web.xml
	//guestDetail.jsp문서에서 세션값출력 
	session.setAttribute("bank", a);
	response.sendRedirect("guestList.jsp");
	
	//세션내용주석처리후 쿠키 바로 적용 Cookie내장클래스
	//파일다운로드할때 response내장개체, 쿠키할때 response, request
	//쿠키추가할때 response개체필요
	
	Cookie ck=new Cookie("daum", a);//생성할때 인자 2개
	ck.setMaxAge(60); //60=1초
	ck.setMaxAge(0); //쿠키바로 소멸 
	response.addCookie(ck);
	response.sendRedirect("indexCopy.jsp");
	
  }else{
	System.out.println("로그인하세요 "); //자바스크립트로응용 
	response.sendRedirect("login.jsp");
  }
 %>
  
</body>
</html>


















