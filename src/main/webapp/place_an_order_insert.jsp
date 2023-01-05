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




<div id="content2" style="margin-bottom:40px; height:1150px;">
<div style="margin-bottom:20px;">
	<h1>발주 등록</h1>
</div>
<form action="CerpPoInsertFinish.Capt" method="post">
	<input type="hidden" id="ordercode" name="ordercode" value=${order.ordercode}>
	
	<div> 부품창고 
  		<select name = "warehouse">
  		<c:forEach var="st" items="${st}" varStatus="status">	
          <option value = "${st.warename}" >${st.warename}</option>
          </c:forEach>   
     
       </select>
      
        
       
       </div>
       <div> 가입고창고 
  		<select name = "warehouse_t">
  		<c:forEach var="st2" items="${st2}" varStatus="status">	
          <option value = "${st2.warename}" >${st2.warename}</option>
          </c:forEach>   
     
       </select>
      
        
       
       </div>
       <div> 불량품창고 
  		<select name = "warehouse_d">
  		<c:forEach var="st3" items="${st3}" varStatus="status">	
          <option value = "${st3.warename}" >${st3.warename}</option>
          </c:forEach>   
     
       </select>
      
        
       
       </div>
    <button type="button" id="button" class="btsize" name="action" value="update" onclick="javascript:popuporder(this.form);" readonly>수주서 불러오기</button>	<br>   
    발주일자 <input type="date" id="orderday" name="firstdate" value=${order.orderday}><br>
    발주시간 : <input type="time" name="firsttime" id="ordertime" value="01:00"><br>
    마감일자 <input type="date" id="delivery_day" name="finaldate" value=${order.delivery_day}><br>
    마감시간 : <input type="time" name="finaltime" id="delivery_time" value="01:00"><br>
    담당직원코드 :	<input type="text"  name="ecode" id="ecode" value=${order.ecode} readonly ><br>
	담당직원이름 : 	<input type="text"  name="name" id="name" value=${order.name} readonly >	<br>
	<button type="button" id="button" class="btsize" name="action" value="update" onclick="javascript:popupemployee(this.form);" readonly>담당직원불러오기</button>	<br>
	수주한 제품 : 	<input type="text"  name="itemname" id="itemname" value='${order.itemname}' readonly >	<br>
	수주한 개수 : 	<input type="text"  name="count" id="count" value=${order.count} readonly >	<br>
	해당 제품의 현재 재고 : 	<input type="text"  name="nowholding" id="nowholding" value=${order.acount} readonly ><br>
	추가로 필요한 제품의 수 : <input type="text"  name="needholding" id="needholding" value= ><br>
	
	
	<button type="submit" id="button" class="btsize" name="action" value="update" onclick="javascript: form.action='CerpPoMRP.Capt';" readonly>필요한 제품의 MRP 계산 및 등록</button>	<br>
	공급가액 : <input type="text"  name="sv" id="sv" value=${sv} readonly ><br>
	총금액[부가세포함] : <input type="text"  name="total_amount" id="total_amount" value=${total} readonly >	<br>
	<button type="button" id="button" class="btsize" name="action" value="update" onclick="javascript:popup(this.form);">선택항목 수정</button><br>
<table cellspacing="0" cellpadding="0">
<tbody>
	<tr>
	<td width="4%" height="30px" align="center"> 선택</td>
		<td width="25%" height="30px" align="center">거래처</td>
		<td width="25%" height="30px" align="center">부품코드</td>
		<td width="25%" height="30px" align="center">부품명</td>
		<td width="25%" height="30px" align="center">필요한 개수</td>
		
	
	
	</tr>
	
	
		
	<c:forEach var="temp" items="${temp}" varStatus="status">			
	<tr>
		<td width="4%" height="30px" align="center"> <input type="radio" id="radio4" name="select" value=${temp.itemcode}></td>
		<td width="25%" height="30px" align="center">${temp.clientname}</td>
		<td width="25%" height="30px" align="center">${temp.itemcode}</td>
		<td width="25%" height="30px" align="center">${temp.itemname}</td>
		<td width="25%" height="30px" align="center">${temp.count}</td>
		
	
	</tr>
	
	
	
	</c:forEach>
		
	

 
	
	
</tbody>
</table>
		
		<button type="submit" id="button" class="btsize" name="action" value="insert" onclick="javascript: form.action='CerpPoInsertFinish.Capt';">완료</button>
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

function popup(form)
{
  
  var popuptitle  = "발주개별요소편집";
  var popupurl    ="CerpPoTempUpdateOne.Capt";
  var popupstatus = "scrollbars=no,resizable=yes,status=yes,toolbar=no,directories=no,menubar=no,width=700, height=1000, top=100,left=0"; 
  window.open("", popuptitle,popupstatus); 
                                       
  form.target = popuptitle;                    
  form.action = popupurl;                   
  form.method = "post";
  form.submit();     
  }
  

  

function popuporder(form)
{
  
  var popuptitle  = "수주서 불러오기";
  var popupurl    ="CerpOrderPlace.Capt";
  var popupstatus = "scrollbars=no,resizable=yes,status=yes,toolbar=no,directories=no,menubar=no,width=1800, height=1000, top=100,left=0"; 
  window.open(popupurl, popuptitle,popupstatus); 
                                       
  
  }  
function popupemployee(form)
{
  
  var popuptitle  = "직원 불러오기";
  var popupurl    ="CerpOrderEmployee.Capt";
  var popupstatus = "scrollbars=no,resizable=yes,status=yes,toolbar=no,directories=no,menubar=no,width=900, height=1000, top=100,left=0"; 
  window.open(popupurl, popuptitle,popupstatus); 
                                       
  
  }
  
function needamount()
{
  var count = document.getElementById("count").value.replace(/,/g, "");
  var nowholding = document.getElementById("nowholding").value;
  document.getElementById('needholding').value = Math.round(parseInt(count) - parseInt(nowholding)).toLocaleString('ko-KR');
  
}
var count = document.getElementById("count").value.replace(/,/g, "");
var nowholding = document.getElementById("nowholding").value;
document.getElementById('needholding').value = Math.round(parseInt(count) - parseInt(nowholding)).toLocaleString('ko-KR');
document.getElementById('sv').value=document.getElementById('sv').value.toLocaleString('ko-KR');
document.getElementById('total').value=document.getElementById('total').value.toLocaleString('ko-KR');
  </script>
</body>
</html>


