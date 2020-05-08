package net.main.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ImageTableDAO {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql="";

	private Connection getConnection() throws Exception{
		// Context 객체를 생성
		Context init = new InitialContext();
		
		DataSource ds 
		 = (DataSource) init.lookup("java:comp/env/jdbc/watchDB");
		
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
	
	public void insertImage (ImageTableDTO dto){
		
		try {
			// 1,2
			con = getConnection();
			System.out.println(" DB 연결 성공 ");
			
			// 3 sql 작성
			sql="insert into main_content "
					+ "values(?,?,?,?,?,?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getIdx());
			pstmt.setString(2, dto.getSave_path());
			pstmt.setString(3, dto.getImg_size());
			pstmt.setString(4, dto.getO_name());
			pstmt.setString(5, dto.getF_name());
			pstmt.setDate(6, dto.getRegist_date());
			pstmt.setString(7, dto.getDelete_yn());
			pstmt.setString(8, dto.getItem_code());
			pstmt.setString(9, dto.getUser_id());
			pstmt.setInt(10, dto.getReview_num());
			pstmt.setString(11, dto.getType());
			

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
	
	public List<ImageTableDTO> getImageList(){
		
		List<ImageTableDTO> imageList = new ArrayList<ImageTableDTO>();
		
		try {
			// 1,2
			con = getConnection();
			// 3 sql
			sql = "select * from img_table;";
			pstmt = con.prepareStatement(sql);
			
			// 4 실행
			rs = pstmt.executeQuery();
			
			// 5  rs 값 비교
		    while(rs.next()){
		    	ImageTableDTO dto = new ImageTableDTO();
		    	
		    	dto.setIdx(rs.getInt("idx"));
		    	dto.setSave_path(rs.getString("save_path"));
		    	dto.setImg_size(rs.getString("img_size"));
		    	dto.setO_name(rs.getString("o_name"));
		    	dto.setF_name(rs.getString("f_name"));
		    	dto.setRegist_date(rs.getDate("regist_date"));
		    	dto.setDelete_yn(rs.getString("delete_yn"));
		    	dto.setItem_code(rs.getString("item_code"));
		    	dto.setUser_id(rs.getString("user_id"));
		    	dto.setReview_num(rs.getInt("review_num"));
		    	dto.setType(rs.getString("type"));
		    	
		    	
		    	//  한사람의 정보를  memberList배열에 한칸으로 저저장
		    	imageList.add(dto);
		    }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return imageList;
	}
	
}
