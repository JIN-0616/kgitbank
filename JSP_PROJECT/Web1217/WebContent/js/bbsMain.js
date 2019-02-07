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
	}else if(n==null || n==""){
		alert("이름은 필수항목입니다")
		bbsFrom.name.focus();
		return false;
	}else if(t==null || t==""){
		alert("제목은 필수항목입니다")
		bbsFrom.title.focus();
		return false;
	}else if(c==null || c==""){
		alert("내용은 필수항목입니다")
		bbsFrom.content.focus();
		return false;
	}else if(p==null || p==""){
		alert("휴대전화번호는 필수항목입니다")
		bbsFrom.phone.focus();
		return false;
	}else if(!regPhone.test(p)){
		alert("잘못된 휴대폰번호입니다. 숫자, - 를 포함한 숫자만 입력하세요.");
		bbsFrom.phone.focus();
        return false;
	}else if(p==null || p==""){
		alert("비밀번호는 필수항목입니다")
		bbsFrom.pwd.focus();
		return false;
	}
	emailcheck();
   }
   
   
   function emailcheck(){
	   //https://regexper.com/documentation.html
	   var mail=myform.email.value;
	   var mail_reg=/^([a-zA-Z0-9-_\.]{3,16})@([a-zA-Z]{2,10})\.([a-zA-Z]{2,6})$/;
	   if(mail_reg.test(mail)==false){
		 document.getElementById("email_ch").innerHTML="<font color=red>email@nate.com형식입니다</font>";		 
		 bbsForm.email.value="";
		 bbsForm.email.focus();
		 return false;
	   }else{document.getElementById("email_ch").innerHTML="";}
	}
   
   
   function idcheck(){
	var sabun = bbsForm.sabun.value;
	if(sabun==null || sabun==""){
		alert("사번데이터는 필수항목입니다")
		bbsForm.sabun.focus();
		return false;
	}
	window.open("bbsIDCheck.jsp","id","left=650, top=300, width=500, height=150,menubar=no,toolbar=no")
	
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