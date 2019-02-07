<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="ssi.jsp" %>
<!-- ./ -> 현재폴더내 -->
<!-- 선언시에는 절대 세미콜론을 찍으면 안됨 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[gestListCopy.jsp]</title>
	<style type="text/css">
	*{margin: 8px;}
	</style>
</head>
<body>
  <%
  	msg="select count(*) as cnt from guest";
  	ST = CN.createStatement();
  	RS = ST.executeQuery(msg);
  	if(RS.next()==true){
  		Gtotal = RS.getInt("cnt");
  	}
	//전역변수이므로 어디서든지 사용가능함
	
	//전역변수선언은 <%! % --> 자동초기화됨
	
	//<% % ==> 여기서 선언된 변수는 지역변수 취급
  %>

  <table width=700 border=1 cellspacing=0>
   <tr align="right">
    <td colspan=5> 레코드갯수:<%= Gtotal %>&nbsp;&nbsp;</td>
   </tr>
   
   <tr bgcolor="yellow">
    <th>행번호</th><th>사 번</th><th>이 름</th><th>제 목</th><th>급 여</th>    
   </tr>
     
  <%	
	msg="select rownum rn, g.* from guest g order by sabun asc";
	ST = CN.createStatement();
	RS = ST.executeQuery(msg); //select쿼리문 실행은 excuteQuery(select~)
	while(RS.next()==true){
		Gsabun=RS.getInt("sabun");
		Gtitle=RS.getString("title");		
		
  %>
  <tr>  
    <td><%= RS.getInt("rn") %></td> 	
    <td><%= RS.getInt("sabun") %></td>    
    <td><%= RS.getString("name") %></td>
    <td><a href="guestDetail.jsp?idx=<%=Gsabun%>"><%= Gtitle %></a></td>
    <td><%= RS.getInt("pay") %></td>
  </tr>  
  <%
	}//while end
  %>
  </table>
  
  	<p>
	<a href="index.jsp">[index]</a>
	<a href="guest.jsp">[신규등록]</a>
	<a href="guestList.jsp">[전체출력]</a>
	<a href="ssi.jsp">[ssi]</a>
 
</body>
</html>