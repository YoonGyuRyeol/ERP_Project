package action;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.xdevapi.Client;

import svc.CerpBomService;
import svc.CerpClientService;
import svc.CerpHoldingService;
import svc.CerpItemService;
import svc.CerpOrderService;
import svc.CerpPoService;
import vo.ActionForward;
import vo.BomS;
import vo.Item;
import vo.Order;
import vo.Order2;
import vo.User;
import vo.client;
import vo.employee;

public class CerpOrderPlaceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id;
		int grade=0;
		User user = null;
		ArrayList<Order2> orderList = new ArrayList<Order2>();
		
	
		user = (User) session.getAttribute("loginuser");
		if(user != null) {
			
			
			System.out.println(user);
			id = user.getId();
			grade = user.getGrade();
			if(grade>=2) {
				CerpPoService logina= new CerpPoService();			
				orderList = logina.getOrderList();
				
				
				request.setAttribute("order", orderList);
				request.setAttribute("loginuser", user);
		
				ActionForward forward = new ActionForward("orderlist_popup.jsp", false); //  
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
