<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [test.jsp]</title>  
  <style type="text/css">
    *{font-size:20pt; font-weight:bold;  font-family:  Segoe UI Symbol , comic Sans MS ;  }
    a{font-size:20pt; font-weight:bold; color:blue; text-decoration:none; }
{font-size:26pt; font-weight:bold; color:green; text-decoration:underline; }                
  </style>  
</head>
<body>

 <hr size=5 color="red">
 <c:catch var="errMsg">
   <c:set var="su" value="${abc}"/>
 	<c:choose>
 	  <c:when test="${su>0}"> ${su} 양수입니다 </c:when>
 	  <c:when test="${su==0}"> ${su} 제로입니다 </c:when>
 	  <c:when test="${su<0}"> ${su} 음수입니다</c:when>
 	  <c:otherwise>${su} 숫자가 아닙니다</c:otherwise>
 	</c:choose>
 </c:catch>
 에러이유:<c:out value="${errMsg}" />
 
 
 
 <hr size=5 color="red">
 <c:set var="data" value="${5}"/>
 <c:choose>
 	<c:when test="${data%2==0}"> ${data} 짝수입니다</c:when>
 	<c:otherwise>${data} 홀수입니다</c:otherwise>
 </c:choose>
 
 <%
   int data=27;
   if(data%2==0){ } //짝수
   else{ }//홀수
 %>
 
 <hr size=5 color="red">
 <%
  int dan=7;
  try{
  for(int i=1; i<10; i++){
	 out.println(dan+"*"+i+"="+(dan*i)+"<br>");
  }
 }catch(Exception ex){}
%>

<hr>
 <c:catch>
 	<c:set var="dan" value="${3}" />
 	<c:forEach var="i" begin="1" end="9">
 		${dan}*${i}=${dan*i}<br>
 	</c:forEach>
 </c:catch>
 
 <hr>
 <h2> fmt </h2>
 
 <jsp:useBean id="date" class="java.util.Date"/>
 <fmt:formatDate value="${date}" type="date" pattern="yyyy-mm-dd hh:mm:ss"/>
 <fmt:formatDate value="${date}" type="time"/><br>
 <fmt:formatNumber value="50000" type="currency"></fmt:formatNumber><br>
 <fmt:formatNumber value="0.15" type="percent" /><br>
 <fmt:formatNumber value="50098760000" pattern="###,###"/><br>
 <fmt:formatNumber value="50009876000" pattern="###,###.##"/><br>
 <fmt:formatNumber value="50098760000" pattern="000,000.00" /><br>
 <!-- 
 
 2018-25-18 09:25:54 오후 9:25:54
 ￦50,000
 15%
 50,098,760,000
 50,009,876,000
 50,098,760,000.00
 
 -->
</body>
</html>



















