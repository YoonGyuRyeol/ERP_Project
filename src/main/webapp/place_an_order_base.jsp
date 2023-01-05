<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="HF1.css">
<link rel="stylesheet" type="text/css" href="main.css">

<style>
</style>
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
			<jsp:include page="New_left_menu_PrManage.jsp"></jsp:include>
		</div>

		<div id="contentpage">
			<div class="cp">
				<h4>발주 관리</h4>
			</div>
			
			<div class="cp wd">
				<div class="bds">
				<!-- 
					<form action="CerpPoSearch.Capt" method="post">
						<div id="radiocontent">
							<input type="radio" id="radio1" name="item" value="warename">
							<label for="itemcode">창고명</label>
							<input type="radio" id="radio2" name="item" value="pocode" checked="checked" style="margin-left: 10px;">
							<label for="itemname">발주코드</label>
							<input type="radio" id="radio2" name="item" value="ename" checked="checked" style="margin-left: 10px;">
							<label for="itemname">담당직원</label><br>
							<label for="itemLike">발주일자</label>
							<input type="date" id="first" name="firstdate" value="2018-01-01">
							~ <input type="date" id="first" name="firstdate2"
								value="2022-12-31">
							<label for="onlyproduct" style="margin-left: 10px;">마감일자</label>
							<input type="date" id="final" name="finaldate"value="2018-01-01"> ~ 
							<input type="date" id="final" name="finaldate2" value="2022-12-31">
							<label for="itemOrder" style="margin-left: 10px;">진행상태</label>
							<select name="Progress">
								<option value="ALL" selected>기준없음</option>
								<option value="Check">재고확인</option>
								<option value="Place_an_order">발주신청</option>
								<option value="warehousing">입고완료</option>
								<option value="outing">출고완료</option>
							</select>
						</div>
						<input type="text" placeholder="검색어를 입력하세요." name="search" id="id1">
						<button type="submit" id="submit" onclick="">검색하기</button>
					</form>
				 -->
					
					<form action="CerpPoSearch.Capt" method="post">
						<div id="radiocontent">
							<input type="radio" id="radio1" name="item" value="warename">
							<label for="itemcode">창고명</label>
							<input type="radio" id="radio2" name="item" value="pocode" checked="checked" style="margin-left: 10px;">
							<label for="itemname">발주코드</label>
							<input type="radio" id="radio2" name="item" value="ename" checked="checked" style="margin-left: 10px;">
							<label for="itemname">담당직원</label><br>
						    <label for="itemLike">발주일자</label>
						    <input type="date" id="first" name="firstdate" value="2018-01-01"> ~ <input type="date" id="first" name="firstdate2" value="2022-12-31">
						    
						 	<label for="onlyproduct" style="margin-left: 10px;">마감일자</label>
						    <input type="date" id="final" name="finaldate" value="2018-01-01"> ~ <input type="date" id="final" name="finaldate2" value="2022-12-31">
						 
						 	<label for="itemOrder" style="margin-left: 10px;">진행상태</label>
						    <select name = "Progress">
						        <option value = "ALL" selected>기준없음</option>
						        <option value = "Place_an_order">발주확인</option>
						        <option value = "warehousing">입고완료</option>
						        <option value = "outing">출고완료</option>
							</select>
					    </div>
						<input type="text" placeholder="검색어를 입력하세요." name="search" id="id1">
					    <button type="submit" id="submit" onclick="">검색하기</button>
					</form>
					
				</div>
			</div>
			
			<div class="cp">
				<form action="" id="setRows">
					<p>
						<input type="text" name="rowPerPage" value="10"
							style="width: 80px; border-radius: 6px;">개씩 보기
					</p>
				</form>

			</div>

			<div class="cp wd" style="width:80%;">
				<div>
					<form method="post" name="poData" id="poData">
						<table id="products" cellspacing="0" cellpadding="0">
							<thead>
								<tr style="text-align: center;">
									<th width="5%" height="30px">선택</th>
									<th width="10%" height="30px">발주코드</th>
									<th width="9%" height="30px">창고명</th>
									<th width="10%" height="30px">발주날짜</th>
									<th width="10%" height="30px">마감날짜</th>
									<th width="10%" height="30px">공급가액</th>
									<th width="10%" height="30px">총금액</th>
									<th width="9%" height="30px">담당직원</th>
									<th width="10%" height="30px">직원코드</th>
									
									<th width="10%" height="30px">진행상태</th>
									<th width="7%" height="30px">상세보기</th>
								</tr>
							</thead>
							
							<tbody>

								<c:forEach var="po" items="${po}" varStatus="status">
									<tr>
										<td width="5%" height="30px" align="center"><input
											type="radio" id="radio4" name="select" value=${po.placecode}></td>
										<td width="10%" height="30px" align="center">${po.placecode}</td>
										<td width="9%" height="30px" align="center">${po.warename}</td>
										<td width="10%" height="30px" align="center">${po.orderday}</td>
										<td width="10%" height="30px" align="center">${po.delivery_day}</td>
										<td width="10%" height="30px" align="center">${po.sv}</td>
										<td width="10%" height="30px" align="center">${po.total_amount}</td>
										
										<td width="9%" height="30px" align="center">${po.name}</td>
										<td width="10%" height="30px" align="center">${po.ecode}</td>
										<td width="10%" height="30px" align="center">${po.progress_status}</td>
										<td width="7%" height="30px" align="center"><a
											href="CerpPoStock.Capt?po=${po.placecode}">상세</a></td>


									</tr>
								</c:forEach>

							</tbody>
						</table>


						<button type="button" name="button1" value="update"
							onclick="javascript:popup(this.form);">수정</button>
						<button type="button" name="button1" value="update"
							onclick="javascript:popup2();">등록</button>
							
						<button type="button" name="button1" value="update"
							onclick="javascript:popup3(this.form);">세금계산서</button>


					</form>

				</div>
			</div>

		</div>

	</div>


	<script type="text/javascript" language="javascript">
		function popup(form) {

			var popuptitle = "발주정보수정";
			var popupurl = "CerpPoUpdate.Capt";
			var popupstatus = "scrollbars=no,resizable=yes,status=yes,toolbar=no,directories=no,menubar=no,width=1900, height=1300, top=100,left=0";
			window.open("", popuptitle, popupstatus);

			form.target = popuptitle;
			form.action = popupurl;
			form.method = "post";
			form.submit();
		}

		function popup2() {

			var popuptitle = "발주등록";
			var popupurl = "CerpPoInsert.Capt";
			var popupstatus = "scrollbars=no,resizable=no,status=no,toolbar=no,directories=no,menubar=no,width=1240, height=900, top=100,left=100";
			window.open(popupurl, popuptitle, popupstatus);

		}
		
		function popup3(form) {

			var popuptitle = "세금계산서";
			var popupurl = "CerpPOTaxbill.Capt";
			var popupstatus = "scrollbars=no,resizable=no,status=no,toolbar=no,directories=no,menubar=no,width=1340, height=900, top=100,left=100";
			window.open("", popuptitle, popupstatus);

			form.target = popuptitle;
			form.action = popupurl;
			form.method = "post";
			form.submit();
		}
	</script>

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


