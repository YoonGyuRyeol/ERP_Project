package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import vo.Holding;
import vo.Item;
import vo.St;
import vo.User;
import vo.client;
import dao.UnitedDAO;
public class CerpHoldingService {

	
	public User getUser(String id) {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
	
		User des = CaptDao.login(id);
		System.out.println("?��?? 로딩");
		close(con);
		return des;
	}
	public ArrayList<Holding> getHoldingList() {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<Holding> holdingList = CaptDao.selectHoldingList(); 
		close(con); // �ڿ� ����
		return holdingList;
	}
public ArrayList<St> getWareList() {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<St> stList = CaptDao.selectStList2(); 
		close(con); // �ڿ� ����
		return stList;
	}
public ArrayList<St> getWareList2() {
	
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	
	
	ArrayList<St> stList = CaptDao.selectStList3(); 
	close(con); // �ڿ� ����
	return stList;
}
public ArrayList<Holding> getHoldingSearchList(String searchoption,String searchLike,String searchLike2,String searchorder,String searchvalue) {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<Holding> holdingList = CaptDao.selectHoldingSearchList(searchoption,searchLike,searchLike2,searchorder,searchvalue); 
		close(con); // �ڿ� ����
		return holdingList;
	}
public Holding getUpdateHolding(String updateholdingcode) {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
	
		Holding updateholding = CaptDao.selectupdateholding(updateholdingcode); 
		close(con);
		return updateholding;
	}
public boolean UpdateHolding(String itemcode, String itemname, int receiving_price, int acount, String warename) {
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	

	boolean success = CaptDao.updateHolding(itemcode,itemname,receiving_price, acount, warename); 
	close(con);
	return success;
}
public ArrayList<Item> getProductNotInList() {
	
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	
	
	ArrayList<Item> itemList = CaptDao.selectProductNotInList2(); 
	close(con); // �ڿ� ����
	return itemList;
}
public String selectItemNameOne(String itemcode) {
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	

	String success = CaptDao.selectItemNameOne(itemcode); 
	close(con);
	return success;
}
public boolean InsertHolding(String itemcode, String itemname,int materials,String warename) {
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	

	boolean success = CaptDao.insertHolding(itemcode,itemname,materials,warename); 
	close(con);
	return success;
	}
}
