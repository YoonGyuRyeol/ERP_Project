<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- css 위치 못잡아줌 // css폴더에서 빼고 일단 씀 -->
<link rel="stylesheet" type="text/css" href="HF1.css">
<link rel="stylesheet" type="text/css" href="main.css">

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">

<title>CERP</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div id="mainpage">
		<!-- 사이드 메뉴 부분 -->
		<div id="sidemenu">
			<jsp:include page="New_left_menu_BaseInfo.jsp"></jsp:include>
		</div>

		<div id="contentpage">
			<div class="cp">
				<h4>회사 정보</h4>
			</div>
			
			<div class="cp wd">
				<table cellspacing="0" cellpadding="0">
					<thead>
						<tr style="text-align: center;">
							<th width="12%" height="30px">회사코드</th>
							<th width="10%" height="30px">회사명</th>
							<th width="10%" height="30px">대표자명</th>
							<th width="10%" height="30px">업태</th>
							<th width="12%" height="30px">사업자등록번호</th>
							<th width="12%" height="30px">연락처</th>
							<th width="10%" height="30px">대표연락처</th>
							<th width="12%" height="30px">주소</th>
							<th width="12%" height="30px">이메일</th>

						</tr>
					</thead>
					<form method="post" name="companyData" id="companyData">
					<tbody>
						<c:forEach var="company" items="${company}" varStatus="status">
							<tr>
								<td width="12%" height="30px" align="center">${company.ccode}</td>
								<td width="10%" height="30px" align="center">${company.cname}</td>
								<td width="10%" height="30px" align="center">${company.representative}</td>
								<td width="10%" height="30px" align="center">${company.type_of_business}</td>
								<td width="12%" height="30px" align="center">${company.business_number}</td>
								<td width="10%" height="30px" align="center">${company.contact}</td>
								<td width="10%" height="30px" align="center">${company.representative_contact}</td>
								<td width="12%" height="30px" align="center">${company.address}</td>
								<td width="10%" height="30px" align="center">${company.representative_email}</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>


				<button type="button" name="button1" value="update" style="margin-top: 10px;"
					onclick="javascript:popup(this.form);">수정</button>



				</form>
			</div>
		</div>

	</div>





	<script type="text/javascript" language="javascript">
		function popup(form) {

			var popuptitle = "회사정보수정";
			var popupurl = "CerpCompanyUpdate.Capt";
			var popupstatus = "scrollbars=no,resizable=no,status=no,toolbar=no,directories=no,menubar=no,width=940, height=900, top=100,left=100";
			window.open("", popuptitle, popupstatus);

			form.target = popuptitle;
			form.action = popupurl;
			form.method = "post";
			form.submit();
		}
	</script>
</body>
</html>


