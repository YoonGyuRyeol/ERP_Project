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

public class CerpPoInsertFinishAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id;
		int grade=0;
		User user = null;
		boolean success = false;
		String placecode;
		String warename;
		String ordercode;
		String tempname;
		String defectname;
		String ecode;
		String ename;
		int redirect = 0;
		int sv = 0;
		int total_amount = 0;
		String placeday;
		String placetime;
		String deliveryday;
		String deliverytime;
		
	
		user = (User) session.getAttribute("loginuser");
		if(user != null) {
			warename= request.getParameter("warehouse");
			tempname= request.getParameter("warehouse_t");
			defectname= request.getParameter("warehouse_d");
			ordercode= request.getParameter("ordercode");
			ecode= request.getParameter("ecode");
			ename= request.getParameter("name");
			placeday= request.getParameter("firstdate");
			deliveryday= request.getParameter("finaldate");
			placetime= request.getParameter("firsttime");
			deliverytime= request.getParameter("finaltime");
			int random = (int) (Math.random()*60);
			placeday= placeday+" "+placetime+":"+random;
			deliveryday= deliveryday+" "+deliverytime+":"+random;
			
			sv= Integer.parseInt(request.getParameter("sv").replaceAll(",", ""));
			total_amount= Integer.parseInt(request.getParameter("total_amount").replaceAll(",", ""));
		System.out.println(user);
			id = user.getId();
			grade = user.getGrade();
			if(grade>=2) {
				CerpPoService logina= new CerpPoService();
				success = logina.insertPo(warename,placeday,deliveryday,sv,total_amount,ecode,ename,ordercode); 
				success = logina.insertPost(ordercode,warename,tempname,defectname);
				request.setAttribute("loginuser", user);
				if(success==true) {
					redirect=1;
					request.setAttribute("redirect", redirect);	
				
					request.setAttribute("loginuser", user);
				
					ActionForward forward = new ActionForward("place_an_order_insert.jsp", false); //  
					return forward;
						
					
				}
				redirect=2;
				request.setAttribute("refresh", redirect);	
				
				ActionForward forward = new ActionForward("place_an_order_insert.jsp", false); //  
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
