package net.hb.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hb.common.DBDAO;

//@WebServlet("/Delete.do")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  response.setContentType("text/html;charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  
	  System.out.println("<h1>DeleteController.java컨트롤문서</h1><br>");	  
	  int data = Integer.parseInt(request.getParameter("idx"));
	  DBDAO dao = new DBDAO();
	  dao.dbDelete(data);//ctal+f5
	  response.sendRedirect("List.do");	  
  }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doUser(request,response);
	}

}
