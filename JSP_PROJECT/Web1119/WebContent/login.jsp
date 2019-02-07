<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [login.jsp]</title>
  <style type="text/css">
    *{font-size:20pt; font-weight:bold;  font-family:  Segoe UI Symbol , comic Sans MS ;  }
    a{font-size:20pt; font-weight:bold; color:blue; text-decoration:none; }
{font-size:26pt; font-weight:bold; color:green; text-decoration:underline; }
    #LOGIN{
      font-size:26pt; font-weight:bold;
      background: #00FF00; height: 120px;
    }             
  </style>
</head>

<body>
 <table  width=750 border=1 cellspacing=0 >
   <form action="loginList.jsp" method="post">
     <tr>
	  <td width="450"> <img src="images/x1.gif">userid:<img src="images/x1.gif"> </td>
	  <td width="250"> <input type="text" name="userid" ></td>
			
	   <td rowspan=2 align="center">
	    <input type="submit" value="LOGIN" id="LOGIN" >
	   </td>
	</tr>
	
	<tr>
	  <td> <img src="images/x1.gif">userpw:<img src="images/x1.gif"> </td>
	  <td> <input type="password" name="pwd" value="1234"></td>
	</tr>
    </form>
 </table>

</body>
</html>












