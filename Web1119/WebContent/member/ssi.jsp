<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<!-- 선언시에는 절대 세미콜론을 찍으면 안됨 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[ssi.jsp]</title>
 <style type="text/css">
   *{font-size: 20pt; font-weight: bold; }
   a{font-size: 20pt; font-weight: bold; color: blue; text-decoration: none;}
{font-size: 20pt; font-weight: bold; color: green; text-decoration: underline;}
 </style>
 <script type="text/javascript"> 
 </script>
</head>
<body>
	<!-- 전역변수, 전역함수 넣기 -->
  <%! // 전역변수, 전역함수 넣기
    Connection CN; 	//DB서버연결정보, 명령어 생성할때 참조
  	Statement ST, ST3;	//ST = CN.createStatement();
  	PreparedStatement PST;	//PST = CN.prepareStatement(sql);
  	CallableStatement CS;	//CS = CN.callableStatement(sql);
  	ResultSet RS, RS3;	//조회한결과를 RS기억, RS.next();
  
	String msg, msg3;		//msg = "쿼리문기술"
  	int a, Gsabun, d, Gpay;	//사번, 급여
  	String b, Gname, c, Gtitle;	//이름, 제목
  	java.util.Date Gnalja; 	//날짜, 직접적는이유는 sql패키지의 date와 겹침
  	int Gtotal=27, Stotal=7, Rtotal=0;//조회수
  	int Rnum; //댓글의 num필드 기억
  	int Rrn;  //댓글의 rownum필드 기억
    String Rdata, Rwriter, Rcontent; //guestreply.jsp문서에서 사번값기억 
    int Rsabun;
  	
  	
  %>
  <%
  	try{
  		Class.forName("oracle.jdbc.driver.OracleDriver");
  		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
  		CN = DriverManager.getConnection(url,"system","oracle");
  		//System.out.println("DB연결 success");
  	}catch(Exception e){System.out.println("DB에러 : "+e.toString());}
  %>  
 
</body>
</html>