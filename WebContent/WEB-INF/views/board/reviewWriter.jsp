<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Writer</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
</head>
<body>
	<div class="Wrapper">
		<div class="wrapSub">
			<!-- top -->
			<%-- <%@ include file="/WEB-INF/views/include/top.jsp"%> --%>
			<%@ include file="/WEB-INF/views/include/header.jsp"%>

			<!---------------------------------------------->
		</div>
		<!-- 메인 -->
		<section class="writerPg">
			<h2>글쓰기</h2>
			<form action="<%=request.getContextPath()%>/board/reviewupload.do"
				method="post" enctype="multipart/form-data">
				<div class="writerTB">
					<table border="1">
						<tr>
							<th>제목</th>
							<td><input id="reviewTitle" type="text" name="reviewTitle"></td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td><input type="file" name="reviewFile"></td>
						</tr>
						<tr>
							<th>공개설정</th>
							<td>
								<ul>
									<li>전체공개<input id="check" type="radio"></li>
									<li>회원공개<input id="check" type="radio" name="0" value="0"></li>
								</ul>
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td><input id="reviewContent" type="text"
								name="reviewContent"></td>
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