package CaptsqlChal4submitService;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;


import vo.Item;
import vo.Order;
import vo.User;
import vo.client;
import vo.employee;
import dao.UnitedDAO;
public class CerpOrderService {

	
	public User getUser(String id) {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
	
		User des = CaptDao.login(id);
		System.out.println("?��?? 로딩");
		close(con);
		return des;
	}
	public ArrayList<Order> getOrderList() {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<Order> orderList = CaptDao.selectOrderList(); 
		close(con); // �ڿ� ����
		return orderList;
	}
public ArrayList<Order> getOrderSearchList(String searchoption,String firstdate,String finaldate,String progress,String searchvalue,String firstdate2,String finaldate2) {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<Order> orderList = CaptDao.selectOrderSearchList(searchoption,firstdate,finaldate,progress,searchvalue,firstdate2,finaldate2); 
		close(con); // �ڿ� ����
		return orderList;
	}
public Order getUpdateOrder(String updateordercode) {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
	
		Order updateorder = CaptDao.selectupdateorder(updateordercode); 
		close(con);
		return updateorder;
	}
public ArrayList<client> getClientList() {
	
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	
	
	ArrayList<client> clientList = CaptDao.selectclientList(); 
	close(con); // �ڿ� ����
	return clientList;
}
public ArrayList<Item> getItemList() {
	
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	
	
	ArrayList<Item> itemList = CaptDao.selectItemProductList(); 
	close(con); // �ڿ� ����
	return itemList;
}
public ArrayList<employee> getEmployeeList() {
	
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	
	
	ArrayList<employee> employeeList = CaptDao.selectEmployeeList(); 
	close(con); // �ڿ� ����
	return employeeList;
}
public boolean UpdateOrder(String ordercode,String clientname,String itemname,String orderday,String delivery_day,int forwarding_price,int count,int total_amount,String ecode,String name,int sv) {
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	

	boolean success = CaptDao.updateOrder(ordercode,clientname,itemname,orderday,delivery_day,forwarding_price,count,total_amount,ecode,name,sv); 
	close(con);
	return success;
}
public boolean InsertOrder(String clientname,String itemname,String orderday,String delivery_day,int forwarding_price,int count,int total_amount,String ecode,String name,int sv) {
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	

	boolean success = CaptDao.insertOrder(clientname,itemname,orderday,delivery_day,forwarding_price,count,total_amount,ecode,name,sv); 
	close(con);
	return success;
}
public boolean checkOrder(String updateordercode) {
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	

	boolean success = CaptDao.checkorder(updateordercode); 
	close(con);
	return success;
}
}
