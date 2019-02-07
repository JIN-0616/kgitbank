<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="ssi.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [guestDetail.jsp]</title>
  <style type="text/css">
    *{font-size:20pt; font-weight:bold;  font-family:  Segoe UI Symbol , comic Sans MS ;  }
    a{font-size:20pt; font-weight:bold; color:blue; text-decoration:none; }
{font-size:26pt; font-weight:bold; color:green; text-decoration:underline; }                
  </style>
 </head>
<body>
<%
 //guestDetail.jsp문서에 세션설정
  String my=(String)session.getAttribute("bank");
  session.invalidate(); //전체 세션 만료시킴
  System.out.println("설정세션이름 = "+my);
  
  my="detail";
   if( my==null || my=="" || my.equals("")){
%>	 
	<script type="text/javascript">
	  alert("로그인 정보가 없습니다");
	  location.href="login.jsp";  
	  //history.back();
	</script>
	   
<%	   
   }else{
  String data=request.getParameter("idx");
  msg="select * from guest where sabun = " + data;
  ST=CN.createStatement( );
  RS=ST.executeQuery(msg);
  RS.next(); //반드시  next()문밖에서 문안으로 진입 
  Gsabun=RS.getInt("sabun"); //삭제,수정,댓글 필요합니다 
%>

 <table  width=900 border=1 cellspacing=0 cellpadding=5>
  <tr align="center" bgcolor="yellow">
    <td colspan="2"> [<%= RS.getString("name") %>님] 상세정보출력 </td>
  <tr>
  
  <tr>
  	<td rowspan="4" align="center"> <img src="images/bear.gif" width=200 height=150> </td>
  	<td> 사 번:<%= RS.getInt("sabun") %> </td>
  </tr>
  
  <tr>
  	<td> 제 목: <%= RS.getString("title") %> </td>
  </tr>
  
  <tr>
  	<td> 날 짜:  <%= RS.getDate("nalja") %> </td>
  </tr>
  
  <tr>
  	<td> 급 여: <%= RS.getInt("pay") %> </td>
  </tr>
  
  <tr align="center">
   <td colspan="2">
       <a href="index.jsp">[index]</a>
       <a href="guest.jsp">[신규등록]</a>
       <a href="guestEdit.jsp?idx=<%=Gsabun%>">[수정]</a>
  	   <a href="guestList.jsp">[전체출력]</a>
  	   <a href="guestDeleteSave.jsp?idx=<%=Gsabun%>">[삭제]</a>
   </td>
  </tr>
 </table>
 	
 	
 <!-- guestDetail.jsp문서 맨마지막문단 -->
 <jsp:include page="guestreply.jsp">
 	<jsp:param  name="idx" value="<%=Gsabun%>" />
 </jsp:include>
 
 <% } %>
</body>
</html>




