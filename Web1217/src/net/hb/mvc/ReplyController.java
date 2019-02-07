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

@WebServlet("/Reply.do")
public class ReplyController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    ////////////////////////////////////////////////////////////////////
    // guestList.jsp문서의 제목클릭하면 <a href=detail.do?idx=${dto.sabun}> ${dto.title} </a>
    String flag = request.getParameter("flag");
    System.out.println(flag);
    ReplyDAO rdao = new ReplyDAO();
    Replybean rbean = new Replybean();

    if (flag == null || flag == "") {
      int rdata = Integer.parseInt(request.getParameter("idx"));
      ArrayList<Replybean> rLG = rdao.replySelect(rdata);
      request.setAttribute("rnaver", rLG);
      request.setAttribute("rsabun", rdata);
      RequestDispatcher dis = request.getRequestDispatcher("guestDetail.jsp");
      dis.forward(request, response);
    } else {
      String a = request.getParameter("writer");
      String b = request.getParameter("content");
      int c = Integer.parseInt(request.getParameter("sabun"));
      rbean.setWriter(a);
      rbean.setContent(b);
      rbean.setSabun(c);
      rdao.replyInsert(rbean);
      response.sendRedirect("Detail.do?idx=" + c);
    }
  }// doUser end

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doUser(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doUser(request, response);
  }

}
