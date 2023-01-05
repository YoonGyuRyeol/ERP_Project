package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import vo.Board;
import vo.Food;
import vo.User;
import vo.client;
import vo.company;
import dao.UnitedDAO;
public class CerpCompanyService {

	
	public User getUser(String id) {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
	
		User des = CaptDao.login(id);
		System.out.println("?œ ?? ë¡œë”©");
		close(con);
		return des;
	}
	public ArrayList<company> getcompanyList() {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<company> companyList = CaptDao.selectcompanyList(); 
		close(con); // ï¿½Ú¿ï¿½ ï¿½ï¿½ï¿½ï¿½
		return companyList;
	}
	public company getUpdateCompany() {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
	
		company updatecompany = CaptDao.selectupdatecompany(); 
		close(con);
		return updatecompany;
	}
public boolean UpdateCompany(String ccode, String cname, String representative, String type_of_business, String business_number, String contact, String representative_contact, String address, String representative_email) {
	Connection con = getConnection();
	UnitedDAO CaptDao = UnitedDAO.getInstance();
	CaptDao.setConnection(con);	

	boolean success = CaptDao.updateCompany(ccode, cname, representative, type_of_business, business_number, contact, representative_contact, address, representative_email); 
	close(con);
	return success;
}
}
