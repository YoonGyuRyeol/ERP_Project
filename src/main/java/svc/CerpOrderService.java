package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;


import vo.Item;
import vo.Order;
import vo.Order3;
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
		close(con);
		return des;
	}
	public ArrayList<Order> getOrderList() {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<Order> orderList = CaptDao.selectOrderList(); 
		close(con);
		return orderList;
	}
public ArrayList<Order> getOrderSearchList(String searchoption,String firstdate,String finaldate,String progress,String searchvalue,String firstdate2,String finaldate2) {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<Order> orderList = CaptDao.selectOrderSearchList(searchoption,firstdate,finaldate,progress,searchvalue,firstdate2,finaldate2); 
		close(con); 
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
	close(con); 
	return clientList;
}
public ArrayList<Item> getItemList() {
	
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	
	
	ArrayList<Item> itemList = CaptDao.selectItemProductList(); 
	close(con); 
	return itemList;
}
public ArrayList<employee> getEmployeeList() {
	
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	
	
	ArrayList<employee> employeeList = CaptDao.selectEmployeeList(); 
	close(con);
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
public boolean CheckFinishOrder(String updateordercode) {
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	

	boolean success = CaptDao.checkfinishorder(updateordercode); 
	close(con);
	return success;
}
public boolean finishOrder(String updateordercode) {
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	

	boolean success = CaptDao.finishorder(updateordercode); 
	close(con);
	return success;
}
public Order3 Taxbillorder(String updateordercode) {
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	
	System.out.println("cerporderservice에서 order3 getupdateorder2실행");
	Order3 taxbillorder = CaptDao.taxbillOrder(updateordercode); 
	close(con);
	return taxbillorder;
}
}
