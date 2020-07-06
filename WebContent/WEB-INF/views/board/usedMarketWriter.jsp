<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="dao" class="com.market.board.model.dao.BoardDao" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
</head>
<body>
	<div class="Wrapper">
		<div class="wrapSub">
			<!-- top -->
			<%@ include file="/WEB-INF/views/include/nav.jsp"%>
			<%@ include file="/WEB-INF/views/include/header.jsp"%>

			<!---------------------------------------------->
		</div>
		<!-- 메인 -->
		<section id="writerPg">
			<div>	`<</div>	
			<h2>중고장터 글쓰기</h2>
			<form action="<%=request.getContextPath()%>/board/usedupload.do"
				method="post" enctype="multipart/form-data">
				<div class="writerText">
					<table>
						<tr>
							<th>판매물품</th>
							<td><input type="text" name="usedTitle" id="usedTitle"></td>
						</tr>
						<tr>
							<th>판매가격</th>
							<td><input type="text" name="usedPrice" id="usedPrice"></td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td><input type="file" name="usedFile" id="usedFile">사진</td>
						</tr>
						<tr>
							<th>내용</th>
							<td><input type="text" name="usedContent" id="usedContent"></td>
						</tr>
						<tr>
							<th>공개설정</th>
							<td>
								<ul id="check">
									<li>전체공개<input type="radio" name="setting"></li>
									<li>회원공개<input type="radio" name="0" value="0"></li>
								</ul>
							</td>

						</tr>
					</table>
				</div>
				<button id="save" type="submit">등록하기</button>
			</form>
		</section>


		<!---------------------------------------------->
		<!-- footer -->
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	</div>
</body>
</html>