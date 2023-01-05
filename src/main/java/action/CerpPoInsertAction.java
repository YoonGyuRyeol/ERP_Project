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
import svc.CerpOrderService;
import svc.CerpPoService;
import vo.ActionForward;
import vo.Item;
import vo.Order;
import vo.St;
import vo.User;
import vo.client;

public class CerpPoInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id;
		int grade=0;
		User user = null;
		
		ArrayList<St> stList = new ArrayList<St>();
		ArrayList<St> stList2 = new ArrayList<St>();
		ArrayList<St> stList3 = new ArrayList<St>();
		user = (User) session.getAttribute("loginuser");
		if(user != null) {
			
		
			System.out.println(user);
	
			id = user.getId();
			grade = user.getGrade();
			if(grade>=2) {
				
				CerpPoService logina= new CerpPoService();
				stList = logina.getWareListStock();
				stList2 = logina.getWareListTemp();
				stList3 = logina.getWareListDefect();
				request.setAttribute("st", stList);
				request.setAttribute("st2", stList2);
				request.setAttribute("st3", stList3);
				logina.resetmrp();
				request.setAttribute("loginuser", user);
				
				ActionForward forward = new ActionForward("place_an_order_insert.jsp", false); //  
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
