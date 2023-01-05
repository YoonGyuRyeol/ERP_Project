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

public class CerpBomUpdateOneAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id;
		int grade=0;
		User user = null;
		ArrayList<Item> itemList = new ArrayList<Item>();
		String productname = null;
		String productcode = null;
		String bom_code = null;
		String itemcode = null;
		String itemname = null;
		int materials = 0;
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
				itemname = logina.selectItemNameOne(itemcode);
				materials = logina.selectMaterials(bom_code,itemcode);
				itemList = logina.getItemNotInList(bom_code,itemcode);
				
				
				request.setAttribute("item", itemList);
				request.setAttribute("bom_code", bom_code);
				request.setAttribute("loginuser", user);
				request.setAttribute("materials", materials);
				request.setAttribute("itemcode", itemcode);
				request.setAttribute("itemname", itemname);
				ActionForward forward = new ActionForward("bom_product_update_one.jsp", false); //  
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
