<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="net.hb.common.DBbean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [guestListCopy3.jsp]</title>
  <style type="text/css">
    *{font-size:16pt; font-weight:bold;  font-family: Comic Sans MS ; }
    a{font-size:16pt; font-weight:bold; color:blue; text-decoration:none; }
{font-size:20pt; font-weight:bold; color:green; text-decoration:underline; }                
  </style>

  <script type="text/javascript">
 	function changeclear( ){
 		myform.keyword.value="";
 		myform.keyword.focus();
 	}//end
  </script>
 </head>
 

<body>
<%	int count = (int)request.getAttribute("Gtotal"); %>

 <table width=900 border=1 cellspacing=0>  
  <tr  align="right">
    <td colspan=5> 레코드갯수:<%=count %> &nbsp;&nbsp;</td>
  </tr>

  <tr bgcolor="yellow">
  	<th>행번호</th> <th>사 번</th> <th>이 름</th> <th>제 목</th> <th>급 여</th>
  </tr>
<%
	int startpage = (int)request.getAttribute("startpage");
	int endpage = (int)request.getAttribute("endpage");
	int pageNUM = (int)request.getAttribute("pageNUM");
	int pagecount = (int)request.getAttribute("pagecount");
	ArrayList<DBbean> dto=(ArrayList<DBbean>)request.getAttribute("naver");
	for(DBbean bean: dto){
	//for(int i=0;i<dto.size();i++){
	  //DBbean bean = dto.get(i);
	  int Gsabun = bean.getSabun();
	  String Gtitle=bean.getTitle();
	
%>    
   <tr>
     <td> <%=bean.getRn() %> </td>
     <td> <%=bean.getSabun() %> </td>
     <td> <%=bean.getName() %> </td>
     <td> <a href="Detail.do?idx=<%=Gsabun%>"><%=Gtitle %></a></td>
     <td> <%=bean.getPay() %></td>
   </tr>
     
<%  } %>
  
   <tr align="center">
   <td colspan="5">
     <%
     if(endpage>10){
       out.println("<a href=List.do?pageNum="+(startpage-10)+">[이전]");
     }
     %>
   
     <%     
     for(int i=startpage; i<=endpage;i++){
       if(i==pageNUM){
       	out.println("<font style='font-size:10; color:red;'><a href=List.do?pageNum="+i+">["+i+"]</a></font>");	  
       }else{
       	out.println("<a href=List.do?pageNum="+i+">["+i+"]</a>");
       }
     }      
     %>    
     <%
     if(endpage<pagecount){
       out.println("<a href=List.do?pageNum="+(startpage+10)+">[다음]");
     }
     %>
   </td>
  </tr>
  
 <tr align="center">
  	<td colspan="5">
  	 <form name="myform">
  	 	검색 :
  	 	<select name="keyfield" onchange="changeclear();">
  	 	   <option value="" selected>전체검색</option>
  	 	   <option value="name"   >이름검색</option>
  	 	   <option value="title"  >제목검색</option>
  	 	   <option value=""> 내용검색 </option>
  	 	</select>
  	 	<input type="text" name="keyword" size=10>
  	 	<input type="submit" value="검 색 "> 
  	 	<input type="button" value="index" onclick="location.href='index.jsp'">
  	 	<input type="button" value="등록" onclick="location.href='Insert.do'">
  	 	<input type="button" value="login" onclick="location.href='login.jsp'"> 
  	 </form>
  	</td>
  </tr>
 </table> 

</body>
</html>
