<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="./ssi.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[guestreply_insert.jsp]</title></head>
<body>
  <%
  	//guestreply_insert.jsp
  	msg="insert into guestreply values(guestreply_seq.nextval, 'LG', 'KB', 7789)";
    int sabun = Integer.parseInt(request.getParameter("sabun"));
    String writer = request.getParameter("writer");
    String content = request.getParameter("content");
    msg= "insert into guestreply values(guestreply_seq.nextval, ?,?,?)";
    PST=CN.prepareStatement(msg);
    	PST.setString(1, writer);
    	PST.setString(2, content);
    	PST.setInt(3, sabun);
    PST.executeUpdate();
    System.out.println("댓글저장 성공했습니다.");
    response.sendRedirect("guestDetail.jsp?idx="+sabun);
    //response.sendRedirect("guestreply.jsp?idx="+sabun);
    
  %>

 
  	
</body>
</html>