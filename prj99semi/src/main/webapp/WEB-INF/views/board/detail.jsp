<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH홈페이지</title>

<script src="/app/resources/js/board/detail.js"></script>

<%@ include file="/WEB-INF/views/layout/util.jsp" %>

</head>
<body>

    <%@ include file="/WEB-INF/views/layout/left-aside.jsp" %>
    <div id="wrap">
        <%@ include file="/WEB-INF/views/layout/header.jsp" %>
        <%@ include file="/WEB-INF/views/layout/nav.jsp" %>
        <main>
            <h1 align="center">게시글 상세조회</h1>
            
            <div>제목 : ${requestScope.vo.title}</div>
            <div>작성자 : ${requestScope.vo.nick}</div>
            <div>조회수 : ${requestScope.vo.hit}</div>
            <div>카테고리이름 : ${requestScope.vo.categoryName}</div>
            <div>작성일시 : ${requestScope.vo.createDate}</div>
            <div>내용 : ${requestScope.vo.content}</div>
            
            <c:forEach items="${attVoList}" var="x">
            <img width="100px" height="100px" alt="${x.originName}" src="/app/resources/upload/${x.changeName}">            
            </c:forEach>
            
            <c:if test="${requestScope.vo.writerNo == sessionScope.loginMemberVo.no}">
               <button onclick="location.href='/app/board/edit?no=${vo.no}'">수정</button>
               <button onclick="location.href='/app/board/delete?no=${vo.no}'">삭제</button>            
            </c:if>
            
            <br>
            
            <button onclick="loadReplyList(${vo.no});">댓글 불러오기</button>
            
            <c:if test="${sessionScope.loginMemberVo != null }">
               <input type="text" name="reply-content" placeholder="댓글을 입력하세요">
               <button onclick="writeReply(${vo.no});">댓글 작성</button>            
            </c:if>
            
            <c:if test="${sessionScope.loginMemberVo == null}">
               <span>로그인 후 댓글 작성 가능합니다.</span>
            </c:if>
            <div id="replyArea">
               <table>
                  <thead>
                     <tr>
                      <th>번호</th>
                      <th>내용</th>
                      <th>작성자</th>
                      <th>작성일시</th>
                     </tr>
                  </thead>
                  <tbody>
                     
                  </tbody>
               </table>
            </div>
            
        </main>
        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
    </div>
    <%@ include file="/WEB-INF/views/layout/left-aside.jsp" %>

</body>
</html>