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
	<h1>품목 등록</h1>
</div>
<form action="CerpItemInsertFinish.Capt" method="post">
	<div> <label for="itemLike">품목의 종류 : </label>
 			 <select name = "Like">
         		<c:forEach var="il" items="${il}" varStatus="status">	
         	 <option value = "${il.itemlikecode2}" >${il.itemlikename}</option>
          </c:forEach>
       	</select>
 		<br>
 	</div>
	
	<div style="margin-top:5px;"> 품목명 : <input type="text" placeholder="품목명을 입력해주세요." name="itemname" id="itemname" value=${item.itemname}></div>
	<div> 입고단가 : <input type="text" placeholder="입고단가를 입력해주세요." name="receiving_price" id="receiving_price" value=${item.receiving_price}></div>
	<div> 출고단가 : <input type="text" placeholder="출고단가를 입력해주세요." name="forwarding_price" id="forwarding_price" value=${item.forwarding_price}></div>



	<button type="submit" id="submit2" class="btsize">등록완료</button>
	
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

alert('값에 문제가 있어 등록할 수 없습니다.');
history.go(-1);
</script>
</c:if>
</body>
</html>


