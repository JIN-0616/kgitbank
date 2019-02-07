<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [BBB.jsp]</title>
  <style type="text/css">
    *{font-size:26pt; font-weight:bold; font-family:comic Sans MS ;  }
    a{font-size:26pt; font-weight:bold; color:blue; text-decoration:none; }
{font-size:26pt; font-weight:bold; color:green; text-decoration:underline; }                
  </style>
  
</head>
<body>
     <% request.setCharacterEncoding("UTF-8"); %>
	 <!-- BBB.jsp -->
	 <img src="images/bar.gif"><br>
	 <img src="images/bar.gif"><br>
	 <img src="images/bar.gif"><p>
<%
  String path=application.getRealPath("./storage");
  System.out.println("경로 " + path);
  int size=1024*1024*7;

  DefaultFileRenamePolicy dfr = new DefaultFileRenamePolicy( );
  //MultipartRequest(request,2경로,3사이즈,4인코딩,5중복여부);
  MultipartRequest mr=new MultipartRequest(request,path,size,"UTF-8");

  //MultipartRequest mr=new MultipartRequest(request,path,size,"UTF-8",dfr);

  String a=mr.getParameter("num");
  String b=mr.getParameter("title");
  //String c=mr.getParameter("file1"); //파일은 다르게 받아야 됩니다
  String c=mr.getFilesystemName("file1"); 
  //String d=mr.getOriginalFileName("file1");
 System.out.println("넘어온히든값  " + a +"<br>");
 System.out.println("넘어온제목값  " + b +"<br>");
 System.out.println("넘어온파일값  " + c +"<p>");
%>
								<!-- \ 사용하려면 \\ 두개사용 -->
  <!-- img src=" %=request.getContextPath()/storage/c%>images/aaa.gif" width=150 height=100 -->
  <!--  -->
  <img src="./storage/<%=c%>" width=250 height="200">
   <a href="filedownload.jsp?fileName=<%=c%>"> <img src="./storage/<%=c%>" width=250 height="200"> </a>
   <a href="filedownload.jsp?fileName=<%=c%>"> <img src="<%=request.getContextPath()%>/storage/<%=c%>" width=250 height="200"> </a>
  
  <img src="<%=request.getContextPath()%>/storage/<%=c%>" width=250 height="200">
   <a href="filedownload.jsp?fileName=<%=c%>"> <img src="./storage/<%=c%>" width=250 height="200"> </a>
   <a href="filedownload.jsp?fileName=<%=c%>"> <img src="<%=request.getContextPath()%>/storage/<%=c%>" width=250 height="200"> </a>

  <p>
  <a href="index.jsp">[index.jsp]</a>
  <a href="AAA.jsp">[AAA.jsp]</a>
  <a href="CCC.jsp">[CCC.jsp]</a>
</body>
</html>





