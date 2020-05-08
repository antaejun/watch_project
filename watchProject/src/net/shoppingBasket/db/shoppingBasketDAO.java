package net.shoppingBasket.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.items.db.ItemDTO;

public class shoppingBasketDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
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
	
	// checkGoods(sbkdto)
	public int checkWatch(shoppingBasketDTO sbkdto){
		int check = 0;
		
		try {
			//1,2 디비연결 
			con = getConnection();
			//3 sql 기존의 장바구니에 해당 상품이 있는지 없는지 판별
			// -> 같은 상품이 있다 check 1 => 수량 변경
			// -> 같은 상품이 없다 check 0
			sql = "SELECT * FROM basket "
					+ "WHERE user_email=? and item_code=? and basket_size=? "
					+ "and basket_color=?  and basket_amount=? and basket_price=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sbkdto.getUser_email());
			pstmt.setString(2, sbkdto.getItem_code());
			pstmt.setString(3, sbkdto.getBasket_size());
			pstmt.setString(4, sbkdto.getBasket_color());
			pstmt.setInt(5, sbkdto.getBasket_amount());
			pstmt.setInt(6, sbkdto.getBasket_price());
			
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				//=> 장바구니에 기존의 상품이 있다. 수량을 변경
				sql = "UPDATE basket SET basket_amount = basket_amount+? "
						+ "WHERE user_email=? and item_code=? and "
						+ "basket_size=? and basket_color=? and basket_price=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, sbkdto.getBasket_amount());
				pstmt.setString(2, sbkdto.getUser_email());
				pstmt.setString(3, sbkdto.getItem_code());
				pstmt.setString(4, sbkdto.getBasket_size());
				pstmt.setString(5, sbkdto.getBasket_color());
				pstmt.setInt(6, sbkdto.getBasket_price());
				
				
				//check = 1;
				check = pstmt.executeUpdate();
			}

			System.out.println("장바구니 체크 완료 (0 : 신규,1 : 기존) : "+check);
			
		} catch (Exception e) {
			e.printStackTrace();
 		} finally {
			closeDB();
		}
		
		return check;
	}
	// checkGoods(sbkdto)
	
	// basketAdd(sbkdto)
	public void basketAdd(shoppingBasketDTO sbkdto){
		int idx = 0;
		try {
			con = getConnection();
			
			// b_num 계산
			sql = "SELECT max(idx) FROM basket";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				idx = rs.getInt(1)+1;
			}
			
			System.out.println(" 장바구니 번호 : "+idx);
			
			// 상품을 장바구니에 저장 
			// 장바구니에 상품 정보를 저장 테이블 순서에 맞게 저장해야함.
			sql = "INSERT INTO basket "
					+ "VALUES(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setString(2, sbkdto.getItem_code());
			pstmt.setInt(3, sbkdto.getBasket_amount());
			pstmt.setInt(4, sbkdto.getBasket_price()*sbkdto.getBasket_amount());
			pstmt.setString(5,sbkdto.getBasket_color());
			pstmt.setString(6, sbkdto.getBasket_size());
			pstmt.setString(7, sbkdto.getUser_email());
			
			pstmt.executeUpdate();

			System.out.println("장바구니 저장 완료!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
	}
	// basketAdd(sbkdto)
	
	// getBasketList(id)
	public Vector getshoopingBasketList(String user_email){
		Vector vec = new Vector();
		//상품정보 저장
		ArrayList watchList = new ArrayList();
		//장바구니 정보 저장
		ArrayList basketList = new ArrayList();
		
		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		
		try {
			con = getConnection();
			// 장바구니 정보 저장
			sql = "SELECT * FROM basket WHERE user_email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_email);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				// 장바구니 정보를 저장 
				// BasketDTO생성
				shoppingBasketDTO sbkdto = new shoppingBasketDTO();
				sbkdto.setBasket_price(rs.getInt("basket_price"));
				sbkdto.setBasket_amount(rs.getInt("basket_amount"));
				sbkdto.setBasket_color(rs.getString("basket_color"));
				sbkdto.setItem_code(rs.getString("item_code"));
				sbkdto.setBasket_size(rs.getString("basket_size"));
				sbkdto.setUser_email(rs.getString("user_email"));
				sbkdto.setIdx(rs.getInt("idx"));
				
				// 장바구니 1개의 정보를 리스트 한칸에 저장
				basketList.add(sbkdto);
				
				// 각각의 장바구니에 해당하는 상품 정보 저장
				sql = "SELECT * FROM item "
						+ "WHERE idx=?";
				pstmt2 = con.prepareStatement(sql);
				
				pstmt2.setString(1, sbkdto.getItem_code());
				
				rs2 = pstmt2.executeQuery();
				
				if(rs2.next()){
					// 장바구니에 들어간 상품의 추가 정보 가져오기
					ItemDTO wdto = new ItemDTO();
					
					/* wdto.setImage(rs2.getString("image")); */
					wdto.setItem_name(rs2.getString("item_name"));
					wdto.setItem_price(rs2.getInt("item_price"));
					// 필요한 추가정보....
					
					// 상품정보 하나를 리스트 한칸에 저장
					watchList.add(wdto);
				} // rs2 끝
			} //rs 끝
			
			// 장바구니 리스트, 상품정보 리스트
			// 백터에 0, 1위치에 각각 저장 
			vec.add(0,basketList);
			vec.add(1,watchList);
			
			System.out.println(" 장바구니,상품정보 리스트 백터에 저장완료 :"+vec);			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return vec;
	}
	// getBasketList(id)
	
	// basketDelete(b_num)
	public void shoppingBasketDelete(int idx){
		
		try {
			con = getConnection();
			// 장바구니에서 특정 번호의 상품을 삭제 
			sql="DELETE FROM basket WHERE idx=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			pstmt.executeUpdate();

			System.out.println(idx+"번의 장바구니 삭제 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
	}	
	// basketDelete(b_num)
	// basketDelete(id)
		public void basketDelete(String user_email){
			
			try {
				con = getConnection();
				// 장바구니에서 특정 번호의 상품을 삭제 
				sql="DELETE FROM basket WHERE user_email=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_email);
				
				pstmt.executeUpdate();

				System.out.println(user_email+"님의 장바구니 삭제 완료");
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeDB();
			}
			
		}	
		// basketDelete(id)
	
	
	
	
	
	
	

}
