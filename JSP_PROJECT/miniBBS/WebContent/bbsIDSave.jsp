<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="bbs_ssi.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사번 중복 체크</title>
</head>
<body>
 <%
    request.setCharacterEncoding("UTF-8");
 	String temp = request.getParameter("id"); 	
  	msg = "select count(*) as cnt from bbs where b_sabun="+temp;
 	st = con.createStatement();
 	rs = st.executeQuery(msg);
	if(rs.next()){Gtotal = rs.getInt("cnt");} 	
 	if(Gtotal>0){
 		System.out.println(temp + "사번 중복입력 체크됨");
 %>		
 		<script type="text/javascript">
 		alert(<%=temp %> +"번호는 이미 사용중입니다.");
 		opener.bbsForm.sabun.value="";
 		opener.bbsForm.sabun.focus();
 		
 		var win = window.open("about:blank", "id");
 		win.close();
 		
 		</script>
 <%
 	}else{
 		System.out.println(temp + "사번 중복입력체크 통과됨");
 %>		
 		<script type="text/javascript">
 		alert(<%=temp %> +"번호는 사용가능합니다.");
 		opener.bbsForm.sabun.disabled = false;
 		opener.bbsForm.check.disabled = false;
 		opener.bbsForm.name.focus();
 	
 		var win = window.open("about:blank", "id");
 		win.close();
 		
 		</script>
 <%
 	}
 %>	
 
</body>
</html>