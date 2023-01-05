package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.ErpDTO;

import java.sql.SQLException;

//import util.DatabaseUtil;

public class ErpDAO {
	//Connection conn = DatabaseUtil.getConnection();
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/erp?useSSL=false&serverTimezone=UTC";
	String id = "root";
	String pw = "1234";
	
	
	/////생성자
	public ErpDAO() {
		try {
			Class.forName(driver);
			System.out.println("드라이버 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 실패");
		}
	}
	
	////connection
	public Connection getConnection() {
		Connection conn=null;
		
		try {
			conn=DriverManager.getConnection(url, id, pw);
		}catch(SQLException e) {
			System.out.println("커넥션실패");
		}
		return conn;
	}
	
	/////insert
	public void infoInsert(ErpDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql="insert into item values(?,?,?,?,?,?,?,?,?)";
		
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getItem_code());
			pstmt.setString(2, dto.getItem_name());
			pstmt.setString(3, dto.getReceiving_unit_price());
			pstmt.setString(4, dto.getRelease_unit_price());
			pstmt.setString(5, dto.getItem_kind());
			pstmt.setString(6, dto.getBusiness_number());
			pstmt.setString(7, dto.getOwener_contact());
			pstmt.setString(8, dto.getAddress());
			pstmt.setString(9, dto.getOwener_email());
			
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//////select
	public ArrayList<ErpDTO> getitemselect(){
		ArrayList<ErpDTO> list = new ArrayList<ErpDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select item_code, item_name, receiving_unit_price, release_unit_price, Item_kind, business_number, owener_contact, address, owener_email from item";
		
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ErpDTO dto = new ErpDTO();
				
				dto.setItem_code(rs.getInt("item_code"));
				dto.setItem_name(rs.getString("item_name"));
				dto.setReceiving_unit_price(rs.getString("receiving_unit_price"));
				dto.setRelease_unit_price(rs.getString("release_unit_price"));
				dto.setItem_kind(rs.getString("Item_kind"));
				dto.setBusiness_number(rs.getString("business_number"));
				dto.setOwener_contact(rs.getString("owener_contact"));
				dto.setAddress(rs.getString("address"));
				dto.setOwener_email(rs.getString("owener_email"));
				
				list.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		ErpDAO dao = new ErpDAO();
	}
}