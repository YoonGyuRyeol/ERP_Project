package action;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import svc.CerpClientService;
import svc.CerpHoldingService;
import svc.CerpItemService;
import vo.ActionForward;
import vo.Holding;
import vo.Item;
import vo.User;
import vo.client;

public class CerpHoldingUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id;
		int grade=0;
		User user = null;
		Holding updateholding = null;
	
		user = (User) session.getAttribute("loginuser");
		if(user != null) {
			
			String updateholdingcode= request.getParameter("select");
			System.out.println(user);
			id = user.getId();
			grade = user.getGrade();
			if(grade>=2) {
				CerpHoldingService logina= new CerpHoldingService();
				updateholding = logina.getUpdateHolding(updateholdingcode);
				request.setAttribute("holding", updateholding);
				request.setAttribute("loginuser", user);
				
				ActionForward forward = new ActionForward("holding_update_popup.jsp", false); //  
				return forward;
			}
			request.setAttribute("loginuser", user);
			
			//  
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter w = response.getWriter();
	        w.write("<script>alert('������ �����մϴ�.');history.go(-1);</script>");
	        w.flush();
	        w.close();
	        ActionForward forward = new ActionForward("CerpHome.Capt", false); 
			return forward;
			
			
		}
		ActionForward forward = new ActionForward("UserLogin.jsp", false);
		return forward;
		
	}
	
}
