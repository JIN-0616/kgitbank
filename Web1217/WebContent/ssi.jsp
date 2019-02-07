<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>  </title>
  <style type="text/css">
    *{font-size:20pt; font-weight:bold;  font-family:  Segoe UI Symbol , comic Sans MS ;  }
    a{font-size:20pt; font-weight:bold; color:blue; text-decoration:none; }
{font-size:26pt; font-weight:bold; color:green; text-decoration:underline; }                
  </style>
 
</head>
<body>
 <%! //전역변수,전역함수
   //ssi.jsp문서는 단독실행가능합니다
   Connection CN; //DB서버연결정보,명령어생성할때 참조 
   Statement ST, ST3 ; //ST=CN.createStatement()
   PreparedStatement PST; //PST=CN.prepareStatment(sql)
   CallableStatement CS; //CS=CN.callableStatement(sql)
   ResultSet RS, RS3; //조회한결과를 RS기억  RS.next( )
 
   String msg, msg3; //msg="쿼리문기술"
   int a,Gsabun,  d, Gpay ; //사번,급여
   String b, Gname, c , Gtitle; //이름, 제목
   java.util.Date Gnalja; //날짜
   int Gtotal=27, Stotal=7, Rtotal=0; //조회수 
   
   int Rnum ; //댓글의  num필드기억
   int Rrn ; //댓글의  rownum필드기억 
   String Rdata, Rwriter, Rcontent; //guestreply.jsp문서에서 사용
   int Rsabun;
   boolean flag=false;
 %>
 
 <%
   try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	CN=DriverManager.getConnection(url,"system", "oracle");
	//System.out.println("db연결 성공했습니다 11-26-월요일 8시 43분 ");
   }catch(Exception ex){System.out.println("db에러:"+ex);}
 %>

 </body>
</html>


















