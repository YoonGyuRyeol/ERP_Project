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
	<h1>품질검사 처리</h1>
</div>
<form action="CerpWhUpdateOneFinish.Capt" method="post">
	
	
	<div>   </div>

	

<table cellspacing="0" cellpadding="0">

	
	
	
	
<table cellspacing="0" cellpadding="0">
<tbody>
	<tr>
		<td width="14%" height="30px" align="center">부품코드</td>
		<td width="19%" height="30px" align="center">부품명</td>
		<td width="10%" height="30px" align="center">발주한 개수</td>
		<td width="10%" height="30px" align="center">미입고 개수</td>
		<td width="12%" height="30px" align="center">반품 개수</td>
		<td width="10%" height="30px" align="center">가입고 개수</td>
		<td width="10%" height="30px" align="center">입고 완료 개수</td>
		<td width="10%" height="30px" align="center">불량품 개수</td>
	</tr>
	
		
	<tr>
		<td width="14%" height="30px" align="center">${whs.itemcode}</td>
		<td width="19%" height="30px" align="center">${whs.itemname}</td>
		<td width="10%" height="30px" align="center">${whs.count}</td>
		<td width="10%" height="30px" align="center">${whs.uncount}</td>
		<td width="12%" height="30px" align="center">${whs.refundcount}</td>
		<td width="10%" height="30px" align="center">${whs.temporary_count}</td>
		<td width="10%" height="30px" align="center">${whs.warecount}</td>
		<td width="10%" height="30px" align="center">${whs.defective_count}</td>
	</tr>
		<input type="hidden" id="max" name="max" value=${max}>
		<input type="hidden" id="" name="waringcode" value=${whs.waringcode}>
		<input type="hidden" id="" name="itemcode" value=${whs.itemcode}>
</tbody>
</table>
	정상 입고 개수 <input type="number" min="0" max=${max} name="warecount" id="warecountd" value=0  onkeyup="totalmax()" onchange="totalmax()">
	불량품 입고 개수 <input type="number" min="0" max=${max} name="defectivecount" id="defectivecountd" value=0  onkeyup="totalmax2()" onchange="totalmax2()">	
	<button type="submit" id="submit2" class="btsize" name="action" value="delete" >품질 검사 처리 완료하기</button><br>
	</form>


	
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
function totalmax()
{
	
	var max = document.getElementById("max").value;	
  var warecount = document.getElementById("warecountd").value;
  var defectivecount = document.getElementById("defectivecountd").value;
  if(max < (parseInt(warecount)+parseInt(defectivecount))){
		alert('가입고 숫자를 넘어서는 값은 입력 할 수 없습니다.');
		document.getElementById('defectivecountd').value = parseInt(max) - parseInt(warecount);
	}
  
  
}
function totalmax2()
{
	var max = document.getElementById("max").value;	
  var warecount = document.getElementById("warecountd").value;
  var defectivecount = document.getElementById("defectivecountd").value;
  if(max < (parseInt(warecount)+parseInt(defectivecount))){
		alert('가입고 숫자를 넘어서는 값은 입력 할 수 없습니다.');
		 document.getElementById('warecountd').value = parseInt(max) - parseInt(defectivecount);
	}
 
  
}
</script>
</body>
</html>


