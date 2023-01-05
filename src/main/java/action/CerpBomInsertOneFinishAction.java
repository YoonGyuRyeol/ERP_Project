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
import vo.ActionForward;
import vo.BomS;
import vo.Item;
import vo.User;
import vo.client;

public class CerpBomInsertOneFinishAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id;
		int grade=0;
		User user = null;
		
		String bom_code = null;
		String itemcode = null;
		String itemname = null;
		
		int materials = 0;
		int redirect =0;
		boolean success = false;
		user = (User) session.getAttribute("loginuser");
		if(user != null) {
			materials=Integer.parseInt(request.getParameter("materials"));
			itemcode= request.getParameter("select");
			bom_code= request.getParameter("bom_code_hidden");
			System.out.println(user);
			id = user.getId();
			grade = user.getGrade();
			if(grade>=2) {
				CerpBomService logina= new CerpBomService();
				itemname = logina.selectItemNameOne(itemcode);
				success = logina.InsertBomStock(bom_code,itemcode,itemname,materials);
				
				
				if(success = true) {
					redirect=1;
					request.setAttribute("redirect", redirect);
					ActionForward forward = new ActionForward("bom_product_insert_one.jsp", false); //  
					return forward;
				}else {
					redirect=0;
					request.setAttribute("redirect", redirect);
					ActionForward forward = new ActionForward("bom_product_insert_one.jsp", false); //  
					return forward;
				}
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
