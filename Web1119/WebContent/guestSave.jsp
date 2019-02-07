<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ include file="./ssi.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [guestSave.jsp]</title></head>
<body>
 <%
  //guestSave.jsp 단독실행하면 에러발생
  //Statement명령어대신   preparedStatement
  Gsabun=Integer.parseInt(request.getParameter("sabun"));
 msg="select count(*) as cnt from guest where sabun=?";
 //ST=CN.createStatement();
 //RS=ST.executeQuery(msg);
 PST=CN.prepareStatement(msg);
  PST.setInt(1, Gsabun);
 RS=PST.executeQuery();
 RS.next();
 Gtotal=RS.getInt("cnt"); 
 if(Gtotal>0){
 %>
  <script type="text/javascript">
    alert(<%=Gsabun%>+ "데이터가 중복되었습니다.");
    location.href="guest.jsp";
    //history.back();
  </script>
 <%	 
  }else{
 ///////////////////////////////////////////////////
   Gname=request.getParameter("name");
   Gtitle=request.getParameter("title");
   Gpay=Integer.parseInt(request.getParameter("pay"));
    
   msg="insert into guest values(?,?,?,sysdate,?)";
   PST=CN.prepareStatement(msg); //데이터가 빠진 쿼리문명령어 미리서해석컴파일
   	   PST.setInt(1,Gsabun);
   	   PST.setString(2,Gname);
   	   PST.setString(3, Gtitle);
   	   PST.setInt(4,Gpay);
   PST.executeUpdate(); //executeUpdate(X매개인자없음) 매개인자있으면 실행중 에러발생
		   
   System.out.println(Gsabun+ "사번으로 guest테이블  PST명령어 저장성공했습니다 ");
   response.sendRedirect("guestList.jsp"); //현재화면보이지않고 바로 이동
  }
 %>
  
</body>
</html>


















