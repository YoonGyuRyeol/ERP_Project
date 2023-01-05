<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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


<form action="CerpPoUpdateOneFinish.Capt" method="post">
<table cellspacing="0" cellpadding="0">

	
	<div style="color:red;"> 발주코드 : <input type="text"  name="placecode" id="" value='${pos.placecode}' readonly></div>
	<div style="color:red;"> 부품코드 : <input type="text"  name="itemcode" id="" value='${pos.itemcode}' readonly></div>
	<div style="color:red;"> 부품명 :  <input type="text"  name="itemname" id="" value='${pos.itemname}' readonly></div>
	거래처명 : <input type="text"  name="clientname" id="clientname" value=${pos.clientname} readonly> <br>
	<button type="button" id="button" class="btsize" name="action" value="update" onclick="javascript:popupclient(this.form);" readonly>거래처불러오기</button>	<br>
	부품개수 : <input type="text"  name="count" id="" value=${pos.count}> <br>
		
	<button type="submit" id="submit2" class="btsize" name="action" value="delete" >수정하기</button><br>

</table>
	</form>
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

<script>
function popupclient(form)
{
  
  var popuptitle  = "거래처 정보 불러오기";
  var popupurl    ="CerpOrderClient.Capt";
  var popupstatus = "scrollbars=no,resizable=yes,status=yes,toolbar=no,directories=no,menubar=no,width=700, height=1000, top=100,left=0"; 
  window.open(popupurl, popuptitle,popupstatus); 
                                       
  
  }
</script>
</body>
</html>


