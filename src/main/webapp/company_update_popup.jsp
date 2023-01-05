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
	<h1>회사 정보 수정</h1>
</div>
<form action="CerpCompanyUpdateFinish.Capt" method="post">
	<div style="color:red;"> 회사 코드 : <input type="text" placeholder="companycode" name="companycode" id="companycode" value=${company.ccode} readonly></div>
	<div> 회사명 : <input type="text" placeholder="companyname" name="companyname" id="companyname" value=${company.cname}></div>
	<div> 대표자명 : <input type="text" placeholder="representative" name="representative" id="representative" value=${company.representative}></div>
	<div> 업태 : <input type="text" placeholder="type_of_business" name="type_of_business" id="type_of_business" value=${company.type_of_business}></div>
	<div> 사업자등록번호 : <input type="text" placeholder="business_number" name="business_number" id="business_number" value=${company.business_number}></div>
	<div> 연락처 : <input type="text" placeholder="contact" name="contact" id="contact" value=${company.contact}></div>
	<div> 대표연락처 : <input type="text" placeholder="representative_contact" name="representative_contact" id="representative_contact" value=${company.representative_contact}></div>
	<div> 주소 : <input type="text" placeholder="address" name="address" id="address" value='${company.address}' ></div>
	<div> 이메일 : <input type="text" placeholder="representative_email" name="representative_email" id="representative_email" value=${company.representative_email}></div>


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


