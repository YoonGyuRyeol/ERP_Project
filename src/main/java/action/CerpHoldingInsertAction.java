package action;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.CerpBomService;
import svc.CerpClientService;
import svc.CerpHoldingService;
import svc.CerpItemService;
import vo.ActionForward;
import vo.BomS;
import vo.Item;
import vo.St;
import vo.User;
import vo.client;

public class CerpHoldingInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id;
		int grade=0;
		User user = null;
		ArrayList<Item> itemList = new ArrayList<Item>();
		ArrayList<St> stList = new ArrayList<St>();
		String warename = null;
		String itemcode = null;
		String itemname = null;
		int materials = 0;
		int productmaterials = 0;
	
		user = (User) session.getAttribute("loginuser");
		if(user != null) {
			
			
			System.out.println(user);
			id = user.getId();
			grade = user.getGrade();
			if(grade>=2) {
				CerpHoldingService logina= new CerpHoldingService();			
				itemList = logina.getProductNotInList();
				stList = logina.getWareList2();
				
				request.setAttribute("item", itemList);
				request.setAttribute("loginuser", user);
				request.setAttribute("st", stList);
				ActionForward forward = new ActionForward("holding_insert_popup.jsp", false); //  
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
