<%@ page language="java" contentType="text/html; charset=UTF-8"  %>

<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
  <style type="text/css">
  	 *{font-size:18pt;}
  	 p,div{
  	   font-size:20pt; font-weight:bold;
  	   padding:10px; width:700px; 
  	  }
  </style>
  
  <title>test_jQuery3.jsp</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 
  <script>
   jQuery(document).ready(function( ){ //람다식, 인라인함수
    	$('#asp').click(function(){
    		$('#asp').text("asp태그영역");
    		$('#asp').css({
    			"background-color":"yellow",
    			"color":"red",
    			"font-size":"34px"
    		});    		 
    	});
    });
    
    $(document).ready(function( ){ 
    	$('#jsp').click(function(){
    	   $('#jsp').text("jsp태그영역");
    	   $('#jsp').css("background-color", "pink");
    	   $('#jsp').css("color", "blue"); 
    	   $('#jsp').css("font-size", "34px"); 
    	});
    });
    
    $(document).ready(function( ){ 
    	$('#php').on("click",function(){
    	   $(this).text("php태그영역");
      	   $(this).css("background-color", "orange");
      	   $(this).css("color", "blue"); 
      	   $(this).css("font-size", "34px"); 
    	});
    });
    
    $(document).ready(function( ){ 
    	$('p').on("click",function(){
    	   $('p').text("p태그영역");
      	   $('p').css("background-color", "lightblue");
      	   $('p').css("color", "blue"); 
      	   $('p').css("font-size", "34px"); 
    	});
    });
    
    $(document).ready(function(){
    	$('#btnTitle').click(function(){
    		var name = $('#title').val();
    		alert(name);
    		$('#title').val().empty();
    	});
    });
  </script>
</head>
<body>
 <div id="asp">asp</div> 
 <div id="jsp">jsp</div> 
 <div id="php">php</div> 
 <p>p태그 </p>
 
 <hr size=5 color=red>
 
 <form>
 제목:<input type="text" id="title" value="snow">
      <input type="button" value="제목보기" id="btnTitle"></button>
</body>
</html>












