<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<!-- 선언시에는 절대 세미콜론을 찍으면 안됨 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[gugudan.jsp]</title>
 <style type="text/css">
   *{font-size: 20pt; font-weight: bold; }
   a{font-size: 20pt; font-weight: bold; color: blue; text-decoration: none;}
{font-size: 26pt; font-weight: bold; color: green; text-decoration: underline;}
 </style>
 <script type="text/javascript"> 
 </script>
</head>
<body>
	<!-- gugudan.jsp -->
	
	<% 
		out.println("구구단출력<br>");
		int dan=3;
		for(int i=1; i<10;i++){ 
			out.println(dan+"*"+i+"="+(dan*i)+"<br>");
		}
		
		out.print("<p>"); //웹브라우저 출력
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년-MM월-dd일");
		out.println("날짜1: "+dt.toLocaleString() + "<br>");		
		out.println("날짜1: "+sdf.format(dt));		
	%>
	<br>
	날짜2: <%= dt.toLocaleString() %> <br>
	날짜2: <%= sdf.format(dt) %>

</body>
</html>