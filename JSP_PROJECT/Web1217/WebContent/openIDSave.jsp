<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ include file="ssi.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [openIDSave.jsp]</title></head>
<body>
 <%
   //openIDSave.jsp문서 데이터출력목적이 아닙니다 
   String data=request.getParameter("userid"); 
   //msg="select * from guest where sabun=" + data ;
   msg="select count(*) as cnt from guest where sabun=" + data ;
   ST=CN.createStatement();
   RS=ST.executeQuery(msg);
   if(RS.next()==true){Gtotal=RS.getInt("cnt");}
   if(Gtotal>0){
	 System.out.println(data +" 사번 이미사용중입니다"); 
  %>	 
	<script type="text/javascript">
	  alert(<%=data%>+"번호는 사용중입니다");
	  location.href='openID2.jsp?idx='+"";
	  //opener.myform.sabun.value="";
	  //opener.myform.sabun.focus();
	  //self.close();
	</script> 
  <%		 
   }else{ 
	 System.out.println(data +" 사번 사용가능합니다");
  %>	 
   <script type="text/javascript">
    alert("사용가능한 아이디번호입니다");
    opener.myform.name.focus();
    opener.myform.sabun.value=<%=data%>;
    self.close();
   </script>
  <% } %>
</body>
</html>


















