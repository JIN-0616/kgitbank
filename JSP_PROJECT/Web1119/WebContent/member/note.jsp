<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[note.jsp]</title>
 <style type="text/css">
   *{font-size: 20pt; font-weight: bold; }
   a{font-size: 20pt; font-weight: bold; color: blue; text-decoration: none;}
{font-size: 26pt; font-weight: bold; color: green; text-decoration: underline;}
 </style>
 
 <script type="text/javascript">
   function info(){
   	 //DOM모델 Document object Model==>웹브라우저 적용 객체적용
     window.open("popup.jsp","kg",
    		 "left=250, top=200, width=500, height=600,menubar=no,toolbar=no");   
   	 //window생략가능
   }//end
 </script> 
</head>
<body>
	<!-- note.jsp -->
	note.jsp문서<p>
	<a href="#" onclick="info()">[popup]</a>
	<img src="images/ddd.gif" onclick="info()">

</body>
</html>