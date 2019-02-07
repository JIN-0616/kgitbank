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
  	setTimeout("location.href='guestList.jsp'", 3000) ;
  </script>
</head>

<jsp:include page="top.jsp"></jsp:include>
<body>
<%
	//response.addCookie(ck);
	Cookie[] my = request.getCookies();
	String data = "";
	if( my!=null){
		for(int i=0; i<my.length; i++){
			if(my[i].getName().equals("daum")){ // "" 안하면 데이터오류
				data = my[i].getValue();
			}
		}
	}else{
		//Cookie 가 null일경우
	}
%>

 <div align="center">
	 <img src="./images/gguri.png" width=450 height=400> <br>
	 <font color=blue> <%=data%>님 반갑습니다.</font>     
 </div>	
 <!-- indexCopy.jsp -->
</body>
</html>





