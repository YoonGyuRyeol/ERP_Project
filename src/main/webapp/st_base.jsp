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
				<h4>창고 관리</h4>
			</div>
			
			<div class="cp wd">
				<div class="bds">
				<!-- 
					<form action="CerpStSearch.Capt" method="post">
						<div id="radiocontent">
							<input type="radio" id="radio1" name="item" value="itemcode">
							<label for="itemcode">창고코드</label> 
							<input type="radio" style="margin-left:10px;"
								id="radio2" name="item" value="itemname" checked="checked">
							<label for="itemname">창고명</label>
							<br>
							
							<label for="onlyproduct" style="margin-left:10px;">창고구분</label> 
							<select name="Like">
								<option value="ALL" selected>모두</option>
								<option value="제품">제품 창고</option>
								<option value="부품">부품 창고</option>
								<option value="가입고">가입고 창고</option>
								<option value="불량품">불량품 창고</option>
							</select>
							
							<input type="text" placeholder="검색어를 입력하세요." name="search" id="id1">
							<button type="submit" id="submit" onclick="">검색하기</button>
						</div>
					</form>
				 -->	
					
					<form action="CerpStSearch.Capt" method="post">
						<div id="radiocontent">
						<input type="radio" id="radio1" name="item" value="itemcode">
						<label for="itemcode">창고코드</label>
						<input type="radio" id="radio2" name="item" value="itemname" checked="checked" style="margin-left:10px;">
						<label for="itemname">창고명</label>
						<br>
					 	<label for="onlyproduct" style="margin-left:10px;">창고구분</label>
					    <select name = "Like">
					        <option value = "ALL" selected>모두</option>
					          <option value = "제품" >제품 창고</option>
					          <option value = "부품">부품 창고</option>
					          <option value = "가입고">가입고 창고</option>
					          <option value = "불량품">불량품 창고</option>
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
					<form method="post" name="StData" id="StData">
						<table id="products" cellspacing="0" cellpadding="0">
							<thead>
								<tr style="text-align: center;">
									<th width="10%" height="30px">선택</th>
									<th width="20%" height="30px">창고코드</th>
									<th width="30%" height="30px">창고명</th>
									<th width="20%" height="30px">창고구분</th>
									<th width="20%" height="30px">사용여부</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="st" items="${st}" varStatus="status">
									<tr>
										<td width="8%" height="30px" align="center"><input
											type="radio" id="radio4" name="select" value=${st.warecode}></td>
										<td width="12%" height="30px" align="center">${st.warecode}</td>
										<td width="40%" height="30px" align="center">${st.warename}</td>
										<td width="10%" height="30px" align="center">${st.warelike}</td>
										<td width="10%" height="30px" align="center">${st.usecheck}</td>
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

	</div>


	<script type="text/javascript" language="javascript">
		function popup(form) {

			var popuptitle = "창고정보수정";
			var popupurl = "CerpStUpdate.Capt";
			var popupstatus = "scrollbars=no,resizable=no,status=no,toolbar=no,directories=no,menubar=no,width=750, height=550, top=100,left=100";
			window.open("", popuptitle, popupstatus);

			form.target = popuptitle;
			form.action = popupurl;
			form.method = "post";
			form.submit();
		}

		function popup2() {

			var popuptitle = "창고등록";
			var popupurl = "CerpStInsert.Capt";
			var popupstatus = "scrollbars=no,resizable=no,status=no,toolbar=no,directories=no,menubar=no,width=940, height=300, top=100,left=100";
			window.open(popupurl, popuptitle, popupstatus);

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


