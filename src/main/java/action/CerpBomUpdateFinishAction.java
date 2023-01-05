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
import vo.ActionForward;
import vo.BomS;
import vo.User;
import vo.client;

public class CerpBomUpdateFinishAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id;
		int grade=0;
		User user = null;
		boolean success = false;
		String itemcode;
		String itemname;
		String bom_code;
		int redirect = 0;
		ArrayList<BomS> boms = null;
		BomS boms2 = null;
		String productname = null;
		String productcode = null;
		int productmaterials = 0;
		user = (User) session.getAttribute("loginuser");
		if(user != null) {
			itemcode= request.getParameter("select");
			bom_code= request.getParameter("bom_code_hidden");
			
		System.out.println(user);
			id = user.getId();
			grade = user.getGrade();
			if(grade>=2) {
				CerpBomService logina= new CerpBomService();
				success = logina.DeleteFromStock(bom_code,itemcode);
				request.setAttribute("loginuser", user);
				if(success==true) {
					redirect=1;
					request.setAttribute("refresh", redirect);	
					boms = logina.getBomStockList(bom_code);
					boms2 = boms.get(0);
					productmaterials = boms.size();
					request.setAttribute("bom_p", boms2);
					request.setAttribute("bom_stock", boms);
					request.setAttribute("loginuser", user);
					request.setAttribute("materials", productmaterials);
					ActionForward forward = new ActionForward("bom_product_update.jsp", false); //  
					return forward;
						
					
				}
				redirect=2;
				request.setAttribute("refresh", redirect);	
				
				ActionForward forward = new ActionForward("bom_product_update.jsp", false); //  
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
