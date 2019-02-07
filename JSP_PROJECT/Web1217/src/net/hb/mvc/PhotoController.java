package net.hb.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/Photo.kg")
//URL매핑 web.xml문서에 기술
public class PhotoController extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  response.setCharacterEncoding("UTF-8");
	  response.setContentType("text/html;charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  out.println("<img src=images/aaa.gif>");	  out.println("<img src=images/aaa.gif>");
	  out.println("<img src=images/aaa.gif>");	  out.println("<img src=images/aaa.gif>");
	  out.println("<img src=images/aaa.gif>");    out.println("<img src=images/aaa.gif>");
	  out.println("<h1>");
	  out.println("<a href=index.jsp>[index.jsp]</a>");
	  out.println("<a href=login.jsp>[login.jsp]</a>");
	  out.println("<a href=guest.jsp>[guest.jsp]</a>");
	  out.println("</h1>");
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
