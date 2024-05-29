<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>위시리스트</title>

<link rel="stylesheet" href="/journey/resources/css/home.css">
<link rel="stylesheet" href="/journey/resources/css/layout/header.css">
<link rel="stylesheet" href="/journey/resources/css/layout/footer.css">
<link rel="stylesheet" href="/journey/resources/css/wish/wish.css">

<script defer src="/journey/resources/js/home.js"></script>

<%@ include file="/WEB-INF/views/layout/util.jsp" %>


<!-- !!!!!!!!!!!!!GPT-AJAX!!!!!!!!!!!!! -->
<script>
	function clickHeart(element) {
		var roomNo = element.getAttribute('room_no');

		var xhr = new XMLHttpRequest();
		xhr.open('POST', '/journey/wish/insert', true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		xhr.onreadystatechange = function() {
			if (xhr.readyState === XMLHttpRequest.DONE) {
				if (xhr.status === 200) {
					alert('위시리스트에 등록되었습니다.');
					element.querySelector('.heart-empty').style.display = 'none';
					element.querySelector('.heart-filled').style.display = 'inline';
				} else if (xhr.status === 401) {
					alert('로그인이 필요합니다.');
				} else {
					alert('위시리스트 등록 중 오류가 발생했습니다. ' + xhr.responseText);
				}
			}
		};
		xhr.send('roomNo=' + encodeURIComponent(roomNo));
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
			<c:forEach var="room" items="${roomList}">
				<div class="accomodation">
					<img src="${accom.imgUrl}" alt="숙소 사진">
					<div class="heart-icon" room_no="${room.no}"
						onclick="clickHeart(this)">
						<img class="heart-empty" src="/journey/resources/img/home/emptyheart.svg" alt="빈 찜 하트"> 
						<img class="heart-filled" src="/journey/resources/img/home/pinkheart.png" alt="찜 하트">
					</div>
					<div id="place-name">${room.name}</div>
					<div id="place-score">★ ${room.grade}</div>
					<div id="place">${room.address}</div>
					<!-- 평일과 금토일 가격 다르게 해야함 !!!!!!!!!!!!!!!!!-->
					<div id="place-date">₩ ${room.weekdayPrice} / 박</div>
					<div id="place-date-weekend">₩ ${room.weekendPrice} / 박</div>
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