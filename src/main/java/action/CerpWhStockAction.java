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
import svc.CerpWhService;
import vo.ActionForward;
import vo.BomS;
import vo.Item;
import vo.User;
import vo.client;
import vo.pos;
import vo.whs;

public class CerpWhStockAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id;
		int grade=0;
		User user = null;
		ArrayList<whs> whslist = null;
		whs whs2 = null;
	
	
		user = (User) session.getAttribute("loginuser");
		if(user != null) {
			
			String selectwhstock= request.getParameter("wh");
			System.out.println(user);
			id = user.getId();
			grade = user.getGrade();
			if(grade>=2) {
				CerpWhService logina= new CerpWhService();
				whslist = logina.getWhStockList(selectwhstock);
				whs2 = whslist.get(0);
				request.setAttribute("whs2", whs2);
				request.setAttribute("whs", whslist);
				request.setAttribute("loginuser", user);
				
				ActionForward forward = new ActionForward("warehousing_stock_select.jsp", false); //  
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
