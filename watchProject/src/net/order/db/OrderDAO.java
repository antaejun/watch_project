package net.order.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class OrderDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";
	
	private Connection getConnection() throws Exception {
		Context init = new InitialContext();
		
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/watchDB");
		
		con = ds.getConnection();
		
		System.out.println(" 디비 연결 완료 : " + con);
		return con;
	}
	
	public void closeDB() {
		try {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
			
			System.out.println(" 자원해제 완료 ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addOrder(OrderDTO odto) {
		
		int idx = 0;
		int order_code = 0;
		
		Calendar cal = Calendar.getInstance();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		try {
			con = getConnection();
			
			sql = "SELECT max(idx) FROM order";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				idx = rs.getInt(1) + 1;
			}
			
			order_code = idx;
			
			System.out.println(" 주문 일련번호 : " + idx + ", 주문번호 : " + order_code);
			
			sql = "INSERT INTO order "
					+ "VALUES("
					+ "?,?,?,?,(now),"
					+ "?,?,?,?,?,"
					+ "?,?,?,?,?,"
					+ "?,?,(now),?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setString(2, sdf.format(cal.getTime()).toString()+"-"+order_code);
			pstmt.setString(3, odto.getItem_code());
			pstmt.setString(4, odto.getOrder_status());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
			
		}
		
		
		
		
		
		
		
	}

}
