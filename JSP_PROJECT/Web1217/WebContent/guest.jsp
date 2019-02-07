<%@ page language="java" contentType="text/html; charset=UTF-8"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [guest.jsp]</title>  
 <script type="text/javascript">

 </script>   
</head>

<jsp:include page="top.jsp"/>
<body>
	<font color=blue> [guest.jsp] </font><p>
	<form name="myform" action="Insert.do">
	   사번: <input type="text" name="sabun"> <br>
	   이름: <input type="text" name="name" value="LG"> <br>
	   제목: <input type="text" name="title" value="blue" > <br>
	   급여: <input type="text" name="pay"  value="97" > <p> 
	     <input type="submit" value="서브밋데이터저장">
	     <input type="reset"  value="입력취소">
	</form>
	
<p>
  <a href="index.jsp">[index]</a>
  <a href="Insert.do">[신규등록]</a>
  <a href="List.do">[전체출력]</a>
 
</body>
</html>













