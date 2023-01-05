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


	<div> 발주코드 : <input type="text" placeholder="dplacecode" name="dplacecode" id="dplacecode" value=${pos2.placecode} readonly> </div>
	
	

<table cellspacing="0" cellpadding="0">
<tbody>
	<tr>
		<td width="25%" height="30px" align="center">거래처</td>
		<td width="25%" height="30px" align="center">부품코드</td>
		<td width="25%" height="30px" align="center">부품명</td>
		<td width="25%" height="30px" align="center">필요한 개수</td>
		
	
	
	</tr>
	
			
	<c:forEach var="pos" items="${pos}" varStatus="status">			
	<tr>
		<td width="25%" height="30px" align="center">${pos.clientname}</td>
		<td width="25%" height="30px" align="center">${pos.itemcode}</td>
		<td width="25%" height="30px" align="center">${pos.itemname}</td>
		<td width="25%" height="30px" align="center">${pos.count}</td>
		
	
	</tr>
	</c:forEach>
	
</tbody>
</table>
		
	
	


	
</div>


</body>
</html>


