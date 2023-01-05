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

<form action="CerpStInsertFinish.Capt" method="post">
	
	<div> 창고명 : <input type="text" placeholder="" name="warename" id="warename" value=''></div>
	<div> 창고분류 : <select name = "ware_sortation">
         			<option value = "pt" selected >부품</option>
          			<option value = "pr">제품</option>
          			<option value = "te">가입고</option>
          			<option value = "de">불량품</option>
          		</select>
	
	

	<button type="submit" id="submit2" class="btsize">창고추가</button>
	
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


