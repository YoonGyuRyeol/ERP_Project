package CaptsqlChal4submitService;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import vo.BomP;
import vo.BomS;
import vo.Item;
import vo.Order;
import vo.Order2;
import vo.User;
import vo.client;
import vo.po;
import vo.pos;
import vo.temp;
import dao.UnitedDAO;
public class CerpPoService {

	
	public User getUser(String id) {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
	
		User des = CaptDao.login(id);
		System.out.println("?��?? 로딩");
		close(con);
		return des;
	}
	public ArrayList<po> getPoList() {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<po> poList = CaptDao.selectPoList(); 
		close(con); // �ڿ� ����
		return poList;
	}
	public po getPoOne(String selectpo) {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		po poList = CaptDao.selectPoOne(selectpo); 
		close(con); // �ڿ� ����
		return poList;
	}
public pos getPoStockOne(String selectpo, String placecode) {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		pos poList = CaptDao.selectPoStockOne(selectpo,placecode); 
		close(con); // �ڿ� ����
		return poList;
	}
	public ArrayList<pos> getPoStockList(String selectpostock) {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<pos> posList = CaptDao.selectPoStockList(selectpostock); 
		close(con); // �ڿ� ����
		return posList;
	}
	public boolean updatePoStock(String placecode, String itemcode,int materials, String clientname) {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	

		boolean success = CaptDao.updatePoStock(placecode,itemcode,materials,clientname); 
		close(con);
		return success;
	}
	public boolean updatePo(String placecode, String warename,String orderday, String deliveryday, String ecode, String ename) {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	

		boolean success = CaptDao.updatePo(placecode,warename,orderday,deliveryday,ecode,ename); 
		close(con);
		return success;
	}
	public boolean insertPo(String warename, String orderday,String delivery_day, int sv, int total_amount, String ecode, String ename,String ordercode) {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	

		boolean success = CaptDao.insertPo(warename,orderday,delivery_day,sv,total_amount,ecode,ename,ordercode); 
		close(con);
		return success;
	}
	public ArrayList<Order2> getOrderList() {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<Order2> orderList = CaptDao.selectOrderList2(); 
		close(con); // �ڿ� ����
		return orderList;
	}
public Order2 getOrderOne(String ordercode) {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		Order2 orderList = CaptDao.selectOrderOne(ordercode); 
		close(con); // �ڿ� ����
		return orderList;
	}
public ArrayList<temp> getMRP(String itemname, String needHolding) {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<temp> mrplist = CaptDao.getMRP(itemname, needHolding); 
		close(con); // �ڿ� ����
		return mrplist;
	}
public int getsv(String itemname, String needHolding) {
	
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	
	
	int sv = CaptDao.getsv(itemname, needHolding); 
	close(con); // �ڿ� ����
	return sv;
}
public temp getMrpOne(String selecttemp) {
	
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	
	
	temp temp = CaptDao.selectMrpOne(selecttemp); 
	close(con); // �ڿ� ����
	return temp;
}
public boolean updateTemp(String itemcode,int materials, String clientname) {
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	

	boolean success = CaptDao.updateTemp(itemcode,materials,clientname); 
	close(con);
	return success;
}
public void resetmrp() {
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	

	CaptDao.resetmrp(); 
	close(con);
	return;
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
