<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>
            <div>빈칸</div>
            <div>로고</div>
            <div>
            	
            	<c:if test="${loginMemberVo != null}">
            		<div>
            			<a download href="/app/resources/upload/${loginMemberVo.profile}">프로필사진 다운로드 받기</a>
            			<img 
            				width="100px"
            				height="100px"
            				alt="프로필사진" 
            				src="/app/resources/upload/${loginMemberVo.profile}"
            			>
            			<span>닉네임 : ${sessionScope.loginMemberVo.nick} </span>
            			<br>
            			<button onclick="location.href = '/app/member/logout'">로그아웃</button>  
            		</div>        
				</c:if>
				<c:if test="${loginMemberVo == null}">
					<div>
            			<button onclick="location.href='/app/member/join'">회원가입</button>
            			<button onclick="location.href='/app/member/login'">로그인</button>
            		</div>  	
				</c:if>
            	
            </div>
</header>