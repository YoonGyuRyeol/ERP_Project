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
import svc.CerpLogStatusService;
import vo.ActionForward;
import vo.Holding;
import vo.IL;
import vo.Item;
import vo.LogStatus;
import vo.St;
import vo.User;
import vo.client;

public class CerpLogSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id;
		int grade=0;
		User user = null;
		String searchLike2 = null;
		ArrayList<St> stList = new ArrayList<St>();
		ArrayList<IL> ilList = new ArrayList<IL>();
		ArrayList<LogStatus> LogList = new ArrayList<LogStatus>();
		user = (User) session.getAttribute("loginuser");
		if(user != null) {
			
			String searchoption= request.getParameter("item");
			String firstdate= request.getParameter("firstdate");
			String firstdate2= request.getParameter("firstdate2");
			String searchLike= request.getParameter("Like");
			searchLike2= request.getParameter("Like2");
			String searchorder= request.getParameter("Order");
			String searchvalue= request.getParameter("search");
			System.out.println(user);
			id = user.getId();
			grade = user.getGrade();
			if(grade>=2) {
				CerpLogStatusService logina= new CerpLogStatusService();
				CerpItemService logina2= new CerpItemService();
				stList = logina.getWareList();
				ilList = logina2.getILList();
				LogList = logina.getLogSearchList(searchoption,firstdate,firstdate2,searchLike,searchLike2,searchorder,searchvalue);
				request.setAttribute("st", stList);
				request.setAttribute("log", LogList);
				request.setAttribute("loginuser", user);
				request.setAttribute("il", ilList);
				ActionForward forward = new ActionForward("log_status.jsp", false); //  
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
