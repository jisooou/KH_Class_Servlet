<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>여행의 정석</title>

    <link rel="stylesheet" href="http://127.0.0.1:8888/journey/resources/css/wish.css">
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        function deleteWish(no) {
            $.ajax({
                url: '/journey/wish/delete',
                type: 'GET',
                data: { no: no },
                success: function(response) {
                    if (response.trim() === "로그인이 필요합니다.") {
                        alert('로그인이 필요합니다.');
                    } else if (response.trim() === "위시리스트가 성공적으로 삭제되었습니다.") {
                        $('#wish-' + no).remove();
                        alert(response);
                    } else {
                        alert('위시리스트 삭제에 실패했습니다. 메시지: ' + response);
                    }
                },
                error: function(xhr, status, error) {
                    console.error('위시리스트 삭제 중 오류가 발생했습니다. 상태:', status, '오류:', error);
                    console.error('응답 내용:', xhr.responseText);
                    alert('위시리스트 삭제 중 오류가 발생했습니다. 상태: ' + status + ', 오류: ' + error);
                }
            });
        }
    </script>
</head>
<body>
    <header>
        <img id="img-logo" src="./image/airbnb.png" alt="">
        <div class="header-right">
            <div id="introduce">당신의 공간을 여정하세요</div>
            <div id="profile-icon" onclick="showAccountContent()">
                <img id="menu-icon" width="16" src="./image/menu.svg" alt="메뉴 아이콘">
                <img id="user-icon" width="30" src="./image/profile.svg" alt="유저 아이콘">
            </div>
        </div>
    </header>

    <section>
        <div class="wishlist-letter">
            위시리스트
        </div>
    </section>

	<div class="main">
          <div class="image-container">
            <div class="accomodation" >
                <img src="https://cdn.travelview.co.kr/travelview/2021/01/21020223/post_41596968_30400772_4.jpg" alt="숙소 사진">
                <div class="heart-icon" room_no="1" onclick="clickHeart(this)">
                    <img class="heart-empty" src="./image/emptyheart.svg" alt="빈 찜 하트">
                    <img class="heart-filled" src="./image/pinkheart.png" alt="찜 하트">
                </div>
                <div id="place-name">한국 애월읍, 제주시</div>
                <div id="place-score">★ 4.79</div>
                <div id="place">협재해수욕장</div>
                <div id="place-date">₩273,882 / 박</div>
            </div>

		
<%-- <%-- 
    <div class="main">
        <div class="image-container">
            <c:choose>
                <c:when test="${not empty voList}">
                    <c:forEach var="wish" items="${voList}">
                        <div class="accomodation" id="wish-${wish.no}">
                            <img src="${wish.imageUrl}" alt="숙소 사진">
                            <div class="heart-icon" room_no="${wish.roomNo}" onclick="clickHeart(this)">
                                <img class="heart-empty" src="./image/emptyheart.svg" alt="빈 찜 하트">
                                <img class="heart-filled" src="./image/pinkheart.png" alt="찜 하트">
                            </div>
                            <div id="place-name">${wish.roomName}</div>
                            <div id="place-score">★ ${wish.grade}</div>
                            <div id="place">${wish.location}</div>
                            <div id="place-date">${wish.price} / 박</div>
                            <div id="place-delete">
                                <button onclick="deleteWish('${wish.no}')">삭제</button>
                            </div>
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <p>위시리스트에 등록된 항목이 없습니다.</p>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
--%>

	
    <br><br><br>

    <footer class="footer">
        <div class="footer-content">
            <div class="footer-column">
                <h4>에어비앤비 지원</h4>
                <ul>
                    <li><a href="https://www.airbnb.co.kr/help">도움말 센터</a></li>
                    <li><a href="https://www.airbnb.co.kr/help/article/3218">에어커버</a></li>
                    <li><a href="https://www.airbnb.co.kr/against-discrimination">차별 반대</a></li>
                    <li><a href="https://www.airbnb.co.kr/accessibility">장애인 지원</a></li>
                    <li><a href="https://www.airbnb.co.kr/help/article/2701">예약 취소 옵션</a></li>
                    <li><a href="https://www.airbnb.co.kr/help/article/3290">이웃 민원 신고</a></li>
                </ul>
            </div>
            <div class="footer-column">
                <h4>호스팅</h4>
                <ul>
                    <li><a href="https://www.airbnb.co.kr/host/homes?from_footer=1">당신의 공간을 여정하세요</a></li>
                    <li><a href="https://www.airbnb.co.kr/host/homes?from_footer=1">호스트를 위한 에어커버</a></li>
                    <li><a href="https://www.airbnb.co.kr/resources/hosting-homes">호스팅 자료</a></li>
                    <li><a href="https://community.withairbnb.com/t5/custom/page/page-id/CommunityCenterNotFound">커뮤니티 포럼</a></li>
                    <li><a href="https://www.airbnb.co.kr/help/article/1387">책임감 있는 호스팅</a></li>
                    <li><a href="https://www.airbnb.co.kr/ambassadors/joinaclass">무료 호스팅 클래스 참여하기</a></li>
                </ul>
            </div>
            <div class="footer-column">
                <h4>여정</h4>
                <ul>
                    <li><a href="https://news.airbnb.com/">뉴스룸</a></li>
                    <li><a href="https://www.airbnb.co.kr/release">새로운 기능</a></li>
                    <li><a href="https://careers.airbnb.com/">채용정보</a></li>
                    <li><a href="https://investors.airbnb.com/home/default.aspx">투자자 정보</a></li>
                    <li><a href="https://ko.airbnb.org/?_set_bev_on_new_domain=1715824984_ZWY5ZmRiZjk5MTg0">여정 긴급 속보</a></li>
                </ul>
            </div>
        </div>
        <div class="footer-language">
            <span>한국어 (KR)</span>
            <span>₩ KRW</span>
        </div>
        <div class="footer-sns">
            <img src="./image//facebook.png" alt="facebook">
            <img src="./image/twitter.png" alt="twitter">
            <img src="./image/instagram.png" alt="instagram">
            <img src="./image/blog.png" alt="blog">
        </div>
        <div class="footer-bottom">
            <span>© 2024 여정, Inc.</span>
            <div class="footer-link">
                <a href="">개인정보 처리방침</a>
                <a href="">이용약관</a>
                <a href="">사이트맵</a>
                <a href="">한국의 변경된 환불 정책</a>
                <a href="">회사 세부정보</a>
            </div>
        </div>
    </footer>
</body>
</html>