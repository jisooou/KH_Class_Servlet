<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <h1>게시글 작성</h1>
   
   <hr>
   
   <a href="http://127.0.0.1:8888/app11/home">홈페이지 이동</a>
   
   <hr>
   
   <form action="http://127.0.0.1:8888/app11/board/insert" method="post">
      <input type="text" name="title" placeholder="제목">
      <br>
      <textarea name="content" placeholder="내용"></textarea>
      <br>
      <input type="submit" value="작성하기">
   </form>

</body>
</html>










