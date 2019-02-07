<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글수정</title>
<link rel="stylesheet" type="text/css" href="css/InputCSS.css" >
 <script type="text/javascript">
function check() {
	var a = rform.writer.value;
	if (a = null || a == "") {
		document.getElementById("lw").innerHTML = "<font color=red>필수항목입니다.</font>";
		rform.writer.focus();
		document.getElementById("sub").disabled = true;
		return false;
	} else {
		document.getElementById("lw").innerHTML = "";
		rform.content.focus();
		document.getElementById("sub").disabled = false;

	}
}
function check2() {
	if (!rform.content.value.replace(/(^\s*)|(\s*$)/gi, "")) {
		//alert("textarea is null!!");
		document.getElementById("lw").innerHTML = "<font color=red>필수항목입니다.</font>";
		rform.content.focus();
		document.getElementById("sub").disabled = true;
		return;
	} else {
		document.getElementById("lw").innerHTML = "";
		document.getElementById("sub").disabled = false;
	}
}
	</script>
</head>
<body>
 <%
	/* 
	int num=Integer.parseInt(request.getParameter("num"));	
	String writer=request.getParameter("writer");
	String content=request.getParameter("content");
	int sabun=Integer.parseInt(request.getParameter("sabun"));
	System.out.println("bbsreply_edit.jsp "+ num +" "+ writer+" "+ content +" " +sabun); 
	*/
 %>
 
 <div class="all" align="center"> 
 	<div class="title"><br>댓 글 수 정</div> 	
 	<form name="rform" action="ReplyEdit.do">
 		<input type="hidden" name="flag" value="edit"> 		
	 	<input type="hidden" name="num" value="${rbean.num}">
	 	<input type="hidden" name="sabun" value="${rbean.sabun}">
 		<table class="table1">
 			<span id="lw"></span>		
			<tr> 
				<th class="td1"> <label> 저자: </label> </th>
				<td > <input type="text" name="writer" value="${rbean.writer}" size="22" maxlength="3" onblur="check()"> </td>
				
			</tr>
			<tr>
				<th class="td1"> <label> 내용: </label> </th>
				<td class="td2"> <textarea name="content" onblur="check2()">${rbean.content}</textarea> </td>				
			</tr>
			<tr>
			  <td colspan="2" class="td3"> 
			  	<input type="submit" id="sub" onClick="opener.location.reload()" value="댓글수정">
			  	<input type="button" onClick="window.close()" value="취소">
			  </td>
			</tr>
		</table>	
	</form> 
 </div>
</body>
</html>