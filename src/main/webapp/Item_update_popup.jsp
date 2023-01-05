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
	<h1>품목 수정</h1>
</div>
<form action="CerpItemUpdateFinish.Capt" method="post">
	<div style="color:red;"> 품목코드 : <input type="text" placeholder="itemcode" name="itemcode" id="itemcode" value=${item.itemcode} readonly></div>
	<div> 품목명 : <input type="text" placeholder="itemname" name="itemname" id="itemname" value='${item.itemname}'></div>
	<div> 입고단가 : <input type="text" placeholder="receiving_price" name="receiving_price" id="receiving_price" value=${item.receiving_price}></div>
	<div> 출고단가 : <input type="text" placeholder="forwarding_price" name="forwarding_price" id="forwarding_price" value=${item.forwarding_price}></div>
		
	<div> 품목 : 
	<c:if test="${item.item_sortation == '제품'}">
				<select name = "item_sortation">
         			<option value = "onlyproduct" selected >제품</option>
          			<option value = "onlystock">부품</option>
          		</select>
	</c:if>	
	<c:if test="${item.item_sortation == '부품'}">
				<select name = "item_sortation">
         			<option value = "onlyproduct"  >제품</option>
          			<option value = "onlystock" selected>부품</option>
          		</select>
	</c:if>	
	</div>

	<button type="submit" id="submit2" class="btsize" >수정완료</button>
	
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


