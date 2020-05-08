package net.basket.db;

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

public class BasketDAO {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";
	
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
	
	// getcheckItems(bkdto)
	public int getcheckItems(BasketDTO bkdto) {
		int check = 0;
		
		try {
			con = getConnection();
			
			sql = "SELECT * FROM basket "
					+ "WHERE user_email=? and item_code=? and basket_size=? "
					+ "and basket_color=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bkdto.getUser_email());
			pstmt.setString(2, bkdto.getItem_code());
			pstmt.setString(3, bkdto.getBasket_size());
			pstmt.setString(4, bkdto.getBasket_color());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				sql = "UPDATE basket SET basket_amount = basket_amount+?, "
						+ "basket_price = basket_price+? "
						+ "WHERE user_email=? and item_code=? and basket_size=? "
						+ "and basket_color=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, bkdto.getBasket_amount());
				pstmt.setInt(2, bkdto.getBasket_price());
				pstmt.setString(3, bkdto.getUser_email());
				pstmt.setString(4, bkdto.getItem_code());
				pstmt.setString(5, bkdto.getBasket_size());
				pstmt.setString(6, bkdto.getBasket_color());
				
				check = pstmt.executeUpdate();
			}
			
			System.out.println("장바구니 체크 완료 (0 : 신규, 1 : 기존) : " + check);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return check;
	}
	// getcheckItems(bkdto) END
	
	// basketAdd(bkdto)
	public void basketAdd(BasketDTO bkdto) {
		int idx = 0;
		
		try {
			con = getConnection();
			
			sql = "SELECT max(idx) FROM basket";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				idx = rs.getInt(1) + 1;
			}
			System.out.println(" 장바구니 번호 : " + idx);
			
			sql = "INSERT INTO basket VALUES(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setString(2, bkdto.getItem_code());
			pstmt.setInt(3, bkdto.getBasket_amount());
			pstmt.setInt(4, bkdto.getBasket_price());
			pstmt.setString(5, bkdto.getBasket_color());
			pstmt.setString(6, bkdto.getBasket_size());
			pstmt.setString(7, bkdto.getUser_email());
			
			pstmt.executeUpdate();
			
			System.out.println("장바구니 담기 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
	}
	// basketAdd(bkdto) END
	
	// getBasketList(id)
	public Vector getBasketList(String user_email){
		Vector vec = new Vector();
		
		ArrayList itemsList = new ArrayList();
		
		ArrayList basketList = new ArrayList();
		
		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		
		try {
			con = getConnection();
			sql = "SELECT * FROM basket WHERE user_email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_email);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BasketDTO bkdto = new BasketDTO();
				
				bkdto.setBasket_amount(rs.getInt("basket_amount"));
				bkdto.setBasket_color(rs.getString("basket_color"));
				bkdto.setBasket_price(rs.getInt("basket_price"));
				bkdto.setBasket_size(rs.getString("basket_size"));
				bkdto.setIdx(rs.getInt("idx"));
				bkdto.setItem_code(rs.getString("item_code"));
				bkdto.setUser_email(rs.getString("user_email"));
				
				basketList.add(bkdto);
				
				sql = "SELECT * FROM item "
						+ "WHERE item_code=?";
				pstmt2 = con.prepareStatement(sql);
				pstmt2.setString(1, bkdto.getItem_code());
				
				rs2 = pstmt2.executeQuery();
				
				if(rs2.next()) {
					ItemDTO idto = new ItemDTO();
					
					idto.setItem_name(rs2.getString("item_name"));
					idto.setItem_price(rs2.getInt("item_price"));
					
					itemsList.add(idto);
				}
			}
			
			vec.add(0,basketList);
			vec.add(1,itemsList);
			
			System.out.println(" 장바구니 및 상품정보 리스트, 벡터 저장완료 : " + vec);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return vec;
	}
	
	// getBasketList(id) END
	
	// basketDelete(idx)
	public void basketDelete(int idx) {
		try {
			con = getConnection();
			
			sql = "DELETE FROM basket WHERE idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			pstmt.executeUpdate();
			
			System.out.println("장바구니 " + idx + " 번 삭제 완료!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}
	
	// basketDelete(idx) END
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
