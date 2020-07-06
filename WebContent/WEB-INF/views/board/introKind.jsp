<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
</head>
<body>
	<div id="wrap">
		<!-- header 시작 -->
		<%@ include file="/WEB-INF/views/include/header.jsp"%>
		<!-- header 끝 -->

		<!-- nav 시작  -->
		<%@ include file="/WEB-INF/views/include/nav.jsp"%>
		<!-- nav 끝  -->


		<!-- section -->
		<main> 
		<section id="introSet02"> <!-- intro subMenu -->
		<%@ include file="/WEB-INF/views/include/intro_submenu.jsp"%>
		<!-------------------------------------->

		<div class="container">
			<div class="row">
				<article class="introSub01">
				<div class="intSub02">
					<div id="kind01">
						<h1>지역화폐의 종류 소개</h1>
						<div id="img02">
							<img src="<%=request.getContextPath()%>/resources/img/intro/introsub02.png" alt="">
						</div>
					</div>
					<div id="kind02">
						<h1>지역화폐의 일반발행과 정책발행</h1>
						<div id="img03">
							<img src="<%=request.getContextPath()%>/resources/img/intro/introsub03.png" alt="">
						</div>
					</div>
				</div>
				</article>
			</div>
		</div>
		</section> 
		</main>

		<!-- footer -->
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	</div>
</body>
</html>