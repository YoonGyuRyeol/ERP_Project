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




<div id="content2" style="margin-bottom:40px; height:1050px;">
<div style="margin-bottom:20px;">
	<h1>발주 수정</h1>
</div>
<form action="CerpPoUpdateFinish.Capt" method="post">

	<div style="color:red;"> 발주코드 : <input type="text" placeholder="itemcode" name="placecode" id="itemcode" value=${po.placecode} readonly></div>
	<div> 부품창고 
  		<select name = "warehouse">
  		<c:forEach var="st" items="${st}" varStatus="status">
  			<c:if test="${post.warename != st.warename}">	
          <option value = "${st.warename}" >${st.warename}</option>
          	</c:if>
          	<c:if test="${post.warename == st.warename}">	
          <option value = "${st.warename}" selected>${st.warename}</option>
          	</c:if>
          </c:forEach>   
     
       </select>
      
        
       
       </div>
       <div> 가입고창고 
  		<select name = "warehouse_t">
  		<c:forEach var="st2" items="${st2}" varStatus="status">	
          <c:if test="${post.tempname != st2.warename}">	
          <option value = "${st2.warename}" >${st2.warename}</option>
          	</c:if>
          	<c:if test="${post.tempname == st2.warename}">	
          <option value = "${st2.warename}" selected>${st2.warename}</option>
          	</c:if>
          </c:forEach>   
     
       </select>
      
        
       
       </div>
       <div> 불량품창고 
  		<select name = "warehouse_d">
  		<c:forEach var="st3" items="${st3}" varStatus="status">	
         <c:if test="${post.defectname != st3.warename}">	
          <option value = "${st3.warename}" >${st3.warename}</option>
          	</c:if>
          	<c:if test="${post.defectname == st3.warename}">	
          <option value = "${st3.warename}" selected>${st3.warename}</option>
          	</c:if>
          </c:forEach>   
     
       </select>
       <br>
    발주일자 <input type="date" id="first" name="firstdate" value=${po.orderday}><br>
    발주시간 : <input type="time" name="firsttime" id="ordertime" value="01:00"><br>
    마감일자 <input type="date" id="first" name="finaldate" value=${po.delivery_day}><br>
    마감시간 : <input type="time" name="finaltime" id="delivery_time" value="01:00"><br>
    담당직원코드 :	<input type="text"  name="ecode" id="ecode" value=${po.ecode} readonly ><br>
	담당직원이름 : 	<input type="text"  name="name" id="name" value=${po.name} readonly >	<br>
	<button type="button" id="button" class="btsize" name="action" value="update" onclick="javascript:popupemployee(this.form);" readonly>담당직원불러오기</button>	<br>
	<div style="color:red;"> 공급가액 : <input type="text"  name="sv" id="sv" value=${po.sv} readonly ></div><br>
	<div style="color:red;"> 총금액[부가세포함] : <input type="text"  name="total_amount" id="total_amount" value=${po.total_amount} readonly ></div>	<br>

<table cellspacing="0" cellpadding="0">
<tbody>
	<tr>
	<td width="4%" height="30px" align="center"> 선택</td>
		<td width="25%" height="30px" align="center">거래처</td>
		<td width="25%" height="30px" align="center">부품코드</td>
		<td width="25%" height="30px" align="center">부품명</td>
		<td width="25%" height="30px" align="center">필요한 개수</td>
		
	
	
	</tr>
	
	
	<input type="hidden" name="place_code_hidden" value=${po.placecode}>	
	<input type="hidden" name="order_code_hidden" value=${pos2.ordercode}>		
	<c:forEach var="pos" items="${pos}" varStatus="status">			
	<tr>
		<td width="4%" height="30px" align="center"> <input type="radio" id="radio4" name="select" value=${pos.itemcode}></td>
		<td width="25%" height="30px" align="center">${pos.clientname}</td>
		<td width="25%" height="30px" align="center">${pos.itemcode}</td>
		<td width="25%" height="30px" align="center">${pos.itemname}</td>
		<td width="25%" height="30px" align="center">${pos.count}</td>
		
	
	</tr>
	
	
	
	</c:forEach>
		
	
	<button type="button" id="button" class="btsize" name="action" value="update" onclick="javascript:popup(this.form);">선택항목 수정</button><br>
	<button type="submit" id="button" class="btsize" name="action" value="insert">완료</button>
	
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


function popup(form)
{
  
  var popuptitle  = "발주개별요소편집";
  var popupurl    ="CerpPoUpdateOne.Capt";
  var popupstatus = "scrollbars=no,resizable=yes,status=yes,toolbar=no,directories=no,menubar=no,width=700, height=1000, top=100,left=0"; 
  window.open("", popuptitle,popupstatus); 
                                       
  form.target = popuptitle;                    
  form.action = popupurl;                   
  form.method = "post";
  form.submit();     
  }
  

  
function popupemployee(form)
{
  
  var popuptitle  = "직원 불러오기";
  var popupurl    ="CerpOrderEmployee.Capt";
  var popupstatus = "scrollbars=no,resizable=yes,status=yes,toolbar=no,directories=no,menubar=no,width=900, height=1000, top=100,left=0"; 
  window.open(popupurl, popuptitle,popupstatus); 
                                       
  
  }
  </script>
</body>
</html>


