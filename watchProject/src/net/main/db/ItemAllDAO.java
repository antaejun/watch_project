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

import net.code.db.CodeDTO;
import net.items.db.CodeDetailDTO;
import net.items.db.ItemDTO;

public class ItemAllDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql="";
	//아이템+code+detail 관계 존재하는 모든 아이템
	final static String SQL_ITEM$CODE$DETAIL = "SELECT * FROM item i "
			+ "JOIN code c ON i.code = c.code "
			+ "JOIN code_detail d ON i.code_detail = d.code_detail;";
	public static String getSqlItem$code$detail() {
		return SQL_ITEM$CODE$DETAIL;
	}

	public static String getSqlLeftAll() {
		return SQL_LEFT_ALL;
	}

	public static String getSqlAll() {
		return SQL_ALL;
	}

	//아이템+코드+코드디테일+이미지 (한 아이템에 이미지 여러개 일 경우)
	final static String SQL_LEFT_ALL = "SELECT * FROM item i "
			+ "JOIN code c ON i.code = c.code "
			+ "JOIN code_detail d ON i.code_detail = d.code_detail "
			+ "LEFT OUTER JOIN img_table g ON i.item_code = g.item_code;";
	//아이템+코드+코드디테일+이미지 (이미지 없는 아이템 제외)
	final static String SQL_ALL = "SELECT * FROM item i "
			+ "JOIN code c ON i.code = c.code "
			+ "JOIN code_detail d ON i.code_detail = d.code_detail "
			+ "JOIN img_table g ON i.item_code = g.item_code;";
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
	
	public List<ItemAllDTO> getItemAllList(String query){
		
		List<ItemAllDTO> itemAllList = new ArrayList<ItemAllDTO>();
		
		try {
			// 1,2
			con = getConnection();
			// 3 sql
			sql = query;
			pstmt = con.prepareStatement(sql);
			
			// 4 실행
			rs = pstmt.executeQuery();
			
			// 5  rs 값 비교
		    while(rs.next()){
		    	ItemAllDTO itemAllDTO = new ItemAllDTO();
		    	
		    	itemAllDTO.setItemDTO(new ItemDTO());
		    	itemAllDTO.setImageDTO(new ImageTableDTO());
		    	itemAllDTO.setCodeDTO(new CodeDTO());
		    	itemAllDTO.setCodeDetailDTO(new CodeDetailDTO());
		    	  	
		    	itemAllDTO.getItemDTO().setIdx(rs.getInt("idx"));
		    	itemAllDTO.getItemDTO().setCode(rs.getString("code"));
		    	itemAllDTO.getItemDTO().setCode_detail(rs.getString("code_detail"));
		    	itemAllDTO.getItemDTO().setItem_amount(rs.getInt("item_amount"));
		    	itemAllDTO.getItemDTO().setItem_code(rs.getString("item_code"));
		    	itemAllDTO.getItemDTO().setItem_info(rs.getString("item_info"));
		    	itemAllDTO.getItemDTO().setItem_color(rs.getString("item_color"));
		    	itemAllDTO.getItemDTO().setItem_name(rs.getString("item_name"));
		    	itemAllDTO.getItemDTO().setItem_price(rs.getInt("item_price"));
		    	itemAllDTO.getItemDTO().setItem_size(rs.getString("item_size"));
		    	itemAllDTO.getItemDTO().setRegist_date(rs.getDate("regist_date"));
		    	itemAllDTO.getItemDTO().setDelete_yn(rs.getString("delete_yn"));
		    	    	
		    	itemAllDTO.getImageDTO().setIdx(rs.getInt("idx"));
		    	itemAllDTO.getImageDTO().setSave_path(rs.getString("save_path"));
		    	itemAllDTO.getImageDTO().setImg_size(rs.getString("img_size"));
		    	itemAllDTO.getImageDTO().setO_name(rs.getString("o_name"));
		    	itemAllDTO.getImageDTO().setF_name(rs.getString("f_name"));
		    	itemAllDTO.getImageDTO().setRegist_date(rs.getDate("regist_date"));
		    	itemAllDTO.getImageDTO().setDelete_yn(rs.getString("delete_yn"));
		    	itemAllDTO.getImageDTO().setItem_code(rs.getString("item_code"));
		    	itemAllDTO.getImageDTO().setUser_id(rs.getString("user_id"));
		    	itemAllDTO.getImageDTO().setReview_num(rs.getInt("review_num"));
		    	itemAllDTO.getImageDTO().setType(rs.getString("type"));
		    		    	
		    	itemAllDTO.getCodeDTO().setIdx(rs.getInt("idx"));
		    	itemAllDTO.getCodeDTO().setCode(rs.getInt("code"));
		    	itemAllDTO.getCodeDTO().setCode_name(rs.getString("code_name"));
		    	itemAllDTO.getCodeDTO().setRegist_date(rs.getTimestamp("regist_date"));
		    	itemAllDTO.getCodeDTO().setDelete_yn(rs.getString("delete_yn"));
		    	   	
		    	itemAllDTO.getCodeDetailDTO().setIdx(rs.getInt("idx"));
		    	itemAllDTO.getCodeDetailDTO().setCode_detail(rs.getString("code_detail"));
		    	itemAllDTO.getCodeDetailDTO().setCode_detail_name(rs.getString("code_detail_name"));
		    	itemAllDTO.getCodeDetailDTO().setCode(rs.getString("code"));
		    	itemAllDTO.getCodeDetailDTO().setRegist_date(rs.getDate("regist_date"));
		    	itemAllDTO.getCodeDetailDTO().setDelete_yn(rs.getString("delete_yn"));
		    	
		    	
		    	
		    	
		    	//  한사람의 정보를  memberList배열에 한칸으로 저저장
		    	itemAllList.add(itemAllDTO);
		    }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return itemAllList;
	}
	
}
