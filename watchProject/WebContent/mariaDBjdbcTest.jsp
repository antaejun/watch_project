<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%
	Connection conn = null;

	String driver = "org.mariadb.jdbc.Driver";
	String url = "jdbc:mariadb://203.245.28.69:3306/project_db";
	
	Boolean connect = false;
	
	try { 
		Class.forName(driver);
		
		conn = DriverManager.getConnection(url, "root", "manager123");
		
		connect = true;
		
		conn.close();
	}catch(Exception e){
		connect = false;
		e.printStackTrace();
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MariaDB Test</title>
</head>
<body>
<h3>
	<%if(connect == true) {%>
	연결 성공
	<%}else{ %>
	연결 실패
	<%} %>
</h3>
</body>
</html>