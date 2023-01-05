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


	
	
	
	<div> 수주한 사원을 선택해주세요.  </div>
	
  <br>

<table cellspacing="0" cellpadding="0">
<tbody>
	<tr>
		<td width="10%" height="30px" align="center">선택</td>
		<td width="26%" height="30px" align="center">사원코드</td>
		<td width="24%" height="30px" align="center">사원명</td>
		<td width="20%" height="30px" align="center">부서</td>
		<td width="20%" height="30px" align="center">직위</td>
	
	
	</tr>
	
	
		
	<c:forEach var="employee" items="${employee}" varStatus="status">			
	<tr >
		<td width="10%" height="30px" align="center"> <input type="radio" id="radio4" name="select" value=${employee.ecode}></td>
		<td width="26%" height="30px" align="center"><input type="text" value='${employee.ecode}' readonly></td>
		<td width="24%" height="30px" align="center" ><input type="text" value='${employee.name}'id=${employee.ecode} readonly></td>
		<td width="20%" height="30px" align="center" ><input type="text" value='${employee.department}'id='${employee.ecode}d' readonly></td>
		<td width="20%" height="30px" align="center" ><input type="text" value='${employee.position}'id='${employee.ecode}p' readonly></td>
	</tr>
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
	


	
    var name = document.getElementById(val).value;
    window.opener.document.getElementById("name").value = name;
    window.opener.document.getElementById("ecode").value = val;
   
    window.close();
                                       
  
  }
</script>
</body>
</html>


