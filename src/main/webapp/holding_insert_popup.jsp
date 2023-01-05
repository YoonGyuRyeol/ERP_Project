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
	<h1>재고 등록</h1>
</div>

<form action="CerpHoldingInsertFinish.Capt" method="post">
	
	
	
	<div> 생성할 재고 목록을 선택하세요.  </div>
	초기 재고수 : <input type="text" placeholder="bom_stock_code" name="materials" id="" value=1>
	<label for="onlyproduct">창고구분 : </label>
  	<select name = "warename">
  		
          <c:forEach var="st" items="${st}" varStatus="status">	
          <option value = "${st.warename}" >${st.warename}</option>
          </c:forEach>
     
       </select>
  <br>

<table cellspacing="0" cellpadding="0" style="margin-top:20px;">
<tbody>
	<tr>
		<td width="10%" height="30px" align="center">선택</td>
		<td width="26%" height="30px" align="center">제품코드</td>
		<td width="64%" height="30px" align="center">제품명</td>
		
		
	
	
	</tr>
	
	
		
	<c:forEach var="item" items="${item}" varStatus="status">			
	<tr>
		<td width="10%" height="30px" align="center"> <input type="radio" id="radio4" name="select" value=${item.itemcode}></td>
		<td width="26%" height="30px" align="center">${item.itemcode}</td>
		<td width="64%" height="30px" align="center">${item.itemname}</td>
		
	
	</tr>
	</c:forEach>
	
</tbody>
</table>
		
	<button type="submit" id="submit2" class="btsize" name="action" value="insert" >선택항목 추가</button><br>
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

</body>
</html>


