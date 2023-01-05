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


	
	
	
	<div> 수주한 품목을 선택해주세요.  </div>
	
  <br>

<table cellspacing="0" cellpadding="0">
<tbody>
	<tr>
		<td width="10%" height="30px" align="center">선택</td>
		<td width="26%" height="30px" align="center">품목코드</td>
		<td width="44%" height="30px" align="center">품목명</td>
		<td width="20%" height="30px" align="center">출고단가</td>
		
	
	
	</tr>
	
	
		
	<c:forEach var="item" items="${item}" varStatus="status">			
	<tr >
		<td width="10%" height="30px" align="center"> <input type="radio" id="radio4" name="select" value=${item.itemcode}></td>
		<td width="26%" height="30px" align="center"><input type="text" value='${item.itemcode}' readonly></td>
		<td width="44%" height="30px" align="center" ><input type="text" value='${item.itemname}'id=${item.itemcode} readonly></td>
		<td width="20%" height="30px" align="center" ><input type="text" value='${item.forwarding_price}'id='${item.itemcode}f' readonly></td>
	
	</tr>
	</c:forEach>
	
</tbody>
</table>
		
	<button type="button" id="button" class="btsize" name="action" value="item" onclick="javascript:commit();">선택항목 추가</button><br>
	


	
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
function commit()
{
	var val;
	var itemid = document.getElementsByName("select");
	for(var i=0; i < itemid.length; i++) {
		if(itemid[i].checked === true) { 
	  	val=itemid[i].value 
	  }
	}
	


	var forwarding = document.getElementById(val+"f").value;
    var itemname = document.getElementById(val).value;
    window.opener.document.getElementById("itemname").value = itemname;
    window.opener.document.getElementById("p_forwarding").value = forwarding;
    window.opener.totalamount();
    window.close();
                                       
  
  }
</script>
</body>
</html>


