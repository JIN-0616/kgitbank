<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="bbs_ssi.jsp" %>
<%@ include file="bbs_top.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/InputCSS.css">

</head>
<body>

 <%
 	//http://localhost:8080/miniBBS/bbsDetail.jsp?idx=7789
 	String idx = request.getParameter("idx");
 
 	msg = "update bbs set b_cnt=b_cnt+1 where b_sabun="+idx;
 	st = con.createStatement();
 	st.executeUpdate(msg);
 				System.out.println("1");
 	msg = "select * from bbs where b_sabun="+idx;
 	st = con.createStatement();
 	rs = st.executeQuery(msg);
 				System.out.println("2");
 	if(rs.next()){
 		Gsabun = rs.getInt("b_sabun");
 		Gurl = rs.getString("b_url");
 		Gfile1 = rs.getString("b_file1");
 		System.out.println("3");
 	}
 %>
 <table  width=900 border=1 cellspacing=0 cellpadding=5>
  <tr align="center" bgcolor="yellow">
    <td colspan="2"> [<%= rs.getString("b_name") %>님] 상세정보출력 </td>
  <tr>
  
  <tr>
  	<td rowspan="10" align="center"> <a href="bbsfiledownload.jsp"><img src="storage/<%=Gfile1 %>" alt="사용자사진" width=200 height=150></a> </td>
  	<td> 사&nbsp;&nbsp; 번 :	<%= rs.getInt("b_sabun") %> </td>
  </tr>
  
  <tr>
  	<td> 제&nbsp;&nbsp; 목 :	<%= rs.getString("b_title") %> </td>
  </tr>
  
  <tr>
  	<td> 날&nbsp;&nbsp; 짜 :	<%= rs.getDate("b_wdate") %> </td>
  </tr>
  
  <tr>
  	<td> 조회수 :	<%= rs.getInt("b_cnt") %> </td>
  </tr>
  
  <tr>
  	<td> 내&nbsp;&nbsp; 용 :	<%=rs.getString("b_content") %> </td>
  </tr>
  
  <tr>
  	<td> 휴대폰 :	<%=rs.getString("b_phone") %> </td>
  </tr>
    
  <tr>
  	<td> 주&nbsp;&nbsp; 소 :	<%=rs.getString("b_juso1")+ rs.getString("b_juso2")  %> </td>
  </tr>
  
  <tr>
  	<td> 이메일 :	<%=rs.getString("b_email") %> </td>
  </tr>
  
  <tr>
  	<td> url&nbsp;&nbsp;&nbsp;&nbsp; : 
  	<% if(Gurl!=null){ %> 
  		<a href='http://<%= Gurl %>'><%= Gurl %></a>
  	<% }System.out.println("4"); %>  	
  	</td>
  </tr>
  <tr align="center">
  	<td> <a href="bbsEdit.jsp?idx=<%=Gsabun%>">[글수정]</a>
  	     <a href="bbsDelete.jsp?idx=<%=Gsabun%>">[글삭제]</a>
  	     <a href="bbsList1.jsp">[글목록]</a>
  	</td>
  </tr>
  
 </table>
<jsp:include page="bbsreply.jsp">
	<jsp:param name="idx" value="<%=Gsabun %>"/>
</jsp:include> 
<jsp:include page="bbs_bottom.jsp"></jsp:include>
</body>
</html>