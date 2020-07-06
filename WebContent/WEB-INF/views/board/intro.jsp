<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>지역화폐란?</title>
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

		<main>
		<section id="introSet">
			<div class="container">
				<div class="row">
					<div class="intBox">
						<h1>"지역살리는 지역화폐<br> 우리동네 띄우는 비장의 머니"</h1>
						<article class="introBox1">
							<div class="intSub01">
								<form action="#" method="post">
									<a href="#"><img class="introImg"
										src="<%=request.getContextPath()%>/resources/img/intro/INTRO01.png"
										alt=""></a>
									<div class="setting">
										<a href="<%=request.getContextPath()%>/board/introIntroduce.do" class="intNext">더보기></a>
									</div>
								</form>
							</div>
						</article>
						<article class="introBox2">
							<div class="intSub02">
								<form action="#" method="post">
									<a href="#"><img class="introImg"
										src="<%=request.getContextPath()%>/resources/img/intro/INTRO02.png"
										alt=""></a>
									<div class="setting">
										<a href="<%=request.getContextPath()%>/board/introKind.do" class="intNext">더보기></a>
									</div>
								</form>
							</div>
						</article>
						<article class="introBox3">
							<div class="intSub03">
								<form action="">
									<a href="#" method="post">
									<img class="introImg" src="<%=request.getContextPath()%>/resources/img/intro/INTRO03.png" alt=""></a>
									<div class="setting">
										<a href="<%=request.getContextPath()%>/board/introInstructions.do" class="intNext">더보기></a>
									</div>
								</form>
							</div>
						</article>
					</div>
				</div>
			</div>
		</section>

		<!-- footer 시작 --> <%@ include
			file="/WEB-INF/views/include/footer.jsp"%> <!-- footer 끝 -->
	</div>

	<!-- JavaScript -->
</body>
</html>