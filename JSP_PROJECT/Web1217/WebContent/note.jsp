<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [note.jsp]</title>
  <style type="text/css">
    *{font-size:20pt; font-weight:bold; }
    a{font-size:20pt; font-weight:bold; color:blue; text-decoration:none; }
{font-size:26pt; font-weight:bold; color:green; text-decoration:underline; }                
  </style>
  
  <script type="text/javascript">
    function info( ){
     //DOM모델 Document object Model==>웹브라우저적용 객체적용
      open("popup.jsp","kg","left=450,top=300,width=600,height=550");
    }//info end
  </script>
 
</head>
<body>
	 <!-- note.jsp -->
	 note.jsp <p>
	 <a  href="#" onclick="info()">[popup]</a>
	 <img src="images/image2.jpg" onclick="info()">
</body>
</html>





