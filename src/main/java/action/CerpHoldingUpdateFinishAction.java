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
import svc.CerpHoldingService;
import svc.CerpItemService;
import vo.ActionForward;

import vo.User;
import vo.client;

public class CerpHoldingUpdateFinishAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id;
		int grade=0;
		User user = null;
		boolean success = false;
		String itemcode;
		String itemname;
		int receiving_price;
		int  acount;
		String warename;
		
		int redirect = 0;
		user = (User) session.getAttribute("loginuser");
		if(user != null) {
			itemcode= request.getParameter("itemcode");
			itemname= request.getParameter("itemname");
			receiving_price= Integer.parseInt(request.getParameter("receiving_price").replaceAll(",", ""));
			acount= Integer.parseInt(request.getParameter("acount"));
			warename= request.getParameter("warename");
			
			System.out.println(user);
			id = user.getId();
			grade = user.getGrade();
			if(grade>=2) {
				CerpHoldingService logina= new CerpHoldingService();
				success = logina.UpdateHolding(itemcode,itemname,receiving_price, acount, warename);
				request.setAttribute("loginuser", user);
				if(success==true) {
					redirect=1;
					request.setAttribute("redirect", redirect);	
					ActionForward forward = new ActionForward("holding_update_popup.jsp", false); //  
					return forward;
						
					
				}
				request.setAttribute("redirect", redirect);	
				ActionForward forward = new ActionForward("holding_update_popup.jsp", false); //  
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
