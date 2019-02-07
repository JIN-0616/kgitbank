<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> [formGuest.jsp] </title> 
 <style type="text/css">
   *{font-size: 20pt; font-weight: bold; }
   a{font-size: 20pt; font-weight: bold; color: blue; text-decoration: none;}
{font-size: 20pt; font-weight: bold; color: green; text-decoration: underline;}
 </style>
 <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script> <!-- />이아니라 반드시 밖으로 닫기태그 설정필요 -->

 <script type="text/javascript">
    var flag=false; //javascript전역변수=field=필드
 
 	function  move( ){
 	  document.myform.submit(); 
 	}//move end
 	
   function myinfo(){
	 var a=document.myform.sabun.value;
 	 if(a=="" || a==null){
 	 }else{ myform.name.focus(); } 
      window.open("~~.jsp","title","width=400,height=150");
  }//myinfo end
  
  
    //다음우편번호
	function sample6_execDaumPostcode() {
	    new daum.Postcode({
	        oncomplete: function(data) {
	            var fullAddr = '';
	            var extraAddr = '';
	            
	            if (data.userSelectedType === 'R') fullAddr = data.roadAddress;
	            else fullAddr = data.jibunAddress;

	            if(data.userSelectedType === 'R') {
	                if(data.bname !== '') extraAddr += data.bname;
	                if(data.buildingName !== '') extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                
	                fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
	            }

	            document.getElementById("sample6_postcode").value = data.postcode;
	            document.getElementById("sample6_address").value = fullAddr;
	            document.getElementById("sample6_address2").focus();
	        }
	    }).open();
	} //sample6_execDaumPostcode end
	
	function emailcheck(){
		 //https://regexper.com/documentation.html
	   var mail=myform.email.value;
	   var mail_reg=/^([a-zA-Z0-9-_\.]{2,16})@([a-zA-Z]{2,10})\.([a-zA-Z]{2,6})$/;
	   if(mail_reg.test(mail)==false){
		 document.getElementById("email_ch").innerHTML="<font color=red>ex)email@nate.com 형식으로 입력하세요</font>";
		//alert("메일주소형식이 틀립니다"); 비권장 
		 myform.email.value="";
		 myform.email.focus();
		 return ;
	   }else{document.getElementById("email_ch").innerHTML="";}
	}//emailcheck end
	
 </script>
 
</head>
<body>
  <font color=blue>[formGuest.jsp]</font> <p> 
  <form name="myform"  method="get"  action="">
     사번: <input type="text" name="sabun"  size=10>
        <input type="button" onclick="myinfo()" value="아이디중복"><br>
        
     이름: <input type="text" name="name"   size=20> <br>
     제목: <input type="text" name="title"  value="bank" size=20> <br>   
     급여: <input type="text" name="pay"     value="21"  size=20> <br>
     메일: <input type="text" name="email"  id="email"  onblur="emailcheck()"><br>
        <span id="email_ch"></span><br>
        
     우편: 
        <input type="text" id="sample6_postcode" name="sample6_postcode" placeholder="우편번호" class="btnCheck"  size=10>
		<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
		주소: <input type="text" id="sample6_address" name="sample6_address" placeholder="주소" class="taAddr"><br>
		상세: <input type="text" id="sample6_address2" name="sample6_address2" placeholder="상세주소" value="비스타워1103호" class="taAddr"> <p>
             
    <input type="button" onclick="javascript:move();"  value="버튼저장">
    <input type="reset" value="입력취소">     
  </form> 
  
  <p>
  <a href="index.jsp">[메인화면]</a>
  <a href="formGuest.jsp">[방명록등록]</a>
  <a href="guestList.jsp">[전체출력]</a>
</body>
</html>


