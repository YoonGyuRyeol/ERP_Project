<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<h3 style="margin-top: 10px; margin-left: 15px; font-family: Georgia, Verdana, sans-serif;">기초정보</h3>
<div
	class="flex-column align-items-stretch flex-shrink-0 bg-white"
	style="width: 150px;">
	<div class="list-group-flush border-bottom border-top scrollarea">
		<a href="CerpCompany.Capt"
			class="list-group-item list-group-item-action py-3 lh-tight">
			<div class="d-flex w-100 align-items-center justify-content-between">
				<strong class="mb-1">회사 정보</strong>
			</div>
		</a> 
		<a href="CerpClient.Capt"
			class="list-group-item list-group-item-action py-3 lh-tight">
			<div class="d-flex w-100 align-items-center justify-content-between">
				<strong class="mb-1">거래처 정보</strong>
			</div>
		</a> 
		<a href="CerpItem.Capt"
			class="list-group-item list-group-item-action py-3 lh-tight">
			<div class="d-flex w-100 align-items-center justify-content-between">
				<strong class="mb-1">품목 등록</strong>
			</div>
		</a> 
		<a href="CerpBom.Capt"
			class="list-group-item list-group-item-action py-3 lh-tight"
			aria-current="true">
			<div class="d-flex w-100 align-items-center justify-content-between">
				<strong class="mb-1">BOM 등록</strong>
			</div>
		</a>
	</div>
</div>
