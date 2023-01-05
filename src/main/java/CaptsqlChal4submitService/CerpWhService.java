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
import vo.wh;
import vo.whs;
import dao.UnitedDAO;
public class CerpWhService {

	
	public User getUser(String id) {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
	
		User des = CaptDao.login(id);
		System.out.println("?��?? 로딩");
		close(con);
		return des;
	}
	public ArrayList<wh> getWhList() {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<wh> whList = CaptDao.selectWhList(); 
		close(con); // �ڿ� ����
		return whList;
	}
	public wh getWhOne(String selectwh) {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		wh whList = CaptDao.selectWhOne(selectwh); 
		close(con); // �ڿ� ����
		return whList;
	}
public whs getWhStockOne(String selectwh, String waringcode) {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		whs whList = CaptDao.selectWhStockOne(selectwh,waringcode); 
		close(con); // �ڿ� ����
		return whList;
	}
	public ArrayList<whs> getWhStockList(String selectwhstock) {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<whs> whsList = CaptDao.selectWhStockList(selectwhstock); 
		close(con); // �ڿ� ����
		return whsList;
	}
	
	public int getMax(String selectwh, String waringcode) {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		int sv = CaptDao.getMax(selectwh, waringcode); 
		close(con); // �ڿ� ����
		return sv;
	}
public int getMax2(String selectwh, String waringcode) {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		int sv = CaptDao.getMax2(selectwh, waringcode); 
		close(con); // �ڿ� ����
		return sv;
	}
public int getMax3(String selectwh, String waringcode) {
	
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	
	
	int sv = CaptDao.getMax3(selectwh, waringcode); 
	close(con); // �ڿ� ����
	return sv;
}
	public boolean updateWhStock(String waringcode, String itemcode,int warecount, int Defective_count) {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	

		boolean success = CaptDao.updateWhStock(waringcode,itemcode,warecount,Defective_count); 
		close(con);
		return success;
	}
	public boolean updateWhTempStock(String waringcode, String itemcode,int count) {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	

		boolean success = CaptDao.updateWhTempStock(waringcode,itemcode,count); 
		close(con);
		return success;
	}
	public boolean updateWhRefundStock(String waringcode, String itemcode,int count) {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	

		boolean success = CaptDao.updateWhRefundStock(waringcode,itemcode,count); 
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
