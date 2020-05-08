package net.inc.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.items.db.CodeDTO;

public class IncDAO {
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
	
	// getCodeList()
	public List<CodeDTO> getCodeList() {
		List<CodeDTO> codeList = new ArrayList<CodeDTO>(); 
		
		try {
			con = getConnection();
			
			sql = "SELECT * FROM code";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CodeDTO cdto = new CodeDTO();
				cdto.setCode(rs.getString("code"));
				cdto.setCode_name(rs.getString("code_name"));
				cdto.setDelete_yn(rs.getString("delete_yn"));
				cdto.setIdx(rs.getInt("idx"));
				cdto.setRegist_date(rs.getDate("regist_date"));
				
				codeList.add(cdto);
			}
			System.out.println(codeList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return codeList;
	}
	// getCodeList() END

}