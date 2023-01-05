package CaptsqlChal4submitService;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import vo.IL;
import vo.Item;
import vo.User;
import vo.client;
import dao.UnitedDAO;
public class CerpItemService {

	
	public User getUser(String id) {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
	
		User des = CaptDao.login(id);
		System.out.println("?��?? 로딩");
		close(con);
		return des;
	}
	public ArrayList<Item> getItemList() {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<Item> itemList = CaptDao.selectItemList(); 
		close(con); // �ڿ� ����
		return itemList;
	}
public ArrayList<IL> getILList() {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<IL> ilList = CaptDao.selectILList(); 
		close(con); // �ڿ� ����
		return ilList;
	}
public ArrayList<Item> getItemSearchList(String searchoption,String searchLike,String searchLike2,String searchorder,String searchvalue) {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<Item> itemList = CaptDao.selectItemSearchList(searchoption,searchLike,searchLike2,searchorder,searchvalue); 
		close(con); // �ڿ� ����
		return itemList;
	}
public Item getUpdateItem(String updateitemcode) {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
	
		Item updateitem = CaptDao.selectupdateitem(updateitemcode); 
		close(con);
		return updateitem;
	}
public boolean UpdateItem(String itemcode, String itemname, int receiving_price, int forwarding_price, String item_sortation) {
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	

	boolean success = CaptDao.updateItem(itemcode,itemname,receiving_price, forwarding_price, item_sortation); 
	close(con);
	return success;
}
public boolean InsertItem(String like, String itemcode, String itemname, int receiving_price, int forwarding_price, String item_sortation) {
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	

	boolean success = CaptDao.insertItem(like, itemcode,itemname,receiving_price, forwarding_price, item_sortation); 
	close(con);
	return success;
	}
public boolean InsertIL(String itemlikecode1, String itemlikecode2, String itemlikename, String item_sortation) {
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	

	boolean success = CaptDao.insertIL(itemlikecode1,itemlikecode2,itemlikename,item_sortation); 
	close(con);
	return success;
	}
}
