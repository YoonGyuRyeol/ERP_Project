package action;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import svc.CerpClientService;
import svc.CerpHoldingService;
import svc.CerpItemService;
import vo.ActionForward;
import vo.Holding;
import vo.IL;
import vo.Item;
import vo.St;
import vo.User;
import vo.client;

public class CerpHoldingAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id;
		int grade=0;
		User user = null;
		ArrayList<Holding> holdingList = new ArrayList<Holding>();
		ArrayList<St> stList = new ArrayList<St>();
		ArrayList<IL> ilList = new ArrayList<IL>();
		user = (User) session.getAttribute("loginuser");
		if(user != null) {
			
			
			System.out.println(user);
			id = user.getId();
			grade = user.getGrade();
			if(grade>=2) {
				CerpHoldingService logina= new CerpHoldingService();
				CerpItemService logina2= new CerpItemService();
				holdingList = logina.getHoldingList();
				stList = logina.getWareList();
				ilList = logina2.getILList();
				request.setAttribute("st", stList);
				request.setAttribute("holding", holdingList);
				request.setAttribute("loginuser", user);
				request.setAttribute("il", ilList);
				ActionForward forward = new ActionForward("holding_info.jsp", false); //  
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
