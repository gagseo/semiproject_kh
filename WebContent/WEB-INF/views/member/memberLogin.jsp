<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
<!-- HTLM5shiv ie6~8 -->
<!-- 익스플로워 9버전 이하일 경우 나타나는 창  -->
<!--[if lt IE 9] 
        <script src="<%=request.getContextPath()%>/resources/js/html5shiv.min.js"></script>
        <script type="text/javascript">
            alert("현재 당신이 보는 브라우저는 지원하지 않습니다. 최신 브라우저로 업데이트해주세요!");
        </script>
[endif] -->
</head>
<body>
	<div id="wrap">
		<!-- header 시작 -->
		<%@ include file="/WEB-INF/views/include/header.jsp"%>
		<!-- header 끝 -->

		<!-- nav 시작  -->
		<%@ include file="/WEB-INF/views/include/nav.jsp"%>
		<!-- nav 끝  -->

		<!-- 메인 -->
		<main>
		<section id="loginSet">
			<div class="container">
				<div class="row">
					<article class="log_sub">
						<div class="log_table">
							<h1>로그인</h1>
							<div class="logForm">
								<form action="<%=request.getContextPath()%>/member/login.do"
									method="post">
									<table>
										<tr>
											<th class="th_text">아이디</th>
											<td><input type="text" name="USER_ID" maxlength="20" />
												<span id="checkMsg" class="checkMsg"></span></td>
										</tr>
										<tr>
											<th class="th_text">비밀번호</th>
											<td><input type="password" name="USER_PWD"
												maxlength="30" /> <span class="btn"></span></td>
										</tr>
									</table>
									<button id="log_button" type="submit">로그인</button>
									<!-- 카카오,네이버, 구글 연동 로그인 해둘 예정 -->
									<div class="snsLogin">
										<ul>
											<!-- 5/3 안되어있는 네이버와 구글은 일단 임시방편으로 이미지로 대체한 상황 -->
											<li><a id="kakao-login-btn" class="snsImg">카카오</a></li>
											<li><a class="snsImg" href="#"
												onclick="window.alert('해당기능은 아직 준비중입니다.')"><img
													src="<%=request.getContextPath()%>/resources/img/member/naver.PNG"></a></li>
											<li><a class="snsImg" href="#"
												onclick="window.alert('해당기능은 아직 준비중입니다.')"><img
													src="<%=request.getContextPath()%>/resources/img/member/Google-Login.png"></a></li>
										</ul>
									</div>

									<!--  4/30 아이디 비밀번호 찾기는 아직 기능 구현 전 -->
									<div class="findUser">
										<ul>
											<li><a href="#findUSER_ID">아이디찾기</a></li>
											<li><a href="#findUSER_PWD">비밀번호찾기</a></li>
											<li><a
												href="<%=request.getContextPath()%>/member/memberjoin.do">회원가입</a></li>
										</ul>
									</div>
								</form>
							</div>
						</div>
					</article>
				</div>
			</div>
		</section>
		</main>

		<!-- footer 시작 -->
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		<!-- footer 끝 -->
	</div>

	<!-- JavaScript -->
	<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

	<script type="text/javascript">
	<!-- 아이디 혹은 비밀번호 가 틀렸을때 -->
		<c:if test="${data.reCheck == 'true'}">
		document.querySelector('#checkMsg').textContent = '아이디 혹은 비밀번호를 확인하세요';
		</c:if>

		//카카오 로그인
		// 사용할 앱의 JavaScript 키를 설정해 주세요.
		var myJSKey = "a3516b835add5a4ea40c900a58bb599f";
		Kakao.init(myJSKey);
		// 카카오 로그인 버튼을 생성합니다.
		Kakao.Auth.createLoginButton({
			container : '#kakao-login-btn'
		//카카오로그인 창이 떠서 본인 정보 입력했을때 어떤값이 같으면 우리 회원인지 정해서 로그인 시켜주게끔 처리 해야함
		});
	</script>


</body>
</html>