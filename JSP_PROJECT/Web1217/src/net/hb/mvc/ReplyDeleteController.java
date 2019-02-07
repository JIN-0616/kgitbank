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

import net.hb.common.ReplyDAO;
import net.hb.common.Replybean;

@WebServlet("/ReplyDelete.do")
public class ReplyDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  response.setCharacterEncoding("UTF-8");
	  response.setContentType("text/html;charset=UTF-8");
	  PrintWriter out = response.getWriter();	    
	  ////////////////////////////////////////////////////////////////////
	  //guestList.jsp문서의 제목클릭하면 <a href=detail.do?idx=${dto.sabun}> ${dto.title} </a>
	  int rdata = Integer.parseInt(request.getParameter("idx"));
	  int sabun = Integer.parseInt(request.getParameter("sabun"));
	  ReplyDAO rdao = new ReplyDAO();	 	
	 	rdao.replyDelete(rdata);	 	
	 
	 	response.sendRedirect("Detail.do?idx="+sabun);	 	
  }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doUser(request,response);
	}

}
