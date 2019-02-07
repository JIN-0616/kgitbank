<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[gugudanSave.jsp]</title>
<style type="text/css">
	* {	font-size: 20pt;font-weight: bold;font-family: Segoe UI Symbol, comic Sans MS;}
	a {	font-size: 20pt;font-weight: bold;color: blue;text-decoration: none;}
 {font-size: 26pt;font-weight: bold;color: green;text-decoration: underline;}
</style>
</head>
<body>
	<c:catch var="msg">
	<c:set var="dan" value="${param.gugu}"/>
	  <c:if test="${dan != '' && dan!=null }"> <!-- && || -->
	    <c:if test="${dan>0 and dan<10}">	<!-- or and -->
	 	  <c:forEach var="i" begin="1" end="9" step="1"> <!-- 1씩증가 생략가능 -->
	        <c:if test="${i le 5}">
	      	  ${dan}*${i}=${dan*i}<br>
	      	</c:if>
	      </c:forEach>
	    </c:if>
	  </c:if>	
	</c:catch>
	<!--c:out value=""-->
	<!--에러이유--> ${msg}
<hr>
  <jsp:useBean id="dt" class="java.util.Date"/>
  <fmt:formatDate value="${dt}" type="date" pattern="yyyy년-MM월-dd일"/> <br>	
  <fmt:formatDate value="${dt}" type="time"/> <br>
  
  <fmt:formatNumber value="567000" type="currency" /><br>
  <fmt:formatNumber value="5671239870.678" pattern="##,###,###.##" /><br>
  <fmt:formatNumber value="5671239870" pattern="##,###,###" /><br>
  <fmt:formatNumber value="0.17" type="percent" /><br>

<%
 java.util.Date date = new java.util.Date();
 java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy년-MM월-dd일"); //권장
 String msg=sdf.format(date);
 out.println(msg+ "<br>");
 out.println(date.toLocaleString()); 
%>
	<p>
		<a href="index.jsp">[index]</a>
		<a href="gugudan.jsp">[구구단]</a>
		<a href="list.do">[전체출력]</a>	
</body>
</html>



















