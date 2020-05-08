package net.orderWatch.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.items.db.ItemDTO;
import net.shoppingBasket.db.shoppingBasketDTO;

public class WatchOrderDAO {
	Connection con ;
	PreparedStatement pstmt ;
	ResultSet rs ;
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
	
	// addOrder(owdto,basketList,watchList)
	public void addOrderWatch(WatchOrderDTO owdto,List basketList,List watchList){
		
		int idx = 0; // 주문 일련번호
		int order_code = 0; // 주문번호
		
		// 주문번호 변경을 하기위한 객체
		Calendar cal = Calendar.getInstance();
		// -> 시스템의 시간정보를 가져다 사용(싱글턴패턴)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		try {
			con = getConnection();
			System.out.println(" DB 연결 성공 ");
			
			// 주문 일련번호 계산하기 (idx)
			sql="SELECT max(idx) FROM  project_db.order"; //왜 프로젝트명 붙어야하는지 몰라(질문)
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				idx = rs.getInt(1)+1;
			}
			
			order_code = idx;
			System.out.println(" DB 연결 성공 22");
			System.out.println(" 주문 일련번호 : "+idx+", 주문번호 : "+order_code);
			
			for(int i=0;i<basketList.size();i++){
				shoppingBasketDTO sbkdto = (shoppingBasketDTO)basketList.get(i);
				ItemDTO wdto = (ItemDTO)watchList.get(i);
				
				
				//WatchPaymentDTO wpdto = (WatchPaymentDTO)payMentList.get(i);
				
			// 18개 목록중 5, 17은 now써야함
			sql ="INSERT INTO project_db.order values(?,?,?,?,now(),?,?,?,?,?,?,?,?,?,?,?,?,?,now(),?)";
			//테이블 순서대로 넣기   10:23분 하다만다.
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx); //ok
			//pstmt.setString(2,order_code);
			pstmt.setString(2,sdf.format(cal.getTime()).toString()+"-"+order_code ); //ok
			// => 20200331-1
			pstmt.setString(3, sbkdto.getItem_code()); //장바구니 아이템 코드 //ok
			pstmt.setString(4, ""); //주문현황 체크확인
			//pstmt.setTimestamp(5, owdto.getOrder_date()); //주문날짜 들고오기 ?는 함수로 사용됨(now())
			//pstmt.setString(5, "");
			
			pstmt.setInt(5, sbkdto.getBasket_amount()); //장바구니의 수량확인
			pstmt.setString(6, owdto.getOrder_name()); //주문한사람 이름 들고오기
			pstmt.setString(7, owdto.getOrder_phone()); //주문한사람의 휴대폰 번호 정보 들고오기
			pstmt.setString(8, owdto.getReceive_name()); //받는사람의 이름정보 들고오기
			pstmt.setString(9, owdto.getReceive_phone()); //받는사람의 휴대폰번호 들고오기
			pstmt.setString(10, owdto.getReceive_address()); //받는사람의 주소정보 들고오기
			pstmt.setString(11, owdto.getReceive_adress_detail()); //받는사람의 상세주소정보 들고오기
			pstmt.setString(12, owdto.getMemo()); //메모정보 들고오기
			pstmt.setInt(13, sbkdto.getBasket_amount() * wdto.getItem_price()); //주문의 가격정보 들고오기 물건별 총액 (구매 수량 * 물건 1개 가격)
			pstmt.setString(14, sbkdto.getBasket_color()); //주문의 색상정보 들고오기
			pstmt.setString(15, sbkdto.getBasket_size()); //주문의 사이즈 정보 들고오기
			pstmt.setString(16, owdto.getPayment_type());
			//pstmt.setTimestamp(17, wpdto.getRegist_date());?는 함수로 사용됨(now())
			//pstmt.setTimestamp(15, wpdto.getRegist_date());// 결제날짜를 들고오기
			pstmt.setString(17, owdto.getTrade_payer()); //결제한사람 이름 가져오기
			pstmt.setString(18, sbkdto.getUser_email()); // 장바구니에서 구매한사람의 이메일(id)들고오기
			
			//////////////////////////////////////////////////////
				/*
				 * pstmt.setInt(6, sbkdto.getBasket_amount()); //장바구니의 수량확인 pstmt.setString(7,
				 * owdto.getUser_email()); //주문한사람 이메일(id)들고오기 pstmt.setString(8,
				 * owdto.getOrder_phone()); //주문한사람의 휴대폰 번호 정보 들고오기 pstmt.setString(9,
				 * owdto.getReceive_name()); //받는사람의 이름정보 들고오기 pstmt.setString(10,
				 * owdto.getReceive_phone()); //받는사람의 휴대폰번호 들고오기 pstmt.setString(11,
				 * owdto.getReceive_address()); //받는사람의 주소정보 들고오기 pstmt.setString(12,
				 * owdto.getReceive_adress_detail()); //받는사람의 상세주소정보 들고오기 pstmt.setString(13,
				 * owdto.getMemo()); //메모정보 들고오기 pstmt.setInt(14, sbkdto.getBasket_amount() *
				 * wdto.getItem_price()); //주문의 가격정보 들고오기 물건별 총액 (구매 수량 * 물건 1개 가격)
				 * pstmt.setString(15, owdto.getOrder_color()); //주문의 색상정보 들고오기
				 * pstmt.setString(16, owdto.getOrder_size()); //주문의 사이즈 정보 들고오기
				 * 
				 * //pstmt.setTimestamp(17, wpdto.getRegist_date());?는 함수로 사용됨(now())
				 * pstmt.setString(17, "");// 결제날짜를 들고오기 pstmt.setString(18,
				 * sbkdto.getUser_email()); // 장바구니에서 구매한사람의 이메일(id)들고오기
				 */			/////////////////////////////////////////////////////////////////////////////////
			
			
			
			pstmt.executeUpdate();
			
			System.out.println(idx+"번 구매정보 저장완료 ! ");
			
			idx ++; // 주문 일련번호를 증가
			
			}// order 테이블 INSERT동작 반복(for)
			
			System.out.println(" 장바구니에 있던 모든 상품정보를 주문 완료! ");			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
	}	
	// addOrder(owdto,basketList,watchList)
	
	
	// getOrderList(user_email) (여기서 오류ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ)
	public ArrayList getOrderList(String user_email){
		ArrayList orderList = new ArrayList();
		
		try {
			con = getConnection();
			
			// 본인의 정보만 가지고이동, order_code기준으로 내림차순 정렬
			sql="SELECT "
					+ "order_code,order_name,order_amount,order_size,"
					+ "order_color,sum(order_price) as order_price,"
					+ "order_code,order_date,order_status,payment_date "
					+ "FROM project_db.order "
					+ "WHERE user_email=? "
					+ "GROUP BY order_code "
					+ "ORDER BY order_code desc";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_email);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				WatchOrderDTO owdto = new WatchOrderDTO();
				
				
				owdto.setOrder_code(rs.getString("order_code"));
				owdto.setOrder_name(rs.getString("order_name"));
				owdto.setOrder_amount(rs.getInt("order_amount"));
				owdto.setOrder_size(rs.getString("order_size"));
				owdto.setOrder_color(rs.getString("order_color"));
				owdto.setOrder_price(rs.getInt("order_price"));
				owdto.setOrder_code(rs.getString("order_code"));
				owdto.setOrder_date(rs.getTimestamp("order_date"));
				owdto.setOrder_status(rs.getString("order_status"));
				owdto.setPayment_date(rs.getDate("payment_date"));

				orderList.add(owdto);			
			}
			
			System.out.println(" 주문정보 저장 완료 : "+orderList);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
				
		return orderList;
	}
	// getOrderList(user_email)
	
	// orderDetail(order_code)
	public List orderDetail(String order_code){
		
		List orderDetailList = new ArrayList();
		
		try {
			con = getConnection();
			
			sql ="SELECT * FROM order "
					+ "WHERE order_code=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, order_code);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				WatchOrderDTO owdto = new WatchOrderDTO();
				owdto.setOrder_date(rs.getTimestamp("order_date"));
				
				owdto.setOrder_amount(rs.getInt("order_amount"));
				owdto.setOrder_color(rs.getString("order_color"));
				owdto.setOrder_name(rs.getString("order_name"));
				owdto.setOrder_size(rs.getString("order_size"));
				owdto.setOrder_price(rs.getInt("order_price"));
				owdto.setOrder_code(rs.getString("order_code"));
				
				owdto.setOrder_status(rs.getString("order_status"));
				
				owdto.setPayment_date(rs.getDate("payment_date"));
				orderDetailList.add(owdto);			
				
			} //while(rs.next)

			System.out.println(" 주문 상세정보 저장완료 : "+orderDetailList);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return orderDetailList;
	}
	// orderDetail(order_code)
	
	
	
	
	
	
}
