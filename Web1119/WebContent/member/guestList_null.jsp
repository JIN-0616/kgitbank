<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ include file="ssi.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [guestList.jsp]</title>
  <style type="text/css">
    *{font-size:16pt; font-weight:bold;  font-family: Comic Sans MS ; }
    a{font-size:16pt; font-weight:bold; color:blue; text-decoration:none; }
{font-size:20pt; font-weight:bold; color:green; text-decoration:underline; }                
  </style>
 </head>
 
<body>
<%!
 int start, end ;  //[7클릭] start=61, end=70
 int pagecount;  //316레코드갯수 페이지갯수 7페이지
 int pageNUM ;   //[7문자] =>숫자화 pageNUM=Integer.parsetInt("7")
 int startpage, endpage; //[14클릭]  startpage=11, endpage=20
 String pnum;  //pnum=request.getParamenter("pageNum")
 int temp; //시작페이지를 구하기위해서 사용하는변수  
 int num; //행번호 역순출력 
 
 //검색할때 
 String sqry; 
 String skey, sval; //검색필드, sky="title필드" sval="%p%"
 String returnpage; 
%>

 <%
  skey=request.getParameter("keyfield"); //검색필드
  sval=request.getParameter("keyword"); //검색키워드
 
   msg="select count(*) as cnt from guest " ;
   ST=CN.createStatement();
   RS=ST.executeQuery(msg);
   if(RS.next()==true){
	 Gtotal=RS.getInt("cnt");   
   }
 %>

 <table width=900 border=1 cellspacing=0>  
  <tr  align="right">
    <td colspan=5> 레코드갯수:<%= Gtotal %> &nbsp;&nbsp;</td>
  </tr>

  <tr bgcolor="yellow">
  	<th>행번호</th> <th>사 번</th> <th>이 름</th> <th>제 목</th> <th>급 여</th>
  </tr>
 <%
   //guestList.jsp 단독실행가능 
   pnum=request.getParameter("pageNum");
   if(pnum==null || pnum==""){ pnum="1"; }
   pageNUM=Integer.parseInt(pnum); //[7]문자가 숫자화 
   
   
   //String x=" select * from ( " ;
   //String y=" select rownum rn, g.* from guest g "  ;
   //String z=" ) where rn between "+start+" and "+end ;
    
   msg="select rownum as rn, sabun,name,title,nalja,pay from guest ";
   ST=CN.createStatement();
   RS=ST.executeQuery(msg); 
   
   while(RS.next()==true){
	   Gsabun=RS.getInt("sabun");
	   Gtitle=RS.getString("title");
 %>	   
   <tr>
     <td> <%= RS.getInt("rn")  %> </td>
     <td> <%= RS.getInt("sabun")   %> </td>
     <td> <%= RS.getString("name")  %></td>
     <td> <%= Gtitle %>  </td>
     <td> <%= RS.getInt("pay") %> </td>
   </td>  
  
 <%  
   }//while end
 %>
 
  <tr align="center">
   <td colspan="5">
     <!-- 이전  1~10  11  21  31 startpage -->
     <%
    
     %>
   
     <%
      for(int i=1; i<=10; i++){
  
      }//for end
     %> 
     
     <!-- 다음  10 20 30 40 endpage, pagecount -->
     <%
 
     %>
   </td>
  </tr>
  
 <tr align="center">
  	<td colspan="5">
  	 <form name="myform" action="guestList.jsp">
  	 	검색 :
  	 	
  	 	
  	 </form>
  	 <button onclick="location.href='index.jsp'">index</button> &nbsp;&nbsp;
  	</td>
  </tr>
 </table> 

</body>
</html>


















