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
			<jsp:include page="New_left_menu_Management.jsp"></jsp:include>
		</div>

		<div id="contentpage">
			<div class="cp">
				<h4>재고증감량 현황</h4>
			</div>
			
			<div class="cp wd">
				<div class="bds">
					<form action="CerpLogSearch.Capt" method="post">
						<div id="radiocontent">
							<input type="radio" id="radio1" name="item" value="itemcode">
							<label for="itemcode">품목코드</label> 
							<input type="radio" style="margin-left: 10px;" id="radio2" name="item"
								value="itemname" checked="checked"> 
							<label for="itemname">품목명</label>
							<input type="radio" style="margin-left: 10px;" id="radio3" name="item"
								value="clientname"> 
							<label for="itemname">거래처명</label>
							<br>
							
							<label for="timeLike">갱신일자</label>
						    <input type="date" id="first" name="firstdate" value="2022-11-01"> ~ <input type="date" id="first" name="firstdate2" value="2022-12-31">
						    <br>
							
							<label for="itemLike" style="margin-left: 10px;">분류별</label> 
							<select name="Like">
							<option value="ALL" selected>모두</option>
							<option value="입고">입고</option>
							<option value="출고">출고</option>
							<option value="반품">반품</option>
							<option value="생산입고">생산입고</option>
							<option value="생산출고">생산출고</option>
							<option value="수주출고">수주출고</option>
							</select> 
							
							<label for="onlyproduct" style="margin-left: 10px;">창고</label>
							<select name="Like2">
							<option value="ALL" selected>모두</option>
							<c:forEach var="st" items="${st}" varStatus="status">
								<option value="${st.warename}">${st.warename}</option>
							</c:forEach>
							</select>
							
							<label for="itemOrder">정렬기준</label> 
							<select name="Order">
							<option value="ALL" selected>기준없음</option>
							<option value="INASC">재고 오름차순</option>
							<option value="INDESC">재고 내림차순</option>
							</select>
							
							<input type="text" placeholder="검색어를 입력하세요." name="search" id="id1">
							<button type="submit" id="submit" onclick="">검색하기</button>
						</div>
					</form>
				</div>

				<div class="cp">
					<form action="" id="setRows">
						<p  style="margin-bottom:0;">
							<input type="text" name="rowPerPage" value="10"
								style="width: 80px; border-radius: 6px;">개씩 보기
						</p>
					</form>

				</div>

				<div class="cp">
					<div>

						<form method="post" name="LogData" id="LogData">
							<table id="products" cellspacing="0" cellpadding="0">

								<thead>
									<tr style="text-align: center;">
										<th width="14%" height="30px">갱신일자</th>
										<th width="12%" height="30px">품목코드</th>
										<th width="24%" height="30px">품목명</th>
										<th width="12%" height="30px">거래처명</th>
										<th width="12%" height="30px">창고명</th>
										
										<th width="8%" height="30px">수량</th>
										<th width="8%" height="30px">재고수</th>
										<th width="10%" height="30px">분류</th>

									</tr>
								</thead>

								<tbody>


									<c:forEach var="log" items="${log}" varStatus="status">
										<tr>
											<td width="14%" height="30px" align="center">${log.holdingday}</td>
											<td width="12%" height="30px" align="center">${log.itemcode}</td>
											<td width="24%" height="30px" align="center">${log.itemname}</td>
											<td width="12%" height="30px" align="center">${log.clientname}</td>
											<td width="12%" height="30px" align="center">${log.warename}</td>
											
											<td width="8%" height="30px" align="center">${log.acount}</td>
											<td width="8%" height="30px" align="center">${log.changeacount}</td>
											<td width="10%" height="30px" align="center">${log.log_like}</td>

										</tr>
									</c:forEach>

								</tbody>
							</table>

						</form>

					</div>

				</div>


			</div>

		</div>

	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script type="text/javascript">
		var $setRows = $('#setRows');

		$setRows
				.submit(function(e) {
					e.preventDefault();
					var rowPerPage = $('[name="rowPerPage"]').val() * 1;// 1 을  곱하여 문자열을 숫자형로 변환

					//		console.log(typeof rowPerPage);

					var zeroWarning = 'Sorry, but we cat\'t display "0" rows page. + \nPlease try again.'
					if (!rowPerPage) {
						alert(zeroWarning);
						return;
					}
					$('#nav').remove();
					var $products = $('#products');

					$products.after('<div id="nav">');

					var $tr = $($products).find('tbody tr');
					var rowTotals = $tr.length;
					//	console.log(rowTotals);

					var pageTotal = Math.ceil(rowTotals / rowPerPage);
					var i = 0;

					for (; i < pageTotal; i++) {
						$('<a href="#"></a>').attr('rel', i).html(i + 1)
								.appendTo('#nav');
					}

					$tr.addClass('off-screen').slice(0, rowPerPage)
							.removeClass('off-screen');

					var $pagingLink = $('#nav a');
					$pagingLink.on('click', function(evt) {
						evt.preventDefault();
						var $this = $(this);
						if ($this.hasClass('active')) {
							return;
						}
						$pagingLink.removeClass('active');
						$this.addClass('active');

						// 0 => 0(0*4), 4(0*4+4)
						// 1 => 4(1*4), 8(1*4+4)
						// 2 => 8(2*4), 12(2*4+4)
						// 시작 행 = 페이지 번호 * 페이지당 행수
						// 끝 행 = 시작 행 + 페이지당 행수

						var currPage = $this.attr('rel');
						var startItem = currPage * rowPerPage;
						var endItem = startItem + rowPerPage;

						$tr.css('opacity', '0.0').addClass('off-screen').slice(
								startItem, endItem).removeClass('off-screen')
								.animate({
									opacity : 1
								}, 300);

					});

					$pagingLink.filter(':first').addClass('active');

				});

		$setRows.submit();
	</script>

</body>
</html>


