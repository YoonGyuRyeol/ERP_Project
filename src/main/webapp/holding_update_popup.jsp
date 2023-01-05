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
	<h1>재고 수정</h1>
</div>
<form action="CerpHoldingUpdateFinish.Capt" method="post">
	<div style="color:red;"> 품목코드 : <input type="text" placeholder="itemcode" name="itemcode" id="itemcode" value=${holding.itemcode} readonly></div>
	<div style="color:red;"> 품목명 : <input type="text" placeholder="itemname" name="itemname" id="itemname" value=${holding.itemname} readonly></div>
	<div> 제품창고 : <input type="text" placeholder="receiving_price" name="warename" id="receiving_price" value=${holding.warename} ></div>
	<div style="color:red;"> 갱신일자 : <input type="text" placeholder="forwarding_price" name="holdingday" id="forwarding_price" value=${holding.holdingday} readonly> </div>
	<div style="color:red;"> 입고단가 : <input type="text" placeholder="forwarding_price" name="receiving_price" id="forwarding_price" value=${holding.receiving_price} readonly> </div>	
	<div> 재고 :  <input type="text" placeholder="forwarding_price" name="acount" id="forwarding_price" value=${holding.acount} > </div>
	

	<button type="submit" id="submit2" class="btsize">수정완료</button>
	
</form>
	
</div>
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
</body>
</html>


