<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
 <style type="text/css">
   *{font-size: 20pt; font-weight: bold; font-family: 나눔고딕코딩; }
 </style>
</head>
<body>
	
  <%! // 전역변수 선언 
  
    // DB접속
  	Connection con;
  	Statement st, st2;
  	PreparedStatement pst;
  	CallableStatement cst;
  	ResultSet rs, rs2 ;
  	
  	// 전역변수 bbs , bbsreply
  	String msg, msg2 ;
  	int Gno, Gsabun, Gcnt, Gsize1;
  	String Gname, Gtitle, Gphone, Gpwd, Gcontent; 
  	String Gjuso1, Gjuso2, Gemail, Gurl, Gfile1;
  	
  	java.util.Date Gdate, Rdate;
  	
  	int Gtotal=0, Stotal=0, Rtotal=0;
  	int Rnum, Rrn, Rsabun, Rcnt;
  	String Rwriter, Rcontent;	
  
  %>
  
  <%
	try{
  		Class.forName("oracle.jdbc.driver.OracleDriver");
  		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
  		con = DriverManager.getConnection(url,"system","oracle");
  		//System.out.println("DB연결 success");
  	}catch(Exception e){System.out.println("DB에러 : "+e.toString());}
  
  %>

</body>
</html>

