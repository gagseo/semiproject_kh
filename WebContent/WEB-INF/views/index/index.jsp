<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="author" content="smwSemi">
<title>Index</title>
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
		<section id="content1">
			<div class="container">
				<div class="row">
					<article class="sidechatting">
						<!-- 채팅창  -->
						<%@ include file="/WEB-INF/views/include/chat.jsp"%>
					</article>
					<article class="imformation">
						<h4 class="imf_title">공지사항</h4>
						<!-- 공지사항 -->
						<div class="notice">
							<ul>
								<li><a href="#">공지사항 입니다.</a></li>
								<li><a href="#">공지사항 입니다.</a></li>
								<li><a href="#">공지사항 입니다.</a></li>
								<li><a href="#">공지사항 입니다.</a></li>
								<li><a href="#">공지사항 입니다.</a></li>
								<li><a href="#">공지사항 입니다.</a></li>
							</ul>
							<a href="<%=request.getContextPath()%>/board/notice.do"
								class="more" title="더 보기">More<i class="fa fa-plus-circle"
								aria-hidden="true"></i></a>
						</div>
					</article>
					<article class="review">
						<h4 class="rv_title">사용후기</h4>
						<!-- 공지사항 -->
						<div class="rv_notice">
							<ul>
								<li><a href="#">사용후기 입니다.</a></li>
								<li><a href="#">사용후기 입니다.</a></li>
								<li><a href="#">사용후기 입니다.</a></li>
								<li><a href="#">사용후기 입니다.</a></li>
								<li><a href="#">사용후기 입니다.</a></li>
								<li><a href="#">사용후기 입니다.</a></li>
							</ul>
							<a href="<%=request.getContextPath()%>/board/review.do"
								class="more" title="더 보기">More<i class="fa fa-plus-circle"
								aria-hidden="true"></i></a>
						</div>
					</article>
				</div>
			</div>
		</section>
		<section id="content2">
			<div class="container">
				<div class="row">
					<article class="searchMap">
						<div class="scSub">
							<form action="#" method="post">
								<img
									src="<%=request.getContextPath()%>/resources/img/search.png"
									alt="이미지" /> <input id="scVar" type="search" placeholder="검색">
								<input id="scButton" type="submit" value="검색하기" onclick="">
							</form>
						</div>
					</article>
					<article class="support">
						<div class="supportSub">
							<form action="#" method="post">
								<img
									src="<%=request.getContextPath()%>/resources/img/support.png"
									alt="이미지" />
							</form>
						</div>
					</article>
				</div>
			</div>
		</section>
		<section id="content3">
			<div class="container">
				<div class="row">
					<article class="market">
						<div class="mkSub">
							<h3>중고 마켓</h3>
							<form action="<%=request.getContextPath()%>/board/usedmarket.do"
								method="post">
								<a class="mkNext"
									href="<%=request.getContextPath()%>/board/usedmarket.do">더보기</a>
							</form>
							<div class="mk">
								<!-- 
						최신 판매 물건별 보여줄 예정/제이쿼리 소스를 이용해서 옆으로 이미지가 움직이는 
						스타일 적용 예정
						 -->
								<img id="back"
									src="<%=request.getContextPath()%>/resources/img/back.png"
									alt="">
								<ul>
									<li class="mkImg" id="00"><a href="#"> <img
											src="<%=request.getContextPath()%>/resources/img/market/mk00.png"
											alt="">
									</a></li>
									<li class="mkImg" id="01"><a href="#"> <img
											src="<%=request.getContextPath()%>/resources/img/market/mk01.jpg"
											alt="">
									</a></li>
									<li class="mkImg" id="02"><a href="#"> <img
											src="<%=request.getContextPath()%>/resources/img/market/mk02.png"
											alt="">
									</a></li>
									<li class="mkImg" id="03"><a href="#"> <img
											src="<%=request.getContextPath()%>/resources/img/market/mk03.png"
											alt="">
									</a></li>
								</ul>
								<img id="next"
									src="<%=request.getContextPath()%>/resources/img/next.png"
									alt="">
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
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/jquery-3.4.1.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/lightgallery.min.js"></script>

	<!-- 채팅창 api -->
	<script src="https://code.jquery.com/jquery-3.5.0.js"
		integrity="sha256-r/AaFHrszJtwpe+tHyNi/XCfMxYpbsRg2Uqn0x3s2zc="
		crossorigin="anonymous"></script>


	<script type="text/javascript"
		src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=14nvpqoexz"></script>
	<script type="text/javascript">
		var idx = 0;
		var next = document.querySelector('#next');
		console.dir(next);
		next.onclick = function() {
			if (idx < 3) {
				idx++;
			} else {
				idx = 0;
			}
			move(idx);
		}

		var back = document.querySelector('#back');
		back.onclick = function() {
			if (idx == 0) {
				idx = 3;
			} else {
				idx--;
			}
			move(idx);
		}

		function move(idx) {
			var list = document.querySelectorAll('.mkImg').forEach(
					function(el) {
						console.dir(el);
						el.style.transform = 'translateX(' + (-idx * 90)
								+ 'px)';
						el.style.transitionDuration = "1s";
					})
		}

		//라이트 박스
		$(".mkSub").lightGallery({

		});
	</script>
</body>
</html>
