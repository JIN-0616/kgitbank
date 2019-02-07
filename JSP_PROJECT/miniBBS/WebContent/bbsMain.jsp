<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 게시판 </title>
<link rel="stylesheet" type="text/css" href="./css/InputCSS.css">
 <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
 <script type="text/javascript">
//====전역변수:각각 체크여부
	var flag = false;//null체크여부
	var flagS = false;//사번중복체크여부
	var flagE = false;//email체크여부
	
//====다 체크하고 submit
	function check(){
		var sabun = bbsForm.sabun.value;
		var name = bbsForm.name.value;
		var pwd = bbsForm.pwd.value;
		var juso1 = bbsForm.juso1.value;
		var juso2 = bbsForm.juso2.value;	
		var email = bbsForm.email.value;
		var title = bbsForm.title.value;
		var content = bbsForm.content.value;
		var phone = bbsFrom.phone.value;
		var regPhone = /^\d{3}-\d{3,4}-\d{4}$/;
		
		if (sabun==null||sabun==""){
			alert('사번을 입력하세요');
			bbsForm.sabun.focus();
			return;
		}
		if (name==null||name==""){
			alert('이름을 입력하세요.');
			bbsForm.name.focus();
			return;
		}
		if (pwd==null||pwd==""){
			alert('비밀번호를 입력하세요.');
			bbsForm.pw.focus();
			return;
		}
	
		if (juso1==null||juso1==""||juso2==null||juso2==""){
			alert('주소를 입력하세요.');
			bbsForm.code.focus();
			return;
		}
		if (phone==null||phone==""){
			alert('전화번호를 입력하세요.');
			bbsForm.num1.focus();
			return;
		}
		if(!regPhone.test(phone)){
			alert("잘못된 휴대폰번호입니다. 숫자, - 를 포함한 숫자만 입력하세요.");
			bbsFrom.phone.focus();
	        return false;
		}
		if (email==null||email==""){
			alert('이메일을 입력하세요.');
			bbsForm.email.focus();
			return;
		}
		if (title==null||title==""){
			alert('제목을 입력하세요.');
			bbsForm.title.focus();
			return;
		}
		if (content==null||content==""){
			alert('내용을 입력하세요.');
			bbsForm.content.focus();
			return;
		}
		//위에 해당 되는 거 없으면 널 체크 true
		flag=true;
		
		if(flagS==false){	//사번중복체크 안됐을때
			alert('사번 중복체크 하세요.');
			return;
		}				
		
		if(flagN==false){	//전화번호 올바르지 않을때
			alert('전화번호를 올바르게 입력하세요.');
			bbsForm.num1.focus();
			return;
		}
		
		//위에 다 통과&체크 완료 후 submit
		if(flag==true&&flagS==true&&flagE==true){
			document.bbsForm.submit();
		} else { return; }
	}//check end
   
   
   function idcheck(){
		var sabun = bbsForm.sabun.value;
		if(sabun==null || sabun==""){
			alert("사번데이터는 필수항목입니다")
			bbsForm.sabun.focus();
			return false;
		}
		window.open("bbsIDCheck.jsp","id","left=650, top=500, width=800, height=300,menubar=no,toolbar=no")	
		flagS= true;
	   }
   
   
   function nullcheck(){
	var s = bbsForm.sabun.value;
	var n = bbsForm.name.value;
	var t = bbsForm.title.value;
	var c = bbsForm.content.value;
	var p = bbsForm.phone.value;
	var regPhone = "/^\d{3}-\d{3,4}-\d{4}$/";
	var pw= bbsForm.pwd.value;	
	if(s==null || s==""){
		alert("사번은 필수항목입니다")
		bbsFrom.sabun.focus();
		return false;
	}
	if(n==null || n==""){
		alert("이름은 필수항목입니다")
		bbsFrom.name.focus();
		return false;
	}
	if(t==null || t==""){
		alert("제목은 필수항목입니다")
		bbsFrom.title.focus();
		return false;
	}
	if(c==null || c==""){
		alert("내용은 필수항목입니다")
		bbsFrom.content.focus();
		return false;
	}
	if(p==null || p==""){
		alert("휴대전화번호는 필수항목입니다")
		bbsFrom.phone.focus();
		return false;
	}
	if(!regPhone.test(p)){
		alert("잘못된 휴대폰번호입니다. 숫자, - 를 포함한 숫자만 입력하세요.");
		bbsFrom.phone.focus();
        return false;
	}
	if(p==null || p==""){
		alert("비밀번호는 필수항목입니다")
		bbsFrom.pwd.focus();
		return false;
	}	
	
		document.bbsForm.submit();
	
   }
   
   
   function emailcheck(){
	   //https://regexper.com/documentation.html
	   var mail=bbsForm.email.value;
	   var mail_reg=/^([a-zA-Z0-9-_\.]{3,16})@([a-zA-Z]{2,10})\.([a-zA-Z]{2,6})$/;
	   if(mail_reg.test(mail)==false){
		 document.getElementById("email_ch").innerHTML="<font color=red>email@nate.com형식입니다</font>";		 
		 bbsForm.email.value="";
		 bbsForm.email.focus();
		 return false;
	   }else{
		   document.getElementById("email_ch").innerHTML="";
		   flagE = true;
	   }   
	}
     
   function sample6_execDaumPostcode(){
	   new daum.Postcode({
		   oncomplete: function(data){
			   var fullAddr = '';
			   var extraAddr = '';
			   if (data.userSelectedType === 'R') fullAddr = data.roadAddress;
	            else fullAddr = data.jibunAddress;
	           /*if(data.userSelectedType === 'R') {
	                if(data.bname !== '') extraAddr += data.bname;
	                if(data.buildingName !== '') extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                
	                fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
	            }*/  
	            //document.getElementById("sample6_postcode").value = data.postcode;
	            document.getElementById("sample6_postcode").value = data.zonecode;
	            document.getElementById("sample6_address").value = fullAddr;
	            document.getElementById("sample6_address2").focus(); //우리가직접입력하는 상세주소
	        }
	    }).open();
   }
 </script>  
</head>
<body>
<jsp:include page="bbs_top.jsp"></jsp:include>
<div class="all" align="center">
	<div class="title"><br>입력화면</div>
	<div class="cf"><br> <font color=red>* 표는 필수 입력 </font></div>
    <form name="bbsForm" action="bbsSave.jsp" method="post" enctype="multipart/form-data">
      <table class="table1">
    <tr>
	 <th >* 사번</th>
	 <td > <input type="text" name="sabun" size="4"> <!-- 4자리숫자 -->
		  <input type="button"name="check" value="중복체크" onclick="idcheck()"><br>
	 </td>
	 <td rowspan="3">
	  <div id="preview"></div>
	 </td>
	</tr>		
	<tr>
	 <th>* 이름</th>
	 <td><input type="text" name="name"><br></td>
	</tr>
	<tr>
	 <th>* 제목</th>
	 <td><input type="text" name="title"><br></td>
	</tr>
	<tr>
	 <th>* 내용</th>
	 <td><input type="text" name="content"><br></td>	 
	</tr>
	<tr>
	 <th>* 휴대전화</th>
	 <td><input type="text" name="phone" value="010-1234-5678"><br></td>
	</tr>
	<tr>
	 <th>* 비밀번호</th>
	 <td><input type="text" name="pwd" value="1234"><br></td>
	</tr>
		<!-- 다음 주소 찾기 기능 -->	
	<tr>
	<th>우편</th>
	<td><input type="text" id="sample6_postcode" name="sample6_postcode"
	 placeholder="우편번호" class="btnCheck" size=10><input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br></td>
	</tr>
	<tr>
	<th>주소</th>
	<td><input type="text" id="sample6_address" name="juso1" placeholder="주소" class="taAddr" size=40><br></td>
	</tr>
	<tr>
	<th>상세주소</th>
	<td><input type="text" id="sample6_address2" name="juso2" placeholder="상세주소" value="비스타워 아뱅 1103호"  size=40 class="taAddr"> <p></td>
	</tr>	
	<!-- /다음 주소 찾기 기능 -->
	<tr>
	<th>메일</th>
	<td><input type="text" name="email"  id="email" onblur="emailcheck()" ><br><span id="email_ch"></span><br></td>
	</tr>
	<tr>
	<th>url</th>
	<td><input type="text" name="url"  id="url" ><br></td>
	</tr>
	<tr>
	<th>file</th>
	<td><input type="file" name="file1" id="file1"></td>
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













