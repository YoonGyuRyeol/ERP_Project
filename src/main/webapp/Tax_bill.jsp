<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body, td, div, form, input, select {
	font-size: 9pt;
	color: #2D425B;
	overflow: auto;
}

.hrline {
	border-bottom: 1px solid #f2f2f2;
}

.i_no {
	font-size: 7pt;
	font-family: Tahoma, verdana;
	font-weight: bold;
	color: #bbbbbb;
	border-bottom: 1px solid #f2f2f2;
}

A:link {
	text-decoration: underline;
	color: #0055ff;
}

A:visited {
	text-decoration: underline;
	color: #0055ff;
}

A:hover {
	color: #0055ff;
	text-decoration: underline;
}
</style>
<title>Insert title here</title>
</head>
<<body topmargin="0" rightmargin="0" leftmargin="0" bgcolor="#ffffff" style="border-width:0" onload="selection_check()">
<div style="padding-left:10"><br>  
<table border="0" align="center">
      <tbody>
      <tr>
        <td colspan="2" align="center">
          <table border="1" cellpadding="2" cellspacing="0" width="630" bordercolorlight="blue" bordercolordark="#FFFFFF" style="border:2px solid #0000ff;">
            <tbody>
            <tr>
              <td colspan="4" align="center" height="50"><font size="6" color="blue"><b>세금계산서</b></font> <font color="blue">(공급받는자보관용)</font></td>
            </tr>
            <tr>
              <td colspan="4">
                <table width="100%" border="1" cellspacing="0" cellpadding="2" bordercolorlight="blue" bordercolordark="#FFFFFF" background="./img/admin/stamp.gif" style="background-repeat:no-repeat;">
                  <tbody>
                  <tr>
                    <td rowspan="4" width="20" align="center"><font color="blue">공<br>급<br>자</font></td>
                    <td width="64"><font color="blue">등록번호</font></td>
                    <td width="225" colspan="4">&nbsp;</td>
                    <td rowspan="4" width="21" align="center"><font color="blue">공<br>급<br>받<br>는<br>자</font></td>
                    <td width="62"><font color="blue">등록번호</font></td>
                    <td width="264" colspan="4">&nbsp;</td>
                  </tr>
                  <tr>
                    <td width="64"><font color="blue">상 호<br>(법인명)</font></td>
                    <td colspan="2" width="106">&nbsp;</td>
                    <td width="19"><font color="blue">성<br>명</font></td>
                    <td width="88">&nbsp;</td>
                    <td width="62"><font color="blue">상 호<br>(법인명)</font></td>
                    <td colspan="2" width="133">
                    	<input type="text"  name="clientname" id="clientname"  value=${order.clientname} readonly>
                    </td>
                    <td width="19"><font color="blue">성<br>명</font></td>
                    <td width="100">&nbsp;</td>
                  </tr>
                  <tr>
                    <td width="64"><font color="blue">사업장<br>주 소</font></td>
                    <td colspan="4" width="225">&nbsp;서울 도봉구 방학동 322-41 중세빌딩7층 2호</td>
                    <td width="62"><font color="blue">사업장<br>주 소</font></td>
                    <td colspan="4" width="264">&nbsp;울산 남구 삼산동 화성 아데라움 4-102</td>
                  </tr>
                  <tr>
                    <td width="64"><font color="blue">업 태</font></td>
                    <td width="82">&nbsp;</td>
                    <td width="18"><font color="blue">종<br>목</font></td>
                    <td colspan="2" width="113">&nbsp;</td>
                    <td width="62"><font color="blue">업 태</font></td>
                    <td width="109">&nbsp;</td>
                    <td width="18"><font color="blue">종<br>목</font></td>
                    <td colspan="2" width="125">&nbsp;</td>
                  </tr>
                </tbody>
                </table>
              </td>
            </tr>
            <tr>
              <td align="center" height="25"><font color="blue">작 &nbsp;&nbsp;성</font></td>
              <td align="center"><font color="blue">공 &nbsp;&nbsp;급 &nbsp;&nbsp;가&nbsp;&nbsp;액</font></td>
              <td align="center"><font color="blue">세 &nbsp;&nbsp;액</font></td>
              <td align="center"><font color="blue">비 &nbsp;&nbsp;고</font></td>
            </tr>
            <tr>
              <td height="45" align="center">&nbsp;2007/05/21</td>
              <td height="45" align="right">&nbsp;
              	<input type="text"  name="sv" id="sv" value=${order.sv} readonly >&nbsp;&nbsp;
              </td>
              <td height="45" align="right">&nbsp;13,500&nbsp;&nbsp;</td>
              <td height="45" align="center">&nbsp;</td>
            </tr>
            <tr>
              <td colspan="4" height="86">
                <table border="1" cellpadding="1" cellspacing="0" width="100%" bordercolorlight="blue" bordercolordark="#FFFFFF">
                  <tbody><tr align="center">
                    <td><font color="blue">월</font></td>
                    <td><font color="blue">일</font></td>
                    <td><font color="blue">품 목</font></td>
                    <td><font color="blue">규 격</font></td>
                    <td><font color="blue">수 량</font></td>
                    <td><font color="blue">단 가</font></td>
                    <td><font color="blue">공 급 가 액</font></td>
                    <td><font color="blue">세 액</font></td>
                    <td><font color="blue">비 고</font></td>
                  </tr>
                  <tr>
                    <td align="center">&nbsp;05</td>
                    <td align="center">&nbsp;21</td>
                    <td>&nbsp;CTEX 5892</td>
                    <td>&nbsp;</td>
                    <td align="center">&nbsp;1</td>
                    <td align="right">&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td align="right">&nbsp;135,000&nbsp;&nbsp;</td>
                    <td align="right">&nbsp;13,500&nbsp;&nbsp;</td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td align="center">&nbsp;&nbsp;</td>
                    <td align="center">&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;</td>
                    <td>&nbsp;</td>
                    <td align="center">&nbsp;&nbsp;</td>
                    <td align="right">&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td align="right">&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td align="right">&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td align="center">&nbsp;&nbsp;</td>
                    <td align="center">&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;</td>
                    <td>&nbsp;</td>
                    <td align="center">&nbsp;&nbsp;</td>
                    <td align="right">&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td align="right">&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td align="right">&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td align="center">&nbsp;&nbsp;</td>
                    <td align="center">&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;</td>
                    <td>&nbsp;</td>
                    <td align="center">&nbsp;&nbsp;</td>
                    <td align="right">&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td align="right">&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td align="right">&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td>&nbsp;</td>
                  </tr>
                </tbody>
                </table>
              </td>
            </tr>
            <tr>
              <td colspan="4">
                <table border="1" cellpadding="1" cellspacing="0" width="100%" bordercolorlight="blue" bordercolordark="#FFFFFF">
                  <tbody><tr align="center">
                    <td><font color="blue">합 계 금 액</font></td>
                    <td><font color="blue">현 금</font></td>
                    <td><font color="blue">수 표</font></td>
                    <td><font color="blue">어 음</font></td>
                    <td><font color="blue">외 상 미 수 금</font></td>
                    <td rowspan="2" width="120" align="center"><font color="blue">이 금액을 영수 함.<br></font></td>
                  </tr>
                  <tr align="center">
                    <td>
                    	<input type="text"  name="total_amount" id="total_amount" value=${order.total_amount} readonly >
                    </td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                  </tr>
                </tbody>
                </table>
              </td>
            </tr>
          </tbody>
          </table>
        </td>
      </tr>
  </tbody>
 </table>
</div>
<script>
function popupclient(form)
{
  
  var popuptitle  = "거래처 정보 불러오기";
  var popupurl    ="CerpOrderClient.Capt";
  var popupstatus = "scrollbars=no,resizable=yes,status=yes,toolbar=no,directories=no,menubar=no,width=700, height=1000, top=100,left=0"; 
  window.open(popupurl, popuptitle,popupstatus); 
                                       
  
  }
function popupitem(form)
{
  
  var popuptitle  = "제품 정보 불러오기";
  var popupurl    ="CerpOrderItem.Capt";
  var popupstatus = "scrollbars=no,resizable=yes,status=yes,toolbar=no,directories=no,menubar=no,width=700, height=1000, top=100,left=0"; 
  window.open(popupurl, popuptitle,popupstatus); 
                                       
  
  }
function popupemployee(form)
{
  
  var popuptitle  = "직원 불러오기";
  var popupurl    ="CerpOrderEmployee.Capt";
  var popupstatus = "scrollbars=no,resizable=yes,status=yes,toolbar=no,directories=no,menubar=no,width=900, height=1000, top=100,left=0"; 
  window.open(popupurl, popuptitle,popupstatus); 
                                       
  
  }
function totalamount()
{
  var forwarding = document.getElementById("p_forwarding").value.replace(/,/g, "");
  var acount = document.getElementById("count").value;
  document.getElementById('sv').value = Math.round(parseInt(forwarding) * parseInt(acount)).toLocaleString('ko-KR');
  document.getElementById('total_amount').value = Math.round(parseInt(forwarding) * parseInt(acount) * 1.1).toLocaleString('ko-KR');
}


  </script>
</body>
</html>