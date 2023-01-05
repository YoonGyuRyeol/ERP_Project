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
import svc.CerpStService;
import vo.ActionForward;

import vo.User;
import vo.client;

public class CerpStUpdateFinishAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id;
		int grade=0;
		User user = null;
		boolean success = false;
		int redirect=0;
		String warelike;
		String warename;
		String usecheck;
		String warecode;
		user = (User) session.getAttribute("loginuser");
		if(user != null) {
			warecode= request.getParameter("warecode");
			warename= request.getParameter("warename");
			warelike= request.getParameter("ware_sortation");
			usecheck= request.getParameter("use_sortation");
			
			System.out.println(user);
			id = user.getId();
			grade = user.getGrade();
			if(grade>=3) {
				CerpStService logina= new CerpStService();
				success = logina.UpdateSt(warecode,warename,warelike,usecheck);
				request.setAttribute("loginuser", user);
				if(success==true) {
					redirect=1;
					request.setAttribute("redirect", redirect);	
					ActionForward forward = new ActionForward("st_update_popup.jsp", false); //  
					return forward;
						
					
				}
				request.setAttribute("redirect", redirect);	
				ActionForward forward = new ActionForward("st_update_popup.jsp", false); //  
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
