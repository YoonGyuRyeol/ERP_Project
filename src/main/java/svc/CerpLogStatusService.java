package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import vo.Holding;
import vo.Item;
import vo.LogStatus;
import vo.St;
import vo.User;
import vo.client;
import dao.UnitedDAO;
public class CerpLogStatusService {

	
	public User getUser(String id) {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
	
		User des = CaptDao.login(id);
		System.out.println("로그인");
		close(con);
		return des;
	}
	public ArrayList<LogStatus> getLogList() {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<LogStatus> LogList = CaptDao.selectLogList(); 
		close(con); // 재고증감량 테이블 확인
		return LogList;
	}
	
	public ArrayList<LogStatus> getLogSearchList(String searchoption,String firstdate,String firstdate2,String searchLike,String searchLike2,String searchorder,String searchvalue) {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<LogStatus> LogList = CaptDao.selectLogSearchList(searchoption,firstdate,firstdate2,searchLike,searchLike2,searchorder,searchvalue); 
		close(con); // 재고증감량 테이블 검색
		return LogList;
	}

	public ArrayList<St> getWareList() {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<St> stList = CaptDao.selectStList2(); 
		close(con);
		return stList;
	}
	public ArrayList<St> getWareList2() {
		
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		
		ArrayList<St> stList = CaptDao.selectStList3(); 
		close(con);
		return stList;
	}

}
