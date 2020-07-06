<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="dao" class="com.market.board.model.dao.BoardDao" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Market</title>
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

		<main> <!-- section -->
		<section id="marketSet">
			<article class="mkSet">
				<div class="container">
					<div class="mkList">
						<h1>중고장터 게시판입니다.</h1>
						<div class="marketList">
							<c:forEach items="${data.bData }" var="board" >
								<a href="/smwMarket/board/useddetail.do?usedNo=${board.usedNo }">
									<ul>
										<li><img class="sub_img"
											src="<%=request.getContextPath()%>/resources/upload/${board.used_refile}"
											alt=""></li>
										<li>판매물품 ${board.usedTitle }</li>
										<li>판매금액 ${board.sellPrice }</li>
										<li>글쓴이 ${board.usedWriter }</li>
										<li>조회수 ${board.usedViewed }</li>
									</ul>
								</a>
							</c:forEach>
						</div>

						<!-- 게시판 리스트 번호 돌아가게 해줘야함  -->
						<div class="subList">
							<ul>
								<!-- 게시판 리스트 읽을때 보여지는 페이지 leading.jsp임 -->
								<!-- 받아줄 때 저 페이지로 받을 수 있도록 해야합니다. -->

								<!-- 전체 검색 데이터의 갯수 -->
								<li><a href="/smwMarket/board/usedmarket.do"
									class="nav first"><img
										src="<%=request.getContextPath()%>/resources/img/left_icon.png"
										alt="left"></a></li>
								<li><a
									href="/smwMarket/board/usedmarket.do?cPage=${data.paging.blockStart - 1}"
									class="nav prev"></a></li>

								<c:forEach begin="${data.paging.blockStart }"
									end="${data.paging.blockEnd }" var="page">

									<a href="/smwMarket/board/usedmarket.do?cPage=${page}"
										class="num active"><li>${page}</li></a>
								</c:forEach>

								<li><a
									href="/smwMarket/board/usedmarket.do?cPage=${data.paging.blockEnd + 1}"
									class="nav next"> <img
										src="<%=request.getContextPath()%>/resources/img/right_icon.png"
										alt="right"></a></li>
								<li><a
									href="/smwMarket/board/usedmarket.do?cPage=${data.paging.lastPage}"
									class="nav last"></a></li>
							</ul>
						</div>

						<!-- 5/6 로그인을 했을 때만 글쓰기 버튼이 사용 가능하다. -->
						<!-- 5/6 승현님 uri맞는지 확인 부탁드려요 -->

						<c:if test="${sessionScope.loginInfo != null }">
							<button class="write">
								<a href="<%=request.getContextPath()%>/board/usedWriter.do">글쓰기</a>
							</button>
						</c:if>

						<!-- 검색 창 -->
						<div class="searchList">
							<select>
								<option value="title">제목</option>
								<option value="subContents">글내용</option>
								<option value="nickName">닉네임</option>
							</select> <input type="search">
							<button type="submit">검색하기</button>
						</div>
					</div>
				</div>
			</article>
		</section>
		</main>

		<!-- footer 시작 -->
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		<!-- footer 끝 -->
	</div>

	<!-- JavaScript -->
</body>
</html>