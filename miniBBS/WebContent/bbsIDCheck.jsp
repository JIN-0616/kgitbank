<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="bbs_ssi.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사번 중복 체크</title>
<link rel="stylesheet" type="text/css" href="./css/InputCSS.css">

 <script type="text/javascript">
  function takeid(){
	  document.idform.id.value = opener.bbsForm.sabun.value;
  }
 </script>
</head>
<body onload="takeid()">
 <div align="center" >
  <table class="table1">
  <form name="idform" action="bbsIDSave.jsp">
   <tr>
   <td>아이디:</td> <td> <input type="text" name="id"></td>
   		   <td><input type="submit" value="중복확인"></td>
   </tr>  
  </form> 
  </table>
 </div> 
</body>
</html>