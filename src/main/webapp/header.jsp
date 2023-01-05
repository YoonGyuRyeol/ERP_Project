<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div id="header">
	<a href="CerpHome.Capt">
		<div id="title" class="inline1">
			<img class='image2' src="css/images/cerp.png" alt="cerp">
		</div>
	</a>

	<div class="headmenu">
		<ul class="menu">
			<li><a href="CerpCompany.Capt">기초정보</a>
				<ul class="submenu sub4">
					<li><a href="CerpCompany.Capt">회사정보</a></li>
					<li><a href="CerpClient.Capt">거래처정보</a></li>
					<li><a href="CerpItem.Capt">품목등록</a></li>
					<li><a href="CerpBom.Capt">BOM등록</a></li>
				</ul></li>
			<li><a href="CerpHolding.Capt">자재관리</a>
				<ul class="submenu sub3">
					<li><a href="CerpHolding.Capt">재고현황</a></li>
					<li><a href="CerpLogStatus.Capt">재고증감량현황</a></li>
					<li><a href="CerpSt.Capt">창고관리</a></li>
				</ul></li>
			<li><a href="CerpOrder.Capt">구매관리</a>
				<ul class="submenu sub3">
					<li><a href="CerpOrder.Capt">수주관리</a></li>
					<li><a href="CerpPo.Capt">발주현황</a></li>
					<li><a href="CerpWh.Capt">입고등록</a></li>
				</ul></li>
		</ul>
	</div>

	<c:if test="${loginuser != null}">
		<a href="Captlogout.Capt"><div class="inline2 inline6">|
				로그아웃</div></a>
		<div class="inline2 inline6">${loginuser.name}
			${loginuser.position}님 안녕하세요!</div>
	</c:if>
	
	<c:if test="${loginuser == null}">
		<a href="UserLogin.jsp"><div id="login" class="inline2"></div></a>
	</c:if>

</div>

<div id="guidline"></div>