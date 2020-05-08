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

public class MainDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql="";
	
	// 디비 연결(커넥션 풀 사용)
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
	
	public void insertSlider (MainSliderBean msb){
		try {
			// 1,2
			con = getConnection();
			System.out.println(" DB 연결 성공 ");
			
			// 3 sql 작성
			sql="insert into main_content "
					+ "values(?,?,?,?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, msb.getIdx());
			pstmt.setInt(2, msb.getOrder());
			pstmt.setString(3, msb.getArticle());
			pstmt.setString(4, msb.getTag());
			pstmt.setString(5, msb.getImg_path());
			pstmt.setString(6, msb.getImg_file());
			pstmt.setString(7, msb.getHeight());
			pstmt.setString(8, msb.getWidth());
			pstmt.setString(9, msb.getLink());
			
			

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
	
	public List<MainSliderBean> getSliderList(int idx){
		
		List<MainSliderBean> sliderList = new ArrayList<MainSliderBean>();
		
		try {
			// 1,2
			con = getConnection();
			// 3 sql
			sql = "select * from main_content NATURAL JOIN main_img "
					+ "where idx="+idx+";";
			pstmt = con.prepareStatement(sql);
			
			// 4 실행
			rs = pstmt.executeQuery();
			
			// 5  rs 값 비교
		    while(rs.next()){
		    	MainSliderBean msb = new MainSliderBean();
		    	
		    	msb.setIdx(rs.getInt("idx"));
		    	msb.setOrder(rs.getInt("order"));
		    	msb.setArticle(rs.getString("article"));
		    	msb.setTag(rs.getString("tag"));
		    	msb.setImg_path(rs.getString("img_path"));
		    	msb.setImg_file(rs.getString("img_file"));
		    	msb.setHeight(rs.getString("height"));
		    	msb.setWidth(rs.getString("width"));
		    	msb.setLink(rs.getString("link"));
		    	
		    	//  한사람의 정보를  memberList배열에 한칸으로 저저장
		    	sliderList.add(msb);
		    }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return sliderList;
	}
	
	
	
	
}
