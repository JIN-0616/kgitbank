package net.hb.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hb.common.DBDAO;
import net.hb.common.DBbean;

@WebServlet("/Detail.do")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  response.setCharacterEncoding("UTF-8");
	  response.setContentType("text/html;charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  ////////////////////////////////////////////////////////////////////
	  DBDAO dao = new DBDAO();
	 	DBbean bean = dao.dbDetail(Integer.parseInt(request.getParameter("idx")));
	 	request.setAttribute("bean", bean);
	  //RequestDispatcher dis = request.getRequestDispatcher("guestDetail.jsp");
	  //dis.forward(request, response);
	 	RequestDispatcher dis = request.getRequestDispatcher("Reply.do");
	 	dis.forward(request, response);
  }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doUser(request,response);
	}

}
