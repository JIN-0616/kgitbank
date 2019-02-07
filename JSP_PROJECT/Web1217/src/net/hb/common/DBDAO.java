package net.hb.common;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class DBDAO extends GlobalVariable{
  public DBDAO() {
    CN = DB.getConnection();
  }//생성자 end
	
  
  public void dbInsert(DBbean bean) {
	try { //권장
	  msg="insert into guest values(?,?,?,sysdate,?)";	    
	  PST=CN.prepareStatement(msg);
	    PST.setInt(1,bean.getSabun());
	    PST.setString(2,bean.getName());
	    PST.setString(3,bean.getTitle());
	    PST.setInt(4,bean.getPay());	    
	  PST.executeUpdate();	
	  System.out.println("dbInsert(DBbean bean) 저장성공");
	}catch(Exception ex) {System.out.println("Error: "+ex);}
  }
  
    
  public ArrayList<DBbean> dbSelect(int start, int end, String skey, String sval) {
    ArrayList<DBbean> list = new ArrayList<DBbean>();
    String sqry = " where "+ skey + " like '%"+sval+"%' ";
    try {     
      String x=" select * from (";
      String y=" select rownum rn, sabun, name, title, nalja, pay from ";
      String q=" (select * from guest "+sqry +" order by sabun)";
      String z=" ) where rn between "+start+" and "+end ;
    
      msg = x+y+q+z;
      ST = CN.createStatement();
      RS = ST.executeQuery(msg);
      while(RS.next()==true){
        DBbean bean = new DBbean();
          bean.setRn(RS.getInt("rn")); //추가
          bean.setSabun(RS.getInt("sabun"));
          bean.setName(RS.getString("name"));
          bean.setTitle(RS.getString("title"));
          bean.setNalja(RS.getDate("nalja"));
          bean.setPay(RS.getInt("pay"));
          msg3 = "select count(*) as rcnt from guestreply where sabun="+RS.getInt("sabun");
          ST3=CN.createStatement();
          RS3=ST3.executeQuery(msg3);
          if(RS3.next()==true){bean.setReply((RS3.getInt("rcnt")));}
        list.add(bean); //반드시 필요한 항목추가 잊지말것
      }
    }catch(Exception ex) {System.out.println("Error: "+ex);}      
    return list;
  }//dbSelect() end
    
  
  public void dbDelete(int data) {
	try {
	  msg="delete from guest where sabun = "+data;
	  ST = CN.createStatement();
	  RS = ST.executeQuery(msg);
	}catch(Exception ex) {System.out.println("Error: "+ex);}  
  }
  
  public int dbCount(String skey, String sval) {
    try {
      String sqry = " where "+ skey + " like '%"+sval+"%' ";
      msg = "select count(*) as cnt from guest "+sqry;
      ST = CN.createStatement();
      RS = ST.executeQuery(msg);    
      RS.next();
      Gtotal=RS.getInt("cnt");
    }catch(Exception ex) {System.out.println("Error: "+ex);}  
    return Gtotal;
  }
  
  public int dbCount() {
    try {
  	  msg = "select count(*) as cnt from guest";
  	  ST = CN.createStatement();
  	  RS = ST.executeQuery(msg);	  
  	  RS.next();
  	  Gtotal=RS.getInt("cnt");
  	}catch(Exception ex) {System.out.println("Error: "+ex);}  
    return Gtotal;
  }
  
//  public int dbReplyCount(int sabun) {
//    try {
//      msg = "select count(*) as cnt from guestreply where sabun="+sabun;
//      ST = CN.createStatement();
//      RS = ST.executeQuery(msg);    
//      RS.next();
//      Rtotal=RS.getInt("cnt");
//    }catch(Exception ex) {System.out.println("Error: "+ex);}  
//    return Rtotal;
//  }
  
  
  public DBbean dbDetail(int sabun) {
    DBbean bean = new DBbean();
    try {      
      msg = "select * from guest where sabun="+sabun;
      ST = CN.createStatement();
      RS = ST.executeQuery(msg);
      if(RS.next()) {        
        bean.setSabun(sabun);
        bean.setName(RS.getString("name"));
        bean.setTitle(RS.getString("title"));
        bean.setNalja(RS.getDate("nalja"));
        bean.setPay(RS.getInt("pay"));       
      }      
    } catch (Exception e) {System.out.println("Error: "+e);}    
    return bean;    
  }
  
  public void dbEdit(DBbean bean) {    
    try {      
      msg = "update guest set name=?,title=?,nalja=sysdate, pay=? where sabun=?";
                                        // SQL문에서 ' ' 인식안됨
      PST = CN.prepareStatement(msg);
        PST.setString(1, bean.getName());
        PST.setString(2, bean.getTitle());        
        PST.setInt(3, bean.getPay());
        PST.setInt(4, bean.getSabun());
      PST.executeQuery();
      System.out.println(bean.getSabun() + "수정 완료");
    } catch (Exception e) {System.out.println("Error: "+e);}       
  }
  
  public void dbtest(){
  	try {
  	  //틀=모형=복붙
  	}catch(Exception ex) {System.out.println("Error: "+ex);}  
  }
  
  
}
