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
				<h4>BOM 등록</h4>
			</div>
		
			<div class="cp wd">

				<form method="post" name="BomData" id="BomData">
					<table cellspacing="0" cellpadding="0" style="margin-bottom: 10px;">
						<tbody>
							<tr style="text-align: center;">
								<th width="10%" height="30px">선택</th>
								<th width="30%" height="30px">품목코드</th>
								<th width="40%" height="30px">품목명</th>
								<th width="10%" height="30px">원재료개수</th>
								<th width="10%" height="30px">BOM 상세 보기</th>
							</tr>


							<c:forEach var="bom_product" items="${bom_product}"
								varStatus="status">
								<tr>
									<td width="10%" height="30px" align="center"><input
										type="radio" id="radio4" name="select"
										value=${bom_product.bom_code}></td>
									<td width="30%" height="30px" align="center">${bom_product.itemcode}</td>
									<td width="40%" height="30px" align="center">${bom_product.itemname}</td>
									<td width="10%" height="30px" align="center">${bom_product.materials}</td>
									<td width="10%" height="30px" align="center"><a
										href="CerpBomStock.Capt?bom=${bom_product.bom_code}">상세보기</a></td>


								</tr>
							</c:forEach>

						</tbody>
					</table>


					<button type="button" name="button1" value="update"
						onclick="javascript:popup(this.form);">수정</button>
					<button type="button" name="button1" value="update"
						onclick="javascript:popup2();">등록</button>	

				</form>

			</div>
		</div>

	</div>


	<script type="text/javascript" language="javascript">
		function popup(form) {

			var popuptitle = "BOM정보수정";
			var popupurl = "CerpBomUpdate.Capt";
			var popupstatus = "scrollbars=no,resizable=yes,status=yes,toolbar=no,directories=no,menubar=no,width=1200, height=1300, top=100,left=0";
			window.open("", popuptitle, popupstatus);

			form.target = popuptitle;
			form.action = popupurl;
			form.method = "post";
			form.submit();
		}

		function popup2() {

			var popuptitle = "BOM등록";
			var popupurl = "CerpBomBaseInsert.Capt";
			var popupstatus = "scrollbars=no,resizable=no,status=no,toolbar=no,directories=no,menubar=no,width=1240, height=900, top=100,left=100";
			window.open(popupurl, popuptitle, popupstatus);

		}
	</script>


	</script>


</body>
</html>


