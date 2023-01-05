package action;

import java.io.PrintWriter;
import java.text.DecimalFormat;
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
import vo.Order2;
import vo.St;
import vo.User;
import vo.client;
import vo.po;
import vo.pos;
import vo.temp;

public class CerpPoMRPAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id;
		int grade=0;
		User user = null;
		ArrayList<temp> temp = null;
		Order2 order = null;
		int needhold = 0;
		String nh;
		String snh;
		int sneedhold = 0;
		String ordercode;
		ArrayList<St> stList = new ArrayList<St>();
		ArrayList<St> stList2 = new ArrayList<St>();
		ArrayList<St> stList3 = new ArrayList<St>();
		String itemname;
		String needholding;
		user = (User) session.getAttribute("loginuser");
		if(user != null) {
			DecimalFormat df = new DecimalFormat("###,###");
			ordercode= request.getParameter("ordercode");
			itemname= request.getParameter("itemname");
			needholding=request.getParameter("needholding");
			System.out.println(user);
			id = user.getId();
			grade = user.getGrade();
			if(grade>=2) {
				CerpPoService logina= new CerpPoService();
				temp = logina.getMRP(itemname,needholding);
				order = logina.getOrderOne(ordercode);
				needhold = logina.getsv(itemname, needholding);
				sneedhold =(int) (needhold * 1.1);
				nh = df.format(needhold);
				snh = df.format(sneedhold);
				request.setAttribute("temp", temp);
				request.setAttribute("order", order);
				request.setAttribute("sv", nh);
				request.setAttribute("total", snh);
				
				request.setAttribute("loginuser", user);
				stList = logina.getWareListStock();
				stList2 = logina.getWareListTemp();
				stList3 = logina.getWareListDefect();
				request.setAttribute("st", stList);
				request.setAttribute("st2", stList2);
				request.setAttribute("st3", stList3);
				ActionForward forward = new ActionForward("place_an_order_insert.jsp", false); //  
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
