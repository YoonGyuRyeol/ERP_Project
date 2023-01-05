<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" href="mainpop.css">



<style>



</style>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <title>CERP</title>
</head>
<body>


<div id="main">




<div id="content2">
<div style="margin-bottom:20px;">
	<h1>수주 등록</h1>
</div>

<table cellspacing="0" cellpadding="0">
<tbody>
	
	
	<form action="CerpOrderInsertFinish.Capt" method="post">
		
	거래처명 : <input type="text"  name="clientname" id="clientname"  value= readonly>
	<button type="button" id="button" class="btsize" name="action" value="update" onclick="javascript:popupclient(this.form);">거래처불러오기</button><br>
	품목명 : <input type="text"  name="itemname" id="itemname" value= readonly>
	<button type="button" id="button" class="btsize" name="action" value="update" onclick="javascript:popupitem(this.form);">품목불러오기</button><br>
	수주날짜 : <input type="date" name="orderday" id="orderday"  value= ><br>
	수주시간 : <input type="time" name="ordertime" id="ordertime" value="01:00"><br>
	마감날짜 :	<input type="date"  name="delivery_day" id="delivery_day" value=  >		<br>
	마감시간 : <input type="time" name="delivery_time" id="delivery_time" value="01:00"><br>
	출고단가 :	<input type="text"  name="forwarding_price" id="p_forwarding" onkeyup="totalamount()" value=  >	<br>
	수량 : 	<input type="text"  name="count" value=1 id="count" onkeyup="totalamount()"  >	<br>
	공급가액 : <input type="text"  name="sv" id="sv" value=${order.sv} readonly ><br>
	총금액[부가세포함] : <input type="text"  name="total_amount" id="total_amount" value=0 readonly >	<br>
	담당직원코드 :	<input type="text"  name="ecode" id="ecode" value= readonly ><br>
	담당직원이름 : 	<input type="text"  name="name" id="name" value= readonly >	<br>
	<button type="button" id="button" class="btsize" name="action" value="update" onclick="javascript:popupemployee(this.form);" readonly>담당직원불러오기</button>	<br>
	
		
		
		
	<button type="submit" id="button" class="btsize" name="action" value="insert">등록 완료</button>
	
	
	
	
	</form>
</tbody>
</table>
		
	
	


	
</div>

<c:if test="${redirect == 1}">
<script>
window.opener.location.reload();
window.close();

</script>
</c:if>
<c:if test="${redirect == 0}">
<script>

alert('값에 문제가 있어 수정할 수 없습니다.');
history.go(-1);
</script>
</c:if>

<script>


function popupclient(form)
{
  
  var popuptitle  = "거래처 정보 불러오기";
  var popupurl    ="CerpOrderClient.Capt";
  var popupstatus = "scrollbars=no,resizable=yes,status=yes,toolbar=no,directories=no,menubar=no,width=700, height=1000, top=100,left=0"; 
  window.open(popupurl, popuptitle,popupstatus); 
                                       
  
  }
function popupitem(form)
{
  
  var popuptitle  = "제품 정보 불러오기";
  var popupurl    ="CerpOrderItem.Capt";
  var popupstatus = "scrollbars=no,resizable=yes,status=yes,toolbar=no,directories=no,menubar=no,width=700, height=1000, top=100,left=0"; 
  window.open(popupurl, popuptitle,popupstatus); 
                                       
  
  }
function popupemployee(form)
{
  
  var popuptitle  = "직원 불러오기";
  var popupurl    ="CerpOrderEmployee.Capt";
  var popupstatus = "scrollbars=no,resizable=yes,status=yes,toolbar=no,directories=no,menubar=no,width=900, height=1000, top=100,left=0"; 
  window.open(popupurl, popuptitle,popupstatus); 
                                       
  
  }
function totalamount()
{
  var forwarding = document.getElementById("p_forwarding").value.replace(/,/g, "");
  var acount = document.getElementById("count").value;
  document.getElementById('sv').value = Math.round(parseInt(forwarding) * parseInt(acount)).toLocaleString('ko-KR');
  document.getElementById('total_amount').value = Math.round(parseInt(forwarding) * parseInt(acount) * 1.1).toLocaleString('ko-KR');
}


  </script>
</body>
</html>


