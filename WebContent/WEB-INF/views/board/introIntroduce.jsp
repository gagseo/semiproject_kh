<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>지역화폐 소개</title>
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
		<section id="introSet01"> <!-- intro subMenu -->
		<%@ include file="/WEB-INF/views/include/intro_submenu.jsp"%>
		<!-------------------------------------->
		<div class="container">
			<div class="row">
				<article class="introSub01">
				<div class="intSub01">
					<div id="introduce01">
						<h1>지역화폐란?</h1>
						<div class="img01">
							<img src="<%=request.getContextPath()%>/resources/img/intro/introsub01.png" alt="">
						</div>
					</div>
					<div id="introduce02">
						<h1>지역경제 살리는 '지역화폐'</h1>
						<div class="text01">
							<p>
								개인의 삶의 질과 지역 경제의 상황은 유기적으로 연결되어 경제가 어려우면 일자리가 줄어들고,<br>
								일자리가 줄면 소득이 줄어 소비가 둔화한다.<br> <br> 이러한 경우 지역에서 자체적으로
								발행하고 통용되는 지역화폐는 상황을 반전시키는 하나의 원동력이 될 수 있다.<br> 각 지역 시내의 각
								자치구별로 발행되는 지역화폐는 어려움에 처한 소상공인을 지원하고<br> 지역 경제 발전과 시민 복지 증진을
								위한 새로운 가치의 화폐다.<br> <br> 각 지역 시내 곳곳에 있는 지역화폐 가맹점 대부분에서
								사용 가능한 지역화폐상품권의 활성화는 지역과 골목 상권의 숨통을 트이게 하고, 소비를 촉진해 지역 내에 돈이 돌게
								하는 선순환을 만든다.<br>
							</p>
						</div>
					</div>
				</div>
				</article>
			</div>
		</div>
		</section> </main>

		<!-- footer -->
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	</div>
</body>
</html>