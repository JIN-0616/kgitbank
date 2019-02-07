<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="./ssi.jsp" %>
<!-- ./ -> 현재폴더내 -->
<!-- 선언시에는 절대 세미콜론을 찍으면 안됨 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[gestSave.jsp]</title></head>
<body>
  <%
  	//guestSave.jsp
	request.setCharacterEncoding("UTF-8");
		Gsabun = Integer.parseInt(request.getParameter("sabun"));
		Gname = request.getParameter("name");
		Gtitle=request.getParameter("title");
		Gpay= Integer.parseInt(request.getParameter("pay"));
	System.out.println("넘어온 사번 : "+ Gsabun +"<br>");
	System.out.println("넘어온 이름 : "+ Gname +"<br>");
	System.out.println("넘어온 제목 : "+ Gtitle +"<br>");
	System.out.println("넘어온 급여 : "+ Gpay +"<p>");
	
	//guest.jsp --> submit 사용시 강제데이터송신
	msg="select count(*) as cnt from guest where sabun=?";
	//ST = CN.createStatement();
	//RS = ST.executeQuery(msg);
	
	// 3 line => prepareSatememt 사용
	PST = CN.prepareStatement(msg);
		PST.setInt(1,Gsabun);
	RS = PST.executeQuery(); // msg 넣으면 error
	
	RS.next();
	Gtotal=RS.getInt("cnt");
	if(Gtotal>0){
  %>
	<script type="text/javascript">
	  alert(<%=Gsabun %>+ "데이터가 중복되었습니다.");
	  // response 사용불가
	  
	  //location.href("guest.jsp"); // 새로운 문서를 열기
	  
	  history.back(); // 데이터가 안지워지고 되돌아감
	  
	</script>
  <%		
	}else{
		
	
	
//=============================================================================	
	
	msg="insert into guest values(?,?,?,sysdate,?)";
	
	PST=CN.prepareStatement(msg); //데이터가 빠진 쿼리문명령어 미리서해석컴파일
		PST.setInt(1, Gsabun);
		PST.setString(2, Gname);
		PST.setString(3, Gtitle);
		PST.setInt(4, Gpay);
	PST.executeUpdate(); // 매개인자 없음!!! 주의!!!
	
	
	System.out.println(Gsabun+"사번으로 guest테이블 PST명령어저장성공했습니다");
	response.sendRedirect("guestList.jsp"); //현재화면보이지않고 바로 이동 <-> a태그
	
	}
  %>
  	
</body>
</html>