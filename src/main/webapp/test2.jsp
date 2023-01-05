<!--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>-->
<link rel="stylesheet" type="text/css" href="css/HF1.css">


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	
    <title>CERP</title>
</head>
<body>
<div id="header">
	<a href="CerpHome.Capt">
	<div id="title" class="inline1">
		<img class='image2' src="css/images/cerp.png" alt="cerp">
	</div>
	</a>
	<a href="CerpBase.Capt">
	<div class="inline1 inline5">
		기초정보
	</div>
	</a>
	<a href="CerpClient.Capt">
	<div class="inline1 inline5">
		자재관리
	</div>
	</a>
	
	
	<a href="CaptSLSelect.Capt">
	<div class="inline1 inline5">
		구매관리
	</div>
	</a>
	
	
	
	
	<c:if test="${loginuser != null}">
	<a href="Captlogout.Capt"><div class="inline2 inline6">|   로그아웃</div></a>
	<div class="inline2 inline6">${loginuser.name} ${loginuser.position}님 안녕하세요!</div>
	
	
	</c:if>
  	<c:if test="${loginuser == null}">
	<a href="UserLogin.jsp"><div id="login" class="inline2"></div></a>
	</c:if>

	
	
	
	
	
</div>
	<div id="guidline">
	
	</div>

<div id="maincontent">
<a href="CerpCompany.Capt"> 회사정보</a><br>
<a href="CerpClient.Capt"> 거래처정보</a><br> 
<a href="CerpItem.Capt">품목등록</a><br>
<a href="CerpBom.Capt">BOM등록</a><br>
<a href="CerpStCapt">창고관리</a><br>

<a href="CerpHolding.Capt">재고현황<br></a>
재고증감량정리--<br>


<a href="CerpOrder.Capt">수주서관리<br></a>

<a href="CerpPo.Capt">발주현황<br></a>

<a href="CerpWh.Capt">입고등록<br></a>

</div>
	<div id="footer">
		
		<div  class="inline3">
			<div class="inline4">
				CONTACT US<br>
				<br>
				<br>
				<br>
				<br>
			</div>
			<div class="inline4">
				02-423-6543<br>
				cmku99@naver.com<br>
				<!-- --><br>
				<!-- --><br>
				<br>
			</div>
		</div>
		<div  class="inline3">
			<div class="inline4">
				SERVICES<br>
				<br>
				<br>
				<br>
				<br>
			</div>
			<div class="inline4" >
				Contact Us<br>
				Hackings<br>
				Login<br>
				Register<br>
				FAQ
			</div>
		</div>
		<div  class="inline3">
			<div class="inline4">
				INFORMATION<br>
				<br>
				<br>
				<br>
				<br>
			</div>
			<div class="inline4">
				CAPT<br>
				OWASP<br>
				Privacy Policy<br>
				Term & Conditions<br>
				Hackings
			</div>
		</div>
			<div id="capteam">
			@CAPT TEAM
			</div>
		</div>
	</div>
</body>
</html>
