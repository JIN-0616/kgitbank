<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[guest.jsp]</title>
 <style type="text/css">
   *{font-size: 20pt; font-weight: bold; font-family: comic sans MS; }
   a{font-size: 20pt; font-weight: bold; color: blue; text-decoration: none;}
{font-size: 26pt; font-weight: bold; color: green; text-decoration: underline;}
 </style>
 <script type="text/javascript">
 	function move(){
 		var a = document.myform.title.value;
 		var b = myform.pay.value; 		
 		
 		if(a=="" || a==null){
 			alert("제목을 입력하시오");
 			myform.title.focus();
 			return false;
 		}else{
 			myform.pay.focus();
 		}
 		if(b=="" || b==null || b>=100){
 			alert("급여를 정확하게 입력하시오");
 			myform.pay.focus();
 			return false;
 		}
 		//button일때 myform기술해야함
 		document.submit();
 	}//end
 	
 	//급여숫자체크만 추가 급여자릿수 2자리체크하면 더 좋음
 </script>
</head>
<body>
	<font color=blue> [guest.jsp]</font><p>	
	
	<form name="myform" action="guestSave.jsp">
		사번: <input type="text" name="sabun" size=8><input type="button" value="아이디중복">
	      <br>
		이름: <input type="text" name="name"><p>
		제목: <input type="text" name="title" value="snow"><p>
		급여: <input type="text" name="pay" value="97"><p>
			<input type="submit" value="서브밋데이터전송">
			<input type="reset" value="취소"><p>
	</form>
	
	<p>
	<a href="index.jsp">[index]</a>
	<a href="guest.jsp">[신규등록]</a>
	<a href="guestList.jsp">[전체출력]</a>
	<a href="ssi.jsp">[ssi]</a>

</body>
</html>