<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
			<div style="margin-bottom: 20px;">
				<h1>BOM 등록</h1>
			</div>
			<form action="CerpBomBaseInsertFinish.Capt" method="post">
				<div>Bom을 생성할 제품을 선택하세요.</div>
				<table cellspacing="0" cellpadding="0">
					<tbody>
						<tr>
							<td width="10%" height="30px" align="center">선택</td>
							<td width="26%" height="30px" align="center">제품코드</td>
							<td width="64%" height="30px" align="center">제품명</td>
						</tr>
						<c:forEach var="item" items="${item}" varStatus="status">
							<tr>
								<td width="10%" height="30px" align="center"><input
									type="radio" id="radio4" name="select" value=${item.itemcode}></td>
								<td width="26%" height="30px" align="center">${item.itemcode}</td>
								<td width="64%" height="30px" align="center">${item.itemname}</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>

				<button type="submit" id="submit2" class="btsize" name="action" value="insert">선택항목
					추가</button>
				<br>
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


