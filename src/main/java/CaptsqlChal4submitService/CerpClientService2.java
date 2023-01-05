package CaptsqlChal4submitService;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import vo.Board;
import vo.Food;
import vo.User;
import vo.client;
import dao.UnitedDAO;
public class CerpClientService2 {

	
	public User getUser(String id) {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
	
		User des = CaptDao.login(id);
		System.out.println("?��?? 로딩");
		close(con);
		return des;
	}
	
public boolean UpdateClient(String clientcode, String clientname, String representative, String type_of_business, String business_number, String contact, String representative_contact, String address, String representative_email) {
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	

	boolean success = CaptDao.updateClient(clientcode, clientname, representative, type_of_business, business_number, contact, representative_contact, address, representative_email); 
	close(con);
	return success;
}
public boolean InsertClient(String like, String clientname, String representative, String type_of_business, String business_number, String contact, String representative_contact, String address, String representative_email) {
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	

	boolean success = CaptDao.insertClient(like, clientname, representative, type_of_business, business_number, contact, representative_contact, address, representative_email); 
	close(con);
	return success;
}
}
