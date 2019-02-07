<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="ssi.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[guestEdit.jsp]</title>
 <style type="text/css">
   *{font-size: 20pt; font-weight: bold; font-family: comic sans MS; }
   a{font-size: 20pt; font-weight: bold; color: blue; text-decoration: none;}
{font-size: 26pt; font-weight: bold; color: green; text-decoration: underline;}
 </style> 
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>

  <%
  	int data = Integer.parseInt(request.getParameter("idx"));
  	msg = "select * from guest where sabun="+data;
  	ST = CN.createStatement();
  	RS = ST.executeQuery(msg);
  	if(RS.next()){
  		Gsabun = RS.getInt("sabun");
  		Gname = RS.getString("name");
  		Gtitle = RS.getString("title");
  		Gpay = RS.getInt("pay");
  	}
  %>
	<font color=blue> [guestEdit.jsp]</font><p>	
	
	<form name="myform" action="guestEditSave.jsp">
		수정사번: <input type="text" name="sabun" disabled="disabled" value=<%=Gsabun%>><p>
		수정이름: <input type="text" name="name" value=<%=Gname%>><p>
		수정제목: <input type="text" name="title" value=<%=Gtitle%>><p>
		수정급여: <input type="text" name="pay" value=<%=Gpay%>><p>
			<input type="submit" value="서브밋데이터전송">
			<input type="reset" value="취소"><p>
	</form>
	
	<p>
	<a href="index.jsp">[index]</a>
	<a href="guest.jsp">[신규등록]</a>
	<a href="guestList.jsp">[전체출력]</a>
	<a href="ssi.jsp">[ssi]</a>

</body>
</html>