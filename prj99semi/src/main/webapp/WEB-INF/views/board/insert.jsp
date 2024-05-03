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

    <form action="/app/board/insert" method="post">

        <input type="text" name="title" placeholder="제목">
        <select name="category">
            <option value="1">여행</option>
            <option value="2">노래</option>
            <option value="3">개발</option>
            <option value="4">자유</option>
            <option value="5">독서</option>
        </select>
        <br><br>
        <textarea name="content" placeholder="내용"></textarea>
        <br><br>
        <input type="file" name="f">
        <br><br>
        <input type="submit" value="제출하기">
        <br>
    </form>

</body>
</html>