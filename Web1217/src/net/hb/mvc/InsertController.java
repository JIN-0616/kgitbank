package net.hb.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hb.common.DBDAO;
import net.hb.common.DBbean;

@WebServlet("/Insert.do")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  response.setCharacterEncoding("UTF-8");
	  response.setContentType("text/html;charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  System.out.println("InsertController.java컨트롤문서");
	  out.println("<img src=images/aaa.gif>");
	  out.println("<img src=images/aaa.gif>");
	  out.println("<img src=images/aaa.gif>");	 
	  
	  int a = Integer.parseInt(request.getParameter("sabun"));
	  String b = request.getParameter("name");
	  String c = request.getParameter("title");	  
	  int d = Integer.parseInt(request.getParameter("pay"));
	  System.out.println(a +" "+b+" "+c+" "+d);
	  
	  DBbean bean = new DBbean();
	  DBDAO dao = new DBDAO();
	    bean.setSabun(a);
	    bean.setName(b);
	    bean.setTitle(c);
	    bean.setPay(d);
	  dao.dbInsert(bean);
	  response.sendRedirect("List.do");
  }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doUser(request,response);
	}

}
