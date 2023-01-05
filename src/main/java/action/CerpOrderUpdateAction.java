package action;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import svc.CerpClientService;
import svc.CerpItemService;
import svc.CerpOrderService;
import vo.ActionForward;
import vo.Item;
import vo.Order;
import vo.User;
import vo.client;

public class CerpOrderUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id;
		int grade=0;
		User user = null;
		Order updateorder = null;
		boolean success = true;
		user = (User) session.getAttribute("loginuser");
		if(user != null) {
			
			String updateordercode= request.getParameter("select");
			System.out.println(user);
			System.out.println(updateordercode);
			id = user.getId();
			grade = user.getGrade();
			if(grade>=2) {
				CerpOrderService logina= new CerpOrderService();
				if(success==true) {
				updateorder = logina.getUpdateOrder(updateordercode);
				success = logina.checkOrder(updateordercode);
				request.setAttribute("order", updateorder);
				request.setAttribute("loginuser", user);
				
				ActionForward forward = new ActionForward("order_update_popup.jsp", false); //  
				return forward;
				}else {
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter w = response.getWriter();
			        w.write("<script>alert('권한이 부족합니다.');history.go(-1);</script>");
			        w.flush();
			        w.close();
			        ActionForward forward = new ActionForward("CerpOrder.Capt", false); 
					return forward;
				}
				
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
