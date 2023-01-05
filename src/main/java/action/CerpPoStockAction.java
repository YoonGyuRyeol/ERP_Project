package action;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.CerpBomService;
import svc.CerpClientService;
import svc.CerpItemService;
import svc.CerpPoService;
import vo.ActionForward;
import vo.BomS;
import vo.Item;
import vo.User;
import vo.client;
import vo.pos;

public class CerpPoStockAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id;
		int grade=0;
		User user = null;
		ArrayList<pos> poslist = null;
		pos pos2 = null;
		String productname = null;
		String productcode = null;
	
		user = (User) session.getAttribute("loginuser");
		if(user != null) {
			
			String selectpostock= request.getParameter("po");
			System.out.println(user);
			id = user.getId();
			grade = user.getGrade();
			if(grade>=2) {
				CerpPoService logina= new CerpPoService();
				poslist = logina.getPoStockList(selectpostock);
				pos2 = poslist.get(0);
				request.setAttribute("pos2", pos2);
				request.setAttribute("pos", poslist);
				request.setAttribute("loginuser", user);
				
				ActionForward forward = new ActionForward("place_an_order_stock_select.jsp", false); //  
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
