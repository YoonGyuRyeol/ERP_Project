<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" href="css/mainpop.css">



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


	<div> 입고코드 : <input type="text" placeholder="dwaringcode" name="dwaringcode" id="dwaringcode" value=${whs2.waringcode} readonly> </div>
	
	

<table cellspacing="0" cellpadding="0">
<tbody>
	<tr>
		<td width="15%" height="30px" align="center">부품코드</td>
		<td width="20%" height="30px" align="center">부품명</td>
		<td width="11%" height="30px" align="center">발주한 개수</td>
		<td width="11%" height="30px" align="center">미입고 개수</td>
		<td width="12%" height="30px" align="center">반품 개수</td>
		<td width="11%" height="30px" align="center">가입고 개수</td>
		<td width="10%" height="30px" align="center">입고 완료 개수</td>
		<td width="10%" height="30px" align="center">불량품 개수</td>
	</tr>
	
			
	<c:forEach var="whs" items="${whs}" varStatus="status">			
	<tr>
		<td width="15%" height="30px" align="center">${whs.itemcode}</td>
		<td width="20%" height="30px" align="center">${whs.itemname}</td>
		<td width="11%" height="30px" align="center">${whs.count}</td>
		<td width="11%" height="30px" align="center">${whs.uncount}</td>
		<td width="12%" height="30px" align="center">${whs.refundcount}</td>
		<td width="11%" height="30px" align="center">${whs.temporary_count}</td>
		<td width="10%" height="30px" align="center">${whs.warecount}</td>
		<td width="10%" height="30px" align="center">${whs.defective_count}</td>
	</tr>
	</c:forEach>
	
</tbody>
</table>
		
	
	


	
</div>


</body>
</html>


