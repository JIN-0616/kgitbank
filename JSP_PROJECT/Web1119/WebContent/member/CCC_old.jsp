<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[note.jsp]</title>
 <style type="text/css">
   *{font-size: 20pt; font-weight: bold; font-family: comic sans ms;}
   a{font-size: 20pt; font-weight: bold; color: blue; text-decoration: none;}
{font-size: 26pt; font-weight: bold; color: green; text-decoration: underline;}
 </style> 
</head>
<body>
	 <!-- CCC.jsp -->
	 <img src="images/bar.gif"><br>
	 <img src="images/bar.gif"><br>
	 <img src="images/bar.gif"><p>
	 <img src="images/carousel4.png" width=583><br>
	 
	 <jsp:useBean id="sk" class="net.hb.common.Test"/>
	 <%
	 	String a = sk.getTitle();
	 	int b = sk.getCnt();
	 	out.println("제목="+a);
	 	out.println("나이="+b);
	 %>

</body>
</html>