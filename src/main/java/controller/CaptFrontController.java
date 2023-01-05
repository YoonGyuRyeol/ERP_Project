package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;


//import action.DogCartSearchAction;
import action.CaptHomeAction;



import action.CaptloginAction;
import action.CaptlogoutAction;


import action.CerpBaseListAction;
import action.CerpBomAction;
import action.CerpBomBaseInsertAction;
import action.CerpBomBaseInsertFinishAction;
import action.CerpBomInsertOneAction;
import action.CerpBomInsertOneFinishAction;
import action.CerpBomStockAction;
import action.CerpBomUpdateAction;
import action.CerpBomUpdateFinishAction;
import action.CerpBomUpdateOneAction;
import action.CerpBomUpdateOneFinishAction;
import action.CerpClientAction;
import action.CerpClientInsertAction;
import action.CerpClientInsertFinishAction;
import action.CerpClientSearchAction;
import action.CerpClientUpdateAction;
import action.CerpClientUpdateFinishAction;
import action.CerpCompanyAction;
import action.CerpCompanyUpdateAction;
import action.CerpCompanyUpdateFinishAction;
import action.CerpHoldingAction;
import action.CerpHoldingInsertAction;
import action.CerpHoldingInsertFinishAction;
import action.CerpHoldingSearchAction;
import action.CerpHoldingUpdateAction;
import action.CerpHoldingUpdateFinishAction;
import action.CerpILAction;
import action.CerpILInsertFinishAction;
import action.CerpItemAction;
import action.CerpItemInsertAction;
import action.CerpItemInsertFinishAction;
import action.CerpItemSearchAction;
import action.CerpItemUpdateAction;
import action.CerpItemUpdateFinishAction;
import action.CerpLogSearchAction;
import action.CerpLogStatusAction;
import action.CerpOrderAction;
import action.CerpOrderClientAction;
import action.CerpOrderEmployeeAction;
import action.CerpOrderFinishAction;
import action.CerpOrderInsertAction;
import action.CerpOrderInsertFinishAction;
import action.CerpOrderItemAction;
import action.CerpOrderPlaceAction;
import action.CerpOrderSearchAction;
import action.CerpOrderTaxbillAction;
import action.CerpOrderUpdateAction;
import action.CerpOrderUpdateFinishAction;
import action.CerpPOTaxbillAction;
import action.CerpPoAction;
import action.CerpPoInsertAction;
import action.CerpPoInsertFinishAction;
import action.CerpPoMRPAction;
import action.CerpPoSearchAction;
import action.CerpPoStockAction;
import action.CerpPoTempUpdateOneAction;
import action.CerpPoTempUpdateOneFinishAction;
import action.CerpPoUpdateAction;
import action.CerpPoUpdateFinishAction;
import action.CerpPoUpdateOneAction;
import action.CerpPoUpdateOneFinishAction;
import action.CerpStAction;
import action.CerpStInsertAction;
import action.CerpStInsertFinishAction;
import action.CerpStSearchAction;
import action.CerpStUpdateAction;
import action.CerpStUpdateFinishAction;
import action.CerpWhAction;
import action.CerpWhRefundTempUpdateOneAction;
import action.CerpWhRefundTempUpdateOneFinishAction;
import action.CerpWhRefundUpdateOneAction;
import action.CerpWhRefundUpdateOneFinishAction;
import action.CerpWhSearchAction;
import action.CerpWhStockAction;
import action.CerpWhTempUpdateOneAction;
import action.CerpWhTempUpdateOneFinishAction;
import action.CerpWhUpdateAction;
import action.CerpWhUpdateOneAction;
import action.CerpWhUpdateOneFinishAction;
import vo.ActionForward;

@WebServlet("*.Capt")
public class CaptFrontController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String command = request.getServletPath();		
		
				
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("/CerpHome.Capt")){
			action = new CaptHomeAction();
			try {
				forward = action.execute(request, response); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/Cerplogin.Capt")){
			action = new CaptloginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/Captlogout.Capt")){
			action = new CaptlogoutAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/CerpBase.Capt")) {
			action = new CerpBaseListAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpClient.Capt")) {
			action = new CerpClientAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpClientSearch.Capt")) {
			action = new CerpClientSearchAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpClientUpdate.Capt")) {
			action = new CerpClientUpdateAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpClientUpdateFinish.Capt")) {
			action = new CerpClientUpdateFinishAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpClientInsert.Capt")) {
			action = new CerpClientInsertAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpClientInsertFinish.Capt")) {
			action = new CerpClientInsertFinishAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpCompany.Capt")) {
			action = new CerpCompanyAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpCompanyUpdate.Capt")) {
			action = new CerpCompanyUpdateAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpCompanyUpdateFinish.Capt")) {
			action = new CerpCompanyUpdateFinishAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpItem.Capt")) {
			action = new CerpItemAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpItemSearch.Capt")) {
			action = new CerpItemSearchAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpItemUpdate.Capt")) {
			action = new CerpItemUpdateAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpItemUpdateFinish.Capt")) {
			action = new CerpItemUpdateFinishAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpItemInsert.Capt")) {
			action = new CerpItemInsertAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpItemInsertFinish.Capt")) {
			action = new CerpItemInsertFinishAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpBom.Capt")) {
			action = new CerpBomAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpBomStock.Capt")) {
			action = new CerpBomStockAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpBomUpdate.Capt")) {
			action = new CerpBomUpdateAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpBomUpdateFinish.Capt")) {
			action = new CerpBomUpdateFinishAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpBomUpdateOne.Capt")) {
			action = new CerpBomUpdateOneAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpBomUpdateOneFinish.Capt")) {
			action = new CerpBomUpdateOneFinishAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpBomInsertOne.Capt")) {
			action = new CerpBomInsertOneAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpBomInsertOneFinish.Capt")) {
			action = new CerpBomInsertOneFinishAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpBomBaseInsert.Capt")) {
			action = new CerpBomBaseInsertAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpBomBaseInsertFinish.Capt")) {
			action = new CerpBomBaseInsertFinishAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpHolding.Capt")) {
			action = new CerpHoldingAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpHoldingSearch.Capt")) {
			action = new CerpHoldingSearchAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpHoldingUpdate.Capt")) {
			action = new CerpHoldingUpdateAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpHoldingUpdateFinish.Capt")) {
			action = new CerpHoldingUpdateFinishAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpHoldingInsert.Capt")) {
			action = new CerpHoldingInsertAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpHoldingInsertFinish.Capt")) {
			action = new CerpHoldingInsertFinishAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpOrder.Capt")) {
			action = new CerpOrderAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpOrderSearch.Capt")) {
			action = new CerpOrderSearchAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpOrderUpdate.Capt")) {
			action = new CerpOrderUpdateAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpOrderClient.Capt")) {
			action = new CerpOrderClientAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpOrderItem.Capt")) {
			action = new CerpOrderItemAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpOrderEmployee.Capt")) {
			action = new CerpOrderEmployeeAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpOrderUpdateFinish.Capt")) {
			action = new CerpOrderUpdateFinishAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpOrderInsert.Capt")) {
			action = new CerpOrderInsertAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpOrderInsertFinish.Capt")) {
			action = new CerpOrderInsertFinishAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpPo.Capt")) {
			action = new CerpPoAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpPoStock.Capt")) {
			action = new CerpPoStockAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpPoUpdate.Capt")) {
			action = new CerpPoUpdateAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpPoUpdateOne.Capt")) {
			action = new CerpPoUpdateOneAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpPoUpdateOneFinish.Capt")) {
			action = new CerpPoUpdateOneFinishAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpPoUpdateFinish.Capt")) {
			action = new CerpPoUpdateFinishAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpPoInsert.Capt")) {
			action = new CerpPoInsertAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpOrderPlace.Capt")) {
			action = new CerpOrderPlaceAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpPoMRP.Capt")) {
			action = new CerpPoMRPAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpPoTempUpdateOne.Capt")) {
			action = new CerpPoTempUpdateOneAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpPoTempUpdateOneFinish.Capt")) {
			action = new CerpPoTempUpdateOneFinishAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpPoInsertFinish.Capt")) {
			action = new CerpPoInsertFinishAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpWh.Capt")) {
			action = new CerpWhAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpWhStock.Capt")) {
			action = new CerpWhStockAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpWhUpdate.Capt")) {
			action = new CerpWhUpdateAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpWhUpdateOne.Capt")) {
			action = new CerpWhUpdateOneAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpWhUpdateOneFinish.Capt")) {
			action = new CerpWhUpdateOneFinishAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpWhTempUpdateOne.Capt")) {
			action = new CerpWhTempUpdateOneAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpWhTempUpdateOneFinish.Capt")) {
			action = new CerpWhTempUpdateOneFinishAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpWhRefundUpdateOne.Capt")) {
			action = new CerpWhRefundUpdateOneAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpWhRefundUpdateOneFinish.Capt")) {
			action = new CerpWhRefundUpdateOneFinishAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpSt.Capt")) {
			action = new CerpStAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpStUpdate.Capt")) {
			action = new CerpStUpdateAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpStUpdateFinish.Capt")) {
			action = new CerpStUpdateFinishAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpStInsert.Capt")) {
			action = new CerpStInsertAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpStInsertFinish.Capt")) {
			action = new CerpStInsertFinishAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpIL.Capt")) {
			action = new CerpILAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpILInsertFinish.Capt")) {
			action = new CerpILInsertFinishAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpWhRefundTempUpdateOne.Capt")) {
			action = new CerpWhRefundTempUpdateOneAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpWhRefundTempUpdateOneFinish.Capt")) {
			action = new CerpWhRefundTempUpdateOneFinishAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpOrderTaxbill.Capt")) {
			action = new CerpOrderTaxbillAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpPoSearch.Capt")) {
			action = new CerpPoSearchAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpWhSearch.Capt")) {
			action = new CerpWhSearchAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpStSearch.Capt")) {
			action = new CerpStSearchAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpOrderFinish.Capt")) {
			action = new CerpOrderFinishAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpPOTaxbill.Capt")) {
			action = new CerpPOTaxbillAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpLogStatus.Capt")) {
			action = new CerpLogStatusAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}else if(command.equals("/CerpLogSearch.Capt")) {
			action = new CerpLogSearchAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}
		
		
		
		
		
		if(forward !=null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
				
			}
		}
		
	}
	
}
