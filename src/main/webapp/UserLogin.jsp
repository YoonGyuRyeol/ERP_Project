<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/loginstyle.css" />
</head>
<body>
<title>Capt!</title>
<%HttpSession session1 = request.getSession();
	if(session1.getAttribute("loginuser") != null){
		RequestDispatcher dispatcher = request.getRequestDispatcher("CerpHome.Capt");
		dispatcher.forward(request, response);
	}%>
	
	
<form action="Cerplogin.Capt" method="post">

  <div class="image">
  		<img class='image2' src="css/images/cerp.png" alt="cerp">
  </div>
  <div class="container">
  	
    <label for="uname"><b>아이디</b></label>
    <input type="text" placeholder="Cerp계정을 입력하세요" name="id" required>

    <label for="psw"><b>비밀번호</b></label>
    <input type="password" placeholder="비밀번호를 입력하세요" name="psw" required>
        
    <button type="submit">로그인</button>
   
  </div>

</form>

</body>
</html>
