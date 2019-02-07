<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[openID.jsp]</title>
 <style type="text/css">
   *{font-size: 16pt; font-weight: bold; }
   a{font-size: 16pt; font-weight: bold; color: blue; text-decoration: none;}   
 </style>
 <script type="text/javascript">
 	function send(){
 		subform.userid.value = opener.myform.sabun.value;
 	}
 </script>
</head>
<body bgcolor="yellow" onload="send()">
  <%
  	//String data = request.getParameter("sabun");
    //System.out.println(data);
    // 넘어올때 submit이 없으면 데이터를 넘겨받을수가 없음, 주의할것!!
    // action에 지정된 문서가 아니면 데이터 넘길수 없음 다른방법을 찾을것
  %>
	<p>
	<div align="center">
	<form name="subform" action="openIDSave.jsp">
	아이디: <input type="text" name="userid" >
			<input type="submit" value="중복확인">
			<span id="id_ch"></span><br>			
	</form>
	<img src="images/bar.gif" width=400> 
	</div>	
</body>
</html>