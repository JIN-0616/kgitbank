<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title> [test_join.jsp]</title>
  <style type="text/css">
    .input_group {
	 height: 42px;
	 border-bottom: 1px dotted #ccc;
	 font: 1em/40px 'Comic Sans MS', 'Helvetica';
	}
			
	.input_group > label {
	   width: 80px; display: inline-block;
	}             
  </style>

  <script type="text/javascript">
	function move(){
		//성별은 남자, 여자 뿐이므로 단순접근도 괜찮을수있음
		//if(!myform.gender[0].checked && !myform.gender[1].checked){
		if(!(myform.gender[0].checked || myform.gender[1].checked)){
			alert("성별을 입력하시오")
			myform.gender[0].focus();
			return false;
		}
		// or
		var a = document.getElementsByName("gender");
		var anull = null;
		for (var i = 0; i < a.length; i++) {
			if(a[i].checked == true){
				anull=a[i].value;
				break;
			}
		}
		if(anull==null){
			alert("성별을 입력하시오")
			return false;
		}
		//================teachers A======================
		 if(myform.job.selectedIndex<1){
			   alert("직업을 선택해주세요")
			   myform.job.focus();
			   return false;
		 }
		 
		 var chk=false;
		 for(i=0; i<myform.hobby.length; i++){
		   if(myform.hobby[i].checked){
			 chk=true; 
			 break;
		   }	 
		 }//for end
			 
		 if(chk==false){ // if(!chk){
		   alert("취미생활을 선택해주세요");
		   myform.hobby[0].focus();
		   return false;
		 }
			 
		alert("성공");
		//document.myform.submit();
	}
 </script>  
</head>

 <body>
	<form name="myform" onsubmit="move(); return false;">
		<fieldset>
			<legend>회원가입</legend>
			<div class="input_group first">
				<label>이 름:</label>
				<input type="text" name="user_name"  value="GilDong"/>
			</div>
			<div class="input_group">
				<label>성 별:</label>
				<label><input type="radio" name="gender" value="M"> 남자</label>
				<label><input type="radio" name="gender" value="F"> 여자</label>
			</div>
			<div class="input_group">
				<label>직업: </label>
				<select name="job" >
					<option>----- 선택하세요 -----</option>
					<option value="dev">프로그래머</option>
					<option value="pub">퍼블리셔</option>
				</select>
			</div>
			<div class="input_group">
				<label>취 미:</label>
				<label><input type="checkbox" value="축구" name="hobby"> 축구</label>
				<label><input type="checkbox" value="농구" name="hobby"> 농구</label>
				<label><input type="checkbox" value="야구" name="hobby"> 야구</label>
			</div>
			<div class="input_group">
				<label>&nbsp;</label>
				<input type="submit"  value="데이터전송제출" />
				<input type="reset"  value="입력취소" />
			</div>
		</fieldset>
	</form>
 </body>
</html>
