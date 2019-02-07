<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="./ssi.jsp" %>
<!-- ./ -> 현재폴더내 -->
<!-- 선언시에는 절대 세미콜론을 찍으면 안됨 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[openIDSave.jsp]</title></head>
<body>
  <%
  	//openIDSave.jsp 단독실행하면 에러발생
 	String data = request.getParameter("userid");
  	//msg = "select * from guest where sabun= "+data;
  	msg = "select count(*) as cnt from guest where sabun="+data;
  	ST = CN.createStatement();
	RS = ST.executeQuery(msg);
	if(RS.next()){Gtotal = RS.getInt("cnt");}
	if(Gtotal>0){
		System.out.println(data + "사번 이미 사용중입니다.");
		//myform.sabun.value=""; //창닫기 self.close();
   %>
   		<script type="text/javascript">
		alert(<%=data %>+ "번호는 사용중입니다.");
		opener.myfrom.sabun.value="";
		opener.myfrom.sabun.focus();
		
   		//self.close();
   		
   		//window.open('', '_self', '');
		//window.close();
		
		// 작동되는 방식 - 테스팅을 좀더 해볼것
		var win = window.open("about:blank", "kg");
		win.close();
		
		
   		</script>
   <% 
   	}else{
		System.out.println(data + "사용 가능합니다.");
		//창닫기
   %>
   		<script type="text/javascript">
		alert(<%=data %>+ "번호는 사용가능합니다.");
		opener.myform.name.focus();
		//작동안됨
		//opener.myform.getElememtById("id_ch").innerHTML="<font color=red>사용가능합니다.</font>";
   		
		//self.close();
   		
		// X
		//window.open('', '_self', '');
		//window.close();
   		
		var win = window.open("about:blank", "kg");
		win.close();
		</script>
   <%
	}
	
  %>  	
</body>
</html>