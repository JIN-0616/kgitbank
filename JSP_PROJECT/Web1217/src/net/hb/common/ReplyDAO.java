package net.hb.common;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class ReplyDAO extends GlobalVariable{
  public ReplyDAO() {
    CN = DB.getConnection();
  }//생성자 end
	
  
  public void replyInsert(Replybean rbean) {
  	try { 
  	  msg="insert into guestreply values(guestreply_seq.nextval,?,?,?)";	    
  	  PST=CN.prepareStatement(msg);  	    
  	    PST.setString(1, rbean.getWriter());
  	    PST.setString(2, rbean.getContent());
  	    PST.setInt(3, rbean.getSabun());
  	  PST.executeUpdate();	
  	  System.out.println("replyInsert(Replybean bean) 저장성공");
  	}catch(Exception ex) {System.out.println("Error: "+ex);}
  }
  
  public ArrayList<Replybean> replySelect(int Rdata) {
    ArrayList<Replybean> rlist = new ArrayList<Replybean>();
    try {
      String x = " select  rownum rn, g.sabun,r.num,r.writer,r.content from guest g ";
      String y = " inner join guestreply r ";
      String m = " on  g.sabun=r.sabun ";
      String z = " and r.sabun=" + Rdata + "order by r.num" ;
      msg = x + y + m + z;
      ST = CN.createStatement();
      RS = ST.executeQuery(msg);
      while(RS.next()){
        Replybean rbean = new Replybean();
        rbean.setNum(RS.getInt("num"));
        rbean.setWriter(RS.getString("writer"));
        rbean.setContent(RS.getString("content"));
        rbean.setSabun(RS.getInt("sabun"));
        rlist.add(rbean); //반드시 필요         
      }
    } catch (Exception ex) {
      System.out.println("Error: " + ex);
    }
    return rlist;
  }
  
  public void replyDelete(int data) {
  	try { 	   	  
  	  msg="delete from guestreply where num = "+data;
  	  ST = CN.createStatement();
  	  RS = ST.executeQuery(msg);
  	}catch(Exception ex) {System.out.println("Error: "+ex);}  
  }
  
  public Replybean replyEdit(int rdata) {
    Replybean rbean = new Replybean();
    try {
      msg = "select * from guestreply where num = "+rdata;
      ST = CN.createStatement();
      RS = ST.executeQuery(msg);
      if(RS.next()) {
         rbean.setNum(rdata);
         rbean.setWriter(RS.getString("writer"));
         rbean.setContent(RS.getString("content"));         
         rbean.setSabun(RS.getInt("sabun"));
      }
    }catch(Exception ex) {System.out.println("Error: "+ex);}
    return rbean;
  }
  public void replyEdit(Replybean rbean) {    
    try {
      msg="update guestreply set writer=?, content=? where num=? and sabun=?";      
      PST=CN.prepareStatement(msg);       
        PST.setString(1, rbean.getWriter());
        PST.setString(2, rbean.getContent());
        PST.setInt(3, rbean.getSabun());
      PST.executeUpdate();       
    }catch(Exception ex) {System.out.println("Error: "+ex);}   
  }
  
  
}
