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

public class CaptlogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		HttpSession Session = request.getSession();
		Session.invalidate();
		ActionForward forward = new ActionForward("CerpHome.Capt", false);
		return forward;
	
	}
}