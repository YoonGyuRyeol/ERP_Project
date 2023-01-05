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
import vo.User;
import vo.client;
import vo.po;

public class CerpPoSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id;
		int grade=0;
		User user = null;
		
		ArrayList<po> poList = new ArrayList<po>();
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
				CerpPoService logina= new CerpPoService();
				poList = logina.getPoSearchList(searchoption,firstdate,finaldate,progress,searchvalue,firstdate2,finaldate2);
				request.setAttribute("po", poList);
				request.setAttribute("loginuser", user);
				ActionForward forward = new ActionForward("place_an_order_base.jsp", false); //  
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
