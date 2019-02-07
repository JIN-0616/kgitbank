<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [guestEdit.jsp]</title> </head>
<body>
	<font color=blue> [guestEdit.jsp] </font><p>
	<form name="myform" action="ReplyEdit.do">
	   수정사번: <input type="text" name="sabun" readonly value="${bean.sabun}" >  <br>
	   수정이름: <input type="text" name="name"  value="${bean.name}"> <br>
	   수정제목: <input type="text" name="title" value="${bean.title}" > <br>
	   수정급여: <input type="text" name="pay"  value="${bean.pay}" > <p> 
	      <input type="submit" value="서브밋데이터수정" >
	      <input type="reset"  value="수정취소">
	</form>	
<p>
  <a href="index.jsp">[index]</a>
  <a href="Insert.do">[신규등록]</a>
  <a href="List.do">[전체출력]</a>  
</body>
</html>













