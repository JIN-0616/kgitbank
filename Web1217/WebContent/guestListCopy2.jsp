<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ include file="./ssi.jsp" %>
<%@ include file="./top.jsp" %>

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

  <script type="text/javascript">
 	function changeclear( ){
 		myform.keyword.value="";
 		myform.keyword.focus();
 	}//end
  </script>
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
  //guestList.jsp완성본
  skey=request.getParameter("keyfield"); //검색필드
  sval=request.getParameter("keyword"); //검색키워드
  if(skey==null || skey=="" || sval==null || sval==""){
	  sqry=" where name like '%%' "; //검색필드나 검색키워드 선택안하거나 키워드입력안한경우 
	  skey=""; sval="";
  }else{ sqry=" where "+skey+" like '%"+sval+"%'";  }
   
   
  //~guestList.jsp?pageNum=3&keyfield=name&keyword=b
  returnpage="&keyfield="+skey+"&keyword="+sval ; 
		  
   msg="select count(*) as cnt from guest " + sqry;
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
     start=(pageNUM-1)*10+1 ;
     end=pageNUM*10 ; 
     //System.out.println("start=" + start + " end=" + end);
     
     //pagecount=32; 316데이터에서 32페이지수 구하기
     if(Gtotal%10==0){ pagecount=Gtotal/10; }
     else{ pagecount=(Gtotal/10)+1; } 
   
     temp=(pageNUM-1)%10; //홍길동[15선택]  15-1%10 => 4
     startpage=pageNUM-temp; //15-4=11
     endpage=startpage+9; //11+9=20
     if(endpage>pagecount){ endpage=pagecount;} 
     
   String x=" select * from ( " ;
   String y=" select rownum rn, g.* from guest g " + sqry ;
   String z=" ) where rn between "+start+" and "+end ;
   msg=x+y+z; 
   //System.out.println(y);
   //msg="select rownum rn, sabun,name,title,nalja,pay from guest ";
   ST=CN.createStatement();
   RS=ST.executeQuery(msg); //select쿼리문 실행은 executeQuery(select~)
   
   //행번호 역순출력
   num=Gtotal-(pageNUM-1)*10;
   while(RS.next()==true){
	   Gsabun=RS.getInt("sabun");
	   Gtitle=RS.getString("title");
	   
	   ST3=CN.createStatement();
	   msg3="select count(*) as rcnt from guestreply where sabun =" + Gsabun;
	   RS3=ST3.executeQuery(msg3);
	   if(RS3.next()==true){ Rtotal=RS3.getInt("rcnt");}
 %>	   
   <tr>
     <td> <%= RS.getInt("rn")  %> </td>
     <td> <%= RS.getInt("sabun")   %> </td>
     <td> <%= RS.getString("name")  %></td>
     <td> 
       <a href="guestDetail.jsp?idx=<%=Gsabun%>"><%= Gtitle %></a><% if(Rtotal>0){%><font style="font-size:12pt; color:red;">[<%=Rtotal%>]</font> <%}%> 
      </td>
     <td> <%= RS.getInt("pay") %> </td>
   </td>  
  
 <%  
   }//while end
 %>
 
  <tr align="center">
   <td colspan="5">
     <!-- 이전  1~10  11  21  31 startpage -->
     <%
      if(startpage>10){
     	out.println("<a href=guestList.jsp?pageNum="+(startpage-10)+returnpage+">[이전]</a>");   
       }
     %>
   
     <%
      for(int i=startpage; i<=endpage; i++){
   	   if(i==pageNUM){
   		out.println("<font style='font-size:24pt; color:red'>["+i+"]</font>");   
   	   }
   	   else{
   	    out.println("<a href=guestList.jsp?pageNum="+i+returnpage+">[" + i + "]</a>" );
   	   }
      }//for end
     %> 
     
     <!-- 다음  10 20 30 40 endpage, pagecount -->
     <%
      if(endpage<pagecount){
   	out.println("<a href=guestList.jsp?pageNum="+(startpage+10)+returnpage+">[다음]</a>");   
      }
     %>
   </td>
  </tr>
  
 <tr align="center">
  	<td colspan="5">
  	 <form name="myform" action="guestList.jsp">
  	 	검색 :
  	 	<select name="keyfield" onchange="changeclear();">
  	 	   <option value="" selected>전체검색</option>
  	 	   <option value="name"  <% if(skey.equals("name")){out.println("selected");} %> >이름검색</option>
  	 	   <option value="title" <% if(skey.equals("title")){out.println("selected");} %> >제목검색</option>
  	 	   <option value=""> 내용검색 </option>
  	 	</select>
  	 	<input type="text" name="keyword" value="<%=sval %>" size=10>
  	 	<input type="submit" value="검 색 "> 
  	 	<input type="button" value="index" onclick="location.href='index.jsp'">
  	 	<input type="button" value="등록" onclick="location.href='guest.jsp'">
  	 	<input type="button" value="login" onclick="location.href='login.jsp'"> 
  	 </form>
  	</td>
  </tr>
 </table> 

</body>
</html>
