package net.user.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql="";
	
	// 디비 연결(커넥션 풀 사용)
	private Connection getConnection() throws Exception{
		// Context 객체를 생성
		Context init = new InitialContext();
		
		DataSource ds 
		 = (DataSource) init.lookup("java:comp/env/jdbc/watchDB");
		System.out.println("DB 접속 성공");
		con = ds.getConnection();
		
		return con;
	}
	
	// 자원 해제 
	
	public void closeDB(){
		try {
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
			if(con !=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// insertUser(ur)
	public void insertUser(UserBean ur){
		
		try {
			// 1,2
			con = getConnection();
			System.out.println(" DB 연결 성공 ");
			
			// 3 sql 작성
			sql="insert into user "
					+ "values(?,?,?,?,?,?,now,now,?,?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, ur.getUser_email());
			pstmt.setString(2, ur.getUser_pw());
			pstmt.setString(3, ur.getUser_name());
			pstmt.setString(4, ur.getAddress());
			pstmt.setString(5, ur.getAddress_detail());
			pstmt.setString(6, ur.getPhone());
			pstmt.setTimestamp(7, ur.getRegist_date());
			pstmt.setTimestamp(8, ur.getModify_date());
			pstmt.setString(9, ur.getDelete_yn());
			pstmt.setString(10, ur.getUser_status());
			// 4 실행
			int check = pstmt.executeUpdate();
			
			if(check == 1){
				System.out.println(" 정상처리 ");
			}else{
				System.out.println(" 문제 발생( 데이터 저장 오류 ) ");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
	}
	// insertUser(ur)
	
	// idCheck(user_email,user_pw)
	public int idCheck(String user_email,String user_pw){
		int check = -1;
		
		try {
			// 1,2
			con = getConnection();
			
			// 3 sql
			sql = "select user_pw from user where user_email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_email);
			
			// 4 실행
			rs = pstmt.executeQuery();
			
			// 5
			if(rs.next()){
               if(user_pw.equals(rs.getString("user_pw"))){
            	   // 아이디도 있고, 비밀번호 같음=> 회원(로그인성공)
            	   check = 1;            	   
               }else{
            	   // 아이디는 있지만, 비밀번호가 오류
            	   check=0;
               }
			}else{
				//회원아님
				check = -1;
			}
			
			System.out.println(" 아이디 체크 완료 : "+check);			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}	
		
		return check;
	}
	// idCheck(user_email,user_pw)
	

	// getUser(user_email)
	public UserBean getUser(String user_email){
		UserBean ur = null;
		
		try {
			// 1,2
			con = getConnection();
			// 3 sql
			sql = "select * from user where user_email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_email);
			
			// 4 실행
			rs = pstmt.executeQuery();
			
			// 5 rs 비교
			if(rs.next()){
				// 회원정보를 저장 
				ur = new UserBean();
				
				ur.setAddress(rs.getString("address"));
				ur.setAddress_detail(rs.getString("address_detail"));
				ur.setDelete_yn(rs.getString("delete_yn"));
				ur.setModify_date(rs.getTimestamp("modify_date"));	
				ur.setPhone(rs.getString("phone"));
				ur.setReg_date(rs.getTimestamp("regist_date"));
				ur.setUser_email(rs.getString("user_email"));			
				ur.setUser_name(rs.getString("user_name"));			
				ur.setUser_pw(rs.getString("user_pw"));			
				ur.setUser_status(rs.getString("user_status"));			
			}
			
			System.out.println(user_email+" 정보 : "+ur);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}		
		
		return ur;
	}
	// getUser(user_email)
	
	// updateUser(ur)
	public int updateUser(UserBean ur){
		int check = -1;
		
		try {
			// 1,2
			con = getConnection();
			// 3 sql작성
		    sql ="select user_pw from user where user_email=?";
		    pstmt = con.prepareStatement(sql);
		    pstmt.setString(1, ur.getUser_email());
		    
		    // 4 실행
		    rs = pstmt.executeQuery();
		    
			// 5 rs 비교
		    if(rs.next()){
		    	if(ur.getUser_pw().equals(rs.getString("user_pw"))){
		    		
		    		// 3 sql
		    		sql ="update user set user_name=?,address=?,address_detail=?,phone=?,modify_date=now() where user_email=?";
		    		pstmt = con.prepareStatement(sql);
		    		pstmt.setString(1, ur.getUser_name());
		    		pstmt.setString(2, ur.getAddress());
		    		pstmt.setString(3, ur.getAddress_detail());
		    		pstmt.setString(4, ur.getPhone());
		    		pstmt.setString(5, ur.getUser_email());
		    		
		    		
		    		System.out.println("실행 ㅇㅋ");
		    		
		    		// 4 실행
		    		pstmt.executeUpdate();		    		
		    		
		    		check=1;
		    	}else{
		    		check = 0; // 비밀번호 없음
		    	}
		    }else{
		    	check = -1;//아이디 없음
		    }
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		
		
		return check;
	}
	// updateUser(ur)
	
	// deleteUser(user_email,user_pw)
	public int deleteUser(String user_email,String user_pw){
		int check = -1;
		
		try {
			// 1,2
			con = getConnection();
			// 3 sql
			sql = "select user_pw from user where user_email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_email);
			
			// 4 실행
			rs = pstmt.executeQuery();
			
			// 5 rs 비교 처리
			if(rs.next()){
				if(user_pw.equals(rs.getString("user_pw"))){
					// 3 sql
					sql="update user set delete_yn='y' where user_email=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, user_email);
					
					// 4 실행
					pstmt.executeUpdate();
					
					check = 1;					
				}else{
				   check = 0;	
				}				
			}else{
				check = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return check;
	}
	// deleteUser(user_email,user_pw)
	
	// getMemberList()
//	public List<MemberBean> getMemberList(){
//		
//		List<MemberBean> memberList = new ArrayList<MemberBean>();
//		
//		try {
//			// 1,2
//			con = getConnection();
//			// 3 sql
//			sql = "select * from model2_member";
//			pstmt = con.prepareStatement(sql);
//			
//			// 4 실행
//			rs = pstmt.executeQuery();
//			
//			// 5  rs 값 비교
//		    while(rs.next()){
//		    	MemberBean mb = new MemberBean();
//		    	
//		    	mb.setAge(rs.getInt("age"));
//		    	mb.setEmail(rs.getString("email"));
//		    	mb.setGender(rs.getString("gender"));
//		    	mb.setId(rs.getString("id"));
//		    	mb.setName(rs.getString("name"));
//		    	mb.setPass(rs.getString("pass"));
//		    	mb.setReg_date(rs.getTimestamp("regist_date"));
//		    	
//		    	//  한사람의 정보를  memberList배열에 한칸으로 저저장
//		    	memberList.add(mb);
//		    }
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			closeDB();
//		}
//		return memberList;
//	}
	// getMemberList()
	
	
	
	
	
	
	
	

}
