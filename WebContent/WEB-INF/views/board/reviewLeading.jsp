<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="dao" class="com.market.board.model.dao.BoardDao" />
<c:set var="views" value="${dao.increaseViews(param.reviewNo)}" />
<!-- 조회수 증가시켜주는 태그 -->
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>leading</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
</head>
<body>
	<div class="Wrapper">
		<div class="wrapSub">
			<!-- top -->
			<%@ include file="/WEB-INF/views/include/nav.jsp"%>
			<%@ include file="/WEB-INF/views/include/header.jsp"%>
		</div>
		<!---------------------------------------------->

		<!-- 메인 -->
		<section class="readingPg">
			<div class="rdView">
				<!-- 목록위 -->
				<div class="rdView_title">${data.review.reviewTitle}</div>
				<div class="author">
					<div class="writer">작성자 | ${data.review.reviewWriter}</div>
					<div class="boardname">
						<a href="<%=request.getContextPath()%>/board/review.do">리뷰</a>
					</div>
					<div class="writerDate">${data.review.reviewDate }</div>
					<div class="writerCount">조회수 | ${data.review.reviewViewed }</div>
				</div>
				<div class="board_text">
					<p>${data.review.reviewContent}</p>
				</div>
				<c:if test="${loginInfo.nickname == data.review.reviewWriter }">

					<!-- 게시글 수정 기능 -->
					<form action="<%=request.getContextPath()%>/board/reviewdelete.do">
						<input id="deleteReview" type="hidden" name="deleteReview"
							value="${param.reviewNo }" />
						<button onclick="location.href='/smwMarket/board/editreview.do'">게시글수정</button>
					</form>

					<!-- 게시글 삭제 기능 -->
					<form action="<%=request.getContextPath()%>/board/reviewdelete.do"
						method="post">
						<input id="deleteReview" type="hidden" name="deleteReview"
							value="${param.reviewNo }" />
						<button onclick="deleteNotice()">게시글삭제</button>
					</form>
				</c:if>
			</div>

			<div class="comment">
				<!-- 댓글 작성부분 옆에 아이디 값이 보여져야합니다. -->

				<c:if test="${sessionScope.loginInfo != null }">
					<!-- 로그인 시에만 댓글 작성창 출력 -->
					<form
						action="<%=request.getContextPath()%>/board/insertreviewcom.do"
						method="post">
						<div id="commentAll">
							<div class="users">
								<img
									src="<%=request.getContextPath()%>/resources/img/user_icon.png"
									alt=""> <span>${loginInfo.nickname }</span>
							</div>
							<input type="hidden" name="review_no"
								value="${data.review.reviewNo }"> <input type="hidden"
								name="rvcom_writer" value="${loginInfo.nickname }">
							<!-- 댓글을 저장할 시 게시물 번호와 작성자가 저장되어야 하므로 hidden으로 처리 함 -->
							<div class="rvcom">
								<span>${rvcom.rc_writer}</span> <input id="rvcom_content"
									type="text" name="rvcom_content">
								<button type="submit">댓글등록</button>
							</div>
						</div>
					</form>
				</c:if>

				<form
					action="<%=request.getContextPath()%>/board/selectreviewcom.do"
					method="post">
					<div class="commentPg">
						<!-- 작성된 댓글이 보여지는 단이 될 예정입니다. -->
						<table>
							<colgroup>
								<col width="60px">
								<col width="180px">
								<col width="50px">
							</colgroup>
							<tr>
								<th>닉네임</th>
								<th>내용</th>
								<th>작성일</th>
							</tr>
							<c:forEach items="${data.rvcom }" var="board">
								<tr>
									<td id="RVwriter"><c:out value="${board.rc_writer }" /></td>
									<td id="RVcontent"><c:out value="${board.rc_content }" /></td>
									<td id="RVdate"><c:out value="${board.rc_date }" /></td>
								</tr>
							</c:forEach>
						</table>

					</div>

					<div class="commentList">
						<ul>
							<li><a><</a></li>
							<li><a>1</a></li>
							<li><a>2</a></li>
							<li><a>3</a></li>
							<li><a>></a></li>
						</ul>
					</div>
				</form>

				<!-- <div class="listTab">
					<a href="#"> <span class="boardList">위쪽 리스트 입니다.</span>
					</a> <a href="#"> <span class="boardList">아래쪽 리스트 입니다.</span>
					</a>
				</div> -->
				<input type="button" value="목록" onclick="history.back(-1);">
			</div>
		</section>

		<!---------------------------------------------->
		<!-- footer -->
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	</div>
	<script>
		function deleteNotice() {
			var really = confirm("게시물을 삭제 하시겠습니까?");
			if (really == true) {
				location.href = '/smwMarket/board/reviewdelete.do';
				reviewNo.submit();
			}
		}
	</script>

</body>
</html>