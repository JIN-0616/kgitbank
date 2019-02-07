<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="bbs_ssi.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
  <style type="text/css">
  
  </style>
  <script type="text/javascript">
      //---------댓글 수정 창 열기--------------------------------
  function r_edit(num,writer,content,sabun){
	   var a = window.open('bbsreply_edit.jsp?num='+num+'&writer='+writer+'&content='+content+'&sabun='+sabun,'댓글수정','width=500,height=350, top=300,left=400','replyedit');
	   
  }  
  </script>
</head>  
<body>
	<%
		int Rdata = Integer.parseInt(request.getParameter("idx"));		
	%>
	<form action="bbsreply_insert.jsp">
	 <input type="hidden" name="b_sabun" value="<%=Rdata %>">
	 <table  width=900 border=1 cellspacing=0 >
	  <tr>
	   <td><img src="./images/x1.gif">저자:<img src="./images/x1.gif"> </td>
	   <td><input type="text" name="writer" size=25 maxlength="3"></td>
	   <td rowspan=2 align="center">
	   <input type="submit" value="댓글저장" id="rsave" >
	   </td>
	  </tr>
	  <tr>
	   <td><img src="./images/x1.gif">내용:<img src="./images/x1.gif"> </td>
		<td>
		  <textarea cols=27 rows=3 name="content"></textarea>       
		</td>
	  </tr>	  
	 </table>
	</form>	
  <table  width=900 border=0 cellspacing=0 >
   <tr bgcolor="pink" align="center">
     <td colspan="4">댓글 데이터 출력 </td>
   </tr>
   <tr align="left" bgcolor="pink"  >
   	 <td style="border:1px gray solid;">번호</td>
   	 <td style="border:1px gray solid;">작성자</td>
   	 <td colspan="2" style="border:1px gray solid;">내용</td>
   </tr>  
   <%
    StringBuffer sb = new StringBuffer();
    	sb.append(" select rownum as rn, b.b_sabun,br_num,br_writer,br_content from bbs b");
    	sb.append(" inner join bbsreply r");
    	sb.append(" on b.b_sabun=r.br_sabun");
    	sb.append(" and r.br_sabun="+Rdata);
    	sb.append(" order by rn");
    st = con.createStatement();    
    rs = st.executeQuery(sb.toString());
    while(rs.next()==true){
    	Rrn = rs.getInt("rn");
    	Rnum = rs.getInt("br_num");
    	Rwriter=rs.getString("br_writer");
    	Rcontent=rs.getString("br_content");
    	Rsabun=rs.getInt("b_sabun"); //Rsabun대신 Rdata사용권장 
   %>
   
   
   <tr onmouseover="style.backgroundColor='#cccccc'" onmouseout="style.backgroundColor=''">
    <td id=<%= Rrn %>> <%= Rrn %> </td>
    <!-- <td> %= Rnum % </td> -->
    <td id=<%= Rwriter %> > <%= Rwriter %></td>
    <td id=<%= Rcontent %> > <%= Rcontent %></td>
    <td align="right">
      <a href="bbsreply_delete.jsp?idx=<%=Rdata %>&num=<%=Rnum %>" >[댓글삭제]</a>
      <!--a href="javascript:r_edit('%=Rnum %>','%=Rwriter %>','%=Rcontent %>','%=Rsabun %>')" >[댓글수정]</a>-->
       <a href="javascript:r_edit('<%=Rnum %>','<%=Rwriter %>','<%=Rcontent %>','<%=Rsabun %>')" >[댓글수정]</a>
    </td>
   </tr>    
   <%}%>
 </table>
</body>
</html>