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

<form action="CerpILInsertFinish.Capt" method="post">
<table cellspacing="0" cellpadding="0">
<tbody>
	<tr>
		<td width="20%" height="30px" align="center">분류코드</td>
		<td width="20%" height="30px" align="center">종류코드</td>
		<td width="40%" height="30px" align="center">종류명</td>
		<td width="20%" height="30px" align="center">종류구분</td>
	
	
	</tr>
	
			
	<c:forEach var="il" items="${il}" varStatus="status">			
	<tr>
		<td width="20%" height="30px" align="center">${il.itemlikecode1}</td>
		<td width="20%" height="30px" align="center">${il.itemlikecode2}</td>
		<td width="40%" height="30px" align="center">${il.itemlikename}</td>
		<td width="20%" height="30px" align="center">${il.item_sortation}</td>
	
	</tr>
	</c:forEach>
	
</tbody>
</table>
	<div> 분류코드 : <input type="text" placeholder="" name="itemlikecode1" id="itemlikecode1" value=></div>
	<div> 종류코드 : <input type="text" placeholder="" name="itemlikecode2" id="itemlikecode2" value=></div>
	<div> 종류명 : <input type="text" placeholder="" name="itemlikename" id="itemlikename" value=></div>
	<div> 종류구분 : 
				<select name = "item_sortation">
         			<option value = "pr"  >제품</option>
          			<option value = "st" selected>부품</option>
          		</select>
	</div>

	<button type="submit" id="submit2" class="btsize" >추가완료</button>
	<button type="button" id="submit" class="btsize" onclick="javascript:close();" >종료</button>
</form>
	
</div>

<c:if test="${redirect == 1}">
<script>


</script>
</c:if>
<c:if test="${redirect == 0}">
<script>

alert('값에 문제가 있어 수정할 수 없습니다.');
history.go(-1);
</script>

</c:if>
<script>
function close(){
	
	window.opener.location.reload();
	window.close();
}
</script>
</body>
</html>


