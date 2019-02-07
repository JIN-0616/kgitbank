<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="bbs_ssi.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
  <%	
  	// 넘겨받은 데이터
  	request.setCharacterEncoding("UTF-8");
  	Gsabun = Integer.parseInt(request.getParameter("sabun"));
  	Gname = request.getParameter("name");
  	Gtitle = request.getParameter("title");
  	Gcontent = request.getParameter("content");
  	Gphone = request.getParameter("phone");
  	Gpwd = request.getParameter("pwd");
  	Gemail = request.getParameter("email");
  	Gjuso1 = request.getParameter("juso1");
  	Gjuso2 = request.getParameter("juso2");
  	Gurl = request.getParameter("url");

  	msg = "update bbs set b_name=?,b_title=?,b_content=?,b_phone=?,"
  			+"b_pwd=?,b_email=?,b_juso1=?,b_juso2=?,b_url=? where b_sabun=?";  		
  	pst = con.prepareStatement(msg);
	  	 pst.setString(1,Gname);
	  	 pst.setString(2,Gtitle);
	  	 pst.setString(3,Gcontent);
	  	 pst.setString(4,Gphone);
	  	 pst.setString(5,Gpwd);
	  	 pst.setString(6,Gemail);
	  	 pst.setString(7,Gjuso1);
	  	 pst.setString(8,Gjuso2);
	  	 pst.setString(9,Gurl);
	  	 pst.setInt(10,Gsabun);
  	pst.executeUpdate();   	  	
  	response.sendRedirect("bbsList1.jsp");  	
	%>
</body>
</html>