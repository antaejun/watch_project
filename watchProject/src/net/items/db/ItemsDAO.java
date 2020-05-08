package net.items.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class ItemsDAO {
	
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
	
	// getCodeList()
	public List<CodeDTO> getCodeList() {
		List<CodeDTO> codeList = new ArrayList<CodeDTO>();
		System.out.println("getCodeListDAO");
		try {
			con = getConnection();
			
			sql = "SELECT * FROM code";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CodeDTO cdto = new CodeDTO();
				cdto.setCode(rs.getString("code"));
				cdto.setCode_name(rs.getString("code_name"));
				cdto.setDelete_yn(rs.getString("delete_yn"));
				cdto.setIdx(rs.getInt("idx"));
				cdto.setRegist_date(rs.getDate("regist_date"));
				
				codeList.add(cdto);
			}
			System.out.println(codeList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return codeList;
	}
	
	// getCodeList() END
	
	// getCodeDetailList(code)
	public List<CodeDetailDTO> getCodeDetailList(String code) {
		List<CodeDetailDTO> codeDetailList = new ArrayList<CodeDetailDTO>();
		System.out.println("getCodeDetailListDAO");
		try {
			con = getConnection();
			sql = "SELECT * FROM code_detail WHERE code=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, code);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CodeDetailDTO cddto = new CodeDetailDTO();
				cddto.setCode(rs.getString("code"));
				cddto.setCode_detail(rs.getString("code_detail"));
				cddto.setCode_detail_name(rs.getString("code_detail_name"));
				cddto.setDelete_yn(rs.getString("delete_yn"));
				cddto.setIdx(rs.getInt("idx"));
				cddto.setRegist_date(rs.getDate("regist_date"));
				
				codeDetailList.add(cddto);
			}
			System.out.println(codeDetailList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return codeDetailList;
	}
	
	// getCodeDetailList(code) END
	
	// getItemsList() all
	public List<ItemDTO> getItemsList() {
		List<ItemDTO> itemsList = new ArrayList<ItemDTO>();
		System.out.println("getItemListDAO");
		try {
			con = getConnection();
			sql = "SELECT * FROM item";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ItemDTO idto = new ItemDTO();
				
				idto.setIdx(rs.getInt("idx"));
				idto.setCode(rs.getString("code"));
				idto.setCode_detail(rs.getString("code_detail"));
				idto.setItem_amount(rs.getInt("item_amount"));
				idto.setItem_code(rs.getString("item_code"));
				idto.setItem_color(rs.getString("item_color"));
				idto.setItem_name(rs.getString("item_name"));
				idto.setItem_price(rs.getInt("item_price"));
				idto.setItem_size(rs.getString("item_size"));
				idto.setRegist_date(rs.getDate("regist_date"));
				idto.setDelete_yn(rs.getString("delete_yn"));
				
				itemsList.add(idto);
			}
			System.out.println("전체 상품 리스트 " + itemsList.size() + "개 저장 완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return itemsList;
	}
	
	// getItemsList() END
	
	
	// getItemsList(code)
	public List<ItemDTO> getItemsList(String code) {
		List<ItemDTO> itemsList = new ArrayList<ItemDTO>();
		System.out.println("getItemList(param)DAO");
		try {
			con = getConnection();
			sql = "SELECT * FROM item WHERE code = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, code);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ItemDTO idto = new ItemDTO();
				
				idto.setIdx(rs.getInt("idx"));
				idto.setCode(rs.getString("code"));
				idto.setCode_detail(rs.getString("code_detail"));
				idto.setItem_amount(rs.getInt("item_amount"));
				idto.setItem_code(rs.getString("item_code"));
				idto.setItem_color(rs.getString("item_color"));
				idto.setItem_name(rs.getString("item_name"));
				idto.setItem_price(rs.getInt("item_price"));
				idto.setItem_size(rs.getString("item_size"));
				idto.setRegist_date(rs.getDate("regist_date"));
				idto.setDelete_yn(rs.getString("delete_yn"));
				
				itemsList.add(idto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return itemsList;
	}
	// getItemsList(code) END

	
	// getItemsList(code, code_detail)
	public List<ItemDTO> getItemsList(String code, String code_detail) {
		List<ItemDTO> itemsList = new ArrayList<ItemDTO>();
		System.out.println("getItemList(param2)DAO");
		try {
			con = getConnection();
			if(code_detail.equals("all")){
				sql="SELECT * FROM item WHERE code=?";
			} else {
			sql = "SELECT i.idx,i.code,i.item_name,i.item_code,i.item_price,i.item_size, c.code_name, cd.code_detail_name,cd.code_detail FROM item i"
					+ " join code c join code_detail cd"
					+ " on i.code = c.code and i.code_detail = cd.code_detail WHERE i.code = ? and i.code_detail=?";
			}
			pstmt = con.prepareStatement(sql);
			if(code_detail.equals("all")){
				pstmt.setString(1, code);
			} else {
				pstmt.setString(1, code);
				pstmt.setString(2, code_detail);
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ItemDTO idto = new ItemDTO();
				
				idto.setItem_name(rs.getString("item_name"));
				idto.setItem_price(rs.getInt("item_price"));
				idto.setItem_size(rs.getString("item_size"));
				idto.setItem_code(rs.getString("item_code"));
				
				idto.setIdx(rs.getInt("idx"));
				
				itemsList.add(idto);
			}
			System.out.println("고객 상품 리스트 " + itemsList.size()+"개 저장 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return itemsList;
	}
	
	
	// getItemsList(code, code_detail) END
	
	// getItems(idx)
	public ItemDTO getItems(int idx) {
		ItemDTO idto = null;
		try {
			con = getConnection();
			
			sql = "SELECT * FROM item WHERE idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				idto = new ItemDTO();
				idto.setCode(rs.getString("code"));
				idto.setCode_detail(rs.getString("code_detail"));
				idto.setDelete_yn(rs.getString("delete_yn"));
				idto.setIdx(rs.getInt("idx"));
				idto.setItem_amount(rs.getInt("item_amount"));
				idto.setItem_code(rs.getString("item_code"));
				idto.setItem_color(rs.getString("item_color"));
				idto.setItem_info(rs.getString("item_info"));
				idto.setItem_name(rs.getString("item_name"));
				idto.setItem_size(rs.getString("item_size"));
				idto.setItem_price(rs.getInt("item_price"));
				idto.setRegist_date(rs.getDate("regist_date"));
				
			}
			System.out.println(idx + "번 상품 정보 저장완료!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return idto;
	}
	// getItems(idx) END
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
