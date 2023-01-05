package CaptsqlChal4submitService;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import vo.Board;
import vo.Food;
import vo.User;
import vo.client;
import dao.UnitedDAO;
public class CerpClientService {

	
	public User getUser(String id) {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
	
		User des = CaptDao.login(id);
		System.out.println("?��?? 로딩");
		close(con);
		return des;
	}
	public ArrayList<client> getclientList() {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<client> clientList = CaptDao.selectclientList(); 
		close(con); // �ڿ� ����
		return clientList;
	}
public ArrayList<client> getclientSearchList(String searchoption, String searchvalue) {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<client> clientList = CaptDao.selectclientSearchList(searchoption, searchvalue); 
		close(con); // �ڿ� ����
		return clientList;
	}
public client getUpdateClient(String updateclientcode) {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
	
		client updateclient = CaptDao.selectupdateclient(updateclientcode); 
		close(con);
		return updateclient;
	}
public boolean UpdateClient(String clientcode, String clientname, String representative, String type_of_business, String business_number, String contact, String representative_contact, String address, String representative_email) {
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	

	boolean success = CaptDao.updateClient(clientcode, clientname, representative, type_of_business, business_number, contact, representative_contact, address, representative_email); 
	close(con);
	return success;
}
}
