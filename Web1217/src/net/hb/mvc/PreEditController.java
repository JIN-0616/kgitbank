package net.hb.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hb.common.DBDAO;
import net.hb.common.DBbean;

//URL매핑 web.xml문서에 기술
@WebServlet("/preEdit.do")
public class PreEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  response.setCharacterEncoding("UTF-8");
	  response.setContentType("text/html;charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  
	  DBDAO dao = new DBDAO();
	  int data = Integer.parseInt(request.getParameter("idx"));
	  
	  DBbean bean = dao.dbDetail(data);
	  request.setAttribute("bean", bean);
	  
	  RequestDispatcher dis = request.getRequestDispatcher("guestEdit.jsp");
	  dis.forward(request, response);	  
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
