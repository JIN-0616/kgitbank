<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="bbs_ssi.jsp" %>
<%@ include file="bbs_top.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/InputCSS.css">
</head>
<body>
  <%
  	Gsabun = Integer.parseInt(request.getParameter("idx"));
  	msg = "select * from bbs where b_sabun="+Gsabun;
  	st = con.createStatement();
  	rs = st.executeQuery(msg);
  	
  	if(rs.next()){  		
  		Gname = rs.getString("b_name");
  		Gtitle = rs.getString("b_title");
  		Gcontent = rs.getString("b_content");
  		Gphone = rs.getString("b_phone");
  		Gpwd = rs.getString("b_pwd");
  		Gjuso1 = rs.getString("b_juso1");
  		Gjuso2 = rs.getString("b_juso2");
  		Gemail = rs.getString("b_email");
  		Gurl = rs.getString("b_url");
  	}
  %>
 <div class="all" align="center">
	<div class="title"><br>수정화면</div>
	<div class="cf"><br> <font color=red>* 표는 필수 입력 </font></div>
    <form name="bbsForm" action="bbsEditSave.jsp">
    <input type="hidden" name="sabun" value="<%=Gsabun %>">
    <table class="table1">
	<tr>
	 <th>* 이름</th>
	 <td><input type="text" name="name" value="<%=Gname%>"><br></td>
	</tr>
	<tr>
	 <th>* 제목</th>
	 <td><input type="text" name="title" value="<%=Gtitle%>"><br></td>
	</tr>
	<tr>
	 <th>* 내용</th>
	 <td><input type="text" name="content" value="<%=Gcontent%>"><br></td>	 
	</tr>
	<tr>
	 <th>* 휴대전화</th>
	 <td><input type="text" name="phone" value="<%=Gphone%>"><br></td>
	</tr>
	<tr>
	 <th>* 비밀번호</th>
	 <td><input type="text" name="pwd" value="<%=Gpwd%>"><br></td>
	</tr>
		<!-- 다음 주소 찾기 기능 -->	
	<tr>
	<th>우편</th>
	<td><input type="text" id="sample6_postcode" name="sample6_postcode"
	 placeholder="우편번호" class="btnCheck" size=10><input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br></td>
	</tr>
	<tr>
	<th>* 주소</th>
	<td><input type="text" id="sample6_address" name="juso1" placeholder="주소" class="taAddr" size=40 value="<%=Gjuso1%>"><br></td>
	</tr>
	<tr>
	<th>* 상세주소</th>
	<td><input type="text" id="sample6_address2" name="juso2" placeholder="상세주소" value="<%=Gjuso2%>"  size=40 class="taAddr"> <p></td>
	</tr>	
	<!-- /다음 주소 찾기 기능 -->
	<tr>
	<th>* 메일</th>
	<td><input type="text" name="email"  id="email" value="<%=Gemail%>" onblur="emailcheck()" ><br><span id="email_ch"></span><br></td>
	</tr>
	<tr>
	<th>url</th>
	<td><input type="text" name="url"  id="url" value="<%=Gurl %>" ><br></td>
	</tr>
  </table>        
	<input type="submit" value="send" onclick="check()">
	<input type="reset" value="reset">
    <input type="button" value="목록" onclick="location.href='bbsList1.jsp'">
 </form>
 </div>
<jsp:include page="bbs_bottom.jsp"></jsp:include>
</body>
</html>