package net.code.detail.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.code.db.CodeDTO;

public class CodeDetailDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";
	
	//DB Con
	private Connection getConnection() throws Exception{
		Context init = new InitialContext();
		
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/watchDB");
		
		con = ds.getConnection();
		
		System.out.println("DB 연결 완료 : " + con);
		
		return con;
	}
	//DB Con
	
	//DB Close
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
	//DB Close
	
	//addCodeDetail(cddto)
	public void addCodeDetail(CodeDetailDTO cddto){
		int idx = 0;
		
		try {
			con = getConnection();
			
			sql = "select max(idx) from code_detail";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				idx = rs.getInt("max(idx)") + 1;
			}
			
			System.out.println("상세 코드 번호 idx : "+idx);
			
			sql = "insert into code_detail(idx, code_detail, code_detail_name, code) "
					+ "values(?,?,?,?) ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setString(2, cddto.getCode_detail());
			pstmt.setString(3, cddto.getCode_detail_name());
			pstmt.setInt(4, cddto.getCode());
			
			pstmt.executeUpdate();
			
			System.out.println("-----------코드 디테일 등록 성공-----------");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeDB();
		}
	}
	//addCodeDetail(cddto)
	
	//getCodeDetailList()
	public List<CodeDetailDTO> getCodeDetailList(int code){
		List<CodeDetailDTO> codeDetailList = new ArrayList<CodeDetailDTO>();
		System.out.println("코드는 :" +code+"codecodecode");
		try {
			con = getConnection();
			
			sql = "select * from code_detail "
					+ "where code = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				CodeDetailDTO cddto = new CodeDetailDTO();
				
				cddto.setIdx(rs.getInt("idx"));
				cddto.setCode_detail(rs.getString("code_detail"));
				cddto.setCode_detail_name(rs.getString("code_detail_name"));
				cddto.setCode(rs.getInt("code"));
				cddto.setRegist_date(rs.getTimestamp("regist_date"));
				cddto.setDelete_yn(rs.getString("delete_yn"));
				
				codeDetailList.add(cddto);
			}
				System.out.println("상세 목록" + codeDetailList.size()+"개");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeDB();
		}
		
		return codeDetailList;
	}
	//getCodeDetailList()
	
	//disableCodeDetail(idx)
	public void disableCodeDetail(int idx){
		
		try {
			con = getConnection();
			
			sql = "update code_detail set "
					+ "delete_yn = ? "
					+ "where idx = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, "y");
			pstmt.setInt(2, idx);
			
			pstmt.executeUpdate();
			
			System.out.println("상세 코드 비활성화 완료");
					
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeDB();
		}
		
	}
	//disableCodeDetail(idx)
	
	//ableCodeDetail(idx)
	public void ableCodeDetail(int idx){
		
		try {
			con = getConnection();
			
			sql = "update code_detail set "
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
	//ableCodeDetail(idx)
	
	//modifyCodeDetail(cddto)
	public void modifyCodeDetail(CodeDetailDTO cddto){
		
		try {
			con = getConnection();
			
			sql = "update code_detail set "
					+ "code_detail=?, code_detail_name=? "
					+ "where idx=?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, cddto.getCode_detail());
			pstmt.setString(2, cddto.getCode_detail_name());
			pstmt.setInt(3, cddto.getIdx());
			
			pstmt.executeUpdate();
			
			System.out.println("코드 상세 정보 수정 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeDB();
		}
	}
	//modifyCodeDetail(cddto)
	

}
