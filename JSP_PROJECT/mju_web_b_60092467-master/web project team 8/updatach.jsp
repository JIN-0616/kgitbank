<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"  import="java.sql.*" 
		import="org.apache.commons.lang3.StringUtils"%>
<% 
			Connection conn = null;
		PreparedStatement stmt = null;
		Statement stmtn = null;
		ResultSet rs = null;
		
		String dbUrl = "jdbc:mysql://127.0.0.1:3306/web2012?characterEncoding=utf8";
		String dbUser = "web";
		String dbPassword = "asdf";
		
		request.setCharacterEncoding("utf-8");
		String userid = session.getAttribute("userid").toString();
		String name = request.getParameter("name");
		String year = request.getParameter("year");
		String status = request.getParameter("status");
			
		
		
		List<String> errorMsgs = new ArrayList<String>();
		int result = 0;	
		
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
				
			        	 stmt = conn.prepareStatement(
			     				"UPDATE users " +
			     				"SET name=?, year=?, status=? " +
			     				"WHERE userid=?"
			     				);
			     		stmt.setString(1,  name);
			     		stmt.setString(2,  year);
			     		stmt.setString(3,  status);
			     		stmt.setString(4,  userid);
								 
				result = stmt.executeUpdate();
				if (result != 1) {
					errorMsgs.add("등록에 실패하였습니다.");
				}
		
			} catch (ClassNotFoundException e){	
			} catch (SQLException e) {
				errorMsgs.add("SQL 에러: " + e.getMessage());
			} finally {
				// 무슨 일이 있어도 리소스를 제대로 종료
				if (rs != null) try{rs.close();} catch(SQLException e) {}
				if (stmt != null) try{stmt.close();} catch(SQLException e) {}
				if (conn != null) try{conn.close();} catch(SQLException e) {}
			}
			 session.setAttribute("name",name);
			 request.getRequestDispatcher("map.jsp").forward(request, response);
			%>