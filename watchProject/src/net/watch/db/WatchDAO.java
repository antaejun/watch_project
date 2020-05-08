package net.watch.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.items.db.ItemDTO;
import net.shoppingBasket.db.shoppingBasketDTO;

public class WatchDAO {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";

	// 디비 연결(커넥션 풀 사용)
	private Connection getConnection() throws Exception {
		// Context 객체를 생성
		Context init = new InitialContext();

		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/watchDB");

		con = ds.getConnection();

		System.out.println(" 디비 연결 완료 : " + con);
		return con;
	}

	// 자원 해제

	public void closeDB() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();

			System.out.println(" 자원해제 완료 ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// getGoodsList()
	public List<ItemDTO> getWatchList(String item){
		List<ItemDTO> watchList = new ArrayList<ItemDTO>();
		
		StringBuffer SQL = new StringBuffer();
		
		/*
		//"abc" -> UPPER
		//String
		sql = "abc";
		sql.toUpperCase(); // ABC
		//출력 sql =abc
		
		//StringBuffer
		SQL.append("abc");
		SQL.reverse(); //cba
		// 출력 SQL = "cba"
		 */		
		
		try {
			con = getConnection();
			
			// 상품 전체 목록
			//sql= "SELECT * FROM model2_goods";
			// 상품 인기상품 목록
			//sql= "SELECT * FROM model2_goods WHERE best=1";
			// 상품 카테고리별 목록 (6개)
			//sql= "SELECT * FROM model2_goods WHERE catrgory=?";
			
			SQL.append("SELECT * FROM item");
			if(item.equals("all")){				
			}else{
			   SQL.append(" WHERE code_detail=?");
			}
			
//			pstmt = con.prepareStatement(SQL+"");
			pstmt = con.prepareStatement(SQL.toString());
			
			if(item.equals("all")){}
			else if(item.equals("best")){
				pstmt.setInt(1, 1);
			}else{
				pstmt.setString(1, item);
			}
			
			
			
			rs = pstmt.executeQuery();
			
			// 상품이 있을때 마다 
			while(rs.next()){
				ItemDTO wdto = new ItemDTO();
				
				wdto.setItem_amount(rs.getInt("item_amount"));
				wdto.setCode_detail(rs.getString("code_detail"));
				wdto.setCode(rs.getString("code"));
				wdto.setDelete_yn(rs.getString("delete_yn"));
				wdto.setItem_code(rs.getString("item_code"));
				wdto.setItem_color(rs.getString("item_color"));
				wdto.setItem_info(rs.getString("item_info"));
				wdto.setItem_name(rs.getString("item_name"));
				wdto.setItem_price(rs.getInt("item_price"));
				wdto.setItem_size(rs.getString("item_size"));
				wdto.setRegist_date(rs.getDate("regist_date"));
				
				watchList.add(wdto);			
			}
			System.out.println("사용자 상품 목록 저장 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		   closeDB();	
		}
		return watchList;
	}
	// getGoodsList()
	
 
	// getGoods(num)
	public ItemDTO getWatch(int item_code){
		
		ItemDTO wdto = null;
		
		try {
			con = getConnection();
			
			sql="SELECT * FROM item WHERE item_code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, item_code);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				wdto = new ItemDTO();
				
				wdto.setItem_amount(rs.getInt("item_amount"));
				wdto.setCode(rs.getString("code"));
				wdto.setCode_detail(rs.getString("code_detail"));
				wdto.setDelete_yn(rs.getString("delete_yn"));
				wdto.setItem_code(rs.getString("item_code"));
				wdto.setItem_color(rs.getString("item_color"));
				wdto.setItem_info(rs.getString("item_info"));
				wdto.setItem_name(rs.getString("item_name"));
				wdto.setItem_price(rs.getInt("item_price"));
				wdto.setItem_size(rs.getString("item_size"));
				wdto.setRegist_date(rs.getDate("regist_date"));
			}
			System.out.println("상품 정보 저장 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return wdto;
	}
	
	// getGoods(num)

	// updateAmount(basketList)
	public void updateAmount(List basketList){
		
		try {
			con = getConnection();
			System.out.println("@@@@@@@@@@@@@@@@@@@@@   DB연결성공");
			for(int i=0;i<basketList.size();i++){
				shoppingBasketDTO sbkdto =(shoppingBasketDTO) basketList.get(i);
			
			sql = "UPDATE item SET "
					+ "item_amount = item_amount - ? WHERE idx = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sbkdto.getBasket_amount());
			pstmt.setString(2, sbkdto.getItem_code());
			System.out.println("@@@@@@@@@@@@@@@@@@@@@   DB연결성공2");
			pstmt.executeUpdate();
			
			System.out.println(sbkdto.getItem_code()+"번 상품 수량 변경 완료!");
			
			}// for
			
			System.out.println(" 장바구니 (결제완료)상품 수량 변경 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
	}
	// updateAmount(basketList)
	
	
	
	
	
	
	
	
	
	

}
