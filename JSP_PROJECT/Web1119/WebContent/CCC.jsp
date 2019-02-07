<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [CCC.jsp]</title>
  <style type="text/css">
    *{font-size:26pt; font-weight:bold; font-family:comic Sans MS ;  }
    a{font-size:26pt; font-weight:bold; color:blue; text-decoration:none; }
{font-size:26pt; font-weight:bold; color:green; text-decoration:underline; }                
  </style>
  
</head>
<body>
  <!-- CCC.jsp -->
  <font color=blue>[CCC.jsp 아파치 commons 이용]</font><br>
  <form enctype="multipart/form-data" action="DDD.jsp" method="post">
         <input type="hidden" name="num" value="1123"> <br>
      제목: <input type="text" name="title" value="coffee"> <br>
      파일: <input type="file" name="file1" > <br>
        <input type="submit" value="DDD.jsp파일전송실습">
        <input type="reset" value="입력취소">
  </form>
</body>
</html>














