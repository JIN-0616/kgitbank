<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [DDD.jsp]</title>
  <style type="text/css">
    *{font-size:26pt; font-weight:bold; font-family:comic Sans MS ;  }
    a{font-size:26pt; font-weight:bold; color:blue; text-decoration:none; }
{font-size:26pt; font-weight:bold; color:green; text-decoration:underline; }                
  </style>
  
</head>
<body>
  <% request.setCharacterEncoding("UTF-8"); %>
	 <!-- DDD.jsp -->
	 <img src="images/top.jpg"><p>
 <%
   request.setCharacterEncoding("UTF-8");
  
   if(FileUpload.isMultipartContent(request)){
	 String upDir = application.getRealPath("./storage");  
	 DiskFileUpload  dfu=new DiskFileUpload( );
	 
	 //처음업로드한 파일이 아니면 메모리에저장
	 dfu.setRepositoryPath(upDir);
	 dfu.setSizeMax(1024*1024*7); 
	 dfu.setSizeThreshold(1024*1024); //한번에 1024*1024까지만 메모리저장
	 
	 if(request.getContentLength()<dfu.getSizeMax()){
	   List fList=dfu.parseRequest(request);
	   int size=fList.size();
	   for(int i=0; i<fList.size(); i++){
		 FileItem fileitem=(FileItem)fList.get(i);
		 if(fileitem.isFormField()==true){
			System.out.println("아파치 넘어온필드:" +fileitem.getFieldName()+"="+fileitem.getString()); 
		 }else{
			 System.out.print("파일:" +fileitem.getFieldName()+"="+fileitem.getName());
			 System.out.println("(" +fileitem.getSize( )+"Byte)");
			
			if(fileitem.isInMemory()==true){
			   System.out.println("메모리에 저장 ");
			   System.out.println(upDir);	
			}else{ System.out.println("디스크에 저장"); }
			
			if(fileitem.getSize()>0){
			  System.out.println("getName()="+fileitem.getName());
			  int idx=fileitem.getName().lastIndexOf("\\");
			  if(idx==-1){idx=fileitem.getName().lastIndexOf("/"); }
			  String fileName=fileitem.getName().substring(idx+1);
			  System.out.println("idx="+idx+" fileName="+fileName+"\n");
			  
			  //String fileName=fileitem.getName();
			  //System.out.println("fileName="+fileName+"\n");
			   try{
				 File file=new File(upDir,fileName);
				 fileitem.write(file);
			   }catch(Exception ex){ System.out.println("error:"+ex);}
			}
		 }//else 
	   }//for end
	 }else{
	  int overSize=(request.getContentLength()/1000000);
	  System.out.println("파일의크기는 "+ overSize +" MB");
	 }//size비교 else end
   }else{ 
	  System.out.println("인코딩타입이 multipart/form-data가 아닙니다");
   }
  %>
	 
  <a href="index.jsp">[index.jsp]</a>
  <a href="CCC.jsp">[아파치적용CCC.jsp]</a>
  <a href="AAA.jsp">[cos적용AAA.jsp]</a>
</body>
</html>





