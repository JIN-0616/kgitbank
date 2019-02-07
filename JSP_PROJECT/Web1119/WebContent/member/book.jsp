<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[book.jsp]</title>
 <style type="text/css">
   *{font-size: 20pt; font-weight: bold; }
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
 		if(b=="" || b==null){
 			alert("급여를 입력하시오");
 			myform.pay.focus();
 			return false;
 		} 		
 		// 입력란 공백이 아니면 action을 타도록 강제 submit
 		//document.myform.submit();
 		
 		
		// button일때는 myform을 꼭 달아둘것
		// form태그에 직접 달때는 myform 생략가능
		// submit이라도 onsubmit="move(); return false; 때문에
		// move 내부에서 submit을 호출해야된다.
		// ===> 결론 : 폼태그에서 널체크함수 호출하고 return false;하면 
		//            널체크함수에서 sumbit을 꼭 호출해줘야 한다.
		//			  이때 접근은 
		//			  1)document.myform.submit();
		//		      2)document.submit();
 		//document.submit();

		
 	}//end
 </script>
</head>
<body>
	<!-- book.jsp -->
	book.jsp-post<p>
	<form name="myform" method="post" onsubmit="move(); return false;" action="bookSave.jsp">
				<!-- 생략하면 default : get방식 -->
		제목: <input type="text" name="title"><p>
		급여: <input type="text" name="pay" maxLength="3"><p>
			<input type="button" value="button데이터전송">
			<input type="reset" value="취소"><p>
	</form>
	

</body>
</html>