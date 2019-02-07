package net.hb.common;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class GlobalVariable {
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
  
}
