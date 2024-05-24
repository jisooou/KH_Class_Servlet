<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
 <!-- MemberLoginController, MemberVo, login.jsp 임시 테스트용 -->   
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
</head>
<body>
    <h1>로그인</h1>
    <form action="/journey/member/login" method="post">
        <label for="username">아이디:</label>
        <input type="text" id="username" name="username" required><br><br>
        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required><br><br>
        <button type="submit">로그인</button>
    </form>
    <c:if test="${not empty errMsg}">
        <p style="color: red;">${errMsg}</p>
    </c:if>
</body>
</html>