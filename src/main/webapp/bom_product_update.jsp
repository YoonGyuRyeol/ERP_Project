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
<div style="margin-bottom:20px;">
	<h1>BOM 수정</h1>
</div>

	<div style="color:red;"> 제품품목코드 : <input type="text" placeholder="itemcode" name="itemcode" id="itemcode" value=${bom_p.productcode} readonly></div>
	<div style="color:red;"> 제품이름 : <input type="text" placeholder="itemname" name="itemname" id="itemname" value=${bom_p.productname} readonly></div>
	<div style="color:red;"> 부품 개수 : <input type="text" placeholder="materials" name="materials" id="materials" value=${materials} readonly> </div>
	

<table cellspacing="0" cellpadding="0">
<tbody>
	<tr>
	<td width="4%" height="30px" align="center"> 선택</td>
		<td width="20%" height="30px" align="center">BOM코드</td>
		<td width="30%" height="30px" align="center">부품코드</td>
		<td width="30%" height="30px" align="center">부품명</td>
		<td width="16%" height="30px" align="center">필요한 부품 개수</td>
		
	
	
	</tr>
	
	<form action="CerpBomUpdateFinish.Capt" method="post">
	<input type="hidden" name="bom_code_hidden" value=${bom_p.bom_code}>		
	<c:forEach var="bom_stock" items="${bom_stock}" varStatus="status">			
	<tr>
		<td width="4%" height="30px" align="center"> <input type="radio" id="radio4" name="select" value=${bom_stock.itemcode}></td>
		<td width="20%" height="30px" align="center"><input type="text" placeholder="bom_stock_code" name="bom_code" id=${bom_stock.bom_code} value=${bom_stock.bom_code} readonly></td>
		<td width="30%" height="30px" align="center"><input type="text" placeholder="stockcode" name="stockcode" id=${bom_stock.itemcode} value=${bom_stock.itemcode} readonly></td>
		<td width="30%" height="30px" align="center"><input style="width:270px;" type="text" placeholder="stockname" name="stockname" id=${bom_stock.itemname} value='${bom_stock.itemname}' readonly}></td>
		<td width="16%" height="30px" align="center"><input type="text" placeholder="stockmaterials" name="stockmaterials" id="bom_code" value=${bom_stock.materials}  readonly></td>
		
	
	</tr>
	
	
	
	</c:forEach>
		
	<button type="submit" id="submit2" class="btsize" name="action" value="delete" >선택항목 삭제</button><br>
	<button type="button" id="button" class="btsize" name="action" value="update" onclick="javascript:popup(this.form);">선택항목 수정</button><br>
	<button type="button" id="button" class="btsize" name="action" value="insert" onclick="javascript:popup2(this.form);">항목 추가하기</button>
	</form>
</tbody>
</table>
		
	<button type="button" id="button" class="btsize" name="action" value="insert" onclick="javascript:commit();">완료</button>
	


	
</div>
</div>

<c:if test="${refresh == 1}">
<script>


</script>
</c:if>
<c:if test="${refresh == 2}">
<script>

alert('값에 문제가 있어 수정할 수 없습니다.');
history.go(-1);
</script>
</c:if>
<script>

function commit(){
window.opener.location.reload();
window.close();
}
function popup(form)
{
  
  var popuptitle  = "BOM개별요소편집";
  var popupurl    ="CerpBomUpdateOne.Capt";
  var popupstatus = "scrollbars=no,resizable=yes,status=yes,toolbar=no,directories=no,menubar=no,width=700, height=1000, top=100,left=0"; 
  window.open("", popuptitle,popupstatus); 
                                       
  form.target = popuptitle;                    
  form.action = popupurl;                   
  form.method = "post";
  form.submit();     
  }
  
function popup2(form)
{
  
  var popuptitle  = "BOM개별요소추가";
  var popupurl    ="CerpBomInsertOne.Capt";
  var popupstatus = "scrollbars=no,resizable=yes,status=yes,toolbar=no,directories=no,menubar=no,width=700, height=1000, top=100,left=0"; 
  window.open("", popuptitle,popupstatus); 
                                       
  form.target = popuptitle;                    
  form.action = popupurl;                   
  form.method = "post";
  form.submit();     
  } 
  </script>
</body>
</html>


