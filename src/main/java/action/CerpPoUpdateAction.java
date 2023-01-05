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
import vo.Post;
import vo.St;
import vo.User;
import vo.client;
import vo.po;
import vo.pos;

public class CerpPoUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id;
		int grade=0;
		User user = null;
		ArrayList<pos> pos = null;
		po po = null;
		ArrayList<St> stList = new ArrayList<St>();
		ArrayList<St> stList2 = new ArrayList<St>();
		ArrayList<St> stList3 = new ArrayList<St>();
		String productname = null;
		String productcode = null;
		int productmaterials = 0;
		Post post = null;
		user = (User) session.getAttribute("loginuser");
		if(user != null) {
			
			String selectpostock= request.getParameter("select");
			System.out.println(user);
			id = user.getId();
			grade = user.getGrade();
			if(grade>=2) {
				CerpPoService logina= new CerpPoService();
				pos = logina.getPoStockList(selectpostock);
				po = logina.getPoOne(selectpostock);
				stList = logina.getWareListStock();
				stList2 = logina.getWareListTemp();
				stList3 = logina.getWareListDefect();
				post = logina.getPost(selectpostock);
				request.setAttribute("st", stList);
				request.setAttribute("post", post);
				request.setAttribute("st2", stList2);
				request.setAttribute("st3", stList3);
				request.setAttribute("po", po);
				request.setAttribute("pos", pos);
				request.setAttribute("loginuser", user);
				
				ActionForward forward = new ActionForward("place_an_order_update.jsp", false); //  
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
