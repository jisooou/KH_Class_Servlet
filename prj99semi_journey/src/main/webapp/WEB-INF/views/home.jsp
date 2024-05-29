<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<script defer src="/journey/resources/js/home.js"></script>

<%@ include file="/WEB-INF/views/layout/util.jsp" %>
</head>

<body>
	<%@ include file="/WEB-INF/views/layout/header.jsp"%>

	<!-- Member, Host, Admin 회원가입 선택하는 창 -->
	<div class="select-account" id="select-account-join">
		<div id="admin">
			<button>
				<img src="https://cdn3.emoji.gg/emojis/2342-admin.png" alt="관리자">
			</button>
			<span>관리자</span>
		</div>
		<div id="host">
			<!-- 포트번호 확인해서 바꾸기 -->
			<button>
				<a href="http://127.0.0.1:8888/journey/host/join"><img
					src="https://cdn3.emoji.gg/emojis/2342-admin.png" alt="호스트"></a>
			</button>
			<span>호스트</span>
		</div>
		<div id="member">
			<button id="memberJoin" onclick="showMemberJoin()">
				<img src="https://cdn3.emoji.gg/emojis/2342-admin.png" alt="회원">
			</button>
			<span>회원</span>
		</div>
		<button class="close-button" id="close-button-join">닫 기</button>
	</div>

	<!-- Member, Host, Admin 로그인 선택하는 창 -->
	<div class="select-account" id="select-account-login">
		<div id="admin">
			<button onclick="showAdminLogin()">
				<img src="https://cdn3.emoji.gg/emojis/2342-admin.png" alt="관리자">
			</button>
			<span>관리자</span>
		</div>
		<div id="host">
			<!-- 포트번호 확인해서 바꾸기 -->
			<button onclick="showHostLogin()">
				<img src="https://cdn3.emoji.gg/emojis/2342-admin.png" alt="호스트">
			</button>
			<span>호스트</span>
		</div>
		<div id="member">
			<button id="memberLogin" onclick="showMemberLogin()">
				<img src="https://cdn3.emoji.gg/emojis/2342-admin.png" alt="회원">
			</button>
			<span>회원</span>
		</div>
		<button class="close-button" id="close-button-login">닫 기</button>
	</div>

	<!-- Member 회원가입 창 -->
	<div class="join-content" id="join-content">
		<form action="/journey/member/join" method="post"
			enctype="multipart/form-data" class="join-box">
			<h3>회원가입 완료하기</h3>
			<hr>
			<h4>실명</h4>
			<input type="text" size="22" name="name"
				placeholder="신분증에 기재된 이름(예:길동)" required> <br>
			<h6>
				정부 발급 신분증에 기재된 이름과 일치해야 합니다. 평소 다른 이름을 사용하는 경우, <u>선호하는 이름</u>을
				입력하세요.
			</h6>
			<h4>생년월일</h4>
			<input type="text" name="birth-date" required>
			<h6>18세 이상인 성인만 회원으로 가입할 수 있습니다. 생일은 여행의 정석의 다른 회원에게 공개되지 않습니다.</h6>
			<h4>Contact Info</h4>
			전화번호 : <input type="tel" name="phone" placeholder="01012345678"
				required> <br> 이메일 : <input type="email" name="email"
				placeholder="kh11@gmail.com" required>
			<div class="id-checkDup">
				<h4>아이디</h4>
				<input type="text" name="id" required> <input type="button"
					value="중복 확인">
			</div>
			<h4>비밀번호</h4>
			<input type="password" name="pwd" required>
			<h4>비밀번호 확인</h4>
			<input type="password" name="pwd2" required>
			<h4>프로필 이미지</h4>
			<input type="file" name="profile"> <br>
			<hr>
			<br>
			<div class="checkbox-container">
				<h5>개인정보 수집 및 이용에 동의합니다.</h5>
				<input type="checkbox" required>
			</div>
			<div class="checkbox-container">
				<h5>마케팅 이메일 수신을 원합니다(선택).</h5>
				<input type="checkbox">
			</div>
			<br>
			<hr>
			<br>
			<h4>
				동의 및 계속하기를 선택하여 여행의 정석 <u>서비스 약관</u>, <u>결제 서비스 약관</u>, <u>위치기반서비스
					이용약관</u>, <u>차별 금지 정책</u>, <u>개인정보 처리방침</u>에 동의합니다.
			</h4>
			<input type="submit" value="동의 및 계속하기" class="join-submit-button">
			<button type="button" id="join-close-button">닫기</button>
		</form>
	</div>
	<!--  -->


	<!-- Member 로그인 창 -->
	<div class="login-content" id="login-member-content">
		<form action="/journey/member/login" method="post" class="login-box">
			<h3>로그인</h3>
			<hr>
			<h2>여행의 정석에 오신 것을 환영합니다.</h2>
			<br> <input id="login-id" type="text" name="id"
				placeholder="아이디" required> <br> <br> <input
				id="login-password" type="password" name="pwd" placeholder="비밀번호"
				required>
			<!-- 비밀번호 보기 -->
			<button type="button" class="show-password" onclick="showPassword()">비밀번호
				보기</button>
			<br> <br> <input type="submit" value="로그인"
				class="login-submit-button"> <br>
			<h4>
				<u>비밀번호를 잊으셨나요?</u>
			</h4>
			<button type="button" id="login-close-button">닫기</button>
		</form>
	</div>
	<!--  -->
	<!-- Host 로그인 창 -->
	<div class="login-content" id="login-host-content">
		<form action="/journey/host/login" method="post" class="login-box">
			<h3>로그인</h3>
			<hr>
			<h2>여행의 정석에 오신 것을 환영합니다.</h2>
			<br> <input id="login-id" type="text" name="id"
				placeholder="아이디" required> <br> <br> <input
				id="login-password" type="password" name="pwd" placeholder="비밀번호"
				required>
			<!-- 비밀번호 보기 -->
			<button type="button" class="show-password" onclick="showPassword()">비밀번호
				보기</button>
			<br> <br> <input type="submit" value="로그인"
				class="login-submit-button"> <br>
			<h4>
				<u>비밀번호를 잊으셨나요?</u>
			</h4>
			<button type="button" id="login-close-button">닫기</button>
		</form>
	</div>
	<!--  -->
	<!-- Admin 로그인 창 -->
	<div class="login-content" id="login-admin-content">
		<form action="/journey/admin/login" method="post" class="login-box">
			<h3>로그인</h3>
			<hr>
			<h2>여행의 정석에 오신 것을 환영합니다.</h2>
			<br> <input id="login-id" type="text" name="id"
				placeholder="아이디" required> <br> <br> <input
				id="login-password" type="password" name="pwd" placeholder="비밀번호"
				required>
			<!-- 비밀번호 보기 -->
			<button type="button" class="show-password" onclick="showPassword()">비밀번호
				보기</button>
			<br> <br> <input type="submit" value="로그인"
				class="login-submit-button"> <br>
			<h4>
				<u>비밀번호를 잊으셨나요?</u>
			</h4>
			<button type="button" id="login-close-button">닫기</button>
		</form>
	</div>
	<!--  -->


	<nav>
		<div class="search">
			<button class="search-item" onclick="showPlaceSearch()">
				<span>여행지</span> <span id="search-destination">여행지 검색</span>
			</button>
			<div class="divider"></div>
			<!-- 이 부분 캘린더 추가 -->
			<button class="search-item" id="checkin-button"
				onclick="showCalendar('checkin')">
				<span>체크인</span> <span>날짜 추가</span>
			</button>
			<div class="divider"></div>
			<!-- 이 부분 캘린더 추가 -->
			<button class="search-item" id="checkout-button"
				onclick="showCalendar('checkout')">
				<span>체크아웃</span> <span>날짜 추가</span>
			</button>
			<div class="divider"></div>
			<button class="search-item" onclick="showTravelerSearch()">
				<span>여행자</span> <span>게스트 추가</span>
			</button>
			<button type="submit" class="search-icon">
				<img src="/journey/resources/img/search.png" alt="검색 아이콘">
			</button>

			<div class="search-place" id="search-place">
				<h5 class="search-place-letter">지역으로 검색하기</h5>
				<button class="search-place-button">
					<img src="/journey/resources/img/home/place-search.png" alt="유연한 검색">
					<span>유연한 검색</span>
				</button>
				<br>
				<h5 class="search-place-letter">한국</h5>
				<br>
				<div class=search-place-name>
					<button onclick="updateSearchBar('서울')">서울</button>
					<button onclick="updateSearchBar('부산')">부산</button>
					<button onclick="updateSearchBar('속초')">속초</button>
					<button onclick="updateSearchBar('강릉')">강릉</button>
					<button onclick="updateSearchBar('전주')">전주</button>
					<button onclick="updateSearchBar('대구')">대구</button>
					<button onclick="updateSearchBar('경주')">경주</button>
					<button onclick="updateSearchBar('여수')">여수</button>
					<button onclick="updateSearchBar('서귀포')">전남</button>
					<button onclick="updateSearchBar('대전')">대전</button>
					<button onclick="updateSearchBar('제주도')">제주도</button>
					<button onclick="updateSearchBar('인천')">인천</button>
					<button onclick="updateSearchBar('경기')">경기</button>
					<button onclick="updateSearchBar('대전')">대전</button>
					<button onclick="updateSearchBar('충북')">충북</button>
					<button onclick="updateSearchBar('경남')">경남</button>
				</div>
			</div>
		</div>

		<div class="traveler" id="traveler">
			<div class="traveler-option">
				<span>성인</span> <span class="age-info">13세 이상</span>
				<div class="people-count">
					<button class="decrease">-</button>
					<span class="count">0</span>
					<button class="increase">+</button>
				</div>
			</div>
			<div class="traveler-option">
				<span>어린이</span> <span class="age-info">2~12세</span>
				<div class="people-count">
					<button class="decrease">-</button>
					<span class="count">0</span>
					<button class="increase">+</button>
				</div>
			</div>
			<div class="traveler-option">
				<span>유아</span> <span class="age-info">2세 미만</span>
				<div class="people-count">
					<button class="decrease">-</button>
					<span class="count">0</span>
					<button class="increase">+</button>
				</div>
			</div>
			<div class="traveler-option">
				<span>반려동물</span>
				<!-- <span class="age-info">보조동물을 동반하시나요?</span> -->
				<div class="people-count">
					<button class="decrease">-</button>
					<span class="count">0</span>
					<button class="increase">+</button>
				</div>
			</div>
		</div>
	</nav>


	<!-- <br><hr id="line"><br> -->

	<section>
		<div class="theme">
			<button id="theme-detail">
				<img src="/journey/resources/img/home/sea.svg" alt="테마"> <span
					id="theme-name">해변 바로 앞</span>
			</button>
			<button id="theme-detail">
				<img src="/journey/resources/img/home/hanok.svg" alt="테마"> <span
					id="theme-name">한옥</span>
			</button>
			<button id="theme-detail">
				<img src="/journey/resources/img/home/view.svg" alt="테마"> <span
					id="theme-name">최고의 전망</span>
			</button>
			<button id="theme-detail">
				<img src="/journey/resources/img/home/pool.svg" alt="테마"> <span
					id="theme-name">멋진 수영장</span>
			</button>
			<button id="theme-detail">
				<img src="/journey/resources/img/home/camping.svg" alt="테마"> <span
					id="theme-name">캠핑장</span>
			</button>
			<button id="theme-detail">
				<img src="/journey/resources/img/home/wierd.svg" alt="테마"> <span
					id="theme-name">기상천외한</span>
			</button>
			<button id="theme-detail">
				<img src="/journey/resources/img/home/world.png" alt="테마"> <span
					id="theme-name">속세를 벗어난</span>
			</button>
			<button id="theme-detail">
				<img src="/journey/resources/img/home/top.svg" alt="테마"> <span
					id="theme-name">세상의 꼭대기</span>
			</button>
			<button id="theme-detail">
				<img src="/journey/resources/img/home/farm.svg" alt="테마"> <span
					id="theme-name">농장</span>
			</button>
			<button id="theme-detail">
				<img src="/journey/resources/img/home/surfing.svg" alt="테마"> <span
					id="theme-name">서핑</span>
			</button>
			<button id="theme-detail">
				<img src="/journey/resources/img/home/cabin.svg" alt="테마"> <span
					id="theme-name">통나무집</span>
			</button>
			<button id="theme-detail">
				<img src="/journey/resources/img/home/countryside.png" alt="테마"> <span
					id="theme-name">한적한 시골</span>
			</button>
		</div>
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

	<!-- -----------------캘린더------------------------------------ -->
	<div class="calendar-modal" id="calendar-modal">
		<div class="calendar-content">
			<div class="calendar-header">
				<button id="prev-month">&lt;</button>
				<span id="current-month"></span>
				<button id="next-month">&gt;</button>
			</div>
			<div class="calendar-body" id="calendar-body">
				<!-- Calendar grids will be dynamically inserted here -->
			</div>
			<div class="calendar-footer">
				<button id="close-calendar">닫기</button>
			</div>
		</div>
	</div>
	<!-- ----------------------------------------------------------------- -->

	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>

</body>
</html>