<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [index.jsp]</title>
  <style type="text/css">
    *{font-size:40pt; font-weight:bold;  font-family: comic Sans MS; }
  </style>
  
  <script type="text/javascript">
  	setTimeout("location.href='guestList.jsp'", 5000) ;
  </script>
</head>

<body>

<%
  //response.addCookie(ck);
  Cookie[] my= request.getCookies();
  String data="";
  if( my != null){
	for( int i=0; i<my.length; i++){
		if(my[i].getName().equals("daum")){
			data=my[i].getValue();
		}//if end
	}//for end
  }else{
	  
  }
%>
 <div align="center">
	<img src="./images/tulips.png" width=550 height=400> <br>
	<font color=blue> <%=data%> 반갑습니다 </font>     
 </div>	
 <!-- indexCopy.jsp  쿠키 -->
</body>
</html>





