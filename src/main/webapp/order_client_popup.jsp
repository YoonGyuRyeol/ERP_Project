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


	
	
	
	<div> 수주한 거래처를 선택해주세요.  </div>
	
  <br>

<table cellspacing="0" cellpadding="0">
<tbody>
	<tr>
		<td width="10%" height="30px" align="center">선택</td>
		<td width="26%" height="30px" align="center">거래처코드</td>
		<td width="64%" height="30px" align="center">거래처명</td>
		
		
	
	
	</tr>
	
	
		
	<c:forEach var="Client" items="${Client}" varStatus="status">			
	<tr >
		<td width="10%" height="30px" align="center"> <input type="radio" id="radio4" name="select" value=${Client.clientcode}></td>
		<td width="26%" height="30px" align="center"><input type="text" value='${Client.clientcode}' readonly></td>
		<td width="64%" height="30px" align="center" ><input type="text" value='${Client.clientname}'id=${Client.clientcode} readonly></td>
		
	
	</tr>
	</c:forEach>
	
</tbody>
</table>
		
	<button type="button" id="button" class="btsize" name="action" value="client" onclick="javascript:commit();">선택항목 추가</button><br>
	


	
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
	var clientid = document.getElementsByName("select");
	for(var i=0; i < clientid.length; i++) {
		if(clientid[i].checked === true) { 
	  	val=clientid[i].value 
	  }
	}
	
    var clientname = document.getElementById(val).value;
    window.opener.document.getElementById("clientname").value = clientname;
    
    window.close();
                                       
  
  }
</script>
</body>
</html>


