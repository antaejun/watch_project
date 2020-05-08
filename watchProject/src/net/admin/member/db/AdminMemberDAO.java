package net.admin.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AdminMemberDAO {
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
				
				System.out.println("DB 연결 해제");
				System.out.println("con : " + con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	//해제
	
	//getMemberList()
	public List<AdminMemberDTO> getMemberList(){
		
		List<AdminMemberDTO> memberList = new ArrayList<AdminMemberDTO>();
		
		try {
			
			con = getConnection();
			
			sql = "select * from user";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				AdminMemberDTO amdto = new AdminMemberDTO();
				
				amdto.setIdx(rs.getInt("idx"));
				amdto.setUser_email(rs.getString("user_email"));
				amdto.setUser_pw(rs.getString("user_pw"));
				amdto.setUser_name(rs.getString("user_name"));
				amdto.setAddress(rs.getString("address"));
				amdto.setAddress_detail(rs.getString("address_detail"));
				amdto.setPhone(rs.getString("phone"));
				amdto.setRegist_date(rs.getTimestamp("regist_date"));
				amdto.setModify_date(rs.getTimestamp("modify_date"));
				amdto.setDelete_yn(rs.getString("delete_yn"));
				amdto.setUser_status(rs.getString("user_status"));
				
				memberList.add(amdto);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeDB();
		}
		
		return memberList;
	}
	//getMemberList()
	
	//disableMember(idx)
	public void disableMember(int idx){
		try {
			con = getConnection();
			
			sql = "update user set "
					+ "delete_yn = ?, modify_date = now() "
					+ "where idx = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "y");
			pstmt.setInt(2, idx);
			
			pstmt.executeUpdate();
			
			System.out.println("유저 비활성화 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeDB();
		}
	}
	//disableMember(idx)
	
	//ableMember(idx)
	public void ableMember(int idx){
		try {
			con = getConnection();
			
			sql = "update user set "
					+ "delete_yn = ?, modify_date = now() "
					+ "where idx = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, "n");
			pstmt.setInt(2, idx);
			
			pstmt.executeUpdate();
			
			System.out.println("유저 활성화 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeDB();
		}
	}
	//ableMember(idx)
	
	//getMember(idx)
	public AdminMemberDTO getMember(int idx){
		AdminMemberDTO amdto = null;
		
		try {
			con = getConnection();
			
			sql = "select * from user where idx=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				amdto = new AdminMemberDTO();
				
				amdto.setIdx(idx);
				amdto.setUser_email(rs.getString("user_email"));
				amdto.setUser_name(rs.getString("user_name"));
				amdto.setUser_pw(rs.getString("user_pw"));
				amdto.setAddress(rs.getString("address"));
				amdto.setAddress_detail(rs.getString("address_detail"));
				amdto.setPhone(rs.getString("phone"));
				amdto.setUser_status(rs.getString("user_status"));
				amdto.setRegist_date(rs.getTimestamp("regist_date"));
				amdto.setModify_date(rs.getTimestamp("modify_date"));
				amdto.setDelete_yn(rs.getString("delete_yn"));
				
			}
			
			System.out.println("불러온 회원 : "+ amdto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return amdto;
	}
	//getMember(idx)
	
	//adminMemberModify(amdto)
	public void adminMemberModify(AdminMemberDTO amdto){
		
		try {
			con = getConnection();
			
			sql = "update user set "
					+ "user_email=?, user_pw=?, user_name=?, "
					+ "address=?, address_detail=?, phone=?, "
					+ "modify_date=now(), user_status=? "
					+ "where idx = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, amdto.getUser_email());
			pstmt.setString(2, amdto.getUser_pw());
			pstmt.setString(3, amdto.getUser_name());
			pstmt.setString(4, amdto.getAddress());
			pstmt.setString(5, amdto.getAddress_detail());
			pstmt.setString(6, amdto.getPhone());
			pstmt.setString(7, amdto.getUser_status());
			pstmt.setInt(8, amdto.getIdx());
			
			pstmt.executeUpdate();
			
			System.out.println("회원 정보 수정 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeDB();
		}
	}
	//adminMemberModify(amdto)
	
}
