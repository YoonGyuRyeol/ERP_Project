<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" href="mainpop.css">
<link rel="stylesheet" type="text/css" href="HF1.css">

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
	<h1>거래처 정보 수정</h1>
</div>
<form action="CerpClientUpdateFinish.Capt" method="post">
	<div style="color:red;"> 거래처 코드 : <input type="text" placeholder="clientcode" name="clientcode" id="clientcode" value=${client.clientcode} readonly></div>
	<div> 거래처명 : <input type="text" placeholder="clientname" name="clientname" id="clientname" value=${client.clientname}></div>
	<div> 대표자명 : <input type="text" placeholder="representative" name="representative" id="representative" value=${client.representative}></div>
	<div> 업태 : <input type="text" placeholder="type_of_business" name="type_of_business" id="type_of_business" value=${client.type_of_business}></div>
	<div> 사업자등록번호 : <input type="text" placeholder="business_number" name="business_number" id="business_number" value=${client.business_number}></div>
	<div> 연락처 : <input type="text" placeholder="contact" name="contact" id="contact" value=${client.contact}></div>
	<div> 대표연락처 : <input type="text" placeholder="representative_contact" name="representative_contact" id="representative_contact" value=${client.representative_contact}></div>
	<div> 주소 : <input type="text" placeholder="address" name="address" id="address" value='${client.address}' ></div>
	<div> 이메일 : <input type="text" placeholder="representative_email" name="representative_email" id="representative_email" value=${client.representative_email}></div>


	<button type="submit" id="submit2" >수정완료</button>
	
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


