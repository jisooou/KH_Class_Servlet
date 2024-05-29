<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>여행의 정석</title>

<link rel="stylesheet" href="/journey/resources/css/home.css">
<link rel="stylesheet" href="/journey/resources/css/layout/header.css">
<link rel="stylesheet" href="/journey/resources/css/layout/footer.css">
<link rel="stylesheet" href="/journey/resources/css/wish/wish.css">

<script defer src="/journey/resources/js/home.js"></script>

<%@ include file="/WEB-INF/views/layout/util.jsp" %>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	function deleteWish(no) {
		$
				.ajax({
					url : '/journey/wish/delete',
					type : 'GET',
					data : {
						no : no
					},
					success : function(response) {
						if (response.trim() === "로그인이 필요합니다.") {
							alert('로그인이 필요합니다.');
						} else if (response.trim() === "위시리스트가 성공적으로 삭제되었습니다.") {
							$('#wish-' + no).remove();
							alert(response);
						} else {
							alert('위시리스트 삭제에 실패했습니다. 메시지: ' + response);
						}
					},
					error : function(xhr, status, error) {
						console.error('위시리스트 삭제 중 오류가 발생했습니다. 상태:', status,
								'오류:', error);
						console.error('응답 내용:', xhr.responseText);
						alert('위시리스트 삭제 중 오류가 발생했습니다. 상태: ' + status + ', 오류: '
								+ error);
					}
				});
	}
</script>
</head>
<body>
	
	<%@ include file="/WEB-INF/views/layout/header.jsp"%>

	<section>
		<div class="wishlist-letter">위시리스트</div>
	</section>

	<div class="main">
		<div class="image-container">
			<c:forEach var="wish" items="${wishList}">
				<div class="accomodation" id="wish-${wish.no}">
					<img src="${wish.accomImgUrl}" alt="숙소 사진">
					<div class="heart-icon" room_no="${wish.roomNo}"
						onclick="clickHeart(this)">
						<img class="heart-empty" src="/journey/resources/img/home/emptyheart.svg" alt="빈 찜 하트"> 
						<img class="heart-filled" src="/journey/resources/img/home/pinkheart.png" alt="찜 하트">
					</div>
					<div id="place-name">${wish.roomName}</div>
					<div id="place-score">★ ${wish.grade}</div>
					<div id="place">${wish.accomAddress}</div>
					<!-- 평일과 금토일 가격 다르게 해야함 !!!!!!!!!!!!!!!!!-->
					<div id="place-date">₩ ${wish.roomWeekdayPrice} / 박</div>
					<div id="place-date-weekend">₩ ${wish.roomWeekendPrice} / 박</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<br>
	<br>
	<br>

	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
</body>
</html>