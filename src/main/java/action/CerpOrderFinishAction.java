package action;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import svc.CerpClientService;
import svc.CerpClientService2;
import svc.CerpCompanyService;
import svc.CerpItemService;
import svc.CerpOrderService;
import vo.ActionForward;

import vo.User;
import vo.client;

public class CerpOrderFinishAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id;
		int grade=0;
		User user = null;
		boolean success = false;
		String ordercode;
		String clientname;
		String itemname;
		String orderday;
		String delivery_day;
		String ordertime="00:00";
		String delivery_time ="00:00";
		
		int forwarding_price;
		int count;
		int total_amount;
		int sv;
		String ecode;
		String name;
		
		int redirect = 0;
		user = (User) session.getAttribute("loginuser");
		if(user != null) {
			ordercode= request.getParameter("select");
			
			
			System.out.println(user);
			id = user.getId();
			grade = user.getGrade();
			if(grade>=2) {
				CerpOrderService logina= new CerpOrderService();
				success = logina.CheckFinishOrder(ordercode);
				System.out.println(success+"아니");
				
				if(success==true) {
				success = logina.finishOrder(ordercode);
				request.setAttribute("loginuser", user);
				System.out.println(success+"아니2");
					if(success==true) {
					redirect=2;
					System.out.println(success+"아니3");
					System.out.println(redirect);
					request.setAttribute("redirect", redirect);	
					ActionForward forward = new ActionForward("order_info.jsp", false); //  
					return forward;
						
					
					}
					redirect=0;
					request.setAttribute("redirect", redirect);	
					ActionForward forward = new ActionForward("order_info.jsp", false); //  
					return forward;
				}
				redirect=2;
				request.setAttribute("redirect", redirect);	
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter w = response.getWriter();
		        w.write("<script>alert('입고 완료 된 건에 대해서만 출고 처리가 가능합니다.');window.opener.location.reload();\r\n"
		        		+ "window.close();</script>");
		        w.flush();
		        w.close();
		        ActionForward forward = new ActionForward("order_info.jsp", false); 
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
