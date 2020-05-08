package net.review.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ReviewDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";
	
	public ReviewDAO() {
			try {
				getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	
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
	
	// getReviewList(item_code)
	public List<ReviewDTO> getReviewList(String item_code) {
		List<ReviewDTO> reviewList = new ArrayList<ReviewDTO>();
		System.out.println(item_code+"@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		try {
			con = getConnection();
			sql = "SELECT * FROM review WHERE item_code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, item_code);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewDTO rdto = new ReviewDTO();
				rdto.setContent(rs.getString("content"));
				rdto.setDelete_yn(rs.getString("delete_yn"));
				rdto.setItem_code(rs.getString("item_code"));
				rdto.setModify_date(rs.getDate("modify_date"));
				rdto.setRegist_date(rs.getDate("regist_date"));
				rdto.setReview_num(rs.getInt("review_num"));
				rdto.setUser_email(rs.getString("user_email"));
				
				reviewList.add(rdto);
			}
			System.out.println(reviewList+"리뷰 목록 저장");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return reviewList;
	}
	
	// getReviewList(item_code)
	
	// insertReview(rdto)
	public int insertReview(ReviewDTO rdto) {
		int result = -1;
		try {
			con = getConnection();

			sql = "INSERT INTO review(content,item_code,user_email) "
					+ "VALUES(?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rdto.getContent());
			pstmt.setString(2, rdto.getItem_code());
			pstmt.setString(3, rdto.getUser_email());
			
			result = pstmt.executeUpdate();
			
			System.out.println(" 리뷰작성 완료! ");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return result;
	}
	
	public List<ReviewDTO> selectReview(ReviewDTO rdto) {
		
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		try {
			con = getConnection();

			sql = "select * from review where item_code = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rdto.getItem_code());
			
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ReviewDTO rvo = new ReviewDTO();
				rvo.setContent(rs.getString("content"));
				rvo.setUser_email(rs.getString("user_email"));
				
				list.add(rvo);
			}
			System.out.println(" 리뷰작성 완료! " + list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return list;
	}
	
	// insertReview(rdto)

}
