package net.code.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CodeDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";
	
	//DB연결
	private Connection getConnection() throws Exception {
		Context init = new InitialContext();
		
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/watchDB");
		
		con = ds.getConnection();
		
		System.out.println("DB 연결 완료 : " + con);
		
		return con;
	}
	//DB연결
	
	//해제
	public void closeDB(){
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(con != null)
					con.close();
				
				System.out.println("DB연결 해제");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	//해제
	
	//addCode(cdto)
	public void addCode(CodeDTO cdto){
		System.out.println("관리자 코드 추가 메서드");
		int idx = 0;
		
		try {
			con = getConnection();
			
			sql = "select max(idx) from code";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				idx = rs.getInt("max(idx)")+1;
			}
			
			System.out.println("코드 번호 idx : " + idx);
			
			sql = "insert into code(idx,code,code_name) "
					+ "values(?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setInt(2, cdto.getCode());
			pstmt.setString(3, cdto.getCode_name());
			
			pstmt.executeUpdate();
			
			System.out.println("------------코드 등록 성공----------");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeDB();
		}
	}
	//addCode(cdto)
	
	//getCodesList()
	public List<CodeDTO> getCodesList(){
		List<CodeDTO> codesList = new ArrayList<CodeDTO>();
		
		
			try {
				con = getConnection();
				sql = "select * from code";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					CodeDTO cdto = new CodeDTO();
					
					cdto.setIdx(rs.getInt("idx"));
					cdto.setCode(rs.getInt("code"));
					cdto.setCode_name(rs.getString("code_name"));
					cdto.setRegist_date(rs.getTimestamp("regist_date"));
					cdto.setDelete_yn(rs.getString("delete_yn"));
					
					codesList.add(cdto);
				}
					System.out.println("코드 목록 " + codesList.size()+"개");
			} catch (Exception e) {
				e.printStackTrace();
			
		}finally{
			closeDB();
		}
		
		return codesList;
	}
	//getCodesList()
	
	//disableCode(idx)
	public void disableCode(int idx){
		try {
			con = getConnection();
			
			sql = "update code set "
					+ "delete_yn = ? "
					+ "where idx = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, "y");
			pstmt.setInt(2, idx);
			
			pstmt.executeUpdate();
			
			System.out.println("코드 비활성화 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeDB();
		}
	}
	//disableCode(idx)
	
	//ableCode(idx)
	public void ableCode(int idx){
		try {
			con = getConnection();
			
			sql = "update code set "
					+ "delete_yn = ? "
					+ "where idx = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, "n");
			pstmt.setInt(2, idx);
			
			pstmt.executeUpdate();
			
			System.out.println("코드 활성화 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeDB();
		}
	}
	//ableCode(idx)
	
	//getCode(idx)
	public CodeDTO getCode(int idx){
		CodeDTO cdto = null;
		
		try {
			con = getConnection();
			
			sql = "select * from code where idx = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				cdto = new CodeDTO();
				
				cdto.setIdx(idx);
				cdto.setCode(rs.getInt("code"));
				cdto.setCode_name(rs.getString("code_name"));
				cdto.setRegist_date(rs.getTimestamp("regist_date"));
				cdto.setDelete_yn(rs.getString("delete_yn"));
			}
			
			System.out.println("저장된 정보 : " + cdto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeDB();
		}
		
		return cdto;
	}
	//getCode(idx)
	
	//modifyCode(cdto)
	public void modifyCode(CodeDTO cdto){
		try {
			con = getConnection();
			
			sql = "update code set "
					+ "code=?, code_name=? "
					+ "where idx=?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, cdto.getCode());
			pstmt.setString(2, cdto.getCode_name());
			pstmt.setInt(3, cdto.getIdx());
			
			pstmt.executeUpdate();
			
			System.out.println("코드 정보 수정 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeDB();
		}
	}
	//modifyCode(cdto)
}
