<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


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

 <table  width=900 border=1 cellspacing=0 cellpadding=5>
  <tr align="center" bgcolor="yellow">
    <td colspan="2"> [${bean.name}님] 상세정보출력 </td>
  <tr>
  
  <tr>
  	<td rowspan="4" align="center"> <img src="images/bear.gif" width=200 height=150> </td>
  	<td> 사 번: ${bean.sabun } </td>
  </tr>
  
  <tr><td> 제 목: ${bean.title } </td> </tr>
  <tr><td> 날 짜: ${bean.nalja } </td>  </tr>
  <tr><td> 급 여: ${bean.pay } </td>  </tr>
  
  <tr align="center">
   <td colspan="2">
       <a href="index.jsp">[index]</a>
       <a href="Insert.do">[신규등록]</a>
       <a href="preEdit.do?idx=${bean.sabun}">[수정]</a>
  	   <a href="List.do">[전체출력]</a>
  	   <a href="Delete.do?idx=${bean.sabun}">[삭제]</a>
   </td>
  </tr>
 </table>
 	
 	
 <!-- guestDetail.jsp문서 맨마지막문단 -->
 <jsp:include page="guestreply.jsp"/>

 
</body>
</html>




