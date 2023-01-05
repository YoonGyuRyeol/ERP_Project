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
import svc.CerpPoService;
import vo.ActionForward;
import vo.Item;
import vo.Order;
import vo.Order3;
import vo.Order4;
import vo.User;
import vo.client;

public class CerpPOTaxbillAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id;
		int grade=0;
		User user = null;
		Order4 potaxbillorder = null;
		boolean success = true;
		user = (User) session.getAttribute("loginuser");
		if(user != null) {
			
			String placecode= request.getParameter("select");
			System.out.println(user);
			System.out.println(placecode);
			System.out.println("cerppotaxbillaction 1");
			id = user.getId();
			grade = user.getGrade();
			if(grade>=2) {
				CerpPoService logina= new CerpPoService();
				if(success==true) {
				potaxbillorder = logina.SVPOTaxbillorder(placecode);
				request.setAttribute("order", potaxbillorder);
				request.setAttribute("loginuser", user);
				System.out.println("cerppotaxbillaction success==true");
				
				ActionForward forward = new ActionForward("place_an_order_taxbill_popup.jsp", false); //  
				return forward;
				}else {
					System.out.println("오류 1234");
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter w = response.getWriter();
			        w.write("<script>alert('오류.');history.go(-1);</script>");
			        w.flush();
			        w.close();
			        ActionForward forward = new ActionForward("CerpPo.Capt", false); 
					return forward;
				}
				
			}
			request.setAttribute("loginuser", user);
			
			//  
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter w = response.getWriter();
	        w.write("<script>alert('占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쌌니댐옙.');history.go(-1);</script>");
	        w.flush();
	        w.close();
	        ActionForward forward = new ActionForward("CerpHome.Capt", false); 
			return forward;
			
			
		}
		ActionForward forward = new ActionForward("UserLogin.jsp", false);
		return forward;
		
	}
	
}
