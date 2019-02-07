<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="ssi.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [guestreply.jsp]</title>
  <style type="text/css">
    *{font-size:20pt; font-weight:bold;  font-family:  Segoe UI Symbol , comic Sans MS ;  }
    a{font-size:20pt; font-weight:bold; color:blue; text-decoration:none; }
{font-size:26pt; font-weight:bold; color:green; text-decoration:underline; }
    #rsave{
      font-size:26pt; font-weight:bold; 
      background: #00FF00; height:150px;
    }                
  </style>
  <script type="text/javascript">
      //---------댓글 수정 창 열기--------------------------------
	  function r_edit(num,writer,content,sabun){
	   window.open('guestreply_edit.jsp?num='+num+'&writer='+writer+'&content='+content+'&sabun='+sabun,'댓글수정','width=500,height=350, top=300,left=400');
	   }
  </script>
 </head>
<body>

<%
 //guestreply.jsp문서는 단독실행하면 글제목만 출력 
 //guestreply.jsp문서는 guestDetail.jsp 맨마지막문장 인클루대상 - 댓글 입력화면및 댓글출력
  Rdata=request.getParameter("idx"); 
  System.out.println("12.04.화요일 댓글넘어온  Rdata="+Rdata);
%>

<form action="guestreply_insert.jsp">
 <table  width=900 border=1 cellspacing=0 >
   <input type="hidden" name="sabun" value="<%=Rdata%>"> 
   <tr>
	 <td> <img src="../images/x1.gif">저자:<img src="../images/x1.gif"> </td>
	 <td> <input type="text" name="writer" size=25></td>
			
	  <td rowspan=2 align="center">
	   <input type="submit" value="댓글저장" id="rsave" >
	   </td>
	</tr>
		
	<tr>
		<td><img src="../images/x1.gif">내용:<img src="../images/x1.gif"> </td>
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
   <%
    msg="select rownum as rn, g.sabun,r.num,r.writer,r.content from guest g inner join guestreply r on  g.sabun=r.sabun and r.sabun="+Rdata;
    StringBuffer sb = new StringBuffer();
    	sb.append("select rownum as rn, g.sabun,r.num,r.writer,r.content from guest g");
    	sb.append(" inner join guestreply r");
    	sb.append(" on g.sabun=r.sabun");
    	sb.append(" and r.sabun="+Rdata);
    	sb.append(" order by rn");
    ST = CN.createStatement();
    //RS=ST.executeQuery(msg);
    RS = ST.executeQuery(sb.toString());
    while(RS.next()==true){
    	Rrn = RS.getInt("rn");
    	Rnum = RS.getInt("num");
    	Rwriter=RS.getString("writer");
    	Rcontent=RS.getString("content");
    	Rsabun=RS.getInt("sabun"); //Rsabun대신 Rdata사용권장 
   %>
   
   <tr onmouseover="style.backgroundColor='#00FFFF'" onmouseout="style.backgroundColor=''">
    <td> <%= Rrn %> </td>
    <!-- <td> %= Rnum % </td> -->
    <td> <%= Rwriter %></td>
    <td> <%= Rcontent  %></td>
    <td align="right">
      <a href="guestreply_delete.jsp?idx=<%=Rdata %>&num=<%=Rnum %>" >댓글삭제</a>
      <!-- a href="guestreply_edit.jsp?idx=%=Rdata %&num=%=Rnum %" >댓글수정</a>-->
      <a href="javascript:r_edit('<%=Rnum %>','<%=Rwriter %>','<%=Rcontent %>','<%=Rsabun %>')" >[댓글수정]</a>
    </td>
   </tr>
   
   <%}%>
 </table>	
</body>
</html>












