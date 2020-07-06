<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="dao" class="com.market.board.model.dao.BoardDao" />
<c:set var="views" value="${dao.increaseUsed(param.usedNo)}" />
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
					<div class="rdView_title">${data.used.usedTitle}</div>
					<div class="author">
						<div class="writer">작성자 | ${data.used.usedWriter}</div>
						<div class="price">판매가 | ${data.used.sellPrice}</div>
						<input type="hidden" name="usedNo" value="${data.used.usedNo }">
						<div class="boardname">
							<a href="<%=request.getContextPath()%>/board/used.do">중고장터</a>
						</div>
						<div class="writerDate">${data.used.usedDate }</div>
						<div class="writerCount">조회수 | ${data.used.usedViewed }</div>
					</div>
					<div class="board_text">
						<p>${data.used.usedContent}</p>
					</div>
				</div>
			
			<div class="">
				<c:if test="${sessionScope.loginInfo != null }">
					<!-- 로그인 시에만 댓글 작성창 출력 -->
					<form action="<%=request.getContextPath()%>/board/insertusedcom.do"
						method="post">
						<div id="commentAll">
							<div class="users">
								<img
									src="<%=request.getContextPath()%>/resources/img/user_icon.png"
									alt=""> <span>${loginInfo.nickname }</span>
							</div>
							<input type="hidden" name="usedNo" value="${data.used.usedNo }">
							<input type="hidden" name="udcom_writer"
								value="${loginInfo.nickname }">
							<!-- 댓글을 저장할 시 게시물 번호와 작성자가 저장되어야 하므로 hidden으로 처리 함 -->
							<div class="udcom">
								<span>${udcom.ud_writer}</span> <input id="udcom_content"
									type="text" name="udcom_content">
								<button type="submit">댓글등록</button>
							</div>
						</div>
					</form>
				</c:if>

			</div>
			<form action="<%=request.getContextPath()%>/board/selectusedcom.do"
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
						<c:forEach items="${data.udcom }" var="board">
							<tr>
								<td id="RVwriter"><c:out value="${board.uc_writer }" /></td>
								<td id="RVcontent"><c:out value="${board.uc_content }" /></td>
								<td id="RVdate"><c:out value="${board.uc_date }" /></td>
							</tr>
						</c:forEach>
					</table>

				</div>

			</form>
			<input type="button" value="목록" onclick="history.back(-1);">

		</section>

		<!---------------------------------------------->
		<!-- footer -->
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	</div>

</body>
</html>