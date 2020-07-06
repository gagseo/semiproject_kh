<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- header 시작 -->
<header id="header">
	<div class="container">
		<div class="row">
			<div class="header">
				<div class="header_menu">
					<c:if test="${sessionScope.loginInfo == null }">
						<!-- 접속위치 이곳에 쓰여짐 -->
						<a class="locationName"></a>
						<!-- 기온 이곳에 쓰여짐 -->
						<a class="temp"></a>
						<!-- 시간 이곳에 쓰여짐 -->
						<a class="clock"></a>
						<a href="<%=request.getContextPath()%>/member/memberjoin.do">회원가입</a>
						<a href="<%=request.getContextPath()%>/member/memberlogin.do">로그인</a>
					</c:if>
					<c:if test="${sessionScope.loginInfo != null }">
						!-- 접속위치 이곳에 쓰여짐 -->
						<a class="locationName"></a>
						<!-- 기온 이곳에 쓰여짐 -->
						<a class="temp"></a>
						<!-- 시간 이곳에 쓰여짐 -->
						<a class="clock"></a>
						<a>${sessionScope.loginInfo.user_name}님환영합니다.</a>
						<a href="<%=request.getContextPath()%>/note/notebox.do"
					onclick="window.open(this.href,'쪽지함'); return false;">쪽지함</a>
						<a href="<%=request.getContextPath()%>/member/mypagepw.do">마이페이지</a>
						<a href="<%=request.getContextPath()%>/member/logout.do" onclick="return confirmLogout()">로그아웃</a>
					</c:if>
				</div>
				
				<div class="header_title">
					<a href="<%=request.getContextPath()%>/index/index.do"><img src="<%=request.getContextPath()%>/resources/img/common/logo.png" /></a>
					<h1>"지역경제 활성화를 위해 사용하는 지역화폐 커뮤니티 "</h1>
				</div>
			</div>
		</div>
	</div>
</header>	
<!-- header 끝 -->

<!-- JavaScript -->
<script type="text/javascript">
	//시간 출력
	const clockContainer = document.querySelector(".clock");

	function getTime() {
		const date = new Date();
		const minutes = date.getMinutes();
		const hours = date.getHours();
		const seconds = date.getSeconds();
		if (minutes < 10) {
			clockContainer.innerText = "현재시간 : " + hours + ":" + "0" + minutes
					+ ":" + seconds;
		} else if (seconds < 10) {
			clockContainer.innerText = "현재시간 : " + hours + ":" + minutes + ":"
					+ "0" + seconds;
		} else if (minutes < 10 && seconds < 10) {
			clockContainer.innerText = "현재시간 : " + hours + ":" + "0" + minutes
					+ ":" + "0" + seconds;
		} else {
			clockContainer.innerText = "현재시간 : " + hours + ":" + minutes + ":"
					+ seconds;
		}
	}

	// 날씨 및 장소 출력
	var weather = document.querySelector(".temp");
	var locationName = document.querySelector(".locationName");

	const API_KEY = "1c24c214c87331e2d54b81b03a6d505f";
	const COORDS = "coords";

	function getWeather(lat, lng) {
		//맨 뒤에 metric 을 사용함으로써 화씨를 섭씨로 받아올 수 있다. API 확인
		//https://openweathermap.org/current
		const url = "https://api.openweathermap.org/data/2.5/weather?lat="
				+ lat + "&lon=" + lng + "&appid=" + API_KEY + "&units=metric";
		fetch(url).then(function(response) {
			return response.json();
		}).then(function(json) {
			const temperature = json.main.temp.toFixed(1);
			const place = json.name;
			weather.innerText = "현재기온 : " + temperature;
			locationName.innerText = "접속위치 : " + place;
		});
	}

	function saveCoords(coordsObj) {
		localStorage.setItem(COORDS, JSON.stringify(coordsObj));
	}

	function handleGeoSuccess(position) {
		const latitude = position.coords.latitude;
		const longitude = position.coords.longitude;
		const coordsObj = {
			latitude : latitude,
			longitude : longitude
		}
		saveCoords(coordsObj);
		getWeather(latitude, longitude);

	}

	function handleGeoError() {
		console.log("못얻어옴");
	}

	function askForCoords() {
		navigator.geolocation.getCurrentPosition(handleGeoSuccess,
				handleGeoError);
	}

	function loadCoords() {
		const loadedCoords = localStorage.getItem(COORDS);
		if (loadedCoords === null) {
			askForCoords();
		} else {
			//날씨를 알아냄
			const parseCoords = JSON.parse(loadedCoords);
			getWeather(parseCoords.latitude, parseCoords.longitude);
		}
	}

	function init() {
		getTime();
		setInterval(getTime, 1000);
		loadCoords();
	}

	init();

	// Onclick Event List

	function confirmLogout() {
		return confirm("로그아웃 하시겠습니까?");
	}
</script>
