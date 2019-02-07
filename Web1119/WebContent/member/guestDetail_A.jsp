<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="ssi.jsp" %>
<!-- ./ -> 현재폴더내 -->
<!-- 선언시에는 절대 세미콜론을 찍으면 안됨 -->
<jsp:include page="top.jsp"></jsp:include>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[gestDetail.jsp]</title>
 <style type="text/css">
    *{font-size:20pt; font-weight:bold;  font-family:  Segoe UI Symbol , comic Sans MS ;  }
    a{font-size:20pt; font-weight:bold; color:blue; text-decoration:none; }
{font-size:26pt; font-weight:bold; color:green; text-decoration:underline; }                
  </style>
</head>
<body>
<%	// guestDetail.jsp (단독실행금지, 실행시 에러)
	String data = request.getParameter("idx");
	System.out.println("넘어온 idx = "+ data);
	msg = "select * from guest where sabun = "+data;
	System.out.println(msg);
	ST = CN.createStatement();
	RS = ST.executeQuery(msg);
	RS.next(); // 반드시 next()문밖에서 문안으로 진입
			   // 한건, 단독실행일시에는 while문 사용안하고 바로 사용가능
			   
	Gsabun=RS.getInt("sabun"); //삭제 수정 댓글 구현에 필요
%>
  <table align="center" width=700 border=1 cellspacing=0 cellpadding=20>
   <tr align="center">
    <td colspan=2> [ <%= RS.getString("name")%> 님의 상세정보출력 ]</td>
   </tr> 
   <tr>
    <td rowspan=4 align="center"> <img src="images/bbb.gif" width=200 height=200></td>
    <td>사번 : <%= RS.getInt("sabun") %> </td>
   </tr>
   <tr>
   	<td>제목 : <%= RS.getString("title") %> </td>
   </tr>  
   <tr>
   	<td>날짜 : <%= RS.getDate("nalja") %> </td>   	
   </tr>  
   <tr>
   	<td>급여 : <%= RS.getInt("pay") %></td>
   </tr>  
   <tr align="center">
    <td colspan=4>
    <a href="index.jsp">[index]</a>
	<a href="guest.jsp">[신규등록]</a>
	<a href="guestEdit.jsp?idx=<%=Gsabun%>">[수정]</a>
	<a href="guestList.jsp">[전체출력]</a>
	<a href="ssi.jsp">[ssi]</a>
	<a href="guestDeleteSave.jsp?idx=<%=Gsabun%>">[삭제]</a>
	</td>
   </tr>
  </table>
  
  
</body>
</html>