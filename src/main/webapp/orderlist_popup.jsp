<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" href="mainpop.css">



<style>
#main{
width:85%;
}
#content1{
width:90%;
}
#submit{
margin-left : 270px;
}
#content2{
margin-top :100px;
width :90%;
}
table{
font-size:14px;
}

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


	
	
	
	<div> 수주서를 선택해주세요.  </div>
	
  <br>

<table cellspacing="0" cellpadding="0">
<tbody>
	<tr>
		<td width="5%" height="30px" align="center">선택</td>
		<td width="8%" height="30px" align="center">수주코드</td>
		<td width="10%" height="30px" align="center">거래처명</td>
		<td width="15%" height="30px" align="center">제품명</td>
		<td width="10%" height="30px" align="center">수주날짜</td>
		<td width="10%" height="30px" align="center">마감날짜</td>
		<td width="5%" height="30px" align="center">출고단가</td>
		<td width="3%" height="30px" align="center">개수</td>
		<td width="7%" height="30px" align="center">총금액</td>
		<td width="7%" height="30px" align="center">총금액[부가세 포함]</td>
		<td width="5%" height="30px" align="center">담당직원코드</td>
		<td width="5%" height="30px" align="center">담당직원명</td>
	</tr>
	
	
		
	<c:forEach var="order" items="${order}" varStatus="status">			
	<tr >
		<td width="5%" height="30px" align="center"> <input type="radio" id="radio4" name="select" value=${order.ordercode}></td>
		<td width="8%" height="30px" align="center">${order.ordercode}</td>
		<td width="10%" height="30px" align="center" >${order.clientname}</td>
		<td width="15%" height="30px" align="center" ><input type="text" style="width:200px;" value='${order.itemname}'id='${order.ordercode}i' readonly></td>
		<td width="10%" height="30px" align="center" ><input type="text" style="width:120px;" value='${order.orderday}'id='${order.ordercode}o' readonly></td>
		<td width="10%" height="30px" align="center" ><input type="text" style="width:120px;" value='${order.delivery_day}'id='${order.ordercode}d' readonly></td>
		<td width="5%" height="30px" align="center" >${order.forwarding_price}</td>
		<td width="3%" height="30px" align="center" ><input type="text" style="width:50px;" value='${order.count}'id='${order.ordercode}c' readonly></td>
		<td width="7%" height="30px" align="center" >${order.sv}</td>
		<td width="7%" height="30px" align="center" >${order.total_amount}</td>
		<td width="5%" height="30px" align="center" ><input type="text" style="width:80px;" value='${order.ecode}'id='${order.ordercode}e' readonly></td>
		<td width="5%" height="30px" align="center" ><input type="text" style="width:80px;" value='${order.name}'id='${order.ordercode}n' readonly></td>
		
	
	</tr>
	<input type="hidden" value='${order.acount}'id='${order.ordercode}ac' readonly>
	</c:forEach>
	
</tbody>
</table>
		
	<button type="button" id="button" class="btsize" name="action" value="employee" onclick="javascript:commit();">선택항목 추가</button><br>
	


	
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
	var id = document.getElementsByName("select");
	for(var i=0; i < id.length; i++) {
		if(id[i].checked === true) { 
	  	val=id[i].value 
	  }
	}
	var ecode = document.getElementById(val+"e").value;
	var name = document.getElementById(val+"n").value;
	var count = document.getElementById(val+"c").value;
	var orderday = document.getElementById(val+"o").value.replace(/ [0-9][0-9]:[0-9][0-9]:[0-9][0-9]/g, "");
	var delivery_day = document.getElementById(val+"d").value.replace(/ [0-9][0-9]:[0-9][0-9]:[0-9][0-9]/g, "");
    var itemname = document.getElementById(val+"i").value;
    var acount = document.getElementById(val+"ac").value;
    window.opener.document.getElementById("itemname").value = itemname;
    window.opener.document.getElementById("ecode").value = ecode;
    window.opener.document.getElementById("name").value = name;
    window.opener.document.getElementById("count").value = count;
    window.opener.document.getElementById("orderday").value = orderday;
    window.opener.document.getElementById("delivery_day").value = delivery_day;
    window.opener.document.getElementById("ordercode").value = val;
    window.opener.document.getElementById("nowholding").value = acount;
    window.opener.needamount();
    
	window.close();
  
   

                                       
  
  }
</script>
</body>
</html>


