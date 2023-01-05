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
<div style="margin-bottom:20px;">
	<h1>BOM 상세보기</h1>
</div>

	<div> 제품품목코드 : <input type="text" placeholder="itemcode" name="itemcode" id="itemcode" value=${bom_p.productcode} readonly></div>
	<div> 제품이름 : <input type="text" placeholder="itemname" name="itemname" id="itemname" value=${bom_p.productname} readonly></div>
	
	

<table cellspacing="0" cellpadding="0">
<tbody>
	<tr>
		<td width="20%" height="30px" align="center">BOM코드</td>
		<td width="40%" height="30px" align="center">부품코드</td>
		<td width="30%" height="30px" align="center">부품명</td>
		<td width="10%" height="30px" align="center">필요한 부품 개수</td>
		
	
	
	</tr>
	
			
	<c:forEach var="bom_stock" items="${bom_stock}" varStatus="status">			
	<tr>
		<td width="20%" height="30px" align="center">${bom_stock.bom_code}</td>
		<td width="40%" height="30px" align="center">${bom_stock.itemcode}</td>
		<td width="30%" height="30px" align="center">${bom_stock.itemname}</td>
		<td width="10%" height="30px" align="center">${bom_stock.materials}</td>
		
	
	</tr>
	</c:forEach>
	
</tbody>
</table>
		
	
	


</div>
</div>


</body>
</html>


