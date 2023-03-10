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

public class CerpWhUpdateOneFinishAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id;
		int grade=0;
		User user = null;
		String waringcode = null;
		String itemcode = null;
		int redirect=0;
		int warecount = 0;
		int Defective_count =0;
		boolean success = false;
		user = (User) session.getAttribute("loginuser");
		if(user != null) {
			warecount=Integer.parseInt(request.getParameter("warecount"));
			Defective_count=Integer.parseInt(request.getParameter("defectivecount"));
			
			itemcode= request.getParameter("itemcode");
			waringcode= request.getParameter("waringcode");
			
			id = user.getId();
			grade = user.getGrade();
			if(grade>=2) {
				CerpWhService logina= new CerpWhService();
				success = logina.updateWhStock(waringcode,itemcode,warecount,Defective_count);
				
				
				if(success = true) {
					redirect=1;
					request.setAttribute("redirect", redirect);
					ActionForward forward = new ActionForward("warehousing_update_one.jsp", false); //  
					return forward;
				}else {
					redirect=0;
					request.setAttribute("redirect", redirect);
					ActionForward forward = new ActionForward("warehousing_update_one.jsp", false); //  
					return forward;
				}
			}
			request.setAttribute("loginuser", user);
			
			//  
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter w = response.getWriter();
	        w.write("<script>alert('?????? ??????????.');history.go(-1);</script>");
	        w.flush();
	        w.close();
	        ActionForward forward = new ActionForward("CerpHome.Capt", false); 
			return forward;
			
			
		}
		ActionForward forward = new ActionForward("UserLogin.jsp", false);
		return forward;
		
	}
	
}
