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




<div id="content2" style="margin-top:0px;">
<div style="margin-bottom:20px;">
	<h1>입고 처리</h1>
</div>
<form action="CerpWhUpdateFinish.Capt" method="post">

	<div> 입고코드 : <input type="text" placeholder="itemcode" name="waringcode" id="waringcode" value=${wh.waringcode} readonly></div>
	<div> 발주코드 : <input type="text" placeholder="itemcode" name="placecode" id="placecode" value=${wh.placecode} readonly></div>
    
    입고창고 <input type="text" id="ware" name="warename" readonly value='${wh.warename}'> <br>
    갱신일자 <input type="date" id="first" name="firstdate" readonly value=${wh.wareday}> <br>
    진행상태 :	<input type="text"  name="ecode" id="ecode" readonly value=${wh.progress_status}  ><br>
	

<table cellspacing="0" cellpadding="0">
<tbody>
	<tr>
		<td width="5%" height="30px" align="center">선택</td>
		<td width="14%" height="30px" align="center">부품코드</td>
		<td width="19%" height="30px" align="center">부품명</td>
		<td width="10%" height="30px" align="center">발주한 개수</td>
		<td width="10%" height="30px" align="center">미입고 개수</td>
		<td width="12%" height="30px" align="center">반품 개수</td>
		<td width="10%" height="30px" align="center">가입고 개수</td>
		<td width="10%" height="30px" align="center">입고 완료 개수</td>
		<td width="10%" height="30px" align="center">불량품 개수</td>
	</tr>
	
	
	<c:forEach var="whs" items="${whs}" varStatus="status">			
	<tr>
		<c:if test="${status.first}">
		<td width="5%" height="30px" align="center"><input type="radio" id="radio4" name="select" value=${whs.itemcode} checked></td>
		</c:if>
		<c:if test="${!status.first}">
		<td width="5%" height="30px" align="center"><input type="radio" id="radio4" name="select" value=${whs.itemcode} ></td>
		</c:if>
		<td width="14%" height="30px" align="center">${whs.itemcode}</td>
		<td width="19%" height="30px" align="center">${whs.itemname}</td>
		<td width="10%" height="30px" align="center">${whs.count}</td>
		<td width="10%" height="30px" align="center">${whs.uncount}</td>
		<td width="12%" height="30px" align="center">${whs.refundcount}</td>
		<td width="10%" height="30px" align="center">${whs.temporary_count}</td>
		<td width="10%" height="30px" align="center">${whs.warecount}</td>
		<td width="10%" height="30px" align="center">${whs.defective_count}</td>
	</tr>
	</c:forEach>
		
	<button type="button" id="button" class="btsize" name="action" value="update" onclick="javascript:popup2(this.form);">선택항목 가입고 처리</button><br>
	<button type="button" id="button" class="btsize" name="action" value="update" onclick="javascript:popup(this.form);">선택항목 품질검사 처리</button><br>
	<button type="button" id="button" class="btsize" name="action" value="update" onclick="javascript:popup3(this.form);">선택항목 불량품 반품 처리</button><br>
	<button type="button" id="button" class="btsize" name="action" value="update" onclick="javascript:popup4(this.form);">선택항목 반품 가입고 처리</button><br>
	<button type="button" id="button" class="btsize" name="finish" value="insert" onclick="close2();">완료</button>
	
</tbody>
</table>
		
	</form>
	


	
</div>

<c:if test="${redirect == 1}">
<script>
window.opener.location.reload();
window.close();

</script>
</c:if>
<c:if test="${refresh == 2}">
<script>

alert('값에 문제가 있어 수정할 수 없습니다.');
history.go(-1);
</script>
</c:if>
<script>

function close2(){
window.opener.location.reload();
window.close();
}
function popup(form)
{
  
  var popuptitle  = "입고개별요소입고처리";
  var popupurl    ="CerpWhUpdateOne.Capt";
  var popupstatus = "scrollbars=no,resizable=yes,status=yes,toolbar=no,directories=no,menubar=no,width=1300, height=500, top=100,left=0"; 
  window.open("", popuptitle,popupstatus); 
                                       
  form.target = popuptitle;                    
  form.action = popupurl;                   
  form.method = "post";
  form.submit();     
  }
function popup2(form)
{
  
  var popuptitle  = "입고개별요소가입고처리";
  var popupurl    ="CerpWhTempUpdateOne.Capt";
  var popupstatus = "scrollbars=no,resizable=yes,status=yes,toolbar=no,directories=no,menubar=no,width=1300, height=500, top=100,left=0"; 
  window.open("", popuptitle,popupstatus); 
                                       
  form.target = popuptitle;                    
  form.action = popupurl;                   
  form.method = "post";
  form.submit();     
  }
function popup3(form)
{
  
  var popuptitle  = "불량품 반품 처리";
  var popupurl    ="CerpWhRefundUpdateOne.Capt";
  var popupstatus = "scrollbars=no,resizable=yes,status=yes,toolbar=no,directories=no,menubar=no,width=1300, height=500, top=100,left=0"; 
  window.open("", popuptitle,popupstatus); 
                                       
  form.target = popuptitle;                    
  form.action = popupurl;                   
  form.method = "post";
  form.submit();     
  }
  
function popup4(form)
{
  
  var popuptitle  = "반품 가입고처리";
  var popupurl    ="CerpWhRefundTempUpdateOne.Capt";
  var popupstatus = "scrollbars=no,resizable=yes,status=yes,toolbar=no,directories=no,menubar=no,width=1300, height=500, top=100,left=0"; 
  window.open("", popuptitle,popupstatus); 
                                       
  form.target = popuptitle;                    
  form.action = popupurl;                   
  form.method = "post";
  form.submit();     
  }
  

  </script>
</body>
</html>


