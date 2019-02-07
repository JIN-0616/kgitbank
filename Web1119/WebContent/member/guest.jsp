<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [guest.jsp]</title>
  <style type="text/css">
  	#guest_bottom{margin-bottom: 50px;}
    *{font-size:16pt; font-weight:bold;  font-family: Comic Sans MS ; }
    a{font-size:16pt; font-weight:bold; color:blue; text-decoration:none; }
{font-size:20pt; font-weight:bold; color:green; text-decoration:underline; }                
  </style>
  
 <script type="text/javascript">
   var flag = false;
   
   function move( ){
	  var a=document.myform.sabun.value;
	  var b=document.myform.name.value;
	  if(a==null || a==""){
		  alert("사번데이터를 입력하세요");
		  myform.sabun.focus();
		  return false;
	  }else{myform.name.focus(); }
	  
	  if(b==null || b==""){
		  alert("이름 데이터를 입력하세요");
		  myform.name.focus();
		  return false;
	  }else{ myform.title.focus(); }
	  
	  //메일체크
	  var my=myform.email.value;
      //var mail_reg=/^(sky)@(naver).(com)$/
      var mail_reg=/^([a-zA-Z0-9_\.]{3,16})@([a-zA-Z]{2,10})\.([a-zA-Z]{2,6})$/;
      if(mail_reg.test(my)==false){
    	  //alert경고창보다 innerHTML속성 <font color=red>경고메세지</font>
    	  document.getElementById("email_ch").innerHTML="<font color=red>메일형식 다시입력하세요</font>";
    	  myform.email.value="";
    	  myform.email.focus();
      }else{document.getElementById("email_ch").innerHTML=""; }
	  
      // summit 테스팅위해 주석
      //if(flag==false){
	  //	  alert("아이디중복체크하세요");
	  //	  return false;  
	  //}
      
	  document.myform.submit();  //submit태그역할
	  // button일경우 myform 생략불가
	  
	  
	  
   }//move end 
   
   function myinfo( ){
	   flag=true;
	   var a=document.myform.sabun.value;		
	   if(a==null || a==""){
			  alert("중복아이디=사번데이터가 공백입니다.\n데이터를 다시 입력하세요");
			  myform.sabun.focus();
			  return false;
		  }
	   window.open("openID.jsp","kg","left=650, top=300, width=500, height=150,menubar=no,toolbar=no");
		  					  // |-문서고유표식 없으면 중복해서 계속 팝업됨
   }//myinfo end  
   
   function myinfo2( ){
		 flag=true;
		 var a=document.myform.sabun.value;
		 if(a==null || a==""){
		   alert("중복아이디=사번데이터 공백입니다 openID2.jsp");
		   myform.sabun.focus();
		   return false;
		  }
		 open("openID2.jsp?idx="+a, "bc", "left=650,top=200,width=500,height=150");
	   }//myinfo2 end 
 </script>  
 
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>

	<font color=blue> [guest.jsp] </font><p>
	
	<form name="myform" action="guestSave.jsp">
	   사번: <input type="text" name="sabun" size=8>
	         <input type="button" value="아이디중복" onclick="myinfo()"> <br>
	      
	   이름: <input type="text" name="name" value="LG"> <br>
	   제목: <input type="text" name="title" value="snow" > <br>
	   메일: <input type="text" name="email" id="email" value="kim@bank.com"> <br>
	      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="email_ch"></span> <br>
	   급여: <input type="text" name="pay"  value="97" > <p> 
	      <input type="submit" value="버튼데이터저장"  onclick="move();">
	      <input type="reset"  value="입력취소">
	</form>
	
<p>
  <a href="index.jsp">[index]</a>
  <a href="guest.jsp">[신규등록]</a>
  <a href="guestList.jsp">[전체출력]</a>
  <a href="ssi.jsp">[ssi]</a>
  
  <span id="guest_bottom" />
  <jsp:include page="bottom.jsp"></jsp:include>
  							<!-- 축약가능 -->
</body>
</html>













