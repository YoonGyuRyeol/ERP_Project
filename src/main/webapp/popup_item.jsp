<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<html>

<body>
	<form action="infoAction.jsp" method="post">
		<div>품목코드</div>
		<input type="text" name="item_code" size="20">
		<div>품목명</div>
		<input type="text" name="item_name" size="20">
		<div>입고단가</div>
		<input type="text" name="receiving_unit_price" size="20">
		<div>출고단가</div>
		<input type="text" name="release_unit_price" size="20">
		<div>품목구분</div>
		<input type="text" name="Item_kind" size="20">
		<div>사업자번호</div>
		<input type="text" name="business_number" size="20">
		<div>대표연락처</div>
		<input type="text" name="owener_contact" size="20">
		<div>주소</div>
		<input type="text" name="address" size="20">
		<div>대표이메일</div>
		<input type="text" name="owener_email" size="20"> <input
			type="submit" value="등록">
	</form>
</body>
</html>