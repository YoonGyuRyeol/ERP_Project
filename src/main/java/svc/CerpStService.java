package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;


import vo.Item;
import vo.St;
import vo.Stl;
import vo.User;
import vo.client;
import vo.po;
import dao.UnitedDAO;
public class CerpStService {

	
	public User getUser(String id) {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
	
		User des = CaptDao.login(id);
		System.out.println("?��?? 로딩");
		close(con);
		return des;
	}
	public ArrayList<St> getStList() {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<St> stList = CaptDao.selectStList(); 
		close(con); // �ڿ� ����
		return stList;
	}
public ArrayList<Stl> getStlList() {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<Stl> stlList = CaptDao.selectStlList(); 
		close(con); // �ڿ� ����
		return stlList;
	}
public ArrayList<Item> getItemSearchList(String searchoption,String searchLike,String searchLike2,String searchorder,String searchvalue) {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<Item> itemList = CaptDao.selectItemSearchList(searchoption,searchLike,searchLike2,searchorder,searchvalue); 
		close(con); // �ڿ� ����
		return itemList;
	}
public St getUpdateSt(String updatewarecode) {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
	
		St updateware = CaptDao.selectupdatest(updatewarecode); 
		close(con);
		return updateware;
	}
public boolean UpdateSt(String warecode, String warename, String warelike, String usecheck) {
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	

	boolean success = CaptDao.updateSt(warecode,warename,warelike,usecheck); 
	close(con);
	return success;
}
public boolean InsertSt(String warecode, String warename, String warelike, String usecheck) {
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	

	boolean success = CaptDao.insertSt(warecode,warename,warelike,usecheck); 
	close(con);
	return success;
	}

public ArrayList<St> getStSearchList(String searchoption,String searchvalue,String like) {
	
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	
	
	ArrayList<St> stList = CaptDao.selectStSearchList(searchoption,searchvalue,like); 
	close(con); // �ڿ� ����
	return stList;
}
}
