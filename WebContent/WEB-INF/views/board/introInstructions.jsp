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
		<section id="introSet03"> <!-- intro subMenu -->
		<%@ include file="/WEB-INF/views/include/intro_submenu.jsp"%>
		<div class="container">
			<div class="row">
				<article class="introSub03"> <!-------------------------------------->
				<div class="intSub03">
					<div class="instructions01">
						<div id="intsubList">
							<ul id="intTab">
								<li><a href="#" title="tab1">카드형</a></li>
								<li><a href="#" title="tab2">지류형</a></li>
								<li><a href="#" title="tab3">모바일형</a></li>
							</ul>
						</div>
						<div id="subTab">
							<div id="tab1">
								<h1>지역화폐 카드형</h1>
								<img class="img04" alt=""
									src="<%=request.getContextPath()%>/resources/img/intro/introsub04_1.png">
							</div>
							<div id="tab2">
								<h1>지역화폐 지류형</h1>
								<img class="img05" alt=""
									src="<%=request.getContextPath()%>/resources/img/intro/introsub04_2.png">
							</div>
							<div id="tab3">
								<h1>지역화폐 모바일형</h1>
								<img class="img06" alt=""
									src="<%=request.getContextPath()%>/resources/img/intro/introsub04_3.png">
							</div>
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

	<!-- 스크립트 부분  -->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/jquery-3.4.1.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#subTab div").hide();
			$("#intTab li:first").attr("id", "current");
			$("#subTab div:first").fadeIn();

			/* intTab의 메뉴를 클릭했을 때 선택된 목록의 div를 제외하고 안보이게 처리  */
			$('#intTab a').click(function(e) {
				e.preventDefault();
				$("#subTab div").hide();
				$("intTab li").attr("id", "");
				$(this).parent().attr("id", "current");
				$('#' + $(this).attr('title')).fadeIn();
			});
		});
	</script>
</body>
</html>