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

public class CerpOrderSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id;
		int grade=0;
		User user = null;
		
		ArrayList<Order> orderList = new ArrayList<Order>();
		user = (User) session.getAttribute("loginuser");
		if(user != null) {
			
			String searchoption= request.getParameter("item");
			String firstdate= request.getParameter("firstdate");
			String finaldate= request.getParameter("finaldate");
			String firstdate2= request.getParameter("firstdate2");
			String finaldate2= request.getParameter("finaldate2");
			String progress= request.getParameter("Progress");
			String searchvalue= request.getParameter("search");
			System.out.println(user);
			id = user.getId();
			grade = user.getGrade();
			if(grade>=2) {
				CerpOrderService logina= new CerpOrderService();
				orderList = logina.getOrderSearchList(searchoption,firstdate,finaldate,progress,searchvalue,firstdate2,finaldate2);
				request.setAttribute("order", orderList);
				request.setAttribute("loginuser", user);
				ActionForward forward = new ActionForward("order_info.jsp", false); //  
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
