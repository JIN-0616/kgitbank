<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
 <title></title>
</head>
<body>
 <%
  String data=request.getParameter("title");
  if(data=="hb" || data.equals("hb")){
  %>
  	<font size=7 color=red>
  	 <b><%=data%> 네이버,다음 성공!!!!</b>
  	</font>
  	<br>
  	<img src="images/a4.png" width=250 height=50>
 <%	  
  }
 %>
</body>
</html>







