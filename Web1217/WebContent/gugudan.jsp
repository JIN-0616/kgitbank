<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [gugudan.jsp]</title>  
  <style type="text/css">
    *{font-size:20pt; font-weight:bold;  font-family:  Segoe UI Symbol , comic Sans MS ;  }
    a{font-size:20pt; font-weight:bold; color:blue; text-decoration:none; }
{font-size:26pt; font-weight:bold; color:green; text-decoration:underline; }                
  </style>  
</head>
<body>
  <img src="images/bar.gif"><br>
  <img src="images/bar.gif"><br>
  <img src="images/bar.gif"><p> 
  
  <form method="get" action="gugudanSave.jsp">
    단입력:<input type="text" name="gugu">
    	   <input type="submit" value="구구단처리">
  </form>
 
</body>
</html>



















