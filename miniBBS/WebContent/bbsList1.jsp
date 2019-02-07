<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="bbs_ssi.jsp"%>
<%@ include file="bbs_top.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="./css/InputCSS.css">

 <style type="text/css">
  *tr{onmouseover="style.backgroundColor='#00FFFF'" onmouseout="style.backgroundColor=''"}
 </style>
 <script type="text/javascript">
 function changeclear( ){
		myform.keyword.value="";
		myform.keyword.focus();
 }
 </script>
</head>
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
	<%		
		skey = request.getParameter("keyfield"); //검색필드
		sval = request.getParameter("keyword"); //검색키워드
		if (skey == null || skey == "" || sval == null || sval == "") {
			sqry = " where b_name like '%%' ";
			//검색필드나 검색키워드 선택안하거나 키워드입력안한경우 
			skey = "";
			sval = "";
		} else {
			if(skey.equals("b_all")){
				sqry = " where b_name like '%" + sval + "%' OR"
					       + " b_title like '%" + sval + "%' OR"
					       + " b_content like '%" + sval + "%'";
			}else{
				sqry = " where " + skey + " like '%" + sval + "%'";
			}
		}

		//~bbsList1.jsp?pageNum=3&keyfield=name&keyword=b
		returnpage = "&keyfield=" + skey + "&keyword=" + sval;

		msg = "select count(*) as cnt from bbs " + sqry;
		//System.out.println(sqry);
		//System.out.println(msg);
		st = con.createStatement();
		rs = st.executeQuery(msg);
		if (rs.next() == true) {
			Gtotal = rs.getInt("cnt");
		}
		
	%>
	<table width=900 border=1 cellspacing=0 >
		<tr align="right">
			<td colspan=6>레코드갯수:<%=Gtotal%> &nbsp;&nbsp;
			</td>
		</tr>

		<tr bgcolor="#999999">
			<th>행번호</th>
			<th>사 번</th>
			<th>이 름</th>
			<th>제 목</th>
			<th>조회수</th>
			<th>날 짜</th>
		</tr>
		<%
			pnum = request.getParameter("pageNum");
			if (pnum == null || pnum == "") {
				pnum = "1";
			}
			pageNUM = Integer.parseInt(pnum); //[7]문자가 숫자화 
			start = (pageNUM - 1) * 10 + 1;
			end = pageNUM * 10;
			//System.out.println("start=" + start + " end=" + end);

			//pagecount=32; 316데이터에서 32페이지수 구하기
			if (Gtotal % 10 == 0) {
				pagecount = Gtotal / 10;
			} else {
				pagecount = (Gtotal / 10) + 1;
			}

			temp = (pageNUM - 1) % 10; //홍길동[15선택]  15-1%10 => 4
			startpage = pageNUM - temp; //15-4=11
			endpage = startpage + 9; //11+9=20
			if (endpage > pagecount) {
				endpage = pagecount;
			}

			String x = " select * from ( ";
			String y = " select row_number() over(order by rownum desc) as rn, g.* from bbs g " + sqry;  
			String z = " order by rn ) where rn between " + start + " and " + end;
			msg = x + y + z ;
			//System.out.println(msg);
			st = con.createStatement();
			rs = st.executeQuery(msg); 

			//행번호 역순출력
			num = Gtotal - (pageNUM - 1) * 10;
			//td%= num-- %/td
			while (rs.next() == true) {
				Gsabun = rs.getInt("b_sabun");
				Gtitle = rs.getString("b_title");

				st2 = con.createStatement();
				msg2 = "select count(*) as rcnt from bbsreply where br_sabun =" + Gsabun;
				//System.out.println(msg2);
				rs2 = st2.executeQuery(msg2);
				if (rs2.next() == true) {
					Rtotal = rs2.getInt("rcnt");
				}
		%>
	<tr onmouseover="style.backgroundColor='#cccccc'" onmouseout="style.backgroundColor=''">
     <td> <%= rs.getInt("rn") %> </td>
     <td> <%= rs.getInt("b_sabun")   %> </td>
     <td> <%= rs.getString("b_name")  %></td>
     <td> 
       <a href="bbsDetail.jsp?idx=<%=Gsabun%>"><%= Gtitle %></a><% if(Rtotal>0){%><font style="font-size:12pt; color:red;">[<%=Rtotal%>]</font> <%}%> 
      </td>
     <td> <%= rs.getInt("b_cnt") %> </td>
     <td> <%= rs.getDate("b_wdate") %></td>
   </tr>  
  
 <%  
   }//while end
 %>
 
  <tr align="center">
   <td colspan="6">
     <!-- 이전  1~10  11  21  31 startpage -->
     <%
      if(startpage>10){
     	out.println("<a href=bbsList1.jsp?pageNum="+(startpage-10)+returnpage+">[이전]</a>");   
       }
     %>
   
     <%
      for(int i=startpage; i<=endpage; i++){
   	   if(i==pageNUM){
   		out.println("<font style='font-size:24pt; color:red'>["+i+"]</font>");   
   	   }
   	   else{
   	    out.println("<a href=bbsList1.jsp?pageNum="+i+returnpage+">[" + i + "]</a>" );
   	   }
      }//for end
     %> 
     
     <!-- 다음  10 20 30 40 endpage, pagecount -->
     <%
      if(endpage<pagecount){
   	out.println("<a href=bbsList1.jsp?pageNum="+(startpage+10)+returnpage+">[다음]</a>");   
      }
     %>
   </td>
  </tr>
  
 <tr align="center">
  	<td colspan="6">
  	 <form name="myform" action="bbsList1.jsp">
  	 	검색 :
  	 	<select name="keyfield" onchange="changeclear();">
  	 	   <option value="" selected>전체검색</option>
  	 	   <option value="b_name"  <% if(skey.equals("b_name")){out.println("selected");} %> >이름검색</option>
  	 	   <option value="b_title" <% if(skey.equals("b_title")){out.println("selected");} %> >제목검색</option>
  	 	   <option value="b_content" <% if(skey.equals("b_content")){out.println("selected");} %>> 내용검색 </option>
  	 	   <option value="b_all" <% if(skey.equals("b_all")){out.println("selected");} %> >이름+제목+내용</option> 
  	 	</select>
  	 	<input type="text" name="keyword" value="<%=sval %>" size=15>
  	 	<input type="submit" value="검 색 "> 
  	 	<input type="button" value="index" onclick="location.href='index.jsp'"> &nbsp;&nbsp;
  	 </form>
  	</td>
  </tr>
 </table>
<jsp:include page="bbs_bottom.jsp"></jsp:include> 
</body>
</html>