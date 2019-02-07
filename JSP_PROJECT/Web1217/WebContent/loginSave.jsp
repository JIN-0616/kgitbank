<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ include file="./ssi.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [loginSave.jsp]</title></head>
<body>
 <%
  //lgoinSave.jsp 단독실행하면 에러발생
  //select쿼리문 preparedStatement
  
  //var url="loginSave.jsp?UID="+a+&UPWD="+b"
  String a=request.getParameter("UID");
  String b=request.getParameter("UPWD");
  msg="select count(*) as cnt from login where userid=? and pwd=?";
  PST=CN.prepareStatement(msg);
  	PST.setString(1, a);
  	PST.setString(2, b);
  RS=PST.executeQuery();
  if(RS.next()==true){ Gtotal=RS.getInt("cnt");}
  if(Gtotal>0){	
%>
  <font color=blue><b> <%=a%> Login Success!!! </b></font><p>
  <img src="images/bar.gif" width=750><br>
  <img src="images/bar.gif" width=750><br>
  <img src="images/bar.gif" width=750><br>
<%	
  }else{
	out.println("<font color=red><b>"+a+" Login Failed !!!</b></font><p>");
	out.println("<font color=red><b><a href=login.jsp>[login]</a></b></font><p>");
	out.println("<font color=red><b><a href=index.jsp>[index]</a></b></font><p>");
  }
 %>
 
</body>
</html>


















