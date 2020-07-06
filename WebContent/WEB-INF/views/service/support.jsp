<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>고객센터</title>
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

		<main> <!-- section  -->
		<section class="supportPg">
			<div class="supportList">
				<h1>자주 묻는 질문</h1>
				<div class="QnA">
					<!--자주 묻는 질문과 응답-->
					<form action="" method="post">
						<div class="support_box">
							<!-- <div class="support_header">
								<button></button>
							</div> -->
							<ul class="supportBody">
								<li class="article" id="sp1">
									<p class="q">
										<a href="#sp1">카드형 지역화폐 사용에 따른 가맹점 수수료를 지원하나요?</a>
									</p>
									<p class="a">카드 수수료 개편과 세액공제 한도 확대로 수수료 실질 부담액이 없거나 미미한
										수준으로 별도의 카드수수료 지원은 하지 않습니다. 지역과 업종 등 사용처를 제한한 지역화폐는 골목상권 중심으로
										소상공인의 실질적 매출향상을 견인하여 카드수수료 부담을 상회하는 소득향상 효과가 있을 것으로 예상됩니다.</p>
								</li>
								<li class="article" id="sp2">
									<p class="q">
										<a href="#sp2">지역화폐 구입 시 어떤 혜택이 있나요?</a>
									</p>
									<p class="a">구입 시 최대 6% 할인 혜택과 소득공제 30%를 적용받을 수 있으며, 시 군
										실정에 따라 이벤트・명절 기간 등에 한시적으로 할인율을 상향(최대 10%)적용합니다.</p>
								</li>
								<li class="article" id="sp3">
									<p class="q">
										<a href="#sp3">정책발행 대상자 확인은 어디서 할 수 있나요?</a>
									</p>
									<p class="a">해당 시 군 홈페이지에서 시행하는 정책을 확인하실 수 있으며,경기도 같은 경우
										잡아바에서도 확인이 가능합니다.</p>
								</li>
								<li class="article" id="sp4">
									<p class="q">
										<a href="#sp4">지역화폐 신청대상은?</a>
									</p>
									<p class="a">일반발행의 경우 누구나 신청 가능하며, 정책발행의 경우 대상자에 한해 신청할 수
										있습니다.</p>
								</li>
								<li class="article" id="sp5">
									<p class="q">
										<a href="#sp5">지역화폐 사용이 가능한 곳은 어떻게 확인하나요?</a>
									</p>
									<p class="a">지역화폐 가맹점 스티커 부착 여부를 확인하시거나, 전통시장 검색에서 검색하시면 알
										수 있습니다.(단, 사용가능한 가맹점 유형은 시군마다 차이가 있을 수 있음)</p>
								</li>
								<li class="article" id="sp6">
									<p class="q">
										<a href="#sp6">채팅창은 어떤 용도인가요?</a>
									</p>
									<p class="a">저희 사이트를 사용하고 계신 분들께서 서로 소통할 수 있는 창이라고 생각하시면
										되십니다.</p>
								</li>
								<li class="article" id="sp7">
									<p class="q">
										<a href="#sp7">쪽지기능은 어떻게 사용하나요?</a>
									</p>
									<p class="a">리뷰나 중고장터에서 글을 보고 정보를 얻고싶을 때 작성자 옆의 쪽지 버튼을 통해
										보낼 수 있으며, 상단의 쪽지함을 통해 확인이 가능합니다.</p>
								</li>
								<li class="article" id="sp8">
									<p class="q">
										<a href="#sp8">중고장터는 무엇인가요?</a>
									</p>
									<p class="a">중고장터는 중고로 물건을 사고팔 수 있는 곳이며, 100%로 회원제로 사기와 같은
										불법행위를 막기 위해 회원 등급제를 시행하고 있습니다.</p>
								</li>
								<li class="article" id="sp9">
									<p class="q">
										<a href="#sp9">이 사이트를 만든 취지가 무엇인가요?</a>
									</p>
									<p class="a">각 지역 경제 살리기와 코로나 19 긴급 재난 지원금을 사용하는 모든 국민들에게
										정보를 공유하기 위해서입니다.</p>
								</li>
								<li class="article" id="sp10">
									<p class="q">
										<a href="#sp10">지역화폐란?</a>
									</p>
									<p class="a">지역경제 활성화를 위해 지방자치단체 주관으로 시,군,구별로 발행하고 지역 내에서
										사용하는 대안화폐입니다. 일반발행과 정책발행 두 가지고 종류로 발행되며, 시·군에 따라 종이, 카드, 모바일
										형태로 선택하여 구매하실 수 있습니다.</p>
								</li>
							</ul>
						</div>
					</form>
				</div>

			</div>
			<div class="call">
				<!-- 고객센터 전화번호 -->
				<img
					src="<%=request.getContextPath()%>/resources/img/support/call_icon.png"
					alt="">
				<div class="cal_text">
					<p>전화 상담 가능한 시간</p>
					<p>평일 : 09:00 ~ 12:00 / 13:00 ~ 18:00</p>
					<p>Tell : 070 - 0000 - 0000</p>
					<p>Fax : 070 - 0000 - 0001</p>
					<p>Email: smwsemi@gmail.com</p>
				</div>
			</div>
		</section>
		</main>

		<!-- footer 시작 -->
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		<!-- footer 끝 -->
	</div>

	<!-- JavaScript -->
	<!-- 전체적으로 손 본 후에 수정할 예정입니다 건들지 말아주세요~,~   -->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/jquery-3.4.1.js"></script>
	<script type="text/javascript">
		jQuery(function($) {
			var article = $('.support_box>.supportBody>.article');
			var artClick = $('.support_box>.supportBody>.article>.q>a');
			/* var artAll = $() */

			article.addClass('hide');
			article.find('a').show();
			article.eq(0).removeClass('hide');
			article.eq(0).find('a').show();

			$(artClick).click(function() {
				var myArticle = $(this).parents('.article:first');
				if (myArticle.hasClass('hide')) {
					article.addClass('hide').removeClass('show');
					article.find('.a').slideUp(100);
					article.removeClass('hide').addClass('show');
					article.find('.a').slideDown(100);
				} else {
					myArticle.removeClass('show').addClass('hide');
					myArticle.find('.a').slideUp(100);
				}
				return false;
			});

		});
	</script>

</body>
</html>