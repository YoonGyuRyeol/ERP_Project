package dao;

import static db.JdbcUtil.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import vo.BomP;
import vo.BomS;
import vo.Holding;
import vo.IL;
import vo.Item;
import vo.LogStatus;
import vo.Order;
import vo.Order2;
import vo.Order3;
import vo.Order4;
import vo.Post;
import vo.St;
import vo.Stl;
import vo.User;
import vo.client;
import vo.company;
import vo.employee;
import vo.po;
import vo.pos;
import vo.temp;
import vo.wh;
import vo.whs;

import java.util.Calendar;



public class UnitedDAO {
	
	Connection con;
	private static UnitedDAO boardDAO;
	
	private UnitedDAO() {}
	
	public void setConnection(Connection con){
		this.con = con;
	}
	
	public static UnitedDAO getInstance(){
		
		if(boardDAO ==null){
			boardDAO = new UnitedDAO();
		} 
		
		return boardDAO;
	}
	
	
	
	public int updateReadCount(int id) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "";
		
		try {
			sql = "UPDATE food SET readcount = readcount + 1 WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return updateCount;
	}
	
	public boolean logincorrect(String id, String pwd) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean success = false;
		String uid = id;
		String upwd = pwd;
		String dbpwd = "hah";
		System.out.println("0");
		try {
			pstmt = con.prepareStatement("SELECT passwd FROM user WHERE id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				dbpwd = rs.getString("passwd");
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		if(dbpwd.equals(upwd)) {
			success = true;
		}
		return success;
	}
	public User login(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			
			pstmt = con.prepareStatement("SELECT user.id, user.passwd, user.grade, user.ecode, employee.name, employee.position FROM user JOIN employee ON user.ecode = employee.ecode where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			System.out.println("1");
			if(rs.next()){//
				user = new User(
						rs.getString("id")
						,rs.getString("passwd")
						,rs.getInt("grade")
						,rs.getString("ecode")
						,rs.getString("name")
						,rs.getString("position")
						);
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return user;
	}
	public boolean login_sql1(String id,String pwd) {
		Statement stmt = null;
		ResultSet rs = null;
		String user = "tt";
		boolean success = false;
		try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery("select id from sql_table where id='"+id+"' and passwd='"+pwd+"' ");
			System.out.println("SQL 1");
			if(rs.next()){//
					user = rs.getString("id");
						
						
			}
			if(user.equals("admin")) {
				success = true;
			}else {
				success=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rs);
		}
		
		return success;
	}
	public boolean login_sql2(String id,String pwd) {
		Statement stmt = null;
		ResultSet rs = null;
		String user = "tt";
		boolean success = false;
		try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery("select id from sql_table where id='"+id+"' and passwd='"+pwd+"' ");
			System.out.println("sql 2");
			if(rs.next()){//
					user = rs.getString("id");
						
						
			}
			if(user.equals("Cyber")) {
				success = true;
			}else {
				success=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rs);
		}
		
		return success;
	}
	public boolean login_sql3(String id,String pwd) {
		Statement stmt = null;
		ResultSet rs = null;
		String user = "tt";
		boolean success = false;
		id=id.replace("or","");
		id=id.replace("and","");
		id=id.replace("||","");
		id=id.replace("&&","");
		id=id.replace("#","");
		pwd=pwd.replace("or","");
		pwd=pwd.replace("and","");
		pwd=pwd.replace("||","");
		pwd=pwd.replace("&&","");
		pwd=pwd.replace("#","");
		System.out.println(id + " " + pwd);	
		try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery("select id from sql_table where id='"+id+"' and passwd='"+pwd+"' ");
			if(rs.next()){//
					user = rs.getString("id");
						
						
			}
			if(user.equals("Lion")) {
				success = true;
			}else {
				success=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rs);
		}
		
		return success;
	}
	public boolean clear_sql1(String uid) {
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		String user = "tt";
		int point = 50;
		String previous ="fff";
		String sql = "asd";
		int a;
		String b = "1";
		boolean success = false;
			try {
				con.setAutoCommit(true);
				pstmt = con.prepareStatement("SELECT id FROM log WHERE level=? and id=?");
				pstmt.setString(1, b);
				pstmt.setString(2, uid);
				rs = pstmt.executeQuery();
				if(rs.next()){//
				
				previous = rs.getString("id");
							
				}
				if(previous.equals(uid)) {
					previous = null;
					System.out.println("???");
				}else {
					pstmt2=con.prepareStatement("UPDATE user SET point = point + ? WHERE id=?");
					pstmt2.setInt(1, point);
					pstmt2.setString(2, uid);
					a=pstmt2.executeUpdate();
					System.out.println("update "+a);
				
				sql = "INSERT INTO log VALUES (?,?)";
				
				pstmt3 = con.prepareStatement(sql);
				
				pstmt3.setString(1, uid);
				pstmt3.setString(2, b);
				
				a = pstmt3.executeUpdate();
				System.out.println(a);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(pstmt2);
				close(pstmt3);
				success = true;
			}
		
				
			
			return success;
		}
	public boolean clear_sql2(String uid) {
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		String user = "tt";
		int point = 50;
		String previous ="fff";
		String sql = "asd";
		int a;
		String b = "2";
		boolean success = false;
			try {
				con.setAutoCommit(true);
				pstmt = con.prepareStatement("SELECT id FROM log WHERE level=? and id=?");
				pstmt.setString(1, b);
				pstmt.setString(2, uid);
				rs = pstmt.executeQuery();
				if(rs.next()){//
				
				previous = rs.getString("id");
							
				}
				if(previous.equals(uid)) {
					previous = null;
					System.out.println("???");
				}else {
					pstmt2=con.prepareStatement("UPDATE user SET point = point + ? WHERE id=?");
					pstmt2.setInt(1, point);
					pstmt2.setString(2, uid);
					a=pstmt2.executeUpdate();
					System.out.println("update "+a);
				
				sql = "INSERT INTO log VALUES (?,?)";
				
				pstmt3 = con.prepareStatement(sql);
				
				pstmt3.setString(1, uid);
				pstmt3.setString(2, "2");
				
				a = pstmt3.executeUpdate();
				System.out.println(a);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(pstmt2);
				close(pstmt3);
				success = true;
			}
		
				
			
			return success;
		}
	public boolean clear_sql3(String uid) {
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		String user = "tt";
		int point = 150;
		String previous ="fff";
		String sql = "asd";
		int a;
		String b = "3";
		boolean success = false;
			try {
				con.setAutoCommit(true);
				pstmt = con.prepareStatement("SELECT id FROM log WHERE level=? and id=?");
				pstmt.setString(1, b);
				pstmt.setString(2, uid);
				rs = pstmt.executeQuery();
				if(rs.next()){//
				
				previous = rs.getString("id");
							
				}
				if(previous.equals(uid)) {
					previous = null;
					System.out.println("???");
				}else {
					pstmt2=con.prepareStatement("UPDATE user SET point = point + ? WHERE id=?");
					pstmt2.setInt(1, point);
					pstmt2.setString(2, uid);
					a=pstmt2.executeUpdate();
					System.out.println("update "+a);
				
				sql = "INSERT INTO log VALUES (?,?)";
				
				pstmt3 = con.prepareStatement(sql);
				
				pstmt3.setString(1, uid);
				pstmt3.setString(2, "3");
				
				a = pstmt3.executeUpdate();
				System.out.println(a);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(pstmt2);
				close(pstmt3);
				success = true;
			}
		
				
			
			return success;
		}
	public boolean clear_sql4(String uid) {
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		String user = "tt";
		int point = 250;
		String previous ="fff";
		String sql = "asd";
		int a;
		String b = "4";
		boolean success = false;
			try {
				con.setAutoCommit(true);
				pstmt = con.prepareStatement("SELECT id FROM log WHERE level=? and id=?");
				pstmt.setString(1, b);
				pstmt.setString(2, uid);
				rs = pstmt.executeQuery();
				if(rs.next()){//
				
				previous = rs.getString("id");
							
				}
				if(previous.equals(uid)) {
					previous = null;
					System.out.println("???");
				}else {
					pstmt2=con.prepareStatement("UPDATE user SET point = point + ? WHERE id=?");
					pstmt2.setInt(1, point);
					pstmt2.setString(2, uid);
					a=pstmt2.executeUpdate();
					System.out.println("update "+a);
				
				sql = "INSERT INTO log VALUES (?,?)";
				
				pstmt3 = con.prepareStatement(sql);
				
				pstmt3.setString(1, uid);
				pstmt3.setString(2, "4");
				
				a = pstmt3.executeUpdate();
				System.out.println(a);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(pstmt2);
				close(pstmt3);
				success = true;
			}
		
				
			
			return success;
		}
	public boolean clear_sql5(String uid) {
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		String user = "tt";
		int point = 450;
		String previous ="fff";
		String sql = "asd";
		int a;
		String b = "5";
		boolean success = false;
			try {
				con.setAutoCommit(true);
				pstmt = con.prepareStatement("SELECT id FROM log WHERE level=? and id=?");
				pstmt.setString(1, b);
				pstmt.setString(2, uid);
				rs = pstmt.executeQuery();
				if(rs.next()){//
				
				previous = rs.getString("id");
							
				}
				if(previous.equals(uid)) {
					previous = null;
					System.out.println("???");
				}else {
					pstmt2=con.prepareStatement("UPDATE user SET point = point + ? WHERE id=?");
					pstmt2.setInt(1, point);
					pstmt2.setString(2, uid);
					a=pstmt2.executeUpdate();
					System.out.println("update "+a);
				
				sql = "INSERT INTO log VALUES (?,?)";
				
				pstmt3 = con.prepareStatement(sql);
				
				pstmt3.setString(1, uid);
				pstmt3.setString(2, "5");
				
				a = pstmt3.executeUpdate();
				System.out.println(a);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(pstmt2);
				close(pstmt3);
				success = true;
			}
		
				
			
			return success;
		}
	public boolean clear_rfi1(String uid) {
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		String user = "tt";
		int point = 50;
		String previous ="fff";
		String sql = "asd";
		int a;
		String b = "1";
		boolean success = false;
			try {
				con.setAutoCommit(true);
				pstmt = con.prepareStatement("SELECT id FROM rfi_log WHERE level=? and id=?");
				pstmt.setString(1, b);
				pstmt.setString(2, uid);
				rs = pstmt.executeQuery();
				if(rs.next()){//
				
				previous = rs.getString("id");
							
				}
				if(previous.equals(uid)) {
					previous = null;
					System.out.println("???");
				}else {
					pstmt2=con.prepareStatement("UPDATE user SET point = point + ? WHERE id=?");
					pstmt2.setInt(1, point);
					pstmt2.setString(2, uid);
					a=pstmt2.executeUpdate();
					System.out.println("update "+a);
				
				sql = "INSERT INTO rfi_log VALUES (?,?)";
				
				pstmt3 = con.prepareStatement(sql);
				
				pstmt3.setString(1, uid);
				pstmt3.setString(2, b);
				
				a = pstmt3.executeUpdate();
				System.out.println(a);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(pstmt2);
				close(pstmt3);
				success = true;
			}
		
				
			
			return success;
		}
	public boolean clear_file1(String uid) {
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		String user = "tt";
		int point = 50;
		String previous ="fff";
		String sql = "asd";
		int a;
		String b = "1";
		boolean success = false;
			try {
				con.setAutoCommit(true);
				pstmt = con.prepareStatement("SELECT id FROM file_log WHERE level=? and id=?");
				pstmt.setString(1, b);
				pstmt.setString(2, uid);
				rs = pstmt.executeQuery();
				if(rs.next()){//
				
				previous = rs.getString("id");
							
				}
				if(previous.equals(uid)) {
					previous = null;
					System.out.println("???");
				}else {
					pstmt2=con.prepareStatement("UPDATE user SET point = point + ? WHERE id=?");
					pstmt2.setInt(1, point);
					pstmt2.setString(2, uid);
					a=pstmt2.executeUpdate();
					System.out.println("update "+a);
				
				sql = "INSERT INTO file_log VALUES (?,?)";
				
				pstmt3 = con.prepareStatement(sql);
				
				pstmt3.setString(1, uid);
				pstmt3.setString(2, b);
				
				a = pstmt3.executeUpdate();
				System.out.println(a);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(pstmt2);
				close(pstmt3);
				success = true;
			}
		
				
			
			return success;
		}
	public boolean clear_xss1(String uid) {
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		String user = "tt";
		int point = 50;
		String previous ="fff";
		String sql = "asd";
		int a;
		String b = "1";
		boolean success = false;
			try {
				con.setAutoCommit(true);
				pstmt = con.prepareStatement("SELECT id FROM xss_log WHERE level=? and id=?");
				pstmt.setString(1, b);
				pstmt.setString(2, uid);
				rs = pstmt.executeQuery();
				if(rs.next()){//
				
				previous = rs.getString("id");
							
				}
				if(previous.equals(uid)) {
					previous = null;
					System.out.println("???");
				}else {
					pstmt2=con.prepareStatement("UPDATE user SET point = point + ? WHERE id=?");
					pstmt2.setInt(1, point);
					pstmt2.setString(2, uid);
					a=pstmt2.executeUpdate();
					System.out.println("update "+a);
				
				sql = "INSERT INTO xss_log VALUES (?,?)";
				
				pstmt3 = con.prepareStatement(sql);
				
				pstmt3.setString(1, uid);
				pstmt3.setString(2, b);
				
				a = pstmt3.executeUpdate();
				System.out.println(a);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(pstmt2);
				close(pstmt3);
				success = true;
			}
		
				
			
			return success;
		}
	public int select_sqllog(String uid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String previous ="fff";
		int a=1;
		String b = "1";
		boolean success = false;
			try {
				con.setAutoCommit(true);
				pstmt = con.prepareStatement("SELECT id,level FROM log WHERE id=?");
				pstmt.setString(1, uid);
				rs = pstmt.executeQuery();
				while(rs.next()){//
				
				previous = rs.getString("level");
							
				
				if(previous.equals("1")) {
					a = a+1;
					System.out.println("level1");
				}
				if(previous.equals("2")) {
					a = a+1;
					System.out.println("level2");
				}
				if(previous.equals("3")) {
					a = a+1;
					System.out.println("level3");
				}if(previous.equals("4")) {
					a = a+1;
					System.out.println("level4");
				}
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				
				success = true;
			}
		
				
			
			return a;
		}
	public boolean id_check(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String a="haha";
		boolean check = false;
		try {
			pstmt = con.prepareStatement("SELECT * FROM user WHERE id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){//
					a = rs.getString("id");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		if(!a.equals("haha")) {
			check = true;
		}
		return check;
	}
	public boolean Register(String id, String pwd, String addr, int age
			) {
		PreparedStatement pstmt = null;
		int a;
		
		int point = 0;
		String sql = "";
		boolean success = false;
		System.out.println(id+pwd+addr+age+point);
		try {
			con.setAutoCommit(true);
			sql = "INSERT INTO user VALUES (?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, addr);
			pstmt.setInt(4, age);
			pstmt.setInt(5, point);
			a = pstmt.executeUpdate();
			System.out.println(a);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			success = true;
		}
	
			
		
		return success;
	}
	public String selectname(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String name = null;
		
		try {
			pstmt = con.prepareStatement("SELECT name FROM user WHERE id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				name = rs.getString("name");
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return name;
	}
	public String selectdes(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String des = null;
		
		try {
			pstmt = con.prepareStatement("SELECT supplement_facts FROM supplement WHERE product_id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				des = rs.getString("supplement_facts");
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return des;
	}
	public double updatePoint(String id, int point) {
		
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2=null;
		ResultSet rs= null;
		int finalpoint=0;
		int a;
		System.out.println("updatePoint ");
		try {
			con.setAutoCommit(true);
			pstmt=con.prepareStatement("UPDATE user SET point = point + ? WHERE id=?");
			pstmt.setInt(1, point);
			pstmt.setString(2, id);
			a=pstmt.executeUpdate();
			System.out.println("update "+a);
						
			pstmt2 = con.prepareStatement("SELECT point FROM users WHERE id=?");
			pstmt2.setString(1,id);
			rs = pstmt2.executeQuery();
			if(rs.next())
				finalpoint = rs.getInt("point");
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(pstmt2);
			close(rs);
		}
		return finalpoint;
	}
	
	
	public ArrayList<client> selectclientList() {
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<client> clientList = null;
		int i=0;
		
		System.out.println("클라이언트 리스트");	
		try {
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM client");
			
			
			
			if(rs.next()){
				clientList = new ArrayList<client>();
				
				do {
					clientList.add(new client(
							rs.getString("clientcode")
							,rs.getString("clientname")
							,rs.getString("representative")
							,rs.getString("type_of_business")
							,rs.getString("business_number")
							,rs.getString("contact")
							,rs.getString("representative_contact")
							,rs.getString("address")
							,rs.getString("representative_email")
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(stmt);
		}
		
		return clientList;
	}
	public ArrayList<client> selectclientSearchList(String searchoption, String searchvalue) {
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<client> clientList = null;
		int i=0;
		
		System.out.println("클라이언트 검색 리스트");	
		
		try {
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM client where "+ searchoption + " Like '%"+ searchvalue + "%'");
			
			
			
			if(rs.next()){
				clientList = new ArrayList<client>();
				
				do {
					clientList.add(new client(
							rs.getString("clientcode")
							,rs.getString("clientname")
							,rs.getString("representative")
							,rs.getString("type_of_business")
							,rs.getString("business_number")
							,rs.getString("contact")
							,rs.getString("representative_contact")
							,rs.getString("address")
							,rs.getString("representative_email")
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(stmt);
		}
		
		return clientList;
	}
	public client selectupdateclient(String updateclientcode) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		client updateclient = null;
		try {
			
			pstmt = con.prepareStatement("SELECT * FROM client where clientcode=?");
			pstmt.setString(1, updateclientcode);
			rs = pstmt.executeQuery();
			System.out.println("updateclientcode");
			if(rs.next()){//
				 updateclient = new client(
						rs.getString("clientcode")
						,rs.getString("clientname")
						,rs.getString("representative")
						,rs.getString("type_of_business")
						,rs.getString("business_number")
						,rs.getString("contact")
						,rs.getString("representative_contact")
						,rs.getString("address")
						,rs.getString("representative_email")
						);
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		
		return updateclient;
	}
	public boolean updateClient(String clientcode, String clientname, String representative, String type_of_business, String business_number, String contact, String representative_contact, String address, String representative_email) {
		int a=0;
		boolean success = false;
		PreparedStatement pstmt=null;
		
		System.out.println("updateclient ");
		System.out.println(clientcode);
		System.out.println(clientname);
		System.out.println(representative);
		System.out.println(type_of_business);
		System.out.println(business_number);
		System.out.println(contact);
		System.out.println(representative_contact);
		System.out.println(address);
		System.out.println(representative_email);
		try {
			con.setAutoCommit(false);
			pstmt=con.prepareStatement("UPDATE client SET clientname=?, representative=?, type_of_business=?, business_number=?, contact=?, representative_contact=?, address=?, representative_email=? WHERE clientcode=?");
			
			pstmt.setString(1, clientname);
			pstmt.setString(2, representative);
			pstmt.setString(3, type_of_business);
			pstmt.setString(4, business_number);
			pstmt.setString(5, contact);
			pstmt.setString(6, representative_contact);
			pstmt.setString(7, address);
			pstmt.setString(8, representative_email);
			pstmt.setString(9, clientcode);
			a=pstmt.executeUpdate();
			System.out.println("update "+a);
			con.commit(); 	
			
		}catch (SQLException e) {
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			
		}
		if(a>=1) {
			success = true;
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return success;
	}
	public boolean insertClient(String like, String clientname, String representative, String type_of_business, String business_number, String contact, String representative_contact, String address, String representative_email) {
		int a=0;
		boolean success = false;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2=null;
		ResultSet rs = null;
		String clientcode = null;
		int count = 0;
		System.out.println("insertclient ");
		System.out.println(like);
		System.out.println(clientname);
		System.out.println(representative);
		System.out.println(type_of_business);
		System.out.println(business_number);
		System.out.println(contact);
		System.out.println(representative_contact);
		System.out.println(address);
		System.out.println(representative_email);
		try {
			con.setAutoCommit(false);
			if(like.equals("buy")) {
				pstmt2 = con.prepareStatement("select count(*) from client where clientcode Like '%bu%'");
				rs = pstmt2.executeQuery();
				System.out.println("nowcode");
				if(rs.next()){//
				 count = rs.getInt("count(*)");
				
					}
				count++;
				DecimalFormat df = new DecimalFormat("000");
				
				clientcode = "cl-bu-"+df.format(count);
			
			}else if(like.equals("sell")) {
				pstmt2 = con.prepareStatement("select count(*) from client where clientcode Like '%se%'");
				rs = pstmt2.executeQuery();
				System.out.println("nowcode");
				if(rs.next()){//
				 count = rs.getInt("count(*)");
				
					}
				count++;
				DecimalFormat df = new DecimalFormat("000");
				
				clientcode = "cl-se-"+df.format(count);
			}
			System.out.println(clientcode);
			pstmt=con.prepareStatement("Insert into client Values (?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, clientcode);
			pstmt.setString(2, clientname);
			pstmt.setString(3, representative);
			pstmt.setString(4, type_of_business);
			pstmt.setString(5, business_number);
			pstmt.setString(6, contact);
			pstmt.setString(7, representative_contact);
			pstmt.setString(8, address);
			pstmt.setString(9, representative_email);
			
			a=pstmt.executeUpdate();
			System.out.println("Insert "+a);
			con.commit(); 	
			
		}catch (SQLException e) {
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			close(pstmt2);
			close(rs);
		}
		if(a>=1) {
			success = true;
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return success;
	}
	public ArrayList<company> selectcompanyList() {
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<company> companyList = null;
		int i=0;
		
		System.out.println("회사 리스트");	
		try {
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM company");
			
			
			
			if(rs.next()){
				companyList = new ArrayList<company>();
				
				do {
					companyList.add(new company(
							rs.getString("ccode")
							,rs.getString("cname")
							,rs.getString("representative")
							,rs.getString("type_of_business")
							,rs.getString("business_number")
							,rs.getString("contact")
							,rs.getString("representative_contact")
							,rs.getString("address")
							,rs.getString("representative_email")
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(stmt);
		}
		
		return companyList;
	}
	public company selectupdatecompany() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		company updatecompany = null;
		try {
			
			pstmt = con.prepareStatement("SELECT * FROM company");
			
			rs = pstmt.executeQuery();
			System.out.println("updateclientcode");
			if(rs.next()){//
				 updatecompany = new company(
						rs.getString("ccode")
						,rs.getString("cname")
						,rs.getString("representative")
						,rs.getString("type_of_business")
						,rs.getString("business_number")
						,rs.getString("contact")
						,rs.getString("representative_contact")
						,rs.getString("address")
						,rs.getString("representative_email")
						);
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		
		return updatecompany;
	}
	public boolean updateCompany(String ccode, String cname, String representative, String type_of_business, String business_number, String contact, String representative_contact, String address, String representative_email) {
		int a=0;
		boolean success = false;
		PreparedStatement pstmt=null;
		
		System.out.println("updatecompany ");
		System.out.println(ccode);
		System.out.println(cname);
		System.out.println(representative);
		System.out.println(type_of_business);
		System.out.println(business_number);
		System.out.println(contact);
		System.out.println(representative_contact);
		System.out.println(address);
		System.out.println(representative_email);
		try {
			con.setAutoCommit(false);
			pstmt=con.prepareStatement("UPDATE company SET cname=?, representative=?, type_of_business=?, business_number=?, contact=?, representative_contact=?, address=?, representative_email=? WHERE ccode=?");
			
			pstmt.setString(1, cname);
			pstmt.setString(2, representative);
			pstmt.setString(3, type_of_business);
			pstmt.setString(4, business_number);
			pstmt.setString(5, contact);
			pstmt.setString(6, representative_contact);
			pstmt.setString(7, address);
			pstmt.setString(8, representative_email);
			pstmt.setString(9, ccode);
			a=pstmt.executeUpdate();
			System.out.println("update "+a);
			con.commit(); 	
			
		}catch (SQLException e) {
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			
		}
		if(a>=1) {
			success = true;
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return success;
	}
	public ArrayList<Item> selectItemList() {
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<Item> itemList = null;
		int i=0;
		DecimalFormat df = new DecimalFormat("###,###");
		
		System.out.println("품목 리스트");	
		try {
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM item order by item_sortation desc");
			
			
			
			if(rs.next()){
				itemList = new ArrayList<Item>();
				
				do {
					itemList.add(new Item(
							rs.getString("itemcode")
							,rs.getString("itemname")
							,df.format(rs.getInt("Receiving_price"))
							,df.format(rs.getInt("Forwarding_price"))
							,rs.getString("item_sortation")
							
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(stmt);
		}
		
		return itemList;
	}
	public ArrayList<IL> selectILList() {
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<IL> il= null;
		int i=0;
		DecimalFormat df = new DecimalFormat("###,###");
		
		System.out.println("품목 리스트");	
		try {
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM item_like order by item_sortation desc");
			
			
			
			if(rs.next()){
				il = new ArrayList<IL>();
				
				do {
					il.add(new IL(
							rs.getString("itemlikecode1")
							,rs.getString("itemlikecode2")
							,rs.getString("itemlikename")
							,rs.getString("item_sortation")
							
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(stmt);
		}
		
		return il;
	}
	public ArrayList<Item> selectItemSearchList(String searchoption,String searchLike,String searchLike2,String searchorder,String searchvalue) {
		PreparedStatement pstmt=null;
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<Item> ItemList = null;
		int i=0;
		
		System.out.println("품목 검색 리스트");	
		System.out.println(searchoption);
		System.out.println(searchLike);	
		System.out.println(searchLike2);	
		System.out.println(searchorder);	
		System.out.println(searchvalue);
		System.out.println("%"+searchvalue+"%");
		try {
			if(searchoption.equals("itemname")) {
				if(searchLike.equals("ALL")) {
					if(searchLike2.equals("ALL")) {
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ?");
							System.out.println(pstmt);
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();					
							System.out.println("품목 검색 조건 x");	
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? order by Receiving_price ASC");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? order by Receiving_price DESC");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("OUTASC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? order by Forwarding_price ASC");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("OUTDESC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? order by Forwarding_price DESC");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}
					}else if(searchLike2.equals("onlyproduct")) {
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? AND item_sortation Like '%제품%'");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? AND item_sortation Like '%제품%' order by Receiving_price ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? AND item_sortation Like '%제품%' order by Receiving_price DESC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("OUTASC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? AND item_sortation Like '%제품%' order by Forwarding_price ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("OUTDESC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? AND item_sortation Like '%제품%' order by Forwarding_price ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}
					}else if(searchLike2.equals("onlystock")) {
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? AND itemcode Like '%pt%'");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? AND itemcode Like '%pt%' order by Receiving_price ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? AND itemcode Like '%pt%' order by Receiving_price DESC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("OUTASC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? AND itemcode Like '%pt%' order by Forwarding_price ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("OUTDESC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? AND itemcode Like '%pt%' order by Forwarding_price ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}
					}
				}else {
					if(searchLike2.equals("ALL")) {
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? AND itemcode Like ?");
							System.out.println(pstmt);
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();					
							System.out.println("품목 검색 조건 x");	
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? AND itemcode Like ? order by Receiving_price ASC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? AND itemcode Like ? order by Receiving_price DESC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("OUTASC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? AND itemcode Like ? order by Forwarding_price ASC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("OUTDESC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? AND itemcode Like ? order by Forwarding_price DESC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}
					}else if(searchLike2.equals("onlyproduct")) {
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? AND itemcode Like ? AND item_sortation Like '%제품%'");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? AND itemcode Like ? AND item_sortation Like '%제품%' order by Receiving_price ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? AND itemcode Like ? AND item_sortation Like '%제품%' order by Receiving_price DESC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("OUTASC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? AND itemcode Like ? AND item_sortation Like '%제품%' order by Forwarding_price ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("OUTDESC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? AND itemcode Like ? AND item_sortation Like '%제품%' order by Forwarding_price ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}
					}else if(searchLike2.equals("onlystock")) {
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? AND itemcode Like ? AND itemcode Like '%pt%'");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? AND itemcode Like ? AND itemcode Like '%pt%' order by Receiving_price ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? AND itemcode Like ? AND itemcode Like '%pt%' order by Receiving_price DESC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("OUTASC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? AND itemcode Like ? AND itemcode Like '%pt%' order by Forwarding_price ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("OUTDESC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemname Like ? AND itemcode Like ? AND itemcode Like '%pt%' order by Forwarding_price ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}
					}
				}
			}else {
				if(searchLike.equals("ALL")) {
					if(searchLike2.equals("ALL")) {
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ?");
							System.out.println(pstmt);
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();					
							System.out.println("품목 검색 조건 x");	
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? order by Receiving_price ASC");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? order by Receiving_price DESC");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("OUTASC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? order by Forwarding_price ASC");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("OUTDESC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? order by Forwarding_price DESC");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}
					}else if(searchLike2.equals("onlyproduct")) {
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? AND item_sortation Like '%제품%'");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? AND item_sortation Like '%제품%' order by Receiving_price ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? AND item_sortation Like '%제품%' order by Receiving_price DESC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("OUTASC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? AND item_sortation Like '%제품%' order by Forwarding_price ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("OUTDESC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? AND item_sortation Like '%제품%' order by Forwarding_price ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}
					}else if(searchLike2.equals("onlystock")) {
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? AND itemcode Like '%pt%'");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? AND itemcode Like '%pt%' order by Receiving_price ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? AND itemcode Like '%pt%' order by Receiving_price DESC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("OUTASC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? AND itemcode Like '%pt%' order by Forwarding_price ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("OUTDESC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? AND itemcode Like '%pt%' order by Forwarding_price ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}
					}
				}else {
					if(searchLike2.equals("ALL")) {
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? AND itemcode Like ?");
							System.out.println(pstmt);
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();					
							System.out.println("품목 검색 조건 x");	
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? AND itemcode Like ? order by Receiving_price ASC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? AND itemcode Like ? order by Receiving_price DESC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("OUTASC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? AND itemcode Like ? order by Forwarding_price ASC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("OUTDESC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? AND itemcode Like ? order by Forwarding_price DESC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}
					}else if(searchLike2.equals("onlyproduct")) {
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? AND itemcode Like ? AND item_sortation Like '%제품%'");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? AND itemcode Like ? AND item_sortation Like '%제품%' order by Receiving_price ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? AND itemcode Like ? AND item_sortation Like '%제품%' order by Receiving_price DESC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("OUTASC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? AND itemcode Like ? AND item_sortation Like '%제품%' order by Forwarding_price ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("OUTDESC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? AND itemcode Like ? AND item_sortation Like '%제품%' order by Forwarding_price ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}
					}else if(searchLike2.equals("onlystock")) {
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? AND itemcode Like ? AND itemcode Like '%pt%'");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? AND itemcode Like ? AND itemcode Like '%pt%' order by Receiving_price ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? AND itemcode Like ? AND itemcode Like '%pt%' order by Receiving_price DESC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("OUTASC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? AND itemcode Like ? AND itemcode Like '%pt%' order by Forwarding_price ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("OUTDESC")){
							pstmt = con.prepareStatement("SELECT * FROM Item where itemcode Like ? AND itemcode Like ? AND itemcode Like '%pt%' order by Forwarding_price ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}
					}
				}
				
			}
			DecimalFormat df = new DecimalFormat("###,###");
			
			
			if(rs.next()){
				ItemList = new ArrayList<Item>();
				
				do {
					ItemList.add(new Item(
							rs.getString("itemcode")
							,rs.getString("itemname")
							,df.format(rs.getInt("Receiving_price"))
							,df.format(rs.getInt("Forwarding_price"))
							,rs.getString("item_sortation")
							
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
		}
		
		return ItemList;
	}
	public Item selectupdateitem(String updateitemcode) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Item updateitem = null;
		try {
			DecimalFormat df = new DecimalFormat("###,###");
			
			pstmt = con.prepareStatement("SELECT * FROM item where itemcode=?");
			pstmt.setString(1, updateitemcode);
			rs = pstmt.executeQuery();
			System.out.println("updateitemcode");
			if(rs.next()){//
				 updateitem = new Item(
							rs.getString("itemcode")
							,rs.getString("itemname")
							,df.format(rs.getInt("Receiving_price"))
							,df.format(rs.getInt("Forwarding_price"))
							,rs.getString("item_sortation")
						);
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		
		return updateitem;
	}
	public boolean updateItem(String itemcode, String itemname, int receiving_price, int forwarding_price, String item_sortation) {
		int a=0;
		boolean success = false;
		PreparedStatement pstmt=null;
		
		System.out.println("updateitem ");
	
		try {
			con.setAutoCommit(false);
			pstmt=con.prepareStatement("UPDATE item SET itemname=?, Receiving_price=?, Forwarding_price=?, item_sortation=? where itemcode=?");
			
			pstmt.setString(1, itemname);
			pstmt.setInt(2, receiving_price);
			pstmt.setInt(3, forwarding_price);
			pstmt.setString(4, item_sortation);
			pstmt.setString(5, itemcode);
			
			a=pstmt.executeUpdate();
			System.out.println("update "+a);
			con.commit(); 	
			
		}catch (SQLException e) {
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			
		}
		if(a>=1) {
			success = true;
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return success;
	}
	public boolean insertItem(String like, String itemcode, String itemname, int receiving_price, int forwarding_price, String item_sortation) {
		int a=0;
		boolean success = false;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2=null;
		ResultSet rs = null;
		String quality = null;
		int count = 0;
		System.out.println("insertitem ");
		System.out.println(like);
		String itemfirstcode="";
		try {
			con.setAutoCommit(false);
			pstmt2 = con.prepareStatement("select item_sortation from item_like where itemlikecode2=?");
			pstmt2.setString(1, like);
			rs = pstmt2.executeQuery();
			System.out.println("nowcode");
			if(rs.next()){//
			 item_sortation = rs.getString("item_sortation");
			
				}
			pstmt2 = con.prepareStatement("select itemlikecode1 from item_like where itemlikecode2=?");
			pstmt2.setString(1, like);
			rs = pstmt2.executeQuery();
			System.out.println("nowcode");
			if(rs.next()){//
			 itemfirstcode = rs.getString("itemlikecode1");
			
				}
				pstmt2 = con.prepareStatement("select count(*) from item where itemcode Like ?");
				pstmt2.setString(1, "%"+like+"%");
				rs = pstmt2.executeQuery();
				System.out.println("nowcode");
				if(rs.next()){//
				 count = rs.getInt("count(*)");
				
					}
				count++;
				DecimalFormat df = new DecimalFormat("000");
				
				itemcode = itemfirstcode+"-"+like+"-"+df.format(count);	
				
			
		
			pstmt=con.prepareStatement("Insert into item Values (?,?,?,?,?)");
			pstmt.setString(1, itemcode);
			pstmt.setString(2, itemname);
			pstmt.setInt(3, receiving_price);
			pstmt.setInt(4, forwarding_price);
			pstmt.setString(5, item_sortation);
			
			a=pstmt.executeUpdate();
			System.out.println("Insert "+a);
			con.commit(); 	
			
		}catch (SQLException e) {
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			close(pstmt2);
			close(rs);
		}
		if(a>=1) {
			success = true;
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return success;
	}
	public ArrayList<BomP> selectBomList() {
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<BomP> bomList = null;
		int i=0;
		
		System.out.println("bom제품 리스트");	
		try {
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM bom_product");
			
			
			
			if(rs.next()){
				bomList = new ArrayList<BomP>();
				
				do {
					bomList.add(new BomP(
							rs.getString("itemcode")
							,rs.getString("itemname")
							,rs.getInt("materials")
							,rs.getString("bom_code")
							
							
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(stmt);
		}
		
		return bomList;
	}
	public ArrayList<BomS> selectBomStockList(String selectBomStock) {
		PreparedStatement pstmt=null;
		
		ResultSet rs= null;
		ArrayList<BomS> bomList = null;
		int i=0;
		
		System.out.println("bom부품 리스트");	
		System.out.println(selectBomStock);	
		try {
			
			pstmt = con.prepareStatement("select bom_product.itemcode AS 'productcode', bom_product.itemname AS 'productname', bom_stock.bom_code, bom_stock.itemcode, bom_stock.itemname, bom_stock.materials from bom_stock, bom_product where bom_stock.bom_code = bom_product.bom_code and bom_stock.bom_code=?");
			pstmt.setString(1, selectBomStock);
			rs = pstmt.executeQuery();
			System.out.println(rs);	
			
			if(rs.next()){
				bomList = new ArrayList<BomS>();
				System.out.println("bom 부품 객체 생성");
				do {
					bomList.add(new BomS(
							rs.getString("productcode")
							,rs.getString("productname")
							,rs.getString("itemcode")
							,rs.getString("itemname")
							,rs.getInt("materials")
							,rs.getString("bom_code")
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
		}
		System.out.println("bom 부품 객체 리턴");
		return bomList;
	}
	public boolean deleteFromStock(String bom_code, String itemcode) {
		int a=0;
		boolean success = false;
		PreparedStatement pstmt=null;
		
		System.out.println("updateitem ");
	
		try {
			con.setAutoCommit(false);
			pstmt=con.prepareStatement("delete from bom_stock where bom_code=? AND itemcode=?");
			
			pstmt.setString(1, bom_code);
			pstmt.setString(2, itemcode);
			
			a=pstmt.executeUpdate();
			System.out.println("delete "+a);
			
			pstmt=con.prepareStatement("update bom_product set materials = materials - 1 Where bom_code=?");
			pstmt.setString(1, bom_code);
			a=pstmt.executeUpdate();
			con.commit(); 	
			
		}catch (SQLException e) {
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			
		}
		if(a>=1) {
			success = true;
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return success;
	}
	public String selectItemNameOne(String itemcode) {
		PreparedStatement pstmt=null;
		
		ResultSet rs= null;
		String itemname = null;
		int i=0;
		
		System.out.println("품목이름반환");	
			
		try {
			
			pstmt = con.prepareStatement("select itemname from item where itemcode=?");
			pstmt.setString(1, itemcode);
			rs = pstmt.executeQuery();
			System.out.println(rs);	
			
			if(rs.next()){
				
				
				do {
					itemname = rs.getString("itemname");							
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
		}
		
		return itemname;
	}
	public int selectMaterials(String Bom_code, String itemcode) {
		PreparedStatement pstmt=null;
		
		ResultSet rs= null;
		int materials = 0;
		int i=0;
		
		System.out.println("재료개수반환");	
			
		try {
			
			pstmt = con.prepareStatement("select materials from bom_stock where itemcode=? and bom_code=?");
			pstmt.setString(1, itemcode);
			pstmt.setString(2, Bom_code);
			rs = pstmt.executeQuery();
			System.out.println(rs);	
			
			if(rs.next()){
				
				
				do {
					materials = rs.getInt("materials");							
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
		}
		
		return materials;
	}
	public ArrayList<Item> selectItemNotInList(String bom_code,String itemcode) {
		PreparedStatement pstmt=null;
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<Item> ItemList = null;
		int i=0;
		
		System.out.println("없는 품목 리스트");	
	
		try {
							pstmt = con.prepareStatement("select * from item where itemcode not in (select itemcode from bom_stock where bom_code=?) And item_sortation='부품';");
							System.out.println(pstmt);
							pstmt.setString(1, bom_code);
							rs = pstmt.executeQuery();					
							
							DecimalFormat df = new DecimalFormat("###,###");
			if(rs.next()){
				ItemList = new ArrayList<Item>();
				
				do {
					ItemList.add(new Item(
							rs.getString("itemcode")
							,rs.getString("itemname")
							,df.format(rs.getInt("Receiving_price"))
							,df.format(rs.getInt("Forwarding_price"))
							,rs.getString("item_sortation")
							
							));
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
		}
		
		return ItemList;
	}
	public boolean updateBomStock(String bom_code, String itemcode, String itemname, int materials, String o_itemcode) {
		int a=0;
		boolean success = false;
		PreparedStatement pstmt=null;
		
		System.out.println("updatebomstock ");
	
		try {
			con.setAutoCommit(false);
			pstmt=con.prepareStatement("UPDATE bom_stock SET itemcode=?, itemname=?, materials=? where bom_code=? and itemcode=?");
			
			pstmt.setString(1, itemcode);
			pstmt.setString(2, itemname);
			pstmt.setInt(3, materials);
			pstmt.setString(4, bom_code);
			pstmt.setString(5, o_itemcode);
			
			a=pstmt.executeUpdate();
			System.out.println("update "+a);
			con.commit(); 	
			
		}catch (SQLException e) {
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			
		}
		if(a>=1) {
			success = true;
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return success;
	}
	public boolean insertBomStock(String bom_code, String itemcode, String itemname, int materials) {
		int a=0;
		boolean success = false;
		PreparedStatement pstmt=null;
		
		ResultSet rs = null;

		int count = 0;
		
		try {
			con.setAutoCommit(false);
			
				
			
			pstmt=con.prepareStatement("update bom_product set materials = materials + 1 Where bom_code=?");
			pstmt.setString(1, bom_code);
			a=pstmt.executeUpdate();
			pstmt=con.prepareStatement("Insert into bom_stock Values (?,?,?,?)");
			pstmt.setString(1, bom_code);
			pstmt.setString(2, itemcode);
			pstmt.setString(3, itemname);
			pstmt.setInt(4, materials);
			
			
			a=pstmt.executeUpdate();
			System.out.println("Insert "+a);
			con.commit(); 	
			
		}catch (SQLException e) {
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			
			close(rs);
		}
		if(a>=1) {
			success = true;
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return success;
	}
	public ArrayList<Item> selectProductNotInList() {
		PreparedStatement pstmt=null;
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<Item> ItemList = null;
		int i=0;
		
		System.out.println("없는 제품 리스트");	
	
		try {
							pstmt = con.prepareStatement("select * from item where itemcode not in (select itemcode from bom_product) And item_sortation='제품';");
							System.out.println(pstmt);
			
							rs = pstmt.executeQuery();					
							DecimalFormat df = new DecimalFormat("###,###");
			if(rs.next()){
				ItemList = new ArrayList<Item>();
				
				do {
					ItemList.add(new Item(
							rs.getString("itemcode")
							,rs.getString("itemname")
							,df.format(rs.getInt("Receiving_price"))
							,df.format(rs.getInt("Forwarding_price"))
							,rs.getString("item_sortation")
							
							));
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
		}
		
		return ItemList;
	}
	public boolean insertBomBase(String itemcode, String itemname) {
		int a=0;
		boolean success = false;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2=null;
		ResultSet rs = null;

		int count = 0;
		String bom_code = null;
		try {
			con.setAutoCommit(false);
			pstmt2 = con.prepareStatement("select count(*) from bom_product");
			
			rs = pstmt2.executeQuery();
			
			if(rs.next()){//
			 count = rs.getInt("count(*)");
			
				}
			count++;
			DecimalFormat df = new DecimalFormat("000");
			
			bom_code = "cp-bom-"+df.format(count);	
			
			
			pstmt=con.prepareStatement("Insert into bom_product Values (?,?,?,?)");
			pstmt.setString(1, bom_code);
			pstmt.setString(2, itemcode);
			pstmt.setString(3, itemname);
			pstmt.setInt(4, 8);
			a=pstmt.executeUpdate();
			
			pstmt=con.prepareStatement("Insert into bom_stock Values (?,?,?,?)");
			pstmt.setString(1, bom_code);
			pstmt.setString(2, "pt-cas-001");
			pstmt.setString(3, "1번케이스");
			pstmt.setInt(4, 1);
			a=pstmt.executeUpdate();
			
			pstmt=con.prepareStatement("Insert into bom_stock Values (?,?,?,?)");
			pstmt.setString(1, bom_code);
			pstmt.setString(2, "pt-cpu-001");
			pstmt.setString(3, "i5 4670");
			pstmt.setInt(4, 1);
			a=pstmt.executeUpdate();
			
			pstmt=con.prepareStatement("Insert into bom_stock Values (?,?,?,?)");
			pstmt.setString(1, bom_code);
			pstmt.setString(2, "pt-gpu-001");
			pstmt.setString(3, "GTX 760");
			pstmt.setInt(4, 1);
			a=pstmt.executeUpdate();
			
			pstmt=con.prepareStatement("Insert into bom_stock Values (?,?,?,?)");
			pstmt.setString(1, bom_code);
			pstmt.setString(2, "pt-mai-001");
			pstmt.setString(3, "LGA1150소켓메인보드");
			pstmt.setInt(4, 1);
			a=pstmt.executeUpdate();
			
			pstmt=con.prepareStatement("Insert into bom_stock Values (?,?,?,?)");
			pstmt.setString(1, bom_code);
			pstmt.setString(2, "pt-pow-001");
			pstmt.setString(3, "450W파워");
			pstmt.setInt(4, 1);
			a=pstmt.executeUpdate();
			
			pstmt=con.prepareStatement("Insert into bom_stock Values (?,?,?,?)");
			pstmt.setString(1, bom_code);
			pstmt.setString(2, "pt-ssd-001");
			pstmt.setString(3, "SSD_256G");
			pstmt.setInt(4, 1);
			a=pstmt.executeUpdate();
			
			pstmt=con.prepareStatement("Insert into bom_stock Values (?,?,?,?)");
			pstmt.setString(1, bom_code);
			pstmt.setString(2, "pt-ram-001");
			pstmt.setString(3, "Ram 4G");
			pstmt.setInt(4, 4);
			a=pstmt.executeUpdate();
			
			pstmt=con.prepareStatement("Insert into bom_stock Values (?,?,?,?)");
			pstmt.setString(1, bom_code);
			pstmt.setString(2, "pt-hdd-001");
			pstmt.setString(3, "HDD_1T");
			pstmt.setInt(4, 1);
			a=pstmt.executeUpdate();
			System.out.println("Insert "+a);
			con.commit(); 	
			
		}catch (SQLException e) {
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			close(pstmt2);
			close(rs);
		}
		if(a>=1) {
			success = true;
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return success;
	}
	
	public ArrayList<Holding> selectHoldingList() {
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<Holding> holdingList = null;
		int i=0;
		
		System.out.println("재고 리스트");	
		try {
			DecimalFormat df = new DecimalFormat("###,###");
			
				
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM holding");
			
			
			
			if(rs.next()){
				holdingList = new ArrayList<Holding>();
				
				do {
					holdingList.add(new Holding(
							rs.getString("itemcode")
							,rs.getString("itemname")
							,rs.getString("warename")
							,rs.getString("holdingday")
							,df.format(rs.getInt("Receiving_price"))
							,rs.getInt("acount")
							));
					System.out.println(rs.getInt("Receiving_price"));	
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(stmt);
		}
		
		return holdingList;
	}
	
	public ArrayList<Holding> selectHoldingSearchList(String searchoption,String searchLike,String searchLike2,String searchorder,String searchvalue) {
		PreparedStatement pstmt=null;
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<Holding> holdingList = null;
		int i=0;
		
		System.out.println("재고 검색 리스트");	
		System.out.println(searchoption); // 검색종류
		System.out.println(searchLike);	//품목종류
		System.out.println(searchLike2); //창고종류	
		System.out.println(searchorder); //내림차순	
		System.out.println(searchvalue); // 검색값
		
		System.out.println("%"+searchvalue+"%");
		try {
			if(searchoption.equals("itemname")) {
				if(searchLike.equals("ALL")) {
					if(searchLike2.equals("ALL")) {
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM holding where itemname Like ?");
							System.out.println(pstmt);
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();					
							System.out.println("품목 검색 조건 x");	
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM holding where itemname Like ? order by acount ASC");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM holding where itemname Like ? order by acount DESC");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}
					}else{
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM holding where itemname Like ? AND warename=?");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, searchLike2);
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM holding where itemname Like ? AND warename=? order by acount ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, searchLike2);
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM holding where itemname Like ? AND warename=? order by acount DESC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, searchLike2);
							rs = pstmt.executeQuery();
						}
					}
				}else {
					if(searchLike2.equals("ALL")) {
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM holding where itemname Like ? AND itemcode Like ?");
							System.out.println(pstmt);
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();					
							System.out.println("품목 검색 조건 x");	
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM holding where itemname Like ? AND itemcode Like ? order by acount ASC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM holding where itemname Like ? AND itemcode Like ? order by acount DESC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}
					}else{
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM holding where itemname Like ? AND itemcode Like ? AND warename=?");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							pstmt.setString(3, searchLike2);
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM holding where itemname Like ? AND itemcode Like ? AND warename=? order by acount ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							pstmt.setString(3, searchLike2);
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM holding where itemname Like ? AND itemcode Like ? AND warename=? order by acount DESC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							pstmt.setString(3, searchLike2);
							rs = pstmt.executeQuery();
						}
					}
				}
			}else {
				if(searchLike.equals("ALL")) {
					if(searchLike2.equals("ALL")) {
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM holding where itemcode Like ?");
							System.out.println(pstmt);
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();					
							System.out.println("품목 검색 조건 x");	
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM holding where itemcode Like ? order by acount ASC");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM holding where itemcode Like ? order by acount DESC");
							pstmt.setString(1, "%"+searchvalue+"%");
							rs = pstmt.executeQuery();
						}
					}else{
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM holding where itemcode Like ? AND warename=?");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, searchLike2);
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM holding where itemcode Like ? AND warename? order by acount ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, searchLike2);
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM holding where itemcode Like ? AND warename=? order by acount DESC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, searchLike2);
							rs = pstmt.executeQuery();
						}
					}
				}else {
					if(searchLike2.equals("ALL")) {
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM holding where itemcode Like ? AND itemcode Like ?");
							System.out.println(pstmt);
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();					
							System.out.println("품목 검색 조건 x");	
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM holding where itemcode Like ? AND itemcode Like ? order by acount ASC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM holding where itemcode Like ? AND itemcode Like ? order by acount DESC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}
					}else {
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM holding where itemcode Like ? AND itemcode Like ? AND warename=?");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							pstmt.setString(3, searchLike2);
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM holding where itemcode Like ? AND itemcode Like ? AND warename=? order by acount ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							pstmt.setString(3, searchLike2);
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM holding where itemcode Like ? AND itemcode Like ? AND warename=? order by acount DESC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, "%"+searchLike+"%");
							pstmt.setString(3, searchLike2);
							rs = pstmt.executeQuery();
						}
					}
				}
				
			}
			DecimalFormat df = new DecimalFormat("###,###");
			
			
			if(rs.next()){
				holdingList = new ArrayList<Holding>();
				
				do {
					holdingList.add(new Holding(
							rs.getString("itemcode")
							,rs.getString("itemname")
							,rs.getString("warename")
							,rs.getString("holdingday")
							,df.format(rs.getInt("Receiving_price"))
							,rs.getInt("acount")
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
		}
		
		return holdingList;
	}
	public Holding selectupdateholding(String updateholdingcode) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Holding updateholding = null;
		try {
			DecimalFormat df = new DecimalFormat("###,###");
			
			pstmt = con.prepareStatement("SELECT * FROM holding where itemcode=?");
			pstmt.setString(1, updateholdingcode);
			rs = pstmt.executeQuery();
			System.out.println("updateholdingcode");
			if(rs.next()){//
				 updateholding =new Holding(
							rs.getString("itemcode")
							,rs.getString("itemname")
							,rs.getString("warename")
							,rs.getString("holdingday")
							,df.format(rs.getInt("Receiving_price"))
							,rs.getInt("acount")
						);
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		
		return updateholding;
	}
	
	public boolean updateHolding(String itemcode, String itemname, int receiving_price, int acount, String warename) {
		int a=0;
		boolean success = false;
		int firstacount = 0;
		
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		System.out.println("updateitem");
	
		try {
			con.setAutoCommit(false);
			pstmt=con.prepareStatement("select acount from holding where itemcode=? and itemname=? and warename=?");
			
			pstmt.setString(1, itemcode);
			pstmt.setString(2, itemname);
			pstmt.setString(3, warename);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				
				do {
					firstacount = rs.getInt("acount");							
				
				} while (rs.next());
				
			}
			pstmt=con.prepareStatement("UPDATE holding SET warename=?, acount=?, holdingday=now() where itemcode=? and itemname=?");
			
			pstmt.setString(1, warename);
			pstmt.setInt(2, acount);
			pstmt.setString(3, itemcode);
			pstmt.setString(4, itemname);
			
			a=pstmt.executeUpdate();
			System.out.println("update "+a);
			System.out.println("firstacount = "+firstacount);
			
			con.commit(); 	
			
		}catch (SQLException e) {
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			
		}
		if(a>=1) {
			success = true;
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return success;
	}
	public ArrayList<Item> selectProductNotInList2() {
		PreparedStatement pstmt=null;
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<Item> ItemList = null;
		int i=0;
		
		System.out.println("없는 재고 리스트");	
	
		try {
			
				
					
						
							pstmt = con.prepareStatement("select * from item where itemcode not in (select itemcode from holding)");
							System.out.println(pstmt);
			
							rs = pstmt.executeQuery();					
							
						
					
				
				
			
			
			
			if(rs.next()){
				ItemList = new ArrayList<Item>();
				
				do {
					ItemList.add(new Item(
							rs.getString("itemcode")
							,rs.getString("itemname")
							,rs.getString("Receiving_price")
							,rs.getString("Forwarding_price")
							,rs.getString("item_sortation")
							
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
		}
		
		return ItemList;
	}
	
	public boolean insertHolding(String itemcode, String itemname,int materials,String warename) {
		int a=0;
		boolean success = false;
		PreparedStatement pstmt=null;
		int receving_price = 0;
		ResultSet rs = null;

		int count = 0;
		String bom_code = null;
		try {
			con.setAutoCommit(false);
			pstmt=con.prepareStatement("select Receiving_price from item where itemcode=?");
			pstmt.setString(1, itemcode);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				
				
					do {
						receving_price = rs.getInt("Receiving_price");							
					
					} while (rs.next());
				
				}
			
			
			System.out.println(warename+" this");	
			pstmt=con.prepareStatement("Insert into holding Values (?,?,?,now(),?,?)");
			pstmt.setString(1, itemcode);
			pstmt.setString(2, itemname);
			pstmt.setString(3, warename);
			pstmt.setInt(4, receving_price);
			pstmt.setInt(5, materials);
			a=pstmt.executeUpdate();
		
				//pstmt=con.prepareStatement("Insert Into holding_log Values (?,?,?,NOW(),?,?,'입고')");
				//pstmt.setString(1, itemcode);
				//pstmt.setString(2, itemname);
				//pstmt.setString(3, warename);
				//pstmt.setInt(4, materials);
				//pstmt.setInt(5, materials);
			//a=pstmt.executeUpdate();
			
			con.commit(); 	
			
		}catch (SQLException e) {
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			
			close(rs);
		}
		if(a>=1) {
			success = true;
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return success;
	}
	
	public ArrayList<Order> selectOrderList() {
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<Order> orderList = null;
		int i=0;
		
		System.out.println("수주 리스트");	
		try {
			DecimalFormat df = new DecimalFormat("###,###");
		
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM orders");
			
			
			
			if(rs.next()){
				orderList = new ArrayList<Order>();
				
				do {
					orderList.add(new Order(
							rs.getString("ordercode")
							,rs.getString("clientname")
							,rs.getString("itemname")
							,rs.getString("orderday")
							,rs.getString("delivery_day")
							,df.format(rs.getInt("forwarding_price"))
							,rs.getInt("count")
							,df.format(rs.getInt("sv"))
							,df.format(rs.getInt("total_amount"))
							,rs.getString("ecode")
							,rs.getString("name")
							,rs.getString("progress_status")
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");
					System.out.println(rs.getString("ordercode"));
					System.out.println(rs.getString("clientname"));
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(stmt);
		}
		
		return orderList;
	}
	public ArrayList<Order> selectOrderSearchList(String searchoption,String firstdate,String finaldate,String progress,String searchvalue,String firstdate2,String finaldate2) {
		PreparedStatement pstmt=null;
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<Order> OrderList = null;
		int i=0;
		
		System.out.println("수주 검색 리스트");	
		
		System.out.println("%"+searchvalue+"%");
		System.out.println(firstdate+"/"+firstdate2);
		System.out.println(finaldate+"/"+finaldate2);
		try {
			if(searchoption.equals("itemname")) {
				if(progress.equals("ALL")) {
							pstmt = con.prepareStatement(" select * from orders where itemname Like ? and orderday >= ? AND orderday <= ? and delivery_day >= ? And delivery_day <=?");
							System.out.println(pstmt);
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, finaldate);
							pstmt.setString(5, finaldate2);
							rs = pstmt.executeQuery();					
							System.out.println("품목 검색 조건 x");	
					
				}else if(progress.equals("Check")) {
					pstmt = con.prepareStatement(" select * from orders where itemname Like ? and orderday >= ? AND orderday <= ? and delivery_day >= ? And delivery_day <=? And progress_status='재고확인'");
					System.out.println(pstmt);
					pstmt.setString(1, "%"+searchvalue+"%");
					pstmt.setString(2, firstdate);
					pstmt.setString(3, firstdate2);
					pstmt.setString(4, finaldate);
					pstmt.setString(5, finaldate2);
					rs = pstmt.executeQuery();					
					System.out.println("품목 검색 조건 x");	
			
				}else if(progress.equals("Place_an_order")) {
					pstmt = con.prepareStatement(" select * from orders where itemname Like ? and orderday >= ? AND orderday <= ? and delivery_day >= ? And delivery_day <=? And progress_status='발주신청'");
					System.out.println(pstmt);
					pstmt.setString(1, "%"+searchvalue+"%");
					pstmt.setString(2, firstdate);
					pstmt.setString(3, firstdate2);
					pstmt.setString(4, finaldate);
					pstmt.setString(5, finaldate2);
					rs = pstmt.executeQuery();					
					System.out.println("품목 검색 조건 x");	
			
				}else if(progress.equals("warehousing")) {
					pstmt = con.prepareStatement(" select * from orders where itemname Like ? and orderday >= ? AND orderday <= ? and delivery_day >= ? And delivery_day <=? And progress_status='입고완료'");
					System.out.println(pstmt);
					pstmt.setString(1, "%"+searchvalue+"%");
					pstmt.setString(2, firstdate);
					pstmt.setString(3, firstdate2);
					pstmt.setString(4, finaldate);
					pstmt.setString(5, finaldate2);
					rs = pstmt.executeQuery();					
					System.out.println("품목 검색 조건 x");	
			
				}else if(progress.equals("outing")) {
					pstmt = con.prepareStatement(" select * from orders where itemname Like ? and orderday >= ? AND orderday <= ? and delivery_day >= ? And delivery_day <=? And progress_status='출고완료'");
					System.out.println(pstmt);
					pstmt.setString(1, "%"+searchvalue+"%");
					pstmt.setString(2, firstdate);
					pstmt.setString(3, firstdate2);
					pstmt.setString(4, finaldate);
					pstmt.setString(5, finaldate2);
					rs = pstmt.executeQuery();					
					System.out.println("품목 검색 조건 x");	
			
				}
				
			}else if(searchoption.equals("clientname")) {
				if(progress.equals("ALL")) {
					pstmt = con.prepareStatement(" select * from orders where clientname Like ? and orderday >= ? AND orderday <= ? and delivery_day >= ? And delivery_day <=?");
					System.out.println(pstmt);
					pstmt.setString(1, "%"+searchvalue+"%");
					pstmt.setString(2, firstdate);
					pstmt.setString(3, firstdate2);
					pstmt.setString(4, finaldate);
					pstmt.setString(5, finaldate2);
					rs = pstmt.executeQuery();					
					System.out.println("품목 검색 조건 x");	
			
				}else if(progress.equals("Check")) {
					pstmt = con.prepareStatement(" select * from orders where clientname Like ? and orderday >= ? AND orderday <= ? and delivery_day >= ? And delivery_day <=? And progress_status='재고확인'");
					System.out.println(pstmt);
					pstmt.setString(1, "%"+searchvalue+"%");
					pstmt.setString(2, firstdate);
					pstmt.setString(3, firstdate2);
					pstmt.setString(4, finaldate);
					pstmt.setString(5, finaldate2);
					rs = pstmt.executeQuery();					
					System.out.println("품목 검색 조건 x");	
	
				}else if(progress.equals("Place_an_order")) {
					pstmt = con.prepareStatement(" select * from orders where clientname Like ? and orderday >= ? AND orderday <= ? and delivery_day >= ? And delivery_day <=? And progress_status='발주신청'");
					System.out.println(pstmt);
					pstmt.setString(1, "%"+searchvalue+"%");
					pstmt.setString(2, firstdate);
					pstmt.setString(3, firstdate2);
					pstmt.setString(4, finaldate);
					pstmt.setString(5, finaldate2);
					rs = pstmt.executeQuery();					
					System.out.println("품목 검색 조건 x");	
	
				}else if(progress.equals("warehousing")) {
					pstmt = con.prepareStatement(" select * from orders where clientname Like ? and orderday >= ? AND orderday <= ? and delivery_day >= ? And delivery_day <=? And progress_status='입고완료'");
					System.out.println(pstmt);
					pstmt.setString(1, "%"+searchvalue+"%");
					pstmt.setString(2, firstdate);
					pstmt.setString(3, firstdate2);
					pstmt.setString(4, finaldate);
					pstmt.setString(5, finaldate2);
					rs = pstmt.executeQuery();					
					System.out.println("품목 검색 조건 x");	
			
				}else if(progress.equals("outing")) {
					pstmt = con.prepareStatement(" select * from orders where clientname Like ? and orderday >= ? AND orderday <= ? and delivery_day >= ? And delivery_day <=? And progress_status='출고완료'");
					System.out.println(pstmt);
					pstmt.setString(1, "%"+searchvalue+"%");
					pstmt.setString(2, firstdate);
					pstmt.setString(3, firstdate2);
					pstmt.setString(4, finaldate);
					pstmt.setString(5, finaldate2);
					rs = pstmt.executeQuery();					
					System.out.println("품목 검색 조건 x");	
			
				}
		
			}
			DecimalFormat df = new DecimalFormat("###,###");
			
			
			if(rs.next()){
				OrderList = new ArrayList<Order>();
				
				do {
					OrderList.add(new Order(
							rs.getString("ordercode")
							,rs.getString("clientname")
							,rs.getString("itemname")
							,rs.getString("orderday")
							,rs.getString("delivery_day")
							,df.format(rs.getInt("forwarding_price"))
							,rs.getInt("count")
							,df.format(rs.getInt("sv"))
							,df.format(rs.getInt("total_amount"))
							,rs.getString("ecode")
							,rs.getString("name")
							,rs.getString("progress_status")
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
		}
		
		return OrderList;
	}
	public Order selectupdateorder(String updateordercode) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Order updateorder = null;
		try {
			DecimalFormat df = new DecimalFormat("###,###");
		
			System.out.println(updateordercode);
			pstmt = con.prepareStatement("SELECT * FROM orders where ordercode=?");
			pstmt.setString(1, updateordercode);
			rs = pstmt.executeQuery();
			System.out.println("updateordercode");
			if(rs.next()){//
				 updateorder =new Order(
							rs.getString("ordercode")
							,rs.getString("clientname")
							,rs.getString("itemname")
							,rs.getString("orderday")
							,rs.getString("delivery_day")
							,df.format(rs.getInt("forwarding_price"))
							,rs.getInt("count")
							,df.format(rs.getInt("sv"))
							,df.format(rs.getInt("total_amount"))
							,rs.getString("ecode")
							,rs.getString("name")
							,rs.getString("progress_status")
							);
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		
		return updateorder;
	}
	public ArrayList<Item> selectItemProductList() {
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<Item> itemList = null;
		int i=0;
		
		System.out.println("품목 리스트");	
		try {
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM item where item_sortation='제품'");
			DecimalFormat df = new DecimalFormat("###,###");
			
			
			
			if(rs.next()){
				itemList = new ArrayList<Item>();
				
				do {
					itemList.add(new Item(
							rs.getString("itemcode")
							,rs.getString("itemname")
							,df.format(rs.getInt("Receiving_price"))
							,df.format(rs.getInt("Forwarding_price"))
							,rs.getString("item_sortation")
							
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(stmt);
		}
		
		return itemList;
	}
	public ArrayList<employee> selectEmployeeList() {
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<employee> employeeList = null;
		int i=0;
		
		System.out.println("사원 리스트");	
		try {
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM employee");
			
			
			
			if(rs.next()){
				employeeList = new ArrayList<employee>();
				
				do {
					employeeList.add(new employee(
							rs.getString("ecode")
							,rs.getString("name")
							,rs.getString("department")
							,rs.getString("position")
						
							
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(stmt);
		}
		
		return employeeList;
	}
	public boolean updateOrder(String ordercode,String clientname,String itemname,String orderday,String delivery_day,int forwarding_price,int count,int total_amount,String ecode,String name,int sv) {
		int a=0;
		boolean success = false;
		PreparedStatement pstmt=null;
		
		System.out.println("updateitem ");
	
		try {
			con.setAutoCommit(false);
			pstmt=con.prepareStatement("UPDATE orders SET clientname=?, itemname=?, orderday=?, delivery_day=?, Forwarding_price=?, count=?, total_amount=?, ecode=?, name=?, sv=? where ordercode=?");
			
			pstmt.setString(1, clientname);
			pstmt.setString(2, itemname);
			pstmt.setString(3, orderday);
			pstmt.setString(4, delivery_day);
			pstmt.setInt(5, forwarding_price);
			pstmt.setInt(6, count);
			pstmt.setInt(7, total_amount);
			pstmt.setString(8, ecode);
			pstmt.setString(9, name);
			
			pstmt.setInt(10, sv);
			pstmt.setString(11, ordercode);
			a=pstmt.executeUpdate();
			System.out.println("update "+a);
			con.commit(); 	
			
		}catch (SQLException e) {
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			
		}
		if(a>=1) {
			success = true;
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(success);
		return success;
	}
	
	public boolean insertOrder(String clientname,String itemname,String orderday,String delivery_day,int forwarding_price,int count,int total_amount,String ecode,String name,int sv) {
		int a=0;
		boolean success = false;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2=null;
		ResultSet rs = null;
		String quality = null;
		String ordercode = null;
		int rowcount = 0;
		System.out.println("insertOrder ");
		SimpleDateFormat sf = new SimpleDateFormat("MMdd");
		 LocalDate now = LocalDate.now();

	       
	     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMdd");

	   
	     String formatedNow = "22"+now.format(formatter);
	     
		
		try {
			con.setAutoCommit(false);
			
				pstmt2 = con.prepareStatement("select count(*) from orders where ordercode Like ?");
				pstmt2.setString(1, "%"+formatedNow+"%");
				rs = pstmt2.executeQuery();
				System.out.println("nowcode");
				if(rs.next()){//
				 rowcount = rs.getInt("count(*)");
				
					}
				rowcount++;
				DecimalFormat df = new DecimalFormat("000");
				
				ordercode = "od-"+formatedNow+"-"+df.format(rowcount);	
				
			
		
			pstmt=con.prepareStatement("Insert into orders Values (?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, ordercode);
			pstmt.setString(2, clientname);
			pstmt.setString(3, itemname);
			pstmt.setString(4, orderday);
			pstmt.setString(5, delivery_day);
			pstmt.setInt(6, forwarding_price);
			pstmt.setInt(7, count);
			pstmt.setInt(8, sv);
			pstmt.setInt(9, total_amount);
			pstmt.setString(10, ecode);
			pstmt.setString(11, name);
			pstmt.setString(12, "재고확인");
			
			a=pstmt.executeUpdate();
			System.out.println("Insert "+a);
			con.commit(); 	
			
		}catch (SQLException e) {
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			close(pstmt2);
			close(rs);
		}
		if(a>=1) {
			success = true;
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return success;
	}
	public ArrayList<po> selectPoList() {
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<po> poList = null;
		int i=0;
		
		System.out.println("발주 리스트");	
		try {
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM place_an_order");
			DecimalFormat df = new DecimalFormat("###,###");
			
			
			if(rs.next()){
				poList = new ArrayList<po>();
				
				do {
					poList.add(new po(
							rs.getString("placecode")
							,rs.getString("warename")
							,rs.getString("orderday")
							,rs.getString("delivery_day")
							,df.format(rs.getInt("sv"))
							,df.format(rs.getInt("total_amount"))
							,rs.getString("ecode")
							,rs.getString("name")
							,rs.getString("progress_status")
							,rs.getString("ordercode")
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(stmt);
		}
		
		return poList;
	}
	public Post selectPost(String selectpo) {
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		Post post = null;
		int i=0;
		
	
		try {
			pstmt = con.prepareStatement("select * from place_an_order_warehouse where placecode=?");
			pstmt.setString(1, selectpo);
			rs = pstmt.executeQuery();
			
			
			if(rs.next()){
				
				
				do {
					post = new Post(
							rs.getString("placecode")
							,rs.getString("warename")
							,rs.getString("tempname")
							,rs.getString("defectname")
							
							);
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
		}
		
		return post;
	}
	public ArrayList<pos> selectPoStockList(String selectpoStock) {
		PreparedStatement pstmt=null;
		
		ResultSet rs= null;
		ArrayList<pos> posList = null;
		int i=0;
		
		System.out.println("발주품목 리스트");	
		System.out.println(selectpoStock);	
		try {
			//발주코드로 거래처명, 아이템명 확인 가능
			pstmt = con.prepareStatement("select * from place_stock where placecode=?;");
			pstmt.setString(1, selectpoStock);
			rs = pstmt.executeQuery();
			System.out.println(rs);	
			
			if(rs.next()){
				posList = new ArrayList<pos>();
				System.out.println("발주품목객체");
				do {
					posList.add(new pos(
							rs.getString("placecode")
							,rs.getString("itemcode")
							,rs.getString("itemname")
							,rs.getString("clientname")
							,rs.getInt("materials")
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
		}
		
		return posList;
	}
	public po selectPoOne(String getpo) {
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		po poList = null;
		int i=0;
		
		System.out.println("발주 ");	
		try {
			
			
			pstmt = con.prepareStatement("select * from place_an_order where placecode=?");
			pstmt.setString(1, getpo);
			rs = pstmt.executeQuery();
			DecimalFormat df = new DecimalFormat("###,###");
			
			
			if(rs.next()){
				
				
				do {
					poList = new po(
							rs.getString("placecode")
							,rs.getString("warename")
							,rs.getString("orderday")
							,rs.getString("delivery_day")
							,df.format(rs.getInt("sv"))
							,df.format(rs.getInt("total_amount"))
							,rs.getString("ecode")
							,rs.getString("name")
							,rs.getString("progress_status")
							,rs.getString("ordercode")
							);
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
		}
		
		return poList;
	}
	public pos selectPoStockOne(String getpo, String placecode) {
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		pos poList = null;
		int i=0;
		
		System.out.println("발주 ");	
		System.out.println("발주 ");	
		try {
			
			
			pstmt = con.prepareStatement("select * from place_stock where  itemcode=? and placecode=? ");
			pstmt.setString(1, getpo);
			pstmt.setString(2, placecode);
			rs = pstmt.executeQuery();
			DecimalFormat df = new DecimalFormat("###,###");
			
			
			if(rs.next()){
				
				
				do {
					poList = new pos(
							rs.getString("placecode")
							,rs.getString("itemcode")
							,rs.getString("itemname")
							,rs.getString("clientname")
							,rs.getInt("materials")
							);
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
		}
		
		return poList;
	}
	public boolean updatePoStock(String placecode, String itemcode, int materials, String clientname) {
		int a=0;
		boolean success = false;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		System.out.println("updatepostock ");
		int total = 0;
		int finaltotal = 0;
		int i=0;
		try {
			con.setAutoCommit(false);
			pstmt=con.prepareStatement("UPDATE place_stock SET materials=?, clientname=? where placecode=? and itemcode=?");
			
			
			
			pstmt.setInt(1, materials);
			pstmt.setString(2, clientname);
			pstmt.setString(3, placecode);
			pstmt.setString(4, itemcode);
			
			a=pstmt.executeUpdate();
			System.out.println("update "+a);
			
			pstmt=con.prepareStatement("select place_stock.itemname,item.receiving_price,place_stock.materials from place_stock,item where place_stock.itemcode=item.itemcode and place_stock.placecode=?");
			pstmt.setString(1, placecode);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				
				
				do {
					total = total + rs.getInt("materials")*rs.getInt("receiving_price");
							
							
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
				finaltotal = (int) (total*1.1);
				
				pstmt=con.prepareStatement("UPDATE place_an_order SET sv=?, total_amount=? where placecode=?");
				pstmt.setInt(1, total);
				pstmt.setInt(2, finaltotal);
				pstmt.setString(3, placecode);
				a=pstmt.executeUpdate();
				System.out.println("update "+a);
				
			}
			
			
			con.commit(); 	
			
		}catch (SQLException e) {
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			
		}
		if(a>=1) {
			success = true;
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return success;
	}
	public boolean updatePo(String placecode, String warename,String orderday, String deliveryday, String ecode, String ename) {
		int a=0;
		boolean success = false;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		System.out.println("updatepostock ");
		int total = 0;
		int finaltotal = 0;
		int i=0;
		try {
			con.setAutoCommit(false);
			pstmt=con.prepareStatement("UPDATE place_an_order SET warename=?, orderday=?, delivery_day=?, ecode=?, name=? where placecode=?");
			
			
			
			pstmt.setString(1, warename);
			pstmt.setString(2, orderday);
			pstmt.setString(3, deliveryday);
			pstmt.setString(4, ecode);
			pstmt.setString(5, ename);
			pstmt.setString(6, placecode);
			a=pstmt.executeUpdate();
		
			
			
			con.commit(); 	
			
		}catch (SQLException e) {
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			
		}
		if(a>=1) {
			success = true;
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return success;
	}
	public ArrayList<Order2> selectOrderList2() {
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<Order2> orderList = null;
	
		int i=0;
		
		System.out.println("수주서 리스트");	
		try {
			DecimalFormat df = new DecimalFormat("###,###");
		
			stmt = con.createStatement();
			rs = stmt.executeQuery("select orders.*,holding.acount from orders,holding where progress_status='재고확인' and orders.itemname=holding.itemname;");
			
			
			
			if(rs.next()){
				orderList = new ArrayList<Order2>();
				
				do {
					orderList.add(new Order2(
							rs.getString("ordercode")
							,rs.getString("clientname")
							,rs.getString("itemname")
							,rs.getString("orderday")
							,rs.getString("delivery_day")
							,df.format(rs.getInt("forwarding_price"))
							,rs.getInt("count")
							,df.format(rs.getInt("sv"))
							,df.format(rs.getInt("total_amount"))
							,rs.getString("ecode")
							,rs.getString("name")
							,rs.getString("progress_status")
							,rs.getInt("acount")
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
					System.out.println(rs.getString("ordercode"));	
					System.out.println(rs.getString("clientname"));
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(stmt);
		}
		
		return orderList;
	}
	public ArrayList<temp> getMRP(String itemname, String needholding) {
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2=null;
		int needhold = Integer.parseInt(needholding);
		ResultSet rs= null;
		ResultSet rs2= null;
		ArrayList<temp> tempList = null;
		int i=0;
		int a=0;
		System.out.println("mrp임시");	
		
		try {
			
		
			
			
			pstmt2 = con.prepareStatement("select count(*) from place_stock_temp");
			rs = pstmt2.executeQuery();
			if(rs.next()){//
			 a = rs.getInt("count(*)");
			
				}
			
			if(a==0) {
			pstmt2 = con.prepareStatement("insert into place_stock_temp values ('temp001',?,?,?,?)");
			pstmt = con.prepareStatement("select * from bom_stock where bom_code=(select bom_code from bom_product where itemname=?)");
			pstmt.setString(1, itemname);
			rs = pstmt.executeQuery();
			System.out.println(rs);	
			
			if(rs.next()){
			
				
				do {
					pstmt2.setString(1, rs.getString("itemcode"));
					pstmt2.setString(2, rs.getString("itemname"));
					pstmt2.setString(3, "겜성부품");
					pstmt2.setInt(4, (rs.getInt("materials")*needhold));
					a=pstmt2.executeUpdate();
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			}
			pstmt = con.prepareStatement("select * from place_stock_temp");
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				tempList = new ArrayList<temp>();
				
				do {tempList.add(new temp(
						rs.getString("tempcode")
						,rs.getString("itemcode")
						,rs.getString("itemname")
						,rs.getString("clientname")
						,rs.getInt("materials")
						));
					
				} while (rs.next());
				
			}
			con.commit(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
			close(pstmt2);
		}
		
		return tempList;
	}
	public Order2 selectOrderOne(String ordercode) {
		
		ResultSet rs= null;
		Order2 orderList = null;
		PreparedStatement pstmt=null;
		int i=0;
		
		System.out.println("수주 리스트");	
		try {
			DecimalFormat df = new DecimalFormat("###,###");
		
			
			
			pstmt = con.prepareStatement("select orders.*,holding.acount from orders,holding where progress_status='재고확인' and orders.itemname=holding.itemname and orders.ordercode=?");
			pstmt.setString(1, ordercode);
			rs = pstmt.executeQuery();
			
			
			if(rs.next()){
				
				
				do {
					orderList = new Order2(
							rs.getString("ordercode")
							,rs.getString("clientname")
							,rs.getString("itemname")
							,rs.getString("orderday")
							,rs.getString("delivery_day")
							,df.format(rs.getInt("forwarding_price"))
							,rs.getInt("count")
							,df.format(rs.getInt("sv"))
							,df.format(rs.getInt("total_amount"))
							,rs.getString("ecode")
							,rs.getString("name")
							,rs.getString("progress_status")
							,rs.getInt("acount")
							);
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
					System.out.println(rs.getInt("acount"));	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
		}
		
		return orderList;
	}
	public int getsv(String itemname,String needholding) {
		PreparedStatement pstmt=null;
		int needhold=0;
		int mrp = Integer.parseInt(needholding);
		ResultSet rs= null;
		int i=0;
		int a=0;
		System.out.println("mrp임시");	
		
		try {
			
		
			
		
		
			pstmt = con.prepareStatement("select item.itemname, item.receiving_price, place_stock_temp.materials from place_stock_temp,item where place_stock_temp.itemname=item.itemname");
			
			rs = pstmt.executeQuery();
			System.out.println(rs);	
			
			if(rs.next()){
			
				
				do {
					needhold = needhold + rs.getInt("Receiving_price") * rs.getInt("materials");
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
			
		}
		
		return needhold;
	}
	public temp selectMrpOne(String gettemp) {
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		temp temp = null;
		int i=0;
		
		
		try {
			
			
			pstmt = con.prepareStatement("select * from place_stock_temp where itemcode=?");
			pstmt.setString(1, gettemp);
			rs = pstmt.executeQuery();
			DecimalFormat df = new DecimalFormat("###,###");
			
			
			if(rs.next()){
				
				
				do {
					temp = new temp(
							rs.getString("tempcode")
							,rs.getString("itemcode")
							,rs.getString("itemname")
							,rs.getString("clientname")
							,rs.getInt("materials")
							);
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
		}
		
		return temp;
	}
	public boolean updateTemp(String itemcode, int materials, String clientname) {
		int a=0;
		boolean success = false;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		System.out.println("updateTemp ");
		System.out.println(itemcode);
		System.out.println(clientname);
		System.out.println(materials);
		int total = 0;
		int finaltotal = 0;
		int i=0;
		try {
			con.setAutoCommit(false);
			pstmt=con.prepareStatement("UPDATE place_stock_temp SET materials=?, clientname=? where itemcode=?");
			
			
			
			pstmt.setInt(1, materials);
			pstmt.setString(2, clientname);
			pstmt.setString(3, itemcode);
			
			a=pstmt.executeUpdate();
			System.out.println("update "+a);
			
		
			
			
			con.commit(); 	
			
		}catch (SQLException e) {
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			
		}
		if(a>=1) {
			success = true;
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return success;
	}
	public void resetmrp(){
		int a=0;
		boolean success = false;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		System.out.println("resetmrp ");
		
		int total = 0;
		int finaltotal = 0;
		int i=0;
		try {
			con.setAutoCommit(false);
			pstmt=con.prepareStatement("delete from place_stock_temp");
			
			
			
			
			a=pstmt.executeUpdate();
			System.out.println("update "+a);
			
		
			
			
			con.commit(); 	
			
		}catch (SQLException e) {
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			
		}
		if(a>=1) {
			success = true;
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return;
	}
	public boolean insertPo(String warename, String orderday,String delivery_day, int sv, int total_amount, String ecode, String ename,String ordercode) {
		int a=0;
		boolean success = false;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2=null;
		ResultSet rs = null;
		String quality = null;
		String placecode = null;
		String waringcode = null;
		int rowcount = 0;
		System.out.println("insertPo ");
		SimpleDateFormat sf = new SimpleDateFormat("MMdd");
		 LocalDate now = LocalDate.now();

	       
	     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMdd");

	   
	     String formatedNow = "22"+now.format(formatter);
	     
		
		try {
			con.setAutoCommit(false);
			
				pstmt2 = con.prepareStatement("select count(*) from place_an_order where placecode Like ?");
				pstmt2.setString(1, "%"+formatedNow+"%");
				rs = pstmt2.executeQuery();
				System.out.println("nowcode");
				if(rs.next()){//
				 rowcount = rs.getInt("count(*)");
				
					}
				rowcount++;
				DecimalFormat df = new DecimalFormat("000");
				
				placecode = "po-"+formatedNow+"-"+df.format(rowcount);	
				
			
		
			pstmt=con.prepareStatement("Insert into place_an_order Values (?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, placecode);
			pstmt.setString(2, warename);
			pstmt.setString(3, orderday);
			pstmt.setString(4, delivery_day);
			
			pstmt.setInt(5, sv);

			pstmt.setInt(6, total_amount);
			pstmt.setString(7, ecode);
			pstmt.setString(8, ename);
			pstmt.setString(9, "발주확인");
			pstmt.setString(10, ordercode);
			a=pstmt.executeUpdate();
			System.out.println("Insert "+a);
			
			pstmt = con.prepareStatement("select * from place_stock_temp");
			pstmt2 = con.prepareStatement("insert into place_stock values (?,?,?,?,?)");
			
			rs = pstmt.executeQuery();
			System.out.println(rs);	
			
			if(rs.next()){
			
				
				do {
					pstmt2.setString(1, placecode);
					pstmt2.setString(2, rs.getString("itemcode"));
					pstmt2.setString(3, rs.getString("itemname"));
					pstmt2.setString(4, rs.getString("clientname"));
					pstmt2.setInt(5, rs.getInt("materials"));
					a=pstmt2.executeUpdate();
					
					System.out.println("번쨰 레코드");	
				} while (rs.next());
				
			}
			
			pstmt2 = con.prepareStatement("select count(*) from Warehousing where waringcode Like ?");
			pstmt2.setString(1, "%"+formatedNow+"%");
			rs = pstmt2.executeQuery();
			System.out.println("nowcode");
			if(rs.next()){//
			 rowcount = rs.getInt("count(*)");
			
				}
			rowcount++;
			
			
			waringcode = "wi-"+formatedNow+"-"+df.format(rowcount);	
			
			pstmt=con.prepareStatement("Insert into Warehousing Values (?,?,?,?,?)");
			pstmt.setString(1, waringcode);
			pstmt.setString(2, placecode);
			pstmt.setString(3, warename);
			pstmt.setString(4, orderday);
			pstmt.setString(5, "진행중");
			
			a=pstmt.executeUpdate();
			System.out.println("Insert "+a);
			
			pstmt = con.prepareStatement("select * from place_stock where placecode=?");
			pstmt.setString(1, placecode);
			pstmt2 = con.prepareStatement("insert into warehousing_stock values (?,?,?,?,?,?,?,?,?)");
			
			rs = pstmt.executeQuery();
			System.out.println(rs);	
			
			if(rs.next()){
			
				
				do {
					pstmt2.setString(1, waringcode);
					pstmt2.setString(2, rs.getString("itemcode"));
					pstmt2.setString(3, rs.getString("itemname"));
					pstmt2.setInt(4, rs.getInt("materials"));
					pstmt2.setInt(5, rs.getInt("materials"));
					pstmt2.setInt(6, 0);
					pstmt2.setInt(7, 0);
					pstmt2.setInt(8, 0);
					pstmt2.setInt(9, 0);
					a=pstmt2.executeUpdate();
					
					System.out.println("번쨰 레코드");	
				} while (rs.next());
				
			}
			pstmt = con.prepareStatement("update orders set Progress_status='발주신청' where ordercode=?");
			pstmt.setString(1, ordercode);
			a=pstmt.executeUpdate();
			con.commit(); 	
			
		}catch (SQLException e) {
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			close(pstmt2);
			close(rs);
		}
		if(a>=1) {
			success = true;
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return success;
	}
	public boolean insertPost(String ordercode,String warename, String tempname,String defectname) {
		int a=0;
		boolean success = false;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2=null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		String quality = null;
		String placecode = null;
		String waringcode = null;
		String itemname = null;
		String itemcode = null;
		int receiving=0;
		int rowcount = 0;
		System.out.println("insertPost ");
		
	     
		
		try {
			con.setAutoCommit(false);
			pstmt = con.prepareStatement("select placecode from place_an_order where ordercode=?");
			pstmt.setString(1, ordercode);
			rs = pstmt.executeQuery();
			System.out.println("nowcode");
			if(rs.next()){//
			 placecode = rs.getString("placecode");
			
				}
			
			
		
			pstmt=con.prepareStatement("Insert into place_an_order_warehouse Values (?,?,?,?)");
			pstmt.setString(1, placecode);
			pstmt.setString(2, warename);
			pstmt.setString(3, tempname);
			pstmt.setString(4, defectname);
			
			
			a=pstmt.executeUpdate();
			System.out.println("Insert "+a);
			pstmt = con.prepareStatement("select itemname from place_stock where placecode=?");
			pstmt.setString(1, placecode);
			rs = pstmt.executeQuery();
			
			if(rs.next()){//
				
			do {
					
				
			 itemname = rs.getString("itemname");
			 	pstmt2 = con.prepareStatement("select count(*) from holding where warename=? and itemname=?");
			 	pstmt2.setString(1, warename);
				pstmt2.setString(2, itemname);
				rs2 = pstmt2.executeQuery();
					if(rs2.next()){
						rowcount = rs2.getInt("count(*)");
					}
					if(rowcount==0) {
						pstmt2 = con.prepareStatement("select itemcode, receiving_price from item where itemname=?");
						pstmt2.setString(1, itemname);
						rs2 = pstmt2.executeQuery();
						if(rs2.next()){
							itemcode = rs2.getString("itemcode");
							receiving = rs2.getInt("receiving_price");
						}
						pstmt2=con.prepareStatement("Insert into holding Values (?,?,?,now(),?,0)");
						pstmt2.setString(1, itemcode);
						pstmt2.setString(2, itemname);
						pstmt2.setString(3, warename);
						pstmt2.setInt(4, receiving);
						a=pstmt2.executeUpdate();
					}
					
					pstmt2 = con.prepareStatement("select count(*) from holding where warename=? and itemname=?");
				 	pstmt2.setString(1, tempname);
					pstmt2.setString(2, itemname);
					rs2 = pstmt2.executeQuery();
						if(rs2.next()){
							rowcount = rs2.getInt("count(*)");
						}
						if(rowcount==0) {
							pstmt2 = con.prepareStatement("select itemcode, receiving_price from item where itemname=?");
							pstmt2.setString(1, itemname);
							rs2 = pstmt2.executeQuery();
							if(rs2.next()){
								itemcode = rs2.getString("itemcode");
								receiving = rs2.getInt("receiving_price");
							}
							pstmt2=con.prepareStatement("Insert into holding Values (?,?,?,now(),?,0)");
							pstmt2.setString(1, itemcode);
							pstmt2.setString(2, itemname);
							pstmt2.setString(3, tempname);
							pstmt2.setInt(4, receiving);
							a=pstmt2.executeUpdate();
						}
						
						pstmt2 = con.prepareStatement("select count(*) from holding where warename=? and itemname=?");
					 	pstmt2.setString(1, defectname);
						pstmt2.setString(2, itemname);
						rs2 = pstmt2.executeQuery();
							if(rs2.next()){
								rowcount = rs2.getInt("count(*)");
							}
							if(rowcount==0) {
								pstmt2 = con.prepareStatement("select itemcode, receiving_price from item where itemname=?");
								pstmt2.setString(1, itemname);
								rs2 = pstmt2.executeQuery();
								if(rs2.next()){
									itemcode = rs2.getString("itemcode");
									receiving = rs2.getInt("receiving_price");
								}
								pstmt2=con.prepareStatement("Insert into holding Values (?,?,?,now(),?,0)");
								pstmt2.setString(1, itemcode);
								pstmt2.setString(2, itemname);
								pstmt2.setString(3, defectname);
								pstmt2.setInt(4, receiving);
								a=pstmt2.executeUpdate();
							}	
				 } while (rs.next());
				}
			
			
			
			
		
			con.commit(); 	
			
		}catch (SQLException e) {
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			close(pstmt2);
			close(rs);
			close(rs2);
		}
		if(a>=1) {
			success = true;
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return success;
	}
	public boolean updatePost(String placecode,String warename, String tempname,String defectname) {
		int a=0;
		boolean success = false;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2=null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		String quality = null;
	
		String waringcode = null;
		String itemname = null;
		String itemcode = null;
		int receiving=0;
		int rowcount = 0;
		System.out.println("insertPost ");
		
	     
		
		try {
			con.setAutoCommit(false);
			
			
			
		
			pstmt=con.prepareStatement("update place_an_order_warehouse set warename=?, tempname=?, defectname=? where placecode=?");
			pstmt.setString(1, warename);
			pstmt.setString(2, tempname);
			pstmt.setString(3, defectname);
			pstmt.setString(4, placecode);
			
			
			a=pstmt.executeUpdate();
			
			pstmt=con.prepareStatement("update warehousing set warename=? where placecode=?");
			pstmt.setString(1, warename);
			pstmt.setString(2, placecode);
			
			
			
			a=pstmt.executeUpdate();
			System.out.println("Insert "+a);
			
			pstmt = con.prepareStatement("select itemname from place_stock where placecode=?");
			pstmt.setString(1, placecode);
			rs = pstmt.executeQuery();
			
			if(rs.next()){//
				
			do {
					
				
			 itemname = rs.getString("itemname");
			 	pstmt2 = con.prepareStatement("select count(*) from holding where warename=? and itemname=?");
			 	pstmt2.setString(1, warename);
				pstmt2.setString(2, itemname);
				rs2 = pstmt2.executeQuery();
					if(rs2.next()){
						rowcount = rs2.getInt("count(*)");
					}
					if(rowcount==0) {
						pstmt2 = con.prepareStatement("select itemcode, receiving_price from item where itemname=?");
						pstmt2.setString(1, itemname);
						rs2 = pstmt2.executeQuery();
						if(rs2.next()){
							itemcode = rs2.getString("itemcode");
							receiving = rs2.getInt("receiving_price");
						}
						pstmt2=con.prepareStatement("Insert into holding Values (?,?,?,now(),?,0)");
						pstmt2.setString(1, itemcode);
						pstmt2.setString(2, itemname);
						pstmt2.setString(3, warename);
						pstmt2.setInt(4, receiving);
						a=pstmt2.executeUpdate();
					}
					
					pstmt2 = con.prepareStatement("select count(*) from holding where warename=? and itemname=?");
				 	pstmt2.setString(1, tempname);
					pstmt2.setString(2, itemname);
					rs2 = pstmt2.executeQuery();
						if(rs2.next()){
							rowcount = rs2.getInt("count(*)");
						}
						if(rowcount==0) {
							pstmt2 = con.prepareStatement("select itemcode, receiving_price from item where itemname=?");
							pstmt2.setString(1, itemname);
							rs2 = pstmt2.executeQuery();
							if(rs2.next()){
								itemcode = rs2.getString("itemcode");
								receiving = rs2.getInt("receiving_price");
							}
							pstmt2=con.prepareStatement("Insert into holding Values (?,?,?,now(),?,0)");
							pstmt2.setString(1, itemcode);
							pstmt2.setString(2, itemname);
							pstmt2.setString(3, tempname);
							pstmt2.setInt(4, receiving);
							a=pstmt2.executeUpdate();
						}
						
						pstmt2 = con.prepareStatement("select count(*) from holding where warename=? and itemname=?");
					 	pstmt2.setString(1, defectname);
						pstmt2.setString(2, itemname);
						rs2 = pstmt2.executeQuery();
							if(rs2.next()){
								rowcount = rs2.getInt("count(*)");
							}
							if(rowcount==0) {
								pstmt2 = con.prepareStatement("select itemcode, receiving_price from item where itemname=?");
								pstmt2.setString(1, itemname);
								rs2 = pstmt2.executeQuery();
								if(rs2.next()){
									itemcode = rs2.getString("itemcode");
									receiving = rs2.getInt("receiving_price");
								}
								pstmt2=con.prepareStatement("Insert into holding Values (?,?,?,now(),?,0)");
								pstmt2.setString(1, itemcode);
								pstmt2.setString(2, itemname);
								pstmt2.setString(3, defectname);
								pstmt2.setInt(4, receiving);
								a=pstmt2.executeUpdate();
							}	
				 } while (rs.next());
				}
			
			
			
			
		
			con.commit(); 	
			
		}catch (SQLException e) {
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			close(pstmt2);
			close(rs);
			close(rs2);
		}
		if(a>=1) {
			success = true;
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return success;
	}
	public ArrayList<wh> selectWhList() {
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<wh> whList = null;
		int i=0;
		
		System.out.println("입고 리스트");	
		try {
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM warehousing");
			
			
			
			if(rs.next()){
				whList = new ArrayList<wh>();
				
				do {
					whList.add(new wh(
							rs.getString("waringcode")
							,rs.getString("placecode")
							,rs.getString("warename")
							,rs.getString("wareday")	
							,rs.getString("progress_status")
							
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(stmt);
		}
		
		return whList;
	}
	public ArrayList<whs> selectWhStockList(String selectwhStock) {
		PreparedStatement pstmt=null;
		
		ResultSet rs= null;
		ArrayList<whs> whsList = null;
		int i=0;
		
		System.out.println("입고품목 리스트");	
		
		try {
			
			pstmt = con.prepareStatement("select * from warehousing_stock where waringcode=?;");
			pstmt.setString(1, selectwhStock);
			rs = pstmt.executeQuery();
			System.out.println(rs);	
			
			if(rs.next()){
				whsList = new ArrayList<whs>();
				System.out.println("입고품목객체");
				do {
					whsList.add(new whs(
							rs.getString("waringcode")
							,rs.getString("itemcode")
							,rs.getString("itemname")
							,rs.getInt("count")
							,rs.getInt("uncount")
							,rs.getInt("refundcount")
							,rs.getInt("Temporary_count")
							,rs.getInt("warecount")
							,rs.getInt("Defective_count")
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
		}
		
		return whsList;
	}
	public wh selectWhOne(String getwh) {
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		wh whList = null;
		int i=0;
		
		System.out.println("입고 ");	
		try {
			
			
			pstmt = con.prepareStatement("select * from warehousing where waringcode=?");
			pstmt.setString(1, getwh);
			rs = pstmt.executeQuery();
			DecimalFormat df = new DecimalFormat("###,###");
			
			
			if(rs.next()){
				
				
				do {
					whList = new wh(
							rs.getString("waringcode")
							,rs.getString("placecode")
							,rs.getString("warename")
							,rs.getString("wareday")	
							,rs.getString("progress_status")
							
							);
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
		}
		
		return whList;
	}
	public whs selectWhStockOne(String getwh, String waringcode) {
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		whs whList = null;
		int i=0;
		

		try {
			
			
			pstmt = con.prepareStatement("select * from warehousing_stock where itemcode=? and waringcode=? ");
			pstmt.setString(1, getwh);
			pstmt.setString(2, waringcode);
			rs = pstmt.executeQuery();
			DecimalFormat df = new DecimalFormat("###,###");
			
			
			if(rs.next()){
				
				
				do {
					whList = new whs(
							rs.getString("waringcode")
							,rs.getString("itemcode")
							,rs.getString("itemname")
							,rs.getInt("count")
							,rs.getInt("uncount")
							,rs.getInt("refundcount")
							,rs.getInt("Temporary_count")
							,rs.getInt("warecount")
							,rs.getInt("Defective_count")
							);
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
		}
		
		return whList;
	}
	public int getMax(String getwh, String waringcode) {
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		int sv=0;
		int i=0;
		

		try {
			
			
			pstmt = con.prepareStatement("select Temporary_count from warehousing_stock where itemcode=? and waringcode=? ");
			pstmt.setString(1, getwh);
			pstmt.setString(2, waringcode);
			rs = pstmt.executeQuery();
			DecimalFormat df = new DecimalFormat("###,###");
			
			
			if(rs.next()){
				
				
				do {
					sv= rs.getInt("Temporary_count");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
		}
		
		return sv;
	}
	public int getMax2(String getwh, String waringcode) {
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		int sv=0;
		int sv2=0;
		int i=0;
		

		try {
			
			
			pstmt = con.prepareStatement("select uncount from warehousing_stock where itemcode=? and waringcode=? ");
			pstmt.setString(1, getwh);
			pstmt.setString(2, waringcode);
			rs = pstmt.executeQuery();
		
			
			
			if(rs.next()){
				
				
				do {
					sv= rs.getInt("uncount");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
		}
	
		return sv;
	}
	public int getMax3(String getwh, String waringcode) {
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		int sv=0;
		int sv2=0;
		int i=0;
		

		try {
			
			
			pstmt = con.prepareStatement("select Defective_count from warehousing_stock where itemcode=? and waringcode=? ");
			pstmt.setString(1, getwh);
			pstmt.setString(2, waringcode);
			rs = pstmt.executeQuery();
		
			
			
			if(rs.next()){
				
				
				do {
					sv= rs.getInt("Defective_count");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
		}
	
		return sv;
	}
	public int getMax4(String getwh, String waringcode) {
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		int sv=0;
		int sv2=0;
		int i=0;
		

		try {
			
			
			pstmt = con.prepareStatement("select refundcount from warehousing_stock where itemcode=? and waringcode=? ");
			pstmt.setString(1, getwh);
			pstmt.setString(2, waringcode);
			rs = pstmt.executeQuery();
		
			
			
			if(rs.next()){
				
				
				do {
					sv= rs.getInt("refundcount");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
		}
	
		return sv;
	}
	public boolean updateWhStock(String waringcode, String itemcode,int warecount, int Defective_count) {
		int a=0;
		boolean success = false;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt3=null;
		ResultSet rs= null;
		System.out.println("updatepostock ");
		int temp = 0;
		int finaltotal = 0;
		int nowcount = 0;
		int nowcount2 = 0;
		int nowcount3 = 0;
		int i=0;
		int complete = 0;
		int rowcount = 0;
		int rowcount2 = 0;
		String warename = null;
		String defectname = null;
		String itemname = null;
		String tempname = null;
		String clientname = null;
		String placecode= null;
		try {
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement("select Temporary_count from warehousing_stock where itemcode=? and waringcode=? ");
			pstmt.setString(1, itemcode);
			pstmt.setString(2, waringcode);
			rs = pstmt.executeQuery();
			DecimalFormat df = new DecimalFormat("###,###");
			
			
			if(rs.next()){
				
				
				do {
					temp= rs.getInt("Temporary_count");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
			
			if(temp < warecount + Defective_count) {
				return success;
			}
			if(warecount < 0 || Defective_count < 0) {
				return success;
			}
			if(warecount + Defective_count == 0) {
				return success;
			}
			pstmt=con.prepareStatement("UPDATE warehousing_stock SET warecount=warecount+?, Defective_count=Defective_count+?,Temporary_count=Temporary_count-? where waringcode=? and itemcode=?");
			
			
			
			pstmt.setInt(1, warecount);
			pstmt.setInt(2, Defective_count);
			pstmt.setInt(3, warecount+Defective_count);
			pstmt.setString(4, waringcode);
			pstmt.setString(5, itemcode);
			a=pstmt.executeUpdate();
			System.out.println("update "+a);
			
			pstmt3=con.prepareStatement("select warename from place_an_order_warehouse where placecode=(Select placecode from warehousing where waringcode=?)");
			pstmt3.setString(1, waringcode);
			rs = pstmt3.executeQuery();
			if(rs.next()){

			
					warename= rs.getString("warename");					
				
				
			}
			pstmt3=con.prepareStatement("select defectname from place_an_order_warehouse where placecode=(Select placecode from warehousing where waringcode=?)");
			pstmt3.setString(1, waringcode);
			rs = pstmt3.executeQuery();
			if(rs.next()){

			
					defectname= rs.getString("defectname");					
				
				
			}
			pstmt3=con.prepareStatement("select tempname from place_an_order_warehouse where placecode=(Select placecode from warehousing where waringcode=?)");
			pstmt3.setString(1, waringcode);
			rs = pstmt3.executeQuery();
			if(rs.next()){

			
					tempname= rs.getString("tempname");					
				
				
			}
			pstmt=con.prepareStatement("select acount from holding where itemcode=? and warename=?");
			pstmt.setString(1, itemcode);
			pstmt.setString(2, warename);
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				
				do {
					nowcount= rs.getInt("acount");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			pstmt=con.prepareStatement("select acount from holding where itemcode=? and warename=?");
			pstmt.setString(1, itemcode);
			pstmt.setString(2, defectname);
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				
				do {
					nowcount2= rs.getInt("acount");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			pstmt=con.prepareStatement("select acount from holding where itemcode=? and warename=?");
			pstmt.setString(1, itemcode);
			pstmt.setString(2, tempname);
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				
				do {
					nowcount3= rs.getInt("acount");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			pstmt=con.prepareStatement("select placecode from warehousing where waringcode=?");
			pstmt.setString(1, waringcode);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				
				do {
					placecode= rs.getString("placecode");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			pstmt=con.prepareStatement("select clientname from place_stock where itemcode=? and placecode=?");
			pstmt.setString(1, itemcode);
			pstmt.setString(2, placecode);
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				
				do {
					clientname= rs.getString("clientname");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			pstmt=con.prepareStatement("select itemname from item where itemcode=?");
			pstmt.setString(1, itemcode);
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				
				do {
					itemname= rs.getString("itemname");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}	
			if(warecount >= 1) {
			pstmt=con.prepareStatement("Insert Into holding_log Values (?,?,?,?,?,NOW(),?,?,'입고')");
			pstmt.setString(1, waringcode);
			pstmt.setString(2, itemcode);
			pstmt.setString(3, itemname);
			pstmt.setString(4, clientname);
			pstmt.setString(5, warename);
			pstmt.setInt(6, warecount);
			pstmt.setInt(7, nowcount+warecount);
			a=pstmt.executeUpdate();
		
			pstmt=con.prepareStatement("UPDATE holding SET acount=acount+? where itemcode=? and warename=?");
			pstmt.setInt(1, warecount);
			pstmt.setString(2, itemcode);
			pstmt.setString(3, warename);
			a=pstmt.executeUpdate();
			}
			if(Defective_count >= 1) {
			pstmt=con.prepareStatement("Insert Into holding_log Values (?,?,?,?,?,NOW(),?,?,'입고')");
			pstmt.setString(1, waringcode);
			pstmt.setString(2, itemcode);
			pstmt.setString(3, itemname);
			pstmt.setString(4, clientname);
			pstmt.setString(5, defectname);
			pstmt.setInt(6, Defective_count);
			pstmt.setInt(7, nowcount2+Defective_count);
			a=pstmt.executeUpdate();
			
			pstmt=con.prepareStatement("UPDATE holding SET acount=acount+? where itemcode=? and warename=?");
			pstmt.setInt(1, Defective_count);
			pstmt.setString(2, itemcode);
			pstmt.setString(3, defectname);
			a=pstmt.executeUpdate();
			}
			pstmt=con.prepareStatement("Insert Into holding_log Values (?,?,?,?,?,NOW(),?,?,'출고')");
			pstmt.setString(1, waringcode);
			pstmt.setString(2, itemcode);
			pstmt.setString(3, itemname);
			pstmt.setString(4, clientname);
			pstmt.setString(5, tempname);
			pstmt.setInt(6, (Defective_count+warecount)*-1);
			pstmt.setInt(7, nowcount3-(Defective_count+warecount));
			a=pstmt.executeUpdate();
			
			pstmt=con.prepareStatement("UPDATE holding SET acount=acount-? where itemcode=? and warename=?");
			pstmt.setInt(1, Defective_count+warecount);
			pstmt.setString(2, itemcode);
			pstmt.setString(3, tempname);
			a=pstmt.executeUpdate();
			
			pstmt=con.prepareStatement("UPDATE warehousing SET wareday=NOW() where waringcode=?");
			pstmt.setString(1, waringcode);
			a=pstmt.executeUpdate();
			
			
			pstmt=con.prepareStatement("select count(*) from warehousing_stock where waringcode=?");
			pstmt.setString(1, waringcode);
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				
				do {
					rowcount= rs.getInt("count(*)");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}	
			pstmt=con.prepareStatement("select count(*) from warehousing_stock where waringcode=? and warecount=count");
			pstmt.setString(1, waringcode);
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				
				do {
					rowcount2= rs.getInt("count(*)");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}	
			if(rowcount == rowcount2) {
				pstmt=con.prepareStatement("UPDATE warehousing SET Progress_status='입고완료' where waringcode=?");
				pstmt.setString(1, waringcode);
				a=pstmt.executeUpdate();
				pstmt=con.prepareStatement("UPDATE place_an_order SET Progress_status='입고완료' where placecode=(Select placecode from warehousing where waringcode=?)");
				pstmt.setString(1, waringcode);
				a=pstmt.executeUpdate();
				pstmt=con.prepareStatement("UPDATE orders SET Progress_status='입고완료' where ordercode=(Select ordercode from place_an_order where placecode=(Select placecode from warehousing where waringcode=?))");
				pstmt.setString(1, waringcode);
				a=pstmt.executeUpdate();
			}
			con.commit(); 	
			
		}catch (SQLException e) {
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			
		}
		if(a>=1) {
			success = true;
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return success;
	}
	public boolean updateWhTempStock(String waringcode, String itemcode,int count) {
		int a=0;
		boolean success = false;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt3=null;
		ResultSet rs= null;
		System.out.println("updatepostock ");
		int temp = 0;
		int ordercount = 0;
		int finaltotal = 0;
		int nowcount = 0;
		int nowcount2 = 0;
		int i=0;
		int complete = 0;
		String itemname = null;
		String warename = null;
		String defectname = null;
		
		String tempname = null;
		String clientname = null;
		String placecode= null;
		try {
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement("select uncount from warehousing_stock where itemcode=? and waringcode=? ");
			pstmt.setString(1, itemcode);
			pstmt.setString(2, waringcode);
			rs = pstmt.executeQuery();
			DecimalFormat df = new DecimalFormat("###,###");
			
			
			if(rs.next()){
				
				
				do {
					temp= rs.getInt("uncount");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
			
			if(temp < count) {
				return success;
			}
			if(count <= 0) {
				return success;
			}
			
			pstmt=con.prepareStatement("UPDATE warehousing_stock SET uncount=uncount-?,Temporary_count=Temporary_count+? where waringcode=? and itemcode=?");
			
			
			
			pstmt.setInt(1, count);
			pstmt.setInt(2, count);
			pstmt.setString(3, waringcode);
			pstmt.setString(4, itemcode);
			a=pstmt.executeUpdate();
			System.out.println("update "+a);
			
			pstmt3=con.prepareStatement("select tempname from place_an_order_warehouse where placecode=(Select placecode from warehousing where waringcode=?)");
			pstmt3.setString(1, waringcode);
			rs = pstmt3.executeQuery();
			if(rs.next()){

			
					tempname= rs.getString("tempname");					
				
				
			}
			
			
			
			
			pstmt=con.prepareStatement("select acount from holding where itemcode=? and warename=?");
			pstmt.setString(1, itemcode);
			pstmt.setString(2, tempname);
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				
				do {
					nowcount= rs.getInt("acount");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
			
			pstmt=con.prepareStatement("select placecode from warehousing where waringcode=?");
			pstmt.setString(1, waringcode);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				
				do {
					placecode= rs.getString("placecode");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			pstmt=con.prepareStatement("select clientname from place_stock where itemcode=? and placecode=?");
			pstmt.setString(1, itemcode);
			pstmt.setString(2, placecode);
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				
				do {
					clientname= rs.getString("clientname");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
			
			pstmt=con.prepareStatement("select itemname from item where itemcode=?");
			pstmt.setString(1, itemcode);
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				
				do {
					itemname= rs.getString("itemname");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}	
			pstmt=con.prepareStatement("Insert Into holding_log Values (?,?,?,?,?,NOW(),?,?,'입고')");
			pstmt.setString(1, waringcode);
			pstmt.setString(2, itemcode);
			pstmt.setString(3, itemname);
			pstmt.setString(4, clientname);
			pstmt.setString(5, tempname);
			pstmt.setInt(6, count);
			pstmt.setInt(7, nowcount+count);
			a=pstmt.executeUpdate();
		
			pstmt=con.prepareStatement("UPDATE holding SET acount=acount+? where itemcode=? and warename=?");
			pstmt.setInt(1, count);
			pstmt.setString(2, itemcode);
			pstmt.setString(3, tempname);
			a=pstmt.executeUpdate();
			
			
			
			pstmt=con.prepareStatement("UPDATE warehousing SET wareday=NOW() where waringcode=?");
			pstmt.setString(1, waringcode);
			a=pstmt.executeUpdate();
			
			con.commit(); 	
			
		}catch (SQLException e) {
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			
		}
		if(a>=1) {
			success = true;
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return success;
	}
	public boolean updateWhRefundTempStock(String waringcode, String itemcode,int count) {
		int a=0;
		boolean success = false;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt3=null;
		ResultSet rs= null;
		System.out.println(" ");
		int temp = 0;
		int ordercount = 0;
		int finaltotal = 0;
		int nowcount = 0;
		int nowcount2 = 0;
		int i=0;
		int complete = 0;
		String itemname = null;
		String warename = null;
		String defectname = null;
		
		String tempname = null;
		String clientname = null;
		String placecode= null;
		try {
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement("select refundcount from warehousing_stock where itemcode=? and waringcode=? ");
			pstmt.setString(1, itemcode);
			pstmt.setString(2, waringcode);
			rs = pstmt.executeQuery();
			DecimalFormat df = new DecimalFormat("###,###");
			
			
			if(rs.next()){
				
				
				do {
					temp= rs.getInt("refundcount");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
			
			if(temp < count) {
				return success;
			}
			if(count <= 0) {
				return success;
			}
			
			pstmt=con.prepareStatement("UPDATE warehousing_stock SET refundcount=refundcount-?,Temporary_count=Temporary_count+? where waringcode=? and itemcode=?");
			
			
			
			pstmt.setInt(1, count);
			pstmt.setInt(2, count);
			pstmt.setString(3, waringcode);
			pstmt.setString(4, itemcode);
			a=pstmt.executeUpdate();
			System.out.println("update "+a);
			
			pstmt3=con.prepareStatement("select tempname from place_an_order_warehouse where placecode=(Select placecode from warehousing where waringcode=?)");
			pstmt3.setString(1, waringcode);
			rs = pstmt3.executeQuery();
			if(rs.next()){

			
					tempname= rs.getString("tempname");					
				
				
			}
			
			
			
			
			pstmt=con.prepareStatement("select acount from holding where itemcode=? and warename=?");
			pstmt.setString(1, itemcode);
			pstmt.setString(2, tempname);
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				
				do {
					nowcount= rs.getInt("acount");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
			
			pstmt=con.prepareStatement("select placecode from warehousing where waringcode=?");
			pstmt.setString(1, waringcode);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				
				do {
					placecode= rs.getString("placecode");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			pstmt=con.prepareStatement("select clientname from place_stock where itemcode=? and placecode=?");
			pstmt.setString(1, itemcode);
			pstmt.setString(2, placecode);
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				
				do {
					clientname= rs.getString("clientname");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
			
			pstmt=con.prepareStatement("select itemname from item where itemcode=?");
			pstmt.setString(1, itemcode);
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				
				do {
					itemname= rs.getString("itemname");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}	
			pstmt=con.prepareStatement("Insert Into holding_log Values (?,?,?,?,?,NOW(),?,?,'입고')");
			pstmt.setString(1, waringcode);
			pstmt.setString(2, itemcode);
			pstmt.setString(3, itemname);
			pstmt.setString(4, clientname);
			pstmt.setString(5, tempname);
			pstmt.setInt(6, count);
			pstmt.setInt(7, nowcount+count);
			a=pstmt.executeUpdate();
		
			pstmt=con.prepareStatement("UPDATE holding SET acount=acount+? where itemcode=? and warename=?");
			pstmt.setInt(1, count);
			pstmt.setString(2, itemcode);
			pstmt.setString(3, tempname);
			a=pstmt.executeUpdate();
			
			
			
			pstmt=con.prepareStatement("UPDATE warehousing SET wareday=NOW() where waringcode=?");
			pstmt.setString(1, waringcode);
			a=pstmt.executeUpdate();
			
			con.commit(); 	
			
		}catch (SQLException e) {
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			
		}
		if(a>=1) {
			success = true;
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return success;
	}
	public boolean updateWhRefundStock(String waringcode, String itemcode,int count) {
		int a=0;
		boolean success = false;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt3=null;
		ResultSet rs= null;
		System.out.println("updatepostock ");
		int temp = 0;
		int ordercount = 0;
		int finaltotal = 0;
		int nowcount = 0;
		int nowcount2 = 0;
		int i=0;
		int complete = 0;
		String placecode = null;
		String clientname = null;
		String defectname = null;
		String itemname = null;
		try {
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement("select Defective_count from warehousing_stock where itemcode=? and waringcode=? ");
			pstmt.setString(1, itemcode);
			pstmt.setString(2, waringcode);
			rs = pstmt.executeQuery();
			DecimalFormat df = new DecimalFormat("###,###");
			
			
			if(rs.next()){
				
				
				do {
					temp= rs.getInt("Defective_count");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
			
			if(temp < count) {
				return success;
			}
			if(count <= 0) {
				return success;
			}
			
			pstmt=con.prepareStatement("UPDATE warehousing_stock SET Defective_count=Defective_count-?,refundcount=refundcount+? where waringcode=? and itemcode=?");
			
			
			
			pstmt.setInt(1, count);
			pstmt.setInt(2, count);
			pstmt.setString(3, waringcode);
			pstmt.setString(4, itemcode);
			a=pstmt.executeUpdate();
			System.out.println("update "+a);
			
			pstmt3=con.prepareStatement("select defectname from place_an_order_warehouse where placecode=(Select placecode from warehousing where waringcode=?)");
			pstmt3.setString(1, waringcode);
			rs = pstmt3.executeQuery();
			if(rs.next()){

			
					defectname= rs.getString("defectname");					
				
				
			}
			
			
			pstmt=con.prepareStatement("select acount from holding where itemcode=? and warename=?");
			pstmt.setString(1, itemcode);
			pstmt.setString(2, defectname);
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				
				do {
					nowcount= rs.getInt("acount");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
			
			pstmt=con.prepareStatement("select itemname from item where itemcode=?");
			pstmt.setString(1, itemcode);
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				
				do {
					itemname= rs.getString("itemname");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			pstmt=con.prepareStatement("select placecode from warehousing where waringcode=?");
			pstmt.setString(1, waringcode);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				
				do {
					placecode= rs.getString("placecode");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
			pstmt=con.prepareStatement("select clientname from place_stock where itemcode=? and placecode=?");
			pstmt.setString(1, itemcode);
			pstmt.setString(2, placecode);
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				
				do {
					clientname= rs.getString("clientname");
						
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
			
			
			pstmt=con.prepareStatement("Insert Into holding_log Values (?,?,?,?,?,NOW(),?,?,'반품')");
			pstmt.setString(1, waringcode);
			pstmt.setString(2, itemcode);
			pstmt.setString(3, itemname);
			pstmt.setString(4, clientname);
			pstmt.setString(5, defectname);
			pstmt.setInt(6, count*-1);
			pstmt.setInt(7, nowcount-count);
			a=pstmt.executeUpdate();
			
			
			pstmt=con.prepareStatement("UPDATE holding SET acount=acount-? where itemcode=? and warename=?");
			pstmt.setInt(1, count);
			pstmt.setString(2, itemcode);
			pstmt.setString(3, defectname);
			a=pstmt.executeUpdate();
			
			
			
			pstmt=con.prepareStatement("UPDATE warehousing SET wareday=NOW() where waringcode=?");
			pstmt.setString(1, waringcode);
			a=pstmt.executeUpdate();
			
			con.commit(); 	
			
		}catch (SQLException e) {
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			
		}
		if(a>=1) {
			success = true;
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return success;
	}
	public boolean checkorder(String updateordercode) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String updateorder = null;
		boolean success= false;
		try {
			DecimalFormat df = new DecimalFormat("###,###");
		
			System.out.println(updateordercode);
			pstmt = con.prepareStatement("SELECT * FROM orders where ordercode=?");
			pstmt.setString(1, updateordercode);
			rs = pstmt.executeQuery();
			System.out.println("updateordercode");
			if(rs.next()){//
				 updateorder =rs.getString("ordercode");
							
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		if(updateorder.equals("재고확인")) {
			success = true;
		}
		return success;
	}
	public ArrayList<St> selectStList() {
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<St> stList = null;
		int i=0;
		DecimalFormat df = new DecimalFormat("###,###");
		
		System.out.println("창고 리스트");	
		try {
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM warehouse");
			
			
			
			if(rs.next()){
				stList = new ArrayList<St>();
				
				do {
					stList.add(new St(
							rs.getString("warecode")
							,rs.getString("warename")
							,rs.getString("usecheck")
							,rs.getString("warelike")
							,rs.getString("waresearch")
							
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(stmt);
		}
		
		return stList;
	}
	public ArrayList<St> selectStList2() {
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<St> stList = null;
		int i=0;
		DecimalFormat df = new DecimalFormat("###,###");
		
		System.out.println("창고 리스트");	
		try {
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM warehouse where usecheck='사용'");
			
			
			
			if(rs.next()){
				stList = new ArrayList<St>();
				
				do {
					stList.add(new St(
							rs.getString("warecode")
							,rs.getString("warename")
							,rs.getString("usecheck")
							,rs.getString("warelike")
							,rs.getString("waresearch")
							
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(stmt);
		}
		
		return stList;
	}
	public ArrayList<St> selectStList3() {
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<St> stList = null;
		int i=0;
		DecimalFormat df = new DecimalFormat("###,###");
		
		System.out.println("창고 리스트");	
		try {
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from warehouse where warelike IN ('제품','부품') and usecheck='사용'");
			
			
			
			if(rs.next()){
				stList = new ArrayList<St>();
				
				do {
					stList.add(new St(
							rs.getString("warecode")
							,rs.getString("warename")
							,rs.getString("usecheck")
							,rs.getString("warelike")
							,rs.getString("waresearch")
							
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(stmt);
		}
		
		return stList;
	}
	public ArrayList<St> selectStListStock() {
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<St> stList = null;
		int i=0;
		DecimalFormat df = new DecimalFormat("###,###");
		
		System.out.println("창고 리스트");	
		try {
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from warehouse where warelike IN ('부품') and usecheck='사용'");
			
			
			
			if(rs.next()){
				stList = new ArrayList<St>();
				
				do {
					stList.add(new St(
							rs.getString("warecode")
							,rs.getString("warename")
							,rs.getString("usecheck")
							,rs.getString("warelike")
							,rs.getString("waresearch")
							
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(stmt);
		}
		
		return stList;
	}
	public ArrayList<St> selectStListTemp() {
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<St> stList = null;
		int i=0;
		DecimalFormat df = new DecimalFormat("###,###");
		
		System.out.println("창고 리스트");	
		try {
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from warehouse where warelike IN ('가입고') and usecheck='사용'");
			
			
			
			if(rs.next()){
				stList = new ArrayList<St>();
				
				do {
					stList.add(new St(
							rs.getString("warecode")
							,rs.getString("warename")
							,rs.getString("usecheck")
							,rs.getString("warelike")
							,rs.getString("waresearch")
							
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(stmt);
		}
		
		return stList;
	}
	public ArrayList<St> selectStListdefect() {
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<St> stList = null;
		int i=0;
		DecimalFormat df = new DecimalFormat("###,###");
		
		System.out.println("창고 리스트");	
		try {
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from warehouse where warelike IN ('불량품') and usecheck='사용'");
			
			
			
			if(rs.next()){
				stList = new ArrayList<St>();
				
				do {
					stList.add(new St(
							rs.getString("warecode")
							,rs.getString("warename")
							,rs.getString("usecheck")
							,rs.getString("warelike")
							,rs.getString("waresearch")
							
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(stmt);
		}
		
		return stList;
	}
	public ArrayList<Stl> selectStlList() {
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<Stl> stlList = null;
		int i=0;
		DecimalFormat df = new DecimalFormat("###,###");
		
		System.out.println("창고 리스트");	
		try {
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM warehouse_like");
			
			
			
			if(rs.next()){
				stlList = new ArrayList<Stl>();
				
				do {
					stlList.add(new Stl(
							rs.getString("warecode")
							,rs.getString("warelike")
							,rs.getString("waresearch")
							
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(stmt);
		}
		
		return stlList;
	}
	public St selectupdatest(String updatewarecode) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		St updateware = null;
		try {
			
			pstmt = con.prepareStatement("SELECT * FROM warehouse where warecode=?");
			pstmt.setString(1, updatewarecode);
			rs = pstmt.executeQuery();
			System.out.println("updatewarecode");
			if(rs.next()){//
				 updateware =new St(
							rs.getString("warecode")
							,rs.getString("warename")
							,rs.getString("usecheck")
							,rs.getString("warelike")
							,rs.getString("waresearch")
							
							);
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		
		return updateware;
	}
	public boolean updateSt(String warecode, String warename, String warelike, String usecheck) {
		int a=0;
		boolean success = false;
		PreparedStatement pstmt=null;
		String owarelike;
		ResultSet rs = null;
		System.out.println("updateitem ");
		
		try {
			con.setAutoCommit(false);
			
			pstmt=con.prepareStatement("UPDATE warehouse SET warename=?, usecheck=? where warecode=?");
			
			pstmt.setString(1, warename);
			pstmt.setString(2, usecheck);
			pstmt.setString(3, warecode);
			
			a=pstmt.executeUpdate();
			System.out.println("update "+a);
			con.commit(); 	
			
		}catch (SQLException e) {
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			
		}
		if(a>=1) {
			success = true;
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return success;
	}
	public boolean insertSt(String warecode, String warename, String warelike, String usecheck) {
		int a=0;
		boolean success = false;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2=null;
		ResultSet rs = null;
		String quality = null;
		int count = 0;
		System.out.println("insertSt");
		
		if(warelike.equals("제품")) {
			quality = "product";
			
		}else if(warelike.equals("부품")) {
			quality = "stock";
			
		}else if(warelike.equals("가입고")) {
			quality = "temp";
			
		}else {
			quality = "defect";
			
		}
		try {
			con.setAutoCommit(false);
			
				pstmt2 = con.prepareStatement("select count(*) from warehouse where warecode Like ?");
				pstmt2.setString(1, "%"+quality+"%");
				rs = pstmt2.executeQuery();
				System.out.println("nowcode");
				if(rs.next()){//
				 count = rs.getInt("count(*)");
				
					}
				count++;
				DecimalFormat df = new DecimalFormat("000");
				
				warecode = "wh-"+quality+"-"+df.format(count);	
				
			
		
			pstmt=con.prepareStatement("Insert into warehouse Values (?,?,?,?,?)");
			pstmt.setString(1, warecode);
			pstmt.setString(2, warename);
			pstmt.setString(3, "사용");
			pstmt.setString(4, warelike);
			pstmt.setString(5, "");
			
			a=pstmt.executeUpdate();
			System.out.println("Insert "+a);
			con.commit(); 	
			
		}catch (SQLException e) {
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			close(pstmt2);
			close(rs);
		}
		if(a>=1) {
			success = true;
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return success;
	}
	public boolean insertIL(String itemlikecode1, String itemlikecode2, String itemlikename, String item_sortation) {
		int a=0;
		boolean success = false;
		PreparedStatement pstmt=null;
	
		ResultSet rs = null;
		String quality = null;
		int count = 0;
		System.out.println("insertitem ");
		
		try {
			con.setAutoCommit(false);
			
				
			
		
			pstmt=con.prepareStatement("Insert into item_like Values (?,?,?,?)");
			pstmt.setString(1, itemlikecode1);
			pstmt.setString(2, itemlikecode2);
			pstmt.setString(3, itemlikename);
			pstmt.setString(4, item_sortation);
			
			a=pstmt.executeUpdate();
			System.out.println("Insert "+a);
			con.commit(); 	
			
		}catch (SQLException e) {
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			
			close(rs);
		}
		if(a>=1) {
			success = true;
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return success;
	}
	public Order3 taxbillOrder(String updateordercode) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Order3 taxbillorder = null;
        // 현재 날짜 구하기
        LocalDate now = LocalDate.now();
        // 포맷 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        // 포맷 적용
        String formatedNow = now.format(formatter);
        int monthValue = now.getMonthValue();
        int dayOfMonth = now.getDayOfMonth();
		try {
			DecimalFormat df = new DecimalFormat("###,###");
		
			System.out.println(updateordercode);
			pstmt = con.prepareStatement("SELECT clientcode, o.clientname, representative, type_of_business, business_number, address, itemname,delivery_day, Forwarding_price, count, sv, total_amount FROM orders o, client c where ordercode=? and o.clientname=c.clientname");
			pstmt.setString(1, updateordercode);
			rs = pstmt.executeQuery();
			System.out.println("unitedDAO에서 세금계산서 정보");
			if(rs.next()){//
				taxbillorder =new Order3(
							rs.getString("clientcode")
							,rs.getString("o.clientname")
							,rs.getString("representative")
							,rs.getString("type_of_business")
							,rs.getString("business_number")
							,rs.getString("address")
							,rs.getString("itemname")
							,rs.getString("delivery_day")
							,df.format(rs.getInt("forwarding_price"))
							,rs.getInt("count")
							,df.format(rs.getInt("sv"))
							,df.format(rs.getInt("total_amount"))
							,df.format(rs.getInt("total_amount")-rs.getInt("sv"))
							,formatedNow
							,monthValue
							,dayOfMonth
							);
				System.out.println("-------------");
				System.out.println(rs.getString("clientcode"));
				System.out.println(rs.getString("o.clientname"));
				System.out.println(rs.getString("representative"));
				System.out.println(rs.getString("type_of_business"));
				System.out.println(rs.getString("business_number"));
				System.out.println(rs.getString("address"));
				System.out.println(rs.getString("itemname"));
				System.out.println(rs.getString("delivery_day"));
				System.out.println(df.format(rs.getInt("forwarding_price")));
				System.out.println(rs.getInt("count"));
				System.out.println(df.format(rs.getInt("sv")));
				System.out.println(df.format(rs.getInt("total_amount")));
				System.out.println(df.format(rs.getInt("total_amount")-rs.getInt("sv")));
				System.out.println(monthValue);
				System.out.println(dayOfMonth);
				System.out.println("-------------");
				System.out.println("taxbillorder을 넘겨줌");
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		
		return taxbillorder;
	}
	
	public Order4 potaxbillOrder(String placecode) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Order4 potaxbillorder = null;
        // 현재 날짜 구하기
        LocalDate now = LocalDate.now();
        // 포맷 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        // 포맷 적용
        String formatedNow = now.format(formatter);
        int monthValue = now.getMonthValue();
        int dayOfMonth = now.getDayOfMonth();
		try {
			DecimalFormat df = new DecimalFormat("###,###");
		
			System.out.println(placecode);
			pstmt = con.prepareStatement("select itemname, clientname, sum(materials) as sum, count(materials)-1 as count, sv, total_amount from place_stock ps, place_an_order po where ps.placecode=po.placecode and po.placecode=?");
			pstmt.setString(1, placecode);
			rs = pstmt.executeQuery();
			System.out.println("unitedDAO에서 세금계산서 정보");
			if(rs.next()){//
				potaxbillorder =new Order4(
							rs.getString("itemname")
							,rs.getString("clientname")
							,rs.getString("sum")
							,rs.getString("count")
							,df.format(rs.getInt("sv"))
							,df.format(rs.getInt("total_amount"))
							,df.format(rs.getInt("total_amount")-rs.getInt("sv"))
							,formatedNow
							,monthValue
							,dayOfMonth
							);
				System.out.println("-------------");
				System.out.println(rs.getString("itemname"));
				System.out.println(rs.getString("clientname"));
				System.out.println(rs.getString("sum"));
				System.out.println(rs.getString("count"));
				System.out.println(df.format(rs.getInt("sv")));
				System.out.println(df.format(rs.getInt("total_amount")));
				System.out.println(df.format(rs.getInt("total_amount")-rs.getInt("sv")));
				System.out.println(monthValue);
				System.out.println(dayOfMonth);
				System.out.println("-------------");
				System.out.println("potaxbillorder을 넘겨줌");
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		
		return potaxbillorder;
	}
	
	
	public ArrayList<po> selectPoSearchList(String searchoption,String firstdate,String finaldate,String progress,String searchvalue,String firstdate2,String finaldate2) {
		PreparedStatement pstmt=null;
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<po> poList = null;
		int i=0;
		
		System.out.println("발주 검색 리스트");	
		
		System.out.println("%"+searchvalue+"%");
		System.out.println(firstdate+"/"+firstdate2);
		System.out.println(finaldate+"/"+finaldate2);
		System.out.println("됨?");
		try {
			if(searchoption.equals("warename")) {
				if(progress.equals("ALL")) {
							pstmt = con.prepareStatement(" select * from place_an_order where warename Like ? and orderday >= ? AND orderday <= ? and delivery_day >= ? And delivery_day <=?");
							System.out.println(pstmt);
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, finaldate);
							pstmt.setString(5, finaldate2);
							rs = pstmt.executeQuery();				
							System.out.println("됨?2");
							System.out.println("품목 검색 조건 x");	

				}else if(progress.equals("Place_an_order")) {
					pstmt = con.prepareStatement("select * from place_an_order where warename Like ? and orderday >= ? AND orderday <= ? and delivery_day >= ? And delivery_day <=? And progress_status='발주확인'");
					System.out.println(pstmt);
					pstmt.setString(1, "%"+searchvalue+"%");
					pstmt.setString(2, firstdate);
					pstmt.setString(3, firstdate2);
					pstmt.setString(4, finaldate);
					pstmt.setString(5, finaldate2);
					rs = pstmt.executeQuery();					
					System.out.println("품목 검색 조건 x");	
	
				}else if(progress.equals("warehousing")) {
					pstmt = con.prepareStatement("select * from place_an_order where warename Like ? and orderday >= ? AND orderday <= ? and delivery_day >= ? And delivery_day <=? And progress_status='입고완료'");
					System.out.println(pstmt);
					pstmt.setString(1, "%"+searchvalue+"%");
					pstmt.setString(2, firstdate);
					pstmt.setString(3, firstdate2);
					pstmt.setString(4, finaldate);
					pstmt.setString(5, finaldate2);
					rs = pstmt.executeQuery();					
					System.out.println("품목 검색 조건 x");	
			
				}else if(progress.equals("outing")) {
					pstmt = con.prepareStatement("select * from place_an_order where warename Like ? and orderday >= ? AND orderday <= ? and delivery_day >= ? And delivery_day <=? And progress_status='출고완료'");
					System.out.println(pstmt);
					pstmt.setString(1, "%"+searchvalue+"%");
					pstmt.setString(2, firstdate);
					pstmt.setString(3, firstdate2);
					pstmt.setString(4, finaldate);
					pstmt.setString(5, finaldate2);
					rs = pstmt.executeQuery();					
					System.out.println("품목 검색 조건 x");	
			
				}
				
			}else if(searchoption.equals("pocode")) {
				if(progress.equals("ALL")) {
					pstmt = con.prepareStatement(" select * from place_an_order where placecode Like ? and orderday >= ? AND orderday <= ? and delivery_day >= ? And delivery_day <=?");
					System.out.println(pstmt);
					pstmt.setString(1, "%"+searchvalue+"%");
					pstmt.setString(2, firstdate);
					pstmt.setString(3, firstdate2);
					pstmt.setString(4, finaldate);
					pstmt.setString(5, finaldate2);
					rs = pstmt.executeQuery();					
					System.out.println("품목 검색 조건 x");	

				}else if(progress.equals("Place_an_order")) {
			pstmt = con.prepareStatement("select * from place_an_order where placecode Like ? and orderday >= ? AND orderday <= ? and delivery_day >= ? And delivery_day <=? And progress_status='발주확인'");
			System.out.println(pstmt);
			pstmt.setString(1, "%"+searchvalue+"%");
			pstmt.setString(2, firstdate);
			pstmt.setString(3, firstdate2);
			pstmt.setString(4, finaldate);
			pstmt.setString(5, finaldate2);
			rs = pstmt.executeQuery();					
			System.out.println("품목 검색 조건 x");	

				}else if(progress.equals("warehousing")) {
			pstmt = con.prepareStatement("select * from place_an_order where placecode Like ? and orderday >= ? AND orderday <= ? and delivery_day >= ? And delivery_day <=? And progress_status='입고완료'");
			System.out.println(pstmt);
			pstmt.setString(1, "%"+searchvalue+"%");
			pstmt.setString(2, firstdate);
			pstmt.setString(3, firstdate2);
			pstmt.setString(4, finaldate);
			pstmt.setString(5, finaldate2);
			rs = pstmt.executeQuery();					
			System.out.println("품목 검색 조건 x");	
	
				}else if(progress.equals("outing")) {
			pstmt = con.prepareStatement("select * from place_an_order where placecode Like ? and orderday >= ? AND orderday <= ? and delivery_day >= ? And delivery_day <=? And progress_status='출고완료'");
			System.out.println(pstmt);
			pstmt.setString(1, "%"+searchvalue+"%");
			pstmt.setString(2, firstdate);
			pstmt.setString(3, firstdate2);
			pstmt.setString(4, finaldate);
			pstmt.setString(5, finaldate2);
			rs = pstmt.executeQuery();					
			System.out.println("품목 검색 조건 x");	
	
				}
		
			}else if(searchoption.equals("ename")) {
				if(progress.equals("ALL")) {
					pstmt = con.prepareStatement(" select * from place_an_order where name Like ? and orderday >= ? AND orderday <= ? and delivery_day >= ? And delivery_day <=?");
					System.out.println(pstmt);
					pstmt.setString(1, "%"+searchvalue+"%");
					pstmt.setString(2, firstdate);
					pstmt.setString(3, firstdate2);
					pstmt.setString(4, finaldate);
					pstmt.setString(5, finaldate2);
					rs = pstmt.executeQuery();					
					System.out.println("품목 검색 조건 x");	

				}else if(progress.equals("Place_an_order")) {
			pstmt = con.prepareStatement("select * from place_an_order where name Like ? and orderday >= ? AND orderday <= ? and delivery_day >= ? And delivery_day <=? And progress_status='발주확인'");
			System.out.println(pstmt);
			pstmt.setString(1, "%"+searchvalue+"%");
			pstmt.setString(2, firstdate);
			pstmt.setString(3, firstdate2);
			pstmt.setString(4, finaldate);
			pstmt.setString(5, finaldate2);
			rs = pstmt.executeQuery();					
			System.out.println("품목 검색 조건 x");	

				}else if(progress.equals("warehousing")) {
			pstmt = con.prepareStatement("select * from place_an_order where name Like ? and orderday >= ? AND orderday <= ? and delivery_day >= ? And delivery_day <=? And progress_status='입고완료'");
			System.out.println(pstmt);
			pstmt.setString(1, "%"+searchvalue+"%");
			pstmt.setString(2, firstdate);
			pstmt.setString(3, firstdate2);
			pstmt.setString(4, finaldate);
			pstmt.setString(5, finaldate2);
			rs = pstmt.executeQuery();					
			System.out.println("품목 검색 조건 x");	
	
				}else if(progress.equals("outing")) {
			pstmt = con.prepareStatement("select * from place_an_order where name Like ? and orderday >= ? AND orderday <= ? and delivery_day >= ? And delivery_day <=? And progress_status='출고완료'");
			System.out.println(pstmt);
			pstmt.setString(1, "%"+searchvalue+"%");
			pstmt.setString(2, firstdate);
			pstmt.setString(3, firstdate2);
			pstmt.setString(4, finaldate);
			pstmt.setString(5, finaldate2);
			rs = pstmt.executeQuery();					
			System.out.println("품목 검색 조건 x");	
	
				}
			}
			DecimalFormat df = new DecimalFormat("###,###");
			
			
			if(rs.next()){
				poList = new ArrayList<po>();
				
				do {
					poList.add(new po(
							rs.getString("placecode")
							,rs.getString("warename")
							,rs.getString("orderday")
							,rs.getString("delivery_day")
							,df.format(rs.getInt("sv"))
							,df.format(rs.getInt("total_amount"))
							,rs.getString("ecode")
							,rs.getString("name")
							,rs.getString("progress_status")
							,rs.getString("ordercode")
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
		}
		
		return poList;
	}
	public ArrayList<wh> selectWhSearchList(String searchoption,String firstdate,String finaldate,String progress,String searchvalue,String firstdate2,String finaldate2) {
		PreparedStatement pstmt=null;
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<wh> whList = null;
		int i=0;
		
		System.out.println("입고 검색 리스트");	
		
		System.out.println("%"+searchvalue+"%");
		System.out.println(firstdate+"/"+firstdate2);
		System.out.println(finaldate+"/"+finaldate2);
		System.out.println("됨?");
		try {
			if(searchoption.equals("warename")) {
				if(progress.equals("ALL")) {
							pstmt = con.prepareStatement(" select * from warehousing where warename Like ? and wareday >= ? AND wareday <= ?");
							System.out.println(pstmt);
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							
							rs = pstmt.executeQuery();				
							System.out.println("됨?2");
							System.out.println("품목 검색 조건 x");	

				}else if(progress.equals("Check")) {
					pstmt = con.prepareStatement(" select * from warehousing where warename Like ? and wareday >= ? AND wareday <= ? And progress_status='진행중'");
					System.out.println(pstmt);
					pstmt.setString(1, "%"+searchvalue+"%");
					pstmt.setString(2, firstdate);
					pstmt.setString(3, firstdate2);
					
					rs = pstmt.executeQuery();					
					System.out.println("품목 검색 조건 x");	
	
				}else if(progress.equals("warehousing")) {
					pstmt = con.prepareStatement("select * from warehousing where warename Like ? and wareday >= ? AND wareday <= ? And progress_status='입고완료'");
					System.out.println(pstmt);
					pstmt.setString(1, "%"+searchvalue+"%");
					pstmt.setString(2, firstdate);
					pstmt.setString(3, firstdate2);
					
					rs = pstmt.executeQuery();					
					System.out.println("품목 검색 조건 x");	
			
				}
				
			}else if(searchoption.equals("waringcode")) {
				if(progress.equals("ALL")) {
					pstmt = con.prepareStatement(" select * from warehousing where waringcode Like ? and wareday >= ? AND wareday <= ?");
					System.out.println(pstmt);
					pstmt.setString(1, "%"+searchvalue+"%");
					pstmt.setString(2, firstdate);
					pstmt.setString(3, firstdate2);
					
					rs = pstmt.executeQuery();				
					System.out.println("됨?2");
					System.out.println("품목 검색 조건 x");	

		}else if(progress.equals("Check")) {
			pstmt = con.prepareStatement(" select * from warehousing where waringcode Like ? and wareday >= ? AND wareday <= ? And progress_status='진행중'");
			System.out.println(pstmt);
			pstmt.setString(1, "%"+searchvalue+"%");
			pstmt.setString(2, firstdate);
			pstmt.setString(3, firstdate2);
			
			rs = pstmt.executeQuery();					
			System.out.println("품목 검색 조건 x");	

		}else if(progress.equals("warehousing")) {
			pstmt = con.prepareStatement("select * from warehousing where waringcode Like ? and wareday >= ? AND wareday <= ? And progress_status='입고완료'");
			System.out.println(pstmt);
			pstmt.setString(1, "%"+searchvalue+"%");
			pstmt.setString(2, firstdate);
			pstmt.setString(3, firstdate2);
			
			rs = pstmt.executeQuery();					
			System.out.println("품목 검색 조건 x");	
	
		}
		
			}
			
			DecimalFormat df = new DecimalFormat("###,###");
			
			
			if(rs.next()){
				whList = new ArrayList<wh>();
				
				do {
					whList.add(new wh(
							rs.getString("waringcode")
							,rs.getString("placecode")
							,rs.getString("warename")
							,rs.getString("wareday")	
							,rs.getString("progress_status")
							
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
		}
		
		return whList;
	}
	public ArrayList<St> selectStSearchList(String searchoption,String searchvalue,String like) {
		PreparedStatement pstmt=null;
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<St> stList = null;
		int i=0;
		System.out.println(like);
		System.out.println("창고 검색 리스트");	
		
		System.out.println("%"+searchvalue+"%");

		System.out.println("됨?");
		try {
			if(searchoption.equals("itemcode")) {
					if(like.equals("ALL")) {
							pstmt = con.prepareStatement(" select * from warehouse where warecode Like ?");
							System.out.println(pstmt);
							pstmt.setString(1, "%"+searchvalue+"%");
							System.out.println(like);
							
							rs = pstmt.executeQuery();				
							System.out.println("됨?2");
							System.out.println("품목 검색 조건 x");	
					}else {
						pstmt = con.prepareStatement(" select * from warehouse where warecode Like ? And warelike Like ?");
						System.out.println(pstmt);
						pstmt.setString(1, "%"+searchvalue+"%");
						pstmt.setString(2, "%"+like+"%");
						rs = pstmt.executeQuery();	
					}
				
				
			}else if(searchoption.equals("itemname")) {
				
				if(like.equals("ALL")) {
					pstmt = con.prepareStatement(" select * from warehouse where warename Like ?");
					System.out.println(pstmt);
					pstmt.setString(1, "%"+searchvalue+"%");
					
					
					rs = pstmt.executeQuery();				
					System.out.println("됨?2");
					System.out.println("품목 검색 조건 x");	
			}else {
				pstmt = con.prepareStatement(" select * from warehouse where warename Like ? And warelike Like ?");
				System.out.println(pstmt);
				pstmt.setString(1, "%"+searchvalue+"%");
				pstmt.setString(2, "%"+like+"%");
				rs = pstmt.executeQuery();	
			}
		
	
		
		
			}
			
			DecimalFormat df = new DecimalFormat("###,###");
			
			
			if(rs.next()){
				stList = new ArrayList<St>();
				
				do {
					stList.add(new St(
							rs.getString("warecode")
							,rs.getString("warename")
							,rs.getString("usecheck")
							,rs.getString("warelike")
							,rs.getString("waresearch")
							
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
		}
		
		return stList;
	}
	public boolean checkfinishorder(String updateordercode) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String updateorder = null;
		boolean success= false;
		try {
			DecimalFormat df = new DecimalFormat("###,###");
		
			System.out.println(updateordercode);
			pstmt = con.prepareStatement("SELECT progress_status FROM orders where ordercode=?");
			pstmt.setString(1, updateordercode);
			rs = pstmt.executeQuery();
			System.out.println("updateordercode");
			if(rs.next()){//
				 updateorder =rs.getString("progress_status");
							
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		if(updateorder.equals("입고완료")) {
			success = true;
		}
		return success;
	}
	public boolean finishorder(String updateordercode) {
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		
		ResultSet rs = null;
		ResultSet rs2 = null;
		String updateorder = null;
		boolean success= false;
		String placecode=null;
		String itemcode = null;
		String OItemcode = null;
		String OItemname = null;
		String warename=null;
		String Owarename=null;
		String itemname=null;
		String clientname=null;
		int materials = 0;
		int count = 0;
		int Ocount =0;
		int a=0;
		int b=0;
		int nowcount=0;
		int Onowcount=0;
		try {
		con.setAutoCommit(false);
	
		
		DecimalFormat df = new DecimalFormat("###,###");
		
		pstmt = con.prepareStatement("select placecode from place_an_order where ordercode=?");
		pstmt.setString(1, updateordercode);
		rs = pstmt.executeQuery();
		if(rs.next()){		
			do {
				placecode= rs.getString("placecode");			
			} while (rs.next());			
		}
		pstmt = con.prepareStatement("select warename from place_an_order where ordercode=?");
		pstmt.setString(1, updateordercode);
		rs = pstmt.executeQuery();
		if(rs.next()){		
			do {
				warename= rs.getString("warename");			
			} while (rs.next());			
		}
		pstmt = con.prepareStatement("select clientname from orders where ordercode=?");
		pstmt.setString(1, updateordercode);
		rs = pstmt.executeQuery();
		if(rs.next()){		
			do {
				clientname= rs.getString("clientname");			
			} while (rs.next());			
		}
		pstmt = con.prepareStatement("select itemname from orders where ordercode=?");
		pstmt.setString(1, updateordercode);
		rs = pstmt.executeQuery();
		if(rs.next()){		
			do {
				OItemname= rs.getString("itemname");			
			} while (rs.next());			
		}
		pstmt = con.prepareStatement("select itemcode from item where itemname=?");
		pstmt.setString(1, OItemname);
		rs = pstmt.executeQuery();
		if(rs.next()){		
			do {
				OItemcode= rs.getString("itemcode");			
			} while (rs.next());			
		}
		pstmt = con.prepareStatement("select count from orders where ordercode=?");
		pstmt.setString(1, updateordercode);
		rs = pstmt.executeQuery();
		if(rs.next()){		
			do {
				Ocount= rs.getInt("count");			
			} while (rs.next());			
		}
		
		pstmt = con.prepareStatement("select warename from holding where itemname=?");
		pstmt.setString(1, OItemname);
		rs = pstmt.executeQuery();
		if(rs.next()){		
			do {
				Owarename= rs.getString("warename");			
			} while (rs.next());			
		}
		pstmt = con.prepareStatement("select acount from holding where itemname=? and warename=?");
		pstmt.setString(1, OItemname);
		pstmt.setString(2, Owarename);
		rs = pstmt.executeQuery();
		if(rs.next()){		
			do {
				Onowcount= rs.getInt("acount");			
			} while (rs.next());			
		}
		System.out.println(placecode+"아니pc");
		pstmt = con.prepareStatement("select itemname,materials,itemcode from place_stock where placecode=?");
		pstmt.setString(1, placecode);
		rs = pstmt.executeQuery();
		System.out.println(rs+"아니rs");
		if(rs.next()){
			
			
			do {
				itemname = rs.getString("itemname");
				materials = rs.getInt("materials");
				itemcode = rs.getString("itemcode");
				pstmt2 = con.prepareStatement("select acount from holding where itemcode=? and warename=?");
				pstmt2.setString(1, itemcode);	
				pstmt2.setString(2, warename);
				rs2 = pstmt2.executeQuery();
				System.out.println(itemname+"아니");
				System.out.println(itemcode+"아니");
				System.out.println(materials+"아니");
				if(rs2.next()){		
					do {
						nowcount= rs2.getInt("acount");			
					} while (rs2.next());			
				}
				
				pstmt2 = con.prepareStatement("update holding set acount = acount-? where warename=? and itemcode=? ");
				pstmt2.setInt(1, materials);
				pstmt2.setString(2, warename);	
				pstmt2.setString(3, itemcode);
				a= a+ pstmt2.executeUpdate();
				b = b+1;
				if(a==b) {
					pstmt2=con.prepareStatement("Insert Into holding_log Values (?,?,?,?,?,NOW(),?,?,'생산출고')");
					pstmt2.setString(1, null);
					pstmt2.setString(2, itemcode);
					pstmt2.setString(3, itemname);
					pstmt2.setString(4, clientname);
					pstmt2.setString(5, warename);
					pstmt2.setInt(6, materials*-1);
					pstmt2.setInt(7, nowcount-materials);
					pstmt2.executeUpdate();
				}
				
			} while (rs.next());
			
		}
		
		
		
		pstmt = con.prepareStatement("select count(*) from place_stock where placecode=?");
		pstmt.setString(1, placecode);
		rs = pstmt.executeQuery();
		if(rs.next()){		
			do {
				count= rs.getInt("count(*)");			
			} while (rs.next());			
		}
		
		System.out.println(a+"a");
		System.out.println(b+"b");
		System.out.println(count+"아니");
		if(a != count) {
			return success;
		}
		
		pstmt2 = con.prepareStatement("update holding set acount = acount+? where warename=? and itemname=? ");
		pstmt2.setInt(1, Ocount);
		pstmt2.setString(2, Owarename);	
		pstmt2.setString(3, OItemname);
		a=  pstmt2.executeUpdate();
		if(a>=1) {
			pstmt2=con.prepareStatement("Insert Into holding_log Values (?,?,?,?,?,DATE_ADD(NOW(), INTERVAL 1 SECOND),?,?,'생산입고')");
			pstmt2.setString(1, null);
			pstmt2.setString(2, OItemcode);
			pstmt2.setString(3, OItemname);
			pstmt2.setString(4, clientname);
			pstmt2.setString(5, Owarename);
			pstmt2.setInt(6, Ocount-Onowcount);
			pstmt2.setInt(7, Onowcount+(Ocount-Onowcount));
			a=pstmt2.executeUpdate();
		}
		
		pstmt2 = con.prepareStatement("update holding set acount = acount-? where warename=? and itemname=? ");
		pstmt2.setInt(1, Ocount);
		pstmt2.setString(2, Owarename);	
		pstmt2.setString(3, OItemname);
		a=  pstmt2.executeUpdate();
		if(a>=1) {
			pstmt2=con.prepareStatement("Insert Into holding_log Values (?,?,?,?,?,DATE_ADD(NOW(), INTERVAL 2 SECOND),?,?,'수주출고')");
			pstmt2.setString(1, null);
			pstmt2.setString(2, OItemcode);
			pstmt2.setString(3, OItemname);
			pstmt2.setString(4, clientname);
			pstmt2.setString(5, Owarename);
			pstmt2.setInt(6, Ocount*-1);
			pstmt2.setInt(7, (Onowcount+(Ocount-Onowcount))-Ocount);
			a=pstmt2.executeUpdate();
		}
		
		pstmt2 = con.prepareStatement("update orders set progress_status='출고완료' where ordercode=? ");
		pstmt2.setString(1, updateordercode);
		a=pstmt2.executeUpdate();
		
		
		
		con.commit(); 	
		success = true;
	}catch (SQLException e) {
		if(con!=null)
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		e.printStackTrace();
	} finally {
		
		close(pstmt);
		close(pstmt2);
		close(rs);
		close(rs2);
	}
	
		success = true;
	
	try {
		con.setAutoCommit(true);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	return success;
	}
	
	//재고증감량 확인
	public ArrayList<LogStatus> selectLogList() {
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<LogStatus> LogList = null;
		int i=0;
		
		System.out.println("재고증감량 리스트");	
		try {
			DecimalFormat df = new DecimalFormat("###,###");
			
				
			stmt = con.createStatement();
			rs = stmt.executeQuery("select waringcode, itemcode, itemname, clientname, warename, holdingday, acount, changeacount, log_like from holding_log order by holdingday desc");
			
			if(rs.next()){
				LogList = new ArrayList<LogStatus>();
				
				do {
					LogList.add(new LogStatus(
							rs.getString("waringcode")
							,rs.getString("itemcode")
							,rs.getString("itemname")
							,rs.getString("clientname")
							,rs.getString("warename")
							,rs.getString("holdingday")
							,rs.getInt("acount")
							,rs.getInt("changeacount")
							,rs.getString("log_like")
							));
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(stmt);
		}
		
		return LogList;
	}
	//재고증감량 검색
	public ArrayList<LogStatus> selectLogSearchList(String searchoption,String firstdate,String firstdate2,String searchLike,String searchLike2,String searchorder,String searchvalue) {
		PreparedStatement pstmt=null;
		Statement stmt = null;
		ResultSet rs= null;
		ArrayList<LogStatus> LogList = null;
		int i=0;
		
		System.out.println("재고 검색 리스트");	
		System.out.println(searchoption); // 검색종류
		System.out.println(firstdate+"/"+firstdate2);//일자별
		System.out.println(searchLike);	//품목종류
		System.out.println(searchLike2); //창고종류	
		System.out.println(searchorder); //내림차순	
		System.out.println(searchvalue); // 검색값
		
		System.out.println("%"+searchvalue+"%");
		try {
			if(searchoption.equals("itemname")) {		//검색종류 -부품명으로 검색
				if(searchLike.equals("ALL")) {			//품목종류
					if(searchLike2.equals("ALL")) {		//창고종류
						if(searchorder.equals("ALL")) { //내림차순
							pstmt = con.prepareStatement("SELECT * FROM holding_log where itemname Like ? and holdingday >= ? AND holdingday <= ? order by holdingday desc");
							System.out.println(pstmt);
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							rs = pstmt.executeQuery();					
							System.out.println("품목 검색 조건 x");	
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM holding_log where itemname Like ? and holdingday >= ? AND holdingday <= ? order by holdingday ASC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM holding_log where itemname Like ? and holdingday >= ? AND holdingday <= ? order by holdingday DESC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							rs = pstmt.executeQuery();
						}
					}else{
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM holding_log where itemname Like ? and holdingday >= ? AND holdingday <= ? AND warename=? order by holdingday DESC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, searchLike2);
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM holding_log where itemname Like ? and holdingday >= ? AND holdingday <= ? AND warename=? order by holdingday ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, searchLike2);
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM holding_log where itemname Like ? and holdingday >= ? AND holdingday <= ? AND warename=? order by holdingday DESC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, searchLike2);
							rs = pstmt.executeQuery();
						}
					}
				}else {
					if(searchLike2.equals("ALL")) {
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM holding_log where itemname Like ? and holdingday >= ? AND holdingday <= ? AND log_like Like ? order by holdingday DESC");
							System.out.println(pstmt);
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, "%"+searchLike+"%");
							rs = pstmt.executeQuery();					
							System.out.println("품목 검색 조건 x");	
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM holding_log where itemname Like ? and holdingday >= ? AND holdingday <= ? AND log_like Like ? order by holdingday ASC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM holding_log where itemname Like ? and holdingday >= ? AND holdingday <= ? AND log_like Like ? order by holdingday DESC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}
					}else{
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM holding_log where itemname Like ? and holdingday >= ? AND holdingday <= ? AND log_like Like ? AND warename=? order by holdingday DESC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, "%"+searchLike+"%");
							pstmt.setString(5, searchLike2);
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM holding_log where itemname Like ? and holdingday >= ? AND holdingday <= ? AND log_like Like ? AND warename=? order by holdingday ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, "%"+searchLike+"%");
							pstmt.setString(5, searchLike2);
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM holding_log where itemname Like ? and holdingday >= ? AND holdingday <= ? AND log_like Like ? AND warename=? order by holdingday DESC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, "%"+searchLike+"%");
							pstmt.setString(5, searchLike2);
							rs = pstmt.executeQuery();
						}
					}
				}
			}else if(searchoption.equals("clientname")){	//거래처명으로 검색
				if(searchLike.equals("ALL")) {
					if(searchLike2.equals("ALL")) {
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM holding_log where clientname Like ? and holdingday >= ? AND holdingday <= ? order by holdingday desc");
							System.out.println(pstmt);
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							rs = pstmt.executeQuery();					
							System.out.println("품목 검색 조건 x");	
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM holding_log where clientname Like ? and holdingday >= ? AND holdingday <= ? order by holdingday ASC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM holding_log where clientname Like ? and holdingday >= ? AND holdingday <= ? order by holdingday DESC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							rs = pstmt.executeQuery();
						}
					}else{
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM holding_log where clientname Like ? and holdingday >= ? AND holdingday <= ? AND warename=? order by holdingday DESC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, searchLike2);
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM holding_log where clientname Like ? and holdingday >= ? AND holdingday <= ? AND warename? order by holdingday ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, searchLike2);
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM holding_log where clientname Like ? and holdingday >= ? AND holdingday <= ? AND warename=? order by holdingday DESC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, searchLike2);
							rs = pstmt.executeQuery();
						}
					}
				}else {
					if(searchLike2.equals("ALL")) {
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM holding_log where clientname Like ? and holdingday >= ? AND holdingday <= ? AND log_like Like ? order by holdingday desc");
							System.out.println(pstmt);
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, "%"+searchLike+"%");
							rs = pstmt.executeQuery();					
							System.out.println("품목 검색 조건 x");	
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM holding_log where clientname Like ? and holdingday >= ? AND holdingday <= ? AND log_like Like ? order by holdingday ASC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM holding_log where clientname Like ? and holdingday >= ? AND holdingday <= ? AND log_like Like ? order by holdingday DESC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}
					}else {
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM holding_log where clientname Like ? and holdingday >= ? AND holdingday <= ? AND log_like Like ? AND warename=? order by holdingday DESC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, "%"+searchLike+"%");
							pstmt.setString(5, searchLike2);
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM holding_log where clientname Like ? and holdingday >= ? AND holdingday <= ? AND log_like Like ? AND warename=? order by holdingday ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, "%"+searchLike+"%");
							pstmt.setString(5, searchLike2);
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM holding_log where clientname Like ? and holdingday >= ? AND holdingday <= ? AND log_like Like ? AND warename=? order by holdingday DESC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, "%"+searchLike+"%");
							pstmt.setString(5, searchLike2);
							rs = pstmt.executeQuery();
						}
					}
				}
			}else {			// 부품코드로 검색
				if(searchLike.equals("ALL")) {
					if(searchLike2.equals("ALL")) {
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM holding_log where itemcode Like ? and holdingday >= ? AND holdingday <= ? order by holdingday DESC");
							System.out.println(pstmt);
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							rs = pstmt.executeQuery();					
							System.out.println("품목 검색 조건 x");	
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM holding_log where itemcode Like ? and holdingday >= ? AND holdingday <= ? order by holdingday ASC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM holding_log where itemcode Like ? and holdingday >= ? AND holdingday <= ? order by holdingday DESC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							rs = pstmt.executeQuery();
						}
					}else{
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM holding_log where itemcode Like ? and holdingday >= ? AND holdingday <= ? AND warename=? order by holdingday DESC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, searchLike2);
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM holding_log where itemcode Like ? and holdingday >= ? AND holdingday <= ? AND warename? order by holdingday ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, searchLike2);
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM holding_log where itemcode Like ? and holdingday >= ? AND holdingday <= ? AND warename=? order by holdingday DESC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, searchLike2);
							rs = pstmt.executeQuery();
						}
					}
				}else {
					if(searchLike2.equals("ALL")) {
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM holding_log where itemcode Like ? and holdingday >= ? AND holdingday <= ? AND log_like Like ? order by holdingday DESC");
							System.out.println(pstmt);
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, "%"+searchLike+"%");
							rs = pstmt.executeQuery();					
							System.out.println("품목 검색 조건 x");	
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM holding_log where itemcode Like ? and holdingday >= ? AND holdingday <= ? AND log_like Like ? order by holdingday ASC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM holding_log where itemcode Like ? and holdingday >= ? AND holdingday <= ? AND log_like Like ? order by holdingday DESC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, "%"+searchLike+"%");
							rs = pstmt.executeQuery();
						}
					}else {
						if(searchorder.equals("ALL")) {
							pstmt = con.prepareStatement("SELECT * FROM holding_log where itemcode Like ? and holdingday >= ? AND holdingday <= ? AND log_like Like ? AND warename=? order by holdingday DESC");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, "%"+searchLike+"%");
							pstmt.setString(5, searchLike2);
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INASC")){
							pstmt = con.prepareStatement("SELECT * FROM holding_log where itemcode Like ? and holdingday >= ? AND holdingday <= ? AND log_like Like ? AND warename=? order by holdingday ASC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, "%"+searchLike+"%");
							pstmt.setString(5, searchLike2);
							rs = pstmt.executeQuery();
						}else if(searchorder.equals("INDESC")){
							pstmt = con.prepareStatement("SELECT * FROM holding_log where itemcode Like ? and holdingday >= ? AND holdingday <= ? AND log_like Like ? AND warename=? order by holdingday DESC ");
							pstmt.setString(1, "%"+searchvalue+"%");
							pstmt.setString(2, firstdate);
							pstmt.setString(3, firstdate2);
							pstmt.setString(4, "%"+searchLike+"%");
							pstmt.setString(5, searchLike2);
							rs = pstmt.executeQuery();
						}
					}
				}
				
			}
			
			DecimalFormat df = new DecimalFormat("###,###");
			
			
			if(rs.next()){
				LogList = new ArrayList<LogStatus>();
				
				do {
					LogList.add(new LogStatus(
							rs.getString("waringcode")
							,rs.getString("itemcode")
							,rs.getString("itemname")
							,rs.getString("clientname")
							,rs.getString("warename")
							,rs.getString("holdingday")
							,rs.getInt("acount")
							,rs.getInt("changeacount")
							,rs.getString("log_like")
							));
					
					i++;
					System.out.println(i+" 번쨰 레코드");	
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pstmt);
		}
		
		return LogList;
	}
	
}
