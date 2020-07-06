<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="dao" class="com.market.board.model.dao.BoardDao" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이용 후기 게시판</title>
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
		<section id="reviewSet">
			<div class="container">
				<div class="row">
					<article class="rvSet">
						<div class="container">
							<h1>이용 후기 게시판입니다.</h1>
							<div class="sub_review">
								<!-- 이용후기 게시판 시작 -->
								<table class="reviewList" border="1" cellspacing="0" summary="리뷰 글 제목 리스트">
									<caption>게시판 리스트</caption>
									<colgroup>
										<!-- 넓이 지정  -->
										<col width="110">
										<col>
										<col width="110">
										<col width="100">
										<col width="80">
									</colgroup>
									<thead>
										<tr>
											<th scope="col">No</th>
											<th scope="col">제목</th>
											<th scope="col">글쓴이</th>
											<th scope="col">날짜</th>
											<th scope="col">조회수</th>
										</tr>
									</thead>
									<tbody>
										<!-- 작성일을 받아주어야 합니다. -->
										<c:forEach items="${data.bData }" var="board">
											<c:if test="${board.isDelete == 'N' }">
												<tr class="reply">
													<td class="No">${board.reviewNo }</td>
													<td class="title"><c:choose>
															<c:when
																test="${'0' eq board.isPublished && sessionScope.loginInfo == null}">
										해당 게시물은 회원 공개로 설정되어 있습니다. 회원가입 후 열람하실 수 있습니다.
								   </c:when>
															<c:otherwise>
																<a
																	href="/smwMarket/board/reviewdetail.do?reviewNo=${board.reviewNo }">
																	${board.reviewTitle }</a>
															</c:otherwise>
														</c:choose></td>

													<td class="nickName">${board.reviewWriter }</td>
													<td class="date">${board.reviewDate }</td>
													<td class="viewNo">${board.reviewViewed }</td>
												</tr>
											</c:if>
										</c:forEach>
									</tbody>
								</table>
								<!-- 리스트 게시판 끝  -->

								<!-- 게시판 리스트 번호 돌아가게 해줘야함  -->
								<div class="subList">
									<ul>
										<!-- 게시판 리스트 읽을때 보여지는 페이지 leading.jsp임 -->
										<!-- 받아줄 때 저 페이지로 받을 수 있도록 해야합니다. -->

										<!-- 전체 검색 데이터의 갯수 -->
										<li><a href="/smwMarket/board/review.do"
											class="nav first"><img
												src="<%=request.getContextPath()%>/resources/img/left_icon.png"
												alt="left"></a></li>
										<li><a
											href="/smwMarket/board/review.do?cPage=${data.paging.blockStart - 1}"
											class="nav prev"></a></li>

										<c:forEach begin="${data.paging.blockStart }"
											end="${data.paging.blockEnd }" var="page">

											<a href="/smwMarket/board/review.do?cPage=${page}"
												class="num active"><li>${page}</li></a>
										</c:forEach>

										<li><a
											href="/smwMarket/board/review.do?cPage=${data.paging.blockEnd + 1}"
											class="nav next"> <img
												src="<%=request.getContextPath()%>/resources/img/right_icon.png"
												alt="right"></a></li>
										<li><a
											href="/smwMarket/board/review.do?cPage=${data.paging.lastPage}"
											class="nav last"></a></li>
									</ul>
								</div>
								<!-- 
				글을 쓰기 위해 사용자가 버튼을 누르면 글쓰는 페이지로 연동되어야하며, 글쓰기 페이지에 사용되는 jsp는 게시판 글쓰기에 동일하게 사용될 예정
				 -->
								<!-- 5/6 로그인을 했을 때만 글쓰기 버튼이 사용 가능하다. -->
								<c:if test="${sessionScope.loginInfo != null }">
									<button class="write">
										<a href="<%=request.getContextPath()%>/board/reviewWriter.do">글쓰기</a>
									</button>
								</c:if>


								<!-- 검색 창 -->
								<div class="searchList">
									<form action="review.jsp" name="searchReview" method="post">
										<select name="searchType">
											<option value="review_title" selected="selected">제목</option>
											<option value="review_content">글내용</option>
											<option value="review_writer">닉네임</option>
										</select> <input id="searchText" type="text" name="searchWord" /> <input
											id="searchBt" type="button" value="검색하기" id="btnSearch" />
									</form>
								</div>
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
	<script>
		window.onload = function() {
			document.getElementById("btnSearch").onclick = function() {
				if (searchReview.reviewSearched.value == "") {
					searchReview.reviewSearched.focus();
					alert("검색어를 입력하세요");
					return;
				}
				searchReview.submit();
			}
		}
	</script>
</body>
</html>