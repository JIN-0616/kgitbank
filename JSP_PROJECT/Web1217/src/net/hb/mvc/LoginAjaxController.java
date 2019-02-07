package net.hb.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.hb.common.DB;

//URL매핑 web.xml문서에 기술
@WebServlet("/LoginAjax.do")
public class LoginAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  response.setCharacterEncoding("UTF-8");
	  response.setContentType("text/html;charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  
	  String uid = request.getParameter("UID");
	  String upwd = request.getParameter("UPWD");
	  
	  HttpSession session = request.getSession();
	  	  	  
	  try {
	    int total=0;
	    Connection CN = DB.getConnection();
	    String msg = "select count(*) as cnt from login where userid=? and pwd=? ";
	    
	    PreparedStatement PST = CN.prepareStatement(msg);
	      PST.setString(1, uid);
	      PST.setString(2, upwd);
	    ResultSet RS = PST.executeQuery();
	    if(RS.next()) {total=RS.getInt("cnt");}
	    if(total>0) {
	      session.setAttribute("temp", uid); //세션설정
	      out.println("<font size=7 color='#FF00FF'><b>jQuery Ajax Login성공</b></font><p>");
	      out.println("<img src=images/bt_login.gif width=450 height=70><p>");
	      out.println("<img src=images/bar.gif width=450 height=70>");
	    }else {
	      out.println("<font size=7 color=red><b>로그인실패</b></font><p>");
	      out.println("<img src=images/bar.gif width=450 height=70><br>");
	      out.println("<font size=7><a href='loginAjax.jsp'>[로그인]</a></font>");
	      out.println("<font size=7><a href='index.jsp'>[index]</a></font>");
	    }	    
	  }catch(Exception e){
	    e.printStackTrace();
	  }	 
  }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request,response);
    System.out.println("doGet:request,response");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doUser(request,response);
	  System.out.println("doPost:request,response");
	}

}
