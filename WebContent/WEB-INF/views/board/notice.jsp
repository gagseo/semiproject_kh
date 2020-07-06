<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항</title>
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
		<section id="noticeSet">
			<div class="container">
				<div class="row">
					<article class="notiSet">
						<div class="container">
							<h1>공지사항 게시판입니다.</h1>
							<div class="notiList">
								<!-- 리스트 게시판 시작 -->
								<table class="sub_noti" border="1" cellspacing="0"
									summary="공지사항 글 제목 리스트">
									<caption>게시판 리스트</caption>
									<colgroup>
										<!-- 넓이 지정  -->
										<col width="50">
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
										<tr class="reply">
											<td class="No"><a href="#">1</a></td>
											<td class="title"><a href="#">지역화폐사용처에 대한 공지사항1</a></td>
											<td class="commonUser">관리자</td>
											<td class="date">작성일</td>
											<td class="viewNo">조회된 수</td>
										</tr>
										<tr class="reply">
											<td class="No"><a href="#">2</a></td>
											<td class="title" style="padding-left: 30px;"><a
												href="#">지역화폐사용처에 대한 공지사항2</a></td>
											<td class="commonUser">관리자</td>
											<td class="date">작성일</td>
											<td class="viewNo">조회된 수</td>
										</tr>
										<tr class="reply">
											<td class="No"><a href="#">3</a></td>
											<td class="title" style="padding-left: 30px;"><a
												href="#">지역화폐사용처에 대한 공지사항3</a></td>
											<td class="commonUser">관리자</td>
											<td class="date">작성일</td>
											<td class="viewNo">조회된 수</td>
										</tr>
										<tr class="reply">
											<td class="No"><a href="#">4</a></td>
											<td class="title" style="padding-left: 30px;"><a
												href="#">지역화폐사용처에 대한 공지사항4</a></td>
											<td class="commonUser">관리자</td>
											<td class="date">작성일</td>
											<td class="viewNo">조회된 수</td>
										</tr>
										<tr class="reply">
											<td class="No"><a href="#">5</a></td>
											<td class="title" style="padding-left: 30px;"><a
												href="#">지역화폐사용처에 대한 공지사항5</a></td>
											<td class="commonUser">관리자</td>
											<td class="date">작성일</td>
											<td class="viewNo">조회된 수</td>
										</tr>
										<tr class="reply">
											<td class="No"><a href="#">6</a></td>
											<td class="title" style="padding-left: 30px;"><a
												href="#">지역화폐사용처에 대한 공지사항6</a></td>
											<td class="commonUser">관리자</td>
											<td class="date">작성일</td>
											<td class="viewNo">조회된 수</td>
										</tr>
										<tr class="reply">
											<td class="No"><a href="#">7</a></td>
											<td class="title" style="padding-left: 30px;"><a
												href="#">지역화폐사용처에 대한 공지사항7</a></td>
											<td class="commonUser">관리자</td>
											<td class="date">작성일</td>
											<td class="viewNo">조회된 수</td>
										</tr>
										<tr class="reply">
											<td class="No"><a href="#">8</a></td>
											<td class="title" style="padding-left: 30px;"><a
												href="#">지역화폐사용처에 대한 공지사항8</a></td>
											<td class="commonUser">관리자</td>
											<td class="date">작성일</td>
											<td class="viewNo">조회된 수</td>
										</tr>
										<tr class="reply">
											<td class="No"><a href="#">9</a></td>
											<td class="title" style="padding-left: 30px;"><a
												href="#">지역화폐사용처에 대한 공지사항9</a></td>
											<td class="commonUser">관리자</td>
											<td class="date">작성일</td>
											<td class="viewNo">조회된 수</td>
										</tr>
									</tbody>
								</table>
								<!-- 리스트 게시판 끝  -->
								<div class="searchList">
									<select>
										<option value="title">제목</option>
										<option value="subContents">글내용</option>
										<option value="nickName">닉네임</option>
									</select> <input type="search">
									<button id="btn1" type="submit">검색하기</button>

								</div>

								<!-- 게시판 리스트 번호 돌아가게 해줘야함  -->
								<div class="subList">
									<ul>
										<li><a href="#"><</a></li>
										<li><a href="#">1</a></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">4</a></li>
										<li><a href="#">5</a></li>
										<li><a href="#">></a></li>
									</ul>
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
</body>
</html>