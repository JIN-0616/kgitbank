<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<!-- 선언시에는 절대 세미콜론을 찍으면 안됨 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[bookSave.jsp]</title>
 <style type="text/css">
   *{font-size: 20pt; font-weight: bold; }
   a{font-size: 20pt; font-weight: bold; color: blue; text-decoration: none;}
{font-size: 26pt; font-weight: bold; color: green; text-decoration: underline;}
 </style>
 <script type="text/javascript"> 
 </script>
</head>
<body>
	<!-- bookSave.jsp -->
	bookSave.jsp<p>
	<!-- 데이터받는 페이지이므로 단독실행시 error -->
	<!-- 데이터받는 I/O, SQL관련 입출력 발생시 try/catch시 에러예방 -->
	<%	
		try{
			String a=request.getParameter("title");
			String b=request.getParameter("pay");
			
			out.println("넘어온 제목 : "+ a +"<br>");
			out.println("넘어온 급여 : "+ Integer.parseInt(b)+"<p>");
		}catch(Exception e){
			System.out.println(e);
		}
	%>
	
	<a href="gugudan.jsp">[구구단]</a>
	<a href="bookjsp">[신규등록]</a>
	<a href="note.jsp">[note]</a>

</body>
</html>