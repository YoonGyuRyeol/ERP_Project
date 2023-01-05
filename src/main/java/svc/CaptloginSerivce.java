package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import vo.Food;
import vo.User;
import dao.UnitedDAO;
public class CaptloginSerivce {

	public boolean getlogincorrect(String id, String pwd) {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
		boolean success = false;
		
		success = CaptDao.logincorrect(id,pwd);
		System.out.println("로그인 비번 대조");
		close(con);
		return success;
	}
	public User getUser(String id) {
		Connection con = getConnection();
		UnitedDAO CaptDao = UnitedDAO.getInstance();
		CaptDao.setConnection(con);	
	
		User des = CaptDao.login(id);
		System.out.println("유저 로딩");
		close(con);
		return des;
	}
	
}
