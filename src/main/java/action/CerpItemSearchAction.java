package action;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import svc.CerpClientService;
import svc.CerpItemService;
import vo.ActionForward;
import vo.IL;
import vo.Item;
import vo.User;
import vo.client;

public class CerpItemSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id;
		int grade=0;
		User user = null;
		String searchLike2 = null;
		ArrayList<Item> itemList = new ArrayList<Item>();
		ArrayList<IL> ilList = new ArrayList<IL>();
		user = (User) session.getAttribute("loginuser");
		if(user != null) {
			
			String searchoption= request.getParameter("item");
			String searchLike= request.getParameter("Like");
			searchLike2= request.getParameter("Like2");
			String searchorder= request.getParameter("Order");
			String searchvalue= request.getParameter("search");
			System.out.println(user);
			id = user.getId();
			grade = user.getGrade();
			if(grade>=3) {
				CerpItemService logina= new CerpItemService();
				itemList = logina.getItemSearchList(searchoption,searchLike,searchLike2,searchorder,searchvalue);
				ilList = logina.getILList();
				request.setAttribute("item", itemList);
				request.setAttribute("loginuser", user);
				request.setAttribute("il", ilList);
				ActionForward forward = new ActionForward("Item_base.jsp", false); //  
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
