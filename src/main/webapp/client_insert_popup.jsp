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
	<h1>거래처 등록</h1>
</div>
<form action="CerpClientInsertFinish.Capt" method="post">
	<div> <input type="radio" id="radio1" name="buy" value="buy"> <label for="buy">매입처</label>
 		 <input type="radio" id="radio2" name="buy" value="sell" checked="checked"> <label for=sell>매출처</label><br></div>
	<div> 거래처명 : <input type="text" placeholder="거래처명을 입력해주세요." name="clientname" id="clientname" value=${client.clientname}></div>
	<div> 대표자명 : <input type="text" placeholder="대표자명을 입력해주세요." name="representative" id="representative" value=${client.representative}></div>
	<div> 업태 : <input type="text" placeholder="업태를 입력해주세요." name="type_of_business" id="type_of_business" value=${client.type_of_business}></div>
	<div> 사업자등록번호 : <input type="text" placeholder="사업자등록번호를 입력해주세요." name="business_number" id="business_number" value=${client.business_number}></div>
	<div> 연락처 : <input type="text" placeholder="연락처를 입력해주세요." name="contact" id="contact" value=${client.contact}></div>
	<div> 대표연락처 : <input type="text" placeholder="대표연락처를 입력해주세요." name="representative_contact" id="representative_contact" value=${client.representative_contact}></div>
	<div> 주소 : <input type="text" placeholder="주소를 입력해주세요." name="address" id="address" value='${client.address}' ></div>
	<div> 이메일 : <input type="text" placeholder="이메일을 입력해주세요." name="representative_email" id="representative_email" value=${client.representative_email}></div>


	<button type="submit" id="submit2" >등록완료</button>
	
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


