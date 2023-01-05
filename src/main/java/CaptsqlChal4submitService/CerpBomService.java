package CaptsqlChal4submitService;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import vo.BomP;
import vo.BomS;
import vo.Item;
import vo.User;
import vo.client;
import dao.UnitedDAO;
public class CerpBomService {

	
	public User getUser(String id) {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
	
		User des = CaptDao.login(id);
		System.out.println("?��?? 로딩");
		close(con);
		return des;
	}
	public ArrayList<BomP> getBomList() {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<BomP> bomList = CaptDao.selectBomList(); 
		close(con); // �ڿ� ����
		return bomList;
	}
	public ArrayList<BomS> getBomStockList(String selectbomstock) {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<BomS> bomList = CaptDao.selectBomStockList(selectbomstock); 
		close(con); // �ڿ� ����
		return bomList;
	}
	public boolean DeleteFromStock(String bom_code, String itemcode) {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	

		boolean success = CaptDao.deleteFromStock(bom_code,itemcode); 
		close(con);
		return success;
	}
	public String selectItemNameOne(String itemcode) {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	

		String success = CaptDao.selectItemNameOne(itemcode); 
		close(con);
		return success;
	}
	public int selectMaterials(String bom_code, String itemcode) {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	

		int success = CaptDao.selectMaterials(bom_code,itemcode); 
		close(con);
		return success;
	}
public ArrayList<Item> getItemNotInList(String bom_code,String itemcode) {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<Item> itemList = CaptDao.selectItemNotInList(bom_code,itemcode); 
		close(con); // �ڿ� ����
		return itemList;
	}
public ArrayList<Item> getProductNotInList() {
	
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	
	
	ArrayList<Item> itemList = CaptDao.selectProductNotInList(); 
	close(con); // �ڿ� ����
	return itemList;
}

public boolean updateBomStock(String bom_code, String itemcode, String itemname, int materials, String o_itemcode) {
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	

	boolean success = CaptDao.updateBomStock(bom_code,itemcode,itemname,materials,o_itemcode); 
	close(con);
	return success;
}
public boolean InsertBomStock(String bom_code, String itemcode, String itemname, int materials) {
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	

	boolean success = CaptDao.insertBomStock(bom_code,itemcode,itemname,materials); 
	close(con);
	return success;
	}
public boolean InsertBomBase(String itemcode, String itemname) {
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	

	boolean success = CaptDao.insertBomBase(itemcode,itemname); 
	close(con);
	return success;
	}
}
