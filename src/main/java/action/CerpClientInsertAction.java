package action;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.CaptsqlChal4submitService;
import svc.CerpClientService;
import vo.ActionForward;
import vo.Board;
import vo.Food;
import vo.User;
import vo.client;

public class CerpClientInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id;
		int grade=0;
		User user = null;
	
		user = (User) session.getAttribute("loginuser");
		if(user != null) {
			
			System.out.println(user);
			id = user.getId();
			grade = user.getGrade();
			if(grade>=3) {
				
				request.setAttribute("loginuser", user);
				
				ActionForward forward = new ActionForward("client_insert_popup.jsp", false); //  
				return forward;
			}
			request.setAttribute("loginuser", user);
			
			//  
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter w = response.getWriter();
	        w.write("<script>alert('권한이 부족합니다.');history.go(-1);</script>");
	        w.flush();
	        w.close();
	        ActionForward forward = new ActionForward("CerpHome.Capt", false); 
			return forward;
			
			
		}
		ActionForward forward = new ActionForward("UserLogin.jsp", false);
		return forward;
		
	}
	
}
