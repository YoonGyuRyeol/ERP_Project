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
import vo.po;
import vo.pos;

public class CerpPoUpdateOneAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id;
		int grade=0;
		User user = null;
		pos pos = null;
		po po = null;
		String productname = null;
		String productcode = null;
		int productmaterials = 0;
	
		user = (User) session.getAttribute("loginuser");
		if(user != null) {
			
			String selectpostock= request.getParameter("select");
			String placecode= request.getParameter("place_code_hidden");
			System.out.println(user);
			id = user.getId();
			grade = user.getGrade();
			if(grade>=2) {
				CerpPoService logina= new CerpPoService();
				pos = logina.getPoStockOne(selectpostock,placecode);
				
				
			
				request.setAttribute("pos", pos);
				request.setAttribute("loginuser", user);
				
				ActionForward forward = new ActionForward("place_an_order_update_one.jsp", false); //  
				return forward;
			}
			request.setAttribute("loginuser", user);
			
			//  
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter w = response.getWriter();
	        w.write("<script>alert('������ �����մϴ�.');history.go(-1);</script>");
	        w.flush();
	        w.close();
	        ActionForward forward = new ActionForward("CerpHome.Capt", false); 
			return forward;
			
			
		}
		ActionForward forward = new ActionForward("UserLogin.jsp", false);
		return forward;
		
	}
	
}
