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

public class CerpOrderUpdateFinishAction implements Action {

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
			ordercode= request.getParameter("ordercode");
			clientname= request.getParameter("clientname");
			itemname= request.getParameter("itemname");
			
			
			orderday= request.getParameter("orderday");
			delivery_day= request.getParameter("delivery_day");
			ordertime= request.getParameter("ordertime");
			delivery_time= request.getParameter("delivery_time");
			int random = (int) (Math.random()*60);
			orderday= orderday+" "+ordertime+":"+random;
			delivery_day= delivery_day+" "+delivery_time+":"+random;
			System.out.println(orderday);
			System.out.println(ordertime);
			System.out.println(orderday+" "+ordertime);
			forwarding_price= Integer.parseInt(request.getParameter("forwarding_price").replaceAll(",", ""));
			count= Integer.parseInt(request.getParameter("count").replaceAll(",", ""));
			total_amount= Integer.parseInt(request.getParameter("total_amount").replaceAll(",", ""));
			sv= Integer.parseInt(request.getParameter("sv").replaceAll(",", ""));
			ecode= request.getParameter("ecode");
			name= request.getParameter("name");
			
			System.out.println(user);
			id = user.getId();
			grade = user.getGrade();
			if(grade>=2) {
				CerpOrderService logina= new CerpOrderService();
				success = logina.UpdateOrder(ordercode,clientname,itemname,orderday,delivery_day,forwarding_price,count,total_amount,ecode,name,sv);
				request.setAttribute("loginuser", user);
				if(success==true) {
					redirect=1;
					System.out.println(redirect);
					request.setAttribute("redirect", redirect);	
					ActionForward forward = new ActionForward("order_update_popup.jsp", false); //  
					return forward;
						
					
				}
				redirect=0;
				request.setAttribute("redirect", redirect);	
				ActionForward forward = new ActionForward("order_update_popup.jsp", false); //  
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
