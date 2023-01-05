package action;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.CerpBomService;
import svc.CerpClientService;
import svc.CerpClientService2;
import svc.CerpCompanyService;
import svc.CerpItemService;
import svc.CerpPoService;
import vo.ActionForward;
import vo.BomS;
import vo.User;
import vo.client;

public class CerpPoUpdateFinishAction implements Action {

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
		String placecode;
		String warehouse;
		String ecode;
		String ename;
		int redirect = 0;
		String placeday;
		String placetime;
		String deliveryday;
		String deliverytime;
		String tempware;
		String defectware;
		
	
		user = (User) session.getAttribute("loginuser");
		if(user != null) {
			warehouse= request.getParameter("warehouse");
			tempware= request.getParameter("warehouse_t");
			defectware= request.getParameter("warehouse_d");
			placecode= request.getParameter("placecode");
			ecode= request.getParameter("ecode");
			ename= request.getParameter("name");
			placeday= request.getParameter("firstdate");
			deliveryday= request.getParameter("finaldate");
			placetime= request.getParameter("firsttime");
			deliverytime= request.getParameter("finaltime");
			int random = (int) (Math.random()*60);
			placeday= placeday+" "+placetime+":"+random;
			deliveryday= deliveryday+" "+deliverytime+":"+random;
		System.out.println(user);
			id = user.getId();
			grade = user.getGrade();
			if(grade>=2) {
				CerpPoService logina= new CerpPoService();
				success = logina.updatePo(placecode,warehouse,placeday,deliveryday,ecode,ename);
				success = logina.updatePost(placecode,warehouse,tempware,defectware);
				request.setAttribute("loginuser", user);
				if(success==true) {
					redirect=1;
					request.setAttribute("redirect", redirect);	
				
					request.setAttribute("loginuser", user);
				
					ActionForward forward = new ActionForward("place_an_order_update.jsp", false); //  
					return forward;
						
					
				}
				redirect=2;
				request.setAttribute("refresh", redirect);	
				
				ActionForward forward = new ActionForward("place_an_order_update.jsp", false); //  
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
