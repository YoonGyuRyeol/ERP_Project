package action;

import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import vo.ActionForward;
import vo.Food;
import vo.User;

public class CaptHomeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginuser");
		System.out.println(user);	
		if(user != null) {
			request.setAttribute("loginuser", user);
		}
		ActionForward forward = new ActionForward("home.jsp", false); //  
		
		return forward;
	}
	
}
