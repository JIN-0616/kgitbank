<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>[R_edit.jsp]</title>
</head>
 <link rel="stylesheet" type="text/css" href="./css/R_edit.css"/>
<body>
 <%
 	int num=Integer.parseInt(request.getParameter("num"));	
 	String writer=request.getParameter("writer");
 	String content=request.getParameter("content");
 	int sabun=Integer.parseInt(request.getParameter("sabun"));
 	System.out.println("guestreply_edit.jsp "+ num +" "+ writer+" "+ content +" " +sabun);
 	//값 넘어오는지 확인할것
 %>
 
 <form name="rform" action="guestreply_editSave.jsp">
 	<input type="hidden" name="Rnum" value="<%=num%>">
 	<input type="hidden" name="Rsabun" value="<%=sabun%>">
 	<div align="center">
 		<span>댓 글 수 정</span><p>
 		<table class="tab1">
			<tr> 
				<td class="td1"> <label> 저자: </label> </td>
				<td > <input type="text" name="Rwriter" value="<%=writer%>" size="22"> </td>
			</tr>
			<tr>
				<td class="td1"> <label> 내용: </label> </td>
				<td class="td2"> <textarea name="Rcontent"><%=content %></textarea> </td>
			</tr>
			<tr>
			  <td colspan="2" class="td3"> 
			  	<input type="submit" onClick="" value="댓글수정">
			  	<input type="button" onClick="window.close()" value="댓글수정취소">
			  </td>
			</tr>
		</table>
	</div>
 </form>
</body>
</html>