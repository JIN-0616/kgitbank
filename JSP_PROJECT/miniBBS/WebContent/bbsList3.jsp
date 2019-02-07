<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="bbs_ssi.jsp" %>
<%@ include file="bbs_top.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 게시판</title>
</head>
<link rel="stylesheet" type="text/css" href="./css/InputCSS.css">
<body>

<%!
	int start, end; //[7클릭] start=61, end=70
	int pagecount; //316레코드갯수 페이지갯수 7페이지
	int pageNUM; //[7문자] =>숫자화 pageNUM=Integer.parsetInt("7")
	int startpage, endpage; //[14클릭]  startpage=11, endpage=20
	String pnum; //pnum=request.getParamenter("pageNum")
	int temp; //시작페이지를 구하기위해서 사용하는변수  
	int num; //행번호 역순출력 

	//검색할때 
	String sqry;
	String skey, sval; //검색필드, skey="title필드" sval="%p%"
	String returnpage;
%>
	<table width=1100 border=1 cellspacing=0 cellpadding=5>
	<tr>
<%
	msg = "select count(*) as cnt from bbs ";
	//System.out.println(sqry);
	//System.out.println(msg);
	st = con.createStatement();
	rs = st.executeQuery(msg);
	if (rs.next() == true) {
		Gtotal = rs.getInt("cnt");
	}
	pnum = request.getParameter("pageNum");
	if (pnum == null || pnum == "") {
		pnum = "1";
	}
	pageNUM = Integer.parseInt(pnum); //[7]문자가 숫자화 
	start = (pageNUM - 1) * 5 + 1;
	end = pageNUM * 5;
	//System.out.println("start=" + start + " end=" + end);
	
	//pagecount=32; 316데이터에서 32페이지수 구하기
	if (Gtotal % 5 == 0) {
		pagecount = Gtotal / 5;
	} else {
		pagecount = (Gtotal / 5) + 1;
	}
	
	temp = (pageNUM - 1) % 10; //홍길동[15선택]  15-1%10 => 4
	startpage = pageNUM - temp; //15-4=11
	endpage = startpage + 9; //11+9=20
	if (endpage > pagecount) {
		endpage = pagecount;
	}	
	try{		
		msg="select * from (select row_number() over(order by rownum desc) as rn, b_sabun,b_title,b_file1,b_cnt,b_wdate,br_num from bbs b , bbsreply r order by rn ) where rn between " +start + " and " + end;
		st = con.createStatement();
		rs = st.executeQuery(msg);
				
		while(rs.next()==true){
		  	int rn = rs.getInt("rn");
		    Gsabun = rs.getInt("b_sabun");
			Gtitle = rs.getString("b_title");
			Gfile1 = rs.getString("b_file1");			
			Gcnt = rs.getInt("b_cnt");
			Gdate = rs.getDate("b_wdate");
			Rcnt = rs.getInt("br_num");
%>	
	    <td>
     	<a href="bbsDetail.jsp?idx=<%= Gsabun %>">
         	     <img src="storage/<%=Gfile1 %>" width="150" height="150">
    	</a><br>
    		NO <%= rn %><br> 
    		글제목 : <a href="bbsDetail.jsp?idx=<%= Gsabun %>"><%= Gtitle %></a>
    		<%if(Gcnt>=5){ %> <img src = "images/hot.gif"> <% } %>
  			<%if(Gcnt>0){ %><font size=5 ></font> <%} %> <br>
  	 		조회수:  <%= Gcnt %> <br>
    		날  짜 :  <%= Gdate %><br>
        </td>
    	
   <%
        }//while end 
     }catch(Exception ex) { System.out.println("이미지형 조회 실패"+ex); }
   %>
  </tr>
  <tr align="center">
   <td colspan="5">
     <!-- 이전  1~10  11  21  31 startpage -->
     <%
      if(startpage>10){
     	out.println("<a href=bbsList3.jsp?pageNum="+(startpage-10)+">[이전]</a>");   
       }
     %>
   
     <%
      for(int i=startpage; i<=endpage; i++){
   	   if(i==pageNUM){
   		out.println("<font style='font-size:24pt; color:red'>["+i+"]</font>");   
   	   }
   	   else{
   	    out.println("<a href=bbsList3.jsp?pageNum="+i+">[" + i + "]</a>" );
   	   }
      }//for end
     %> 
     
     <!-- 다음  10 20 30 40 endpage, pagecount -->
     <%
      if(endpage<pagecount){
   		out.println("<a href=bbsList3.jsp?pageNum="+(startpage+10)+">[다음]</a>");   
      }
     %>
   </td>
  </tr>
</table>
<%
	
%>

<jsp:include page="bbs_bottom.jsp"></jsp:include>
</body>
</html>