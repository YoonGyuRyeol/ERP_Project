<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://html2canvas.hertzen.com/dist/html2canvas.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.4/jspdf.min.js"></script>
	<script type="text/javascript">
		
	</script>
</head>

<!-- 페이지를 pdf로 변환 후 다운로드 기능 제작 -->
<div id="capture">
<div class="divmargin" style="margin-left:130px;">
<table border="0">
      <tbody>
      <tr>
        <td colspan="2" >
          <table border="1" cellpadding="2" cellspacing="0" width="1200" bordercolorlight="blue" bordercolordark="#FFFFFF" style="border:2px solid #0000ff;">
            <tbody>
            <tr>
              <td colspan="4" align="center" height="50"><font size="6" color="blue"><b>세금계산서</b></font> <font color="blue">(공급받는자보관용)</font></td>
            </tr>
            <tr>
              <td colspan="4">
              	
                <table width="100%" border="1" cellspacing="0" cellpadding="2" bordercolorlight="blue" bordercolordark="#FFFFFF" background="./img/admin/stamp.gif" style="background-repeat:no-repeat; border-color:blue;">
                  <tbody>
                  <tr>
                    <td rowspan="4" width="20" align="center"><font color="blue">공<br>급<br>자</font></td>
                    <td width="64"><font color="blue">등록번호</font></td>
                    <td width="225" colspan="4" >474-41-55555</td>
                    <td rowspan="4" width="21" align="center"><font color="blue">공<br>급<br>받<br>는<br>자</font></td>
                    <td width="62"><font color="blue">등록번호</font></td>
                    <td width="264" colspan="4">174-31-77777</td>
                  </tr>
                  
                  <tr>
                    <td width="64"><font color="blue">상 호<br>(법인명)</font></td>
                    <td colspan="2" width="106"><c:out value='${order.clientname}'/></td>
                    <td width="19"><font color="blue">성<br>명</font></td>
                    <td width="88">김대표</td>
                    <td width="62"><font color="blue">상 호<br>(법인명)</font></td>
                    <td colspan="2" width="133">CerpPC</td>
                    <td width="19"><font color="blue">성<br>명</font></td>
                    <td width="100">윤대표</td>
                  </tr>
                  
                  <tr>
                    <td width="64"><font color="blue">사업장<br>주 소</font></td>
                    <td colspan="4" width="225">서울시 강서구</td>
                    <td width="62"><font color="blue">사업장<br>주 소</font></td>
                    <td colspan="4" width="264">서울시 은평구</td>
                  </tr>
                  <tr>
                    <td width="64"><font color="blue">업 태</font></td>
                    <td width="82">제조업</td>
                    <td width="18"><font color="blue">종<br>목</font></td>
                    <td colspan="2" width="113">서비스</td>
                    <td width="62"><font color="blue">업 태</font></td>
                    <td width="109">제조업</td>
                    <td width="18"><font color="blue">종<br>목</font></td>
                    <td colspan="2" width="125">서비스</td>
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
              <td height="45" align="center"><c:out value='${order.date}'/></td>
              <td height="45" align="right"><c:out value='${order.sv}'/></td>
              <td height="45" align="right">
             	 <c:out value='${order.tax}'/>
              </td>
              <td height="45" align="center">&nbsp;</td>
            </tr>
            <tr>
              <td colspan="4" height="86">
                <table border="1" cellpadding="1" cellspacing="0" width="100%" bordercolorlight="blue" bordercolordark="#FFFFFF" style="border-color:blue;">
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
                  
                  <!-- 여기부턴 c:foreach 사용해서 테이블 행 찍어줘야할듯 -->
                  <tr>
                    <td align="center"><c:out value='${order.mm}'/></td>
                    <td align="center"><c:out value='${order.dd}'/></td>
                    <td><c:out value='${order.itemname}'/> 외 <c:out value='${order.count}'/> 품목</td>
                    <td>개</td>
                    <td align="center"><c:out value='${order.sum}'/></td>
                    <td align="right"></td>
                    <td align="right"><c:out value='${order.sv}'/></td>
                    <td align="right"><c:out value='${order.tax}'/></td>
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
                <table border="1" cellpadding="1" cellspacing="0" width="100%" bordercolorlight="blue" bordercolordark="#FFFFFF" style="border-color:blue;">
                  <tbody><tr align="center">
                    <td><font color="blue">합 계 금 액</font></td>
                    <td><font color="blue">현 금</font></td>
                    <td><font color="blue">수 표</font></td>
                    <td><font color="blue">어 음</font></td>
                    <td><font color="blue">외 상 미 수 금</font></td>
                    <td rowspan="2" width="120" align="center"><font color="blue">이 금액을 영수 함.<br></font></td>
                  </tr>
                  <tr align="center">
                    <td><c:out value='${order.total_amount}'/></td>
                    <td><c:out value='${order.total_amount}'/></td>
                    <td></td>
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
</div>
<!-- 
<button onclick="abc()" id="savePdf" >세금계산서 PDF 다운로드</button>
 -->
<script language="javascript">
function abc(){
	html2canvas(document.querySelector("#capture")).then(canvas => {
	    // 캔버스를 이미지로 변환
	    var imgData = canvas.toDataURL('image/png');
		     
	    var imgWidth = 210; // 이미지 가로 길이(mm) / A4 기준 210mm
	    var pageHeight = imgWidth * 1.414;  // 출력 페이지 세로 길이 계산 A4 기준
	    var imgHeight = canvas.height * imgWidth / canvas.width;
	    var heightLeft = imgHeight;
	    var margin = 20; // 출력 페이지 여백설정
	    var doc = new jsPDF('p', 'mm', 'a4');
	    var position = 20;
	       
	    // 첫 페이지 출력
	    doc.addImage(imgData, 'png', margin, position, imgWidth, imgHeight);
	    heightLeft -= pageHeight;
	 
	 	// 한 페이지 이상일 경우 루프 돌면서 출력
        while (heightLeft >= 20) {
            position = heightLeft - imgHeight;
            doc.addImage(imgData, 'png', 0, position, imgWidth, imgHeight);
            doc.addPage();
            heightLeft -= pageHeight;
        }
	    
	    // 파일 저장
	    doc.save('sample.pdf');
	});
}
</script>

</html>