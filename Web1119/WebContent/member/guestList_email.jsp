<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="ssi.jsp" %>
<!-- ./ -> 현재폴더내 -->
<!-- 선언시에는 절대 세미콜론을 찍으면 안됨 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[gestList.jsp]</title>
	<style type="text/css">
	 *{font-size: 18pt; font-weight: bold; }
     a{font-size: 18pt; font-weight: bold; color: blue; text-decoration: none;}
{font-size: 18pt; font-weight: bold; color: green; text-decoration: underline;}
	</style>
	<script type="text/javascript">
	function changeclear(){
		myform.keyword.value="";
		myform.keyword.focus();
	}//end	
	
	function emailcheck(){
		var mail = myfrom.email.value;
		
		var mail_reg=/^([a-zA-Z0-9-_\/)]{2,16})@([a-zA-Z]{2,10})\.([a-zA-Z]{2,6})$/;
		
		if(mail_reg.test(mail)==true){
			
			docuemnt.getElementById("email_ch").innerHTML="<font color=red>ex)email@naver.com형식으로 입력"
			
			myform.email.value="";
			
			myfrom.email.focus();
			
			return;
			
		}else{document.getElementById("email_ch").innerHTML="";}
		
	}
	</script>
</head>
<body>
  <%!
  	int start, end; //[7클릭] start=61, end=70
  	int pagecount;  //316레코드갯수 페이지갯수 7페이지
  	int pageNUM;	//[7]문자 --> 숫자화 pageNum = Interger.parseInt("7");
  	int startpage, endpage; //[7클릭] startpage=1, endpage=10;
  	String pnum;	//pnum = request.getParameter("pageNUM");
  	int temp;		//시작페이지를 구하기 위해서 사용하는 변수
  	//검색할때
  	String sqry;
  	String skey, sval; //검색필드, 검색키워드 skey="title필드", sval="%p%"
  	String returnpage;
  	int num; 		//행번호 역순출력
  %>

  <%
   	// null 관리해야함
  	skey = request.getParameter("keyfield");
  	sval = request.getParameter("keyword");
  	if(skey==null || skey=="" || sval==null || sval==""){
  		sqry = " where name like '%%' "; //검색필드,검색키워드 선택안함,입력안함
  		skey = ""; sval = "";
  	}else{
  		sqry = " where "+skey+" like '%"+sval+"%'" ; 
  	}
  	
  	
  	
  	//System.out.println(sqry);
  	
  	//guestList.jsp?keyfield=name&keyword=b
  	returnpage="&keyfield="+skey+"&keyword="+sval;
  	
  	//--------------------------------------------------------------------
  	
  	//msg="select count(*) as cnt from guest " + sqry; //공백조심
  	//ST = CN.createStatement();
  	//RS = ST.executeQuery(msg);
  	//if(RS.next()==true){
  	//	Stotal = RS.getInt("cnt");
  	//}	
  	
	//----------------------------------------------------------------------------
	msg="select count(*) as cnt from guest "+ sqry; //공백조심; 
  	ST = CN.createStatement();
  	RS = ST.executeQuery(msg);
  	if(RS.next()==true){
  		Gtotal = RS.getInt("cnt");
  	}
  %>

  <table width=900 border=1 cellspacing=0>  
   <tr align="center">
    <td colspan=5> <img src="images/bar.gif"><a href="index.jsp">[index]</a></td>
   </tr>   
   <tr align="right">
    <td colspan=5> 레코드갯수:<%= Gtotal %>&nbsp;&nbsp;</td>
   </tr>
   
   <tr bgcolor="yellow">
     <th>행번호</th><th>사 번</th><th>이 름</th><th>제 목</th><th>급 여</th>    
   </tr>
     
  <%
 	
   	pnum = request.getParameter("pageNum");
	if(pnum==null || pnum==""){
		 pnum="1";
	}
	pageNUM=Integer.parseInt(pnum);
		start=(pageNUM*10)-9;
		end = pageNUM*10; 
		System.out.println("start="+start+", end="+end);
		
	//pagecount = (Gtotal/10)+1;
	
	//pagecount = 32; 316데이터에서 32페이지수 구하기
	if(Gtotal%10==0){ pagecount = Gtotal/10;}
	else{pagecount= (Gtotal/10)+1;}
	
  	temp = (pageNUM-1)%10;
  	startpage = pageNUM - temp;
  	endpage = (startpage+9>pagecount)? pagecount : startpage + 9 ;
  	
  	String x = "select * from ( ";
  	String y = "select rownum rn, g.* from guest g "+ sqry; //공백조심
  	String z = " ) where rn between "+start+" and "+end;
  	msg = x+y+z;
	//msg="select rownum rn, sabun, name, title, nalja, pay from guest order by sabun asc";
	ST = CN.createStatement();
	RS = ST.executeQuery(msg); //select쿼리문 실행은 excuteQuery(select~)
	
	//행번호 역순출력
	num = Gtotal-(pageNUM-1)*10;	
	while(RS.next()==true){
		Gsabun=RS.getInt("sabun");
		Gtitle=RS.getString("title");		
		
  %>
  <tr onmouseover="style.backgroundColor='#dddddd'" onmouseout="style.backgroundColor=''">  	
    <!-- <td align="center"><!%= RS.getInt("rn") %></td> -->
    <td><%= num-- %></td>
    <td><%= RS.getInt("sabun") %></td>    
    <td><%= RS.getString("name") %></td>
    <td><a href="guestDetail.jsp?idx=<%=Gsabun%>"><%= Gtitle %></a></td>
    <td><%= RS.getInt("pay") %></td>
  </tr>  
  <%
	}//while end
  %>
  <tr align="center">
    <td colspan="5">
    
  <% 
  	// << 맨처음으로
  	out.println("<a href='guestList.jsp?pageNum="+1+"')>[<<]</a>");
	
  	// 10개단위 끊기 11~20
  	
    if(startpage>10){
    	out.println("<a href='guestList.jsp?pageNum="+(startpage-1)+returnpage+"')>[이전]</a>");
    }    
    for(int i=startpage; i<=endpage; i++){
    	if(i==pageNUM){
    		out.println("<font style='font-size:24pt; color:red'>["+i+"]</font> </a>" );
    	}else{
    		out.println("<a href='guestList.jsp?pageNum="+i+returnpage+"'>["+i+"]</a>" ); 
    	}
    }    
    if(endpage<pagecount){
    	out.println("<a href='guestList.jsp?pageNum="+(endpage+1)+returnpage+"')>[다음]</a>");
    }    
    // >> 맨마지막으로 붙이기
    out.println("<a href='guestList.jsp?pageNum="+pagecount+"')>[>>]</a>");
  %>
    </td>    
  </tr>
  <tr align="center">
    <td colspan="5">
	    <a href="index.jsp">[index]</a>
		<a href="guest.jsp">[신규등록]</a>
		<a href="guestList.jsp">[전체출력]</a>
    </td>
  </tr>
  <tr align="center">
    <td colspan="5">
	 <form name="myform">
		검색 :	 	 
	 	<select name="keyfield" onchange="changeclear();" >
	 		<option value="" selected >전체</option>
	 		<option value="name" <% if(skey.equals("name")){out.println("selected");} %>>이름</option>
	 		<option value="title" <% if(skey.equals("title")){out.println("selected");}%>>제목</option>
	 		<option value="">내용</option> <!-- 쿼리문중첩필요 -->
	 		<!-- 옵션은 value로!!! name이 아니다! -->	 		
	 	</select>	 	
	 	<input type="text" name="keyword" value="<%=sval%>" size=10>
	 	<input type="submit" value="검색">
	 	<input type="button" value="index" onclick="location.href='index.jsp'">&nbsp;&nbsp;
	 </form>			
    </td>
   </tr>   
  </table> 
</body>
</html>