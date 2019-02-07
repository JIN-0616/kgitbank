<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>[loginAjax.jsp]</title>
	<style type="text/css">
		input, b{font-size: 20pt; font-weight: bold;}
		a{text-decoration: none;font-size: 20pt; font-weight: bold;}
 {color: red; font-size: 20pt; font-weight: bold;}
		#btnlogin{
		 font-size:26pt; font-weight: bold; 
		 background:"yellow"; height:120; 
		}
		
		#loading-mask{
		  display:none;
		  width:500px;
		  height:500px;
		}
	</style>

<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
		
		
<script type="text/javascript"> 
  $(function( ){ 
       $('#btnlogin').click( function( ){  
			$.ajax({
			  "url"  : "LoginAjax.do" ,
			  "type" : "get",
			  "data" : {UID: $('#userid').val(), UPWD: $('#pwd').val( )} ,
			  
			  "beforeSend": function( ){ 
					$('#loading-mask').show();
					$('#msgIN').empty();
					$('#loading-mask').html("<div align=center><img src='./images/ajax-loader.gif' width=500 height=250></div> ");
					$("#loading-mask").css("opacity","0.9").stop().animate({opacity:3},9000);	
				   }, 
			  
			  "success": function(data){
				setTimeout(function() {
					$('#loading-mask').fadeOut( );
					$('#msgIN').empty();
					$('#msg').html(data);
				}, 1000);
			  },
			  "error": function(data){$('#loading-mask').fadeOut(); }
			});
	   });
      //////////////////////////////////////////////////////////////////////////
	 
   });
</script>
</head>
<body>
	
<div id="msg" align="center">	
   <div id="msgIN">
	<table width="550" border="1" cellspacing="0">
	  <form name="myform" method="get">
		<tr>
			<td width=350> <b>userid: </b></td>
			<td> <input type="text" name="userid" id="userid"  value="hb"></td>
			
			<td rowspan=2 align="center">
			 <input type="button" id="btnlogin"  value="loginAjax"  >
			</td>
		</tr>
		
		<tr>
			<td width=350><b>userpw: </b> </td>
			<td>
			  <input type="text"  name="pwd" id="pwd" value="1234">       
			</td>
		</tr>
		</form>
	</table>
	</div>
	<div id="loading-mask"> </div>
</div>
	
   
   
</body>
</html>

