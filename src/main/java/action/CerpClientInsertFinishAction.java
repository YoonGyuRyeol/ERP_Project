package action;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.CaptsqlChal4submitService;
import svc.CerpClientService;
import svc.CerpClientService2;
import vo.ActionForward;
import vo.Board;
import vo.Food;
import vo.User;
import vo.client;

public class CerpClientInsertFinishAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id;
		int grade=0;
		User user = null;
		boolean success = false;
		String like;
		String clientname;
		String representative;
		String type_of_business;
		String business_number;
		String contact;
		String representative_contact;
		String address;
		String representative_email;
		int redirect = 0;
		user = (User) session.getAttribute("loginuser");
		if(user != null) {
			like= request.getParameter("buy");
			clientname= request.getParameter("clientname");
			representative= request.getParameter("representative");
			type_of_business= request.getParameter("type_of_business");
			business_number= request.getParameter("business_number");
			contact= request.getParameter("contact");
			representative_contact= request.getParameter("representative_contact");
			address= request.getParameter("address");
			representative_email= request.getParameter("representative_email");
			
			System.out.println(user);
			id = user.getId();
			grade = user.getGrade();
			if(grade>=3) {
				CerpClientService2 logina= new CerpClientService2();
				success = logina.InsertClient(like,clientname,representative, type_of_business, business_number, contact, representative_contact, address, representative_email);
				request.setAttribute("loginuser", user);
				if(success==true) {
					redirect=1;
					request.setAttribute("redirect", redirect);	
					ActionForward forward = new ActionForward("client_insert_popup.jsp", false); //  
					return forward;
						
					
				}
				request.setAttribute("redirect", redirect);	
				ActionForward forward = new ActionForward("client_insert_popup.jsp", false); //  
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
