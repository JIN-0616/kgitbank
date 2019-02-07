<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [guestList.jsp]</title>
  <style type="text/css">
    *{font-size:16pt; font-weight:bold;  font-family: Comic Sans MS ; }
    a{font-size:16pt; font-weight:bold; color:blue; text-decoration:none; }
{font-size:20pt; font-weight:bold; color:green; text-decoration:underline; }                
  </style>

  <script type="text/javascript">
 	function changeclear( ){
 		myform.keyword.value="";
 		myform.keyword.focus();
 	}//end
  </script>
 </head>
<body>

 <table width=900 border=1 cellspacing=0>  
  <tr  align="right">
    <td colspan=5> 레코드갯수:${GSearchTotal}/${Gtotal} &nbsp;&nbsp;</td>
  </tr>

  <tr bgcolor="yellow">
  	<th>행번호</th> <th>사 번</th> <th>이 름</th> <th>제 목</th> <th>급 여</th>
  </tr>

 <c:forEach var="bean" items="${naver}">
  <tr>
     <td> ${bean.getRn()} </td>
     <td> ${bean.getSabun()} </td>
     <td> ${bean.getName()} </td>
     <td><a href="Detail.do?idx=${bean.sabun}">${bean.title}</a><font style="font-size:12pt; color:red;"><c:if test="${bean.reply>0}">[${bean.reply}]</c:if></font>
      </td>
     							<!-- 직접접근해도 가능 -->
     <td> ${bean.getPay() } </td>
  </tr>   
 </c:forEach>
 
  <tr align="center">
   <td colspan="5">
 	<c:if test="${startpage>10}">
 	   <a href="List.do?pageNum=${startpage-10}${returnpage}">[이전]</a>
 	</c:if>
   
 	<c:forEach var="i" begin="${startpage}" end="${endpage}">
 	   <c:choose>
 	     <c:when test="${i==pageNUM}">
 	       <font style='font-size:24pt; color:red'>[${i}] </font> 
 	     </c:when>
 	     <c:otherwise> 
 	       <a href="List.do?pageNum=${i}${returnpage}">[${i}]</a>
 	     </c:otherwise>
 	   </c:choose>	
 	</c:forEach>
     
   <c:if test="${endpage<pagecount}">
	 <a href="List.do?pageNum=${startpage+10}${returnpage}">[다음]</a>
   </c:if>

   </td>
  </tr>
  
 <tr align="center">
  	<td colspan="5">
  	 <form name="myform" action="List.do">
  	 	검색 :
  	 	<select name="keyfield" onchange="changeclear();">
  	 	   <option value="" selected>전체검색</option>  	 	   
  	 	   <option value="name" <c:if test="${skey eq 'name'}">selected</c:if>>이름검색</option>
  	 	   <option value="title"<c:if test="${skey eq 'title'}">selected</c:if> >제목검색</option>
  	 	   <option value=""> 내용검색 </option>
  	 	</select>
  	 	<input type="text" name="keyword" value="${sval}"  size=10>
  	 	<input type="submit" value="검 색 "> 
  	 	<input type="button" value="index" onclick="location.href='index.jsp'">
  	 	<input type="button" value="등록" onclick="location.href='guest.jsp'">
  	 	<input type="button" value="login" onclick="location.href='login.jsp'"> 
  	 </form>
  	</td>
  </tr>
 </table> 

</body>
</html>
