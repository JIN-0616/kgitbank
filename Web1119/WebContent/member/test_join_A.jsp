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
	 
	 if(!chk){
	   alert("취미생활을 선택해주세요");
	   myform.hobby[0].focus();
	   return false;
	 }
	 
   }//move end
  </script>  
</head>

 <body>
	<form name="myform" onsubmit="move(); return false;">
		<fieldset>
			<legend> 회 원 가 입</legend>
			<div class="input_group first">
				<label>이 름:</label>
				<input type="text" name="user_name"  value="GilDong"/>
			</div>
			<div class="input_group">
				<label>성 별:</label>
				<label><input type="radio" name="gender" value="M"> 남자</label>
				<label><input type="radio" name="gender" value="F" checked> 여자</label>
			</div>
			<div class="input_group">
				<label>직 업: </label>
				<select name="job">
					<option>----- 선택하세요 -----</option>
					<option value="dev">프로그래머</option>
					<option value="pub">퍼블리셔</option>
					<option value="gamer">프로게임머</option>
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
