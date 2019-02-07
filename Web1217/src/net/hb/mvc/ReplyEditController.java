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

@WebServlet("/ReplyEdit.do")
public class ReplyEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  response.setCharacterEncoding("UTF-8");
	  response.setContentType("text/html;charset=UTF-8");
	  PrintWriter out = response.getWriter();	    
	  ////////////////////////////////////////////////////////////////////
	  //guestList.jsp문서의 제목클릭하면 <a href=detail.do?idx=${dto.sabun}> ${dto.title} </a>
	  String rdata = null;
	  String flag = null;
	  if(request.getParameter("idx")!=null) {
	    rdata = request.getParameter("idx");  
	  }
	  if(request.getParameter("flag")!=null){
	    flag = request.getParameter("flag");
	  }
	  
	  ReplyDAO rdao = new ReplyDAO();	 	
	  Replybean rbean = null;
	 	if(flag==null) {
	 	  rbean = rdao.replyEdit(Integer.parseInt(rdata));
  	 	request.setAttribute("rbean", rbean);
  	 	RequestDispatcher dis = request.getRequestDispatcher("guestreply_edit.jsp");
  	 	dis.forward(request, response);
	 	}else if(rdata==null) {
	 	  rbean = new Replybean();
	 	    rbean.setNum(Integer.parseInt(request.getParameter("num")));
	 	    rbean.setSabun(Integer.parseInt(request.getParameter("sabun")));
	 	    rbean.setWriter(request.getParameter("writer"));
	 	    rbean.setContent(request.getParameter("content"));	 	  
	 	  rdao.replyEdit(rbean);
	 	  response.sendRedirect("Detail.do?idx="+rbean.getSabun());
	  }	 	
  }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doUser(request,response);
	}

}
