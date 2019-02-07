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
 <%! 
   //ssi2.jsp
   Connection CN; 
   Statement ST, ST3 ; //ST=CN.createStatement()
   PreparedStatement PST; //PST=CN.prepareStatment(sql)
   CallableStatement CS; //CS=CN.callableStatement(sql)
   ResultSet RS, RS3; //  RS.next( )
 
   String msg, msg3; 
   int a,Gsabun,  d, Gpay ; 
   String b, Gname, c , Gtitle; 
   java.util.Date Gnalja; 
   int Gtotal=27, Stotal=7, Rtotal=0; 
   
   int Rnum ; 
   int Rrn ; 
   String Rdata, Rwriter, Rcontent; //guestreply.jsp
   int Rsabun;
   boolean flag=false;
 %>
 
 <%
   try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	CN=DriverManager.getConnection(url,"system", "oracle");
	//System.out.println("db success OK!!! ");
   }catch(Exception ex){System.out.println("db error:"+ex);}
 %>

 </body>
</html>


















