<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>start page</title>
<link rel="stylesheet" type="text/css" href="./css/InputCSS.css">

 <script type="text/javascript">
    //var t3 = document.getElementsById("txt").innerHTML;    
 	//var t2 = t3.replace("Loading... 3", "Loading... 2");
 	//function a1(){document.getElementsById("txt").innerHTML = t2};
 	//var count1 = setTimeout(a1(),1000);
 	//count1;
 	setTimeout("location.href='bbsList1.jsp'",2000);
 	//function timedText() {
 	//    var x = document.getElementById("txt");
 	//    setTimeout(function(){ x.value="2 seconds" }, 1000);
 	//    setTimeout(function(){ x.value="4 seconds" }, 2000);
 	//    setTimeout(function(){ x.value="6 seconds" }, 3000);
 	//}
 </script>
</head>
<jsp:include page="bbs_top.jsp"></jsp:include>
<body>
	<div align="center" onload="timedText()">
		<img src = "images/a5.png" width="400" height="300" alt="공사중페이지입니다"><br>
		<span id="txt">Loading... </span> 
	</div>
</body>
<jsp:include page="bbs_bottom.jsp"></jsp:include>
</html>