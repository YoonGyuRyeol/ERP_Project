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
	<h1>창고 수정</h1>
</div>

<form action="CerpStUpdateFinish.Capt" method="post">
	<div style="color:red;"> 창고코드 : <input type="text" placeholder="" name="warecode" id="warecode" value=${st.warecode} readonly></div>
	<div> 창고명 : <input type="text" placeholder="" name="warename" id="warename" value='${st.warename}'></div>
	<div style="color:red;"> 창고분류 : <input type="text" placeholder="" name="warelike" id="warelike" value=${st.warelike} readonly></div>
	
	<div> 사용여부 : 
	<c:if test="${st.usecheck == '사용'}">
				<select name = "use_sortation">
         			<option value = "사용" selected >사용</option>
          			<option value = "미사용">미사용</option>
          		</select>
	</c:if>	
	<c:if test="${st.usecheck == '미사용'}">
				<select name = "use_sortation">
         			<option value = "사용"  >사용</option>
          			<option value = "미사용" selected>미사용</option>
          		</select>
	</c:if>	
	</div>

	<button type="submit" id="submit2" class="btsize">수정완료</button>
	
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


