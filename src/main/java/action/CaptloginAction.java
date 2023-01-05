package action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import svc.CaptloginSerivce;
import vo.ActionForward;
import vo.Food;
import vo.User;

public class CaptloginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		HttpSession Session = request.getSession();
		
		User user2 = null;
		String id1 = request.getParameter("id"); 
				String pwd = request.getParameter("psw"); // 
			
				CaptloginSerivce logina= new CaptloginSerivce();
				boolean success = logina.getlogincorrect(id1,pwd); //
				System.out.println(success);
				if(success == true) {
					user2 = logina.getUser(id1);
					
					System.out.println(user2);
					Session.setAttribute("loginuser", user2); 
					System.out.println(user2);
					
					ActionForward forward = new ActionForward("CerpHome.Capt", false);
					return forward;
				}else if(success == false){
					ActionForward forward = new ActionForward("UserLogin.jsp", false);
					return forward;
				}
				
				
				
			
			ActionForward forward = new ActionForward("UserLogin.jsp", false);
			return forward;
	}
	

}