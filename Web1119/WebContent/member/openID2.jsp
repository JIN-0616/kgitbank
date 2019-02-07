<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [openID2.jsp]</title>
  <style type="text/css">
    *{font-size:14pt; font-weight:bold; }             
  </style>
 
</head>
<body bgcolor="pink">
  <%
   String data=request.getParameter("idx");
  %>
 <p>
 <div align="center">
  <form name="subform" action="openIDSave.jsp">
     아이디:<input type="text" name="userid"  value="<%=data%>">
        <input type="submit" value="중복확인"> 
  </form>
  <img src="images/bar.gif" width=400>
 </div>	
</body>
</html>


