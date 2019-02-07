<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [guestreply.jsp]</title>
  <style type="text/css">
    *{font-size:20pt; font-weight:bold;  font-family:  Segoe UI Symbol , comic Sans MS ;  }
    a{font-size:20pt; font-weight:bold; color:blue; text-decoration:none; }
{font-size:26pt; font-weight:bold; color:green; text-decoration:underline; }
    #rsave{
      font-size:26pt; font-weight:bold; 
      background: #00FF00; height:150px;
    }                
  </style>
 </head>
<body>

<form action="Reply.do">
 <table  width=900 border=1 cellspacing=0 >
   <input type="hidden" name="sabun" value="${rsabun}"> 
   <input type="hidden" name="flag" value="true"> 
   <tr>
	 <td> <img src="images/x1.gif">저자:<img src="images/x1.gif"> </td>
	 <td> <input type="text" name="writer" size=25></td>
	 <td rowspan=2 align="center"><input type="submit" value="댓글저장" id="rsave" ></td>
	</tr>
		
	<tr>
		<td><img src="images/x1.gif">내용:<img src="images/x1.gif"> </td>
		<td><textarea cols=27 rows=3 name="content"></textarea></td>
	</tr>
 </table>
</form>

 <table  width=900 border=0 cellspacing=0 >
   <tr bgcolor="pink" align="center">
     <td colspan="4">댓글 데이터 출력 </td>
   </tr>  
 <c:forEach var="rbean" items="${rnaver}">  
   <tr>
    <td> ${rbean.num } </td>
    <td> ${rbean.writer} </td>
    <td> ${rbean.content}</td>
    <td align="right">
      <a href="ReplyDelete.do?idx=${rbean.num}&sabun=${rbean.sabun}" >[댓글삭제]</a>
      <a href="ReplyEdit.do?idx=${rbean.num}" >[댓글수정]</a>
    </td>
   </tr>
 </c:forEach>   

 </table>	
</body>
</html>












