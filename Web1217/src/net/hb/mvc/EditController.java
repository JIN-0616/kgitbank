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
@WebServlet("/Edit.do")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  response.setCharacterEncoding("UTF-8");
	  response.setContentType("text/html;charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  
	  DBDAO dao = new DBDAO();
	  DBbean bean = new DBbean();
  	  bean.setSabun(Integer.parseInt(request.getParameter("sabun")));
      bean.setName(request.getParameter("name"));
      bean.setTitle(request.getParameter("title"));      
      bean.setPay(Integer.parseInt(request.getParameter("pay")));
	  dao.dbEdit(bean);    
    
	  response.sendRedirect("List.do");
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
