<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전통시장 검색 게시판</title>
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


		<!-- seciton -->
		<main>
		<section id="searchMap">
			<div class="container">
				<div class="row">
					<article class="">
						<div class="mapPg">
							<div class="searchSub1">
								<div class="search_img" id="map" alt=""></div>
								<!-- api를 통한 지도 맵 활용 할 곳 -->

								<!-- 검색어를 입력한 뒤 submit을 누르면 form태그에 매핑된 메서드로 이동한다. -->
								<form action="<%=request.getContextPath()%>/board/marketinfo.do"
									method="post">
									<div class="searchbar">
										<select name="searchType">
											<!-- 검색조건 추가 -->
											<option value="NAME_BRAND" selected="selected">상호명</option>
											<option value="ADDRESS_NUMBER">지역</option>
											<option value="NAME_BUSINESS">업종</option>
										</select> <input type="search" placeholder="검색어 입력" name="srBar">
										<button type="submit">검색</button>
									</div>
								</form>
							</div>
						</div>
					</article>
				</div>
			</div>
		</section>
		<table border="1" style="text-align:center;">
		<thead>
		<tr>
		<td>도시
		<td>상호명
		<td>업종명
		<td>도로명주소
		<td>지번주소
		<td>전화번호
		<td>우편번호
		<td>지도에서보기
		</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${data.search }" var="search" varStatus="vs">
		<tr>
		<td>${search.nameCity }
		<td>${search.nameBrand }
		<td>${search.nameBusiness }
		<td>${search.adresRoad }
		<td>${search.adresNum }
		<td>${search.tell }
		<td>${search.zipcode }
		<input type="hidden" class="index" value="${vs.index }">
								<input type="hidden" name="latitude" value="${search.latitude }">
								<input type="hidden" name="longitude"
									value="${search.longitude }">
								<td><input type="button" id="button_${vs.index }"
									name="button_${vs.index }" value="지도에서 보기" /></td>
		</c:forEach>
		</tbody>
		
		</table>
		</main>

		<!-- footer -->
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.0.js"
		integrity="sha256-r/AaFHrszJtwpe+tHyNi/XCfMxYpbsRg2Uqn0x3s2zc="
		crossorigin="anonymous"></script>
	<script type="text/javascript"
		src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=14nvpqoexz"></script>

	<script type="text/javascript">
		var HOME_PATH = window.HOME_PATH || '.';

		var latitude = $('latitude').val();
		var longitude = $('longitude').val();

		var kh = new naver.maps.LatLng(37.4989458, 127.0328584), map = new naver.maps.Map(
				'map', {
					center : kh.destinationPoint(0, 50),
					zoom : 18
				}), marker = new naver.maps.Marker({
			map : map,
			position : kh
		});

		var contentString = [
				'<div class="iw_inner">',
				'   <h3>KH정보교육원</h3>',
				'   <p>서울특별시 강남구 강남구 테헤란로14길 6 | 서울특별시 강남구 강남구 테헤란로14길 6<br />',
				'       <img src="../resources/img/sample.png" width="55" height="55" alt="KH정보교육원" class="thumb" /><br />',
				'       1544-9970 | 공공,사회기관 &gt; 교육,교육기관<br />',
				'       <a href="https://www.iei.or.kr" target="_blank">https://www.iei.or.kr</a>',
				'   </p>', '</div>' ].join('');

		var infowindow = new naver.maps.InfoWindow({
			content : contentString
		});

		$("input[name^='button']").on(
				'click',
				function(e) {
					var lati = $("input[name=latitude]").length;
					var logi = $("input[name=longitude]").length;

					var latiArr = new Array(lati);
					var logiArr = new Array(logi);

					for (var i = 0; i < lati; i++) {
						latiArr[i] = $("input[name=latitude]").eq(i).val();
					}

					for (var i = 0; i < logi; i++) {
						logiArr[i] = $("input[name=longitude]").eq(i).val();
					}

					var string = event.target.name;
					var index = string.substring(7);

					var kh = new naver.maps.LatLng(latiArr[index],
							logiArr[index]), map = new naver.maps.Map('map', {
						center : kh.destinationPoint(0, 0),
						zoom : 18
					}), marker = new naver.maps.Marker({
						map : map,
						position : kh
					});

				});

		infowindow.open(map, marker);
	</script>
</body>
</html>