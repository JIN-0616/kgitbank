<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="bbs_ssi.jsp" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
  <%
	request.setCharacterEncoding("UTF-8");
    
    String path = application.getRealPath("storage");
    int size = 1024*1024*12;
    
    DefaultFileRenamePolicy dfr = new DefaultFileRenamePolicy();
    MultipartRequest mr = new MultipartRequest(request,path,size,"UTF-8",dfr);
  	
  
  	// 넘겨받은 데이터
  	Gsabun = Integer.parseInt(mr.getParameter("sabun"));
  	Gname = mr.getParameter("name");
  	Gtitle = mr.getParameter("title");
  	Gcontent = mr.getParameter("content");
  	Gphone = mr.getParameter("phone");
  	Gpwd = mr.getParameter("pwd");
  	Gemail = mr.getParameter("email");
  	Gjuso1 = mr.getParameter("juso1");
  	Gjuso2 = mr.getParameter("juso2");
	Gurl = mr.getParameter("url");
	Gfile1 = mr.getFilesystemName("file1");
	
	//수정중
	
  	msg = "SELECT COUNT(*) AS CNT FROM BBS WHERE B_SABUN=?";  		
  	pst = con.prepareStatement(msg);
  		pst.setInt(1, Gsabun);
  	rs = pst.executeQuery();
  	
  	if(rs.next()){
  		Gtotal=rs.getInt("CNT");  		
  	}
  	if(Gtotal>0){
  %>	
  	<script type="text/javascript">
  		alert(<%=Gsabun %>+"데이터가 중복, 사용불가");
  		history.back();
  	</script>
  <%
  	}else{
  	
  	String a = "INSERT INTO BBS VALUES(";
  	String b = "bbs_seq.nextval,?,?,?,0,";
  	String c = "?,?,?,sysdate,?,";
  	String d = "?,?,?,?,0)";
  	msg = a+b+c+d;
  	pst = con.prepareStatement(msg);
  		pst.setInt(1, Gsabun);
  		pst.setString(2, Gname);
  		pst.setString(3, Gtitle);
  		
  		pst.setString(4, Gcontent);
  		pst.setString(5, Gphone);
  		pst.setString(6, Gpwd);  		
  		pst.setString(7, Gjuso1);
  		
  		pst.setString(8, Gjuso2);  		
  		pst.setString(9, Gemail);
  		pst.setString(10, Gurl);
  		pst.setString(11, Gfile1);
  	pst.executeUpdate();
  	
  	System.out.println(Gsabun + "insert처리실행");
  	response.sendRedirect("bbsList1.jsp");
  	}
  %>

</body>
</html>