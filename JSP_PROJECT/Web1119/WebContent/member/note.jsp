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
   	 //DOM�� Document object Model==>�������� ���� ��ü����
     window.open("popup.jsp","kg",
    		 "left=250, top=200, width=500, height=600,menubar=no,toolbar=no");   
   	 //window��������
   }//end
 </script> 
</head>
<body>
	<!-- note.jsp -->
	note.jsp����<p>
	<a href="#" onclick="info()">[popup]</a>
	<img src="images/ddd.gif" onclick="info()">

</body>
</html>